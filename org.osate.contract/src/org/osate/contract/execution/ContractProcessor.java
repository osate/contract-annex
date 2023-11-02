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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.ease.service.EngineDescription;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.ContractSubclause;
import org.osate.contract.contract.InputAssumption;
import org.osate.contract.contract.Language;
import org.osate.contract.contract.VerificationPlan;

public class ContractProcessor {

	// Dio: just to add the feedback from assert_and_track()
	protected boolean analysisExplanations = true;

	private int assertIndex = 0;

	protected boolean useZ3 = true;

	protected PythonBuilder pyBuilder;

	protected ScriptRunner pyRunner;

	protected ComponentInstance context;

	protected Set<Contract> addedContracts = new HashSet<>();

	List<Contract> deferredContracts = new ArrayList<>();

	List<Argument> deferredArguments = new ArrayList<>();

	static final Object DONE = new Object();

	public ContractProcessor(ComponentInstance context, EngineDescription description) {
		this.context = context;
		pyBuilder = new PythonBuilder(context);
		pyRunner = new ScriptRunner(description);
	}

	public Object pyVerificationPlan(VerificationPlan plan) {
		ContractLibrary library = EcoreUtil2.getContainerOfType(plan, ContractLibrary.class);
		pyBuilder.addImplementations(library);
		for (var contract : plan.getContracts()) {
			pyContract(contract);
		}
		return DONE;
	};

	public Object pyContract(Contract contract) {
		ContractLibrary library = EcoreUtil2.getContainerOfType(contract, ContractLibrary.class);
		pyBuilder.addImplementations(library);
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof CodeAssumption ca) {
				pyBuilder.addCode(ca.getCode());
			}
		}
		for (var analysis : contract.getAnalyses()) {
			pyBuilder.addCode(analysis.getCode());
		}
		return DONE;
	};

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
					    error0 = [\"\"]
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
			var expr = smtContract(contract);
			pyBuilder.addCode("# contract " + contract.getFullName());
			addCode(expr);
		}
		for (int i = 0; i < deferredArguments.size(); i++) {
			var a = deferredArguments.get(i);
			pyBuilder.addCode("# argument " + a.getFullName());
			var expr = smtArgument(a);
			addCode(expr);
		}
		for (int i = 0; i < deferredContracts.size(); i++) {
			var c = deferredContracts.get(i);
			pyBuilder.addCode("# contract " + c.getFullName());
			var expr = smtContract(c);
			addCode(expr);
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
					    return \"False,\" + info0[0]
					#print(s.unsat_core())
					#return True
					return \"True,\" + str(s.unsat_core())

					""");
		} else {
			pyBuilder.addCode("""
					if s.check() == sat:
					    return \"True,\" + info0[0]
					#print(s.unsat_core())
					#return False
					return \"False,\" + str(s.unsat_core())

					""");
		}
		pyBuilder.outdent().addCode("""
				info0 = [\"\"]
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

		pyBuilder.addImplementations(library);
		for (var domain : contract.getDomains()) {
			pyBuilder.addDomain(domain);
		}
		var pyExpr = new PythonBuilder(context);
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
					pyExpr.addCode(ca.getGuarantee().getCode(), ",");
					deferredAssumptions.add(ca);
				} else {
					if (ca.getCode().getLanguage() == Language.SMT) {
						pyExpr.addCode(evalAssumption(ca) + ",");
					} else {
						pyExpr.addCode(ca.getCode(), ",");
					}
				}
			} else if (assumption instanceof ContractAssumption ca) {
				// add referenced contract's guarantee here and add referenced contract itself later
				Contract c = (Contract) ca.getContract();
				pyExpr.addCode(c.getGuarantee().getCode(), ",");
				deferredContracts.add(c);
			} else if (assumption instanceof ArgumentAssumption aa) {
				// add referenced contract's guarantee here and add referenced contract itself later
				Argument a = (Argument) aa.getArgument();
				pyExpr.addCode(a.getGuarantee().getCode(), ",");
				deferredArguments.add(a);
			}
		}
		for (var analysis : contract.getAnalyses()) {
			pyExpr.addCode(analysis.getCode());
		}
		pyExpr.outdent().addCode("""
				),
				""");
		var guarantee = contract.getGuarantee();
		if (contract.isExact()) {
			pyExpr.addCode(guarantee.getCode(), ",");
			pyExpr.addCode("""
					Not(
					""").indent();
			pyExpr.addCode(guarantee.getCode());
			pyExpr.outdent(2).addCode("""
					    )
					),
					""");
		} else {
			pyExpr.addCode(guarantee.getCode(), "");
			pyExpr.outdent().addCode("""
					),
					""");
		}
		for (var a : deferredAssumptions) {
			pyExpr.addCode(smtAssumption(a));
		}
		pyBuilder.getVariables().putAll(pyExpr.getVariables());
		return pyExpr.getScript();
	};

	private boolean checkInputAssumptions(Contract contract) {
		var pb = new PythonBuilder(context);
		ContractLibrary library = EcoreUtil2.getContainerOfType(contract, ContractLibrary.class);
		pb.addImplementations(library);
		// reuse initial part of the script
		var common = pb.getScript();
		for (var ia : contract.getInputs()) {
			pb = new PythonBuilder(context);
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

		System.out.println("Checking input assumption:\n" + pyCode);

		var result = pyRunner.run(pyCode, pb.getVariables());
		return result;
	}

	private String evalAssumption(CodeAssumption ca) {
		var pb = new PythonBuilder(context);
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

	public String smtAssumption(CodeAssumption ca) {
		var pyExpr = new PythonBuilder(context);
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
			pyExpr.addCode(ca.getCode(), ",");
		}
		var guarantee = ca.getGuarantee();
		if (ca.isExact()) {
			pyExpr.addCode(guarantee.getCode(), ",");
			pyExpr.addCode("""
					Not(
					""").indent();
			pyExpr.addCode(guarantee.getCode());
			pyExpr.outdent(2).addCode("""
					    )
					),
					""");
		} else {
			pyExpr.addCode(guarantee.getCode(), "");
			pyExpr.outdent().addCode("""
					),
					""");
		}
		return pyExpr.getScript();
	}

	public String smtArgument(Argument argument) {
		var pb = new PythonBuilder(context);
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
		pb.addCode("""
				Or(
				""").indent();
		var ae = argument.getArgumentExpression();
		for (var ce : ae.getContracts()) {
			// add referenced contract's guarantee here and add referenced contract itself later
			Contract c = (Contract) ce;
			pb.addCode(c.getGuarantee().getCode(), ",");
			deferredContracts.add(c);
		}
		for (var ce : ae.getArguments()) {
			// add referenced contract's guarantee here and add referenced contract itself later
			Argument a = (Argument) ce;
			pb.addCode(a.getGuarantee().getCode(), ",");
			deferredArguments.add(a);
		}
		pb.outdent().addCode("""
				),
				""");
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

	@Deprecated(forRemoval = true)
	public void processVerificationPlan(ComponentInstance component, boolean checkCompleteness) {
		var classifier = component.getComponentClassifier();

		if (classifier != null) {
			for (var subclause : getAllAnnexSubclauses(classifier)) {
				if (subclause instanceof DefaultAnnexSubclause defaultSubclause
						&& defaultSubclause.getParsedAnnexSubclause() instanceof ContractSubclause contractSubclause) {
					for (var plan : contractSubclause.getVerifyPlans()) {
						if (useZ3) {
							smtVerificationPlan(plan, checkCompleteness);
						} else {
							pyVerificationPlan(plan);
						}
						var pyCode = pyBuilder.getScript();

						int i = 1;
						var s = new Scanner(pyCode);
						while (s.hasNextLine()) {
							System.out.println(i + s.nextLine());
							i += 1;
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
