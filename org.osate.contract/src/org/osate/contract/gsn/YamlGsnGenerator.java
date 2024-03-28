package org.osate.contract.gsn;

import org.osate.contract.contract.VerificationPlan;

public final class YamlGsnGenerator {
	private YamlGsnGenerator() {
	}

	public static String generateYamlGsn(VerificationPlan verificationPlan) {
		var contents = verificationPlan.getName() + ":\n";
		contents += "  text: " + verificationPlan.getName() + '\n';
		contents += "  nodeType: Goal\n";
		contents += "  undeveloped: true";
		return contents;
	}
}