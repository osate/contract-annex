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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public final class ListType implements Type {
	private final Type elementType;
	private final Map<String, Member> members;

	public ListType(Type elementType) {
		this.elementType = elementType;

		members = new LinkedHashMap<>();
		members.put("size", new SimpleMember(LongType.INSTANCE, receiver -> size((List<?>) receiver)));
		members.put("empty", new SimpleMember(BooleanType.INSTANCE, receiver -> empty((List<?>) receiver)));
		members.put("first", new SimpleMember(new OptionalType(elementType), receiver -> first((List<?>) receiver)));
		members.put("filter",
				new MemberWithLambda(elementType,
						lambdaReturnType -> lambdaReturnType == BooleanType.INSTANCE ? Optional.empty()
								: Optional.of(BooleanType.INSTANCE.toString()),
						lambdaType -> this, (receiver, evaluateLambda) -> filter((List<?>) receiver, evaluateLambda)));
		members.put("map",
				new MemberWithLambda(elementType, lambdaReturnType -> Optional.empty(),
						lambdaType -> lambdaType != null ? new ListType(lambdaType) : null,
						(receiver, evaluateLambda) -> map((List<?>) receiver, evaluateLambda)));
		members.put("contains", new MemberWithArgument(argument -> BooleanType.INSTANCE,
				(receiver, argument) -> contains((List<?>) receiver, argument)));
	}

	public Type getElementType() {
		return elementType;
	}

	@Override
	public Map<String, Member> getMembers() {
		return members;
	}

	@Override
	public String toString() {
		return "List<" + elementType + '>';
	}

	private static Long size(List<?> receiver) {
		return Long.valueOf(receiver.size());
	}

	private static Boolean empty(List<?> receiver) {
		return receiver.isEmpty();
	}

	private static Optional<?> first(List<?> receiver) {
		if (receiver.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(receiver.get(0));
		}
	}

	private static List<?> filter(List<?> receiver, Function<Object, Object> evaluateLambda) {
		var result = new ArrayList<>();
		for (var element : receiver) {
			var lambdaResult = (Boolean) evaluateLambda.apply(element);
			if (lambdaResult) {
				result.add(element);
			}
		}
		return result;
	}

	private static List<?> map(List<?> receiver, Function<Object, Object> evaluateLambda) {
		var result = new ArrayList<>();
		for (var element : receiver) {
			var lambdaResult = evaluateLambda.apply(element);
			result.add(lambdaResult);
		}
		return result;
	}

	private static Boolean contains(List<?> receiver, Object element) {
		return receiver.contains(element);
	}
}