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
package org.osate.contract.tests.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
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
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class CheckMemberCallTest {
	private static final String PATH = "org.osate.contract.tests/models/validator/CheckMemberCallTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testInvalidComponentInstanceMember() {
		var pkg = testHelper.parseFile(PATH + "invalid_component_instance_member.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(1, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'foo' is not a member of the type ComponentInstance", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(1).getValue()), issue.getUriToProblem());
		});
	}

	@Test
	public void testInvalidSystemInstanceMember() {
		var pkg = testHelper.parseFile(PATH + "invalid_system_instance_member.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(1, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'foo' is not a member of the type SystemInstance", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(1).getValue()), issue.getUriToProblem());
		});
	}

	@Test
	public void testInvalidStringMember() {
		var pkg = testHelper.parseFile(PATH + "invalid_string_member.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(1, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'foo' is not a member of the type String", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(0).getValue()), issue.getUriToProblem());
		});
	}

	@Test
	public void testInvalidOptionalMember() {
		var pkg = testHelper.parseFile(PATH + "invalid_optional_member.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(1, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'foo' is not a member of the type LongWithUnits<AADL_Project::Time_Units>?",
					issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(1).getValue()), issue.getUriToProblem());
		});
	}

	@Test
	public void testInvalidLongWithUnitsMember() {
		var pkg = testHelper.parseFile(PATH + "invalid_long_with_units_member.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(1, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'foo' is not a member of the type LongWithUnits<AADL_Project::Time_Units>",
					issue.getMessage());
			assertEquals(
					EcoreUtil.getURI(
							((MemberCall) contract.getQueries().get(1).getValue()).getLambda().getReturnValue()),
					issue.getUriToProblem());
		});
	}

	@Test
	public void testMissingLambda() {
		var pkg = testHelper.parseFile(PATH + "missing_lambda.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Lambda expected for call to 'map'", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(1).getValue()), issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Lambda expected for call to 'map'", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(2).getValue()), issue.getUriToProblem());
		});
	}

	@Test
	public void testExtraLambda() {
		var pkg = testHelper.parseFile(PATH + "extra_lambda.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Unexpected lambda for call to 'name'", issue.getMessage());
			assertEquals(EcoreUtil.getURI(((MemberCall) contract.getQueries().get(1).getValue()).getLambda()),
					issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Unexpected lambda for call to 'get'", issue.getMessage());
			assertEquals(EcoreUtil.getURI(
					((MemberCall) ((MemberCall) contract.getQueries().get(2).getValue()).getLambda().getReturnValue())
							.getLambda()),
					issue.getUriToProblem());
		});
	}

	@Test
	public void testMissingArgument() {
		var pkg = testHelper.parseFile(PATH + "missing_argument.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Argument expected for call to 'scaledTo'", issue.getMessage());
			assertEquals(
					EcoreUtil.getURI(
							((MemberCall) contract.getQueries().get(1).getValue()).getLambda().getReturnValue()),
					issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Argument expected for call to 'get'", issue.getMessage());
			assertEquals(
					EcoreUtil.getURI(
							((MemberCall) contract.getQueries().get(2).getValue()).getLambda().getReturnValue()),
					issue.getUriToProblem());
		});
	}

	@Test
	public void testExtraArgument() {
		var pkg = testHelper.parseFile(PATH + "extra_argument.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Couldn't resolve reference to 'ms'.", issue.getMessage());
			assertEquals(EcoreUtil.getURI(((MemberCall) contract.getQueries().get(1).getValue()).getArgument()),
					issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Unexpected argument for call to 'name'", issue.getMessage());
			assertEquals(EcoreUtil.getURI(contract.getQueries().get(1).getValue()), issue.getUriToProblem());
		});
	}
}