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

import org.eclipse.emf.ecore.EObject;
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
import org.osate.contract.contract.ContractElement;
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

public final class SACMGenerator2 {
	private final ArgumentPackage argumentPackage;
	private final ArtifactPackage artifactPackage;

	protected HashMap<Object, Object> parentContract = new HashMap<Object, Object>();

	/*
	 * Need to create all the nodes before creating the edges, so need to maintain a list of
	 * nodes that have been created and all the edges that need to be created.
	 */
	private final Map<EObject, ArtifactReference> analysisToArtifactReference = new HashMap<>();
	private final Map<EObject, Claim> contractObjToClaim = new HashMap<>();

	// top-level claim has incoming edges from the list of sources
	private List<Source> vpClaimsEdges;
	// top-level claim has incoming edges from the list of Contracts
	private List<ContractElement> vpContractEdges;

	// Claim has incoming edges from the list of Assumptions
	private final Map<Claim, List<CodeAssumption>> assumptionEdges = new HashMap<>();
	// Claim has incoming edges from the list of analyses
	private final Map<Claim, List<Analysis>> analysisEdges = new HashMap<>();
	// Claim has incoming edges from the list of claims
	private final Map<Claim, List<ContractElement>> contractEdges = new HashMap<>();
	// Claim has incoming edges from the list of argument
	private final Map<Claim, List<ContractElement>> argumentEdges = new HashMap<>();
	// Claim has incoming edges from the list of argument expressions
	private final Map<Claim, List<ArgumentExpression>> argumentExprEdges = new HashMap<>();

	public SACMGenerator2(final ArgumentPackage argPack, final ArtifactPackage artPack) {
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
		/* This generates the top level portion of the argument. */
		final Claim vpClaim = generateVerificationPlan(vp);
		for (var claim : vp.getClaims()) {
			generateClaim(claim, vp);
		}

		// --

		final NodeCollector collector = new NodeCollector();
		collector.collect(vp);
		collector.contractNodes.forEach((contract, contractNodes) -> {
			/*
			 * YAML-GSN version creates a different file for each contract. Mostly that is
			 * for graph-making convenience. But we could switch to a new ArgumentPackage
			 * here if we wanted to.
			 */
			generateContract(contract);
			for (var assumption : contractNodes.assumptions) {
				generateAssumption(assumption);
			}
			for (var analysis : contractNodes.analyses) {
				generateAnalysis(analysis);
			}
		});
		collector.argumentNodes.forEach((argument, argumentNodes) -> {
			/*
			 * YAML-GSN version creates a different file for each argument. Mostly that is
			 * for graph-making convenience. But we could switch to a new ArgumentPackage
			 * here if we wanted to.
			 */
			generateArgument(argument);
			for (var expression : argumentNodes.argumentExpressions) {
				generateArgumentExpression(expression);
			}
		});

		// --

		/*
		 * YAML-GSN version creates a new file for the common elements. Mostly that is
		 * for graph-making convenience. But we could switch to a new ArgumentPackage
		 * here if we wanted to.
		 */

		for (var assumption : collector.commonAssumptions) {
			generateAssumption(assumption);
		}
		for (var analysis : collector.commonAnalyses) {
			generateAnalysis(analysis);
		}

		/*
		 * If we create multiple ArgumentPackages, the edge creation becomes a little
		 * trickier because we will have store somewhere which package an edge should
		 * be placed in.
		 */
		addAllEdges(vpClaim);

		return vpClaim;
	}

	private void addAllEdges(final Claim vpClaim) {
		generateEdgesToClaim(vpClaim, vpClaimsEdges, contractObjToClaim, SACMHelper::newAssertedInference,
				"assumptions");
		generateEdgesToClaim(vpClaim, vpContractEdges, contractObjToClaim, SACMHelper::newAssertedInference,
				"contracts");

		generateEdgesToClaims(analysisEdges, analysisToArtifactReference, SACMHelper::newAssertedEvidence,
				"analyses");
		generateEdgesToClaims(assumptionEdges, contractObjToClaim, SACMHelper::newAssertedInference, "assumptions");
		generateEdgesToClaims(contractEdges, contractObjToClaim, SACMHelper::newAssertedInference, "contracts");
		generateEdgesToClaims(argumentEdges, contractObjToClaim, SACMHelper::newAssertedInference, "arguments");
		generateEdgesToClaims(argumentExprEdges, contractObjToClaim, SACMHelper::newAssertedInference,
				"arg exprs");
	}

	private <Q extends EObject> void generateEdgesToClaims(final Map<Claim, List<Q>> claimEdges,
			final Map<EObject, ? extends ArgumentAsset> argPathToAsset,
			final Function<ArgumentPackage, AssertedRelationship> assertionFunction, final String label) {
		for (var entry : claimEdges.entrySet()) {
			generateEdgesToClaim(entry.getKey(), entry.getValue(), argPathToAsset,
					assertionFunction, label);
		}
	}

	private void generateEdgesToClaim(final Claim target, final List<? extends EObject> sourceArgPaths,
			final Map<EObject, ? extends ArgumentAsset> argPathToAsset,
			final Function<ArgumentPackage, AssertedRelationship> assertionFunction, final String label) {
		final ArgumentReasoning reasoning = SACMHelper.newArgumentReasoning(argumentPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, label));
		final AssertedRelationship relationship = assertionFunction.apply(argumentPackage);
		relationship.setReasoning(reasoning);
		relationship.getTarget().add(target);

		for (final EObject argPath : sourceArgPaths) {
			final ArgumentAsset source = argPathToAsset.get(argPath);
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
		vpContractEdges = vp.getContracts()
				.stream()
				.distinct()
				.collect(Collectors.toList());
		vpClaimsEdges = vp.getClaims();
		return vpClaim;
	}

	private Claim generateClaim(final Source claim, final VerificationPlan verificationPlan) {
		final String claimName = getClaimName(claim, verificationPlan);
		final Claim claimClaim = SACMHelper.newClaim(argumentPackage, true,
				SACMHelper.newLangString(SACMHelper.LANG_EN, claimName),
				SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, toString(claim)))));
		contractObjToClaim.put(claim, claimClaim);
		return claimClaim;
	}

	private Claim generateContract(final Contract contract) {
		final String description;
		final Guarantee guarantee = contract.getGuarantee();
		if (guarantee == null) {
			description = contract.getName();
		} else {
			var symbol = contract.isExact() ? "<=>" : "=>";
			var source = toString(guarantee.getCode());
			description = symbol + ' ' + source;
		}
		final String argPath = getArgumentPath(contract);

		final Claim contractClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));

		final List<CodeAssumption> supportingAssumptions = new ArrayList<>();
		final List<ContractElement> supportingContracts = new ArrayList<>();
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				parentContract.put(referencedContract, contract);
				supportingContracts.add(referencedContract);
			} else if (assumption instanceof ArgumentAssumption argumentAssumption
					&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
				parentContract.put(referencedArgument, contract);
				supportingContracts.add(referencedArgument);
			} else if (assumption instanceof CodeAssumption codeAssumption) {
				parentContract.put(codeAssumption, contract);
				supportingAssumptions.add(codeAssumption);
			}
		}
		for (var analysis : contract.getAnalyses()) {
			parentContract.put(analysis, contract);
		}

		assumptionEdges.put(contractClaim, supportingAssumptions);
		analysisEdges.put(contractClaim, contract.getAnalyses());
		contractEdges.put(contractClaim, supportingContracts);

//		contractPathToClaim.put(contract, contractClaim);
		contractObjToClaim.put(contract, contractClaim);
		return contractClaim;
	}

	private Claim generateAssumption(final CodeAssumption assumption) {
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
		final String name = getAssumptionName(assumption);
		final Claim assumptionClaim = SACMHelper.newClaim(argumentPackage, true,
				SACMHelper.newLangString(SACMHelper.LANG_EN, name), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, name))));

		contractObjToClaim.put(assumption, assumptionClaim);
		return assumptionClaim;
	}

	private ArtifactReference generateAnalysis(final Analysis analysis) {
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

		final String name = getAnalysisName(analysis);
		final Technique analysisAsTechnique = SACMHelper.newTechnique(artifactPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, name), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, name))));

		// Actually need a reference to the technique
		final ArtifactReference ref = SACMHelper.newArtifactReference(argumentPackage,
				SACMHelper.newLangString(SACMHelper.LANG_EN, name), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, name))));
		// XXX: Probably deal with result here!
		ref.getReferencedArtifactElement().add(analysisAsTechnique);

		analysisToArtifactReference.put(analysis, ref);
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

		if (argument.getArgumentExpression() != null) {
			parentContract.put(argument.getArgumentExpression(), argument);
			argumentExprEdges.put(argumentClaim, List.of(argument.getArgumentExpression()));
		}

		System.out.println("Generating claim for argument " + argument + ": " + argumentClaim);
//		argumentPathToClaim.put(argument, argumentClaim);
		contractObjToClaim.put(argument, argumentClaim);
		return argumentClaim;
	}

	private Claim generateArgumentExpression(final ArgumentExpression expression) {
		final Argument containingArgument = EcoreUtil2.getContainerOfType(expression, Argument.class);
		final String name = getArgumentExpressionName(containingArgument, expression);
		final Claim argumentExprClaim = SACMHelper.newClaim(argumentPackage, false,
				SACMHelper.newLangString(SACMHelper.LANG_EN, name), SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, name))));

		for (var argument : expression.getArguments()) {
			parentContract.put(argument, expression);
		}
		for (var contract : expression.getContracts()) {
			parentContract.put(contract, expression);
		}
		for (var nested : expression.getNested()) {
			parentContract.put(nested, expression);
		}

		System.out.println("Argument expression " + expression + " needs arguments " + expression.getArguments());
		argumentEdges.put(argumentExprClaim, expression.getArguments());
		contractEdges.put(argumentExprClaim, expression.getContracts());
		argumentExprEdges.put(argumentExprClaim, expression.getNested());

		contractObjToClaim.put(expression, argumentExprClaim);
		return argumentExprClaim;
	}

	// --

	private class NodeCollector {
		public final Map<Contract, ContractNodes> contractNodes = new LinkedHashMap<>();
		public final Map<Argument, ArgumentNodes> argumentNodes = new LinkedHashMap<>();
		public final List<CodeAssumption> commonAssumptions = new ArrayList<>();
		public final List<Analysis> commonAnalyses = new ArrayList<>();

		public NodeCollector() {
			super();
		}

		public void collect(final VerificationPlan verificationPlan) {
			for (var contract : verificationPlan.getContracts()) {
				parentContract.put(contract, verificationPlan);
				collect(contract);
			}

			var assumptionOccurrences = new LinkedHashMap<CodeAssumption, Integer>();
			var analysisOccurrences = new HashMap<Analysis, Integer>();

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
					nodes.assumptions.add(codeAssumption);
				}
			}
			for (var analysis : contract.getAnalyses()) {
				nodes.analyses.add(analysis);
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
		public final Set<CodeAssumption> assumptions = new LinkedHashSet<>();
		public final Set<Analysis> analyses = new LinkedHashSet<>();
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
}
