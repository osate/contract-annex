package org.osate.sysmlv2.contract.typing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.omg.sysml.lang.sysml.OccurrenceDefinition;

public final class GenericTypeArgumentRegistry {
	private static final Map<String, Entry> REGISTRY;

	static {
		REGISTRY = new HashMap<>();
		addEntry(BooleanType.INSTANCE, Boolean.class);
//		addEntry(ClassifierType.INSTANCE, Classifier.class);
//		addEntry(ComponentCategoryType.INSTANCE, ComponentCategory.class);
//		addEntry(ComponentInstanceType.INSTANCE, ComponentInstance.class);
//		addEntry(ConnectionInstanceEndType.INSTANCE, ConnectionInstanceEnd.class);
//		addEntry(ConnectionInstanceType.INSTANCE, ConnectionInstance.class);
		addEntry(DoubleType.INSTANCE, Double.class);
//		addEntry(EndToEndFlowInstanceType.INSTANCE, EndToEndFlowInstance.class);
//		addEntry(EventInstanceType.INSTANCE, EventInstance.class);
//		addEntry(FeatureInstanceType.INSTANCE, FeatureInstance.class);
//		addEntry(FlowSpecificationInstanceType.INSTANCE, FlowSpecificationInstance.class);
//		addEntry(InstanceObjectType.INSTANCE, InstanceObject.class);
		addEntry(LongType.INSTANCE, Long.class);
//		addEntry(ModeInstanceType.INSTANCE, ModeInstance.class);
//		addEntry(ModeTransitionInstanceType.INSTANCE, ModeTransitionInstance.class);
//		addEntry(StateInstanceType.INSTANCE, StateInstance.class);
		addEntry(StringType.INSTANCE, String.class);
//		addEntry(SystemInstanceType.INSTANCE, SystemInstance.class);
//		addEntry(SystemOperationModeType.INSTANCE, SystemOperationMode.class);
		addEntry(OccurrenceDefintionType.INSTANCE, OccurrenceDefinition.class);
	}

	private GenericTypeArgumentRegistry() {
	}

	public static Set<String> getTypeNames() {
		return REGISTRY.keySet();
	}

	public static Type getQueryType(String typeName) {
		var entry = REGISTRY.get(typeName);
		return entry != null ? entry.queryType() : null;
	}

	public static Class<?> getJavaType(String typeName) {
		var entry = REGISTRY.get(typeName);
		return entry != null ? entry.javaType() : null;
	}

	private static void addEntry(Type queryType, Class<?> javaType) {
		REGISTRY.put(queryType.toString(), new Entry(queryType, javaType));
	}

	private record Entry(Type queryType, Class<?> javaType) {
	}
}