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

import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

public final class SystemInstanceType implements Type {
	public static final SystemInstanceType INSTANCE = new SystemInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
		MEMBERS.put("category", new CategoryMember());
		MEMBERS.put("subcomponents", new SubcomponentsMember());
		MEMBERS.put("allSubcomponents", new AllSubcomponentsMember());
		MEMBERS.put("allComponents", new AllComponentsMember());
		MEMBERS.put("features", new FeaturesMember());
		MEMBERS.put("allFeatures", new AllFeaturesMember());
		MEMBERS.put("localModes", new LocalModesMember());
		MEMBERS.put("allModes", new AllModesMember());
		MEMBERS.put("modeTransitions", new ModeTransitionsMember());
		MEMBERS.put("allModeTransitions", new AllModeTransitionsMember());
		MEMBERS.put("flowSpecifications", new FlowSpecificationsMember());
		MEMBERS.put("allFlowSpecifications", new AllFlowSpecificationsMember());
		MEMBERS.put("endToEndFlows", new EndToEndFlowsMember());
		MEMBERS.put("allEndToEndFlows", new AllEndToEndFlowsMember());
		MEMBERS.put("connections", new ConnectionsMember());
		MEMBERS.put("allConnections", new AllConnectionsMember());
		MEMBERS.put("systemOperationModes", new SystemOperationModesMember());
		MEMBERS.put("isAbstract", new IsAbstractMember());
		MEMBERS.put("isBus", new IsBusMember());
		MEMBERS.put("isData", new IsDataMember());
		MEMBERS.put("isDevice", new IsDeviceMember());
		MEMBERS.put("isMemory", new IsMemoryMember());
		MEMBERS.put("isProcess", new IsProcessMember());
		MEMBERS.put("isProcessor", new IsProcessorMember());
		MEMBERS.put("isSubprogram", new IsSubprogramMember());
		MEMBERS.put("isSubprogramGroup", new IsSubprogramGroupMember());
		MEMBERS.put("isSystem", new IsSystemMember());
		MEMBERS.put("isThread", new IsThreadMember());
		MEMBERS.put("isThreadGroup", new IsThreadGroupMember());
		MEMBERS.put("isVirtualBus", new IsVirtualBusMember());
		MEMBERS.put("isVirtualProcessor", new IsVirtualProcessorMember());
		MEMBERS.put("states", new StatesMember());
		MEMBERS.put("events", new EventsMember());
	}

	private SystemInstanceType() {
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
		return "SystemInstance";
	}

	private static class NameMember implements SimpleMember<SystemInstance, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(SystemInstance receiver) {
			return receiver.getName();
		}
	}

	private static class CategoryMember implements SimpleMember<SystemInstance, ComponentCategory> {
		@Override
		public Type getReturnType() {
			return ComponentCategoryType.INSTANCE;
		}

		@Override
		public ComponentCategory evaluate(SystemInstance receiver) {
			return receiver.getCategory();
		}
	}

	private static class SubcomponentsMember implements SimpleMember<SystemInstance, List<ComponentInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ComponentInstanceType.INSTANCE);
		}

		@Override
		public List<ComponentInstance> evaluate(SystemInstance receiver) {
			return receiver.getComponentInstances();
		}
	}

	private static class AllSubcomponentsMember implements SimpleMember<SystemInstance, List<ComponentInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ComponentInstanceType.INSTANCE);
		}

		@Override
		public List<ComponentInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<ComponentInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof ComponentInstance subcomponent) {
					result.add(subcomponent);
				}
			});
			return result;
		}
	}

	private static class AllComponentsMember implements SimpleMember<SystemInstance, List<ComponentInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ComponentInstanceType.INSTANCE);
		}

		@Override
		public List<ComponentInstance> evaluate(SystemInstance receiver) {
			return EcoreUtil2.eAllOfType(receiver, ComponentInstance.class);
		}
	}

	private static class FeaturesMember implements SimpleMember<SystemInstance, List<FeatureInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(FeatureInstanceType.INSTANCE);
		}

		@Override
		public List<FeatureInstance> evaluate(SystemInstance receiver) {
			return receiver.getFeatureInstances();
		}
	}

	private static class AllFeaturesMember implements SimpleMember<SystemInstance, List<FeatureInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(FeatureInstanceType.INSTANCE);
		}

		@Override
		public List<FeatureInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<FeatureInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof FeatureInstance feature) {
					result.add(feature);
				}
			});
			return result;
		}
	}

	private static class LocalModesMember implements SimpleMember<SystemInstance, List<ModeInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ModeInstanceType.INSTANCE);
		}

		@Override
		public List<ModeInstance> evaluate(SystemInstance receiver) {
			return receiver.getModeInstances();
		}
	}

	private static class AllModesMember implements SimpleMember<SystemInstance, List<ModeInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ModeInstanceType.INSTANCE);
		}

		@Override
		public List<ModeInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<ModeInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof ModeInstance mode) {
					result.add(mode);
				}
			});
			return result;
		}
	}

	private static class ModeTransitionsMember implements SimpleMember<SystemInstance, List<ModeTransitionInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ModeTransitionInstanceType.INSTANCE);
		}

		@Override
		public List<ModeTransitionInstance> evaluate(SystemInstance receiver) {
			return receiver.getModeTransitionInstances();
		}
	}

	private static class AllModeTransitionsMember
			implements SimpleMember<SystemInstance, List<ModeTransitionInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ModeTransitionInstanceType.INSTANCE);
		}

		@Override
		public List<ModeTransitionInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<ModeTransitionInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof ModeTransitionInstance transition) {
					result.add(transition);
				}
			});
			return result;
		}
	}

	private static class FlowSpecificationsMember
			implements SimpleMember<SystemInstance, List<FlowSpecificationInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(FlowSpecificationInstanceType.INSTANCE);
		}

		@Override
		public List<FlowSpecificationInstance> evaluate(SystemInstance receiver) {
			return receiver.getFlowSpecifications();
		}
	}

	private static class AllFlowSpecificationsMember
			implements SimpleMember<SystemInstance, List<FlowSpecificationInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(FlowSpecificationInstanceType.INSTANCE);
		}

		@Override
		public List<FlowSpecificationInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<FlowSpecificationInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof FlowSpecificationInstance flow) {
					result.add(flow);
				}
			});
			return result;
		}
	}

	private static class EndToEndFlowsMember implements SimpleMember<SystemInstance, List<EndToEndFlowInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(EndToEndFlowInstanceType.INSTANCE);
		}

		@Override
		public List<EndToEndFlowInstance> evaluate(SystemInstance receiver) {
			return receiver.getEndToEndFlows();
		}
	}

	private static class AllEndToEndFlowsMember implements SimpleMember<SystemInstance, List<EndToEndFlowInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(EndToEndFlowInstanceType.INSTANCE);
		}

		@Override
		public List<EndToEndFlowInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<EndToEndFlowInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof EndToEndFlowInstance flow) {
					result.add(flow);
				}
			});
			return result;
		}
	}

	private static class ConnectionsMember implements SimpleMember<SystemInstance, List<ConnectionInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ConnectionInstanceType.INSTANCE);
		}

		@Override
		public List<ConnectionInstance> evaluate(SystemInstance receiver) {
			return receiver.getConnectionInstances();
		}
	}

	private static class AllConnectionsMember implements SimpleMember<SystemInstance, List<ConnectionInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ConnectionInstanceType.INSTANCE);
		}

		@Override
		public List<ConnectionInstance> evaluate(SystemInstance receiver) {
			var result = new ArrayList<ConnectionInstance>();
			receiver.eAllContents().forEachRemaining(element -> {
				if (element instanceof ConnectionInstance connection) {
					result.add(connection);
				}
			});
			return result;
		}
	}

	private static class SystemOperationModesMember implements SimpleMember<SystemInstance, List<SystemOperationMode>> {
		@Override
		public Type getReturnType() {
			return new ListType(SystemOperationModeType.INSTANCE);
		}

		@Override
		public List<SystemOperationMode> evaluate(SystemInstance receiver) {
			return receiver.getSystemOperationModes();
		}
	}

	private static class IsAbstractMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.ABSTRACT;
		}
	}

	private static class IsBusMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.BUS;
		}
	}

	private static class IsDataMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.DATA;
		}
	}

	private static class IsDeviceMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.DEVICE;
		}
	}

	private static class IsMemoryMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.MEMORY;
		}
	}

	private static class IsProcessMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.PROCESS;
		}
	}

	private static class IsProcessorMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.PROCESSOR;
		}
	}

	private static class IsSubprogramMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.SUBPROGRAM;
		}
	}

	private static class IsSubprogramGroupMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.SUBPROGRAM_GROUP;
		}
	}

	private static class IsSystemMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.SYSTEM;
		}
	}

	private static class IsThreadMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.THREAD;
		}
	}

	private static class IsThreadGroupMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.THREAD_GROUP;
		}
	}

	private static class IsVirtualBusMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.VIRTUAL_BUS;
		}
	}

	private static class IsVirtualProcessorMember implements SimpleMember<SystemInstance, Boolean> {
		@Override
		public Type getReturnType() {
			return BooleanType.INSTANCE;
		}

		@Override
		public Boolean evaluate(SystemInstance receiver) {
			return receiver.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR;
		}
	}

	private static class StatesMember implements SimpleMember<SystemInstance, List<StateInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(StateInstanceType.INSTANCE);
		}

		@Override
		public List<StateInstance> evaluate(SystemInstance receiver) {
			for (var annexInstance : receiver.getAnnexInstances()) {
				if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
					return emv2AnnexInstance.getStates();
				}
			}
			return Collections.emptyList();
		}
	}

	private static class EventsMember implements SimpleMember<SystemInstance, List<EventInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(EventInstanceType.INSTANCE);
		}

		@Override
		public List<EventInstance> evaluate(SystemInstance receiver) {
			for (var annexInstance : receiver.getAnnexInstances()) {
				if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
					return emv2AnnexInstance.getEvents();
				}
			}
			return Collections.emptyList();
		}
	}
}