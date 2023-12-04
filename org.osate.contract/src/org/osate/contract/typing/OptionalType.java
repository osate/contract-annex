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
import java.util.function.Consumer;
import java.util.function.Function;

public final class OptionalType implements Type {
	private final Type elementType;
	private final Map<String, Member> members;

	public OptionalType(Type elementType) {
		this.elementType = elementType;

		members = new LinkedHashMap<>();
		members.put("isEmpty", new SimpleMember(BooleanType.INSTANCE, receiver -> isEmpty((Optional<?>) receiver)));
		members.put("filterType", new FilterTypeMember());
		members.put("map", new MapMember());
		members.put("flatMap", new FlatMapMember());
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
		return elementType + "?";
	}

	private static Boolean isEmpty(Optional<?> receiver) {
		return receiver.isEmpty();
	}

	private static class FilterTypeMember implements MemberWithTypeParameter<Optional<?>, Optional<?>> {
		@Override
		public Type getReturnType(Type genericType) {
			return new OptionalType(genericType);
		}

		@Override
		public Optional<?> evaluate(Optional<?> receiver, Class<?> genericType) {
			return receiver.filter(genericType::isInstance);
		}
	}

	private class MapMember implements MemberWithLambda<Optional<?>, Optional<?>, Object> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			if (lambdaType != null) {
				return new OptionalType(lambdaType);
			} else {
				return null;
			}
		}

		@Override
		public Optional<?> evaluate(Optional<?> receiver, Function<Object, Object> evaluateLambda) {
			return receiver.map(evaluateLambda);
		}
	}

	private class FlatMapMember implements MemberWithLambda<Optional<?>, Optional<?>, Optional<?>> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public void validateLambdaReturnType(Type lambdaReturnType, Consumer<String> errorReporter) {
			if (!(lambdaReturnType instanceof OptionalType)) {
				errorReporter.accept("Expected Optional; found " + lambdaReturnType);
			}
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			if (lambdaType instanceof OptionalType nestedLambdaType) {
				return nestedLambdaType;
			} else {
				return null;
			}
		}

		@Override
		public Optional<?> evaluate(Optional<?> receiver, Function<Object, Optional<?>> evaluateLambda) {
			return receiver.flatMap(evaluateLambda);
		}
	}
}