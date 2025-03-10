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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import org.osate.contract.contract.Expression;
import org.osate.sysmlv2.contract.tuples.Tuple;

public final class ListType implements Type {
	private final Type elementType;
	private final Map<String, Member> members;
	private final String label;

	public ListType(Type elementType) {
		this.elementType = elementType;

		members = new LinkedHashMap<>();
		members.put("size", new SizeMember());
		members.put("empty", new EmptyMember());
		members.put("first", new FirstMember());
		members.put("filter", new FilterMember());
		members.put("filterType", new FilterTypeMember());
		members.put("map", new MapMember());
		members.put("flatMap", new FlatMapMember());
		members.put("mapPresent", new MapPresentMember());
		members.put("contains", new ContainsMember());
		members.put("allMatch", new AllMatchMember());

		if (elementType instanceof OptionalType optionalType) {
			members.put("filterPresent", new FilterPresentMember(optionalType));
		} else if (elementType instanceof TupleType tupleType
				&& tupleType.getElementTypes().stream().anyMatch(OptionalType.class::isInstance)) {
			var unwrappedTypes = new ArrayList<Type>();
			for (var tupleElementType : tupleType.getElementTypes()) {
				if (tupleElementType instanceof OptionalType optionalType) {
					unwrappedTypes.add(optionalType.getElementType());
				} else {
					unwrappedTypes.add(tupleElementType);
				}
			}
			members.put("filterTupleElementsPresent", new FilterTupleElementsPresentMember(unwrappedTypes));
		} else if (elementType instanceof ListType listType) {
			members.put("flatten", new FlattenMember(listType.elementType));
		}

		label = "List<" + elementType + '>';
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

	private static class SizeMember implements SimpleMember<List<?>, Long> {
		@Override
		public Type getReturnType() {
			return LongType.INSTANCE;
		}

		@Override
		public Long evaluate(List<?> receiver) {
			return Long.valueOf(receiver.size());
		}
	}

	private static class EmptyMember implements SimpleMember<List<?>, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(List<?> receiver) {
			return receiver.isEmpty();
		}
	}

	private class FirstMember implements SimpleMember<List<?>, Optional<?>> {
		@Override
		public Type getReturnType() {
			return new OptionalType(elementType);
		}

		@Override
		public Optional<?> evaluate(List<?> receiver) {
			if (receiver.isEmpty()) {
				return Optional.empty();
			} else {
				return Optional.of(receiver.get(0));
			}
		}
	}

	private class FilterMember implements MemberWithLambda<List<?>, List<?>, Boolean> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public void validateLambdaReturnType(Type lambdaReturnType, Consumer<String> errorReporter) {
			if (lambdaReturnType != BooleanType.INSTANCE) {
				errorReporter.accept("Expected " + BooleanType.INSTANCE + "; found " + lambdaReturnType);
			}
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			return ListType.this;
		}

		@Override
		public List<?> evaluate(List<?> receiver, Function<Object, Boolean> evaluateLambda) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				if (evaluateLambda.apply(element)) {
					result.add(element);
				}
			}
			return result;
		}
	}

	private static class FilterTypeMember implements MemberWithTypeParameter<List<?>, List<?>> {
		@Override
		public Type getReturnType(Type genericType) {
			return new ListType(genericType);
		}

		@Override
		public List<?> evaluate(List<?> receiver, Class<?> genericType) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				if (genericType.isInstance(element)) {
					result.add(element);
				}
			}
			return result;
		}
	}

	private class MapMember implements MemberWithLambda<List<?>, List<?>, Object> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			if (lambdaType != null) {
				return new ListType(lambdaType);
			} else {
				return null;
			}
		}

		@Override
		public List<?> evaluate(List<?> receiver, Function<Object, Object> evaluateLambda) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				result.add(evaluateLambda.apply(element));
			}
			return result;
		}
	}

	private class FlatMapMember implements MemberWithLambda<List<?>, List<?>, List<?>> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public void validateLambdaReturnType(Type lambdaReturnType, Consumer<String> errorReporter) {
			if (!(lambdaReturnType instanceof ListType)) {
				errorReporter.accept("Expected List; found " + lambdaReturnType);
			}
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			if (lambdaType instanceof ListType listType) {
				return new ListType(listType.elementType);
			} else {
				return null;
			}
		}

		@Override
		public List<?> evaluate(List<?> receiver, Function<Object, List<?>> evaluateLambda) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				result.addAll(evaluateLambda.apply(element));
			}
			return result;
		}
	}

	private class MapPresentMember implements MemberWithLambda<List<?>, List<?>, Optional<?>> {
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
				return new ListType(nestedLambdaType.getElementType());
			} else {
				return null;
			}
		}

		@Override
		public List<?> evaluate(List<?> receiver, Function<Object, Optional<?>> evaluateLambda) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				evaluateLambda.apply(element).ifPresent(result::add);
			}
			return result;
		}
	}

	private static class ContainsMember implements MemberWithArgument<List<?>, Boolean, Object> {
		@Override
		public Type getReturnType(Expression argument) {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(List<?> receiver, Object argument) {
			return receiver.contains(argument);
		}
	}

	private class AllMatchMember implements MemberWithLambda<List<?>, Boolean, Boolean> {
		@Override
		public Type getLambdaParameterType() {
			return elementType;
		}

		@Override
		public void validateLambdaReturnType(Type lambdaReturnType, Consumer<String> errorReporter) {
			if (lambdaReturnType != BooleanType.INSTANCE) {
				errorReporter.accept("Expected " + BooleanType.INSTANCE + "; found " + lambdaReturnType);
			}
		}

		@Override
		public Type getReturnType(Type lambdaType) {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(List<?> receiver, Function<Object, Boolean> evaluateLambda) {
			for (var element : receiver) {
				if (!evaluateLambda.apply(element)) {
					return false;
				}
			}
			return true;
		}
	}

	private static class FilterPresentMember implements SimpleMember<List<Optional<?>>, List<?>> {
		private final OptionalType optionalType;

		public FilterPresentMember(OptionalType optionalType) {
			this.optionalType = optionalType;
		}

		@Override
		public Type getReturnType() {
			return new ListType(optionalType.getElementType());
		}

		@Override
		public List<?> evaluate(List<Optional<?>> receiver) {
			var result = new ArrayList<>();
			for (var element : receiver) {
				element.ifPresent(result::add);
			}
			return result;
		}
	}

	private static class FilterTupleElementsPresentMember implements SimpleMember<List<Tuple>, List<Tuple>> {
		private final List<Type> unwrappedTypes;

		public FilterTupleElementsPresentMember(List<Type> unwrappedTypes) {
			this.unwrappedTypes = unwrappedTypes;
		}

		@Override
		public Type getReturnType() {
			return new ListType(new TupleType(unwrappedTypes));
		}

		@Override
		public List<Tuple> evaluate(List<Tuple> receiver) {
			var result = new ArrayList<Tuple>();
			listLoop: for (var listElement : receiver) {
				var unwrappedTupleElements = new ArrayList<>();
				for (var tupleElement : listElement.getElements()) {
					if (tupleElement instanceof Optional<?> optional) {
						if (optional.isPresent()) {
							unwrappedTupleElements.add(optional.get());
						} else {
							continue listLoop;
						}
					} else {
						unwrappedTupleElements.add(tupleElement);
					}
				}
				result.add(new Tuple(unwrappedTupleElements));
			}
			return result;
		}
	}

	private static class FlattenMember implements SimpleMember<List<List<?>>, List<?>> {
		private final Type nestedType;

		public FlattenMember(Type nestedType) {
			this.nestedType = nestedType;
		}

		@Override
		public Type getReturnType() {
			return new ListType(nestedType);
		}

		@Override
		public List<?> evaluate(List<List<?>> receiver) {
			var result = new ArrayList<>();
			for (var nestedList : receiver) {
				result.addAll(nestedList);
			}
			return result;
		}
	}
}