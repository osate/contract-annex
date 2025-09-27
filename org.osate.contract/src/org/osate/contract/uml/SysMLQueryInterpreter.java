package org.osate.contract.uml;

import java.util.HashMap;

import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

public class SysMLQueryInterpreter {
	HashMap<String, Object> queryVariables = new HashMap<String, Object>();

	int nextId = 0;

	HashMap<Integer, Object> id2object = new HashMap<Integer, Object>();
	HashMap<Object, Integer> object2id = new HashMap<Object, Integer>();

	TraverseModel modelTraverser = new TraverseModel();

	public Object getQueryVariableValue(String varname) {
		return queryVariables.get(varname);
	}

	public String setvar_loadModel(String varName, String modelPath) {
		var model = modelTraverser.loadModel(modelPath);
		if (model != null) {
			queryVariables.put(varName, model);
		}
		return null;
	}

	public String setvar_loadDiagram(String diagQueryVar, String modelQueryVar, String diagName) {
		var model = queryVariables.get(modelQueryVar);
		if (model != null) {
			try {
				var diagram = modelTraverser.getDiagram((PackageableElement) model, diagName);
				if (diagram != null) {
					queryVariables.put(diagQueryVar, diagram);
				}
			} catch (ClassCastException e) {
				return "Variable " + diagName + " is not a diagram";
			}
		}
		return null;
	}

	public int getId(Object o) {
		Integer id = object2id.get(o);
		if (id == null) {
			id = nextId++;
			object2id.put(o, id);
			id2object.put(id, o);
		}

		return id;
	}

	public Object getObjectFromId(Integer id) {
		return id2object.get(id);
	}

	public String getValueAsString(ValueSpecification val) {
		String strval = "";

		if (val instanceof LiteralInteger) {
			strval += val.integerValue();
		} else if (val instanceof LiteralBoolean) {
			strval += val.booleanValue();
		} else if (val instanceof LiteralReal) {
			strval += val.realValue();
		} else if (val instanceof LiteralString) {
			strval += val.stringValue();
		}
		return strval;
	}

	public String getNodePropertyValues(FlowNode node, String[] propNames) {
		String result = "";
		String separator = "";

		for (var pname : propNames) {
			// first well-known properties like name
			if (pname.equalsIgnoreCase("name")) {
				result += separator + "'" + node.getDiagNode().getName() + "'";
				separator = ",";
			} else {
				// then user-defined properties
				var type = node.getDiagNode().getType();
				for (var e : type.getOwnedElements()) {
					if (e instanceof Property) {
						var prop = (Property) e;
						if (prop.getName().equalsIgnoreCase(pname)) {
							var val = prop.getDefaultValue();
							if (val != null) {
								result += separator + getValueAsString(val);
								separator = ",";
							}
						}
					}
				}
			}
		}

		return result;
	}

	public String setvar_endToEndFlows(String e2eFlowsQueryVar, String diagQueryVar, String propertyNames) {
		var diagram = queryVariables.get(diagQueryVar);
		String[] propNames = propertyNames.split(",");
		if (diagram != null) {
			try {
				var e2eflows = modelTraverser.getEndToEndFlowsFromInteraction((Interaction) diagram);
				String result = "[";
				String sep = "";
				for (var e2ef : e2eflows) {
					// System.out.print("Node(" + e2ef.getSource().getDiagNode().getName() + ")");
					FlowNode nextNode = e2ef.getSource();
					result += sep + "["; // for e2eflow
					result += "["; // for the source node
					result += getId(nextNode.getDiagNode());
					result += "," + getNodePropertyValues(nextNode, propNames);
					result += "]"; // for the source node
					String sep1 = "";
					for (var nextEdge = e2ef.getNextEdge(nextNode); nextEdge != null; nextEdge = e2ef
							.getNextEdge(nextNode)) {
						var msg = nextEdge.getMessage();
						result += ",[" + getId(msg) + "," + "'" + msg.getName() + "'" + "],";
						nextNode = nextEdge.getDstNode();
						result += "["; // for the node
						result += getId(nextNode.getDiagNode());
						result += "," + getNodePropertyValues(nextNode, propNames);
						result += "]"; // for the node
						sep1 = ",";
					}
					result += "]"; // for the e2eflow
					sep = ",";
				}
				result += "]"; // for the end2end flows
				queryVariables.put(e2eFlowsQueryVar, result);
			} catch (ClassCastException e) {
				return "Variable " + diagQueryVar + " is not an interaction diagram";
			}
		}
		return null;
	}

	public String parseAndExecuteQuery(String varname, String query) {
		String result = "";

		// action = 'loadModel('path')

		String action = query.split("[(]")[0];

		if (action.equalsIgnoreCase("loadModel")) {
			String modelPath = query.split("[(]")[1].split("[)]")[0];
			setvar_loadModel(varname, modelPath);
			result = "<internal sysml query value>";
		} else if (action.equalsIgnoreCase("loadDiagram")) {
			// action = loadDiagram(modelVarName, diagramName)
			String modelVarName = query.split("[(]")[1].split(",")[0];
			String diagramName = query.split("[(]")[1].split(",")[1].split("[)]")[0];
			setvar_loadDiagram(varname, modelVarName, diagramName);
			result = "<internal sysml query value>";
		} else if (action.equalsIgnoreCase("end2endFlows")) {
			// action = end2endFlow(diagramQueryVarName,propertyList)
			String diagQueryVarName = query.split("[(]")[1].split(",")[0];
			String propertyList = query.split("[(]")[1].split("[)]")[0];
			var propertyArray = propertyList.split(",");
			propertyList = "";
			String sep = "";
			for (int i = 1; i < propertyArray.length; i++) {
				propertyList += sep + propertyArray[i];
				sep = ",";
			}
			setvar_endToEndFlows(varname, diagQueryVarName, propertyList);
			result = (String) getQueryVariableValue(varname);
		}
		return result;
	}
}
