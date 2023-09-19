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
import org.osate.contract.contract.TupleDeclaration;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class TupleNameTest {
	private static final String PATH = "org.osate.contract.tests/models/typeSystem/TupleNameTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractTypeSystem typeSystem;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testTupleDeclaration() {
		var pkg = testHelper.parseFile(PATH + "tuple_declaration_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(1, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var tuple = (TupleDeclaration) query;
			assertEquals(3, tuple.getNames().size());
			with(tuple.getNames().get(0), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentInstance", type.toString());
			});
			with(tuple.getNames().get(1), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("String", type.toString());
			});
			with(tuple.getNames().get(2), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentCategory", type.toString());
			});
		});
	}

	@Test
	public void testTupleParameter() {
		var pkg = testHelper.parseFile(PATH + "tuple_parameter_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(3, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var call = (MemberCall) query.getValue();
			var parameter = (TupleParameter) call.getLambda().getParameter();
			assertEquals(3, parameter.getNames().size());
			with(parameter.getNames().get(0), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentInstance", type.toString());
			});
			with(parameter.getNames().get(1), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("String", type.toString());
			});
			with(parameter.getNames().get(2), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentCategory", type.toString());
			});
		});
		with(contract.getQueries().get(1), query -> {
			var call = (MemberCall) query.getValue();
			var parameter = (TupleParameter) call.getLambda().getParameter();
			assertEquals(3, parameter.getNames().size());
			with(parameter.getNames().get(0), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentInstance", type.toString());
			});
			with(parameter.getNames().get(1), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("String", type.toString());
			});
			with(parameter.getNames().get(2), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentCategory", type.toString());
			});
		});
		with(contract.getQueries().get(2), query -> {
			var call = (MemberCall) query.getValue();
			var parameter = (TupleParameter) call.getLambda().getParameter();
			assertEquals(3, parameter.getNames().size());
			with(parameter.getNames().get(0), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentInstance", type.toString());
			});
			with(parameter.getNames().get(1), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("String", type.toString());
			});
			with(parameter.getNames().get(2), tupleName -> {
				var type = typeSystem.namedType(tupleName).getValue();
				assertEquals("ComponentCategory", type.toString());
			});
		});
	}
}