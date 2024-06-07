package org.osate.contract.tests.gsn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

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
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("SimplePlan_SimplePlan", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("SimplePlan.gsn.yaml", file.name());
			var expected = """
					SimplePlan:
					  text: SimplePlan
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testPlanWithOneContract() {
		var pkg = testHelper.parseFile(PATH + "PlanWithOneContract.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(1);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("PlanWithOneContract_PlanWithOneContract", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("PlanWithOneContract.gsn.yaml", file.name());
			var expected = """
					PlanWithOneContract:
					  text: PlanWithOneContract
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testPlanWithThreeContracts() {
		var pkg = testHelper.parseFile(PATH + "PlanWithThreeContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("PlanWithThreeContracts_PlanWithThreeContracts", folder.name());
		assertEquals(4, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("PlanWithThreeContracts.gsn.yaml", file.name());
			var expected = """
					PlanWithThreeContracts:
					  text: PlanWithThreeContracts
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2, Contract3]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testPlanWithOneClaim() {
		var pkg = testHelper.parseFile(PATH + "PlanWithOneClaim.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("PlanWithOneClaim_PlanWithOneClaim", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("PlanWithOneClaim.gsn.yaml", file.name());
			var expected = """
					PlanWithOneClaim:
					  text: PlanWithOneClaim
					  nodeType: Goal
					  inContextOf: [PlanWithOneClaim_claim_1]

					PlanWithOneClaim_claim_1:
					  text: And([E2ESamplingJitter[i] <= E2ESamplingJitterTolerance[i] for i in range(len(E2ESamplingJitter))])
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testPlanWithThreeClaims() {
		var pkg = testHelper.parseFile(PATH + "PlanWithThreeClaims.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("PlanWithThreeClaims_PlanWithThreeClaims", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("PlanWithThreeClaims.gsn.yaml", file.name());
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
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testPlanWithContractsAndClaims() {
		var pkg = testHelper.parseFile(PATH + "PlanWithContractsAndClaims.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("PlanWithContractsAndClaims_PlanWithContractsAndClaims", folder.name());
		assertEquals(4, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("PlanWithContractsAndClaims.gsn.yaml", file.name());
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
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractText() {
		var pkg = testHelper.parseFile(PATH + "ContractText.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractText_ContractText", folder.name());
		assertEquals(4, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractText.gsn.yaml", file.name());
			var expected = """
					ContractText:
					  text: ContractText
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2, Contract3]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: => harmonicBoundSchedulable
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: <=> harmonicBoundSchedulable
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithOneAnalysis() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneAnalysis.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithOneAnalysis_ContractWithOneAnalysis", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithOneAnalysis.gsn.yaml", file.name());
			var expected = """
					ContractWithOneAnalysis:
					  text: ContractWithOneAnalysis
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [isHarmonicBoundSchedulable]

					isHarmonicBoundSchedulable:
					  text: isHarmonicBoundSchedulable
					  nodeType: Solution""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithThreeAnalyses() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeAnalyses.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithThreeAnalyses_ContractWithThreeAnalyses", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithThreeAnalyses.gsn.yaml", file.name());
			var expected = """
					ContractWithThreeAnalyses:
					  text: ContractWithThreeAnalyses
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
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
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithOneAssumption() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneAssumption.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithOneAssumption_ContractWithOneAssumption", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithOneAssumption.gsn.yaml", file.name());
			var expected = """
					ContractWithOneAssumption:
					  text: ContractWithOneAssumption
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  inContextOf: [areAllPeriodsHarmonic]

					areAllPeriodsHarmonic:
					  text: areAllPeriodsHarmonic
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithThreeAssumptions() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeAssumptions.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithThreeAssumptions_ContractWithThreeAssumptions", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithThreeAssumptions.gsn.yaml", file.name());
			var expected = """
					ContractWithThreeAssumptions:
					  text: ContractWithThreeAssumptions
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
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
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithOneContract() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneContract.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithOneContract_ContractWithOneContract", folder.name());
		assertEquals(3, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithOneContract.gsn.yaml", file.name());
			var expected = """
					ContractWithOneContract:
					  text: ContractWithOneContract
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Contract2]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithThreeContracts() {
		var pkg = testHelper.parseFile(PATH + "ContractWithThreeContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithThreeContracts_ContractWithThreeContracts", folder.name());
		assertEquals(5, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithThreeContracts.gsn.yaml", file.name());
			var expected = """
					ContractWithThreeContracts:
					  text: ContractWithThreeContracts
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Contract2, Contract3, Contract4]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(4), file -> {
			assertEquals("Contract4.gsn.yaml", file.name());
			var expected = """
					Contract4:
					  text: Contract4
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testRepeatedContracts() {
		var pkg = testHelper.parseFile(PATH + "RepeatedContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("RepeatedContracts_RepeatedContracts", folder.name());
		assertEquals(6, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("RepeatedContracts.gsn.yaml", file.name());
			var expected = """
					RepeatedContracts:
					  text: RepeatedContracts
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  supportedBy: [Contract3, Contract4]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  supportedBy: [Contract5]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(4), file -> {
			assertEquals("Contract5.gsn.yaml", file.name());
			var expected = """
					Contract5:
					  text: Contract5
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(5), file -> {
			assertEquals("Contract4.gsn.yaml", file.name());
			var expected = """
					Contract4:
					  text: Contract4
					  nodeType: Goal
					  supportedBy: [Contract5]""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testRepeatedAssumptions() {
		var pkg = testHelper.parseFile(PATH + "RepeatedAssumptions.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("RepeatedAssumptions_RepeatedAssumptions", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("RepeatedAssumptions.gsn.yaml", file.name());
			var expected = """
					RepeatedAssumptions:
					  text: RepeatedAssumptions
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2]

					Contract1:
					  text: Contract1
					  nodeType: Goal
					  inContextOf: [assumption1, assumption2, assumption3]

					Contract2:
					  text: Contract2
					  nodeType: Goal
					  inContextOf: [assumption3, assumption4]

					assumption1:
					  text: assumption1
					  nodeType: Assumption

					assumption2:
					  text: assumption2
					  nodeType: Assumption

					assumption3:
					  text: assumption3
					  nodeType: Assumption

					assumption4:
					  text: assumption4
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testRepeatedAnalyses() {
		var pkg = testHelper.parseFile(PATH + "RepeatedAnalyses.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("RepeatedAnalyses_RepeatedAnalyses", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("RepeatedAnalyses.gsn.yaml", file.name());
			var expected = """
					RepeatedAnalyses:
					  text: RepeatedAnalyses
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2]

					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [analysis1, analysis2, analysis3]

					Contract2:
					  text: Contract2
					  nodeType: Goal
					  supportedBy: [analysis3, analysis4]

					analysis1:
					  text: analysis1
					  nodeType: Solution

					analysis2:
					  text: analysis2
					  nodeType: Solution

					analysis3:
					  text: analysis3
					  nodeType: Solution

					analysis4:
					  text: analysis4
					  nodeType: Solution""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testAnalysisWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "AnalysisWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("AnalysisWithInterpolatedName_AnalysisWithInterpolatedName", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("AnalysisWithInterpolatedName.gsn.yaml", file.name());
			var expected = """
					AnalysisWithInterpolatedName:
					  text: AnalysisWithInterpolatedName
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [isEdfDBFSchedulable]

					isEdfDBFSchedulable:
					  text: isEdfDBFSchedulable
					  nodeType: Solution""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testAssumptionWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "AssumptionWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("AssumptionWithInterpolatedName_AssumptionWithInterpolatedName", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("AssumptionWithInterpolatedName.gsn.yaml", file.name());
			var expected = """
					AssumptionWithInterpolatedName:
					  text: AssumptionWithInterpolatedName
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  inContextOf: [areAllPrioritiesSet]

					areAllPrioritiesSet:
					  text: areAllPrioritiesSet
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractsWithInterpolatedGuarantee() {
		var pkg = testHelper.parseFile(PATH + "ContractsWithInterpolatedGuarantee.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractsWithInterpolatedGuarantee_ContractsWithInterpolatedGuarantee", folder.name());
		assertEquals(3, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractsWithInterpolatedGuarantee.gsn.yaml", file.name());
			var expected = """
					ContractsWithInterpolatedGuarantee:
					  text: ContractsWithInterpolatedGuarantee
					  nodeType: Goal
					  supportedBy: [Contract1, Contract2]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: <=> channelsAreImplementedCorrectly
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: <=> And([actualCounts[i] >= requiredCounts[i] for i in range(${numFlatReqs$})])
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testClaimWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "ClaimWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ClaimWithInterpolatedName_ClaimWithInterpolatedName", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ClaimWithInterpolatedName.gsn.yaml", file.name());
			var expected = """
					ClaimWithInterpolatedName:
					  text: ClaimWithInterpolatedName
					  nodeType: Goal
					  inContextOf: [ClaimWithInterpolatedName_claim_1]

					ClaimWithInterpolatedName_claim_1:
					  text: And([blpOkay, channelsAreImplementedCorrectly, connectionsAreBound])
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testExhaustiveIStringVar() {
		var pkg = testHelper.parseFile(PATH + "ExhaustiveIStringVar.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ExhaustiveIStringVar_ExhaustiveIStringVar", folder.name());
		assertEquals(1, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ExhaustiveIStringVar.gsn.yaml", file.name());
			var expected = """
					ExhaustiveIStringVar:
					  text: ExhaustiveIStringVar
					  nodeType: Goal
					  inContextOf: [ExhaustiveIStringVar_claim_1, ExhaustiveIStringVar_claim_2, ExhaustiveIStringVar_claim_3, ExhaustiveIStringVar_claim_4, ExhaustiveIStringVar_claim_5, ExhaustiveIStringVar_claim_6, ExhaustiveIStringVar_claim_7, ExhaustiveIStringVar_claim_8]

					ExhaustiveIStringVar_claim_1:
					  text: query(${query1$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_2:
					  text: directQuery(${:query1$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_3:
					  text: qualifiedQuery(${domain2::query2$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_4:
					  text: directQualifiedQuery(${:domain2::query2$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_5:
					  text: error(${error0$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_6:
					  text: directError(${:error0$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_7:
					  text: info(${info0$})
					  nodeType: Assumption

					ExhaustiveIStringVar_claim_8:
					  text: directInfo(${:info0$})
					  nodeType: Assumption""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testContractWithOneArgument() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneArgument.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ContractWithOneArgument_ContractWithOneArgument", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ContractWithOneArgument.gsn.yaml", file.name());
			var expected = """
					ContractWithOneArgument:
					  text: ContractWithOneArgument
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testArgumentWithGuarantee() {
		var pkg = testHelper.parseFile(PATH + "ArgumentWithGuarantee.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("ArgumentWithGuarantee_ArgumentWithGuarantee", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("ArgumentWithGuarantee.gsn.yaml", file.name());
			var expected = """
					ArgumentWithGuarantee:
					  text: ArgumentWithGuarantee
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1, Argument2]

					Argument1:
					  text: => And([Deadlines[i] >= Responses[i] for i in range(len(Deadlines))])
					  nodeType: Goal
					  undeveloped: true

					Argument2:
					  text: <=> And([Deadlines[i] >= Responses[i] for i in range(len(Deadlines))])
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testSimpleAnd() {
		var pkg = testHelper.parseFile(PATH + "SimpleAnd.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("SimpleAnd_SimpleAnd", folder.name());
		assertEquals(4, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("SimpleAnd.gsn.yaml", file.name());
			var expected = """
					SimpleAnd:
					  text: SimpleAnd
					  nodeType: Goal
					  supportedBy: [Contract1, Contract3]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_and_1]

					Argument1_and_1:
					  text: Argument1_and_1
					  nodeType: Goal
					  supportedBy: [Contract2]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  supportedBy: [Argument2]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  supportedBy: [Argument2_and_1]

					Argument3:
					  text: Argument3
					  nodeType: Goal
					  undeveloped: true

					Argument2_and_1:
					  text: Argument2_and_1
					  nodeType: Goal
					  supportedBy: [Argument3]""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testAndWithMultipleTerms() {
		var pkg = testHelper.parseFile(PATH + "AndWithMultipleTerms.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("AndWithMultipleTerms_AndWithMultipleTerms", folder.name());
		assertEquals(5, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("AndWithMultipleTerms.gsn.yaml", file.name());
			var expected = """
					AndWithMultipleTerms:
					  text: AndWithMultipleTerms
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_and_1]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  undeveloped: true

					Argument3:
					  text: Argument3
					  nodeType: Goal
					  undeveloped: true

					Argument4:
					  text: Argument4
					  nodeType: Goal
					  undeveloped: true

					Argument1_and_1:
					  text: Argument1_and_1
					  nodeType: Goal
					  supportedBy: [Argument2, Argument3, Argument4, Contract2, Contract3, Contract4]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(4), file -> {
			assertEquals("Contract4.gsn.yaml", file.name());
			var expected = """
					Contract4:
					  text: Contract4
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testNestedAnd() {
		var pkg = testHelper.parseFile(PATH + "NestedAnd.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("NestedAnd_NestedAnd", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("NestedAnd.gsn.yaml", file.name());
			var expected = """
					NestedAnd:
					  text: NestedAnd
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_and_1]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  undeveloped: true

					Argument3:
					  text: Argument3
					  nodeType: Goal
					  undeveloped: true

					Argument4:
					  text: Argument4
					  nodeType: Goal
					  undeveloped: true

					Argument5:
					  text: Argument5
					  nodeType: Goal
					  undeveloped: true

					Argument6:
					  text: Argument6
					  nodeType: Goal
					  undeveloped: true

					Argument7:
					  text: Argument7
					  nodeType: Goal
					  undeveloped: true

					Argument8:
					  text: Argument8
					  nodeType: Goal
					  undeveloped: true

					Argument1_and_1:
					  text: Argument1_and_1
					  nodeType: Goal
					  supportedBy: [Argument1_and_2, Argument1_and_3]

					Argument1_and_2:
					  text: Argument1_and_2
					  nodeType: Goal
					  supportedBy: [Argument2, Argument3]

					Argument1_and_3:
					  text: Argument1_and_3
					  nodeType: Goal
					  supportedBy: [Argument4, Argument1_and_4]

					Argument1_and_4:
					  text: Argument1_and_4
					  nodeType: Goal
					  supportedBy: [Argument5, Argument1_and_5]

					Argument1_and_5:
					  text: Argument1_and_5
					  nodeType: Goal
					  supportedBy: [Argument6, Argument7, Argument8]""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testSimpleOr() {
		var pkg = testHelper.parseFile(PATH + "SimpleOr.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("SimpleOr_SimpleOr", folder.name());
		assertEquals(3, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("SimpleOr.gsn.yaml", file.name());
			var expected = """
					SimpleOr:
					  text: SimpleOr
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_or_1]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  undeveloped: true

					Argument1_or_1:
					  text: Argument1_or_1
					  nodeType: Goal
					  supportedBy: [Argument2, Contract2]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testSimpleNot() {
		var pkg = testHelper.parseFile(PATH + "SimpleNot.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("SimpleNot_SimpleNot", folder.name());
		assertEquals(2, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("SimpleNot.gsn.yaml", file.name());
			var expected = """
					SimpleNot:
					  text: SimpleNot
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_not_1]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  undeveloped: true

					Argument1_not_1:
					  text: Argument1_not_1
					  nodeType: Goal
					  supportedBy: [Argument2]""";
			assertEquals(expected, file.contents());
		});
	}

	@Test
	public void testAllExpressionCombinations() {
		var pkg = testHelper.parseFile(PATH + "AllExpressionCombinations.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var folder = YamlGsnGenerator.generateYamlGsn(plan);
		assertEquals("AllExpressionCombinations_AllExpressionCombinations", folder.name());
		assertEquals(7, folder.files().size());
		with(folder.files().get(0), file -> {
			assertEquals("AllExpressionCombinations.gsn.yaml", file.name());
			var expected = """
					AllExpressionCombinations:
					  text: AllExpressionCombinations
					  nodeType: Goal
					  supportedBy: [Contract1]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(1), file -> {
			assertEquals("Contract1.gsn.yaml", file.name());
			var expected = """
					Contract1:
					  text: Contract1
					  nodeType: Goal
					  supportedBy: [Argument1]

					Argument1:
					  text: Argument1
					  nodeType: Goal
					  supportedBy: [Argument1_and_1]

					Argument2:
					  text: Argument2
					  nodeType: Goal
					  undeveloped: true

					Argument3:
					  text: Argument3
					  nodeType: Goal
					  undeveloped: true

					Argument4:
					  text: Argument4
					  nodeType: Goal
					  undeveloped: true

					Argument5:
					  text: Argument5
					  nodeType: Goal
					  undeveloped: true

					Argument6:
					  text: Argument6
					  nodeType: Goal
					  undeveloped: true

					Argument1_and_1:
					  text: Argument1_and_1
					  nodeType: Goal
					  supportedBy: [Argument1_and_2, Argument1_or_1, Argument1_not_2]

					Argument1_and_2:
					  text: Argument1_and_2
					  nodeType: Goal
					  supportedBy: [Argument2, Contract2]

					Argument1_or_1:
					  text: Argument1_or_1
					  nodeType: Goal
					  supportedBy: [Argument1_and_3, Argument1_or_2, Argument1_not_1]

					Argument1_and_3:
					  text: Argument1_and_3
					  nodeType: Goal
					  supportedBy: [Argument3, Contract3]

					Argument1_or_2:
					  text: Argument1_or_2
					  nodeType: Goal
					  supportedBy: [Argument4, Contract4]

					Argument1_not_1:
					  text: Argument1_not_1
					  nodeType: Goal
					  supportedBy: [Argument1_or_3]

					Argument1_or_3:
					  text: Argument1_or_3
					  nodeType: Goal
					  supportedBy: [Argument5, Contract5]

					Argument1_not_2:
					  text: Argument1_not_2
					  nodeType: Goal
					  supportedBy: [Argument1_and_4]

					Argument1_and_4:
					  text: Argument1_and_4
					  nodeType: Goal
					  supportedBy: [Argument1_not_3, Argument1_not_5]

					Argument1_not_3:
					  text: Argument1_not_3
					  nodeType: Goal
					  supportedBy: [Argument1_not_4]

					Argument1_not_4:
					  text: Argument1_not_4
					  nodeType: Goal
					  supportedBy: [Contract6]

					Argument1_not_5:
					  text: Argument1_not_5
					  nodeType: Goal
					  supportedBy: [Argument6]""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(2), file -> {
			assertEquals("Contract2.gsn.yaml", file.name());
			var expected = """
					Contract2:
					  text: Contract2
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(3), file -> {
			assertEquals("Contract3.gsn.yaml", file.name());
			var expected = """
					Contract3:
					  text: Contract3
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(4), file -> {
			assertEquals("Contract4.gsn.yaml", file.name());
			var expected = """
					Contract4:
					  text: Contract4
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(5), file -> {
			assertEquals("Contract5.gsn.yaml", file.name());
			var expected = """
					Contract5:
					  text: Contract5
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
		with(folder.files().get(6), file -> {
			assertEquals("Contract6.gsn.yaml", file.name());
			var expected = """
					Contract6:
					  text: Contract6
					  nodeType: Goal
					  undeveloped: true""";
			assertEquals(expected, file.contents());
		});
	}
}