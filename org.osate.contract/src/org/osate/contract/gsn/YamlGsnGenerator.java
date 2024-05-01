package org.osate.contract.gsn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.osate.aadl2.NamedElement;
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAssumption;
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
		var assumptions = new LinkedHashSet<String>();
		var analyses = new LinkedHashSet<String>();
		for (var contract : verificationPlan.getContracts()) {
			collectNodes(contract, contracts, arguments, assumptions, analyses);
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
		for (var assumption : assumptions) {
			nodes.add(generateAssumption(assumption));
		}
		for (var analysis : analyses) {
			nodes.add(generateAnalysis(analysis));
		}

		return nodes.stream().collect(Collectors.joining("\n\n"));
	}

	private static void collectNodes(Contract contract, Collection<Contract> contracts, Collection<Argument> arguments,
			Collection<String> assumptions, Collection<String> analyses) {
		contracts.add(contract);
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof ContractAssumption contractAssumption
					&& contractAssumption.getContract() instanceof Contract referencedContract) {
				collectNodes(referencedContract, contracts, arguments, assumptions, analyses);
			} else if (assumption instanceof ArgumentAssumption argumentAssumption
					&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
				arguments.add(referencedArgument);
			} else if (assumption instanceof CodeAssumption codeAssumption) {
				assumptions.add(getAssumptionName(codeAssumption));
			}
		}
		for (var analysis : contract.getAnalyses()) {
			analyses.add(getAnalysisName(analysis));
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
				  undeveloped: true""", '%', '%');
		template.add("name", argument.getName());
		var guarantee = argument.getGuarantee();
		if (guarantee == null) {
			template.add("text", argument.getName());
		} else {
			var symbol = argument.isExact() ? "<=>" : "=>";
			var source = toString(guarantee.getCode());
			template.add("text", symbol + ' ' + source);
		}
		return template.render();
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