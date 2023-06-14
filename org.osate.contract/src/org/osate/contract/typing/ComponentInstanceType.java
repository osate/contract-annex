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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;

public final class ComponentInstanceType implements PropertyLookupSupportedType {
	public static final ComponentInstanceType INSTANCE = new ComponentInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new SimpleMember(StringType.INSTANCE, receiver -> name((ComponentInstance) receiver)));
		MEMBERS.put("category",
				new SimpleMember(ComponentCategoryType.INSTANCE, receiver -> category((ComponentInstance) receiver)));
		MEMBERS.put("subcomponents", new SimpleMember(new ListType(ComponentInstanceType.INSTANCE),
				receiver -> subcomponents((ComponentInstance) receiver)));
		MEMBERS.put("allSubcomponents", new SimpleMember(new ListType(ComponentInstanceType.INSTANCE),
				receiver -> allSubcomponents((ComponentInstance) receiver)));
		MEMBERS.put("features", new SimpleMember(new ListType(FeatureInstanceType.INSTANCE),
				receiver -> features((ComponentInstance) receiver)));
		MEMBERS.put("allFeatures", new SimpleMember(new ListType(FeatureInstanceType.INSTANCE),
				receiver -> allFeatures((ComponentInstance) receiver)));
		MEMBERS.put("localModes", new SimpleMember(new ListType(ModeInstanceType.INSTANCE),
				receiver -> localModes((ComponentInstance) receiver)));
		MEMBERS.put("allModes", new SimpleMember(new ListType(ModeInstanceType.INSTANCE),
				receiver -> allModes((ComponentInstance) receiver)));
		MEMBERS.put("modeTransitions", new SimpleMember(new ListType(ModeTransitionInstanceType.INSTANCE),
				receiver -> modeTransitions((ComponentInstance) receiver)));
		MEMBERS.put("allModeTransitions", new SimpleMember(new ListType(ModeTransitionInstanceType.INSTANCE),
				receiver -> allModeTransitions((ComponentInstance) receiver)));
		MEMBERS.put("flowSpecifications", new SimpleMember(new ListType(FlowSpecificationInstanceType.INSTANCE),
				receiver -> flowSpecifications((ComponentInstance) receiver)));
		MEMBERS.put("allFlowSpecifications", new SimpleMember(new ListType(FlowSpecificationInstanceType.INSTANCE),
				receiver -> allFlowSpecifications((ComponentInstance) receiver)));
		MEMBERS.put("endToEndFlows", new SimpleMember(new ListType(EndToEndFlowInstanceType.INSTANCE),
				receiver -> endToEndFlows((ComponentInstance) receiver)));
		MEMBERS.put("allEndToEndFlows", new SimpleMember(new ListType(EndToEndFlowInstanceType.INSTANCE),
				receiver -> allEndToEndFlows((ComponentInstance) receiver)));
		MEMBERS.put("connections", new SimpleMember(new ListType(ConnectionInstanceType.INSTANCE),
				receiver -> connections((ComponentInstance) receiver)));
		MEMBERS.put("allConnections", new SimpleMember(new ListType(ConnectionInstanceType.INSTANCE),
				receiver -> allConnections((ComponentInstance) receiver)));
		MEMBERS.put("inModes", new SimpleMember(new ListType(ModeInstanceType.INSTANCE),
				receiver -> inModes((ComponentInstance) receiver)));
		MEMBERS.put("parent", new SimpleMember(new OptionalType(ComponentInstanceType.INSTANCE),
				receiver -> parent((ComponentInstance) receiver)));
		MEMBERS.put("isAbstract",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isAbstract((ComponentInstance) receiver)));
		MEMBERS.put("isBus", new SimpleMember(BooleanType.INSTANCE, receiver -> isBus((ComponentInstance) receiver)));
		MEMBERS.put("isData", new SimpleMember(BooleanType.INSTANCE, receiver -> isData((ComponentInstance) receiver)));
		MEMBERS.put("isDevice",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isDevice((ComponentInstance) receiver)));
		MEMBERS.put("isMemory",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isMemory((ComponentInstance) receiver)));
		MEMBERS.put("isProcess",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isProcess((ComponentInstance) receiver)));
		MEMBERS.put("isProcessor",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isProcessor((ComponentInstance) receiver)));
		MEMBERS.put("isSubprogram",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSubprogram((ComponentInstance) receiver)));
		MEMBERS.put("isSubprogramGroup",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSubprogramGroup((ComponentInstance) receiver)));
		MEMBERS.put("isSystem",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isSystem((ComponentInstance) receiver)));
		MEMBERS.put("isThread",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isThread((ComponentInstance) receiver)));
		MEMBERS.put("isThreadGroup",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isThreadGroup((ComponentInstance) receiver)));
		MEMBERS.put("isVirtualBus",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isVirtualBus((ComponentInstance) receiver)));
		MEMBERS.put("isVirtualProcessor",
				new SimpleMember(BooleanType.INSTANCE, receiver -> isVirtualProcessor((ComponentInstance) receiver)));
		MEMBERS.put("processorBindingSources", new SimpleMember(new ListType(ComponentInstanceType.INSTANCE),
				receiver -> processorBindingSources((ComponentInstance) receiver)));
	}

	private ComponentInstanceType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public String toString() {
		return "ComponentInstance";
	}

	private static String name(ComponentInstance receiver) {
		return receiver.getName();
	}

	private static ComponentCategory category(ComponentInstance receiver) {
		return receiver.getCategory();
	}

	private static List<ComponentInstance> subcomponents(ComponentInstance receiver) {
		return receiver.getComponentInstances();
	}

	private static List<ComponentInstance> allSubcomponents(ComponentInstance receiver) {
		var result = new ArrayList<ComponentInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ComponentInstance subcomponent) {
				result.add(subcomponent);
			}
		});
		return result;
	}

	private static List<FeatureInstance> features(ComponentInstance receiver) {
		return receiver.getFeatureInstances();
	}

	private static List<FeatureInstance> allFeatures(ComponentInstance receiver) {
		var result = new ArrayList<FeatureInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof FeatureInstance feature) {
				result.add(feature);
			}
		});
		return result;
	}

	private static List<ModeInstance> localModes(ComponentInstance receiver) {
		return receiver.getModeInstances();
	}

	private static List<ModeInstance> allModes(ComponentInstance receiver) {
		var result = new ArrayList<ModeInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ModeInstance mode) {
				result.add(mode);
			}
		});
		return result;
	}

	private static List<ModeTransitionInstance> modeTransitions(ComponentInstance receiver) {
		return receiver.getModeTransitionInstances();
	}

	private static List<ModeTransitionInstance> allModeTransitions(ComponentInstance receiver) {
		var result = new ArrayList<ModeTransitionInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ModeTransitionInstance transition) {
				result.add(transition);
			}
		});
		return result;
	}

	private static List<FlowSpecificationInstance> flowSpecifications(ComponentInstance receiver) {
		return receiver.getFlowSpecifications();
	}

	private static List<FlowSpecificationInstance> allFlowSpecifications(ComponentInstance receiver) {
		var result = new ArrayList<FlowSpecificationInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof FlowSpecificationInstance flow) {
				result.add(flow);
			}
		});
		return result;
	}

	private static List<EndToEndFlowInstance> endToEndFlows(ComponentInstance receiver) {
		return receiver.getEndToEndFlows();
	}

	private static List<EndToEndFlowInstance> allEndToEndFlows(ComponentInstance receiver) {
		var result = new ArrayList<EndToEndFlowInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof EndToEndFlowInstance flow) {
				result.add(flow);
			}
		});
		return result;
	}

	private static List<ConnectionInstance> connections(ComponentInstance receiver) {
		return receiver.getConnectionInstances();
	}

	private static List<ConnectionInstance> allConnections(ComponentInstance receiver) {
		var result = new ArrayList<ConnectionInstance>();
		receiver.eAllContents().forEachRemaining(element -> {
			if (element instanceof ConnectionInstance connection) {
				result.add(connection);
			}
		});
		return result;
	}

	private static List<ModeInstance> inModes(ComponentInstance receiver) {
		return receiver.getInModes();
	}

	private static Optional<ComponentInstance> parent(ComponentInstance receiver) {
		if (receiver.eContainer() instanceof ComponentInstance container) {
			return Optional.of(container);
		} else {
			return Optional.empty();
		}
	}

	private static Boolean isAbstract(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.ABSTRACT;
	}

	private static Boolean isBus(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.BUS;
	}

	private static Boolean isData(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.DATA;
	}

	private static Boolean isDevice(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.DEVICE;
	}

	private static Boolean isMemory(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.MEMORY;
	}

	private static Boolean isProcess(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.PROCESS;
	}

	private static Boolean isProcessor(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.PROCESSOR;
	}

	private static Boolean isSubprogram(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SUBPROGRAM;
	}

	private static Boolean isSubprogramGroup(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SUBPROGRAM_GROUP;
	}

	private static Boolean isSystem(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.SYSTEM;
	}

	private static Boolean isThread(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.THREAD;
	}

	private static Boolean isThreadGroup(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.THREAD_GROUP;
	}

	private static Boolean isVirtualBus(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.VIRTUAL_BUS;
	}

	private static Boolean isVirtualProcessor(ComponentInstance receiver) {
		return receiver.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR;
	}

	private static List<ComponentInstance> processorBindingSources(ComponentInstance receiver) {
		var result = new ArrayList<ComponentInstance>();
		for (var iterator = receiver.eResource().getAllContents(); iterator.hasNext();) {
			if (iterator.next() instanceof ComponentInstance component) {
				if (DeploymentProperties.getActualProcessorBinding(component)
						.filter(targets -> targets.contains(receiver))
						.isPresent()) {
					result.add(component);
				}
			} else {
				iterator.prune();
			}
		}
		return result;
	}
}