package org.osate.contract.gsn;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.osate.aadl2.NamedElement;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.VerificationPlan;
import org.stringtemplate.v4.ST;

public final class YamlGsnGenerator {
	private YamlGsnGenerator() {
	}

	public static String generateYamlGsn(VerificationPlan verificationPlan) {
		var elements = new ArrayList<String>();
		elements.add(generateVerificationPlan(verificationPlan));
		for (var contract : verificationPlan.getContracts()) {
			elements.add(generateContract(contract));
		}
		return elements.stream().collect(Collectors.joining("\n\n"));
	}

	private static String generateVerificationPlan(VerificationPlan verificationPlan) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Goal
				  %supportedBy%
				  %undeveloped%""", '%', '%');
		template.add("name", verificationPlan.getName());
		if (verificationPlan.getContracts().isEmpty()) {
			template.add("supportedBy", "");
			template.add("undeveloped", "undeveloped: true");
		} else {
			var supportedBy = verificationPlan.getContracts()
					.stream()
					.map(NamedElement::getName)
					.collect(Collectors.joining(", ", "supportedBy: [", "]"));
			template.add("supportedBy", supportedBy);
			template.add("undeveloped", "");
		}
		// The result is trimmed because there could be an extra line ending at the end if %undeveloped% is blank.
		return template.render().trim();
	}

	private static String generateContract(Contract contract) {
		var template = new ST("""
				%name%:
				  text: %name%
				  nodeType: Goal
				  undeveloped: true""", '%', '%');
		template.add("name", contract.getName());
		return template.render();
	}
}