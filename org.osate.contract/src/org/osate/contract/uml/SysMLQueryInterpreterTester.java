package org.osate.contract.uml;

public class SysMLQueryInterpreterTester {

	public static void main(String args[]) {
		SysMLQueryInterpreter interpreter = new SysMLQueryInterpreter();
		String modelPath = "/SEI/Tools/cameo/temp/MQLTest1.uml";

		interpreter.setvar_loadModel("model", modelPath);
		interpreter.setvar_loadDiagram("sequence", "model", "SelfCheckingPair1Sequence");
		interpreter.setvar_endToEndFlows("e2eflows", "sequence", "name,period");

		System.out.println("E2eFlows: " + interpreter.getQueryVariableValue("e2eflows"));
	}
}
