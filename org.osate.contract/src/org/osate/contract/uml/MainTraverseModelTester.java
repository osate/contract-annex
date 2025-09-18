package org.osate.contract.uml;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Package;

public class MainTraverseModelTester {

	public static void main(String[] args) {
		TraverseModel traverser = new TraverseModel();

		Package umlPackage = traverser.loadModel("/SEI/Tools/cameo/temp/MQLTest1.uml");

		var diags = traverser.getDiagrams(umlPackage);

		for (var d : diags) {
			if (!d.isEmpty() && d.getFirst() instanceof Interaction) {
				for (Behavior behavior : d) {
					Interaction inter = (Interaction) behavior;
					var e2eflows = traverser.getEndToEndFlowsFromInteraction(inter);
					for (var e2ef : e2eflows) {
						System.out.print("Node(" + e2ef.getSource().getDiagNode().getName() + ")");
						FlowNode nextNode = e2ef.getSource();
						for (var nextEdge = e2ef.getNextEdge(nextNode); nextEdge != null; nextEdge = e2ef
								.getNextEdge(nextNode)) {
							var msg = nextEdge.getMessage();
							System.out.print("-[" + msg.getName() + "]->");
							nextNode = nextEdge.getDstNode();
							System.out.print("Node(" + nextNode.getDiagNode().getName() + ")");
						}
						System.out.println(" ");
					}
				}
			}
		}
	}
}
