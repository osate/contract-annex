package org.osate.sysmlv2.contract.typing;

import java.util.Optional;

import org.omg.sysml.lang.sysml.AttributeDefinition;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.OccurrenceDefinition;

public final class InterpreterUtils {
	private InterpreterUtils() { super(); }
	
	public static Optional<AttributeValueHolder> lookupAttributeValue(
			final OccurrenceDefinition component, final AttributeDefinition attribute, final Type optionalType) {
//		System.out.println("component = " + component.getDeclaredName());
		for (var refUsage : component.getOwnedReference()) {
//			System.out.println("- owned ref = " + refUsage.effectiveName());
			for (var usageDef : refUsage.getDefinition()) {
//				System.out.println("+ def = " + usageDef.effectiveName());
				if (usageDef.equals(attribute)) {
					// Found it!
					var propType = ((OptionalType) optionalType).getElementType();
					if (propType.equals(PriorityType.INSTANCE)
							|| propType.equals(TimeType.INSTANCE)) {
						for (var relationship : refUsage.getOwnedRelationship()) {
							if (relationship instanceof FeatureValue featureValue) {
								return Optional.of(new AttributeValueHolder(featureValue));
							}
						}
					} else if (propType.equals(TimeRangeType.INSTANCE)) {
						return Optional.of(new AttributeValueHolder(refUsage));
					} else {
						throw new IllegalArgumentException("Cannot look up attribute values of type " + optionalType);
					}
				}
			}
		}
		
		return Optional.empty();
	}
}
