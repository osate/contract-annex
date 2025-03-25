
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
package org.osate.sysmlv2.contract.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.sysmlv2.contract.ide.contentassist.antlr.internal.InternalContractParser;
import org.osate.sysmlv2.contract.services.ContractGrammarAccess;

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
			builder.put(grammarAccess.getNotExpressionAccess().getAlternatives(), "rule__NotExpression__Alternatives");
			builder.put(grammarAccess.getCallExpressionAccess().getAlternatives_1(), "rule__CallExpression__Alternatives_1");
			builder.put(grammarAccess.getParameterAccess().getAlternatives(), "rule__Parameter__Alternatives");
			builder.put(grammarAccess.getTerminalExpressionAccess().getAlternatives(), "rule__TerminalExpression__Alternatives");
			builder.put(grammarAccess.getIStringAccess().getAlternatives(), "rule__IString__Alternatives");
			builder.put(grammarAccess.getIStringPartAccess().getAlternatives(), "rule__IStringPart__Alternatives");
			builder.put(grammarAccess.getIStringInterAccess().getAlternatives_1(), "rule__IStringInter__Alternatives_1");
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
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_7(), "rule__VerificationPlan__Group_7__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_8(), "rule__VerificationPlan__Group_8__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_9(), "rule__VerificationPlan__Group_9__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_9_1(), "rule__VerificationPlan__Group_9_1__0");
			builder.put(grammarAccess.getClaimsAccess().getGroup(), "rule__Claims__Group__0");
			builder.put(grammarAccess.getQueryAccess().getGroup_1(), "rule__Query__Group_1__0");
			builder.put(grammarAccess.getQueryAccess().getGroup_1_4(), "rule__Query__Group_1_4__0");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getGroup(), "rule__SingleValDeclaration__Group__0");
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
			builder.put(grammarAccess.getIStringAccess().getGroup_1(), "rule__IString__Group_1__0");
			builder.put(grammarAccess.getIStringAccess().getGroup_1_2(), "rule__IString__Group_1_2__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup(), "rule__IStringInter__Group__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup_1_0(), "rule__IStringInter__Group_1_0__0");
			builder.put(grammarAccess.getIStringInterAccess().getGroup_1_0_0(), "rule__IStringInter__Group_1_0_0__0");
			builder.put(grammarAccess.getOptionalQualifiedNameAccess().getGroup(), "rule__OptionalQualifiedName__Group__0");
			builder.put(grammarAccess.getOptionalQualifiedNameAccess().getGroup_0(), "rule__OptionalQualifiedName__Group_0__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
			builder.put(grammarAccess.getContractLibraryAccess().getDeclaredNameAssignment_1(), "rule__ContractLibrary__DeclaredNameAssignment_1");
			builder.put(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_3(), "rule__ContractLibrary__ContractElementsAssignment_3");
			builder.put(grammarAccess.getContractAccess().getDeclaredNameAssignment_1(), "rule__Contract__DeclaredNameAssignment_1");
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
			builder.put(grammarAccess.getImplementationAccess().getDeclaredNameAssignment_2(), "rule__Implementation__DeclaredNameAssignment_2");
			builder.put(grammarAccess.getImplementationAccess().getCodeAssignment_4(), "rule__Implementation__CodeAssignment_4");
			builder.put(grammarAccess.getDomainAccess().getDeclaredNameAssignment_1(), "rule__Domain__DeclaredNameAssignment_1");
			builder.put(grammarAccess.getDomainAccess().getCodeAssignment_4_1(), "rule__Domain__CodeAssignment_4_1");
			builder.put(grammarAccess.getArgumentAccess().getDeclaredNameAssignment_1(), "rule__Argument__DeclaredNameAssignment_1");
			builder.put(grammarAccess.getArgumentAccess().getGuaranteeAssignment_4_2(), "rule__Argument__GuaranteeAssignment_4_2");
			builder.put(grammarAccess.getArgumentAccess().getArgumentExpressionAssignment_5_1(), "rule__Argument__ArgumentExpressionAssignment_5_1");
			builder.put(grammarAccess.getArgumentTermAccess().getContractsAssignment_0_1(), "rule__ArgumentTerm__ContractsAssignment_0_1");
			builder.put(grammarAccess.getArgumentTermAccess().getArgumentsAssignment_1_1(), "rule__ArgumentTerm__ArgumentsAssignment_1_1");
			builder.put(grammarAccess.getArgumentTermAccess().getNestedAssignment_2(), "rule__ArgumentTerm__NestedAssignment_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getDeclaredNameAssignment_2(), "rule__VerificationPlan__DeclaredNameAssignment_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getOccurenceDefinitionAssignment_5(), "rule__VerificationPlan__OccurenceDefinitionAssignment_5");
			builder.put(grammarAccess.getVerificationPlanAccess().getContractsAssignment_9_1_0(), "rule__VerificationPlan__ContractsAssignment_9_1_0");
			builder.put(grammarAccess.getClaimsAccess().getClaimsAssignment_0(), "rule__Claims__ClaimsAssignment_0");
			builder.put(grammarAccess.getQueryAccess().getNamesAssignment_1_3(), "rule__Query__NamesAssignment_1_3");
			builder.put(grammarAccess.getQueryAccess().getNamesAssignment_1_4_1(), "rule__Query__NamesAssignment_1_4_1");
			builder.put(grammarAccess.getQueryAccess().getValueAssignment_1_7(), "rule__Query__ValueAssignment_1_7");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getDeclaredNameAssignment_1(), "rule__SingleValDeclaration__DeclaredNameAssignment_1");
			builder.put(grammarAccess.getSingleValDeclarationAccess().getValueAssignment_3(), "rule__SingleValDeclaration__ValueAssignment_3");
			builder.put(grammarAccess.getTupleNameAccess().getDeclaredNameAssignment(), "rule__TupleName__DeclaredNameAssignment");
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
			builder.put(grammarAccess.getSingleParameterAccess().getDeclaredNameAssignment(), "rule__SingleParameter__DeclaredNameAssignment");
			builder.put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1(), "rule__TerminalExpression__ValueAssignment_1_1");
			builder.put(grammarAccess.getTerminalExpressionAccess().getReferenceAssignment_2_1(), "rule__TerminalExpression__ReferenceAssignment_2_1");
			builder.put(grammarAccess.getTerminalExpressionAccess().getUsageAssignment_3_2(), "rule__TerminalExpression__UsageAssignment_3_2");
			builder.put(grammarAccess.getTerminalExpressionAccess().getElementsAssignment_4_2_1_1(), "rule__TerminalExpression__ElementsAssignment_4_2_1_1");
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
