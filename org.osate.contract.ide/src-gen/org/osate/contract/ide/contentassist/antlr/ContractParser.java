
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
package org.osate.contract.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.contract.ide.contentassist.antlr.internal.InternalContractParser;
import org.osate.contract.services.ContractGrammarAccess;

public class ContractParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContractGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ContractGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
			builder.put(grammarAccess.getNamedElementAccess().getAlternatives(), "rule__NamedElement__Alternatives");
			builder.put(grammarAccess.getContractElementAccess().getAlternatives(), "rule__ContractElement__Alternatives");
			builder.put(grammarAccess.getContractAccess().getAlternatives_8_0(), "rule__Contract__Alternatives_8_0");
			builder.put(grammarAccess.getExactAccess().getAlternatives(), "rule__Exact__Alternatives");
			builder.put(grammarAccess.getAssumptionElementAccess().getAlternatives(), "rule__AssumptionElement__Alternatives");
			builder.put(grammarAccess.getSourceAccess().getAlternatives_1(), "rule__Source__Alternatives_1");
			builder.put(grammarAccess.getArgumentExpressionAccess().getAlternatives(), "rule__ArgumentExpression__Alternatives");
			builder.put(grammarAccess.getArgumentNotAccess().getAlternatives_2(), "rule__ArgumentNot__Alternatives_2");
			builder.put(grammarAccess.getArgumentTermAccess().getAlternatives(), "rule__ArgumentTerm__Alternatives");
			builder.put(grammarAccess.getQueryAccess().getAlternatives(), "rule__Query__Alternatives");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getAlternatives(), "rule__TerminalTypeAnnotation__Alternatives");
			builder.put(grammarAccess.getNotExpressionAccess().getAlternatives(), "rule__NotExpression__Alternatives");
			builder.put(grammarAccess.getCallExpressionAccess().getAlternatives_1(), "rule__CallExpression__Alternatives_1");
			builder.put(grammarAccess.getParameterAccess().getAlternatives(), "rule__Parameter__Alternatives");
			builder.put(grammarAccess.getTerminalExpressionAccess().getAlternatives(), "rule__TerminalExpression__Alternatives");
			builder.put(grammarAccess.getIStringAccess().getAlternatives(), "rule__IString__Alternatives");
			builder.put(grammarAccess.getIStringPartAccess().getAlternatives(), "rule__IStringPart__Alternatives");
			builder.put(grammarAccess.getIStringInterAccess().getAlternatives_1(), "rule__IStringInter__Alternatives_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1(), "rule__ContainedPropertyAssociation__Alternatives_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getAlternatives_1(), "rule__PropertyAssociation__Alternatives_1");
			builder.put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getPlusMinusAccess().getAlternatives(), "rule__PlusMinus__Alternatives");
			builder.put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
			builder.put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
			builder.put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
			builder.put(grammarAccess.getLanguageAccess().getAlternatives(), "rule__Language__Alternatives");
			builder.put(grammarAccess.getPredefinedAccess().getAlternatives(), "rule__Predefined__Alternatives");
			builder.put(grammarAccess.getContractLibraryAccess().getGroup(), "rule__ContractLibrary__Group__0");
			builder.put(grammarAccess.getContractAccess().getGroup(), "rule__Contract__Group__0");
			builder.put(grammarAccess.getContractAccess().getGroup_3(), "rule__Contract__Group_3__0");
			builder.put(grammarAccess.getContractAccess().getGroup_4(), "rule__Contract__Group_4__0");
			builder.put(grammarAccess.getContractAccess().getGroup_5(), "rule__Contract__Group_5__0");
			builder.put(grammarAccess.getContractAccess().getGroup_6(), "rule__Contract__Group_6__0");
			builder.put(grammarAccess.getContractAccess().getGroup_7(), "rule__Contract__Group_7__0");
			builder.put(grammarAccess.getContractAccess().getGroup_8(), "rule__Contract__Group_8__0");
			builder.put(grammarAccess.getQueriesAccess().getGroup(), "rule__Queries__Group__0");
			builder.put(grammarAccess.getDomainsAccess().getGroup(), "rule__Domains__Group__0");
			builder.put(grammarAccess.getAssumptionsAccess().getGroup(), "rule__Assumptions__Group__0");
			builder.put(grammarAccess.getAnalysesAccess().getGroup(), "rule__Analyses__Group__0");
			builder.put(grammarAccess.getInputAssumptionAccess().getGroup(), "rule__InputAssumption__Group__0");
			builder.put(grammarAccess.getAssumptionElementAccess().getGroup_0(), "rule__AssumptionElement__Group_0__0");
			builder.put(grammarAccess.getAssumptionElementAccess().getGroup_1(), "rule__AssumptionElement__Group_1__0");
			builder.put(grammarAccess.getAssumptionElementAccess().getGroup_2(), "rule__AssumptionElement__Group_2__0");
			builder.put(grammarAccess.getAssumptionElementAccess().getGroup_2_2(), "rule__AssumptionElement__Group_2_2__0");
			builder.put(grammarAccess.getSourceAccess().getGroup(), "rule__Source__Group__0");
			builder.put(grammarAccess.getImplementationAccess().getGroup(), "rule__Implementation__Group__0");
			builder.put(grammarAccess.getDomainAccess().getGroup(), "rule__Domain__Group__0");
			builder.put(grammarAccess.getDomainAccess().getGroup_3(), "rule__Domain__Group_3__0");
			builder.put(grammarAccess.getDomainAccess().getGroup_4(), "rule__Domain__Group_4__0");
			builder.put(grammarAccess.getArgumentAccess().getGroup(), "rule__Argument__Group__0");
			builder.put(grammarAccess.getArgumentAccess().getGroup_3(), "rule__Argument__Group_3__0");
			builder.put(grammarAccess.getArgumentAccess().getGroup_4(), "rule__Argument__Group_4__0");
			builder.put(grammarAccess.getArgumentAccess().getGroup_5(), "rule__Argument__Group_5__0");
			builder.put(grammarAccess.getArgumentAndAccess().getGroup(), "rule__ArgumentAnd__Group__0");
			builder.put(grammarAccess.getArgumentAndAccess().getGroup_4(), "rule__ArgumentAnd__Group_4__0");
			builder.put(grammarAccess.getArgumentOrAccess().getGroup(), "rule__ArgumentOr__Group__0");
			builder.put(grammarAccess.getArgumentOrAccess().getGroup_4(), "rule__ArgumentOr__Group_4__0");
			builder.put(grammarAccess.getArgumentNotAccess().getGroup(), "rule__ArgumentNot__Group__0");
			builder.put(grammarAccess.getArgumentNotAccess().getGroup_2_1(), "rule__ArgumentNot__Group_2_1__0");
			builder.put(grammarAccess.getArgumentTermAccess().getGroup_0(), "rule__ArgumentTerm__Group_0__0");
			builder.put(grammarAccess.getArgumentTermAccess().getGroup_1(), "rule__ArgumentTerm__Group_1__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup(), "rule__VerificationPlan__Group__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_9(), "rule__VerificationPlan__Group_9__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_10(), "rule__VerificationPlan__Group_10__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_11(), "rule__VerificationPlan__Group_11__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_11_1(), "rule__VerificationPlan__Group_11_1__0");
			builder.put(grammarAccess.getClaimsAccess().getGroup(), "rule__Claims__Group__0");
			builder.put(grammarAccess.getQueryAccess().getGroup_1(), "rule__Query__Group_1__0");
			builder.put(grammarAccess.getQueryAccess().getGroup_1_4(), "rule__Query__Group_1_4__0");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getGroup(), "rule__SingleValDeclaration__Group__0");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getGroup_2(), "rule__SingleValDeclaration__Group_2__0");
			builder.put(grammarAccess.getTypeAnnotationAccess().getGroup(), "rule__TypeAnnotation__Group__0");
			builder.put(grammarAccess.getTypeAnnotationAccess().getGroup_1(), "rule__TypeAnnotation__Group_1__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_0(), "rule__TerminalTypeAnnotation__Group_0__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_1(), "rule__TerminalTypeAnnotation__Group_1__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_2(), "rule__TerminalTypeAnnotation__Group_2__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_2_6(), "rule__TerminalTypeAnnotation__Group_2_6__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_3(), "rule__TerminalTypeAnnotation__Group_3__0");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGroup_3_3(), "rule__TerminalTypeAnnotation__Group_3_3__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1(), "rule__Expression__Group_1__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			builder.put(grammarAccess.getNotExpressionAccess().getGroup_1(), "rule__NotExpression__Group_1__0");
			builder.put(grammarAccess.getCallExpressionAccess().getGroup(), "rule__CallExpression__Group__0");
			builder.put(grammarAccess.getCallExpressionAccess().getGroup_1_0(), "rule__CallExpression__Group_1_0__0");
			builder.put(grammarAccess.getCallExpressionAccess().getGroup_1_0_3(), "rule__CallExpression__Group_1_0_3__0");
			builder.put(grammarAccess.getCallExpressionAccess().getGroup_1_0_4(), "rule__CallExpression__Group_1_0_4__0");
			builder.put(grammarAccess.getCallExpressionAccess().getGroup_1_1(), "rule__CallExpression__Group_1_1__0");
			builder.put(grammarAccess.getLambdaAccess().getGroup(), "rule__Lambda__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup_1(), "rule__Parameter__Group_1__0");
			builder.put(grammarAccess.getParameterAccess().getGroup_1_3(), "rule__Parameter__Group_1_3__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_0(), "rule__TerminalExpression__Group_0__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_1(), "rule__TerminalExpression__Group_1__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_2(), "rule__TerminalExpression__Group_2__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_3(), "rule__TerminalExpression__Group_3__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_4(), "rule__TerminalExpression__Group_4__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_4_2(), "rule__TerminalExpression__Group_4_2__0");
			builder.put(grammarAccess.getTerminalExpressionAccess().getGroup_4_2_1(), "rule__TerminalExpression__Group_4_2_1__0");
			builder.put(grammarAccess.getContractSubclauseAccess().getGroup(), "rule__ContractSubclause__Group__0");
			builder.put(grammarAccess.getContractSubclauseAccess().getGroup_1(), "rule__ContractSubclause__Group_1__0");
			builder.put(grammarAccess.getContractSubclauseAccess().getGroup_2(), "rule__ContractSubclause__Group_2__0");
			builder.put(grammarAccess.getIStringAccess().getGroup_1(), "rule__IString__Group_1__0");
			builder.put(grammarAccess.getIStringAccess().getGroup_1_2(), "rule__IString__Group_1_2__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup(), "rule__IStringInter__Group__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup_1_0(), "rule__IStringInter__Group_1_0__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup_1_0_0(), "rule__IStringInter__Group_1_0_0__0");
			builder.put(grammarAccess.getOptionalQualifiedNameAccess().getGroup(), "rule__OptionalQualifiedName__Group__0");
			builder.put(grammarAccess.getOptionalQualifiedNameAccess().getGroup_0(), "rule__OptionalQualifiedName__Group_0__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup(), "rule__ContainedPropertyAssociation__Group__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3(), "rule__ContainedPropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1(), "rule__ContainedPropertyAssociation__Group_3_1__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4(), "rule__ContainedPropertyAssociation__Group_4__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2(), "rule__ContainedPropertyAssociation__Group_4_2__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5(), "rule__ContainedPropertyAssociation__Group_5__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup(), "rule__PropertyAssociation__Group__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3(), "rule__PropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1(), "rule__PropertyAssociation__Group_3_1__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_4(), "rule__PropertyAssociation__Group_4__0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup_4(), "rule__ModalPropertyValue__Group_4__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup(), "rule__OptionalModalPropertyValue__Group__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1(), "rule__OptionalModalPropertyValue__Group_1__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3(), "rule__OptionalModalPropertyValue__Group_1_3__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
			builder.put(grammarAccess.getReferenceTermAccess().getGroup(), "rule__ReferenceTerm__Group__0");
			builder.put(grammarAccess.getRecordTermAccess().getGroup(), "rule__RecordTerm__Group__0");
			builder.put(grammarAccess.getOldRecordTermAccess().getGroup(), "rule__OldRecordTerm__Group__0");
			builder.put(grammarAccess.getComputedTermAccess().getGroup(), "rule__ComputedTerm__Group__0");
			builder.put(grammarAccess.getComponentClassifierTermAccess().getGroup(), "rule__ComponentClassifierTerm__Group__0");
			builder.put(grammarAccess.getListTermAccess().getGroup(), "rule__ListTerm__Group__0");
			builder.put(grammarAccess.getListTermAccess().getGroup_2(), "rule__ListTerm__Group_2__0");
			builder.put(grammarAccess.getListTermAccess().getGroup_2_1(), "rule__ListTerm__Group_2_1__0");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getGroup(), "rule__FieldPropertyAssociation__Group__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup(), "rule__ContainmentPathElement__Group__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup_0(), "rule__ContainmentPathElement__Group_0__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup_1(), "rule__ContainmentPathElement__Group_1__0");
			builder.put(grammarAccess.getANNEXREFAccess().getGroup(), "rule__ANNEXREF__Group__0");
			builder.put(grammarAccess.getArrayRangeAccess().getGroup(), "rule__ArrayRange__Group__0");
			builder.put(grammarAccess.getArrayRangeAccess().getGroup_3(), "rule__ArrayRange__Group_3__0");
			builder.put(grammarAccess.getSignedConstantAccess().getGroup(), "rule__SignedConstant__Group__0");
			builder.put(grammarAccess.getIntegerTermAccess().getGroup(), "rule__IntegerTerm__Group__0");
			builder.put(grammarAccess.getSignedIntAccess().getGroup(), "rule__SignedInt__Group__0");
			builder.put(grammarAccess.getRealTermAccess().getGroup(), "rule__RealTerm__Group__0");
			builder.put(grammarAccess.getSignedRealAccess().getGroup(), "rule__SignedReal__Group__0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getGroup(), "rule__NumericRangeTerm__Group__0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getGroup_3(), "rule__NumericRangeTerm__Group_3__0");
			builder.put(grammarAccess.getAppliesToKeywordsAccess().getGroup(), "rule__AppliesToKeywords__Group__0");
			builder.put(grammarAccess.getInBindingKeywordsAccess().getGroup(), "rule__InBindingKeywords__Group__0");
			builder.put(grammarAccess.getInModesKeywordsAccess().getGroup(), "rule__InModesKeywords__Group__0");
			builder.put(grammarAccess.getQCLREFAccess().getGroup(), "rule__QCLREF__Group__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
			builder.put(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_1(), "rule__ContractLibrary__ContractElementsAssignment_1");
			builder.put(grammarAccess.getContractAccess().getNameAssignment_1(), "rule__Contract__NameAssignment_1");
			builder.put(grammarAccess.getContractAccess().getInputsAssignment_5_2(), "rule__Contract__InputsAssignment_5_2");
			builder.put(grammarAccess.getContractAccess().getGuaranteeAssignment_7_2(), "rule__Contract__GuaranteeAssignment_7_2");
			builder.put(grammarAccess.getExactAccess().getExactAssignment_1(), "rule__Exact__ExactAssignment_1");
			builder.put(grammarAccess.getQueriesAccess().getQueriesAssignment_0(), "rule__Queries__QueriesAssignment_0");
			builder.put(grammarAccess.getDomainsAccess().getDomainsAssignment_0(), "rule__Domains__DomainsAssignment_0");
			builder.put(grammarAccess.getAssumptionsAccess().getAssumptionsAssignment_0(), "rule__Assumptions__AssumptionsAssignment_0");
			builder.put(grammarAccess.getAnalysesAccess().getAnalysesAssignment_0(), "rule__Analyses__AnalysesAssignment_0");
			builder.put(grammarAccess.getInputAssumptionAccess().getCodeAssignment_1(), "rule__InputAssumption__CodeAssignment_1");
			builder.put(grammarAccess.getAssumptionElementAccess().getContractAssignment_0_2(), "rule__AssumptionElement__ContractAssignment_0_2");
			builder.put(grammarAccess.getAssumptionElementAccess().getArgumentAssignment_1_2(), "rule__AssumptionElement__ArgumentAssignment_1_2");
			builder.put(grammarAccess.getAssumptionElementAccess().getCodeAssignment_2_1(), "rule__AssumptionElement__CodeAssignment_2_1");
			builder.put(grammarAccess.getAssumptionElementAccess().getGuaranteeAssignment_2_2_1(), "rule__AssumptionElement__GuaranteeAssignment_2_2_1");
			builder.put(grammarAccess.getGuaranteeAccess().getCodeAssignment(), "rule__Guarantee__CodeAssignment");
			builder.put(grammarAccess.getAnalysisAccess().getCodeAssignment(), "rule__Analysis__CodeAssignment");
			builder.put(grammarAccess.getSourceAccess().getLanguageAssignment_0(), "rule__Source__LanguageAssignment_0");
			builder.put(grammarAccess.getSourceAccess().getSourceAssignment_1_0(), "rule__Source__SourceAssignment_1_0");
			builder.put(grammarAccess.getSourceAccess().getInterAssignment_1_1(), "rule__Source__InterAssignment_1_1");
			builder.put(grammarAccess.getImplementationAccess().getNameAssignment_2(), "rule__Implementation__NameAssignment_2");
			builder.put(grammarAccess.getImplementationAccess().getCodeAssignment_4(), "rule__Implementation__CodeAssignment_4");
			builder.put(grammarAccess.getDomainAccess().getNameAssignment_1(), "rule__Domain__NameAssignment_1");
			builder.put(grammarAccess.getDomainAccess().getCodeAssignment_4_1(), "rule__Domain__CodeAssignment_4_1");
			builder.put(grammarAccess.getArgumentAccess().getNameAssignment_1(), "rule__Argument__NameAssignment_1");
			builder.put(grammarAccess.getArgumentAccess().getGuaranteeAssignment_4_2(), "rule__Argument__GuaranteeAssignment_4_2");
			builder.put(grammarAccess.getArgumentAccess().getArgumentExpressionAssignment_5_1(), "rule__Argument__ArgumentExpressionAssignment_5_1");
			builder.put(grammarAccess.getArgumentTermAccess().getContractsAssignment_0_1(), "rule__ArgumentTerm__ContractsAssignment_0_1");
			builder.put(grammarAccess.getArgumentTermAccess().getArgumentsAssignment_1_1(), "rule__ArgumentTerm__ArgumentsAssignment_1_1");
			builder.put(grammarAccess.getArgumentTermAccess().getNestedAssignment_2(), "rule__ArgumentTerm__NestedAssignment_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getNameAssignment_2(), "rule__VerificationPlan__NameAssignment_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getComponentImplementationAssignment_7(), "rule__VerificationPlan__ComponentImplementationAssignment_7");
			builder.put(grammarAccess.getVerificationPlanAccess().getContractsAssignment_11_1_0(), "rule__VerificationPlan__ContractsAssignment_11_1_0");
			builder.put(grammarAccess.getClaimsAccess().getClaimsAssignment_0(), "rule__Claims__ClaimsAssignment_0");
			builder.put(grammarAccess.getQueryAccess().getNamesAssignment_1_3(), "rule__Query__NamesAssignment_1_3");
			builder.put(grammarAccess.getQueryAccess().getNamesAssignment_1_4_1(), "rule__Query__NamesAssignment_1_4_1");
			builder.put(grammarAccess.getQueryAccess().getValueAssignment_1_7(), "rule__Query__ValueAssignment_1_7");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getNameAssignment_1(), "rule__SingleValDeclaration__NameAssignment_1");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getTypeAssignment_2_1(), "rule__SingleValDeclaration__TypeAssignment_2_1");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getValueAssignment_4(), "rule__SingleValDeclaration__ValueAssignment_4");
			builder.put(grammarAccess.getTupleNameAccess().getNameAssignment(), "rule__TupleName__NameAssignment");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getTypeAssignment_0_1(), "rule__TerminalTypeAnnotation__TypeAssignment_0_1");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getBaseTypeAssignment_1_1(), "rule__TerminalTypeAnnotation__BaseTypeAssignment_1_1");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getGenericTypeAssignment_1_3(), "rule__TerminalTypeAnnotation__GenericTypeAssignment_1_3");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getBaseTypeAssignment_2_1(), "rule__TerminalTypeAnnotation__BaseTypeAssignment_2_1");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getPropertySetAssignment_2_3(), "rule__TerminalTypeAnnotation__PropertySetAssignment_2_3");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getPropertyTypeAssignment_2_5(), "rule__TerminalTypeAnnotation__PropertyTypeAssignment_2_5");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getFieldsAssignment_2_6_1(), "rule__TerminalTypeAnnotation__FieldsAssignment_2_6_1");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getTypesAssignment_3_2(), "rule__TerminalTypeAnnotation__TypesAssignment_3_2");
			builder.put(grammarAccess.getTerminalTypeAnnotationAccess().getTypesAssignment_3_3_1(), "rule__TerminalTypeAnnotation__TypesAssignment_3_3_1");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_2(), "rule__Expression__RightAssignment_1_2");
			builder.put(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2(), "rule__AndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getNotExpressionAccess().getOperandAssignment_1_2(), "rule__NotExpression__OperandAssignment_1_2");
			builder.put(grammarAccess.getCallExpressionAccess().getRightAssignment_1_0_2(), "rule__CallExpression__RightAssignment_1_0_2");
			builder.put(grammarAccess.getCallExpressionAccess().getTypeArgumentAssignment_1_0_3_1(), "rule__CallExpression__TypeArgumentAssignment_1_0_3_1");
			builder.put(grammarAccess.getCallExpressionAccess().getArgumentAssignment_1_0_4_1(), "rule__CallExpression__ArgumentAssignment_1_0_4_1");
			builder.put(grammarAccess.getCallExpressionAccess().getLambdaAssignment_1_0_5(), "rule__CallExpression__LambdaAssignment_1_0_5");
			builder.put(grammarAccess.getCallExpressionAccess().getRightAssignment_1_1_2(), "rule__CallExpression__RightAssignment_1_1_2");
			builder.put(grammarAccess.getLambdaAccess().getParameterAssignment_1(), "rule__Lambda__ParameterAssignment_1");
			builder.put(grammarAccess.getLambdaAccess().getReturnValueAssignment_4(), "rule__Lambda__ReturnValueAssignment_4");
			builder.put(grammarAccess.getParameterAccess().getNamesAssignment_1_2(), "rule__Parameter__NamesAssignment_1_2");
			builder.put(grammarAccess.getParameterAccess().getNamesAssignment_1_3_1(), "rule__Parameter__NamesAssignment_1_3_1");
			builder.put(grammarAccess.getSingleParameterAccess().getNameAssignment(), "rule__SingleParameter__NameAssignment");
			builder.put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1(), "rule__TerminalExpression__ValueAssignment_2_1");
			builder.put(grammarAccess.getTerminalExpressionAccess().getReferenceAssignment_3_1(), "rule__TerminalExpression__ReferenceAssignment_3_1");
			builder.put(grammarAccess.getTerminalExpressionAccess().getElementsAssignment_4_2_1_1(), "rule__TerminalExpression__ElementsAssignment_4_2_1_1");
			builder.put(grammarAccess.getContractSubclauseAccess().getUseQueriesAssignment_1_1(), "rule__ContractSubclause__UseQueriesAssignment_1_1");
			builder.put(grammarAccess.getContractSubclauseAccess().getVerifyPlansAssignment_2_1(), "rule__ContractSubclause__VerifyPlansAssignment_2_1");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_0(), "rule__IString__PartsAssignment_0");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_1_0(), "rule__IString__PartsAssignment_1_0");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_1_1(), "rule__IString__PartsAssignment_1_1");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_1_2_0(), "rule__IString__PartsAssignment_1_2_0");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_1_2_1(), "rule__IString__PartsAssignment_1_2_1");
			builder.put(grammarAccess.getIStringAccess().getPartsAssignment_1_3(), "rule__IString__PartsAssignment_1_3");
			builder.put(grammarAccess.getIStringLiteralAccess().getValueAssignment(), "rule__IStringLiteral__ValueAssignment");
			builder.put(grammarAccess.getIStringLeftLiteralAccess().getValueAssignment(), "rule__IStringLeftLiteral__ValueAssignment");
			builder.put(grammarAccess.getIStringMiddleLiteralAccess().getValueAssignment(), "rule__IStringMiddleLiteral__ValueAssignment");
			builder.put(grammarAccess.getIStringRightLiteralAccess().getValueAssignment(), "rule__IStringRightLiteral__ValueAssignment");
			builder.put(grammarAccess.getIStringInterAccess().getDirectAssignment_0(), "rule__IStringInter__DirectAssignment_0");
			builder.put(grammarAccess.getIStringInterAccess().getDomainAssignment_1_0_0_0(), "rule__IStringInter__DomainAssignment_1_0_0_0");
			builder.put(grammarAccess.getIStringInterAccess().getQueryAssignment_1_0_1(), "rule__IStringInter__QueryAssignment_1_0_1");
			builder.put(grammarAccess.getIStringInterAccess().getPredefinedAssignment_1_1(), "rule__IStringInter__PredefinedAssignment_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0(), "rule__ContainedPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__ContainedPropertyAssociation__AppendAssignment_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2(), "rule__ContainedPropertyAssociation__ConstantAssignment_2");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2(), "rule__ContainedPropertyAssociation__InBindingAssignment_5_2");
			builder.put(grammarAccess.getPropertyAssociationAccess().getPropertyAssignment_0(), "rule__PropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__PropertyAssociation__AppendAssignment_1_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getConstantAssignment_2(), "rule__PropertyAssociation__ConstantAssignment_2");
			builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__PropertyAssociation__OwnedValueAssignment_3_0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getInBindingAssignment_4_2(), "rule__PropertyAssociation__InBindingAssignment_4_2");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
			builder.put(grammarAccess.getContainmentPathAccess().getPathAssignment(), "rule__ContainmentPath__PathAssignment");
			builder.put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_3(), "rule__ModalPropertyValue__InModeAssignment_3");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4_1(), "rule__ModalPropertyValue__InModeAssignment_4_1");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__OptionalModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2(), "rule__OptionalModalPropertyValue__InModeAssignment_1_2");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1(), "rule__OptionalModalPropertyValue__InModeAssignment_1_3_1");
			builder.put(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment(), "rule__PropertyValue__OwnedValueAssignment");
			builder.put(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment(), "rule__LiteralorReferenceTerm__NamedValueAssignment");
			builder.put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BooleanLiteral__ValueAssignment_1_0");
			builder.put(grammarAccess.getConstantValueAccess().getNamedValueAssignment(), "rule__ConstantValue__NamedValueAssignment");
			builder.put(grammarAccess.getReferenceTermAccess().getPathAssignment_2(), "rule__ReferenceTerm__PathAssignment_2");
			builder.put(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__RecordTerm__OwnedFieldValueAssignment_1");
			builder.put(grammarAccess.getOldRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__OldRecordTerm__OwnedFieldValueAssignment_1");
			builder.put(grammarAccess.getComputedTermAccess().getFunctionAssignment_2(), "rule__ComputedTerm__FunctionAssignment_2");
			builder.put(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2(), "rule__ComponentClassifierTerm__ClassifierAssignment_2");
			builder.put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0(), "rule__ListTerm__OwnedListElementAssignment_2_0");
			builder.put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1(), "rule__ListTerm__OwnedListElementAssignment_2_1_1");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0(), "rule__FieldPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__FieldPropertyAssociation__OwnedValueAssignment_2");
			builder.put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0(), "rule__ContainmentPathElement__NamedElementAssignment_0_0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1(), "rule__ContainmentPathElement__ArrayRangeAssignment_0_1");
			builder.put(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1(), "rule__ContainmentPathElement__PathAssignment_1_1");
			builder.put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
			builder.put(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2(), "rule__ArrayRange__LowerBoundAssignment_2");
			builder.put(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1(), "rule__ArrayRange__UpperBoundAssignment_3_1");
			builder.put(grammarAccess.getSignedConstantAccess().getOpAssignment_0(), "rule__SignedConstant__OpAssignment_0");
			builder.put(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1(), "rule__SignedConstant__OwnedPropertyExpressionAssignment_1");
			builder.put(grammarAccess.getIntegerTermAccess().getValueAssignment_0(), "rule__IntegerTerm__ValueAssignment_0");
			builder.put(grammarAccess.getIntegerTermAccess().getUnitAssignment_1(), "rule__IntegerTerm__UnitAssignment_1");
			builder.put(grammarAccess.getRealTermAccess().getValueAssignment_0(), "rule__RealTerm__ValueAssignment_0");
			builder.put(grammarAccess.getRealTermAccess().getUnitAssignment_1(), "rule__RealTerm__UnitAssignment_1");
			builder.put(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0(), "rule__NumericRangeTerm__MinimumAssignment_0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2(), "rule__NumericRangeTerm__MaximumAssignment_2");
			builder.put(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1(), "rule__NumericRangeTerm__DeltaAssignment_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContractGrammarAccess grammarAccess;

	@Override
	protected InternalContractParser createParser() {
		InternalContractParser result = new InternalContractParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}

	public ContractGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContractGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
