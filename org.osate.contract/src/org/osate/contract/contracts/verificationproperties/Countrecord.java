package org.osate.contract.contracts.verificationproperties;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.GeneratedRecord;

public class Countrecord extends GeneratedRecord {
	public static final String CLAZZ__NAME = "clazz";
	public static final String BOUND__NAME = "bound";
	public static final URI CLAZZ__URI = URI.createURI("platform:/resource/Full_Security_Example/VerificationProperties.aadl#/0/@ownedPropertyType.0/@ownedField.0");
	public static final URI BOUND__URI = URI.createURI("platform:/resource/Full_Security_Example/VerificationProperties.aadl#/0/@ownedPropertyType.0/@ownedField.1");

	private final Optional<Classifier> clazz;
	private final OptionalLong bound;

	public Countrecord(
			Optional<Classifier> clazz,
			OptionalLong bound
	) {
		this.clazz = clazz;
		this.bound = bound;
	}

	public Countrecord(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
		RecordValue recordValue = (RecordValue) propertyExpression;

		Optional<Classifier> clazz_local;
		try {
			clazz_local = findFieldValue(recordValue, CLAZZ__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((ClassifierValue) resolved).getClassifier();
			});
		} catch (PropertyNotPresentException e) {
			clazz_local = Optional.empty();
		}
		this.clazz = clazz_local;

		OptionalLong bound_local;
		try {
			bound_local = findFieldValue(recordValue, BOUND__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			bound_local = OptionalLong.empty();
		}
		this.bound = bound_local;
	}

	public Countrecord(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;

		Optional<Classifier> clazz_local;
		try {
			clazz_local = findFieldValue(recordValue, CLAZZ__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((ClassifierValue) resolved).getClassifier();
			});
		} catch (PropertyNotPresentException e) {
			clazz_local = Optional.empty();
		}
		this.clazz = clazz_local;

		OptionalLong bound_local;
		try {
			bound_local = findFieldValue(recordValue, BOUND__NAME).map(field -> {
				PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				return ((IntegerLiteral) resolved).getValue();
			}).map(OptionalLong::of).orElse(OptionalLong.empty());
		} catch (PropertyNotPresentException e) {
			bound_local = OptionalLong.empty();
		}
		this.bound = bound_local;
	}

	public Optional<Classifier> getClazz() {
		return clazz;
	}

	public OptionalLong getBound() {
		return bound;
	}

	@Override
	public RecordValue toPropertyExpression(ResourceSet resourceSet) {
		if (!clazz.isPresent()
				&& !bound.isPresent()
		) {
			throw new IllegalStateException("Record must have at least one field set.");
		}
		RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
		clazz.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, CLAZZ__URI, CLAZZ__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		bound.ifPresent(field -> {
			BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
			fieldAssociation.setProperty(loadField(resourceSet, BOUND__URI, BOUND__NAME));
			fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
		});
		return recordValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				clazz,
				bound
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Countrecord)) {
			return false;
		}
		Countrecord other = (Countrecord) obj;
		return Objects.equals(this.clazz, other.clazz)
				&& Objects.equals(this.bound, other.bound);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.clazz.ifPresent(field -> {
			builder.append(CLAZZ__NAME);
			builder.append(" => classifier (");
			builder.append(field.getQualifiedName());
			builder.append(");");
		});
		this.bound.ifPresent(field -> {
			builder.append(BOUND__NAME);
			builder.append(" => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
