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
package org.osate.contract.tests.typesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class MemberCallTest {
	private static final String PATH = "org.osate.contract.tests/models/typeSystem/MemberCallTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractTypeSystem typeSystem;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testComponentInstanceMembers() {
		var pkg = testHelper.parseFile(PATH + "component_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(35, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("String", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentCategory", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FeatureInstance>", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FeatureInstance>", type.toString());
		});
		with(contract.getQueries().get(6), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeInstance>", type.toString());
		});
		with(contract.getQueries().get(7), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeInstance>", type.toString());
		});
		with(contract.getQueries().get(8), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeTransitionInstance>", type.toString());
		});
		with(contract.getQueries().get(9), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeTransitionInstance>", type.toString());
		});
		with(contract.getQueries().get(10), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FlowSpecificationInstance>", type.toString());
		});
		with(contract.getQueries().get(11), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FlowSpecificationInstance>", type.toString());
		});
		with(contract.getQueries().get(12), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EndToEndFlowInstance>", type.toString());
		});
		with(contract.getQueries().get(13), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EndToEndFlowInstance>", type.toString());
		});
		with(contract.getQueries().get(14), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(15), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(16), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeInstance>", type.toString());
		});
		with(contract.getQueries().get(17), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentInstance?", type.toString());
		});
		with(contract.getQueries().get(18), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(19), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(20), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(21), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(22), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(23), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(24), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(25), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(26), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(27), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(28), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(29), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(30), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(31), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(32), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(33), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<StateInstance>", type.toString());
		});
		with(contract.getQueries().get(34), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EventInstance>", type.toString());
		});
	}

	@Test
	public void testSystemInstanceMembers() {
		var pkg = testHelper.parseFile(PATH + "system_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(33, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("String", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentCategory", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FeatureInstance>", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FeatureInstance>", type.toString());
		});
		with(contract.getQueries().get(6), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeInstance>", type.toString());
		});
		with(contract.getQueries().get(7), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeInstance>", type.toString());
		});
		with(contract.getQueries().get(8), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeTransitionInstance>", type.toString());
		});
		with(contract.getQueries().get(9), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ModeTransitionInstance>", type.toString());
		});
		with(contract.getQueries().get(10), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FlowSpecificationInstance>", type.toString());
		});
		with(contract.getQueries().get(11), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<FlowSpecificationInstance>", type.toString());
		});
		with(contract.getQueries().get(12), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EndToEndFlowInstance>", type.toString());
		});
		with(contract.getQueries().get(13), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EndToEndFlowInstance>", type.toString());
		});
		with(contract.getQueries().get(14), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(15), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(16), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<SystemOperationMode>", type.toString());
		});
		with(contract.getQueries().get(17), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(18), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(19), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(20), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(21), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(22), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(23), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(24), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(25), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(26), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(27), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(28), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(29), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(30), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(31), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<StateInstance>", type.toString());
		});
		with(contract.getQueries().get(32), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<EventInstance>", type.toString());
		});
	}

	@Test
	public void testListMembers() {
		var pkg = testHelper.parseFile(PATH + "list_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(9, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Long", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentInstance?", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ConnectionInstance?", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(6), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<String>", type.toString());
		});
		with(contract.getQueries().get(7), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentCategory>", type.toString());
		});
		with(contract.getQueries().get(8), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean", type.toString());
		});
	}

	@Test
	public void testOptionalMembers() {
		var pkg = testHelper.parseFile(PATH + "optional_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("String?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentCategory?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRangeWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
	}

	@Test
	public void testLongWithUnitsMembers() {
		var pkg = testHelper.parseFile(PATH + "long_with_units_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Double", type.toString());
		});
	}

	@Test
	public void testLongRangeMembers() {
		var pkg = testHelper.parseFile(PATH + "long_range_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Long", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Long", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Long?", type.toString());
		});
	}

	@Test
	public void testLongRangeWithUnitsMembers() {
		var pkg = testHelper.parseFile(PATH + "long_range_with_units_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongWithUnits<AADL_Project::Time_Units>", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongWithUnits<AADL_Project::Time_Units>", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
	}

	@Test
	public void testDoubleRangeMembers() {
		var pkg = testHelper.parseFile(PATH + "double_range_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Double", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Double", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Double?", type.toString());
		});
	}

	@Test
	public void testDoubleRangeWithUnitsMembers() {
		var pkg = testHelper.parseFile(PATH + "double_range_with_units_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleWithUnits<AADL_Project::Time_Units>", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleWithUnits<AADL_Project::Time_Units>", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
	}

	@Test
	public void testRecordMembers() {
		var pkg = testHelper.parseFile(PATH + "record_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(15, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Boolean?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("String?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Classifier?", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("UnnamedEnumeration<ps::record_property>?", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Long?", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(6), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("Double?", type.toString());
		});
		with(contract.getQueries().get(7), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(8), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongRange?", type.toString());
		});
		with(contract.getQueries().get(9), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("LongRangeWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(10), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleRange?", type.toString());
		});
		with(contract.getQueries().get(11), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("DoubleRangeWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(12), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("UnnamedRecord<ps::record_property>?", type.toString());
		});
		with(contract.getQueries().get(13), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("InstanceObject?", type.toString());
		});
		with(contract.getQueries().get(14), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("List<String>?", type.toString());
		});
	}

	@Test
	public void testEndToEndFlowInstanceMembers() {
		var pkg = testHelper.parseFile(PATH + "end_to_end_flow_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("List<FlowSpecificationInstance>", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("List<ConnectionInstance>", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("List<ComponentInstance>", type.toString());
		});
	}

	@Test
	public void testStateInstanceMembers() {
		var pkg = testHelper.parseFile(PATH + "state_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("String", type.toString());
		});
	}

	@Test
	public void testEventInstanceMembers() {
		var pkg = testHelper.parseFile(PATH + "event_instance_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var mapCall = (MemberCall) query.getValue();
			var type = typeSystem.expressionType(mapCall.getLambda().getReturnValue()).getValue();
			assertEquals("String", type.toString());
		});
	}
}