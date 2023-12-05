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
package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordField;
import org.osate.aadl2.UnitsType;

public final class DoubleRangeWithUnitsType implements Type {
	private final UnitsType unitsType;
	private final Map<String, Member> members;
	private final String label;

	public DoubleRangeWithUnitsType(UnitsType unitsType) {
		this.unitsType = unitsType;

		members = new LinkedHashMap<>();
		members.put("minimum", new MinimumMember());
		members.put("maximum", new MaximumMember());
		members.put("getDelta", new GetDeltaMember());

		if (unitsType.getName() != null) {
			label = "DoubleRangeWithUnits<" + unitsType.getQualifiedName() + '>';
		} else {
			var builder = new StringBuilder();
			for (var current = unitsType.eContainer(); current != null; current = current.eContainer()) {
				if (current instanceof RecordField field) {
					builder.insert(0, field.getName());
					builder.insert(0, '.');
				} else if (current instanceof Property property) {
					builder.insert(0, property.getQualifiedName());
					break;
				} else if (current instanceof PropertyType propertyType && propertyType.getName() != null) {
					builder.insert(0, propertyType.getQualifiedName());
					break;
				}
			}
			builder.insert(0, "DoubleRangeWithUnnamedUnits<");
			builder.append('>');
			label = builder.toString();
		}
	}

	@Override
	public Map<String, Member> getMembers() {
		return members;
	}

	@Override
	public String toString() {
		return label;
	}

	private class MinimumMember implements SimpleMember<RangeValueHolder, RealLiteral> {
		@Override
		public Type getReturnType() {
			return new DoubleWithUnitsType(unitsType);
		}

		@Override
		public RealLiteral evaluate(RangeValueHolder receiver) {
			return (RealLiteral) receiver.getMinimum();
		}
	}

	private class MaximumMember implements SimpleMember<RangeValueHolder, RealLiteral> {
		@Override
		public Type getReturnType() {
			return new DoubleWithUnitsType(unitsType);
		}

		@Override
		public RealLiteral evaluate(RangeValueHolder receiver) {
			return (RealLiteral) receiver.getMaximum();
		}
	}

	private class GetDeltaMember implements SimpleMember<RangeValueHolder, Optional<RealLiteral>> {
		@Override
		public Type getReturnType() {
			return new OptionalType(new DoubleWithUnitsType(unitsType));
		}

		@Override
		public Optional<RealLiteral> evaluate(RangeValueHolder receiver) {
			return Optional.ofNullable(receiver.getDelta()).map(RealLiteral.class::cast);
		}
	}
}