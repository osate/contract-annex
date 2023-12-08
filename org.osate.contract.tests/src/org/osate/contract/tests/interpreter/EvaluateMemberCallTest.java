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
package org.osate.contract.tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.tuples.Tuple;
import org.osate.contract.typing.ContractInterpreter;
import org.osate.contract.typing.RangeValueHolder;
import org.osate.contract.typing.RecordValueHolder;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class EvaluateMemberCallTest {
	private static final String PATH = "org.osate.contract.tests/models/interpreter/EvaluateMemberCallTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractInterpreter interpreter;

	@Inject
	private ValidationTestHelper validationHelper;

	@SuppressWarnings("unchecked")
	@Test
	public void testComponentInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "component_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(36, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s_i_Instance", ((ComponentInstance) result.get("v1")).getName());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s_i_Instance", result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(ComponentCategory.SYSTEM, result.get("v3"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("left_process", "right_process", "nested_sub"),
					((List<ComponentInstance>) result.get("v4")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("left_process", "left_thread", "right_process", "right_thread", "nested_sub",
							"left_process", "left_thread", "right_process", "right_thread"),
					((List<ComponentInstance>) result.get("v5")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("s_i_Instance", "left_process", "left_thread", "right_process", "right_thread",
							"nested_sub",
							"left_process", "left_thread", "right_process", "right_thread"),
					((List<ComponentInstance>) result.get("v6")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("ep1"),
					((List<FeatureInstance>) result.get("v7")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("ep1", "left_process_port", "left_thread_port", "ep2", "right_process_port",
							"right_thread_port", "left_process_port", "left_thread_port", "ep2", "right_process_port",
							"right_thread_port"),
					((List<FeatureInstance>) result.get("v8")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_m1", "outer_m2"),
					((List<ModeInstance>) result.get("v9")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(9), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("inner_m1", "inner_m2", "inner_m1", "inner_m2", "outer_m1", "outer_m2"),
					((List<ModeInstance>) result.get("v10")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(10), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_m1_ep1_outer_m2"),
					((List<ModeTransitionInstance>) result.get("v11")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(11), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("inner_m1_ep2_inner_m2", "inner_m1_ep2_inner_m2", "outer_m1_ep1_outer_m2"),
					((List<ModeTransitionInstance>) result.get("v12")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(12), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_flow_spec"),
					((List<FlowSpecificationInstance>) result.get("v13")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(13), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("left_thread_source", "left_source", "right_thread_sink", "right_sink",
							"left_thread_source", "left_source", "right_thread_sink", "right_sink", "outer_flow_spec"),
					((List<FlowSpecificationInstance>) result.get("v14")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(14), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("etef1"),
					((List<EndToEndFlowInstance>) result.get("v15")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(15), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("etef2", "etef1"),
					((List<EndToEndFlowInstance>) result.get("v16")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(16), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List
					.of("left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port"),
					((List<ConnectionInstance>) result.get("v17")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(17), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of(
					"left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port",
					"left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port"),
					((List<ConnectionInstance>) result.get("v18")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(18), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Collections.emptyList(), result.get("v19"));
		});
		with(contract.getQueries().get(19), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v20"));
		});
		with(contract.getQueries().get(20), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v21"));
		});
		with(contract.getQueries().get(21), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v22"));
		});
		with(contract.getQueries().get(22), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v23"));
		});
		with(contract.getQueries().get(23), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v24"));
		});
		with(contract.getQueries().get(24), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v25"));
		});
		with(contract.getQueries().get(25), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v26"));
		});
		with(contract.getQueries().get(26), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v27"));
		});
		with(contract.getQueries().get(27), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v28"));
		});
		with(contract.getQueries().get(28), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v29"));
		});
		with(contract.getQueries().get(29), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v30"));
		});
		with(contract.getQueries().get(30), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v31"));
		});
		with(contract.getQueries().get(31), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v32"));
		});
		with(contract.getQueries().get(32), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v33"));
		});
		with(contract.getQueries().get(33), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v34"));
		});
		with(contract.getQueries().get(34), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("state1", "state2"),
					((List<StateInstance>) result.get("v35")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(35), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("event1", "event2"),
					((List<EventInstance>) result.get("v36")).stream().map(NamedElement::getName).toList());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testComponentInstanceInModesAndParentTest() throws Exception {
		var pkg = testHelper.parseFile(PATH + "component_instance_in_modes_and_parent_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var subcomponent = systemInstance.getComponentInstances().get(0);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", subcomponent));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(2, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("m1"),
					((List<ModeInstance>) result.get("v1")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("in_modes_test_i_Instance", ((Optional<ComponentInstance>) result.get("v2")).get().getName());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testComponentInstanceBindingTest() throws Exception {
		var pkg = testHelper.parseFile(PATH + "component_instance_binding_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var value = (List<List<ComponentInstance>>) result.get("v1");
			assertEquals(2, value.size());
			assertIterableEquals(List.of("thread1", "thread3"),
					value.get(0).stream().map(NamedElement::getName).toList());
			assertEquals(0, value.get(1).size());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSystemInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "system_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var subcomponent = systemInstance.getComponentInstances().get(0);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", subcomponent));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(36, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s_i_Instance", ((ComponentInstance) result.get("v1")).getName());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s_i_Instance", result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(ComponentCategory.SYSTEM, result.get("v3"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("left_process", "right_process", "nested_sub"),
					((List<ComponentInstance>) result.get("v4")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("left_process", "left_thread", "right_process", "right_thread", "nested_sub",
							"left_process", "left_thread", "right_process", "right_thread"),
					((List<ComponentInstance>) result.get("v5")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("s_i_Instance", "left_process", "left_thread", "right_process", "right_thread",
							"nested_sub", "left_process", "left_thread", "right_process", "right_thread"),
					((List<ComponentInstance>) result.get("v6")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("ep1"),
					((List<FeatureInstance>) result.get("v7")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("ep1", "left_process_port", "left_thread_port", "ep2", "right_process_port",
							"right_thread_port", "left_process_port", "left_thread_port", "ep2", "right_process_port",
							"right_thread_port"),
					((List<FeatureInstance>) result.get("v8")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_m1", "outer_m2"),
					((List<ModeInstance>) result.get("v9")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(9), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("inner_m1", "inner_m2", "inner_m1", "inner_m2", "outer_m1", "outer_m2"),
					((List<ModeInstance>) result.get("v10")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(10), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_m1_ep1_outer_m2"),
					((List<ModeTransitionInstance>) result.get("v11")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(11), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("inner_m1_ep2_inner_m2", "inner_m1_ep2_inner_m2", "outer_m1_ep1_outer_m2"),
					((List<ModeTransitionInstance>) result.get("v12")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(12), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("outer_flow_spec"),
					((List<FlowSpecificationInstance>) result.get("v13")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(13), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("left_thread_source", "left_source", "right_thread_sink", "right_sink",
							"left_thread_source", "left_source", "right_thread_sink", "right_sink", "outer_flow_spec"),
					((List<FlowSpecificationInstance>) result.get("v14")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(14), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("etef1"),
					((List<EndToEndFlowInstance>) result.get("v15")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(15), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("etef2", "etef1"),
					((List<EndToEndFlowInstance>) result.get("v16")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(16), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List
					.of("left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port"),
					((List<ConnectionInstance>) result.get("v17")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(17), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of(
					"left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port",
					"left_process.left_thread.left_thread_port -> right_process.right_thread.right_thread_port"),
					((List<ConnectionInstance>) result.get("v18")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(18), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("som_1", "som_2", "som_3", "som_4", "som_5", "som_6", "som_7", "som_8"),
					((List<SystemOperationMode>) result.get("v19")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(19), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v20"));
		});
		with(contract.getQueries().get(20), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v21"));
		});
		with(contract.getQueries().get(21), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v22"));
		});
		with(contract.getQueries().get(22), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v23"));
		});
		with(contract.getQueries().get(23), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v24"));
		});
		with(contract.getQueries().get(24), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v25"));
		});
		with(contract.getQueries().get(25), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v26"));
		});
		with(contract.getQueries().get(26), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v27"));
		});
		with(contract.getQueries().get(27), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v28"));
		});
		with(contract.getQueries().get(28), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v29"));
		});
		with(contract.getQueries().get(29), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v30"));
		});
		with(contract.getQueries().get(30), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v31"));
		});
		with(contract.getQueries().get(31), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v32"));
		});
		with(contract.getQueries().get(32), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v33"));
		});
		with(contract.getQueries().get(33), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v34"));
		});
		with(contract.getQueries().get(34), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("state1", "state2"),
					((List<StateInstance>) result.get("v35")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(35), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("event1", "event2"),
					((List<EventInstance>) result.get("v36")).stream().map(NamedElement::getName).toList());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testList() throws Exception {
		var pkg = testHelper.parseFile(PATH + "list_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(18, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(0, (Long) result.get("v1"));
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(5, (Long) result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v3"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v4"));
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v5"));
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("process_1", ((Optional<ComponentInstance>) result.get("v6")).get().getName());
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("process_1", "process_2", "process_3"),
					((List<ComponentInstance>) result.get("v7")).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("(process_1, process_1)", "(process_2, process_2)", "(process_3, process_3)"),
					((List<Tuple>) result.get("v8")).stream()
							.map(tuple -> "(" + tuple.getElements().get(0) + ", "
									+ ((ComponentInstance) tuple.getElements().get(1)).getName() + ")")
							.toList());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("process_1", "process_2", "process_3", "ps_with_features_1", "ps_with_features_2"),
					(List<String>) result.get("v9"));
		});
		with(contract.getQueries().get(9), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(
					List.of("process_1", "process_2", "process_3", "ps_with_features_1", "ps_with_features_2"),
					(List<String>) result.get("v10"));
		});
		with(contract.getQueries().get(10), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v11"));
		});
		with(contract.getQueries().get(11), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v12"));
		});
		with(contract.getQueries().get(12), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("f1", "f2"),
					((Optional<List<FeatureInstance>>) result.get("v13")).get()
							.stream()
							.map(NamedElement::getName)
							.toList());
		});
		with(contract.getQueries().get(13), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("process_1", "process_2", "process_3"),
					((Optional<List<ComponentInstance>>) result.get("v14")).get()
							.stream()
							.map(NamedElement::getName)
							.toList());
		});
		with(contract.getQueries().get(14), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of(1L, 3L), (List<Long>) result.get("v15"));
		});
		with(contract.getQueries().get(15), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of(1L, 3L), (List<Long>) result.get("v16"));
		});
		with(contract.getQueries().get(16), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var list = (List<Tuple>) result.get("v17");
			assertEquals(2, list.size());
			assertIterableEquals(List.of("process_1", 1L), list.get(0).getElements());
			assertIterableEquals(List.of("process_3", 3L), list.get(1).getElements());
		});
		with(contract.getQueries().get(17), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("f1", "f2", "f1", "f2"),
					((List<FeatureInstance>) result.get("v18")).stream().map(NamedElement::getName).toList());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOptional() throws Exception {
		var pkg = testHelper.parseFile(PATH + "optional_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(9, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("85 GBytesps", ((Optional<IntegerLiteral>) result.get("v1")).get().toString());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("85 GBytesps", ((Optional<IntegerLiteral>) result.get("v3")).get().toString());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[10 ms .. 100 ms]", ((Optional<RangeValueHolder>) result.get("v4")).get().toString());
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v5"));
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(false, result.get("v6"));
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(true, result.get("v7"));
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("sub1", ((Optional<ComponentInstance>) result.get("v8")).get().getName());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("v9"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLongWithUnits() throws Exception {
		var pkg = testHelper.parseFile(PATH + "long_with_units_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(5000.0, ((Optional<Double>) result.get("v1")).get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLongRange() throws Exception {
		var pkg = testHelper.parseFile(PATH + "long_range_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(4, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(1, ((Optional<Long>) result.get("v1")).get());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(20, ((Optional<Long>) result.get("v2")).get());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(3, ((Optional<Optional<Long>>) result.get("v3")).get().get());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), ((Optional<Optional<Optional<Long>>>) result.get("v4")).get().get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testLongRangeWithUnits() throws Exception {
		var pkg = testHelper.parseFile(PATH + "long_range_with_units_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(4, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("1 ms", ((Optional<IntegerLiteral>) result.get("v1")).get().toString());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("20 ms", ((Optional<IntegerLiteral>) result.get("v2")).get().toString());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("3 ms", ((Optional<Optional<IntegerLiteral>>) result.get("v3")).get().get().toString());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(),
					((Optional<Optional<Optional<IntegerLiteral>>>) result.get("v4")).get().get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDoubleRange() throws Exception {
		var pkg = testHelper.parseFile(PATH + "double_range_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(4, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("1.1", ((Optional<Double>) result.get("v1")).get().toString());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("20.2", ((Optional<Double>) result.get("v2")).get().toString());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("3.3", ((Optional<Optional<Double>>) result.get("v3")).get().get().toString());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), ((Optional<Optional<Optional<Double>>>) result.get("v4")).get().get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDoubleRangeWithUnits() throws Exception {
		var pkg = testHelper.parseFile(PATH + "double_range_with_units_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(4, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("1.1 ms", ((Optional<RealLiteral>) result.get("v1")).get().toString());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("20.2 ms", ((Optional<RealLiteral>) result.get("v2")).get().toString());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("3.3 ms", ((Optional<Optional<RealLiteral>>) result.get("v3")).get().get().toString());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), ((Optional<Optional<Optional<RealLiteral>>>) result.get("v4")).get().get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecord() throws Exception {
		var pkg = testHelper.parseFile(PATH + "record_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(16, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), ((Optional<Optional<Boolean>>) result.get("v1")).get());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue(((Optional<Optional<Boolean>>) result.get("v2")).get().get());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("string value", ((Optional<Optional<String>>) result.get("v3")).get().get());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s", ((Optional<Optional<SystemType>>) result.get("v4")).get().get().getName());
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("red", ((Optional<Optional<EnumerationLiteral>>) result.get("v5")).get().get().getName());
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(1, ((Optional<Optional<Long>>) result.get("v6")).get().get());
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("2 ms", ((Optional<Optional<IntegerLiteral>>) result.get("v7")).get().get().toString());
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(3.4, ((Optional<Optional<Double>>) result.get("v8")).get().get());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("5.6 min", ((Optional<Optional<RealLiteral>>) result.get("v9")).get().get().toString());
		});
		with(contract.getQueries().get(9), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[7 .. 70]",
					((Optional<Optional<RangeValueHolder>>) result.get("v10")).get().get().toString());
		});
		with(contract.getQueries().get(10), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[8 hr .. 80 hr]",
					((Optional<Optional<RangeValueHolder>>) result.get("v11")).get().get().toString());
		});
		with(contract.getQueries().get(11), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[9.9 .. 10.01]",
					((Optional<Optional<RangeValueHolder>>) result.get("v12")).get().get().toString());
		});
		with(contract.getQueries().get(12), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[11.11 ms .. 12.12 ms]",
					((Optional<Optional<RangeValueHolder>>) result.get("v13")).get().get().toString());
		});
		with(contract.getQueries().get(13), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var recordValue = ((Optional<Optional<RecordValueHolder>>) result.get("v14")).get().get().getValue();
			assertEquals(1, recordValue.getOwnedFieldValues().size());
			with(recordValue.getOwnedFieldValues().get(0), field -> {
				assertEquals("nested_field", field.getProperty().getName());
				assertEquals("nested value", ((StringLiteral) field.getOwnedValue()).getValue());
			});
		});
		with(contract.getQueries().get(14), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("sub1", ((Optional<Optional<ComponentInstance>>) result.get("v15")).get().get().getName());
		});
		with(contract.getQueries().get(15), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("one", "two", "three"),
					((Optional<Optional<List<String>>>) result.get("v16")).get().get());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testEndToEndFlowInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "end_to_end_flow_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var value = (List<List<FlowSpecificationInstance>>) result.get("v1");
			assertEquals(4, value.size());
			assertIterableEquals(List.of("source1", "path1"),
					value.get(0).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("source1", "path1", "sink1"),
					value.get(1).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("path2"), value.get(2).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("path2", "sink2"), value.get(3).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var value = (List<List<ConnectionInstance>>) result.get("v2");
			assertEquals(4, value.size());
			assertIterableEquals(List.of("left.outf -> middle.inf"),
					value.get(0).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("left.outf -> middle.inf", "middle.outf -> right.inf"),
					value.get(1).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("d -> middle.rda"), value.get(2).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("d -> middle.rda", "middle.pda -> right.rda"),
					value.get(3).stream().map(NamedElement::getName).toList());
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var value = (List<List<ComponentInstance>>) result.get("v3");
			assertEquals(4, value.size());
			assertIterableEquals(List.of("left", "middle"), value.get(0).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("left", "middle", "right"),
					value.get(1).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("d", "middle"), value.get(2).stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("d", "middle", "right"),
					value.get(3).stream().map(NamedElement::getName).toList());
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testStateInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "state_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("state1", "state2"), (List<String>) result.get("v1"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testEventInstance() throws Exception {
		var pkg = testHelper.parseFile(PATH + "event_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("event1", "event2"), (List<String>) result.get("v1"));
		});
	}
}