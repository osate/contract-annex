/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and
 * unlimited distribution.  Please see Copyright notice for non-US Government use and
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
package org.osate.sysmlv2.contract.typing;

import java.util.ArrayList;
import java.util.Optional;

import org.omg.sysml.lang.sysml.AttributeDefinition;
import org.omg.sysml.lang.sysml.Usage;


public final class TypeSystemUtils {
	public static final String SEPARATOR = "::";

	public static final String AADL_LIB = "AADL";
	public static final String AADL_PROPERTY = AADL_LIB + SEPARATOR + "Property";
	
	public static final String AADL_PROJECT_LIB = "AADL_Project";
	public static final String TIME = AADL_PROJECT_LIB + SEPARATOR + "Time";
	public static final String TIME_RANGE = AADL_PROJECT_LIB + SEPARATOR + "Time_Range";
	public static final String SUPPORTED_DISPATCH_PROTOCOLS = AADL_PROJECT_LIB + SEPARATOR + "Supported_Dispatch_Protocols";

	public static final String SCALAR_VALUES_LIB = "ScalarValues";
	public static final String LONG = SCALAR_VALUES_LIB + SEPARATOR + "Integer";
	
	public static final String MEASUREMENT_REFERENCES_LIB = "MeasurementReferences";
	public static final String UNIT_PREFIX = MEASUREMENT_REFERENCES_LIB + SEPARATOR + "UnitPrefix";
	
	
	
	private TypeSystemUtils() {
	}

	public static Type convertPropertyType(final AttributeDefinition attrDef) {
		final Type t;
		if (attrDef.specializesFromLibrary(AADL_PROPERTY)) {
			System.out.println("Attribute def: " + attrDef.getQualifiedName());
			System.out.println("  supertypes");
			for (var x : attrDef.supertypes(true)) {
				System.out.println ("    " + x.getQualifiedName());
			}
			System.out.println("  all supertypes");
			for (var x : attrDef.allSupertypes()) {
				System.out.println ("    " + x.getQualifiedName());
			}
			System.out.println();
			
			if (attrDef.specializesFromLibrary(TIME)) {
				t = TimeType.INSTANCE;
			} else if (attrDef.specializesFromLibrary(TIME_RANGE)) {
				t = TimeRangeType.INSTANCE;
			} else if (attrDef.specializesFromLibrary(SUPPORTED_DISPATCH_PROTOCOLS)) {
				t = SupportedDispatchProtocolsType.INSTANCE;
			} else if (attrDef.specializesFromLibrary(LONG)) {
				t = LongType.INSTANCE;
			} else {
				throw new RuntimeException("Unknown type for attribute definition '" +
						attrDef.getQualifiedName() + "'");
			}
//			
//			t = BooleanType.INSTANCE;
		} else {
			throw new RuntimeException("Attribute definition '" +
					attrDef.getQualifiedName() +
					"' does not specialize 'AADL::Property'");
		}
		return t;
	}
	
	public static Type typeOfUsage(final Usage usage) {
		if (usage.specializesFromLibrary(UNIT_PREFIX)) {
			return UnitType.INSTANCE;
		} else {
			return null;
		}
	}

	//
//	public static Type convertPropertyType(PropertyType propertyType) {
//		if (propertyType instanceof AadlBoolean) {
//			return BooleanType.INSTANCE;
//		} else if (propertyType instanceof AadlString) {
//			return StringType.INSTANCE;
//		} else if (propertyType instanceof org.osate.aadl2.ClassifierType) {
//			return ClassifierType.INSTANCE;
//		} else if (propertyType instanceof org.osate.aadl2.EnumerationType enumType) {
//			return new EnumerationType(enumType);
//		} else if (propertyType instanceof AadlInteger aadlInteger) {
//			if (aadlInteger.getUnitsType() == null) {
//				return LongType.INSTANCE;
//			} else {
//				return new LongWithUnitsType(aadlInteger.getUnitsType());
//			}
//		} else if (propertyType instanceof AadlReal aadlReal) {
//			if (aadlReal.getUnitsType() == null) {
//				return DoubleType.INSTANCE;
//			} else {
//				return new DoubleWithUnitsType(aadlReal.getUnitsType());
//			}
//		} else if (propertyType instanceof RangeType rangeType) {
//			var numberType = rangeType.getNumberType();
//			if (numberType instanceof AadlInteger aadlInteger) {
//				if (aadlInteger.getUnitsType() == null) {
//					return LongRangeType.INSTANCE;
//				} else {
//					return new LongRangeWithUnitsType(aadlInteger.getUnitsType());
//				}
//			} else if (numberType instanceof AadlReal aadlReal) {
//				if (aadlReal.getUnitsType() == null) {
//					return DoubleRangeType.INSTANCE;
//				} else {
//					return new DoubleRangeWithUnitsType(aadlReal.getUnitsType());
//				}
//			} else {
//				throw new RuntimeException(
//						"Unexpected number type '" + numberType + "' for range type '" + rangeType + "'.");
//			}
//		} else if (propertyType instanceof org.osate.aadl2.RecordType recordType) {
//			return new RecordType(recordType);
//		} else if (propertyType instanceof ReferenceType) {
//			return InstanceObjectType.INSTANCE;
//		} else if (propertyType instanceof org.osate.aadl2.ListType listType) {
//			return new ListType(convertPropertyType(listType.getElementType()));
//		} else {
//			throw new RuntimeException("Unexpected property type '" + propertyType + "'.");
//		}
//	}
//
//	public static Object convertPropertyValue(PropertyExpression value, NamedElement lookupContext) {
//		if (value instanceof BooleanLiteral booleanLiteral) {
//			return booleanLiteral.getValue();
//		} else if (value instanceof StringLiteral stringLiteral) {
//			return stringLiteral.getValue();
//		} else if (value instanceof ClassifierValue classifierValue) {
//			return classifierValue.getClassifier();
//		} else if (value instanceof NamedValue namedValue) {
//			return namedValue.getNamedValue();
//		} else if (value instanceof IntegerLiteral integerLiteral && integerLiteral.getUnit() == null) {
//			return integerLiteral.getValue();
//		} else if (value instanceof RealLiteral realLiteral && realLiteral.getUnit() == null) {
//			return realLiteral.getValue();
//		} else if (value instanceof NumberValue numberValue) {
//			return numberValue;
//		} else if (value instanceof RangeValue rangeValue) {
//			return new RangeValueHolder(rangeValue, lookupContext);
//		} else if (value instanceof RecordValue recordValue) {
//			return new RecordValueHolder(recordValue, lookupContext);
//		} else if (value instanceof InstanceReferenceValue instanceReferenceValue) {
//			return instanceReferenceValue.getReferencedInstanceObject();
//		} else if (value instanceof ListValue listValue) {
//			var result = new ArrayList<>();
//			for (var element : listValue.getOwnedListElements()) {
//				var resolved = CodeGenUtil.resolveNamedValue(element, lookupContext, Optional.empty());
//				result.add(convertPropertyValue(resolved, lookupContext));
//			}
//			return result;
//		} else {
//			throw new RuntimeException("Unexpected property expression '" + value + "'.");
//		}
//	}
//
//	public static String generateName(PropertyType unnamedType) {
//		if (unnamedType.getName() != null) {
//			throw new IllegalArgumentException(
//					"generateName is meant to be used with a PropertyType that does not have a name.");
//		}
//		var builder = new StringBuilder();
//		for (var current = unnamedType.eContainer(); current != null; current = current.eContainer()) {
//			if (current instanceof Property property) {
//				builder.insert(0, property.getQualifiedName());
//				break;
//			} else if (current instanceof PropertyType propertyType && propertyType.getName() != null) {
//				builder.insert(0, propertyType.getQualifiedName());
//				break;
//			} else if (current instanceof BasicProperty field) {
//				builder.insert(0, field.getName());
//				builder.insert(0, '.');
//			}
//		}
//		return builder.toString();
//	}
}