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

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;

public final class EndToEndFlowInstanceType implements Type {
	public static final EndToEndFlowInstanceType INSTANCE = new EndToEndFlowInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
		MEMBERS.put("flowSpecifications", new FlowSpecificationsMember());
		MEMBERS.put("connections", new ConnectionsMember());
		MEMBERS.put("components", new ComponentsMember());
	}

	private EndToEndFlowInstanceType() {
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
		return "EndToEndFlowInstance";
	}

	private static class NameMember implements SimpleMember<EndToEndFlowInstance, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(EndToEndFlowInstance receiver) {
			return receiver.getName();
		}
	}

	private static List<FlowSpecificationInstance> flowSpecifications(EndToEndFlowInstance receiver) {
		var result = new ArrayList<FlowSpecificationInstance>();
		for (var element : receiver.getFlowElements()) {
			if (element instanceof FlowSpecificationInstance flowSpecificationInstance) {
				result.add(flowSpecificationInstance);
			} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
				result.addAll(flowSpecifications(endToEndFlowInstance));
			}
		}
		return result;
	}

	private static class FlowSpecificationsMember
			implements SimpleMember<EndToEndFlowInstance, List<FlowSpecificationInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(FlowSpecificationInstanceType.INSTANCE);
		}

		@Override
		public List<FlowSpecificationInstance> evaluate(EndToEndFlowInstance receiver) {
			var result = new ArrayList<FlowSpecificationInstance>();
			for (var element : receiver.getFlowElements()) {
				if (element instanceof FlowSpecificationInstance flowSpecificationInstance) {
					result.add(flowSpecificationInstance);
				} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
					result.addAll(flowSpecifications(endToEndFlowInstance));
				}
			}
			return result;
		}
	}

	private static List<ConnectionInstance> connections(EndToEndFlowInstance receiver) {
		var result = new ArrayList<ConnectionInstance>();
		for (var element : receiver.getFlowElements()) {
			if (element instanceof ConnectionInstance connectionInstance) {
				result.add(connectionInstance);
			} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
				result.addAll(connections(endToEndFlowInstance));
			}
		}
		return result;
	}

	private static class ConnectionsMember implements SimpleMember<EndToEndFlowInstance, List<ConnectionInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ConnectionInstanceType.INSTANCE);
		}

		@Override
		public List<ConnectionInstance> evaluate(EndToEndFlowInstance receiver) {
			var result = new ArrayList<ConnectionInstance>();
			for (var element : receiver.getFlowElements()) {
				if (element instanceof ConnectionInstance connectionInstance) {
					result.add(connectionInstance);
				} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
					result.addAll(connections(endToEndFlowInstance));
				}
			}
			return result;
		}
	}

	private static List<ComponentInstance> components(EndToEndFlowInstance receiver) {
		var result = new ArrayList<ComponentInstance>();
		for (var element : receiver.getFlowElements()) {
			if (element instanceof ComponentInstance componentInstance) {
				result.add(componentInstance);
			} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
				result.addAll(components(endToEndFlowInstance));
			} else if (element instanceof FlowSpecificationInstance spec) {
				result.add(spec.getContainingComponentInstance());
			}
		}
		return result;
	}

	private static class ComponentsMember implements SimpleMember<EndToEndFlowInstance, List<ComponentInstance>> {
		@Override
		public Type getReturnType() {
			return new ListType(ComponentInstanceType.INSTANCE);
		}

		@Override
		public List<ComponentInstance> evaluate(EndToEndFlowInstance receiver) {
			var result = new ArrayList<ComponentInstance>();
			for (var element : receiver.getFlowElements()) {
				if (element instanceof ComponentInstance componentInstance) {
					result.add(componentInstance);
				} else if (element instanceof EndToEndFlowInstance endToEndFlowInstance) {
					result.addAll(components(endToEndFlowInstance));
				} else if (element instanceof FlowSpecificationInstance spec) {
					result.add(spec.getContainingComponentInstance());
				}
			}
			return result;
		}
	}
}