package org.osate.contract.uml;

import org.eclipse.uml2.uml.Message;

public class FlowEdge {
	FlowNode srcNode;
	FlowNode dstNode;
	Message diagMsg;

	public FlowEdge(FlowNode src, FlowNode dst, Message msg) {
		srcNode = src;
		dstNode = dst;
		diagMsg = msg;
	}

	public FlowNode getSrcNode() {
		return srcNode;
	}

	public FlowNode getDstNode() {
		return dstNode;
	}

	public Message getMessage() {
		return diagMsg;
	}
}
