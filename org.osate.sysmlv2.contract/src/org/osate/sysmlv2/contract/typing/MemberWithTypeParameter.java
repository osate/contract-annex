package org.osate.sysmlv2.contract.typing;

import java.util.List;

/**
 * Generic parameters are expected to be the backing Java types such as {@link List}, {@link Long}, {@link String}, etc.
 * For example, when implementing {@code List.filterType}, the receiver type {@code T} should be {@code List<?>}. The
 * generic parameters should not be any type that extends from {@link Type}.
 *
 * @param <T> Receiver Java type
 * @param <R> Return Java type
 */
public non-sealed interface MemberWithTypeParameter<T, R> extends Member {
	Type getReturnType(Type genericType);

	R evaluate(T receiver, Class<?> genericType);
}