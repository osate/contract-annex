package org.osate.contract.typing;

public final class StateInstanceType implements Type {
	public static final StateInstanceType INSTANCE = new StateInstanceType();

	private StateInstanceType() {
	}

	@Override
	public String toString() {
		return "StateInstance";
	}
}