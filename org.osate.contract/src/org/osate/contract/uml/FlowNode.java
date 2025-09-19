package org.osate.contract.uml;

import org.eclipse.uml2.uml.ConnectableElement;

public class FlowNode {
	ConnectableElement diagNode;

	public FlowNode(ConnectableElement e) {
		diagNode = e;
	}

	public ConnectableElement getDiagNode() {
		return diagNode;
	}
}
