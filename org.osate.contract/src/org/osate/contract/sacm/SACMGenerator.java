package org.osate.contract.sacm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAnd;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ArgumentNot;
import org.osate.contract.contract.ArgumentOr;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.Guarantee;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;

import argumentation.ArgumentAsset;
import argumentation.ArgumentPackage;
import argumentation.ArgumentReasoning;
import argumentation.ArtifactReference;
import argumentation.AssertedRelationship;
import argumentation.Claim;
import artifact.ArtifactPackage;
import artifact.Technique;
import assuranceCase.AssuranceCasePackage;
import base.LangString;

public final class SACMGenerator {
	private final ArgumentPackage argumentPackage;
	private final ArtifactPackage artifactPackage;

	protected HashMap<Object, Object> parentContract = new HashMap<Object, Object>();

	/*
	 * Need to create all the nodes before creating the edges, so need to maintain a list of
	 * nodes that have been created and all the edges that need to be created.
	 */
//	private final Map<String, ContractRecord> contractToRecords = new HashMap<>();

	private final Map<String, Claim> claimPathToClaim = new HashMap<>(); // N.B. ETMAC "claim" to SACM Claim
	private final Map<String, Claim> contractPathToClaim = new HashMap<>();
	private final Map<String, Claim> assumptionPathToClaim = new HashMap<>();
	private final Map<String, ArtifactReference> analysisPathToArtifactReference = new HashMap<>();
	private final Map<String, Claim> argumentPathToClaim = new HashMap<>();
	private final Map<String, Claim> argumentExprPathToClaim = new HashMap<>();

	// top-level claim has incoming edges from the list of sources
	private List<String> vpClaimsEdges;
	// top-level claim has incoming edges from the list of Contracts
	private List<String> vpContractEdges;
	// Claim has incoming edges from the list of Assumptions; assumptions are indirectly referenced by argPath
	private final Map<Claim, List<String>> assumptionEdges = new HashMap<>();
	// Claim has incoming edges from the list of analyses; analyses are indirectly referenced by argPath
	private final Map<Claim, List<String>> analysisEdges = new HashMap<>();
	// Claim has incoming edges from the list of claims; claims are indirectly referenced by argPath
	private final Map<Claim, List<String>> contractEdges = new HashMap<>();
	// Claim has incoming edges from the list of arguments; arguments are indirectly referenced by argPath
	private final Map<Claim, List<String>> argumentEdges = new HashMap<>();
	// Claim has incoming edges from the list of argument expressions; argument expressions are indirectly referenced by argPath
	private final Map<Claim, List<String>> argumentExprEdges = new HashMap<>();

	public SACMGenerator(final ArgumentPackage argPack, final ArtifactPackage artPack) {
		this.argumentPackage = argPack;
		this.artifactPackage = artPack;
	}

	public static final void createAssuraceCasePackage(final Resource sacmResource, final VerificationPlan vp) {
		final LangString pName = SACMHelper.newLangString(SACMHelper.LANG_EN, "Verification Plan " + vp.getFullName());
		final AssuranceCasePackage acp = SACMHelper.newAssuraceCasePackage(pName);
		sacmResource.getContents().add(acp);
		createAssurancePackage(acp, vp);
	}

	private static void createAssurancePackage(final AssuranceCasePackage acp, final VerificationPlan vp) {
		final ArgumentPackage argPack = SACMHelper
				.newArgumentPackage(SACMHelper.newLangString(SACMHelper.LANG_EN, "The Argument"));
		acp.getArgumentPackage().add(argPack);

		final ArtifactPackage artPack = SACMHelper
				.newArtifactPackage(SACMHelper.newLangString(SACMHelper.LANG_EN, "Artifacts"));
		acp.getArtifactPackage().add(artPack);

		processVerificationPlan(argPack, artPack, vp);
	}

	private static void processVerificationPlan(final ArgumentPackage argPack, final ArtifactPackage artPack,
			final VerificationPlan vp) {
		final SACMGenerator generator = new SACMGenerator(argPack, artPack);
		generator.buildSACM(vp);
	}

	public Claim buildSACM(final VerificationPlan vp) {
		final Claim vpClaim = generateVerificationPlan(vp);
		for (var claim : vp.getClaims()) {
			generateClaim(claim, vp);
		}
		// XXX: One argument package?
//		files.add(new YamlFile(verificationPlan.getName(), planNodes));

		// --

		final NodeCollector collector = new NodeCollector();
		collector.collect(vp);
		collector.contractNodes.forEach((contract, contractNodes) -> {
			generateContract(contract);
			for (var assumption : contractNodes.assumptions) {
				generateAssumption(assumption);
			}
			for (var analysis : contractNodes.analyses) {
				generateAnalysis(analysis);
			}
			// XXX: Another argument package?
//			var argpath = getArgumentPath(contract);
//			files.add(new YamlFile(argpath, nodes));

		});
		collector.argumentNodes.forEach((argument, argumentNodes) -> {
			var nodes = new ArrayList<String>();
			generateArgument(argument);
			for (var expression : argumentNodes.argumentExpressions) {
				generateArgumentExpression(expression);
			}
			// XXX: Another argument package?
//			var argpath = getArgumentPath(argument);
//			files.add(new YamlFile(argpath, nodes));
		});

		// --

		for (var assumption : collector.commonAssumptions) {
			generateAssumption(assumption);
		}
		for (var analysis : collector.commonAnalyses) {
			generateAnalysis(analysis);
		}
		// XXX: Another argument package?
//		if (!commonNodes.isEmpty()) {
//			files.add(new YamlFile("CommonNodes", commonNodes));
//		}

		addAllEdges(vpClaim);

		return vpClaim;
	}

	private void addAllEdges(final Claim vpClaim) {
//		// top-level claim has incoming edges from the list of sources
//		private List<String> vpClaimsEdges;
//		// top-level claim has incoming edges from the list of Contracts
//		private List<String> vpContractEdges;
//		// Claim has incoming edges from the list of Assumptions; assumptions are indirectly referenced by argPath
//		private final Map<Claim, List<String>> assumptionEdges = new HashMap<>();
//		// Claim has incoming edges from the list of analyses; analyses are indirectly referenced by argPath
//		private final Map<Claim, List<String>> analysisEdges = new HashMap<>();
//		// Claim has incoming edges from the list of claims; claims are indirectly referenced by argPath
//		private final Map<Claim, List<String>> contractEdges = new HashMap<>();
//		// Claim has incoming edges from the list of arguments; arguments are indirectly referenced by argPath
//		private final Map<Claim, List<String>> argumentEdges = new HashMap<>();
//		// Claim has incoming edges from the list of argument expressions; argument expressions are indirectly referenced by argPath
//		private final Map<Claim, List<String>> argumentExprEdges = new HashMap<>();

		generateEdgesToClaim(vpClaim, vpClaimsEdges, claimPathToClaim, SACMHelper::newAssertedInference, "assumptions");
		generateEdgesToClaim(vpClaim, vpContractEdges, contractPathToClaim, SACMHelper::newAssertedInference,
				"contracts");

		// XXX: something wrong here: The created references don't have the same names as the edges
//		generateEdgesToClaims(analysisEdges, analysisPathToArtifactReference, SACMHelper::newAssertedEvidence,
//				"analyses");
		generateEdgesToClaims(assumptionEdges, assumptionPathToClaim, SACMHelper::newAssertedInference, "assumptions");
		generateEdgesToClaims(contractEdges, contractPathToClaim, SACMHelper::newAssertedInference, "contracts");
		generateEdgesToClaims(argumentEdges, argumentPathToClaim, SACMHelper::newAssertedInference, "arguments");
		generateEdgesToClaims(argumentExprEdges, argumentExprPathToClaim, SACMHelper::newAssertedInference,
				"arg exprs");


	}

//	// add inference between vp and its claims
//	final ArgumentReasoning analysis = SACMHelper.newAnalysis(ap,
//			SACMHelper.newLangString(SACMHelper.LANG_EN, "TBD"));
//	final AssertedInference inference = SACMHelper.newInference(ap);
//	inference.getSource().addAll(assumed);
//	inference.getTarget().add(vpClaim);
//	inference.setReasoning(analysis);

	private <T extends ArgumentAsset> void generateEdgesToClaims(final Map<Claim, List<String>> claimEdges,
			final Map<String, T> argPathToAsset,
			final Function<ArgumentPackage, AssertedRelationship> assertionFunction, final String label) {
		for (var entry : claimEdges.entrySet()) {
			generateEdgesToClaim(entry.getKey(), entry.getValue(), argPathToAsset,
					assertionFunction, label);
		}
	}

//	private void generateEdgesToClaim(final Claim target, final List<String> sourceArgPaths,
//			final Map<String, Claim> argPathToClaim, final String label) {
//		final ArgumentReasoning reasoning = SACMHelper.newArgumentReasoning(argumentPackage,
//				SACMHelper.newLangString(SACMHelper.LANG_EN, label));
//		final AssertedInference inference = SACMHelper.newAssertedInference(argumentPackage);
//		inference.setReasoning(reasoning);
//		inference.getTarget().add(target);
//
//		for (final String argPath : sourceArgPaths) {
//			final Claim source = argPathToClaim.get(argPath);
//			inference.getSource().add(source);
//		}
//	}

	private <T extends ArgumentAsset> void generateEdgesToClaim(final Claim target, final List<String> sourceArgPaths,
			final Map<String, T> argPathToAsset,
			final Function<ArgumentPackage, AssertedRelationship> assertionFunction, final String label) {
		final ArgumentReasoning reasoning = SACMHelper.newArgumentReasoning(argumentPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, label));
		final AssertedRelationship relationship = assertionFunction.apply(argumentPackage);
		relationship.setReasoning(reasoning);
		relationship.getTarget().add(target);

		for (final String argPath : sourceArgPaths) {
			final T source = argPathToAsset.get(argPath);
			if (source == null) {
				System.out.println("Cannot find node for '" + argPath + "'");
			} else {
				relationship.getSource().add(source);
			}
		}
	}

	private Claim generateVerificationPlan(final VerificationPlan vp) {
		final Claim vpClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()),
				SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()))));

		for (var contract : vp.getContracts()) {
			parentContract.put(contract, vp);
			contract.setArgumentPrefix(vp.getName());
		}
		final List<String> supportingContracts = vp.getContracts()
				.stream()
				.map(Contract::getFullArgumentPath)
				.distinct()
				.collect(Collectors.toList());
		final List<String> supportingClaims = vp.getClaims()
				.stream()
				.map(claim -> getClaimName(claim, vp))
				.collect(Collectors.toList());
		vpContractEdges = supportingContracts;
		vpClaimsEdges = supportingClaims;
		return vpClaim;
	}

	private Claim generateClaim(final Source claim, final VerificationPlan verificationPlan) {
		final String claimName = getClaimName(claim, verificationPlan);
		final Claim claimClaim = SACMHelper.newClaim(argumentPackage, true,
				SACMHelper.newLangString(SACMHelper.LANG_EN, claimName),
				SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, toString(claim)))));
		claimPathToClaim.put(claimName, claimClaim);
		return claimClaim;
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

		final Claim contractClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));

		final List<String> supportingAnalyses = new ArrayList<>();
		final List<String> supportingAssumptions = new ArrayList<>();
		final List<String> supportingContracts = new ArrayList<>();
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				parentContract.put(referencedContract, contract);
				// TODO: FIX THIS [5/21 why? seems ok]
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

		contractPathToClaim.put(argPath, contractClaim);
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
		final Claim assumptionClaim = SACMHelper.newClaim(argumentPackage, true,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, argPath))));

		assumptionPathToClaim.put(argPath, assumptionClaim);
		return assumptionClaim;
	}

	private ArtifactReference generateAnalysis(final String argPath) {
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

		final Technique analysisAsTechnique = SACMHelper.newTechnique(artifactPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, argPath))));

		// Actually need a reference to the technique
		final ArtifactReference ref = SACMHelper.newArtifactReference(argumentPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, argPath))));
		// XXX: Probably deal with result here!
		ref.getReferencedArtifactElement().add(analysisAsTechnique);

		analysisPathToArtifactReference.put(argPath, ref);
		return ref;
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
		final Claim argumentClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));

		final List<String> supportedBy = new ArrayList<>();

		if (argument.getArgumentExpression() != null) {
			parentContract.put(argument.getArgumentExpression(), argument);
			supportedBy.add(getArgumentExpressionName(argument, argument.getArgumentExpression()));
		}
		argumentExprEdges.put(argumentClaim, supportedBy);

		argumentPathToClaim.put(argPath, argumentClaim);
		return argumentClaim;
	}

	private Claim generateArgumentExpression(final ArgumentExpression expression) {
		final Argument containingArgument = EcoreUtil2.getContainerOfType(expression, Argument.class);
		final String name = getArgumentExpressionName(containingArgument, expression);
		final Claim argumentExprClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, name), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, name))));

		final List<String> supportingArguments = new ArrayList<>();
		final List<String> supportingContracts = new ArrayList<>();
		final List<String> supportingArgExprs = new ArrayList<>();
		for (var argument : expression.getArguments()) {
			parentContract.put(argument, expression);
			var argargpath = getArgumentPath(argument);
			supportingArguments.add(argargpath);// argument.getName());
		}
		for (var contract : expression.getContracts()) {
			parentContract.put(contract, expression);
			var contractargpath = getArgumentPath(contract);
			supportingContracts.add(contractargpath);// contract.getName());
		}
		for (var nested : expression.getNested()) {
			parentContract.put(nested, expression);
			supportingArgExprs.add(getArgumentExpressionName(containingArgument, nested));
		}

		argumentEdges.put(argumentExprClaim, supportingArguments);
		contractEdges.put(argumentExprClaim, supportingContracts);
		argumentExprEdges.put(argumentExprClaim, supportingArgExprs);

		argumentExprPathToClaim.put(name, argumentExprClaim);
		return argumentExprClaim;
	}

	// --

	private class NodeCollector {
		public final Map<Contract, ContractNodes> contractNodes = new LinkedHashMap<>();
		public final Map<Argument, ArgumentNodes> argumentNodes = new LinkedHashMap<>();
		public final List<String> commonAssumptions = new ArrayList<>();
		public final List<String> commonAnalyses = new ArrayList<>();

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
				}
			}
			for (var analysis : contract.getAnalyses()) {
				final String fullPath = argpath + "." + getAnalysisName(analysis);
				nodes.analyses.add(fullPath);
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
	private String getArgumentExpressionName(Argument argument, ArgumentExpression expression) {
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

//	private static class SourceRecord {
//		// XXX: Might not need this?
//		public final Source source;
//		public Claim asClaim;
//
//		public SourceRecord(final Source source) {
//			this.source = source;
//		}
//	}
//
//	private static class AssumptionRecord {
//		// XXX: Might not need this?
//		public final AssumptionElement assumption;
//		public Claim asClaim;
//
//		public AssumptionRecord(final AssumptionElement assumption) {
//			this.assumption = assumption;
//		}
//	}
//
//	private static class AnalysisRecord {
//		// XXX: Might not need this?
//		public final Analysis analysis;
//		public ArtifactReference asArtifactReference; // TODO: What is this?
//
//		public AnalysisRecord(final Analysis analysis) {
//			this.analysis = analysis;
//		}
//	}
//
//	private static class ArgumentRecord {
//		// XXX: Might not need this?
//		public final Argument argument;
//		public Claim asClaim;
//
//		public ArgumentRecord(final Argument argument) {
//			this.argument = argument;
//		}
//	}
//
//	private static class ArgumentExprRecord {
//		// XXX: Might not need this?
//		public final ArgumentExpression argumentExpr;
//		public Claim asClaim;
//
//		public ArgumentExprRecord(final ArgumentExpression argumentExpr) {
//			this.argumentExpr = argumentExpr;
//		}
//	}
}
