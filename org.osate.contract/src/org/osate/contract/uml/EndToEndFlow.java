package org.osate.contract.uml;

import java.util.HashMap;

public class EndToEndFlow {
	FlowNode source = null;
	HashMap<FlowNode, FlowEdge> nodeToEdge = new HashMap<FlowNode, FlowEdge>();

	public EndToEndFlow() {
	}

	public void setSource(FlowNode src) {
		source = src;
	}

	public FlowNode getSource() {
		return source;
	}

	public void addFlowEdge(FlowEdge edge) {
		nodeToEdge.put(edge.getSrcNode(), edge);
	}

	public FlowEdge getNextEdge(FlowNode n) {
		return nodeToEdge.get(n);
	}

	public EndToEndFlow deepClone() {
		EndToEndFlow c = new EndToEndFlow();
		c.setSource(getSource());
		c.nodeToEdge = (HashMap) nodeToEdge.clone();
		return c;
	}
}
