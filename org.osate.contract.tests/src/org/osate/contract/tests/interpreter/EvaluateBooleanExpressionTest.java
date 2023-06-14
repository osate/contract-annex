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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractInterpreter;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class EvaluateBooleanExpressionTest {
	private static final String PATH = "org.osate.contract.tests/models/interpreter/EvaluateBooleanExpressionTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractInterpreter interpreter;

	@Test
	public void testOrExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "or_expression_test.aadl");
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
			assertFalse((Boolean) result.get("v1"));
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v3"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v4"));
		});
	}

	@Test
	public void testAndExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "and_expression_test.aadl");
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
			assertFalse((Boolean) result.get("v1"));
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v2"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v3"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v4"));
		});
	}

	@Test
	public void testNotExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "not_expression_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(2, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertTrue((Boolean) result.get("v1"));
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertFalse((Boolean) result.get("v2"));
		});
	}
}