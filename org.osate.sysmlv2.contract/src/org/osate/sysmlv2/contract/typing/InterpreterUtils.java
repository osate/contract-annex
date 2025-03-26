package org.osate.sysmlv2.contract.typing;

import java.util.Optional;

import org.omg.sysml.lang.sysml.AttributeDefinition;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.OccurrenceDefinition;

public final class InterpreterUtils {
	private InterpreterUtils() { super(); }
	
	public static Optional<FeatureValue> lookupAttributeValue(final OccurrenceDefinition component, final AttributeDefinition attribute) {
		System.out.println("component = " + component.getDeclaredName());
		for (var refUsage : component.getOwnedReference()) {
			System.out.println("- owned ref = " + refUsage.effectiveName());
			for (var usageDef : refUsage.getDefinition()) {
				System.out.println("+ def = " + usageDef.effectiveName());
				if (usageDef.equals(attribute)) {
					// Found it!
					for (var relationship : refUsage.getOwnedRelationship()) {
						if (relationship instanceof FeatureValue featureValue) {
							return Optional.of(featureValue);
						}
					}
				}
			}
		}
		
		return Optional.empty();
	}
}
