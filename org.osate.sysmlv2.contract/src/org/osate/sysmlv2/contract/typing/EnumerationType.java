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

import org.osate.aadl2.EnumerationLiteral;
import org.osate.contract.contract.Expression;

public final class EnumerationType implements Type {
	private final org.osate.aadl2.EnumerationType enumType;
	private final Map<String, Member> members;
	private final String label;

	public EnumerationType(org.osate.aadl2.EnumerationType enumType) {
		this.enumType = enumType;

		members = new LinkedHashMap<>();
		members.put("is", new IsMember());

		var genericName = enumType.hasName() ? enumType.getQualifiedName() : TypeSystemUtils.generateName(enumType);
		label = "Enumeration<" + genericName + '>';
	}

	public org.osate.aadl2.EnumerationType getEnumerationType() {
		return enumType;
	}

	@Override
	public Map<String, Member> getMembers() {
		return members;
	}

	@Override
	public boolean supportsAttributeLookup() {
		return false;
	}

	@Override
	public String toString() {
		return label;
	}

	private static class IsMember implements MemberWithArgument<EnumerationLiteral, Boolean, EnumerationLiteral> {
		@Override
		public Type getReturnType(Expression argument) {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(EnumerationLiteral receiver, EnumerationLiteral argument) {
			return receiver.getName().equalsIgnoreCase(argument.getName());
		}
	}
}