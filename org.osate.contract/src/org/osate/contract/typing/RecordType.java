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

import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RecordField;
import org.osate.contract.contract.Expression;
import org.osate.contract.contract.NameReference;
import org.osate.pluginsupport.properties.CodeGenUtil;

public final class RecordType implements Type {
	private final org.osate.aadl2.RecordType recordType;
	private final Map<String, Member> members;
	private final String label;

	public RecordType(org.osate.aadl2.RecordType recordType) {
		this.recordType = recordType;

		members = new LinkedHashMap<>();
		members.put("get", new GetMember());

		if (recordType.getName() != null) {
			label = "Record<" + recordType.getQualifiedName() + '>';
		} else {
			var builder = new StringBuilder();
			for (var current = recordType.eContainer(); current != null; current = current.eContainer()) {
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
			builder.insert(0, "UnnamedRecord<");
			builder.append('>');
			label = builder.toString();
		}
	}

	public org.osate.aadl2.RecordType getRecordType() {
		return recordType;
	}

	@Override
	public Map<String, Member> getMembers() {
		return members;
	}

	@Override
	public String toString() {
		return label;
	}

	private static class GetMember implements MemberWithArgument<RecordValueHolder, Optional<?>, BasicProperty> {
		@Override
		public Type getReturnType(Expression argument) {
			if (argument instanceof NameReference reference
					&& reference.getReference() instanceof BasicProperty field) {
				return new OptionalType(TypeSystemUtils.convertPropertyType(field.getPropertyType()));
			} else {
				return null;
			}
		}

		@Override
		public Optional<?> evaluate(RecordValueHolder receiver, BasicProperty argument) {
			for (var fieldValue : receiver.getValue().getOwnedFieldValues()) {
				if (fieldValue.getProperty().equals(argument)) {
					var lookupContext = receiver.getLookupContext();
					var resolved = CodeGenUtil.resolveNamedValue(fieldValue.getOwnedValue(), lookupContext,
							Optional.empty());
					return Optional.of(TypeSystemUtils.convertPropertyValue(resolved, lookupContext));
				}
			}
			return Optional.empty();
		}
	}
}