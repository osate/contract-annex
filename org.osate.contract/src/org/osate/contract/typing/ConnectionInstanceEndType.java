package org.osate.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

public final class ConnectionInstanceEndType implements Type {
	public static final ConnectionInstanceEndType INSTANCE = new ConnectionInstanceEndType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
		MEMBERS.put("parent", new ParentMember());
	}

	private ConnectionInstanceEndType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public boolean supportsPropertyLookup() {
		return true;
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

	private static class ParentMember implements SimpleMember<ConnectionInstanceEnd, ComponentInstance> {
		@Override
		public Type getReturnType() {
			return ComponentInstanceType.INSTANCE;
		}

		@Override
		public ComponentInstance evaluate(ConnectionInstanceEnd receiver) {
			return EcoreUtil2.getContainerOfType(receiver.eContainer(), ComponentInstance.class);
		}
	}
}