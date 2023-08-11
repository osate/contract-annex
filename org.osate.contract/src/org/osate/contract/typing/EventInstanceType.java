package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osate.aadl2.errormodel.instance.EventInstance;

public final class EventInstanceType implements Type {
	public static final EventInstanceType INSTANCE = new EventInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new SimpleMember(StringType.INSTANCE, receiver -> name((EventInstance) receiver)));
	}

	private EventInstanceType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "EventInstance";
	}

	private static String name(EventInstance receiver) {
		return receiver.getName();
	}
}