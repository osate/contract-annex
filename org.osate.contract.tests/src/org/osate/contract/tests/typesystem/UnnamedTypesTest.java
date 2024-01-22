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
public class UnnamedTypesTest {
	private static final String PATH = "org.osate.contract.tests/models/typeSystem/UnnamedTypesTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ContractTypeSystem typeSystem;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testGenerateName() {
		var pkg = testHelper.parseFile(PATH + "generate_name_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(4, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnnamedUnits<ps::integer_with_units>?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleWithUnnamedUnits<ps::real_type_with_units>?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnnamedUnits<ps::record_with_integer.integer_field>??", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnnamedUnits<ps::deeply_nested_record.field1.field2.field3>????", type.toString());
		});
	}

	@Test
	public void testUnnamedTypes() {
		var pkg = testHelper.parseFile(PATH + "unnamed_types_test.aadl", PATH + "ps.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var contract = (Contract) contractLibrary.getContractElements().get(0);
		assertEquals(6, contract.getQueries().size());
		with(contract.getQueries().get(0), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongWithUnnamedUnits<ps::integer_with_units>?", type.toString());
		});
		with(contract.getQueries().get(1), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleWithUnnamedUnits<ps::real_type_with_units>?", type.toString());
		});
		with(contract.getQueries().get(2), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("LongRangeWithUnnamedUnits<ps::integer_range_with_units>?", type.toString());
		});
		with(contract.getQueries().get(3), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("DoubleRangeWithUnnamedUnits<ps::real_range_with_units>?", type.toString());
		});
		with(contract.getQueries().get(4), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("UnnamedEnumeration<ps::enum_property>?", type.toString());
		});
		with(contract.getQueries().get(5), query -> {
			var type = typeSystem.expressionType(query.getValue()).getValue();
			assertEquals("UnnamedRecord<ps::record_with_integer>?", type.toString());
		});
	}
}