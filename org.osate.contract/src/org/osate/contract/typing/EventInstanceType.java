package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osate.aadl2.errormodel.instance.EventInstance;

public final class EventInstanceType implements PropertyLookupSupportedType {
	public static final EventInstanceType INSTANCE = new EventInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
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

	private static class NameMember implements SimpleMember<EventInstance, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(EventInstance receiver) {
			return receiver.getName();
		}
	}
}