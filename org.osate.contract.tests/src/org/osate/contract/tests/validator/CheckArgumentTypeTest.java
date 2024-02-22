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
public class CheckArgumentTypeTest {
	private static final String PATH = "org.osate.contract.tests/models/validator/CheckArgumentTypeTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testWrongArgumentTypeForLongWithUnitsScaledTo() {
		var pkg = testHelper.parseFile(PATH + "wrong_argument_type_for_long_with_units_scaled_to.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Expected UnitLiteral; found ComponentInstance", issue.getMessage());
			assertEquals(
					EcoreUtil.getURI(
							((MemberCall) contract.getQueries().get(1).getValue()).getLambda().getReturnValue()),
					issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Expected UnitLiteral; found ComponentInstance", issue.getMessage());
			assertEquals(EcoreUtil.getURI((contract.getQueries().get(3).getValue())), issue.getUriToProblem());
		});
	}

	@Test
	public void testWrongArgumentTypeForRecordGet() {
		var pkg = testHelper.parseFile(PATH + "wrong_argument_type_for_record_get.aadl");
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		var issues = validationHelper.validate(pkg);
		assertEquals(2, issues.size());
		with(issues.get(0), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Expected RecordField; found Boolean", issue.getMessage());
			assertEquals(
					EcoreUtil.getURI(
							((MemberCall) contract.getQueries().get(1).getValue()).getLambda().getReturnValue()),
					issue.getUriToProblem());
		});
		with(issues.get(1), issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Expected RecordField; found Boolean", issue.getMessage());
			assertEquals(EcoreUtil.getURI((contract.getQueries().get(3).getValue())), issue.getUriToProblem());
		});
	}
}