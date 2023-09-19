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
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

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
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractInterpreter;
import org.osate.contract.typing.RangeValueHolder;
import org.osate.contract.typing.RecordValueHolder;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class EvaluatePropertyLookupTest {
	private static final String PATH = "org.osate.contract.tests/models/interpreter/EvaluatePropertyLookupTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractInterpreter interpreter;

	@Inject
	private ValidationTestHelper validationHelper;

	@SuppressWarnings("unchecked")
	@Test
	public void testPropertyLookup() throws Exception {
		var pkg = testHelper.parseFile(PATH + "property_lookup_test.aadl", PATH + "ps.aadl");
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
			assertEquals(Optional.of("Direct Value"), result.get("direct"));
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.of("Reference to property"), result.get("referenceToProperty"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.of("Reference to constant"), result.get("referenceToConstant"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("undefined"));
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue(((Optional<Boolean>) result.get("booleanProperty")).get());
		});
		with(contract.getQueries().get(5), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.of("Direct Value"), result.get("stringProperty"));
		});
		with(contract.getQueries().get(6), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("s.i", ((Optional<SystemImplementation>) result.get("classifierProperty")).get().getName());
		});
		with(contract.getQueries().get(7), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("VHDL", ((Optional<EnumerationLiteral>) result.get("enumProperty")).get().getName());
		});
		with(contract.getQueries().get(8), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(8, ((Optional<Long>) result.get("integer")).get());
		});
		with(contract.getQueries().get(9), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("5 KBytesps", ((Optional<IntegerLiteral>) result.get("integerWithUnits")).get().toString());
		});
		with(contract.getQueries().get(10), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(82.45, ((Optional<Double>) result.get("real")).get());
		});
		with(contract.getQueries().get(11), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("3.14 MIPS", ((Optional<RealLiteral>) result.get("realWithUnits")).get().toString());
		});
		with(contract.getQueries().get(12), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("[30 .. 80] delta 5",
					((Optional<RangeValueHolder>) result.get("rangeOfInteger")).get().toString());
		});
		with(contract.getQueries().get(13), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			var recordValue = ((Optional<RecordValueHolder>) result.get("recordProperty")).get().getValue();
			assertEquals(2, recordValue.getOwnedFieldValues().size());
			with(recordValue.getOwnedFieldValues().get(0), field -> {
				assertEquals("Fixed", field.getProperty().getName());
				assertEquals("[10 ms .. 20 ms]", ((RangeValue) field.getOwnedValue()).toString());
			});
			with(recordValue.getOwnedFieldValues().get(1), field -> {
				assertEquals("PerByte", field.getProperty().getName());
				assertEquals("[30 ms .. 40 ms]", ((RangeValue) field.getOwnedValue()).toString());
			});
		});
		with(contract.getQueries().get(14), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals("sub1", ((Optional<ComponentInstance>) result.get("referenceProperty")).get().getName());
		});
		with(contract.getQueries().get(15), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertIterableEquals(List.of("GuaranteedDelivery", "OrderedDelivery"),
					((Optional<List<EnumerationLiteral>>) result.get("listProperty")).get()
							.stream()
							.map(NamedElement::getName)
							.toList());
		});
	}
}