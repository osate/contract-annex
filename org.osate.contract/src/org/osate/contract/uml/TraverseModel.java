/**
 * FASR Source Code
 *
 * Copyright 2025 Carnegie Mellon University.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING
 * INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS
 * TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE
 * MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND
 * WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Licensed under a MIT (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 *
 * [DISTRIBUTION STATEMENT A] This material has been approved for public
 * release and unlimited distribution.  Please see Copyright notice for non-US
 * Government use and distribution.
 *
 * DM25-0946
 */

package org.osate.contract.uml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class TraverseModel {
		private Package model;
		private ResourceSet resources;
		private URI modelURI;
		/*
		 * Class constructor
		 */
		public TraverseModel() {
			this.model = null;
		}

		/*
		 * Class constructor specifying project path
		 * @param path 	specifies path to UML file to load
		 */
		public TraverseModel(String path) {
			this.model = loadModel(path);
		}


		/*
		 * Loads the UML model into memory
		 *
		 * @param 	path	specifies path to UML file to load
		 * @return			a Package object containing the model
		 */
		public Package loadModel(String path) {
			this.resources = new ResourceSetImpl();
			UMLResourcesUtil.init(resources);
			Resource modelResource;

			try {
				this.modelURI  = URI.createFileURI(path);
				modelResource = resources.getResource(modelURI  , true);
                EcoreUtil.resolveAll(modelResource);
			} catch (RuntimeException e) {
                System.err.println(e.getMessage());
                return null;
			}
			Package umlPackage = (Package) EcoreUtil.getObjectByType(modelResource.getContents(),UMLPackage.Literals.PACKAGE);
			EcoreUtil.resolveAll(umlPackage);
			return umlPackage;
		}


		/*
		 * Returns a list of StateMachines from a project
		 *
		 * @param	p	a PackageableElement
		 * @return		a list of state machines
		 */
		public EList<BasicEList<Behavior>> getDiagrams(PackageableElement p) {
			EList<BasicEList<Behavior>> result = new BasicEList<BasicEList<Behavior>>();
			BasicEList<Behavior> machineList = new BasicEList<Behavior>();
			BasicEList<Behavior> environmentList = new BasicEList<Behavior>();
			BasicEList<Behavior> interactionList = new BasicEList<Behavior>();

			for(Element e : p.allOwnedElements()) {
				if(e instanceof StateMachine) {
					EList<Stereotype> i = e.getAppliedStereotypes();
					for(Stereotype stereotype : i) {
						if(stereotype.getName().equals("Machine")) {
							machineList.add((StateMachine) e);
						}
					}
				} else if(e instanceof Activity) {
					EList<Stereotype> i = e.getAppliedStereotypes();
					for(Stereotype stereotype : i) {
						if (stereotype.getName().equals("Environment")){
								environmentList.add((Activity) e);
						} else if (stereotype.getName().equals("Machine")) {
							// If the activity is specifically used to just send signals for the State Machine Diagram
							machineList.add((Activity) e);
						}
					}
				} else if (e instanceof Interaction) {
					interactionList.add((Interaction) e);
//					Interaction intaction = (Interaction) e;
//					TreeMap<String, Object> roles = new TreeMap<String, Object>();
//					for (var r : intaction.getRoles()) {
//						var n = r.getName();
//						System.out.println("role: " + n);
//						roles.put(n, r);
//					}
//					for (var a : intaction.getActions()) {
//						var n = a.getName();
//						System.out.println("action: " + n);
//					}
//					for (var o : intaction.getAllOperations()) {
//						var n = o.getName();
//						System.out.println("operation: " + n);
//					}
//					for (var i : intaction.getAllImplementedInterfaces()) {
//						var n = i.getName();
//						System.out.println("implemented interface: " + n);
//					}
//					for (var i : intaction.getAllUsedInterfaces()) {
//						var n = i.getName();
//						System.out.println("used interface: " + n);
//					}
//					for (var msg : intaction.getMessages()) {
//						var mname = msg.getName();
//						var signature = msg.getSignature();
//						System.out.println("msg(" + mname + ")");
////						if (signature != null) {
//						// This is the operation attached to it.
////							ClassImpl target = (ClassImpl) signature.eContainer();
////							var tn = target.getName();
////							System.out.println("target: " + tn);
////						}
//						var sevent = msg.getSendEvent();
//						for (var crossref : sevent.eCrossReferences()) {
//							if (crossref instanceof Lifeline) {
//								Lifeline ll = (Lifeline) crossref;
//								var srccomponent = ll.getRepresents();
//								var type = srccomponent.getType();
//								var comname = srccomponent.getName();
//								System.out.println("\tsender lifeline: " + type.getName() + ":" + comname);
//							}
//						}
//						var revent = msg.getReceiveEvent();
//						for (var crossref : revent.eCrossReferences()) {
//							if (crossref instanceof Lifeline) {
//								Lifeline ll = (Lifeline) crossref;
//								var tgtcomponent = ll.getRepresents();
//								var type = tgtcomponent.getType();
//								var comname = ll.getRepresents().getName();
//								System.out.println("\treceiver lifeline: " + type.getName() + ":" + comname);
//							}
//						}
//					}
				}
			}
			result.add(machineList);
			result.add(environmentList);
			result.add(interactionList);
			return result;
		}

		public List<EndToEndFlow> getE2EFlowForEdge(EndToEndFlow roote2eflow, FlowEdge edge,
				HashMap<FlowNode, List<FlowEdge>> edgeList) {

			ArrayList<EndToEndFlow> elist = new ArrayList<EndToEndFlow>();

			EndToEndFlow e2eflow = null;

			if (roote2eflow == null) {
				e2eflow = new EndToEndFlow();
				e2eflow.setSource(edge.getSrcNode());
			} else {
				// need to duplicate
				e2eflow = roote2eflow.deepClone();
			}

			e2eflow.addFlowEdge(edge);
			FlowNode node = edge.getDstNode();
			if (edgeList.get(node) != null) {
				for (var e : edgeList.get(node)) {
					var ef = getE2EFlowForEdge(e2eflow, e, edgeList);
					elist.addAll(ef);
				}
			} else {
				// at end of e2e
				elist.add(e2eflow);
			}

			return elist;
		}

		public Behavior getDiagram(PackageableElement p, String name) {
			for (Element e : p.allOwnedElements()) {
				if (e instanceof StateMachine) {
					StateMachine sm = (StateMachine) e;
					if (sm.getName().equalsIgnoreCase(name)) {
						EList<Stereotype> i = e.getAppliedStereotypes();
						for (Stereotype stereotype : i) {
							if (stereotype.getName().equals("Machine")) {
								return sm;
							}
						}
					}
				} else if (e instanceof Activity) {
					Activity a = (Activity) e;
					if (a.getName().equalsIgnoreCase(name)) {
						EList<Stereotype> i = e.getAppliedStereotypes();
						for (Stereotype stereotype : i) {
							if (stereotype.getName().equals("Environment")) {
								return a;
							} else if (stereotype.getName().equals("Machine")) {
								// If the activity is specifically used to just send signals for the State Machine Diagram
								return a;
							}
						}
					}
				} else if (e instanceof Interaction) {
					Interaction i = (Interaction) e;
					if (i.getName().equalsIgnoreCase(name)) {
						return i;
					}
				}
			}
			return null;
		}

		public List<EndToEndFlow> getEndToEndFlowsFromInteraction(Interaction i) {
			List<EndToEndFlow> e2elist = new ArrayList<EndToEndFlow>();
			HashMap<FlowNode, List<FlowEdge>> edgeList = new HashMap<FlowNode, List<FlowEdge>>();
			HashMap<ConnectableElement, FlowNode> diagToNode = new HashMap<ConnectableElement, FlowNode>();
			HashSet<FlowNode> roots = new HashSet<FlowNode>();
			HashSet<FlowNode> dsts = new HashSet<FlowNode>();
			for (var msg : i.getMessages()) {
				FlowNode srcNode = null;
				FlowNode dstNode = null;
				var sevent = msg.getSendEvent();
				for (var crossref : sevent.eCrossReferences()) {
					if (crossref instanceof Lifeline) {
						Lifeline ll = (Lifeline) crossref;
						var srccomponent = ll.getRepresents();
//						var type = srccomponent.getType();
//						for (var e : type.getOwnedElements()) {
//							if (e instanceof Property) {
//								var prop = (Property) e;
//								var val = prop.getDefaultValue();
//								if (val != null) {
//									int intval = val.integerValue();
//									System.out.println("Property(" + prop.getName() + "):" + intval);
//								}
//							}
//						}
						srcNode = diagToNode.get(srccomponent);
						if (srcNode == null) {
							srcNode = new FlowNode(srccomponent);
							diagToNode.put(srccomponent, srcNode);
							roots.add(srcNode);
						}
					}
				}
				var revent = msg.getReceiveEvent();
				for (var crossref : revent.eCrossReferences()) {
					if (crossref instanceof Lifeline) {
						Lifeline ll = (Lifeline) crossref;
						var tgtcomponent = ll.getRepresents();
						var type = tgtcomponent.getType();
						dstNode = diagToNode.get(tgtcomponent);
						if (dstNode == null) {
							dstNode = new FlowNode(tgtcomponent);
							diagToNode.put(tgtcomponent, dstNode);
							dsts.add(dstNode);
						} else {
							if (roots.contains(dstNode)) {
								roots.remove(dstNode);
							}
						}
					}
				}
				if (srcNode != null && dstNode != null) {
					FlowEdge edge = new FlowEdge(srcNode, dstNode, msg);
					List<FlowEdge> edges = edgeList.get(srcNode);
					if (edges == null) {
						edges = new ArrayList<FlowEdge>();
						edgeList.put(srcNode, edges);
					}
					edges.add(edge);
				}
			}

			for (var root : roots) {
				for (FlowEdge edge : edgeList.get(root)) {
					List<EndToEndFlow> e2ef2 = getE2EFlowForEdge(null, edge, edgeList);
					e2elist.addAll(e2ef2);
				}
			}

			return e2elist;
		}

		public EList<ActivityNode> getAllNodesFromActivity(Activity a){
			EList<ActivityNode> result = new BasicEList<ActivityNode>();

			for(Element e : a.allOwnedElements()) {
				if(e instanceof ActivityNode) {
					result.add((ActivityNode)e);
				}
			}
			return result;
		}

		/*
		 * Returns a list of States from a StateMachine
		 *
		 * @param	sm	a StateMachine
		 * @return		a list of states
		 */
		public EList<State> getAllStatesFromStateMachine(StateMachine sm){
			EList<State> result = new BasicEList<State>();
			for(Element e : sm.allOwnedElements()) {
				if(e instanceof State) {
					result.add((State) e);
				}
			}
			return result;
		}

		/*
		 * Returns the starting state of a StateMachine
		 *
		 * @param 	sm	a StateMachine
		 * @return		a State
		 */
		public State getFirstState(StateMachine sm) {
			// Get all states and find which one is transitioned to from InitialState
			for(State s : getAllStatesFromStateMachine(sm)) {
				for(Transition t : getTransitionsToState(s, Boolean.TRUE)) {
					// see if the state is being transitioned to from a Pseudostate
					if(t.getSource() instanceof Pseudostate) {
						// see if the Pseudostate is PseudostateKind.INITIAL
						if(((Pseudostate) t.getSource()).getKind() == PseudostateKind.get("initial")){
							return s;
						}

						System.out.println(((Pseudostate) t.getSource()).getKind().getValue());
					}
				}
			}
			System.out.println("Initial state not found!");
			return null;
		}


		/*
		 * Returns the the InitialNode of an Activity
		 *
		 *  @param	a	an Activity
		 *  @return		an ActivityNode
		 */
		public ActivityNode getFirstActivityNode(Activity a) {
			for(ActivityNode n : getAllNodesFromActivity(a)) {
				for(ActivityEdge ae : n.getIncomings()) {
					if (ae.getSource() instanceof InitialNode) {
						return ae.getSource();
					}
				}
			}
			return null;
		}

		/*
		 *  Gets all transitions where the given state is the target
		 *  If getPseudostates is true, then all transitions are returned
		 *  If getPseudostates is false, then transitions that include a Pseudostate are excluded
		 *
		 *  @param	s				a state
		 *  @param	getPseudostate	a boolean determining if pseudostates will be included
		 *  @return					a list of transitions
		 */
		public EList<Transition> getTransitionsToState(State s, Boolean getPseudostates){
			EList<Transition> result = new BasicEList<Transition>();
			Region region;
			if(s.eContainer() instanceof Region) {
				region = (Region) s.eContainer();
			}else {
				System.out.println("Unable to find region!");
				return null;
			}

			for(Transition t : region.getTransitions()) {
				if(t.getTarget() == s) {
					if(!getPseudostates && t.getSource() instanceof Pseudostate) {
						continue;
					}
					result.add(t);
				}
			}

			return result;
		}

		/*
		 * Gets all transitions where the given state is the source
		 *
		 *  @param s	a state
		 *  @return		a list of transitions
		 */
		public EList<Transition> getTransitionsFromState(State s){
			EList<Transition> result = new BasicEList<Transition>();
			Region region;
			if(s.eContainer() instanceof Region) {
				region = (Region) s.eContainer();
			}else {
				System.out.println("Unable to find region!");
				return null;
			}

			for(Transition t : region.getTransitions()) {
				if(t.getSource() == s) {
					result.add(t);
				}
			}

			return result;
		}

		/*
		 * Returns a single Trigger for a given Transition
		 * Only cares about getting the signal
		 *
		 * @param t		a transition
		 * @return		a signal
		 */
		public Signal getTransitionTrigger(Transition t) {
			// A transition can only have one trigger
			SignalEvent s = (SignalEvent) t.getTriggers().get(0).getEvent();
			s.getSignal().getName();
			return s.getSignal();
		}

		/*
		 * A getter that returns the UML model
		 *
		 * @return	a loaded UML model
		 */
		public Package getModel() {
			return this.model;
		}

		public boolean updateUML() {
			Map<String, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			Resource resource = resources.getResource(modelURI  , true);

			try {
			    resource.save(options);
			} catch (IOException e) {
			    e.printStackTrace();
			    return false;
			}
			return true;
		}

		public void exportModel() {
			Map<String, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			options.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

			URI newUri = URI.createFileURI("/Users/kehanna/GitRepos/fasr/TestUML/Diagrams/modified-model.uml");
			Resource newResource = this.resources.createResource(newUri);
			Resource modelResource = resources.getResource(modelURI  , true);
			newResource.getContents().add(modelResource.getContents().get(0)); // add the root element

			try {
				newResource.save(options);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Exported modified model to: " + newUri);

		}


}
