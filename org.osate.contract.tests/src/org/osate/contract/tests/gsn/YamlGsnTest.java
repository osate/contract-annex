package org.osate.contract.tests.gsn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.gsn.YamlGsnGenerator;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class YamlGsnTest {
	private static final String PATH = "org.osate.contract.tests/models/gsn/YamlGsnTests/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testSimplePlan() {
		var pkg = testHelper.parseFile(PATH + "SimplePlan.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				SimplePlan:
				  text: SimplePlan
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testPlanWithOneContract() {
		var pkg = testHelper.parseFile(PATH + "PlanWithOneContract.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(1);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				PlanWithOneContract:
				  text: PlanWithOneContract
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testPlanWithThreeContracts() {
		var pkg = testHelper.parseFile(PATH + "PlanWithThreeContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				PlanWithThreeContracts:
				  text: PlanWithThreeContracts
				  nodeType: Goal
				  supportedBy: [Contract1, Contract2, Contract3]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  undeveloped: true

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  undeveloped: true

				Contract3:
				  text: Contract3
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testPlanWithOneClaim() {
		var pkg = testHelper.parseFile(PATH + "PlanWithOneClaim.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				PlanWithOneClaim:
				  text: PlanWithOneClaim
				  nodeType: Goal
				  inContextOf: [PlanWithOneClaim_claim_1]

				PlanWithOneClaim_claim_1:
				  text: And([E2ESamplingJitter[i] <= E2ESamplingJitterTolerance[i] for i in range(len(E2ESamplingJitter))])
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testPlanWithThreeClaims() {
		var pkg = testHelper.parseFile(PATH + "PlanWithThreeClaims.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				PlanWithThreeClaims:
				  text: PlanWithThreeClaims
				  nodeType: Goal
				  inContextOf: [PlanWithThreeClaims_claim_1, PlanWithThreeClaims_claim_2, PlanWithThreeClaims_claim_3]

				PlanWithThreeClaims_claim_1:
				  text: And([E2ESamplingJitter[i] <= E2ESamplingJitterTolerance[i] for i in range(len(E2ESamplingJitter))])
				  nodeType: Assumption

				PlanWithThreeClaims_claim_2:
				  text: And([Reliability[i]>=ReliabiiltyTarget[i] for i in range(len(Reliability))])
				  nodeType: Assumption

				PlanWithThreeClaims_claim_3:
				  text: And([E2EResponses[i] <= E2ELatencies[i] for i in range(len(E2EResponses))])
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testPlanWithContractsAndClaims() {
		var pkg = testHelper.parseFile(PATH + "PlanWithContractsAndClaims.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				PlanWithContractsAndClaims:
				  text: PlanWithContractsAndClaims
				  nodeType: Goal
				  supportedBy: [Contract1, Contract2, Contract3]
				  inContextOf: [PlanWithContractsAndClaims_claim_1, PlanWithContractsAndClaims_claim_2, PlanWithContractsAndClaims_claim_3]

				PlanWithContractsAndClaims_claim_1:
				  text: And([E2ESamplingJitter[i] <= E2ESamplingJitterTolerance[i] for i in range(len(E2ESamplingJitter))])
				  nodeType: Assumption

				PlanWithContractsAndClaims_claim_2:
				  text: And([Reliability[i]>=ReliabiiltyTarget[i] for i in range(len(Reliability))])
				  nodeType: Assumption

				PlanWithContractsAndClaims_claim_3:
				  text: And([E2EResponses[i] <= E2ELatencies[i] for i in range(len(E2EResponses))])
				  nodeType: Assumption

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  undeveloped: true

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  undeveloped: true

				Contract3:
				  text: Contract3
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractText() {
		var pkg = testHelper.parseFile(PATH + "ContractText.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractText:
				  text: ContractText
				  nodeType: Goal
				  supportedBy: [Contract1, Contract2, Contract3]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  undeveloped: true

				Contract2:
				  text: => harmonicBoundSchedulable
				  nodeType: Goal
				  undeveloped: true

				Contract3:
				  text: <=> harmonicBoundSchedulable
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithOneAnalysis() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneAnalysis.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithOneAnalysis:
				  text: ContractWithOneAnalysis
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [isHarmonicBoundSchedulable]

				isHarmonicBoundSchedulable:
				  text: isHarmonicBoundSchedulable
				  nodeType: Solution""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithThreeAnalyses() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeAnalyses.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithThreeAnalyses:
				  text: ContractWithThreeAnalyses
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [withoutParens, withParens, withParameters]

				withoutParens:
				  text: withoutParens
				  nodeType: Solution

				withParens:
				  text: withParens
				  nodeType: Solution

				withParameters:
				  text: withParameters
				  nodeType: Solution""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithOneAssumption() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneAssumption.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithOneAssumption:
				  text: ContractWithOneAssumption
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  inContextOf: [areAllPeriodsHarmonic]

				areAllPeriodsHarmonic:
				  text: areAllPeriodsHarmonic
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithThreeAssumptions() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeAssumptions.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithThreeAssumptions:
				  text: ContractWithThreeAssumptions
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  inContextOf: [areAllPeriodsHarmonic, areAllThreadsBoundToOneProcessor, areAllPeriodsEqualToDeadlines]

				areAllPeriodsHarmonic:
				  text: areAllPeriodsHarmonic
				  nodeType: Assumption

				areAllThreadsBoundToOneProcessor:
				  text: areAllThreadsBoundToOneProcessor
				  nodeType: Assumption

				areAllPeriodsEqualToDeadlines:
				  text: areAllPeriodsEqualToDeadlines
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithOneContract() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneContract.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithOneContract:
				  text: ContractWithOneContract
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [Contract2]

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithThreeContracts() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithThreeContracts:
				  text: ContractWithThreeContracts
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [Contract2, Contract3, Contract4]

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  undeveloped: true

				Contract3:
				  text: Contract3
				  nodeType: Goal
				  undeveloped: true

				Contract4:
				  text: Contract4
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}
}