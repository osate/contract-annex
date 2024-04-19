package org.osate.contract.gsn;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.osate.aadl2.NamedElement;
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;
import org.stringtemplate.v4.ST;

public final class YamlGsnGenerator {
	private YamlGsnGenerator() {
	}

	public static String generateYamlGsn(VerificationPlan verificationPlan) {
		var elements = new ArrayList<String>();
		elements.add(generateVerificationPlan(verificationPlan));
		for (var claim : verificationPlan.getClaims()) {
			elements.add(generateClaim(claim, verificationPlan));
		}
		for (var contract : verificationPlan.getContracts()) {
			elements.add(generateContract(contract));
			for (var assumption : contract.getAssumptions()) {
				if (assumption instanceof CodeAssumption codeAssumption) {
					elements.add(generateAssumption(codeAssumption));
				}
			}
			for (var analysis : contract.getAnalyses()) {
				elements.add(generateAnalysis(analysis));
			}
		}
		return elements.stream().collect(Collectors.joining("\n\n"));
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
		if (contract.getGuarantee() == null) {
			template.add("text", contract.getName());
		} else {
			var symbol = contract.isExact() ? "<=>" : "=>";
			template.add("text", symbol + ' ' + contract.getGuarantee().getCode().getSource());
		}

		var supportedBy = new ArrayList<String>();
		for (var analysis : contract.getAnalyses()) {
			supportedBy.add(getAnalysisName(analysis));
		}
		if (supportedBy.isEmpty()) {
			template.add("supportedBy", "");
		} else {
			template.add("supportedBy", supportedBy.stream().collect(Collectors.joining(", ", "supportedBy: [", "]")));
		}

		var inContextOf = new ArrayList<String>();
		for (var assumption : contract.getAssumptions()) {
			if (assumption instanceof CodeAssumption codeAssumption) {
				inContextOf.add(getAssumptionName(codeAssumption));
			}
		}
		if (inContextOf.isEmpty()) {
			template.add("inContextOf", "");
		} else {
			template.add("inContextOf", inContextOf.stream().collect(Collectors.joining(", ", "inContextOf: [", "]")));
		}

		if (supportedBy.isEmpty() && inContextOf.isEmpty()) {
			template.add("undeveloped", "undeveloped: true");
		} else {
			template.add("undeveloped", "");
		}

		// The result is trimmed because there could be an extra line ending at the end if %undeveloped% is blank.
		return template.render().trim();
	}

	private static String generateClaim(Source claim, VerificationPlan verificationPlan) {
		var template = new ST("""
				%name%:
				  text: %text%
				  nodeType: Assumption""", '%', '%');
		template.add("name", getClaimName(claim, verificationPlan));
		template.add("text", claim.getSource());
		return template.render();
	}

	private static String getClaimName(Source claim, VerificationPlan verificationPlan) {
		return verificationPlan.getName() + "_claim_" + (verificationPlan.getClaims().indexOf(claim) + 1);
	}

	private static String generateAnalysis(Analysis analysis) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Solution""", '%', '%');
		template.add("name", getAnalysisName(analysis));
		return template.render();
	}

	private static String getAnalysisName(Analysis analysis) {
		var source = analysis.getCode().getSource();
		var paren = source.indexOf('(');
		if (paren == -1) {
			return source;
		} else {
			return source.substring(0, paren);
		}
	}

	private static String generateAssumption(CodeAssumption assumption) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Assumption""", '%', '%');
		template.add("name", getAssumptionName(assumption));
		return template.render();
	}

	private static String getAssumptionName(CodeAssumption assumption) {
		var source = assumption.getCode().getSource();
		var paren = source.indexOf('(');
		if (paren == -1) {
			return source;
		} else {
			return source.substring(0, paren);
		}
	}
}