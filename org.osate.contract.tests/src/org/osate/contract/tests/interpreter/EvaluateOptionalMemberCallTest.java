package org.osate.contract.tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractInterpreter;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class EvaluateOptionalMemberCallTest {
	private static final String PATH = "org.osate.contract.tests/models/interpreter/EvaluateOptionalMemberCallTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractInterpreter interpreter;

	@Inject
	private ValidationTestHelper validationHelper;

	@SuppressWarnings("unchecked")
	@Test
	public void testSimpleMember() throws Exception {
		var pkg = testHelper.parseFile(PATH + "simple_member_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(5, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(1, ((Optional<Long>) result.get("presentMap")).get());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("emptyMap"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(2, ((Optional<Long>) result.get("presentFlatMap")).get());
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("outerEmptyFlatMap"));
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("innerEmptyFlatMap"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMemberWithTypeParameter() throws Exception {
		var pkg = testHelper.parseFile(PATH + "member_with_type_parameter_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
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
			assertIterableEquals(List.of("sub1", "sub2"),
					((Optional<List<ComponentInstance>>) result.get("presentMap")).get()
							.stream()
							.map(NamedElement::getName)
							.toList());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("emptyMap"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMemberWithArgument() throws Exception {
		var pkg = testHelper.parseFile(PATH + "member_with_argument_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", systemInstance));
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(5, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(1000.0, ((Optional<Double>) result.get("presentMap")).get());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("emptyMap"));
		});
		with(contract.getQueries().get(2), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.of("field_1"), result.get("presentFlatMap"));
		});
		with(contract.getQueries().get(3), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("outerEmptyFlatMap"));
		});
		with(contract.getQueries().get(4), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("innerEmptyFlatMap"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMemberWithLambda() throws Exception {
		var pkg = testHelper.parseFile(PATH + "member_with_lambda_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
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
			assertIterableEquals(List.of("process_1", "process_2"),
					((Optional<List<ComponentInstance>>) result.get("presentMap")).get()
							.stream()
							.map(NamedElement::getName)
							.toList());
		});
		with(contract.getQueries().get(1), query -> {
			var result = interpreter.evaluateQuery(environment, query).getValue();
			assertEquals(1, result.size());
			assertEquals(Optional.empty(), result.get("emptyMap"));
		});
	}
}