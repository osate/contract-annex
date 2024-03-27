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
import org.osate.contract.contract.SingleParameter;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class OptionalMemberCallTest {
	private static final String PATH = "org.osate.contract.tests/models/typeSystem/OptionalMemberCallTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractTypeSystem typeSystem;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testChainedOptionalCalls() {
		var pkg = testHelper.parseFile(PATH + "chained_optional_calls_test.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(6, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentInstance", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("ComponentInstance?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>?", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var parameter = (SingleParameter) ((MemberCall) query.getValue()).getLambda().getParameter();
			var parameterType = typeSystem.namedType(parameter).getValue();
			assertEquals("ComponentInstance", parameterType.toString());
			var queryType = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>?", queryType.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var parameter = (TupleParameter) ((MemberCall) query.getValue()).getLambda().getParameter();
			var firstParameterType = typeSystem.namedType(parameter.getNames().get(0)).getValue();
			assertEquals("String", firstParameterType.toString());
			var secondParameterType = typeSystem.namedType(parameter.getNames().get(1)).getValue();
			assertEquals("ComponentCategory", secondParameterType.toString());
			var queryType = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<String>?", queryType.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("List<ComponentInstance>?", type.toString());
		});
	}
}