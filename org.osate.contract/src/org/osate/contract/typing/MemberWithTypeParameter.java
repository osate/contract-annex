package org.osate.contract.typing;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class MemberWithTypeParameter implements Member {
	private final Function<Type, Type> returnTypeFunction;
	private final BiFunction<Object, Class<?>, Object> evaluateFunction;

	public MemberWithTypeParameter(Function<Type, Type> returnTypeFunction,
			BiFunction<Object, Class<?>, Object> evaluateFunction) {
		this.returnTypeFunction = returnTypeFunction;
		this.evaluateFunction = evaluateFunction;
	}

	public Type getReturnType(Type genericType) {
		return returnTypeFunction.apply(genericType);
	}

	public Object evaluate(Object receiver, Class<?> genericType) {
		return evaluateFunction.apply(receiver, genericType);
	}
}