package org.osate.contract.typing;

public final class ConnectionInstanceEndType implements Type {
	public static final ConnectionInstanceEndType INSTANCE = new ConnectionInstanceEndType();

	private ConnectionInstanceEndType() {
	}

	@Override
	public String toString() {
		return "ConnectionInstanceEnd";
	}
}