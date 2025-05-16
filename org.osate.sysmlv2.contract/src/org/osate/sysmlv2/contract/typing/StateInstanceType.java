package org.osate.sysmlv2.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

public final class StateInstanceType implements Type {
	public static final StateInstanceType INSTANCE = new StateInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
//		MEMBERS.put("name", new NameMember());
	}

	private StateInstanceType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public boolean supportsAttributeLookup() {
		return true;
	}

	@Override
	public String toString() {
		return "StateInstance";
	}

//	private static class NameMember implements SimpleMember<StateInstance, String> {
//		@Override
//		public Type getReturnType() {
//			return StringType.INSTANCE;
//		}
//
//		@Override
//		public String evaluate(StateInstance receiver) {
//			return receiver.getName();
//		}
//	}
}