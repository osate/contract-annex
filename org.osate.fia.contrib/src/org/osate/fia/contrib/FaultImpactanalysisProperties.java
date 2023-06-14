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
package org.osate.fia.contrib;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class FaultImpactanalysisProperties {
	public static final String FAULTIMPACTANALYSISPROPERTIES__NAME = "FaultImpactAnalysisProperties";

	private FaultImpactanalysisProperties() {
	}

	// Lookup methods for FaultImpactAnalysisProperties::Acceptable

	public static final String ACCEPTABLE__NAME = "Acceptable";

	public static boolean acceptsAcceptable(NamedElement lookupContext) {
		return lookupContext.acceptsProperty(getAcceptable_Property(lookupContext));
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext) {
		return getAcceptable(lookupContext, Optional.empty());
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext, Mode mode) {
		return getAcceptable(lookupContext, Optional.of(mode));
	}

	public static Optional<Boolean> getAcceptable(NamedElement lookupContext, Optional<Mode> mode) {
		Property property = getAcceptable_Property(lookupContext);
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of(((BooleanLiteral) resolved).getValue());
		} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
			return Optional.empty();
		}
	}

	public static Property getAcceptable_Property(EObject lookupContext) {
		String name = FAULTIMPACTANALYSISPROPERTIES__NAME + "::" + ACCEPTABLE__NAME;
		return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
	}

	public static PropertyExpression getAcceptable_EObject(NamedElement lookupContext) {
		return lookupContext.getNonModalPropertyValue(getAcceptable_Property(lookupContext));
	}
}

