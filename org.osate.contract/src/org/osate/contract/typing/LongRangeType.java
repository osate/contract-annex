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

import org.osate.aadl2.IntegerLiteral;

public final class LongRangeType implements Type {
	public static final LongRangeType INSTANCE = new LongRangeType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("minimum", new SimpleMember(LongType.INSTANCE, receiver -> minimum((RangeValueHolder) receiver)));
		MEMBERS.put("maximum", new SimpleMember(LongType.INSTANCE, receiver -> maximum((RangeValueHolder) receiver)));
		MEMBERS.put("getDelta", new SimpleMember(new OptionalType(LongType.INSTANCE),
				receiver -> getDelta((RangeValueHolder) receiver)));
	}

	private LongRangeType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "LongRange";
	}

	private static Long minimum(RangeValueHolder receiver) {
		return ((IntegerLiteral) receiver.getMinimum()).getValue();
	}

	private static Long maximum(RangeValueHolder receiver) {
		return ((IntegerLiteral) receiver.getMaximum()).getValue();
	}

	private static Optional<Long> getDelta(RangeValueHolder receiver) {
		return Optional.ofNullable(receiver.getDelta()).map(delta -> ((IntegerLiteral) delta).getValue());
	}
}