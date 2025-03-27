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

import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.LiteralInteger;

public final class PriorityType implements Type {
	public static final PriorityType INSTANCE = new PriorityType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("value", new ValueMember());
	}

	public PriorityType() {
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
		return "Priority";
	}

	private static class ValueMember implements SimpleMember<AttributeValueHolder, Long> {
		@Override
		public Type getReturnType() {
			return LongType.INSTANCE;
		}
	
		@Override
		public Long evaluate(final AttributeValueHolder avh) {
			/*
			 * Assumes the following patter in the attribute usage:
			 * 
			 *   :>> Period = 500 [micro * s];
			 *   
			 * Note: Currently does not support just "1 [s]", would have to use "1000 [milli * s]" 
			 */
			var featureValue = (FeatureValue) avh.getElement();
			if (featureValue.getValue() instanceof LiteralInteger litInt) {
				return Long.valueOf(litInt.getValue());
			}
			throw new IllegalArgumentException("Feature value is not an integer literal");
		}
	}
}