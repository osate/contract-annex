package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osate.aadl2.errormodel.instance.StateInstance;

public final class StateInstanceType implements PropertyLookupSupportedType {
	public static final StateInstanceType INSTANCE = new StateInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new SimpleMember(StringType.INSTANCE, receiver -> name((StateInstance) receiver)));
	}

	private StateInstanceType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "StateInstance";
	}

	private static String name(StateInstance receiver) {
		return receiver.getName();
	}
}