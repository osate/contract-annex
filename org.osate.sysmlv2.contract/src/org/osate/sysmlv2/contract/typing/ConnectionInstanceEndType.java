package org.osate.sysmlv2.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;


public final class ConnectionInstanceEndType implements Type {
	public static final ConnectionInstanceEndType INSTANCE = new ConnectionInstanceEndType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
//		MEMBERS.put("name", new NameMember());
//		MEMBERS.put("parent", new ParentMember());
//		MEMBERS.put("isDataPort", new IsDataPortMember());
	}

	private ConnectionInstanceEndType() {
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
		return "ConnectionInstanceEnd";
	}

//	private static class NameMember implements SimpleMember<ConnectionInstanceEnd, String> {
//		@Override
//		public Type getReturnType() {
//			return StringType.INSTANCE;
//		}
//
//		@Override
//		public String evaluate(ConnectionInstanceEnd receiver) {
//			return receiver.getName();
//		}
//	}
//
//	private static class ParentMember implements SimpleMember<ConnectionInstanceEnd, ComponentInstance> {
//		@Override
//		public Type getReturnType() {
//			return ComponentInstanceType.INSTANCE;
//		}
//
//		@Override
//		public ComponentInstance evaluate(ConnectionInstanceEnd receiver) {
//			return EcoreUtil2.getContainerOfType(receiver.eContainer(), ComponentInstance.class);
//		}
//	}
//
//	private static class IsDataPortMember implements SimpleMember<ConnectionInstanceEnd, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ConnectionInstanceEnd receiver) {
//			return receiver instanceof FeatureInstance feature && feature.getCategory() == FeatureCategory.DATA_PORT;
//		}
//	}
}