package org.osate.contract.gsn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.eclipse.xtext.EcoreUtil2;
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

	public static String generateYamlGsn(VerificationPlan verificationPlan) {
		var contracts = new LinkedHashSet<Contract>();
		var arguments = new LinkedHashSet<Argument>();
		var argumentExpressions = new LinkedHashSet<ArgumentExpression>();
		var assumptions = new LinkedHashSet<String>();
		var analyses = new LinkedHashSet<String>();
		for (var contract : verificationPlan.getContracts()) {
			collectNodes(contract, contracts, arguments, argumentExpressions, assumptions, analyses);
		}

		var nodes = new ArrayList<String>();
		nodes.add(generateVerificationPlan(verificationPlan));
		for (var claim : verificationPlan.getClaims()) {
			nodes.add(generateClaim(claim, verificationPlan));
		}
		for (var contract : contracts) {
			nodes.add(generateContract(contract));
		}
		for (var argument : arguments) {
			nodes.add(generateArgument(argument));
		}
		for (var expression : argumentExpressions) {
			nodes.add(generateArgumentExpression(expression));
		}
		for (var assumption : assumptions) {
			nodes.add(generateAssumption(assumption));
		}
		for (var analysis : analyses) {
			nodes.add(generateAnalysis(analysis));
		}

		return nodes.stream().collect(Collectors.joining("\n\n"));
	}

	private static void collectNodes(Contract contract, Collection<Contract> contracts, Collection<Argument> arguments,
			Collection<ArgumentExpression> argumentExpressions, Collection<String> assumptions,
			Collection<String> analyses) {
		contracts.add(contract);
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				collectNodes(referencedContract, contracts, arguments, argumentExpressions, assumptions, analyses);
			} else if (assumption instanceof ArgumentAssumption argumentAssumption
					&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
				collectNodes(referencedArgument, contracts, arguments, argumentExpressions, assumptions, analyses);
			} else if (assumption instanceof CodeAssumption codeAssumption) {
				assumptions.add(getAssumptionName(codeAssumption));
			}
		}
		for (var analysis : contract.getAnalyses()) {
			analyses.add(getAnalysisName(analysis));
		}
	}

	private static void collectNodes(Argument argument, Collection<Contract> contracts, Collection<Argument> arguments,
			Collection<ArgumentExpression> argumentExpressions, Collection<String> assumptions,
			Collection<String> analyses) {
		arguments.add(argument);
		if (argument.getArgumentExpression() != null) {
			collectNodes(argument.getArgumentExpression(), contracts, arguments, argumentExpressions, assumptions,
					analyses);
		}
	}

	private static void collectNodes(ArgumentExpression expression, Collection<Contract> contracts,
			Collection<Argument> arguments, Collection<ArgumentExpression> argumentExpressions,
			Collection<String> assumptions, Collection<String> analyses) {
		argumentExpressions.add(expression);
		for (var referencedArgument : expression.getArguments()) {
			if (referencedArgument instanceof Argument castedArgument) {
				collectNodes(castedArgument, contracts, arguments, argumentExpressions, assumptions, analyses);
			}
		}
		for (var referencedContract : expression.getContracts()) {
			if (referencedContract instanceof Contract castedContract) {
				collectNodes(castedContract, contracts, arguments, argumentExpressions, assumptions, analyses);
			}
		}
		for (var nested : expression.getNested()) {
			collectNodes(nested, contracts, arguments, argumentExpressions, assumptions, analyses);
		}
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
			return "TODO: or";
		} else if (expression instanceof ArgumentNot) {
			return "TODO: not";
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
				  nodeType: Solution""", '%', '%');
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
}