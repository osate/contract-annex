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
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class PropertyLookupTest {
	private static final String PATH = "org.osate.contract.tests/models/typeSystem/PropertyLookupTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractTypeSystem typeSystem;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testSupportedTypes() {
		var pkg = testHelper.parseFile(PATH + "supported_types_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(6, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<LongRangeWithUnits<AADL_Project::Time_Units>?>", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean?", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<Enumeration<EMV2::StateKindEnum>?>", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<Double?>", type.toString());
		});
	}

	@Test
	public void testPropertyTypes() {
		var pkg = testHelper.parseFile(PATH + "property_types_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(37, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Boolean?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("String?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Classifier?", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Enumeration<AADL_Project::Supported_Hardware_Source_Languages>?", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Long?", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnits<AADL_Project::Data_Rate_Units>?", type.toString());
		});
		with(contract.getQueries().get(6), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Double?", type.toString());
		});
		with(contract.getQueries().get(7), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleWithUnits<AADL_Project::Processor_Speed_Units>?", type.toString());
		});
		with(contract.getQueries().get(8), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRange?", type.toString());
		});
		with(contract.getQueries().get(9), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRangeWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(10), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleRange?", type.toString());
		});
		with(contract.getQueries().get(11), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleRangeWithUnits<AADL_Project::Time_Units>?", type.toString());
		});
		with(contract.getQueries().get(12), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<Communication_Properties::Transmission_Time>?", type.toString());
		});
		with(contract.getQueries().get(13), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("InstanceObject?", type.toString());
		});
		with(contract.getQueries().get(14), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<Enumeration<AADL_Project::Supported_Connection_QoS>>?", type.toString());
		});
		with(contract.getQueries().get(15), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Enumeration<ps::property_with_enum>?", type.toString());
		});
		with(contract.getQueries().get(16), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<List<Enumeration<ps::property_with_list_of_enum>>>?", type.toString());
		});
		with(contract.getQueries().get(17), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::property_with_record_with_enum>?", type.toString());
		});
		with(contract.getQueries().get(18), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<List<Record<ps::property_with_list_of_record_with_list_of_enum>>>?",
					type.toString());
		});
		with(contract.getQueries().get(19), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::property_with_deeply_nested>?", type.toString());
		});
		with(contract.getQueries().get(20), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_enum>?", type.toString());
		});
		with(contract.getQueries().get(21), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_list_of_enum>?", type.toString());
		});
		with(contract.getQueries().get(22), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_deeply_nested>?", type.toString());
		});
		with(contract.getQueries().get(23), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnits<ps::integer_type_with_units>?", type.toString());
		});
		with(contract.getQueries().get(24), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleWithUnits<ps::real_type_with_units>?", type.toString());
		});
		with(contract.getQueries().get(25), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRangeWithUnits<ps::range_type_of_integer_with_units>?", type.toString());
		});
		with(contract.getQueries().get(26), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleRangeWithUnits<ps::range_type_of_real_with_units>?", type.toString());
		});
		with(contract.getQueries().get(27), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_integer>?", type.toString());
		});
		with(contract.getQueries().get(28), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_range_of_integer>?", type.toString());
		});
		with(contract.getQueries().get(29), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_range_of_real>?", type.toString());
		});
		with(contract.getQueries().get(30), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_list_of_integer>?", type.toString());
		});
		with(contract.getQueries().get(31), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::record_with_deeply_nested_integer>?", type.toString());
		});
		with(contract.getQueries().get(32), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnits<ps::property_with_integer_with_units>?", type.toString());
		});
		with(contract.getQueries().get(33), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("Record<ps::property_with_deeply_nested_with_integer>?", type.toString());
		});
		with(contract.getQueries().get(34), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleWithUnits<ps::property_with_real_with_units>?", type.toString());
		});
		with(contract.getQueries().get(35), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRangeWithUnits<ps::property_with_integer_range_with_units>?", type.toString());
		});
		with(contract.getQueries().get(36), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleRangeWithUnits<ps::property_with_real_range_with_units>?", type.toString());
		});
	}
}