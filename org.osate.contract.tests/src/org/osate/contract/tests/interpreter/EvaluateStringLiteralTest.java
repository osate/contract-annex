package org.osate.contract.tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
public class EvaluateStringLiteralTest {
	private static final String PATH = "org.osate.contract.tests/models/interpreter/EvaluateStringLiteralTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractInterpreter interpreter;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testStringLiteral() throws Exception {
		var pkg = testHelper.parseFile(PATH + "string_literal_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var query = ((Contract) contractLibrary.getContractElements().get(0)).getQueries().get(0);
		var result = interpreter.evaluateQuery(environment, query).getValue();
		assertEquals(1, result.size());
		assertEquals("I am a string.", result.get("v1"));
	}
}