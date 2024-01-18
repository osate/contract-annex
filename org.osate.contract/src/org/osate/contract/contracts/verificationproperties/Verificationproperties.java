package org.osate.contract.contracts.verificationproperties;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.pluginsupport.properties.IntegerWithUnits;

public final class Verificationproperties {
	public static final String VERIFICATIONPROPERTIES__NAME = "VerificationProperties";

	private Verificationproperties() {}

	// Lookup methods for VerificationProperties::RequiredCount

	public static final String REQUIREDCOUNT__NAME = "RequiredCount";

	public static boolean acceptsRequiredcount(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRequiredcount_Property(lookupContext));
	}

	public static Optional<List<Countrecord>> getRequiredcount(NamedElement lookupContext) {
		return getRequiredcount(lookupContext, Optional.empty());
	}

	public static Optional<List<Countrecord>> getRequiredcount(NamedElement lookupContext, Mode mode) {
		return getRequiredcount(lookupContext, Optional.of(mode));
	}

	public static Optional<List<Countrecord>> getRequiredcount(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRequiredcount_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				return new Countrecord(resolved1, lookupContext, mode);
			}).collect(Collectors.toList()));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRequiredcount_Property(EObject lookupContext) {
		String name = VERIFICATIONPROPERTIES__NAME + "::" + REQUIREDCOUNT__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRequiredcount_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRequiredcount_Property(lookupContext));
	}

	// Lookup methods for VerificationProperties::RequiredPeriod

	public static final String REQUIREDPERIOD__NAME = "RequiredPeriod";

	public static boolean acceptsRequiredperiod(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getRequiredperiod_Property(lookupContext));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getRequiredperiod(NamedElement lookupContext) {
		return getRequiredperiod(lookupContext, Optional.empty());
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getRequiredperiod(NamedElement lookupContext, Mode mode) {
		return getRequiredperiod(lookupContext, Optional.of(mode));
	}

	public static Optional<IntegerWithUnits<TimeUnits>> getRequiredperiod(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getRequiredperiod_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(new IntegerWithUnits<>(resolved, TimeUnits.class));
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getRequiredperiod_Property(EObject lookupContext) {
		String name = VERIFICATIONPROPERTIES__NAME + "::" + REQUIREDPERIOD__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getRequiredperiod_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getRequiredperiod_Property(lookupContext));
	}

	// Lookup methods for VerificationProperties::Level

	public static final String LEVEL__NAME = "Level";

	public static boolean acceptsLevel(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getLevel_Property(lookupContext));
	}

	public static OptionalLong getLevel(NamedElement lookupContext) {
		return getLevel(lookupContext, Optional.empty());
	}

	public static OptionalLong getLevel(NamedElement lookupContext, Mode mode) {
		return getLevel(lookupContext, Optional.of(mode));
	}

	public static OptionalLong getLevel(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getLevel_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return OptionalLong.of(((IntegerLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return OptionalLong.empty();
		}
	}

	public static Property getLevel_Property(EObject lookupContext) {
		String name = VERIFICATIONPROPERTIES__NAME + "::" + LEVEL__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getLevel_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getLevel_Property(lookupContext));
	}
}
