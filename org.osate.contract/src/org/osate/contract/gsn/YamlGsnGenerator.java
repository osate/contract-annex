package org.osate.contract.gsn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
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
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;
import org.stringtemplate.v4.ST;

public final class YamlGsnGenerator {
	private YamlGsnGenerator() {
	}

	public static YamlFolder generateYamlGsn(VerificationPlan verificationPlan) {
		var files = new ArrayList<YamlFile>();

		var planNodes = new ArrayList<String>();
		planNodes.add(generateVerificationPlan(verificationPlan));
		for (var claim : verificationPlan.getClaims()) {
			planNodes.add(generateClaim(claim, verificationPlan));
		}
		files.add(new YamlFile(verificationPlan.getName(), planNodes));

		var collector = new NodeCollector(verificationPlan);
		collector.contractNodes.forEach((contract, contractNodes) -> {
			var nodes = new ArrayList<String>();
			nodes.add(generateContract(contract));
			for (var assumption : contractNodes.assumptions) {
				nodes.add(generateAssumption(assumption));
			}
			for (var analysis : contractNodes.analyses) {
				nodes.add(generateAnalysis(analysis));
			}
			files.add(new YamlFile(contract.getName(), nodes));
		});
		collector.argumentNodes.forEach((argument, argumentNodes) -> {
			var nodes = new ArrayList<String>();
			nodes.add(generateArgument(argument));
			for (var expression : argumentNodes.argumentExpressions) {
				nodes.add(generateArgumentExpression(expression));
			}
			files.add(new YamlFile(argument.getName(), nodes));
		});

		var commonNodes = new ArrayList<String>();
		for (var assumption : collector.commonAssumptions) {
			commonNodes.add(generateAssumption(assumption));
		}
		for (var analysis : collector.commonAnalyses) {
			commonNodes.add(generateAnalysis(analysis));
		}
		if (!commonNodes.isEmpty()) {
			files.add(new YamlFile("CommonNodes", commonNodes));
		}

		var aadlPackage = EcoreUtil2.getContainerOfType(verificationPlan, AadlPackage.class);
		var folderName = aadlPackage.getName() + "_" + verificationPlan.getName();
		return new YamlFolder(folderName, files);
	}

	private static String generateVerificationPlan(VerificationPlan verificationPlan) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Goal
				  %supportedBy%
				  %inContextOf%
				  %undeveloped%""", '%', '%');
		template.add("name", verificationPlan.getName());

		if (verificationPlan.getContracts().isEmpty() && verificationPlan.getClaims().isEmpty()) {
			template.add("undeveloped", "undeveloped: true");
		} else {
			template.add("undeveloped", "");
		}

		if (verificationPlan.getContracts().isEmpty()) {
			template.add("supportedBy", "");
		} else {
			var supportedBy = verificationPlan.getContracts()
					.stream()
					.map(NamedElement::getName)
					.distinct()
					.collect(Collectors.joining(", ", "supportedBy: [", "]"));
			template.add("supportedBy", supportedBy);
		}

		if (verificationPlan.getClaims().isEmpty()) {
			template.add("inContextOf", "");
		} else {
			var inContextOf = verificationPlan.getClaims()
					.stream()
					.map(claim -> getClaimName(claim, verificationPlan))
					.collect(Collectors.joining(", ", "inContextOf: [", "]"));
			template.add("inContextOf", inContextOf);
		}

		// The result is trimmed because there could be an extra line ending at the end if %undeveloped% is blank.
		return template.render().trim();
	}

	private static String generateContract(Contract contract) {
		var template = new ST("""
				%name%:
				  text: %text%
				  nodeType: Goal
				  %supportedBy%
				  %inContextOf%
				  %undeveloped%""", '%', '%');

		template.add("name", contract.getName());

		var guarantee = contract.getGuarantee();
		if (guarantee == null) {
			template.add("text", contract.getName());
		} else {
			var symbol = contract.isExact() ? "<=>" : "=>";
			var source = toString(guarantee.getCode());
			template.add("text", symbol + ' ' + source);
		}

		var supportedBy = new ArrayList<String>();
		var inContextOf = new ArrayList<String>();

		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				supportedBy.add(referencedContract.getName());
			} else if (assumption instanceof ArgumentAssumption argumentAssumption
					&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
				supportedBy.add(referencedArgument.getName());
			} else if (assumption instanceof CodeAssumption codeAssumption) {
				inContextOf.add(getAssumptionName(codeAssumption));
			}
		}
		for (var analysis : contract.getAnalyses()) {
			supportedBy.add(getAnalysisName(analysis));
		}

		if (supportedBy.isEmpty()) {
			template.add("supportedBy", "");
		} else {
			template.add("supportedBy",
					supportedBy.stream().distinct().collect(Collectors.joining(", ", "supportedBy: [", "]")));
		}

		if (inContextOf.isEmpty()) {
			template.add("inContextOf", "");
		} else {
			template.add("inContextOf",
					inContextOf.stream().distinct().collect(Collectors.joining(", ", "inContextOf: [", "]")));
		}

		if (supportedBy.isEmpty() && inContextOf.isEmpty()) {
			template.add("undeveloped", "undeveloped: true");
		} else {
			template.add("undeveloped", "");
		}

		// The result is trimmed because there could be an extra line ending at the end if %undeveloped% is blank.
		return template.render().trim();
	}

	private static String generateArgument(Argument argument) {
		var template = new ST("""
				%name%:
				  text: %text%
				  nodeType: Goal
				  %supportedBy%
				  %undeveloped%""", '%', '%');

		template.add("name", argument.getName());

		var guarantee = argument.getGuarantee();
		if (guarantee == null) {
			template.add("text", argument.getName());
		} else {
			var symbol = argument.isExact() ? "<=>" : "=>";
			var source = toString(guarantee.getCode());
			template.add("text", symbol + ' ' + source);
		}

		var supportedBy = new ArrayList<String>();

		if (argument.getArgumentExpression() != null) {
			supportedBy.add(getArgumentExpressionName(argument, argument.getArgumentExpression()));
		}

		if (supportedBy.isEmpty()) {
			template.add("supportedBy", "");
			template.add("undeveloped", "undeveloped: true");
		} else {
			template.add("supportedBy",
					supportedBy.stream().distinct().collect(Collectors.joining(", ", "supportedBy: [", "]")));
			template.add("undeveloped", "");
		}

		// The result is trimmed because there could be an extra line ending at the end if %undeveloped% is blank.
		return template.render().trim();
	}

	private static String generateArgumentExpression(ArgumentExpression expression) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Goal
				  supportedBy: [%supportedBy%]""", '%', '%');

		var containingArgument = EcoreUtil2.getContainerOfType(expression, Argument.class);

		template.add("name", getArgumentExpressionName(containingArgument, expression));

		var supportedBy = new ArrayList<String>();
		for (var argument : expression.getArguments()) {
			supportedBy.add(argument.getName());
		}
		for (var contract : expression.getContracts()) {
			supportedBy.add(contract.getName());
		}
		for (var nested : expression.getNested()) {
			supportedBy.add(getArgumentExpressionName(containingArgument, nested));
		}
		template.add("supportedBy", supportedBy.stream().collect(Collectors.joining(", ")));

		return template.render();
	}

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

		return argument.getName() + '_' + expressionType + '_' + (index + 1);
	}

	private static String generateClaim(Source claim, VerificationPlan verificationPlan) {
		var template = new ST("""
				%name%:
				  text: %text%
				  nodeType: Assumption""", '%', '%');
		template.add("name", getClaimName(claim, verificationPlan));
		template.add("text", toString(claim));
		return template.render();
	}

	private static String getClaimName(Source claim, VerificationPlan verificationPlan) {
		return verificationPlan.getName() + "_claim_" + (verificationPlan.getClaims().indexOf(claim) + 1);
	}

	private static String generateAssumption(String name) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Assumption""", '%', '%');
		template.add("name", name);
		return template.render();
	}

	private static String getAssumptionName(CodeAssumption assumption) {
		return trimParens(toString(assumption.getCode()));
	}

	private static String generateAnalysis(String name) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Solution
				  url: eclipse+gsnmarker://%name%""",
				'%', '%');
		template.add("name", name);
		return template.render();
	}

	private static String getAnalysisName(Analysis analysis) {
		return trimParens(toString(analysis.getCode()));
	}

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

	private static String trimParens(String s) {
		var paren = s.indexOf('(');
		if (paren == -1) {
			return s;
		} else {
			return s.substring(0, paren);
		}
	}

	private static class NodeCollector {
		public final Map<Contract, ContractNodes> contractNodes = new LinkedHashMap<>();
		public final Map<Argument, ArgumentNodes> argumentNodes = new LinkedHashMap<>();
		public final List<String> commonAssumptions = new ArrayList<>();
		public final List<String> commonAnalyses = new ArrayList<>();

		public NodeCollector(VerificationPlan verificationPlan) {
			for (var contract : verificationPlan.getContracts()) {
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

		private void collect(Contract contract) {
			var nodes = contractNodes.computeIfAbsent(contract, key -> new ContractNodes());
			for (var assumption : contract.getAssumptions()) {
				if (assumption instanceof ContractAssumption contractAssumption
						&& contractAssumption.getContract() instanceof Contract referencedContract) {
					collect(referencedContract);
				} else if (assumption instanceof ArgumentAssumption argumentAssumption
						&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
					collect(referencedArgument);
				} else if (assumption instanceof CodeAssumption codeAssumption) {
					nodes.assumptions.add(getAssumptionName(codeAssumption));
				}
			}
			for (var analysis : contract.getAnalyses()) {
				nodes.analyses.add(getAnalysisName(analysis));
			}
		}

		private void collect(Argument argument) {
			var nodes = argumentNodes.computeIfAbsent(argument, key -> new ArgumentNodes());
			if (argument.getArgumentExpression() != null) {
				collect(argument.getArgumentExpression(), nodes);
			}
		}

		private void collect(ArgumentExpression expression, ArgumentNodes nodes) {
			nodes.argumentExpressions.add(expression);
			for (var referencedArgument : expression.getArguments()) {
				if (referencedArgument instanceof Argument castedArgument) {
					collect(castedArgument);
				}
			}
			for (var referencedContract : expression.getContracts()) {
				if (referencedContract instanceof Contract castedContract) {
					collect(castedContract);
				}
			}
			for (var nested : expression.getNested()) {
				collect(nested, nodes);
			}
		}
	}

	private static class ContractNodes {
		public final Set<String> assumptions = new LinkedHashSet<>();
		public final Set<String> analyses = new LinkedHashSet<>();
	}

	private static class ArgumentNodes {
		public final Set<ArgumentExpression> argumentExpressions = new LinkedHashSet<>();
	}
}