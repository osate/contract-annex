package org.osate.contract.typing;

public final class EventInstanceType implements Type {
	public static final EventInstanceType INSTANCE = new EventInstanceType();

	private EventInstanceType() {
	}

	@Override
	public String toString() {
		return "EventInstance";
	}
}