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

	@Test
	public void testRepeatedContracts() {
		var pkg = testHelper.parseFile(PATH + "RepeatedContracts.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				RepeatedContracts:
				  text: RepeatedContracts
				  nodeType: Goal
				  supportedBy: [Contract1, Contract2]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  undeveloped: true

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  supportedBy: [Contract3, Contract4]

				Contract3:
				  text: Contract3
				  nodeType: Goal
				  supportedBy: [Contract5]

				Contract5:
				  text: Contract5
				  nodeType: Goal
				  undeveloped: true

				Contract4:
				  text: Contract4
				  nodeType: Goal
				  supportedBy: [Contract5]""";
		assertEquals(expected, actual);
	}

	@Test
	public void testRepeatedAssumptions() {
		var pkg = testHelper.parseFile(PATH + "RepeatedAssumptions.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
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
		assertEquals(expected, actual);
	}

	@Test
	public void testRepeatedAnalyses() {
		var pkg = testHelper.parseFile(PATH + "RepeatedAnalyses.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
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
		assertEquals(expected, actual);
	}

	@Test
	public void testAnalysisWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "AnalysisWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				AnalysisWithInterpolatedName:
				  text: AnalysisWithInterpolatedName
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [isEdfDBFSchedulable]

				isEdfDBFSchedulable:
				  text: isEdfDBFSchedulable
				  nodeType: Solution""";
		assertEquals(expected, actual);
	}

	@Test
	public void testAssumptionWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "AssumptionWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				AssumptionWithInterpolatedName:
				  text: AssumptionWithInterpolatedName
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  inContextOf: [areAllPrioritiesSet]

				areAllPrioritiesSet:
				  text: areAllPrioritiesSet
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testContractsWithInterpolatedGuarantee() {
		var pkg = testHelper.parseFile(PATH + "ContractsWithInterpolatedGuarantee.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractsWithInterpolatedGuarantee:
				  text: ContractsWithInterpolatedGuarantee
				  nodeType: Goal
				  supportedBy: [Contract1, Contract2]

				Contract1:
				  text: <=> channelsAreImplementedCorrectly
				  nodeType: Goal
				  undeveloped: true

				Contract2:
				  text: <=> And([actualCounts[i] >= requiredCounts[i] for i in range(${numFlatReqs$})])
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testClaimWithInterpolatedName() {
		var pkg = testHelper.parseFile(PATH + "ClaimWithInterpolatedName.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ClaimWithInterpolatedName:
				  text: ClaimWithInterpolatedName
				  nodeType: Goal
				  inContextOf: [ClaimWithInterpolatedName_claim_1]

				ClaimWithInterpolatedName_claim_1:
				  text: And([blpOkay, channelsAreImplementedCorrectly, connectionsAreBound])
				  nodeType: Assumption""";
		assertEquals(expected, actual);
	}

	@Test
	public void testExhaustiveIStringVar() {
		var pkg = testHelper.parseFile(PATH + "ExhaustiveIStringVar.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
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
		assertEquals(expected, actual);
	}

	@Test
	public void testContractWithOneArgument() {
		var pkg = testHelper.parseFile(PATH + "ContractWithOneArgument.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ContractWithOneArgument:
				  text: ContractWithOneArgument
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [Argument1]

				Argument1:
				  text: Argument1
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testArgumentWithGuarantee() {
		var pkg = testHelper.parseFile(PATH + "ArgumentWithGuarantee.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				ArgumentWithGuarantee:
				  text: ArgumentWithGuarantee
				  nodeType: Goal
				  supportedBy: [Contract1]

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
		assertEquals(expected, actual);
	}

	@Test
	public void testSimpleArgumentExpression() {
		var pkg = testHelper.parseFile(PATH + "SimpleArgumentExpression.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				SimpleArgumentExpression:
				  text: SimpleArgumentExpression
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [Argument1, Argument2]

				Contract2:
				  text: Contract2
				  nodeType: Goal
				  undeveloped: true

				Argument1:
				  text: Argument1
				  nodeType: Goal
				  supportedBy: [Contract2]

				Argument2:
				  text: Argument2
				  nodeType: Goal
				  supportedBy: [Argument3]

				Argument3:
				  text: Argument3
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}

	@Test
	public void testNestedArgumentExpression() {
		var pkg = testHelper.parseFile(PATH + "NestedArgumentExpression.aadl", PATH + "pkg1.aadl");
		validationHelper.assertNoIssues(pkg);
		var defaultLibrary = (DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0);
		var contractLibrary = (ContractLibrary) defaultLibrary.getParsedAnnexLibrary();
		var plan = (VerificationPlan) contractLibrary.getContractElements().get(0);
		var actual = YamlGsnGenerator.generateYamlGsn(plan);
		var expected = """
				NestedArgumentExpression:
				  text: NestedArgumentExpression
				  nodeType: Goal
				  supportedBy: [Contract1]

				Contract1:
				  text: Contract1
				  nodeType: Goal
				  supportedBy: [Argument1, Argument3]

				Argument1:
				  text: Argument1
				  nodeType: Goal
				  supportedBy: [Argument2]

				Argument2:
				  text: Argument2
				  nodeType: Goal
				  undeveloped: true

				Argument3:
				  text: Argument3
				  nodeType: Goal
				  supportedBy: [Argument4]

				Argument4:
				  text: Argument4
				  nodeType: Goal
				  undeveloped: true""";
		assertEquals(expected, actual);
	}
}