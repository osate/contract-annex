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

import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.sysml.lang.sysml.AttributeUsage;
import org.omg.sysml.lang.sysml.FeatureReferenceExpression;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.LiteralRational;
import org.omg.sysml.lang.sysml.OperatorExpression;
import org.osate.sysmlv2.contract.contract.Expression;

public final class TimeType implements Type {
	public static final TimeType INSTANCE = new TimeType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("scaledTo", new ScaledToMember());
	}

	public TimeType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public boolean supportsAttributeLookup() {
		return false;
	}

	@Override
	public String toString() {
		return "Time";
	}

	private static class ScaledToMember implements MemberWithArgument<AttributeValueHolder, Double, AttributeUsage> {
		@Override
		public Type getReturnType(final Expression argument) {
			return DoubleType.INSTANCE;
		}
	
		@Override
		public Double evaluate(final AttributeValueHolder avh, final AttributeUsage unitUsage) {
			/*
			 * Assumes the following pattern in the attribute usage:
			 * 
			 *   :>> Period = 500 [micro * s];
			 *   
			 * Note: Currently does not support just "1 [s]", would have to use "1000 [milli * s]" 
			 */
			final FeatureValue featureValue = (FeatureValue) avh.getElement();
			if (featureValue.getValue() instanceof OperatorExpression operatorExpression
					&& operatorExpression.getOperator().equals("[")
					&& operatorExpression.getOperand().size() == 2
					&& operatorExpression.getOperand().get(0) instanceof LiteralInteger literal) {
				final int coefficient = literal.getValue();
				
				if (operatorExpression.getOperand().get(1) instanceof OperatorExpression operatorExpression2
						&& operatorExpression2.getOperator().equals("*")
						&& operatorExpression2.getOperand().size() == 2
						&& operatorExpression2.getOperand().get(1) instanceof FeatureReferenceExpression featureReference
						&& featureReference.getReferent().getQualifiedName().equals("SI::second")
						&& operatorExpression2.getOperand().get(0) instanceof FeatureReferenceExpression featureReference2
						&& featureReference2.getReferent() instanceof AttributeUsage attrUsage) {
					final double sourceFactor = getConversionFactor(attrUsage);
					final double destFactor = getConversionFactor(unitUsage);
					return Double.valueOf(coefficient * (sourceFactor / destFactor));
				}
			}
			throw new IllegalArgumentException(
					"Attribute usage does not follow pattern: '::> attr = <value> [<prefix> * s]'");
		}
		
		public static double getConversionFactor(final AttributeUsage attrUsage) {
			for (var fm: attrUsage.getOwnedFeatureMembership()) {
				var ownedF = fm.getOwnedMemberFeature();
				if (ownedF.effectiveName().equals("conversionFactor")) {
					for (var relationship : ownedF.getOwnedRelationship()) {
						if (relationship instanceof FeatureValue featureValue10) {
							var factor = ((LiteralRational) featureValue10.getValue()).getValue();
							return factor;
						}
					}
				}
			}
			throw new IllegalArgumentException("Cannot find 'conversionFactor' in attribute usage");
		}
	}
}