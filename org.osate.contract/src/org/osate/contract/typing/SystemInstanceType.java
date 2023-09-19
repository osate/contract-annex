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
package org.osate.contract.typing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

public final class SystemInstanceType implements PropertyLookupSupportedType {
	public static final SystemInstanceType INSTANCE = new SystemInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new SimpleMember(StringType.INSTANCE, receiver -> name((SystemInstance) receiver)));
		MEMBERS.put("category",
				new SimpleMember(ComponentCategoryType.INSTANCE, receiver -> category((SystemInstance) receiver)));
		MEMBERS.put("subcomponents", new SimpleMember(new ListType(ComponentInstanceType.INSTANCE),
				receiver -> subcomponents((SystemInstance) receiver)));
		MEMBERS.put("allSubcomponents", new SimpleMember(new ListType(ComponentInstanceType.INSTANCE),
				receiver -> allSubcomponents((SystemInstance) receiver)));
		MEMBERS.put("features", new SimpleMember(new ListType(FeatureInstanceType.INSTANCE),
				receiver -> features((SystemInstance) receiver)));
		MEMBERS.put("allFeatures", new SimpleMember(new ListType(FeatureInstanceType.INSTANCE),
				receiver -> allFeatures((SystemInstance) receiver)));
		MEMBERS.put("localModes", new SimpleMember(new ListType(ModeInstanceType.INSTANCE),
				receiver -> localModes((SystemInstance) receiver)));
		MEMBERS.put("allModes", new SimpleMember(new ListType(ModeInstanceType.INSTANCE),
				receiver -> allModes((SystemInstance) receiver)));
		MEMBERS.put("modeTransitions", new SimpleMember(new ListType(ModeTransitionInstanceType.INSTANCE),
				receiver -> modeTransitions((SystemInstance) receiver)));
		MEMBERS.put("allModeTransitions", new SimpleMember(new ListType(ModeTransitionInstanceType.INSTANCE),
				receiver -> allModeTransitions((SystemInstance) receiver)));
		MEMBERS.put("flowSpecifications", new SimpleMember(new ListType(FlowSpecificationInstanceType.INSTANCE),
				receiver -> flowSpecifications((SystemInstance) receiver)));
		MEMBERS.put("allFlowSpecifications", new SimpleMember(new ListType(FlowSpecificationInstanceType.INSTANCE),
				receiver -> allFlowSpecifications((SystemInstance) receiver)));
		MEMBERS.put("endToEndFlows", new SimpleMember(new ListType(EndToEndFlowInstanceType.INSTANCE),
				receiver -> endToEndFlows((SystemInstance) receiver)));
		MEMBERS.put("allEndToEndFlows", new SimpleMember(new ListType(EndToEndFlowInstanceType.INSTANCE),
				receiver -> allEndToEndFlows((SystemInstance) receiver)));
		MEMBERS.put("connections", new SimpleMember(new ListType(ConnectionInstanceType.INSTANCE),
				receiver -> connections((SystemInstance) receiver)));
		MEMBERS.put("allConnections", new SimpleMember(new ListType(ConnectionInstanceType.INSTANCE),
				receiver -> allConnections((SystemInstance) receiver)));
		MEMBERS.put("systemOperationModes", new SimpleMember(new ListType(SystemOperationModeType.INSTANCE),
				receiver -> systemOperationModes((SystemInstance) receiver)));
		MEMBERS.put("isAbstract",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isAbstract((SystemInstance) receiver)));
		MEMBERS.put("isBus", new SimpleMember(BooleanType.INSTANCE, receiver -> isBus((SystemInstance) receiver)));
		MEMBERS.put("isData", new SimpleMember(BooleanType.INSTANCE, receiver -> isData((SystemInstance) receiver)));
		MEMBERS.put("isDevice",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isDevice((SystemInstance) receiver)));
		MEMBERS.put("isMemory",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isMemory((SystemInstance) receiver)));
		MEMBERS.put("isProcess",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isProcess((SystemInstance) receiver)));
		MEMBERS.put("isProcessor",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isProcessor((SystemInstance) receiver)));
		MEMBERS.put("isSubprogram",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSubprogram((SystemInstance) receiver)));
		MEMBERS.put("isSubprogramGroup",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSubprogramGroup((SystemInstance) receiver)));
		MEMBERS.put("isSystem",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSystem((SystemInstance) receiver)));
		MEMBERS.put("isThread",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isThread((SystemInstance) receiver)));
		MEMBERS.put("isThreadGroup",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isThreadGroup((SystemInstance) receiver)));
		MEMBERS.put("isVirtualBus",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isVirtualBus((SystemInstance) receiver)));
		MEMBERS.put("isVirtualProcessor",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isVirtualProcessor((SystemInstance) receiver)));
		MEMBERS.put("states", new SimpleMember(new ListType(StateInstanceType.INSTANCE),
				receiver -> states((SystemInstance) receiver)));
		MEMBERS.put("events", new SimpleMember(new ListType(EventInstanceType.INSTANCE),
				receiver -> events((SystemInstance) receiver)));
	}

	private SystemInstanceType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "SystemInstance";
	}

	private static String name(SystemInstance receiver) {
		return receiver.getName();
	}

	private static ComponentCategory category(SystemInstance receiver) {
		return receiver.getCategory();
	}

	private static List<ComponentInstance> subcomponents(SystemInstance receiver) {
		return receiver.getComponentInstances();
	}

	private static List<ComponentInstance> allSubcomponents(SystemInstance receiver) {
		var result = new ArrayList<ComponentInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ComponentInstance subcomponent) {
				result.add(subcomponent);
			}
		});
		return result;
	}

	private static List<FeatureInstance> features(SystemInstance receiver) {
		return receiver.getFeatureInstances();
	}

	private static List<FeatureInstance> allFeatures(SystemInstance receiver) {
		var result = new ArrayList<FeatureInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof FeatureInstance feature) {
				result.add(feature);
			}
		});
		return result;
	}

	private static List<ModeInstance> localModes(SystemInstance receiver) {
		return receiver.getModeInstances();
	}

	private static List<ModeInstance> allModes(SystemInstance receiver) {
		var result = new ArrayList<ModeInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ModeInstance mode) {
				result.add(mode);
			}
		});
		return result;
	}

	private static List<ModeTransitionInstance> modeTransitions(SystemInstance receiver) {
		return receiver.getModeTransitionInstances();
	}

	private static List<ModeTransitionInstance> allModeTransitions(SystemInstance receiver) {
		var result = new ArrayList<ModeTransitionInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ModeTransitionInstance transition) {
				result.add(transition);
			}
		});
		return result;
	}

	private static List<FlowSpecificationInstance> flowSpecifications(SystemInstance receiver) {
		return receiver.getFlowSpecifications();
	}

	private static List<FlowSpecificationInstance> allFlowSpecifications(SystemInstance receiver) {
		var result = new ArrayList<FlowSpecificationInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof FlowSpecificationInstance flow) {
				result.add(flow);
			}
		});
		return result;
	}

	private static List<EndToEndFlowInstance> endToEndFlows(SystemInstance receiver) {
		return receiver.getEndToEndFlows();
	}

	private static List<EndToEndFlowInstance> allEndToEndFlows(SystemInstance receiver) {
		var result = new ArrayList<EndToEndFlowInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof EndToEndFlowInstance flow) {
				result.add(flow);
			}
		});
		return result;
	}

	private static List<ConnectionInstance> connections(SystemInstance receiver) {
		return receiver.getConnectionInstances();
	}

	private static List<ConnectionInstance> allConnections(SystemInstance receiver) {
		var result = new ArrayList<ConnectionInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ConnectionInstance connection) {
				result.add(connection);
			}
		});
		return result;
	}

	private static List<SystemOperationMode> systemOperationModes(SystemInstance receiver) {
		return receiver.getSystemOperationModes();
	}

	private static Boolean isAbstract(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.ABSTRACT;
	}

	private static Boolean isBus(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.BUS;
	}

	private static Boolean isData(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.DATA;
	}

	private static Boolean isDevice(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.DEVICE;
	}

	private static Boolean isMemory(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.MEMORY;
	}

	private static Boolean isProcess(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.PROCESS;
	}

	private static Boolean isProcessor(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.PROCESSOR;
	}

	private static Boolean isSubprogram(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SUBPROGRAM;
	}

	private static Boolean isSubprogramGroup(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SUBPROGRAM_GROUP;
	}

	private static Boolean isSystem(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SYSTEM;
	}

	private static Boolean isThread(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.THREAD;
	}

	private static Boolean isThreadGroup(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.THREAD_GROUP;
	}

	private static Boolean isVirtualBus(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.VIRTUAL_BUS;
	}

	private static Boolean isVirtualProcessor(SystemInstance receiver) {
		return receiver.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR;
	}

	private static List<StateInstance> states(SystemInstance receiver) {
		for (var annexInstance : receiver.getAnnexInstances()) {
			if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
				return emv2AnnexInstance.getStates();
			}
		}
		return Collections.emptyList();
	}

	private static List<EventInstance> events(SystemInstance receiver) {
		for (var annexInstance : receiver.getAnnexInstances()) {
			if (annexInstance instanceof EMV2AnnexInstance emv2AnnexInstance) {
				return emv2AnnexInstance.getEvents();
			}
		}
		return Collections.emptyList();
	}
}