/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and
 * unlimited distribution.  Please see Copyright notice for non-US Government use and
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
package org.osate.sysmlv2.contract.typing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.omg.sysml.lang.sysml.AllocationUsage;
import org.omg.sysml.lang.sysml.OccurrenceDefinition;
import org.osate.sysmlv2.contract.contract.Expression;


public final class OccurrenceDefintionType implements Type {
	public static final OccurrenceDefintionType INSTANCE = new OccurrenceDefintionType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
		MEMBERS.put("allUsages", new AllUsagesMember());
		MEMBERS.put("isThread", new IsThreadMember());
		MEMBERS.put("isProcessor", new isProcessorMember());
		MEMBERS.put("actualProcessorBindings", new ActualProcessorBindingsMember());
		MEMBERS.put("equals", new EqualsMember());
//		MEMBERS.put("category", new CategoryMember());
//		MEMBERS.put("subcomponents", new SubcomponentsMember());
//		MEMBERS.put("allSubcomponents", new AllSubcomponentsMember());
//		MEMBERS.put("allComponents", new AllComponentsMember());
//		MEMBERS.put("features", new FeaturesMember());
//		MEMBERS.put("allFeatures", new AllFeaturesMember());
//		MEMBERS.put("localModes", new LocalModesMember());
//		MEMBERS.put("allModes", new AllModesMember());
//		MEMBERS.put("modeTransitions", new ModeTransitionsMember());
//		MEMBERS.put("allModeTransitions", new AllModeTransitionsMember());
//		MEMBERS.put("flowSpecifications", new FlowSpecificationsMember());
//		MEMBERS.put("allFlowSpecifications", new AllFlowSpecificationsMember());
//		MEMBERS.put("endToEndFlows", new EndToEndFlowsMember());
//		MEMBERS.put("allEndToEndFlows", new AllEndToEndFlowsMember());
//		MEMBERS.put("connections", new ConnectionsMember());
//		MEMBERS.put("allConnections", new AllConnectionsMember());
//		MEMBERS.put("inModes", new InModesMember());
//		MEMBERS.put("parent", new ParentMember());
//		MEMBERS.put("isAbstract", new IsAbstractMember());
//		MEMBERS.put("isBus", new IsBusMember());
//		MEMBERS.put("isData", new IsDataMember());
//		MEMBERS.put("isDevice", new IsDeviceMember());
//		MEMBERS.put("isMemory", new IsMemoryMember());
//		MEMBERS.put("isProcess", new IsProcessMember());
//		MEMBERS.put("isProcessor", new IsProcessorMember());
//		MEMBERS.put("isSubprogram", new IsSubprogramMember());
//		MEMBERS.put("isSubprogramGroup", new IsSubprogramGroupMember());
//		MEMBERS.put("isSystem", new IsSystemMember());
//		MEMBERS.put("isThread", new IsThreadMember());
//		MEMBERS.put("isThreadGroup", new IsThreadGroupMember());
//		MEMBERS.put("isVirtualBus", new IsVirtualBusMember());
//		MEMBERS.put("isVirtualProcessor", new IsVirtualProcessorMember());
//		MEMBERS.put("processorBindingSources", new ProcessorBindingSourcesMember());
//		MEMBERS.put("states", new StatesMember());
//		MEMBERS.put("events", new EventsMember());
	}

	private OccurrenceDefintionType() {
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
		return "OccurrenceDefinition";
	}

	private static class EqualsMember implements MemberWithArgument<OccurrenceDefinition, Boolean, OccurrenceDefinition> {

		@Override
		public Type getReturnType(Expression argument) {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(OccurrenceDefinition receiver, OccurrenceDefinition argument) {
			return receiver.equals(argument);
		}
		
	}
	
	private static class NameMember implements SimpleMember<OccurrenceDefinition, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(OccurrenceDefinition receiver) {
			return receiver.getName();
		}
	}
	
	private static class AllUsagesMember implements SimpleMember<OccurrenceDefinition, List<OccurrenceDefinition>> {
		@Override
		public Type getReturnType() {
			return new ListType(OccurrenceDefintionType.INSTANCE);
		}
	
		@Override
		public List<OccurrenceDefinition> evaluate(OccurrenceDefinition receiver) {
			var result = new ArrayList<OccurrenceDefinition>();
			
			// TODO!
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof ComponentInstance subcomponent) {
//					result.add(subcomponent);
//				}
//			});
			return result;
		}
	}
	
	private static class IsThreadMember implements SimpleMember<OccurrenceDefinition, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(OccurrenceDefinition receiver) {
			// TODO
			return true;
//			return receiver.getCategory() == ComponentCategory.THREAD;
		}
	}
	
	private static class isProcessorMember implements SimpleMember<OccurrenceDefinition, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(OccurrenceDefinition receiver) {
			// TODO
			return true;
//			return receiver.getCategory() == ComponentCategory.THREAD;
		}
	}
	
	private static class ActualProcessorBindingsMember implements SimpleMember<OccurrenceDefinition, List<AllocationUsage>> {
		@Override
		public Type getReturnType() {
			return new ListType(ActualProcessorBindingsType.INSTANCE);
		}

		@Override
		public List<AllocationUsage> evaluate(OccurrenceDefinition receiver) {
			// TODO
			return null;
//			return receiver.getCategory() == ComponentCategory.THREAD;
		}
	}

//	private static class CategoryMember implements SimpleMember<ComponentInstance, ComponentCategory> {
//		@Override
//		public Type getReturnType() {
//			return ComponentCategoryType.INSTANCE;
//		}
//
//		@Override
//		public ComponentCategory evaluate(ComponentInstance receiver) {
//			return receiver.getCategory();
//		}
//	}
//
//	private static class SubcomponentsMember implements SimpleMember<ComponentInstance, List<ComponentInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(OccurrenceDefintionType.INSTANCE);
//		}
//
//		@Override
//		public List<ComponentInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getComponentInstances();
//		}
//	}
//
//	private static class AllSubcomponentsMember implements SimpleMember<ComponentInstance, List<ComponentInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(OccurrenceDefintionType.INSTANCE);
//		}
//
//		@Override
//		public List<ComponentInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<ComponentInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof ComponentInstance subcomponent) {
//					result.add(subcomponent);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class AllComponentsMember implements SimpleMember<ComponentInstance, List<ComponentInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(OccurrenceDefintionType.INSTANCE);
//		}
//
//		@Override
//		public List<ComponentInstance> evaluate(ComponentInstance receiver) {
//			return EcoreUtil2.eAllOfType(receiver, ComponentInstance.class);
//		}
//	}
//
//	private static class FeaturesMember implements SimpleMember<ComponentInstance, List<FeatureInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(FeatureInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<FeatureInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getFeatureInstances();
//		}
//	}
//
//	private static class AllFeaturesMember implements SimpleMember<ComponentInstance, List<FeatureInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(FeatureInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<FeatureInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<FeatureInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof FeatureInstance feature) {
//					result.add(feature);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class LocalModesMember implements SimpleMember<ComponentInstance, List<ModeInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ModeInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ModeInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getModeInstances();
//		}
//	}
//
//	private static class AllModesMember implements SimpleMember<ComponentInstance, List<ModeInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ModeInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ModeInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<ModeInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof ModeInstance mode) {
//					result.add(mode);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class ModeTransitionsMember
//			implements SimpleMember<ComponentInstance, List<ModeTransitionInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ModeTransitionInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ModeTransitionInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getModeTransitionInstances();
//		}
//	}
//
//	private static class AllModeTransitionsMember
//			implements SimpleMember<ComponentInstance, List<ModeTransitionInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ModeTransitionInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ModeTransitionInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<ModeTransitionInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof ModeTransitionInstance transition) {
//					result.add(transition);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class FlowSpecificationsMember
//			implements SimpleMember<ComponentInstance, List<FlowSpecificationInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(FlowSpecificationInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<FlowSpecificationInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getFlowSpecifications();
//		}
//	}
//
//	private static class AllFlowSpecificationsMember
//			implements SimpleMember<ComponentInstance, List<FlowSpecificationInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(FlowSpecificationInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<FlowSpecificationInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<FlowSpecificationInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof FlowSpecificationInstance flow) {
//					result.add(flow);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class EndToEndFlowsMember implements SimpleMember<ComponentInstance, List<EndToEndFlowInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(EndToEndFlowInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<EndToEndFlowInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getEndToEndFlows();
//		}
//	}
//
//	private static class AllEndToEndFlowsMember implements SimpleMember<ComponentInstance, List<EndToEndFlowInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(EndToEndFlowInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<EndToEndFlowInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<EndToEndFlowInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof EndToEndFlowInstance flow) {
//					result.add(flow);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class ConnectionsMember implements SimpleMember<ComponentInstance, List<ConnectionInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ConnectionInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ConnectionInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getConnectionInstances();
//		}
//	}
//
//	private static class AllConnectionsMember implements SimpleMember<ComponentInstance, List<ConnectionInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ConnectionInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ConnectionInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<ConnectionInstance>();
//			receiver.eAllContents().forEachRemaining(element -> {
//				if (element instanceof ConnectionInstance connection) {
//					result.add(connection);
//				}
//			});
//			return result;
//		}
//	}
//
//	private static class InModesMember implements SimpleMember<ComponentInstance, List<ModeInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(ModeInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<ModeInstance> evaluate(ComponentInstance receiver) {
//			return receiver.getInModes();
//		}
//	}
//
//	private static class ParentMember implements SimpleMember<ComponentInstance, Optional<ComponentInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new OptionalType(OccurrenceDefintionType.INSTANCE);
//		}
//
//		@Override
//		public Optional<ComponentInstance> evaluate(ComponentInstance receiver) {
//			if (receiver.eContainer() instanceof ComponentInstance container) {
//				return Optional.of(container);
//			} else {
//				return Optional.empty();
//			}
//		}
//	}
//
//	private static class IsAbstractMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.ABSTRACT;
//		}
//	}
//
//	private static class IsBusMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.BUS;
//		}
//	}
//
//	private static class IsDataMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.DATA;
//		}
//	}
//
//	private static class IsDeviceMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.DEVICE;
//		}
//	}
//
//	private static class IsMemoryMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.MEMORY;
//		}
//	}
//
//	private static class IsProcessMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.PROCESS;
//		}
//	}
//
//	private static class IsProcessorMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.PROCESSOR;
//		}
//	}
//
//	private static class IsSubprogramMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.SUBPROGRAM;
//		}
//	}
//
//	private static class IsSubprogramGroupMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.SUBPROGRAM_GROUP;
//		}
//	}
//
//	private static class IsSystemMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.SYSTEM;
//		}
//	}
//
//	private static class IsThreadMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.THREAD;
//		}
//	}
//
//	private static class IsThreadGroupMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.THREAD_GROUP;
//		}
//	}
//
//	private static class IsVirtualBusMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.VIRTUAL_BUS;
//		}
//	}
//
//	private static class IsVirtualProcessorMember implements SimpleMember<ComponentInstance, Boolean> {
//		@Override
//		public Type getReturnType() {
//			return BooleanType.INSTANCE;
//		}
//
//		@Override
//		public Boolean evaluate(ComponentInstance receiver) {
//			return receiver.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR;
//		}
//	}
//
//	private static class ProcessorBindingSourcesMember
//			implements SimpleMember<ComponentInstance, List<ComponentInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(OccurrenceDefintionType.INSTANCE);
//		}
//
//		@Override
//		public List<ComponentInstance> evaluate(ComponentInstance receiver) {
//			var result = new ArrayList<ComponentInstance>();
//			for (var iterator = receiver.eResource().getAllContents(); iterator.hasNext();) {
//				if (iterator.next() instanceof ComponentInstance component) {
//					if (DeploymentProperties.getActualProcessorBinding(component)
//							.filter(targets -> targets.contains(receiver))
//							.isPresent()) {
//						result.add(component);
//					}
//				} else {
//					iterator.prune();
//				}
//			}
//			return result;
//		}
//	}
//
//	private static class StatesMember implements SimpleMember<ComponentInstance, List<StateInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(StateInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<StateInstance> evaluate(ComponentInstance receiver) {
//			for (var annexInstance : receiver.getAnnexInstances()) {
//				if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
//					return emv2AnnexInstance.getStates();
//				}
//			}
//			return Collections.emptyList();
//		}
//	}
//
//	private static class EventsMember implements SimpleMember<ComponentInstance, List<EventInstance>> {
//		@Override
//		public Type getReturnType() {
//			return new ListType(EventInstanceType.INSTANCE);
//		}
//
//		@Override
//		public List<EventInstance> evaluate(ComponentInstance receiver) {
//			for (var annexInstance : receiver.getAnnexInstances()) {
//				if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
//					return emv2AnnexInstance.getEvents();
//				}
//			}
//			return Collections.emptyList();
//		}
//	}
}