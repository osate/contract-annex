/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and
 * unlimited distribution.  Please see Copyright notice for non-US Government use and
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
package org.osate.contract.execution;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import org.eclipse.ease.service.EngineDescription;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAnd;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ArgumentNot;
import org.osate.contract.contract.ArgumentOr;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.ContractSubclause;
import org.osate.contract.contract.InputAssumption;
import org.osate.contract.contract.Language;
import org.osate.contract.contract.PathSourceImpl;
import org.osate.contract.contract.VerificationPlan;

public class ContractProcessor {

	// Dio: just to add the feedback from assert_and_track()
	protected boolean analysisExplanations = true;

	private int assertIndex = 0;

	protected PythonBuilder pyBuilder;

	protected ScriptRunner pyRunner;

	protected ComponentInstance context;

	protected Set<Contract> addedContracts = new HashSet<>();

	List<Contract> deferredContracts = new ArrayList<>();

	List<Argument> deferredArguments = new ArrayList<>();

	static final Object DONE = new Object();

	private List<String> error = new ArrayList<>();

	private List<String> info = new ArrayList<>();

	private final Iterable<VerificationPlan> plans;

	protected HashMap<Object, Object> parentContract = new HashMap<Object, Object>();

	public String getName(Object c) {
		if (c instanceof Contract) {
			return ((Contract) c).getName();
		} else if (c instanceof VerificationPlan) {
			return ((VerificationPlan) c).getName();
		} else if (c instanceof Argument) {
			return ((Argument) c).getName();
		}

		return "";
	}

	public String getArgumentPath(Object contract) {
		String path = "";
		Stack<String> pathSegments = new Stack<String>();

		Object parent = parentContract.get(contract);
		while (parent != null) {
			pathSegments.push(getName(parent));
			parent = parentContract.get(parent);
		}

		while (!pathSegments.isEmpty()) {
			String s = pathSegments.pop();
			if (s.length()>0) {
				if (path.length()>0) {
					path = path + "." + s;
				} else {
					path = path + s;
				}
			}
		}

		if (path.length() > 0) {
			path = path + "." + getName(contract);
		} else {
			path = getName(contract);
		}

		return path;
	}

	public ContractProcessor(ComponentInstance context, Iterable<VerificationPlan> plans,
			EngineDescription description) {
		this.context = context;
		this.plans = plans;
		error.add("");
		info.add("");
		pyBuilder = newPythonBuilder(context);
		pyRunner = new ScriptRunner(description, error, info);
	}

	private PythonBuilder newPythonBuilder(ComponentInstance context) {
		return new PythonBuilder(context, error, info);
	}

	public void smtVerificationPlan(VerificationPlan plan, boolean checkCompleteness) {
		ContractLibrary library = EcoreUtil2.getContainerOfType(plan, ContractLibrary.class);
		pyBuilder.addZ3Import().addImplementations(library);
		for (var domain : plan.getDomains()) {
			pyBuilder.addDomain(domain);
		}

		assertIndex = 0;

		if (analysisExplanations) {
			pyBuilder.addCode("""

					def execute%s():
					    s = Solver()
					""".formatted(plan.getName()));
			pyBuilder.indent();

		} else {
			pyBuilder.addCode("""

					def execute%s():
					    s = Solver()
					""".formatted(plan.getName()));
			pyBuilder.indent();
		}
		for (var contract : plan.getContracts()) {
			parentContract.put(contract, plan);
			var expr = smtContract(contract);
			pyBuilder.addCode("# contract " + contract.getFullName());
			addCode(expr);
		}
		/**
		 * Dio: deferredArguments or deferredContracts can be added while processing
		 * previous arguments or contracts
		 */
		while (deferredArguments.size() > 0 || deferredContracts.size() > 0) {
			List<Argument> processedArguments = new ArrayList<Argument>();
			for (int i = 0; i < deferredArguments.size(); i++) {
				var a = deferredArguments.get(i);
				processedArguments.add(a);
				pyBuilder.addCode("# argument " + a.getFullName());
				var expr = smtArgument(a);
				addCode(expr);
			}
			for (Argument a : processedArguments) {
				deferredArguments.remove(a);
			}

			List<Contract> processedContracts = new ArrayList<Contract>();
			for (int i = 0; i < deferredContracts.size(); i++) {
				var c = deferredContracts.get(i);
				processedContracts.add(c);
				pyBuilder.addCode("# contract " + c.getFullName());
				var expr = smtContract(c);
				addCode(expr);
			}
			for (Contract c : processedContracts) {
				deferredContracts.remove(c);
			}
		}
		if (!plan.getClaims().isEmpty()) {
			pyBuilder.addCode("""
					s.add(
					""");
			if (checkCompleteness) {
				pyBuilder.indent().addCode("""
						Not(
						""");
			}
			pyBuilder.indent().addCode("""
					And(
					""").indent();
			for (var claim : plan.getClaims()) {
				pyBuilder.addCode(claim, ",");
			}
			pyBuilder.outdent().addCode("""
					)
					""");
			if (checkCompleteness) {
				pyBuilder.outdent().addCode("""
						)
						""");
			}
			pyBuilder.outdent().addCode("""
					)
					""");
		}
		if (checkCompleteness) {
			pyBuilder.addCode("""
					if s.check() == sat:
					    return \"False\"
					error0[0] += str(s.unsat_core())
					return \"True\"
					""");
		} else {
			pyBuilder.addCode("""
					if s.check() == sat:
					    return \"True\"
					error0[0] += str(s.unsat_core())
					return \"False\"
					""");
		}
		pyBuilder.outdent().addCode("""
				execute%s()
				""".formatted(plan.getName()));
	}

	void addCode(String expr) {
		if (!Strings.isEmpty(expr)) {
			if (analysisExplanations) {
				pyBuilder.addCode("""
						s.assert_and_track(And(
						""");
				pyBuilder.indent().addCode(expr);
				pyBuilder.outdent().addCode("),\"#" + Integer.toString(assertIndex++) + "#|\"+error0[0]");
				pyBuilder.addCode("""
						)
						""");
			} else {
				pyBuilder.addCode("""
						s.add(
						""");
				pyBuilder.indent().addCode(expr);
				pyBuilder.outdent().addCode("""
						)
						""");
			}
		}
	}

	public String smtContract(Contract contract) {
		if (!checkInputAssumptions(contract)) {
			return "";
		}
		List<CodeAssumption> deferredAssumptions = new ArrayList<>();
		ContractLibrary library = EcoreUtil2.getContainerOfType(contract, ContractLibrary.class);

		/**
		 * DIO: UNDER CONSTRUCTION
		 *
		 * Test the argument path construction
		 * This only works for tree-like arguments. In general they are networked so this should be
		 * extended.
		 */

		System.out.println("ARGUMENT PATH: " + getArgumentPath(contract));

		pyBuilder.addImplementations(library);
		for (var domain : contract.getDomains()) {
			pyBuilder.addDomain(domain);
		}
		var pyExpr = newPythonBuilder(context);
		if (contract.isExact()) {
			pyExpr.addCode("""
					If(
					    And(
					""").indent(2);
		} else {
			pyExpr.addCode("""
					Implies(
					    And(
					""").indent(2);
		}
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof CodeAssumption ca) {
				if (ca.getGuarantee() != null) {
					// add guarantee here and add assumption as separate item later
					// treat assumption like an unnamed trivial contract
					// pyExpr.addCode(ca.getGuarantee().getCode(), ",");
					pyExpr.addCode(new PathSourceImpl(ca.getGuarantee().getCode(), getArgumentPath(contract)), ",");
					deferredAssumptions.add(ca);
				} else {
					if (ca.getCode().getLanguage() == Language.SMT) {
						pyExpr.addCode(evalAssumption(ca) + ",");
					} else {
						// pyExpr.addCode(ca.getCode(), ",");
						pyExpr.addCode(new PathSourceImpl(ca.getCode(), getArgumentPath(contract)), ",");
					}
				}
			} else if (assumption instanceof ContractAssumption ca) {
				// add referenced contract's guarantee here and add referenced contract itself later
				Contract c = (Contract) ca.getContract();
				parentContract.put(c, contract);
				pyExpr.addCode(new PathSourceImpl(c.getGuarantee().getCode(), getArgumentPath(contract)), ",");
				deferredContracts.add(c);
			} else if (assumption instanceof ArgumentAssumption aa) {
				// add referenced contract's guarantee here and add referenced contract itself later
				Argument a = (Argument) aa.getArgument();
				parentContract.put(a, contract);
				pyExpr.addCode(new PathSourceImpl(a.getGuarantee().getCode(), getArgumentPath(contract)), ",");
				deferredArguments.add(a);
			}
		}
		for (var analysis : contract.getAnalyses()) {
			// pyExpr.addCode(analysis.getCode());
			pyExpr.addCode(new PathSourceImpl(analysis.getCode(), getArgumentPath(contract)));
		}
		pyExpr.outdent().addCode("""
				),
				""");
		var guarantee = contract.getGuarantee();
		if (contract.isExact()) {
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)), ",");
			pyExpr.addCode("""
					Not(
					""").indent();
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)));
			pyExpr.outdent(2).addCode("""
					    )
					),
					""");
		} else {
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)), "");
			pyExpr.outdent().addCode("""
					),
					""");
		}
		for (var a : deferredAssumptions) {
			// TODO: add argumentpath to smtassumption
			pyExpr.addCode(smtAssumption(a, contract));
		}
		pyBuilder.getVariables().putAll(pyExpr.getVariables());
		return pyExpr.getScript();
	};

	private boolean checkInputAssumptions(Contract contract) {
		var pb = newPythonBuilder(context);
		ContractLibrary library = EcoreUtil2.getContainerOfType(contract, ContractLibrary.class);
		pb.addImplementations(library);
		// reuse initial part of the script
		var common = pb.getScript();
		for (var ia : contract.getInputs()) {
			pb = newPythonBuilder(context);
			pb.addCode(common);
			if (!checkInputAssumption(pb, ia)) {
				return false;
			}
		}
		return true;
	};

	private boolean checkInputAssumption(PythonBuilder pb, InputAssumption ia) {
		pb.addCode(ia.getCode());
		var pyCode = pb.getScript();

		System.out.println("Checking input assumption:\n");// + pyCode);

		var result = pyRunner.run(pyCode, pb.getVariables());
		return result;
	}

	private String evalAssumption(CodeAssumption ca) {
		var pb = newPythonBuilder(context);
		ContractLibrary library = EcoreUtil2.getContainerOfType(ca, ContractLibrary.class);
		pb.addImplementations(library);
		pb.addCode(ca.getCode());
		var pyCode = pb.getScript();
		var txt = pyRunner.eval(pyCode, pb.getVariables());
		System.out.println("\nGenerated >>>");
		System.out.println(txt);
		System.out.println("<<<\n\n");
		return txt;
	};

	public String smtAssumption(CodeAssumption ca, Contract contract) {
		var pyExpr = newPythonBuilder(context);
		if (ca.isExact()) {
			pyExpr.addCode("""
					If(
					""").indent();
		} else {
			pyExpr.addCode("""
					Implies(
					""").indent();
		}
		if (ca.getCode().getLanguage() == Language.SMT) {
			pyExpr.addCode(evalAssumption(ca) + ",");
		} else {
			pyExpr.addCode(new PathSourceImpl(ca.getCode(), getArgumentPath(contract)), ",");
		}
		var guarantee = ca.getGuarantee();
		if (ca.isExact()) {
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)), ",");
			pyExpr.addCode("""
					Not(
					""").indent();
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)));
			pyExpr.outdent(2).addCode("""
					    )
					),
					""");
		} else {
			pyExpr.addCode(new PathSourceImpl(guarantee.getCode(), getArgumentPath(contract)), "");
			pyExpr.outdent().addCode("""
					),
					""");
		}
		return pyExpr.getScript();
	}

	public String smtArgument(Argument argument) {
		var pb = newPythonBuilder(context);
		ContractLibrary library = EcoreUtil2.getContainerOfType(argument, ContractLibrary.class);

		pyBuilder.addImplementations(library);
		if (argument.isExact()) {
			pb.addCode("""
					If(
					""").indent();
		} else {
			pb.addCode("""
					Implies(
					""").indent();
		}
		parentContract.put(argument.getArgumentExpression(), argument);
		smtArgumentExpression(argument.getArgumentExpression(), pb);
		var guarantee = argument.getGuarantee();
		if (argument.isExact()) {
			pb.addCode(guarantee.getCode(), ",");
			pb.addCode("""
					Not(
					""").indent();
			pb.addCode(guarantee.getCode());
			pb.outdent(2).addCode("""
					    )
					),
					""");
		} else {
			pb.addCode(guarantee.getCode(), "");
			pb.outdent().addCode("""
					),
					""");
		}
		return pb.getScript();
	}

	private void smtArgumentExpression(ArgumentExpression ae, PythonBuilder pb) {
		if (ae instanceof ArgumentAnd) {
			pb.addCode("""
					And(
					""");
		} else if (ae instanceof ArgumentOr) {
			pb.addCode("""
					Or(
					""");
		} else if (ae instanceof ArgumentNot) {
			pb.addCode("""
					Not(
					""");
		}
		pb.indent();
		for (var ce : ae.getContracts()) {
			// add referenced contract's guarantee here and add referenced contract itself later
			Contract c = (Contract) ce;
			pb.addCode(c.getGuarantee().getCode(), ",");
			deferredContracts.add(c);
			parentContract.put(c, ae);
		}
		for (var ce : ae.getArguments()) {
			// add referenced argument's guarantee here and add referenced contract itself later
			Argument a = (Argument) ce;
			pb.addCode(a.getGuarantee().getCode(), ",");
			deferredArguments.add(a);
			parentContract.put(a, ae);
		}
		for (var ne : ae.getNested()) {
			parentContract.put(ne, ae);
			smtArgumentExpression(ne, pb);
		}
		pb.outdent().addCode("""
				),
				""");
	}

	public void processVerificationPlans(boolean checkCompleteness) {
		for (var plan : plans) {
			smtVerificationPlan(plan, checkCompleteness);

			var pyCode = pyBuilder.getScript();

			int i = 1;
			try (var s = new Scanner(pyCode)) {
				while (s.hasNextLine()) {
					System.out.println(i + s.nextLine());
					i += 1;
				}
			}

			pyRunner.run(pyCode, pyBuilder.getVariables());
		}
	}

	@Deprecated(forRemoval = true)
	public void processVerificationPlan(ComponentInstance component, boolean checkCompleteness) {
		var classifier = component.getComponentClassifier();

		if (classifier != null) {
			for (var subclause : getAllAnnexSubclauses(classifier)) {
				if (subclause instanceof DefaultAnnexSubclause defaultSubclause
						&& defaultSubclause.getParsedAnnexSubclause() instanceof ContractSubclause contractSubclause) {
					for (var plan : contractSubclause.getVerifyPlans()) {
						smtVerificationPlan(plan, checkCompleteness);

						var pyCode = pyBuilder.getScript();

						int i = 1;
						try (var s = new Scanner(pyCode)) {
							while (s.hasNextLine()) {
								System.out.println(i + s.nextLine());
								i += 1;
							}
						}


						/**
						 * Dio: This is only for debugging in my own laptop with
						 * hardwired directories
						 */

						try {
							FileWriter writer = new FileWriter("/home/dionisio/etmac-workspace/smt/evalsmt3.py");
							writer.append(pyCode);
							writer.close();
						} catch (Exception writerException) {
							// System.out.println("Not in Dio's machine. Not writing debugging python program");
						}

						pyRunner.run(pyCode, pyBuilder.getVariables());
					}
				}
			}
		}
	}

	private static List<AnnexSubclause> getAllAnnexSubclauses(Classifier classifier) {
		var subclauses = new ArrayList<AnnexSubclause>();
		for (var currentClassifier : classifier.getSelfPlusAllExtended()) {
			subclauses.addAll(currentClassifier.getOwnedAnnexSubclauses());
		}
		if (classifier instanceof ComponentImplementation implementation) {
			for (var currentClassifier : implementation.getType().getSelfPlusAllExtended()) {
				subclauses.addAll(currentClassifier.getOwnedAnnexSubclauses());
			}
		}
		return subclauses;
	}

}
