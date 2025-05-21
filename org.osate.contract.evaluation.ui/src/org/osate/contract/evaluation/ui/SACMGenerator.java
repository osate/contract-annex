package org.osate.contract.evaluation.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAnd;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ArgumentNot;
import org.osate.contract.contract.ArgumentOr;
import org.osate.contract.contract.AssumptionElement;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.Guarantee;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;

import argumentation.ArgumentPackage;
import argumentation.Claim;
import assuranceCase.AssuranceCasePackage;
import base.LangString;

final class SACMGenerator {
	private final ArgumentPackage ap;
	protected HashMap<Object, Object> parentContract = new HashMap<Object, Object>();

	/*
	 * Need to create all the nodes before creating the edges, so need to maintain a list of
	 * nodes that have been created and all the edges that need to be created.
	 */
	private final Map<Source, Claim> claimsToClaims = new HashMap<>();
	private final Map<Contract, Claim> contractsToClaims = new HashMap<>();
	private final Map<String, AssumptionRecord> assumptionsToRecords = new HashMap<>();
	private final Map<String, AnalysisRecord> analysesToRecords = new HashMap<>();
	private final Map<String, ArgumentRecord> argumentsToRecords = new HashMap<>();

	// top-level claim has incoming edges from the list of sources
	private final Map<Claim, List<Source>> vpClaimsEdges = new HashMap<>();
	// top-level claim has incoming edges from the list of Contracts
	private final Map<Claim, List<Contract>> vpContractEdges = new HashMap<>();
	// Claim has incoming edges from the list of Assumptions; assumptions are indirectly referenced by argPath
	private final Map<Claim, List<String>> assumptionEdges = new HashMap<>();
	// Claim has incoming edges from the list of analyses; analyses are indirectly referenced by argPath
	private final Map<Claim, List<String>> analysisEdges = new HashMap<>();
	// Claim has incoming edges from the list of claims; claims are indirectly referenced by argPath
	private final Map<Claim, List<String>> contractEdges = new HashMap<>();
	// Claim has incoming edges from the list of argument expressions; argument expressions are indirectly referenced by argPath
	private final Map<Claim, List<String>> argumentExprEdges = new HashMap<>();

	public SACMGenerator(final ArgumentPackage ap) {
		this.ap = ap;
	}

	public static final void createAssuraceCasePackage(final Resource sacmResource, final VerificationPlan vp) {
		final LangString pName = SACMHelper.newLangString(SACMHelper.LANG_EN, "Verification Plan " + vp.getFullName());
		final AssuranceCasePackage acp = SACMHelper.newAssuraceCasePackage(pName);
		sacmResource.getContents().add(acp);
		createAssurancePackage(acp, vp);
	}

	private static void createAssurancePackage(final AssuranceCasePackage acp, final VerificationPlan vp) {
		final LangString pName = SACMHelper.newLangString(SACMHelper.LANG_EN, "The Argument");
		final ArgumentPackage ap = SACMHelper.newArgumentPackage(pName);
		acp.getArgumentPackage().add(ap);
		processVerificationPlan(ap, vp);
	}

	private static void processVerificationPlan(final ArgumentPackage ap, final VerificationPlan vp) {
		final SACMGenerator generator = new SACMGenerator(ap);
		generator.buildSACM(vp);
	}

	public Claim buildSACM(final VerificationPlan vp) {
		final Claim vpClaim = generateVerificationPlan(vp);
		final NodeCollector collector = new NodeCollector();
		collector.collect(vp);

		// TODO: FIX THIS
//		collector.contractNodes.forEach((contract, contractNodes) -> {
//			var nodes = new ArrayList<String>();
//			nodes.add(generateContract(contract));
//			for (var assumption : contractNodes.assumptions) {
//				nodes.add(generateAssumption(assumption));
//			}
//			for (var analysis : contractNodes.analyses) {
//				nodes.add(generateAnalysis(analysis));
//			}
//			var argpath = getArgumentPath(contract);
//			files.add(new YamlFile(argpath, nodes));
//		});
//		collector.argumentNodes.forEach((argument, argumentNodes) -> {
//			var nodes = new ArrayList<String>();
//			nodes.add(generateArgument(argument));
//			for (var expression : argumentNodes.argumentExpressions) {
//				nodes.add(generateArgumentExpression(expression));
//			}
//			var argpath = getArgumentPath(argument);
//			files.add(new YamlFile(argpath, nodes));
//		});
//
//		var commonNodes = new ArrayList<String>();
//		for (var assumption : collector.commonAssumptions) {
//			commonNodes.add(generateAssumption(assumption));
//		}
//		for (var analysis : collector.commonAnalyses) {
//			commonNodes.add(generateAnalysis(analysis));
//		}
//		if (!commonNodes.isEmpty()) {
//			files.add(new YamlFile("CommonNodes", commonNodes));
//		}
//
//		var verificationPlanPackage = (ContractLibraryImpl) EcoreUtil.getRootContainer(verificationPlan);
//		var folderName = verificationPlanPackage.getName() + "_" + verificationPlan.getName();
//		return new YamlFolder(folderName, files);

		buildEdges();

		return vpClaim;
	}

	private void buildEdges() {
		// TO DO

//		// add inference between vp and its claims
//		final ArgumentReasoning analysis = SACMHelper.newAnalysis(ap,
//				SACMHelper.newLangString(SACMHelper.LANG_EN, "TBD"));
//		final AssertedInference inference = SACMHelper.newInference(ap);
//		inference.getSource().addAll(assumed);
//		inference.getTarget().add(vpClaim);
//		inference.setReasoning(analysis);
	}

	private Claim generateVerificationPlan(final VerificationPlan vp) {
		final Claim vpClaim = SACMHelper.newClaim(ap, false, SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()),
				SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()))));
		vpClaimsEdges.put(vpClaim, vp.getClaims());
		vpContractEdges.put(vpClaim, vp.getContracts());
		return vpClaim;
	}

	private Claim generateContract(final Contract contract) {
		final String description;
		final Guarantee guarantee = contract.getGuarantee();
		if (guarantee == null) {
			description = contract.getName();
		} else {
			var symbol = contract.isExact() ? "<=>" : "=>";
			var source = SACMGenerator.toString(guarantee.getCode());
			description = symbol + ' ' + source;
		}
		final String argPath = getArgumentPath(contract);

		final Claim contractClaim = SACMHelper.newClaim(ap, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));
		contractsToClaims.put(contract, contractClaim);

		final List<String> supportingAnalyses = new ArrayList<>();
		final List<String> supportingAssumptions = new ArrayList<>();
		final List<String> supportingContracts = new ArrayList<>();
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				parentContract.put(referencedContract, contract);
				// TODO: FIX THIS
				supportingContracts.add(argPath + "." + referencedContract.getName());
			} else if (assumption instanceof ArgumentAssumption argumentAssumption
					&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
				parentContract.put(referencedArgument, contract);
				supportingContracts.add(argPath + "." + referencedArgument.getName());
			} else if (assumption instanceof CodeAssumption codeAssumption) {
				parentContract.put(codeAssumption, contract);
				supportingAssumptions.add(argPath + "." + getAssumptionName(codeAssumption));
			}
		}
		for (var analysis : contract.getAnalyses()) {
			parentContract.put(analysis, contract);
			supportingAnalyses.add(argPath + "." + getAnalysisName(analysis));
		}

		assumptionEdges.put(contractClaim, supportingAssumptions);
		analysisEdges.put(contractClaim, supportingAnalyses);
		contractEdges.put(contractClaim, supportingContracts);

		return contractClaim;
	}

	private Claim generateAssumption(final String argPath) {
//		var template = new ST("""
//				%name%:
//				  text: %name%
//				  nodeType: Assumption
//				  url: eclipse+gsnmarker://%name%
//				  #result: %result%""", '%', '%');
//		template.add("name", name);
//		var result = resultFinder.getResult(name);
//		template.add("result", result);
//		return template.render();

		// TODO: Deal with url/link and #result
		final Claim assumptionClaim = SACMHelper.newClaim(ap, true,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, argPath))));

		// Updated record!
		assumptionsToRecords.get(argPath).asClaim = assumptionClaim;
		return assumptionClaim;
	}

	private Object generateAnalysis(final String argPath) {
//		private static String generateAnalysis(String name) {
//			var template = new ST("""
//					%name%:
//					  text: %name%
//					  nodeType: Solution
//					  url: eclipse+gsnmarker://%name%
//					  #result: %result%""", '%', '%');
//			template.add("name", name);
//			var result = resultFinder.getResult(name);
//			template.add("result", result);
//			return template.render();

		// TODO: Deal with url/link and #result
		// TODO: What do we create???
		final Object analysisNode = null;

		// Update record!
		analysesToRecords.get(argPath).asNode = analysisNode;
		return analysisNode;
	}

	private Claim generateArgument(final Argument argument) {
		final String argPath = getArgumentPath(argument);
		final String description;
		final Guarantee guarantee = argument.getGuarantee();
		if (guarantee == null) {
			description = argPath;
		} else {
			var symbol = argument.isExact() ? "<=>" : "=>";
			var source = toString(guarantee.getCode());
			description = symbol + ' ' + source;
		}
		final Claim argumentClaim = SACMHelper.newClaim(ap, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));

		final List<String> supportedBy = new ArrayList<>();

		if (argument.getArgumentExpression() != null) {
			parentContract.put(argument.getArgumentExpression(), argument);
			supportedBy.add(getArgumentExpressionName(argument, argument.getArgumentExpression()));
		}
		argumentExprEdges.put(argumentClaim, supportedBy);

		// Updated record!
		argumentsToRecords.get(argPath).asClaim = argumentClaim;
		return argumentClaim;
	}

	// --

	private class NodeCollector {
		public final Map<Contract, ContractNodes> contractNodes = new LinkedHashMap<>();
		public final Map<Argument, ArgumentNodes> argumentNodes = new LinkedHashMap<>();

		public NodeCollector() {
			super();
		}

		public void collect(final VerificationPlan verificationPlan) {
			for (var contract : verificationPlan.getContracts()) {
				parentContract.put(contract, verificationPlan);
				collect(contract);
			}

			var assumptionOccurrences = new LinkedHashMap<String, Integer>();
			var analysisOccurrences = new HashMap<String, Integer>();

			for (var nodes : contractNodes.values()) {
				for (var assumption : nodes.assumptions) {
					assumptionOccurrences.merge(assumption, 1, Integer::sum);
				}
				for (var analysis : nodes.analyses) {
						analysisOccurrences.merge(analysis, 1, Integer::sum);
				}
			}

			final List<String> commonAssumptions = new ArrayList<>();
			final List<String> commonAnalyses = new ArrayList<>();
			for (var entry : assumptionOccurrences.entrySet()) {
				if (entry.getValue() > 1) {
					commonAssumptions.add(entry.getKey());
				}
			}
			for (var entry : analysisOccurrences.entrySet()) {
				if (entry.getValue() > 1) {
					commonAnalyses.add(entry.getKey());
				}
			}

			for (var nodes : contractNodes.values()) {
				nodes.assumptions.removeAll(commonAssumptions);
				nodes.analyses.removeAll(commonAnalyses);
			}
		}

		private void collect(final Contract contract) {
			var argpath = getArgumentPath(contract);
			var nodes = contractNodes.computeIfAbsent(contract, key -> new ContractNodes());
			for (var assumption : contract.getAssumptions()) {
				parentContract.put(assumption, contract);
				if (assumption instanceof ContractAssumption contractAssumption
						&& contractAssumption.getContract() instanceof Contract referencedContract) {
					collect(referencedContract);
				} else if (assumption instanceof ArgumentAssumption argumentAssumption
						&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
					collect(referencedArgument);
				} else if (assumption instanceof CodeAssumption codeAssumption) {
					final String fullPath = argpath + "." + getAssumptionName(codeAssumption);
					nodes.assumptions.add(fullPath);
					assumptionsToRecords.put(fullPath, new AssumptionRecord(codeAssumption));
				}
			}
			for (var analysis : contract.getAnalyses()) {
				final String fullPath = argpath + "." + getAnalysisName(analysis);
				nodes.analyses.add(fullPath);
				analysesToRecords.put(fullPath, new AnalysisRecord(analysis));
			}
		}

		private void collect(final Argument argument) {
			var nodes = argumentNodes.computeIfAbsent(argument, key -> new ArgumentNodes());
			if (argument.getArgumentExpression() != null) {
				parentContract.put(argument.getArgumentExpression(), argument);
				collect(argument.getArgumentExpression(), nodes);
			}
		}

		private void collect(ArgumentExpression expression, ArgumentNodes nodes) {
			nodes.argumentExpressions.add(expression);
			for (var referencedArgument : expression.getArguments()) {
				if (referencedArgument instanceof Argument castedArgument) {
					parentContract.put(castedArgument, expression);
					collect(castedArgument);
				}
			}
			for (var referencedContract : expression.getContracts()) {
				if (referencedContract instanceof Contract castedContract) {
					parentContract.put(castedContract, expression);
					collect(castedContract);
				}
			}
			for (var nested : expression.getNested()) {
				parentContract.put(nested, expression);
				collect(nested, nodes);
			}
		}
	}

	// --

	// unchanged
	private String getArgumentPath(Object contract) {
		String path = "";
		Stack<String> pathSegments = new Stack<String>();

		Object parent = parentContract.get(contract);
		while (parent != null) {
			pathSegments.push(getName(parent));
			parent = parentContract.get(parent);
		}

		while (!pathSegments.isEmpty()) {
			String s = pathSegments.pop();
			if (s.length() > 0) {
				if (path.length() > 0) {
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

	// unchanged
	private static String getClaimName(Source claim, VerificationPlan verificationPlan) {
		return verificationPlan.getName() + "_claim_" + (verificationPlan.getClaims().indexOf(claim) + 1);
	}

	// unchanged
	private static String toString(Source source) {
		if (source.getSource() != null) {
			return source.getSource();
		} else if (source.getInter() != null) {
			var result = new StringBuilder();
			for (var part : source.getInter().getParts()) {
				if (part instanceof IStringLiteral stringLiteral) {
					result.append(stringLiteral.getValue());
				} else if (part instanceof IStringVar stringVar) {
					result.append("${");
					if (stringVar.isDirect()) {
						result.append(':');
					}
					if (stringVar.getQuery() != null) {
						if (stringVar.getDomain() != null) {
							result.append(stringVar.getDomain().getName());
							result.append("::");
						}
						result.append(stringVar.getQuery().getName());
					} else {
						result.append(stringVar.getPredefined());
					}
					result.append("$}");
				} else {
					throw new AssertionError("Unexpected class: " + part.getClass());
				}
			}
			return result.toString();
		} else {
			throw new AssertionError("Unexpected condition: source and inter are both null for " + source);
		}
	}

	// unchanged

	// unchanged
	private static class ContractNodes {
		public final Set<String> assumptions = new LinkedHashSet<>();
		public final Set<String> analyses = new LinkedHashSet<>();
	}

	// unchanged
	private static class ArgumentNodes {
		public final Set<ArgumentExpression> argumentExpressions = new LinkedHashSet<>();
	}

	// unchanged
	public static String getName(Object c) {
		if (c instanceof Contract) {
			return ((Contract) c).getName();
		} else if (c instanceof VerificationPlan) {
			return ((VerificationPlan) c).getName();
		} else if (c instanceof Argument) {
			return ((Argument) c).getName();
		}

		return "";
	}

	// unchanged
	private static String getArgumentExpressionName(Argument argument, ArgumentExpression expression) {
		String expressionType;
		if (expression instanceof ArgumentAnd) {
			expressionType = "and";
		} else if (expression instanceof ArgumentOr) {
			expressionType = "or";
		} else if (expression instanceof ArgumentNot) {
			expressionType = "not";
		} else {
			throw new AssertionError("Unexpected class: " + expression.getClass());
		}

		var allExpressionsOfType = EcoreUtil2.getAllContentsOfType(argument, expression.getClass());
		var index = allExpressionsOfType.indexOf(expression);

		String argpath = getArgumentPath(argument);

		// return argument.getName() + '_' + expressionType + '_' + (index + 1);
		return argpath + '_' + expressionType + '_' + (index + 1);
	}

	// unchanged
	private static String getAssumptionName(CodeAssumption assumption) {
		return trimParens(toString(assumption.getCode()));
	}

	// unchanged
	private static String getAnalysisName(Analysis analysis) {
		return trimParens(toString(analysis.getCode()));
	}

	// unchanged
	private static String trimParens(String s) {
		var paren = s.indexOf('(');
		if (paren == -1) {
			return s;
		} else {
			return s.substring(0, paren);
		}
	}

	private static class AssumptionRecord {
		// XXX: Might not need this?
		public final AssumptionElement assumption;
		public Claim asClaim;

		public AssumptionRecord(final AssumptionElement assumption) {
			this.assumption = assumption;
		}
	}

	private static class AnalysisRecord {
		// XXX: Might not need this?
		public final Analysis analysis;
		public Object asNode; // TODO: What is this?

		public AnalysisRecord(final Analysis analysis) {
			this.analysis = analysis;
		}
	}

	private static class ArgumentRecord {
		// XXX: Might not need this?
		public final Argument argument;
		public Claim asClaim;

		public ArgumentRecord(final Argument argument) {
			this.argument = argument;
		}
	}
}
