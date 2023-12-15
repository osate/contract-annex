package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osate.aadl2.instance.ConnectionInstanceEnd;

public final class ConnectionInstanceEndType implements PropertyLookupSupportedType {
	public static final ConnectionInstanceEndType INSTANCE = new ConnectionInstanceEndType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
	}

	private ConnectionInstanceEndType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "ConnectionInstanceEnd";
	}

	private static class NameMember implements SimpleMember<ConnectionInstanceEnd, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(ConnectionInstanceEnd receiver) {
			return receiver.getName();
		}
	}
}