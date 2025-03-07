
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
package org.osate.sysmlv2.contract.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ContractGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class ContractLibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ContractLibrary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cContractElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cContractElementsContractElementParserRuleCall_3_0 = (RuleCall)cContractElementsAssignment_3.eContents().get(0);
		
		//ContractLibrary:
		//    'package' name = ID ';'
		//    contractElements+=ContractElement*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'package' name = ID ';'
		//contractElements+=ContractElement*
		public Group getGroup() { return cGroup; }
		
		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }
		
		//name = ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
		
		//contractElements+=ContractElement*
		public Assignment getContractElementsAssignment_3() { return cContractElementsAssignment_3; }
		
		//ContractElement
		public RuleCall getContractElementsContractElementParserRuleCall_3_0() { return cContractElementsContractElementParserRuleCall_3_0; }
	}
	public class NamedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.NamedElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cContractElementParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSingleValDeclarationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTupleNameParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSingleParameterParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//NamedElement returns sysmlv2::Element: // aadl2::NamedElement:
		//    ContractElement | SingleValDeclaration | TupleName | SingleParameter
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//// aadl2::NamedElement:
		//   ContractElement | SingleValDeclaration | TupleName | SingleParameter
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//// aadl2::NamedElement:
		//   ContractElement
		public RuleCall getContractElementParserRuleCall_0() { return cContractElementParserRuleCall_0; }
		
		//SingleValDeclaration
		public RuleCall getSingleValDeclarationParserRuleCall_1() { return cSingleValDeclarationParserRuleCall_1; }
		
		//TupleName
		public RuleCall getTupleNameParserRuleCall_2() { return cTupleNameParserRuleCall_2; }
		
		//SingleParameter
		public RuleCall getSingleParameterParserRuleCall_3() { return cSingleParameterParserRuleCall_3; }
	}
	public class ContractElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ContractElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cImplementationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDomainParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cArgumentParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cContractParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cVerificationPlanParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//ContractElement:
		//    Implementation | Domain | Argument | Contract | VerificationPlan
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Implementation | Domain | Argument | Contract | VerificationPlan
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Implementation
		public RuleCall getImplementationParserRuleCall_0() { return cImplementationParserRuleCall_0; }
		
		//Domain
		public RuleCall getDomainParserRuleCall_1() { return cDomainParserRuleCall_1; }
		
		//Argument
		public RuleCall getArgumentParserRuleCall_2() { return cArgumentParserRuleCall_2; }
		
		//Contract
		public RuleCall getContractParserRuleCall_3() { return cContractParserRuleCall_3; }
		
		//VerificationPlan
		public RuleCall getVerificationPlanParserRuleCall_4() { return cVerificationPlanParserRuleCall_4; }
	}
	public class ContractElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Contract");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContractKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cDomainsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cDomainsParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cQueriesKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cQueriesParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cInputKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cAssumptionsKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cInputsAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cInputsInputAssumptionParserRuleCall_5_2_0 = (RuleCall)cInputsAssignment_5_2.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cAssumptionsKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final RuleCall cAssumptionsParserRuleCall_6_1 = (RuleCall)cGroup_6.eContents().get(1);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cGuaranteeKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final RuleCall cExactParserRuleCall_7_1 = (RuleCall)cGroup_7.eContents().get(1);
		private final Assignment cGuaranteeAssignment_7_2 = (Assignment)cGroup_7.eContents().get(2);
		private final RuleCall cGuaranteeGuaranteeParserRuleCall_7_2_0 = (RuleCall)cGuaranteeAssignment_7_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_7_3 = (Keyword)cGroup_7.eContents().get(3);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Alternatives cAlternatives_8_0 = (Alternatives)cGroup_8.eContents().get(0);
		private final Keyword cInvocationKeyword_8_0_0 = (Keyword)cAlternatives_8_0.eContents().get(0);
		private final Keyword cAnalysisKeyword_8_0_1 = (Keyword)cAlternatives_8_0.eContents().get(1);
		private final RuleCall cAnalysesParserRuleCall_8_1 = (RuleCall)cGroup_8.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//Contract:
		//    'contract' name=ID '{'
		//    ('domains'
		//        Domains
		//    )?
		//    ('queries'
		//        Queries
		//    )?
		//    ('input' 'assumptions'
		//        inputs+=InputAssumption*
		//    )?
		//    ('assumptions'
		//        Assumptions
		//    )?
		//    ('guarantee'
		//        Exact guarantee=Guarantee ';'
		//    )?
		//    (('invocation' | 'analysis')
		//        Analyses
		//    )?
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'contract' name=ID '{'
		//('domains'
		//    Domains
		//)?
		//('queries'
		//    Queries
		//)?
		//('input' 'assumptions'
		//    inputs+=InputAssumption*
		//)?
		//('assumptions'
		//    Assumptions
		//)?
		//('guarantee'
		//    Exact guarantee=Guarantee ';'
		//)?
		//(('invocation' | 'analysis')
		//    Analyses
		//)?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'contract'
		public Keyword getContractKeyword_0() { return cContractKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('domains'
		//    Domains
		//)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'domains'
		public Keyword getDomainsKeyword_3_0() { return cDomainsKeyword_3_0; }
		
		//Domains
		public RuleCall getDomainsParserRuleCall_3_1() { return cDomainsParserRuleCall_3_1; }
		
		//('queries'
		//    Queries
		//)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'queries'
		public Keyword getQueriesKeyword_4_0() { return cQueriesKeyword_4_0; }
		
		//Queries
		public RuleCall getQueriesParserRuleCall_4_1() { return cQueriesParserRuleCall_4_1; }
		
		//('input' 'assumptions'
		//    inputs+=InputAssumption*
		//)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'input'
		public Keyword getInputKeyword_5_0() { return cInputKeyword_5_0; }
		
		//'assumptions'
		public Keyword getAssumptionsKeyword_5_1() { return cAssumptionsKeyword_5_1; }
		
		//inputs+=InputAssumption*
		public Assignment getInputsAssignment_5_2() { return cInputsAssignment_5_2; }
		
		//InputAssumption
		public RuleCall getInputsInputAssumptionParserRuleCall_5_2_0() { return cInputsInputAssumptionParserRuleCall_5_2_0; }
		
		//('assumptions'
		//    Assumptions
		//)?
		public Group getGroup_6() { return cGroup_6; }
		
		//'assumptions'
		public Keyword getAssumptionsKeyword_6_0() { return cAssumptionsKeyword_6_0; }
		
		//Assumptions
		public RuleCall getAssumptionsParserRuleCall_6_1() { return cAssumptionsParserRuleCall_6_1; }
		
		//('guarantee'
		//    Exact guarantee=Guarantee ';'
		//)?
		public Group getGroup_7() { return cGroup_7; }
		
		//'guarantee'
		public Keyword getGuaranteeKeyword_7_0() { return cGuaranteeKeyword_7_0; }
		
		//Exact
		public RuleCall getExactParserRuleCall_7_1() { return cExactParserRuleCall_7_1; }
		
		//guarantee=Guarantee
		public Assignment getGuaranteeAssignment_7_2() { return cGuaranteeAssignment_7_2; }
		
		//Guarantee
		public RuleCall getGuaranteeGuaranteeParserRuleCall_7_2_0() { return cGuaranteeGuaranteeParserRuleCall_7_2_0; }
		
		//';'
		public Keyword getSemicolonKeyword_7_3() { return cSemicolonKeyword_7_3; }
		
		//(('invocation' | 'analysis')
		//    Analyses
		//)?
		public Group getGroup_8() { return cGroup_8; }
		
		//('invocation' | 'analysis')
		public Alternatives getAlternatives_8_0() { return cAlternatives_8_0; }
		
		//'invocation'
		public Keyword getInvocationKeyword_8_0_0() { return cInvocationKeyword_8_0_0; }
		
		//'analysis'
		public Keyword getAnalysisKeyword_8_0_1() { return cAnalysisKeyword_8_0_1; }
		
		//Analyses
		public RuleCall getAnalysesParserRuleCall_8_1() { return cAnalysesParserRuleCall_8_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class ExactElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Exact");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Assignment cExactAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0 = (Keyword)cExactAssignment_1.eContents().get(0);
		
		//fragment Exact*:
		//    '=>'
		//    | exact?='<=>'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'=>'
		//| exact?='<=>'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_0() { return cEqualsSignGreaterThanSignKeyword_0; }
		
		//exact?='<=>'
		public Assignment getExactAssignment_1() { return cExactAssignment_1; }
		
		//'<=>'
		public Keyword getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0() { return cExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0; }
	}
	public class QueriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Queries");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cQueriesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cQueriesQueryParserRuleCall_0_0 = (RuleCall)cQueriesAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//fragment Queries*:
		//    (queries+=Query? ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(queries+=Query? ';')*
		public Group getGroup() { return cGroup; }
		
		//queries+=Query?
		public Assignment getQueriesAssignment_0() { return cQueriesAssignment_0; }
		
		//Query
		public RuleCall getQueriesQueryParserRuleCall_0_0() { return cQueriesQueryParserRuleCall_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class DomainsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Domains");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cDomainsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cDomainsDomainCrossReference_0_0 = (CrossReference)cDomainsAssignment_0.eContents().get(0);
		private final RuleCall cDomainsDomainQPREFParserRuleCall_0_0_1 = (RuleCall)cDomainsDomainCrossReference_0_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//fragment Domains*:
		//    (domains+=[Domain|QPREF]? ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(domains+=[Domain|QPREF]? ';')*
		public Group getGroup() { return cGroup; }
		
		//domains+=[Domain|QPREF]?
		public Assignment getDomainsAssignment_0() { return cDomainsAssignment_0; }
		
		//[Domain|QPREF]
		public CrossReference getDomainsDomainCrossReference_0_0() { return cDomainsDomainCrossReference_0_0; }
		
		//QPREF
		public RuleCall getDomainsDomainQPREFParserRuleCall_0_0_1() { return cDomainsDomainQPREFParserRuleCall_0_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class AssumptionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Assumptions");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cAssumptionsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAssumptionsAssumptionElementParserRuleCall_0_0 = (RuleCall)cAssumptionsAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//fragment Assumptions*:
		//    (assumptions+=AssumptionElement? ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(assumptions+=AssumptionElement? ';')*
		public Group getGroup() { return cGroup; }
		
		//assumptions+=AssumptionElement?
		public Assignment getAssumptionsAssignment_0() { return cAssumptionsAssignment_0; }
		
		//AssumptionElement
		public RuleCall getAssumptionsAssumptionElementParserRuleCall_0_0() { return cAssumptionsAssumptionElementParserRuleCall_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class AnalysesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Analyses");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cAnalysesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cAnalysesAnalysisParserRuleCall_0_0 = (RuleCall)cAnalysesAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//fragment Analyses*:
		//    (analyses+=Analysis? ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(analyses+=Analysis? ';')*
		public Group getGroup() { return cGroup; }
		
		//analyses+=Analysis?
		public Assignment getAnalysesAssignment_0() { return cAnalysesAssignment_0; }
		
		//Analysis
		public RuleCall getAnalysesAnalysisParserRuleCall_0_0() { return cAnalysesAnalysisParserRuleCall_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class InputAssumptionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.InputAssumption");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInputAssumptionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cCodeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCodeSourceParserRuleCall_1_0 = (RuleCall)cCodeAssignment_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//InputAssumption:
		//    {InputAssumption}
		//    (code=Source)? ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{InputAssumption}
		//(code=Source)? ';'
		public Group getGroup() { return cGroup; }
		
		//{InputAssumption}
		public Action getInputAssumptionAction_0() { return cInputAssumptionAction_0; }
		
		//(code=Source)?
		public Assignment getCodeAssignment_1() { return cCodeAssignment_1; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_1_0() { return cCodeSourceParserRuleCall_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class AssumptionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.AssumptionElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cContractAssumptionAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cContractKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cContractAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final CrossReference cContractContractElementCrossReference_0_2_0 = (CrossReference)cContractAssignment_0_2.eContents().get(0);
		private final RuleCall cContractContractElementQPREFParserRuleCall_0_2_0_1 = (RuleCall)cContractContractElementCrossReference_0_2_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cArgumentAssumptionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cArgumentKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cArgumentAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cArgumentContractElementCrossReference_1_2_0 = (CrossReference)cArgumentAssignment_1_2.eContents().get(0);
		private final RuleCall cArgumentContractElementQPREFParserRuleCall_1_2_0_1 = (RuleCall)cArgumentContractElementCrossReference_1_2_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cCodeAssumptionAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Assignment cCodeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cCodeSourceParserRuleCall_2_1_0 = (RuleCall)cCodeAssignment_2_1.eContents().get(0);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final RuleCall cExactParserRuleCall_2_2_0 = (RuleCall)cGroup_2_2.eContents().get(0);
		private final Assignment cGuaranteeAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final RuleCall cGuaranteeGuaranteeParserRuleCall_2_2_1_0 = (RuleCall)cGuaranteeAssignment_2_2_1.eContents().get(0);
		
		//AssumptionElement:
		//    (
		//        {ContractAssumption} 'contract' contract=[ContractElement|QPREF]
		//        | {ArgumentAssumption} 'argument' argument=[ContractElement|QPREF]
		//        | {CodeAssumption} code=Source     (Exact guarantee=Guarantee)?
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(
		//    {ContractAssumption} 'contract' contract=[ContractElement|QPREF]
		//    | {ArgumentAssumption} 'argument' argument=[ContractElement|QPREF]
		//    | {CodeAssumption} code=Source     (Exact guarantee=Guarantee)?
		//)
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{ContractAssumption} 'contract' contract=[ContractElement|QPREF]
		public Group getGroup_0() { return cGroup_0; }
		
		//{ContractAssumption}
		public Action getContractAssumptionAction_0_0() { return cContractAssumptionAction_0_0; }
		
		//'contract'
		public Keyword getContractKeyword_0_1() { return cContractKeyword_0_1; }
		
		//contract=[ContractElement|QPREF]
		public Assignment getContractAssignment_0_2() { return cContractAssignment_0_2; }
		
		//[ContractElement|QPREF]
		public CrossReference getContractContractElementCrossReference_0_2_0() { return cContractContractElementCrossReference_0_2_0; }
		
		//QPREF
		public RuleCall getContractContractElementQPREFParserRuleCall_0_2_0_1() { return cContractContractElementQPREFParserRuleCall_0_2_0_1; }
		
		//{ArgumentAssumption} 'argument' argument=[ContractElement|QPREF]
		public Group getGroup_1() { return cGroup_1; }
		
		//{ArgumentAssumption}
		public Action getArgumentAssumptionAction_1_0() { return cArgumentAssumptionAction_1_0; }
		
		//'argument'
		public Keyword getArgumentKeyword_1_1() { return cArgumentKeyword_1_1; }
		
		//argument=[ContractElement|QPREF]
		public Assignment getArgumentAssignment_1_2() { return cArgumentAssignment_1_2; }
		
		//[ContractElement|QPREF]
		public CrossReference getArgumentContractElementCrossReference_1_2_0() { return cArgumentContractElementCrossReference_1_2_0; }
		
		//QPREF
		public RuleCall getArgumentContractElementQPREFParserRuleCall_1_2_0_1() { return cArgumentContractElementQPREFParserRuleCall_1_2_0_1; }
		
		//{CodeAssumption} code=Source 	(Exact guarantee=Guarantee)?
		public Group getGroup_2() { return cGroup_2; }
		
		//{CodeAssumption}
		public Action getCodeAssumptionAction_2_0() { return cCodeAssumptionAction_2_0; }
		
		//code=Source
		public Assignment getCodeAssignment_2_1() { return cCodeAssignment_2_1; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_2_1_0() { return cCodeSourceParserRuleCall_2_1_0; }
		
		//(Exact guarantee=Guarantee)?
		public Group getGroup_2_2() { return cGroup_2_2; }
		
		//Exact
		public RuleCall getExactParserRuleCall_2_2_0() { return cExactParserRuleCall_2_2_0; }
		
		//guarantee=Guarantee
		public Assignment getGuaranteeAssignment_2_2_1() { return cGuaranteeAssignment_2_2_1; }
		
		//Guarantee
		public RuleCall getGuaranteeGuaranteeParserRuleCall_2_2_1_0() { return cGuaranteeGuaranteeParserRuleCall_2_2_1_0; }
	}
	public class GuaranteeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Guarantee");
		private final Assignment cCodeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCodeSourceParserRuleCall_0 = (RuleCall)cCodeAssignment.eContents().get(0);
		
		//Guarantee:
		//    code=Source
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//code=Source
		public Assignment getCodeAssignment() { return cCodeAssignment; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_0() { return cCodeSourceParserRuleCall_0; }
	}
	public class AnalysisElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Analysis");
		private final Assignment cCodeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCodeSourceParserRuleCall_0 = (RuleCall)cCodeAssignment.eContents().get(0);
		
		//Analysis:
		//    code=Source
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//code=Source
		public Assignment getCodeAssignment() { return cCodeAssignment; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_0() { return cCodeSourceParserRuleCall_0; }
	}
	public class SourceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Source");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLanguageAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLanguageLanguageEnumRuleCall_0_0 = (RuleCall)cLanguageAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cSourceAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cSourceSSTRINGTerminalRuleCall_1_0_0 = (RuleCall)cSourceAssignment_1_0.eContents().get(0);
		private final Assignment cInterAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cInterIStringParserRuleCall_1_1_0 = (RuleCall)cInterAssignment_1_1.eContents().get(0);
		
		//Source:
		//    (language=Language)?
		//    (source=SSTRING | inter=IString)
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(language=Language)?
		//(source=SSTRING | inter=IString)
		public Group getGroup() { return cGroup; }
		
		//(language=Language)?
		public Assignment getLanguageAssignment_0() { return cLanguageAssignment_0; }
		
		//Language
		public RuleCall getLanguageLanguageEnumRuleCall_0_0() { return cLanguageLanguageEnumRuleCall_0_0; }
		
		//(source=SSTRING | inter=IString)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//source=SSTRING
		public Assignment getSourceAssignment_1_0() { return cSourceAssignment_1_0; }
		
		//SSTRING
		public RuleCall getSourceSSTRINGTerminalRuleCall_1_0_0() { return cSourceSSTRINGTerminalRuleCall_1_0_0; }
		
		//inter=IString
		public Assignment getInterAssignment_1_1() { return cInterAssignment_1_1; }
		
		//IString
		public RuleCall getInterIStringParserRuleCall_1_1_0() { return cInterIStringParserRuleCall_1_1_0; }
	}
	public class ImplementationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Implementation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContractKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cImplementationKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCodeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCodeSourceParserRuleCall_4_0 = (RuleCall)cCodeAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Implementation:
		//    'contract' 'implementation' name=ID '{'
		//        code=Source
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'contract' 'implementation' name=ID '{'
		//    code=Source
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'contract'
		public Keyword getContractKeyword_0() { return cContractKeyword_0; }
		
		//'implementation'
		public Keyword getImplementationKeyword_1() { return cImplementationKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//code=Source
		public Assignment getCodeAssignment_4() { return cCodeAssignment_4; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_4_0() { return cCodeSourceParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class DomainElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Domain");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDomainKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cQueriesKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cQueriesParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cDeclarationsKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cCodeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cCodeSourceParserRuleCall_4_1_0 = (RuleCall)cCodeAssignment_4_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Domain:
		//    'domain' name=ID '{'
		//    ('queries'
		//        Queries
		//    )?
		//    ('declarations'
		//        code=Source
		//    )?
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'domain' name=ID '{'
		//('queries'
		//    Queries
		//)?
		//('declarations'
		//    code=Source
		//)?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'domain'
		public Keyword getDomainKeyword_0() { return cDomainKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('queries'
		//    Queries
		//)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'queries'
		public Keyword getQueriesKeyword_3_0() { return cQueriesKeyword_3_0; }
		
		//Queries
		public RuleCall getQueriesParserRuleCall_3_1() { return cQueriesParserRuleCall_3_1; }
		
		//('declarations'
		//    code=Source
		//)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'declarations'
		public Keyword getDeclarationsKeyword_4_0() { return cDeclarationsKeyword_4_0; }
		
		//code=Source
		public Assignment getCodeAssignment_4_1() { return cCodeAssignment_4_1; }
		
		//Source
		public RuleCall getCodeSourceParserRuleCall_4_1_0() { return cCodeSourceParserRuleCall_4_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class ArgumentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Argument");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cArgumentKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cDomainsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final RuleCall cDomainsParserRuleCall_3_1 = (RuleCall)cGroup_3.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cGuaranteeKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cExactParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Assignment cGuaranteeAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final RuleCall cGuaranteeGuaranteeParserRuleCall_4_2_0 = (RuleCall)cGuaranteeAssignment_4_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cArgumentKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cArgumentExpressionAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cArgumentExpressionArgumentExpressionParserRuleCall_5_1_0 = (RuleCall)cArgumentExpressionAssignment_5_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Argument:
		//    'argument' name=ID '{'
		//    ('domains'
		//        Domains
		//    )?
		//    ('guarantee'
		//        Exact guarantee=Guarantee ';'
		//    )?
		//    ('argument'
		//        argumentExpression=ArgumentExpression ';'
		//    )?
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'argument' name=ID '{'
		//('domains'
		//    Domains
		//)?
		//('guarantee'
		//    Exact guarantee=Guarantee ';'
		//)?
		//('argument'
		//    argumentExpression=ArgumentExpression ';'
		//)?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//'argument'
		public Keyword getArgumentKeyword_0() { return cArgumentKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//('domains'
		//    Domains
		//)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'domains'
		public Keyword getDomainsKeyword_3_0() { return cDomainsKeyword_3_0; }
		
		//Domains
		public RuleCall getDomainsParserRuleCall_3_1() { return cDomainsParserRuleCall_3_1; }
		
		//('guarantee'
		//    Exact guarantee=Guarantee ';'
		//)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'guarantee'
		public Keyword getGuaranteeKeyword_4_0() { return cGuaranteeKeyword_4_0; }
		
		//Exact
		public RuleCall getExactParserRuleCall_4_1() { return cExactParserRuleCall_4_1; }
		
		//guarantee=Guarantee
		public Assignment getGuaranteeAssignment_4_2() { return cGuaranteeAssignment_4_2; }
		
		//Guarantee
		public RuleCall getGuaranteeGuaranteeParserRuleCall_4_2_0() { return cGuaranteeGuaranteeParserRuleCall_4_2_0; }
		
		//';'
		public Keyword getSemicolonKeyword_4_3() { return cSemicolonKeyword_4_3; }
		
		//('argument'
		//    argumentExpression=ArgumentExpression ';'
		//)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'argument'
		public Keyword getArgumentKeyword_5_0() { return cArgumentKeyword_5_0; }
		
		//argumentExpression=ArgumentExpression
		public Assignment getArgumentExpressionAssignment_5_1() { return cArgumentExpressionAssignment_5_1; }
		
		//ArgumentExpression
		public RuleCall getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0() { return cArgumentExpressionArgumentExpressionParserRuleCall_5_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_5_2() { return cSemicolonKeyword_5_2; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class ArgumentExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ArgumentExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cArgumentOrParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cArgumentAndParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cArgumentNotParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ArgumentExpression:
		//    (
		//      ArgumentOr
		//    | ArgumentAnd
		//    | ArgumentNot
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(
		//  ArgumentOr
		//| ArgumentAnd
		//| ArgumentNot
		//)
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ArgumentOr
		public RuleCall getArgumentOrParserRuleCall_0() { return cArgumentOrParserRuleCall_0; }
		
		//ArgumentAnd
		public RuleCall getArgumentAndParserRuleCall_1() { return cArgumentAndParserRuleCall_1; }
		
		//ArgumentNot
		public RuleCall getArgumentNotParserRuleCall_2() { return cArgumentNotParserRuleCall_2; }
	}
	public class ArgumentAndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ArgumentAnd");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cArgumentAndAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAndKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cArgumentTermParserRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cArgumentTermParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ArgumentAnd returns ArgumentExpression:
		//    {ArgumentAnd}
		//    'and' '('
		//        ArgumentTerm (','? ArgumentTerm)*
		//    ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ArgumentAnd}
		//'and' '('
		//    ArgumentTerm (','? ArgumentTerm)*
		//')'
		public Group getGroup() { return cGroup; }
		
		//{ArgumentAnd}
		public Action getArgumentAndAction_0() { return cArgumentAndAction_0; }
		
		//'and'
		public Keyword getAndKeyword_1() { return cAndKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_3() { return cArgumentTermParserRuleCall_3; }
		
		//(','? ArgumentTerm)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','?
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_4_1() { return cArgumentTermParserRuleCall_4_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ArgumentOrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ArgumentOr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cArgumentOrAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOrKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cArgumentTermParserRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cArgumentTermParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ArgumentOr returns ArgumentExpression:
		//    {ArgumentOr}
		//    'or' '('
		//        ArgumentTerm (','? ArgumentTerm)*
		//    ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ArgumentOr}
		//'or' '('
		//    ArgumentTerm (','? ArgumentTerm)*
		//')'
		public Group getGroup() { return cGroup; }
		
		//{ArgumentOr}
		public Action getArgumentOrAction_0() { return cArgumentOrAction_0; }
		
		//'or'
		public Keyword getOrKeyword_1() { return cOrKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_3() { return cArgumentTermParserRuleCall_3; }
		
		//(','? ArgumentTerm)*
		public Group getGroup_4() { return cGroup_4; }
		
		//','?
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_4_1() { return cArgumentTermParserRuleCall_4_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ArgumentNotElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ArgumentNot");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cArgumentNotAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNotKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final RuleCall cArgumentTermParserRuleCall_2_0 = (RuleCall)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final RuleCall cArgumentTermParserRuleCall_2_1_1 = (RuleCall)cGroup_2_1.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_1_2 = (Keyword)cGroup_2_1.eContents().get(2);
		
		//ArgumentNot returns ArgumentExpression:
		//    {ArgumentNot}
		//    'not'
		//        (ArgumentTerm | '(' ArgumentTerm')')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ArgumentNot}
		//'not'
		//    (ArgumentTerm | '(' ArgumentTerm')')
		public Group getGroup() { return cGroup; }
		
		//{ArgumentNot}
		public Action getArgumentNotAction_0() { return cArgumentNotAction_0; }
		
		//'not'
		public Keyword getNotKeyword_1() { return cNotKeyword_1; }
		
		//(ArgumentTerm | '(' ArgumentTerm')')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_2_0() { return cArgumentTermParserRuleCall_2_0; }
		
		//'(' ArgumentTerm')'
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_1_0() { return cLeftParenthesisKeyword_2_1_0; }
		
		//ArgumentTerm
		public RuleCall getArgumentTermParserRuleCall_2_1_1() { return cArgumentTermParserRuleCall_2_1_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_1_2() { return cRightParenthesisKeyword_2_1_2; }
	}
	public class ArgumentTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ArgumentTerm");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(0);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cContractKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cContractsAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final CrossReference cContractsContractElementCrossReference_0_1_0 = (CrossReference)cContractsAssignment_0_1.eContents().get(0);
		private final RuleCall cContractsContractElementQPREFParserRuleCall_0_1_0_1 = (RuleCall)cContractsContractElementCrossReference_0_1_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cArgumentKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cArgumentsContractElementCrossReference_1_1_0 = (CrossReference)cArgumentsAssignment_1_1.eContents().get(0);
		private final RuleCall cArgumentsContractElementQPREFParserRuleCall_1_1_0_1 = (RuleCall)cArgumentsContractElementCrossReference_1_1_0.eContents().get(1);
		private final Assignment cNestedAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cNestedArgumentExpressionParserRuleCall_2_0 = (RuleCall)cNestedAssignment_2.eContents().get(0);
		
		//fragment ArgumentTerm*:
		//    (
		//       'contract' contracts+=[ContractElement|QPREF]
		//     | 'argument' arguments+=[ContractElement|QPREF]
		//     | nested+=ArgumentExpression
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(
		//   'contract' contracts+=[ContractElement|QPREF]
		// | 'argument' arguments+=[ContractElement|QPREF]
		// | nested+=ArgumentExpression
		//)
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'contract' contracts+=[ContractElement|QPREF]
		public Group getGroup_0() { return cGroup_0; }
		
		//'contract'
		public Keyword getContractKeyword_0_0() { return cContractKeyword_0_0; }
		
		//contracts+=[ContractElement|QPREF]
		public Assignment getContractsAssignment_0_1() { return cContractsAssignment_0_1; }
		
		//[ContractElement|QPREF]
		public CrossReference getContractsContractElementCrossReference_0_1_0() { return cContractsContractElementCrossReference_0_1_0; }
		
		//QPREF
		public RuleCall getContractsContractElementQPREFParserRuleCall_0_1_0_1() { return cContractsContractElementQPREFParserRuleCall_0_1_0_1; }
		
		//'argument' arguments+=[ContractElement|QPREF]
		public Group getGroup_1() { return cGroup_1; }
		
		//'argument'
		public Keyword getArgumentKeyword_1_0() { return cArgumentKeyword_1_0; }
		
		//arguments+=[ContractElement|QPREF]
		public Assignment getArgumentsAssignment_1_1() { return cArgumentsAssignment_1_1; }
		
		//[ContractElement|QPREF]
		public CrossReference getArgumentsContractElementCrossReference_1_1_0() { return cArgumentsContractElementCrossReference_1_1_0; }
		
		//QPREF
		public RuleCall getArgumentsContractElementQPREFParserRuleCall_1_1_0_1() { return cArgumentsContractElementQPREFParserRuleCall_1_1_0_1; }
		
		//nested+=ArgumentExpression
		public Assignment getNestedAssignment_2() { return cNestedAssignment_2; }
		
		//ArgumentExpression
		public RuleCall getNestedArgumentExpressionParserRuleCall_2_0() { return cNestedArgumentExpressionParserRuleCall_2_0; }
	}
	public class VerificationPlanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.VerificationPlan");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPlanKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cComponentKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final RuleCall cIDTerminalRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cComponentImplementationAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final CrossReference cComponentImplementationOccurrenceDefinitionCrossReference_7_0 = (CrossReference)cComponentImplementationAssignment_7.eContents().get(0);
		private final RuleCall cComponentImplementationOccurrenceDefinitionQCREFParserRuleCall_7_0_1 = (RuleCall)cComponentImplementationOccurrenceDefinitionCrossReference_7_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cDomainsKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final RuleCall cDomainsParserRuleCall_9_1 = (RuleCall)cGroup_9.eContents().get(1);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cClaimsKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final RuleCall cClaimsParserRuleCall_10_1 = (RuleCall)cGroup_10.eContents().get(1);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cContractsKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Group cGroup_11_1 = (Group)cGroup_11.eContents().get(1);
		private final Assignment cContractsAssignment_11_1_0 = (Assignment)cGroup_11_1.eContents().get(0);
		private final CrossReference cContractsContractCrossReference_11_1_0_0 = (CrossReference)cContractsAssignment_11_1_0.eContents().get(0);
		private final RuleCall cContractsContractQPREFParserRuleCall_11_1_0_0_1 = (RuleCall)cContractsContractCrossReference_11_1_0_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_11_1_1 = (Keyword)cGroup_11_1.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//VerificationPlan:
		//    'verification' 'plan' name=ID '{'
		//    'component'
		////        ID ':' componentImplementation=[aadl2::ComponentImplementation|QCREF] ';'
		//        ID ':' componentImplementation=[sysmlv2::OccurrenceDefinition|QCREF] ';'
		//    ('domains'
		//        Domains
		//    )?
		//    ('claims'
		//        Claims
		//    )?
		//    ('contracts'
		//        (contracts+=[Contract|QPREF]? ';')*
		//    )?
		//    '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//    'verification' 'plan' name=ID '{'
		//    'component'
		////        ID ':' componentImplementation=[aadl2::ComponentImplementation|QCREF] ';'
		//        ID ':' componentImplementation=[sysmlv2::OccurrenceDefinition|QCREF] ';'
		//    ('domains'
		//        Domains
		//    )?
		//    ('claims'
		//        Claims
		//    )?
		//    ('contracts'
		//        (contracts+=[Contract|QPREF]? ';')*
		//    )?
		//    '}'
		public Group getGroup() { return cGroup; }
		
		//'verification'
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }
		
		//'plan'
		public Keyword getPlanKeyword_1() { return cPlanKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//'component'
		public Keyword getComponentKeyword_4() { return cComponentKeyword_4; }
		
		////        ID ':' componentImplementation=[aadl2::ComponentImplementation|QCREF] ';'
		//        ID
		public RuleCall getIDTerminalRuleCall_5() { return cIDTerminalRuleCall_5; }
		
		//':'
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }
		
		//componentImplementation=[sysmlv2::OccurrenceDefinition|QCREF]
		public Assignment getComponentImplementationAssignment_7() { return cComponentImplementationAssignment_7; }
		
		//[sysmlv2::OccurrenceDefinition|QCREF]
		public CrossReference getComponentImplementationOccurrenceDefinitionCrossReference_7_0() { return cComponentImplementationOccurrenceDefinitionCrossReference_7_0; }
		
		//QCREF
		public RuleCall getComponentImplementationOccurrenceDefinitionQCREFParserRuleCall_7_0_1() { return cComponentImplementationOccurrenceDefinitionQCREFParserRuleCall_7_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
		
		//('domains'
		//    Domains
		//)?
		public Group getGroup_9() { return cGroup_9; }
		
		//'domains'
		public Keyword getDomainsKeyword_9_0() { return cDomainsKeyword_9_0; }
		
		//Domains
		public RuleCall getDomainsParserRuleCall_9_1() { return cDomainsParserRuleCall_9_1; }
		
		//('claims'
		//    Claims
		//)?
		public Group getGroup_10() { return cGroup_10; }
		
		//'claims'
		public Keyword getClaimsKeyword_10_0() { return cClaimsKeyword_10_0; }
		
		//Claims
		public RuleCall getClaimsParserRuleCall_10_1() { return cClaimsParserRuleCall_10_1; }
		
		//('contracts'
		//    (contracts+=[Contract|QPREF]? ';')*
		//)?
		public Group getGroup_11() { return cGroup_11; }
		
		//'contracts'
		public Keyword getContractsKeyword_11_0() { return cContractsKeyword_11_0; }
		
		//(contracts+=[Contract|QPREF]? ';')*
		public Group getGroup_11_1() { return cGroup_11_1; }
		
		//contracts+=[Contract|QPREF]?
		public Assignment getContractsAssignment_11_1_0() { return cContractsAssignment_11_1_0; }
		
		//[Contract|QPREF]
		public CrossReference getContractsContractCrossReference_11_1_0_0() { return cContractsContractCrossReference_11_1_0_0; }
		
		//QPREF
		public RuleCall getContractsContractQPREFParserRuleCall_11_1_0_0_1() { return cContractsContractQPREFParserRuleCall_11_1_0_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_11_1_1() { return cSemicolonKeyword_11_1_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_12() { return cRightCurlyBracketKeyword_12; }
	}
	public class ClaimsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Claims");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cClaimsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cClaimsSourceParserRuleCall_0_0 = (RuleCall)cClaimsAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//fragment Claims*:
		//    (claims+=Source? ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(claims+=Source? ';')*
		public Group getGroup() { return cGroup; }
		
		//claims+=Source?
		public Assignment getClaimsAssignment_0() { return cClaimsAssignment_0; }
		
		//Source
		public RuleCall getClaimsSourceParserRuleCall_0_0() { return cClaimsSourceParserRuleCall_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class QueryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Query");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSingleValDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cTupleDeclarationAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cValKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cNamesAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cNamesTupleNameParserRuleCall_1_3_0 = (RuleCall)cNamesAssignment_1_3.eContents().get(0);
		private final Group cGroup_1_4 = (Group)cGroup_1.eContents().get(4);
		private final Keyword cCommaKeyword_1_4_0 = (Keyword)cGroup_1_4.eContents().get(0);
		private final Assignment cNamesAssignment_1_4_1 = (Assignment)cGroup_1_4.eContents().get(1);
		private final RuleCall cNamesTupleNameParserRuleCall_1_4_1_0 = (RuleCall)cNamesAssignment_1_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_5 = (Keyword)cGroup_1.eContents().get(5);
		private final Keyword cEqualsSignKeyword_1_6 = (Keyword)cGroup_1.eContents().get(6);
		private final Assignment cValueAssignment_1_7 = (Assignment)cGroup_1.eContents().get(7);
		private final RuleCall cValueExpressionParserRuleCall_1_7_0 = (RuleCall)cValueAssignment_1_7.eContents().get(0);
		
		//Query:
		//    SingleValDeclaration |
		//    {TupleDeclaration} 'val' '(' names+=TupleName (',' names+=TupleName)+ ')' '=' value=Expression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//SingleValDeclaration |
		//{TupleDeclaration} 'val' '(' names+=TupleName (',' names+=TupleName)+ ')' '=' value=Expression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//SingleValDeclaration
		public RuleCall getSingleValDeclarationParserRuleCall_0() { return cSingleValDeclarationParserRuleCall_0; }
		
		//{TupleDeclaration} 'val' '(' names+=TupleName (',' names+=TupleName)+ ')' '=' value=Expression
		public Group getGroup_1() { return cGroup_1; }
		
		//{TupleDeclaration}
		public Action getTupleDeclarationAction_1_0() { return cTupleDeclarationAction_1_0; }
		
		//'val'
		public Keyword getValKeyword_1_1() { return cValKeyword_1_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_2() { return cLeftParenthesisKeyword_1_2; }
		
		//names+=TupleName
		public Assignment getNamesAssignment_1_3() { return cNamesAssignment_1_3; }
		
		//TupleName
		public RuleCall getNamesTupleNameParserRuleCall_1_3_0() { return cNamesTupleNameParserRuleCall_1_3_0; }
		
		//(',' names+=TupleName)+
		public Group getGroup_1_4() { return cGroup_1_4; }
		
		//','
		public Keyword getCommaKeyword_1_4_0() { return cCommaKeyword_1_4_0; }
		
		//names+=TupleName
		public Assignment getNamesAssignment_1_4_1() { return cNamesAssignment_1_4_1; }
		
		//TupleName
		public RuleCall getNamesTupleNameParserRuleCall_1_4_1_0() { return cNamesTupleNameParserRuleCall_1_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_5() { return cRightParenthesisKeyword_1_5; }
		
		//'='
		public Keyword getEqualsSignKeyword_1_6() { return cEqualsSignKeyword_1_6; }
		
		//value=Expression
		public Assignment getValueAssignment_1_7() { return cValueAssignment_1_7; }
		
		//Expression
		public RuleCall getValueExpressionParserRuleCall_1_7_0() { return cValueExpressionParserRuleCall_1_7_0; }
	}
	public class SingleValDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.SingleValDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cValKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueExpressionParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		
		//SingleValDeclaration:
		//    'val' name=ID '=' value=Expression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'val' name=ID '=' value=Expression
		public Group getGroup() { return cGroup; }
		
		//'val'
		public Keyword getValKeyword_0() { return cValKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//value=Expression
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }
		
		//Expression
		public RuleCall getValueExpressionParserRuleCall_3_0() { return cValueExpressionParserRuleCall_3_0; }
	}
	public class TupleNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.TupleName");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//TupleName:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Expression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cOrExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cVerticalLineVerticalLineKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightAndExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Expression:
		//    AndExpression ({OrExpression.left=current} '||' right=AndExpression)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AndExpression ({OrExpression.left=current} '||' right=AndExpression)*
		public Group getGroup() { return cGroup; }
		
		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_0() { return cAndExpressionParserRuleCall_0; }
		
		//({OrExpression.left=current} '||' right=AndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{OrExpression.left=current}
		public Action getOrExpressionLeftAction_1_0() { return cOrExpressionLeftAction_1_0; }
		
		//'||'
		public Keyword getVerticalLineVerticalLineKeyword_1_1() { return cVerticalLineVerticalLineKeyword_1_1; }
		
		//right=AndExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//AndExpression
		public RuleCall getRightAndExpressionParserRuleCall_1_2_0() { return cRightAndExpressionParserRuleCall_1_2_0; }
	}
	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNotExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAndExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAmpersandAmpersandKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightNotExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//AndExpression returns Expression:
		//    NotExpression ({AndExpression.left=current} '&&' right=NotExpression)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//NotExpression ({AndExpression.left=current} '&&' right=NotExpression)*
		public Group getGroup() { return cGroup; }
		
		//NotExpression
		public RuleCall getNotExpressionParserRuleCall_0() { return cNotExpressionParserRuleCall_0; }
		
		//({AndExpression.left=current} '&&' right=NotExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{AndExpression.left=current}
		public Action getAndExpressionLeftAction_1_0() { return cAndExpressionLeftAction_1_0; }
		
		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1_1() { return cAmpersandAmpersandKeyword_1_1; }
		
		//right=NotExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//NotExpression
		public RuleCall getRightNotExpressionParserRuleCall_1_2_0() { return cRightNotExpressionParserRuleCall_1_2_0; }
	}
	public class NotExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.NotExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCallExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cNotExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cExclamationMarkKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandCallExpressionParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		
		//NotExpression returns Expression:
		//    CallExpression | {NotExpression} '!' operand=CallExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//CallExpression | {NotExpression} '!' operand=CallExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//CallExpression
		public RuleCall getCallExpressionParserRuleCall_0() { return cCallExpressionParserRuleCall_0; }
		
		//{NotExpression} '!' operand=CallExpression
		public Group getGroup_1() { return cGroup_1; }
		
		//{NotExpression}
		public Action getNotExpressionAction_1_0() { return cNotExpressionAction_1_0; }
		
		//'!'
		public Keyword getExclamationMarkKeyword_1_1() { return cExclamationMarkKeyword_1_1; }
		
		//operand=CallExpression
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//CallExpression
		public RuleCall getOperandCallExpressionParserRuleCall_1_2_0() { return cOperandCallExpressionParserRuleCall_1_2_0; }
	}
	public class CallExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.CallExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cTerminalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Action cMemberCallLeftAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRightAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRightIDTerminalRuleCall_1_0_2_0 = (RuleCall)cRightAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_0_3 = (Group)cGroup_1_0.eContents().get(3);
		private final Keyword cLessThanSignKeyword_1_0_3_0 = (Keyword)cGroup_1_0_3.eContents().get(0);
		private final Assignment cTypeArgumentAssignment_1_0_3_1 = (Assignment)cGroup_1_0_3.eContents().get(1);
		private final RuleCall cTypeArgumentIDTerminalRuleCall_1_0_3_1_0 = (RuleCall)cTypeArgumentAssignment_1_0_3_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_0_3_2 = (Keyword)cGroup_1_0_3.eContents().get(2);
		private final Group cGroup_1_0_4 = (Group)cGroup_1_0.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_1_0_4_0 = (Keyword)cGroup_1_0_4.eContents().get(0);
		private final Assignment cArgumentAssignment_1_0_4_1 = (Assignment)cGroup_1_0_4.eContents().get(1);
		private final RuleCall cArgumentExpressionParserRuleCall_1_0_4_1_0 = (RuleCall)cArgumentAssignment_1_0_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_0_4_2 = (Keyword)cGroup_1_0_4.eContents().get(2);
		private final Assignment cLambdaAssignment_1_0_5 = (Assignment)cGroup_1_0.eContents().get(5);
		private final RuleCall cLambdaLambdaParserRuleCall_1_0_5_0 = (RuleCall)cLambdaAssignment_1_0_5.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cPropertyLookupLeftAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final Keyword cNumberSignKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Assignment cRightAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final CrossReference cRightAttributeDefinitionCrossReference_1_1_2_0 = (CrossReference)cRightAssignment_1_1_2.eContents().get(0);
		private final RuleCall cRightAttributeDefinitionQPREFParserRuleCall_1_1_2_0_1 = (RuleCall)cRightAttributeDefinitionCrossReference_1_1_2_0.eContents().get(1);
		
		//CallExpression returns Expression:
		//    TerminalExpression (
		//        {MemberCall.left=current} '.' right=ID ('<' typeArgument=ID '>')? ('(' argument=Expression ')')? lambda=Lambda? |
		////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
		//        {PropertyLookup.left=current} '#' right=[sysmlv2::AttributeDefinition|QPREF]
		//    )*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//    TerminalExpression (
		//        {MemberCall.left=current} '.' right=ID ('<' typeArgument=ID '>')? ('(' argument=Expression ')')? lambda=Lambda? |
		////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
		//        {PropertyLookup.left=current} '#' right=[sysmlv2::AttributeDefinition|QPREF]
		//    )*
		public Group getGroup() { return cGroup; }
		
		//TerminalExpression
		public RuleCall getTerminalExpressionParserRuleCall_0() { return cTerminalExpressionParserRuleCall_0; }
		
		// (
		//        {MemberCall.left=current} '.' right=ID ('<' typeArgument=ID '>')? ('(' argument=Expression ')')? lambda=Lambda? |
		////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
		//        {PropertyLookup.left=current} '#' right=[sysmlv2::AttributeDefinition|QPREF]
		//    )*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//{MemberCall.left=current} '.' right=ID ('<' typeArgument=ID '>')? ('(' argument=Expression ')')? lambda=Lambda?
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{MemberCall.left=current}
		public Action getMemberCallLeftAction_1_0_0() { return cMemberCallLeftAction_1_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0_1() { return cFullStopKeyword_1_0_1; }
		
		//right=ID
		public Assignment getRightAssignment_1_0_2() { return cRightAssignment_1_0_2; }
		
		//ID
		public RuleCall getRightIDTerminalRuleCall_1_0_2_0() { return cRightIDTerminalRuleCall_1_0_2_0; }
		
		//('<' typeArgument=ID '>')?
		public Group getGroup_1_0_3() { return cGroup_1_0_3; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0_3_0() { return cLessThanSignKeyword_1_0_3_0; }
		
		//typeArgument=ID
		public Assignment getTypeArgumentAssignment_1_0_3_1() { return cTypeArgumentAssignment_1_0_3_1; }
		
		//ID
		public RuleCall getTypeArgumentIDTerminalRuleCall_1_0_3_1_0() { return cTypeArgumentIDTerminalRuleCall_1_0_3_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_0_3_2() { return cGreaterThanSignKeyword_1_0_3_2; }
		
		//('(' argument=Expression ')')?
		public Group getGroup_1_0_4() { return cGroup_1_0_4; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_0_4_0() { return cLeftParenthesisKeyword_1_0_4_0; }
		
		//argument=Expression
		public Assignment getArgumentAssignment_1_0_4_1() { return cArgumentAssignment_1_0_4_1; }
		
		//Expression
		public RuleCall getArgumentExpressionParserRuleCall_1_0_4_1_0() { return cArgumentExpressionParserRuleCall_1_0_4_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_0_4_2() { return cRightParenthesisKeyword_1_0_4_2; }
		
		//lambda=Lambda?
		public Assignment getLambdaAssignment_1_0_5() { return cLambdaAssignment_1_0_5; }
		
		//Lambda
		public RuleCall getLambdaLambdaParserRuleCall_1_0_5_0() { return cLambdaLambdaParserRuleCall_1_0_5_0; }
		
		////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
		//        {PropertyLookup.left=current} '#' right=[sysmlv2::AttributeDefinition|QPREF]
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
		//        {PropertyLookup.left=current}
		public Action getPropertyLookupLeftAction_1_1_0() { return cPropertyLookupLeftAction_1_1_0; }
		
		//'#'
		public Keyword getNumberSignKeyword_1_1_1() { return cNumberSignKeyword_1_1_1; }
		
		//right=[sysmlv2::AttributeDefinition|QPREF]
		public Assignment getRightAssignment_1_1_2() { return cRightAssignment_1_1_2; }
		
		//[sysmlv2::AttributeDefinition|QPREF]
		public CrossReference getRightAttributeDefinitionCrossReference_1_1_2_0() { return cRightAttributeDefinitionCrossReference_1_1_2_0; }
		
		//QPREF
		public RuleCall getRightAttributeDefinitionQPREFParserRuleCall_1_1_2_0_1() { return cRightAttributeDefinitionQPREFParserRuleCall_1_1_2_0_1; }
	}
	public class LambdaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Lambda");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cParameterAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParameterParameterParserRuleCall_1_0 = (RuleCall)cParameterAssignment_1.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cQueriesParserRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Assignment cReturnValueAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cReturnValueExpressionParserRuleCall_4_0 = (RuleCall)cReturnValueAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//Lambda:
		//    '{' parameter=Parameter '->' Queries returnValue=Expression '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'{' parameter=Parameter '->' Queries returnValue=Expression '}'
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//parameter=Parameter
		public Assignment getParameterAssignment_1() { return cParameterAssignment_1; }
		
		//Parameter
		public RuleCall getParameterParameterParserRuleCall_1_0() { return cParameterParameterParserRuleCall_1_0; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//Queries
		public RuleCall getQueriesParserRuleCall_3() { return cQueriesParserRuleCall_3; }
		
		//returnValue=Expression
		public Assignment getReturnValueAssignment_4() { return cReturnValueAssignment_4; }
		
		//Expression
		public RuleCall getReturnValueExpressionParserRuleCall_4_0() { return cReturnValueExpressionParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Parameter");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSingleParameterParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cTupleParameterAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cNamesAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cNamesTupleNameParserRuleCall_1_2_0 = (RuleCall)cNamesAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cCommaKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cNamesAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cNamesTupleNameParserRuleCall_1_3_1_0 = (RuleCall)cNamesAssignment_1_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		
		//Parameter:
		//    SingleParameter |
		//    {TupleParameter} '(' names+=TupleName (',' names+=TupleName)+ ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//SingleParameter |
		//{TupleParameter} '(' names+=TupleName (',' names+=TupleName)+ ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//SingleParameter
		public RuleCall getSingleParameterParserRuleCall_0() { return cSingleParameterParserRuleCall_0; }
		
		//{TupleParameter} '(' names+=TupleName (',' names+=TupleName)+ ')'
		public Group getGroup_1() { return cGroup_1; }
		
		//{TupleParameter}
		public Action getTupleParameterAction_1_0() { return cTupleParameterAction_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_1() { return cLeftParenthesisKeyword_1_1; }
		
		//names+=TupleName
		public Assignment getNamesAssignment_1_2() { return cNamesAssignment_1_2; }
		
		//TupleName
		public RuleCall getNamesTupleNameParserRuleCall_1_2_0() { return cNamesTupleNameParserRuleCall_1_2_0; }
		
		//(',' names+=TupleName)+
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//','
		public Keyword getCommaKeyword_1_3_0() { return cCommaKeyword_1_3_0; }
		
		//names+=TupleName
		public Assignment getNamesAssignment_1_3_1() { return cNamesAssignment_1_3_1; }
		
		//TupleName
		public RuleCall getNamesTupleNameParserRuleCall_1_3_1_0() { return cNamesTupleNameParserRuleCall_1_3_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_4() { return cRightParenthesisKeyword_1_4; }
	}
	public class SingleParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.SingleParameter");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//SingleParameter:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class TerminalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.TerminalExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cSelfExpressionAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cSelfKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cRootExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cRootKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cStringLiteralAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Assignment cValueAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cValueAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cNameReferenceAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Assignment cReferenceAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cReferenceElementCrossReference_3_1_0 = (CrossReference)cReferenceAssignment_3_1.eContents().get(0);
		private final RuleCall cReferenceElementIDTerminalRuleCall_3_1_0_1 = (RuleCall)cReferenceElementCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Action cTupleExpressionElementsAction_4_2_0 = (Action)cGroup_4_2.eContents().get(0);
		private final Group cGroup_4_2_1 = (Group)cGroup_4_2.eContents().get(1);
		private final Keyword cCommaKeyword_4_2_1_0 = (Keyword)cGroup_4_2_1.eContents().get(0);
		private final Assignment cElementsAssignment_4_2_1_1 = (Assignment)cGroup_4_2_1.eContents().get(1);
		private final RuleCall cElementsExpressionParserRuleCall_4_2_1_1_0 = (RuleCall)cElementsAssignment_4_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		
		//TerminalExpression returns Expression:
		//    {SelfExpression} 'self' |
		//    {RootExpression} 'root' |
		//    {StringLiteral} value=STRING |
		////    {NameReference} reference=[aadl2::NamedElement] |
		//    {NameReference} reference=[sysmlv2::Element] |
		//    /*
		//     * Handles both parentheses and tuples. Combining these is necessary to avoid a left recursion problem. The
		//     * following doesn't work:
		//     *
		//     * {TupleExpression} '(' elements+=Expression (',' elements+=Expression)+ ')' |
		//     * '(' Expression ')'
		//     */
		//    '(' Expression ({TupleExpression.elements+=current} (',' elements+=Expression)+)? ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//    {SelfExpression} 'self' |
		//    {RootExpression} 'root' |
		//    {StringLiteral} value=STRING |
		////    {NameReference} reference=[aadl2::NamedElement] |
		//    {NameReference} reference=[sysmlv2::Element] |
		//    /*
		//     * Handles both parentheses and tuples. Combining these is necessary to avoid a left recursion problem. The
		//     * following doesn't work:
		//     *
		//     * {TupleExpression} '(' elements+=Expression (',' elements+=Expression)+ ')' |
		//     * '(' Expression ')'
		//     */
		//    '(' Expression ({TupleExpression.elements+=current} (',' elements+=Expression)+)? ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{SelfExpression} 'self'
		public Group getGroup_0() { return cGroup_0; }
		
		//{SelfExpression}
		public Action getSelfExpressionAction_0_0() { return cSelfExpressionAction_0_0; }
		
		//'self'
		public Keyword getSelfKeyword_0_1() { return cSelfKeyword_0_1; }
		
		//{RootExpression} 'root'
		public Group getGroup_1() { return cGroup_1; }
		
		//{RootExpression}
		public Action getRootExpressionAction_1_0() { return cRootExpressionAction_1_0; }
		
		//'root'
		public Keyword getRootKeyword_1_1() { return cRootKeyword_1_1; }
		
		//{StringLiteral} value=STRING
		public Group getGroup_2() { return cGroup_2; }
		
		//{StringLiteral}
		public Action getStringLiteralAction_2_0() { return cStringLiteralAction_2_0; }
		
		//value=STRING
		public Assignment getValueAssignment_2_1() { return cValueAssignment_2_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_1_0() { return cValueSTRINGTerminalRuleCall_2_1_0; }
		
		////    {NameReference} reference=[aadl2::NamedElement] |
		//    {NameReference} reference=[sysmlv2::Element]
		public Group getGroup_3() { return cGroup_3; }
		
		////    {NameReference} reference=[aadl2::NamedElement] |
		//    {NameReference}
		public Action getNameReferenceAction_3_0() { return cNameReferenceAction_3_0; }
		
		//reference=[sysmlv2::Element]
		public Assignment getReferenceAssignment_3_1() { return cReferenceAssignment_3_1; }
		
		//[sysmlv2::Element]
		public CrossReference getReferenceElementCrossReference_3_1_0() { return cReferenceElementCrossReference_3_1_0; }
		
		//ID
		public RuleCall getReferenceElementIDTerminalRuleCall_3_1_0_1() { return cReferenceElementIDTerminalRuleCall_3_1_0_1; }
		
		///*
		// * Handles both parentheses and tuples. Combining these is necessary to avoid a left recursion problem. The
		// * following doesn't work:
		// *
		// * {TupleExpression} '(' elements+=Expression (',' elements+=Expression)+ ')' |
		// * '(' Expression ')'
		// */
		//'(' Expression ({TupleExpression.elements+=current} (',' elements+=Expression)+)? ')'
		public Group getGroup_4() { return cGroup_4; }
		
		///*
		// * Handles both parentheses and tuples. Combining these is necessary to avoid a left recursion problem. The
		// * following doesn't work:
		// *
		// * {TupleExpression} '(' elements+=Expression (',' elements+=Expression)+ ')' |
		// * '(' Expression ')'
		// */
		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_4_1() { return cExpressionParserRuleCall_4_1; }
		
		//({TupleExpression.elements+=current} (',' elements+=Expression)+)?
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//{TupleExpression.elements+=current}
		public Action getTupleExpressionElementsAction_4_2_0() { return cTupleExpressionElementsAction_4_2_0; }
		
		//(',' elements+=Expression)+
		public Group getGroup_4_2_1() { return cGroup_4_2_1; }
		
		//','
		public Keyword getCommaKeyword_4_2_1_0() { return cCommaKeyword_4_2_1_0; }
		
		//elements+=Expression
		public Assignment getElementsAssignment_4_2_1_1() { return cElementsAssignment_4_2_1_1; }
		
		//Expression
		public RuleCall getElementsExpressionParserRuleCall_4_2_1_1_0() { return cElementsExpressionParserRuleCall_4_2_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }
	}
	public class ContractSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ContractSubclause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cContractSubclauseAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cUseKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cUseQueriesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cUseQueriesContractCrossReference_1_1_0 = (CrossReference)cUseQueriesAssignment_1_1.eContents().get(0);
		private final RuleCall cUseQueriesContractQPREFParserRuleCall_1_1_0_1 = (RuleCall)cUseQueriesContractCrossReference_1_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cVerifyKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cVerifyPlansAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cVerifyPlansVerificationPlanCrossReference_2_1_0 = (CrossReference)cVerifyPlansAssignment_2_1.eContents().get(0);
		private final RuleCall cVerifyPlansVerificationPlanQPREFParserRuleCall_2_1_0_1 = (RuleCall)cVerifyPlansVerificationPlanCrossReference_2_1_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//ContractSubclause:
		//    {ContractSubclause} ('use' useQueries+=[Contract|QPREF])*
		//    ('verify' verifyPlans+=[VerificationPlan|QPREF] ';')*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ContractSubclause} ('use' useQueries+=[Contract|QPREF])*
		//('verify' verifyPlans+=[VerificationPlan|QPREF] ';')*
		public Group getGroup() { return cGroup; }
		
		//{ContractSubclause}
		public Action getContractSubclauseAction_0() { return cContractSubclauseAction_0; }
		
		//('use' useQueries+=[Contract|QPREF])*
		public Group getGroup_1() { return cGroup_1; }
		
		//'use'
		public Keyword getUseKeyword_1_0() { return cUseKeyword_1_0; }
		
		//useQueries+=[Contract|QPREF]
		public Assignment getUseQueriesAssignment_1_1() { return cUseQueriesAssignment_1_1; }
		
		//[Contract|QPREF]
		public CrossReference getUseQueriesContractCrossReference_1_1_0() { return cUseQueriesContractCrossReference_1_1_0; }
		
		//QPREF
		public RuleCall getUseQueriesContractQPREFParserRuleCall_1_1_0_1() { return cUseQueriesContractQPREFParserRuleCall_1_1_0_1; }
		
		//('verify' verifyPlans+=[VerificationPlan|QPREF] ';')*
		public Group getGroup_2() { return cGroup_2; }
		
		//'verify'
		public Keyword getVerifyKeyword_2_0() { return cVerifyKeyword_2_0; }
		
		//verifyPlans+=[VerificationPlan|QPREF]
		public Assignment getVerifyPlansAssignment_2_1() { return cVerifyPlansAssignment_2_1; }
		
		//[VerificationPlan|QPREF]
		public CrossReference getVerifyPlansVerificationPlanCrossReference_2_1_0() { return cVerifyPlansVerificationPlanCrossReference_2_1_0; }
		
		//QPREF
		public RuleCall getVerifyPlansVerificationPlanQPREFParserRuleCall_2_1_0_1() { return cVerifyPlansVerificationPlanQPREFParserRuleCall_2_1_0_1; }
		
		//';'
		public Keyword getSemicolonKeyword_2_2() { return cSemicolonKeyword_2_2; }
	}
	public class IStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cPartsAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cPartsIStringLiteralParserRuleCall_0_0 = (RuleCall)cPartsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cPartsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cPartsIStringLeftLiteralParserRuleCall_1_0_0 = (RuleCall)cPartsAssignment_1_0.eContents().get(0);
		private final Assignment cPartsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cPartsIStringInterParserRuleCall_1_1_0 = (RuleCall)cPartsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Assignment cPartsAssignment_1_2_0 = (Assignment)cGroup_1_2.eContents().get(0);
		private final RuleCall cPartsIStringMiddleLiteralParserRuleCall_1_2_0_0 = (RuleCall)cPartsAssignment_1_2_0.eContents().get(0);
		private final Assignment cPartsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cPartsIStringInterParserRuleCall_1_2_1_0 = (RuleCall)cPartsAssignment_1_2_1.eContents().get(0);
		private final Assignment cPartsAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final RuleCall cPartsIStringRightLiteralParserRuleCall_1_3_0 = (RuleCall)cPartsAssignment_1_3.eContents().get(0);
		
		//// interpolated strings
		//IString:
		//    parts+=IStringLiteral
		//    | parts+=IStringLeftLiteral parts+=IStringInter?
		//      (parts+=IStringMiddleLiteral parts+=IStringInter?)*
		//      parts+=IStringRightLiteral
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//parts+=IStringLiteral
		//| parts+=IStringLeftLiteral parts+=IStringInter?
		//  (parts+=IStringMiddleLiteral parts+=IStringInter?)*
		//  parts+=IStringRightLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//parts+=IStringLiteral
		public Assignment getPartsAssignment_0() { return cPartsAssignment_0; }
		
		//IStringLiteral
		public RuleCall getPartsIStringLiteralParserRuleCall_0_0() { return cPartsIStringLiteralParserRuleCall_0_0; }
		
		//parts+=IStringLeftLiteral parts+=IStringInter?
		//     (parts+=IStringMiddleLiteral parts+=IStringInter?)*
		//     parts+=IStringRightLiteral
		public Group getGroup_1() { return cGroup_1; }
		
		//parts+=IStringLeftLiteral
		public Assignment getPartsAssignment_1_0() { return cPartsAssignment_1_0; }
		
		//IStringLeftLiteral
		public RuleCall getPartsIStringLeftLiteralParserRuleCall_1_0_0() { return cPartsIStringLeftLiteralParserRuleCall_1_0_0; }
		
		//parts+=IStringInter?
		public Assignment getPartsAssignment_1_1() { return cPartsAssignment_1_1; }
		
		//IStringInter
		public RuleCall getPartsIStringInterParserRuleCall_1_1_0() { return cPartsIStringInterParserRuleCall_1_1_0; }
		
		//(parts+=IStringMiddleLiteral parts+=IStringInter?)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//parts+=IStringMiddleLiteral
		public Assignment getPartsAssignment_1_2_0() { return cPartsAssignment_1_2_0; }
		
		//IStringMiddleLiteral
		public RuleCall getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0() { return cPartsIStringMiddleLiteralParserRuleCall_1_2_0_0; }
		
		//parts+=IStringInter?
		public Assignment getPartsAssignment_1_2_1() { return cPartsAssignment_1_2_1; }
		
		//IStringInter
		public RuleCall getPartsIStringInterParserRuleCall_1_2_1_0() { return cPartsIStringInterParserRuleCall_1_2_1_0; }
		
		//parts+=IStringRightLiteral
		public Assignment getPartsAssignment_1_3() { return cPartsAssignment_1_3; }
		
		//IStringRightLiteral
		public RuleCall getPartsIStringRightLiteralParserRuleCall_1_3_0() { return cPartsIStringRightLiteralParserRuleCall_1_3_0; }
	}
	public class IStringPartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringPart");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIStringLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIStringInterParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//IStringPart:
		//    IStringLiteral | IStringInter
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//IStringLiteral | IStringInter
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//IStringLiteral
		public RuleCall getIStringLiteralParserRuleCall_0() { return cIStringLiteralParserRuleCall_0; }
		
		//IStringInter
		public RuleCall getIStringInterParserRuleCall_1() { return cIStringInterParserRuleCall_1; }
	}
	public class IStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueISTRING_TEXTTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//IStringLiteral:
		//    value=ISTRING_TEXT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ISTRING_TEXT
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//ISTRING_TEXT
		public RuleCall getValueISTRING_TEXTTerminalRuleCall_0() { return cValueISTRING_TEXTTerminalRuleCall_0; }
	}
	public class IStringLeftLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringLeftLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueISTRING_LEFTTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//IStringLeftLiteral returns IStringLiteral:
		//    value=ISTRING_LEFT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ISTRING_LEFT
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//ISTRING_LEFT
		public RuleCall getValueISTRING_LEFTTerminalRuleCall_0() { return cValueISTRING_LEFTTerminalRuleCall_0; }
	}
	public class IStringMiddleLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringMiddleLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueISTRING_MIDDLETerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//IStringMiddleLiteral returns IStringLiteral:
		//    value=ISTRING_MIDDLE
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ISTRING_MIDDLE
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//ISTRING_MIDDLE
		public RuleCall getValueISTRING_MIDDLETerminalRuleCall_0() { return cValueISTRING_MIDDLETerminalRuleCall_0; }
	}
	public class IStringRightLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringRightLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueISTRING_RIGHTTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//IStringRightLiteral returns IStringLiteral:
		//    value=ISTRING_RIGHT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ISTRING_RIGHT
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//ISTRING_RIGHT
		public RuleCall getValueISTRING_RIGHTTerminalRuleCall_0() { return cValueISTRING_RIGHTTerminalRuleCall_0; }
	}
	public class IStringInterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IStringInter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cDirectAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cDirectColonKeyword_0_0 = (Keyword)cDirectAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Assignment cDomainAssignment_1_0_0_0 = (Assignment)cGroup_1_0_0.eContents().get(0);
		private final CrossReference cDomainDomainCrossReference_1_0_0_0_0 = (CrossReference)cDomainAssignment_1_0_0_0.eContents().get(0);
		private final RuleCall cDomainDomainIDTerminalRuleCall_1_0_0_0_0_1 = (RuleCall)cDomainDomainCrossReference_1_0_0_0_0.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cQueryAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final CrossReference cQuerySingleValDeclarationCrossReference_1_0_1_0 = (CrossReference)cQueryAssignment_1_0_1.eContents().get(0);
		private final RuleCall cQuerySingleValDeclarationIDTerminalRuleCall_1_0_1_0_1 = (RuleCall)cQuerySingleValDeclarationCrossReference_1_0_1_0.eContents().get(1);
		private final Assignment cPredefinedAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final RuleCall cPredefinedPredefinedEnumRuleCall_1_1_0 = (RuleCall)cPredefinedAssignment_1_1.eContents().get(0);
		
		//IStringInter returns IStringVar:
		//    direct?=":"?
		//    (
		//      ((domain=[Domain|ID] '::')? query=([SingleValDeclaration|ID]))
		//    | predefined=Predefined
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//direct?=":"?
		//(
		//  ((domain=[Domain|ID] '::')? query=([SingleValDeclaration|ID]))
		//| predefined=Predefined
		//)
		public Group getGroup() { return cGroup; }
		
		//direct?=":"?
		public Assignment getDirectAssignment_0() { return cDirectAssignment_0; }
		
		//":"
		public Keyword getDirectColonKeyword_0_0() { return cDirectColonKeyword_0_0; }
		
		//(
		//  ((domain=[Domain|ID] '::')? query=([SingleValDeclaration|ID]))
		//| predefined=Predefined
		//)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//((domain=[Domain|ID] '::')? query=([SingleValDeclaration|ID]))
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//(domain=[Domain|ID] '::')?
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//domain=[Domain|ID]
		public Assignment getDomainAssignment_1_0_0_0() { return cDomainAssignment_1_0_0_0; }
		
		//[Domain|ID]
		public CrossReference getDomainDomainCrossReference_1_0_0_0_0() { return cDomainDomainCrossReference_1_0_0_0_0; }
		
		//ID
		public RuleCall getDomainDomainIDTerminalRuleCall_1_0_0_0_0_1() { return cDomainDomainIDTerminalRuleCall_1_0_0_0_0_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0_0_1() { return cColonColonKeyword_1_0_0_1; }
		
		//query=([SingleValDeclaration|ID])
		public Assignment getQueryAssignment_1_0_1() { return cQueryAssignment_1_0_1; }
		
		//([SingleValDeclaration|ID])
		public CrossReference getQuerySingleValDeclarationCrossReference_1_0_1_0() { return cQuerySingleValDeclarationCrossReference_1_0_1_0; }
		
		//ID
		public RuleCall getQuerySingleValDeclarationIDTerminalRuleCall_1_0_1_0_1() { return cQuerySingleValDeclarationIDTerminalRuleCall_1_0_1_0_1; }
		
		//predefined=Predefined
		public Assignment getPredefinedAssignment_1_1() { return cPredefinedAssignment_1_1; }
		
		//Predefined
		public RuleCall getPredefinedPredefinedEnumRuleCall_1_1_0() { return cPredefinedPredefinedEnumRuleCall_1_1_0; }
	}
	public class OptionalQualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.OptionalQualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//OptionalQualifiedName:
		//    (ID '::')? ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(ID '::')? ID
		public Group getGroup() { return cGroup; }
		
		//(ID '::')?
		public Group getGroup_0() { return cGroup_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }
		
		//'::'
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}
	public class QPREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.QPREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QPREF:
		//    ID ('::' ID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('::' ID)?
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('::' ID)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class QCREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.QCREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		
		//QCREF:
		//    (ID '::')* ID ('.' ID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//(ID '::')* ID ('.' ID)?
		public Group getGroup() { return cGroup; }
		
		//(ID '::')*
		public Group getGroup_0() { return cGroup_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }
		
		//'::'
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
		
		//('.' ID)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'.'
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}
	public class STARElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.STAR");
		private final Keyword cAsteriskKeyword = (Keyword)rule.eContents().get(1);
		
		//STAR : '*';
		@Override public ParserRule getRule() { return rule; }
		
		//'*'
		public Keyword getAsteriskKeyword() { return cAsteriskKeyword; }
	}
	
	public class LanguageElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Language");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPYTHONEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPYTHONPythonKeyword_0_0 = (Keyword)cPYTHONEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cJAVAEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cJAVAJavaKeyword_1_0 = (Keyword)cJAVAEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cSMTEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cSMTSmtKeyword_2_0 = (Keyword)cSMTEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum Language:
		//    PYTHON='python' | JAVA='java' | SMT='smt'
		//;
		public EnumRule getRule() { return rule; }
		
		//PYTHON='python' | JAVA='java' | SMT='smt'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//PYTHON='python'
		public EnumLiteralDeclaration getPYTHONEnumLiteralDeclaration_0() { return cPYTHONEnumLiteralDeclaration_0; }
		
		//'python'
		public Keyword getPYTHONPythonKeyword_0_0() { return cPYTHONPythonKeyword_0_0; }
		
		//JAVA='java'
		public EnumLiteralDeclaration getJAVAEnumLiteralDeclaration_1() { return cJAVAEnumLiteralDeclaration_1; }
		
		//'java'
		public Keyword getJAVAJavaKeyword_1_0() { return cJAVAJavaKeyword_1_0; }
		
		//SMT='smt'
		public EnumLiteralDeclaration getSMTEnumLiteralDeclaration_2() { return cSMTEnumLiteralDeclaration_2; }
		
		//'smt'
		public Keyword getSMTSmtKeyword_2_0() { return cSMTSmtKeyword_2_0; }
	}
	public class PredefinedElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.Predefined");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cERRORError0Keyword_0_0 = (Keyword)cERROREnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cINFOEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cINFOInfo0Keyword_1_0 = (Keyword)cINFOEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum Predefined:
		//    ERROR='error0' | INFO='info0'
		//;
		public EnumRule getRule() { return rule; }
		
		//ERROR='error0' | INFO='info0'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ERROR='error0'
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_0() { return cERROREnumLiteralDeclaration_0; }
		
		//'error0'
		public Keyword getERRORError0Keyword_0_0() { return cERRORError0Keyword_0_0; }
		
		//INFO='info0'
		public EnumLiteralDeclaration getINFOEnumLiteralDeclaration_1() { return cINFOEnumLiteralDeclaration_1; }
		
		//'info0'
		public Keyword getINFOInfo0Keyword_1_0() { return cINFOInfo0Keyword_1_0; }
	}
	
	private final ContractLibraryElements pContractLibrary;
	private final NamedElementElements pNamedElement;
	private final ContractElementElements pContractElement;
	private final ContractElements pContract;
	private final ExactElements pExact;
	private final QueriesElements pQueries;
	private final DomainsElements pDomains;
	private final AssumptionsElements pAssumptions;
	private final AnalysesElements pAnalyses;
	private final InputAssumptionElements pInputAssumption;
	private final AssumptionElementElements pAssumptionElement;
	private final GuaranteeElements pGuarantee;
	private final AnalysisElements pAnalysis;
	private final SourceElements pSource;
	private final ImplementationElements pImplementation;
	private final DomainElements pDomain;
	private final ArgumentElements pArgument;
	private final ArgumentExpressionElements pArgumentExpression;
	private final ArgumentAndElements pArgumentAnd;
	private final ArgumentOrElements pArgumentOr;
	private final ArgumentNotElements pArgumentNot;
	private final ArgumentTermElements pArgumentTerm;
	private final VerificationPlanElements pVerificationPlan;
	private final ClaimsElements pClaims;
	private final LanguageElements eLanguage;
	private final QueryElements pQuery;
	private final SingleValDeclarationElements pSingleValDeclaration;
	private final TupleNameElements pTupleName;
	private final ExpressionElements pExpression;
	private final AndExpressionElements pAndExpression;
	private final NotExpressionElements pNotExpression;
	private final CallExpressionElements pCallExpression;
	private final LambdaElements pLambda;
	private final ParameterElements pParameter;
	private final SingleParameterElements pSingleParameter;
	private final TerminalExpressionElements pTerminalExpression;
	private final ContractSubclauseElements pContractSubclause;
	private final IStringElements pIString;
	private final IStringPartElements pIStringPart;
	private final IStringLiteralElements pIStringLiteral;
	private final IStringLeftLiteralElements pIStringLeftLiteral;
	private final IStringMiddleLiteralElements pIStringMiddleLiteral;
	private final IStringRightLiteralElements pIStringRightLiteral;
	private final PredefinedElements ePredefined;
	private final IStringInterElements pIStringInter;
	private final TerminalRule tISTRING_TEXT;
	private final TerminalRule tISTRING_LEFT;
	private final TerminalRule tISTRING_MIDDLE;
	private final TerminalRule tISTRING_RIGHT;
	private final TerminalRule tIN_ISTRING;
	private final OptionalQualifiedNameElements pOptionalQualifiedName;
	private final TerminalRule tSSTRING;
	private final TerminalRule tSL_COMMENT;
	private final QPREFElements pQPREF;
	private final QCREFElements pQCREF;
	private final STARElements pSTAR;
	private final TerminalRule tSTRING;
	private final TerminalRule tID;
	
	private final Grammar grammar;

	@Inject
	public ContractGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pContractLibrary = new ContractLibraryElements();
		this.pNamedElement = new NamedElementElements();
		this.pContractElement = new ContractElementElements();
		this.pContract = new ContractElements();
		this.pExact = new ExactElements();
		this.pQueries = new QueriesElements();
		this.pDomains = new DomainsElements();
		this.pAssumptions = new AssumptionsElements();
		this.pAnalyses = new AnalysesElements();
		this.pInputAssumption = new InputAssumptionElements();
		this.pAssumptionElement = new AssumptionElementElements();
		this.pGuarantee = new GuaranteeElements();
		this.pAnalysis = new AnalysisElements();
		this.pSource = new SourceElements();
		this.pImplementation = new ImplementationElements();
		this.pDomain = new DomainElements();
		this.pArgument = new ArgumentElements();
		this.pArgumentExpression = new ArgumentExpressionElements();
		this.pArgumentAnd = new ArgumentAndElements();
		this.pArgumentOr = new ArgumentOrElements();
		this.pArgumentNot = new ArgumentNotElements();
		this.pArgumentTerm = new ArgumentTermElements();
		this.pVerificationPlan = new VerificationPlanElements();
		this.pClaims = new ClaimsElements();
		this.eLanguage = new LanguageElements();
		this.pQuery = new QueryElements();
		this.pSingleValDeclaration = new SingleValDeclarationElements();
		this.pTupleName = new TupleNameElements();
		this.pExpression = new ExpressionElements();
		this.pAndExpression = new AndExpressionElements();
		this.pNotExpression = new NotExpressionElements();
		this.pCallExpression = new CallExpressionElements();
		this.pLambda = new LambdaElements();
		this.pParameter = new ParameterElements();
		this.pSingleParameter = new SingleParameterElements();
		this.pTerminalExpression = new TerminalExpressionElements();
		this.pContractSubclause = new ContractSubclauseElements();
		this.pIString = new IStringElements();
		this.pIStringPart = new IStringPartElements();
		this.pIStringLiteral = new IStringLiteralElements();
		this.pIStringLeftLiteral = new IStringLeftLiteralElements();
		this.pIStringMiddleLiteral = new IStringMiddleLiteralElements();
		this.pIStringRightLiteral = new IStringRightLiteralElements();
		this.ePredefined = new PredefinedElements();
		this.pIStringInter = new IStringInterElements();
		this.tISTRING_TEXT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ISTRING_TEXT");
		this.tISTRING_LEFT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ISTRING_LEFT");
		this.tISTRING_MIDDLE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ISTRING_MIDDLE");
		this.tISTRING_RIGHT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ISTRING_RIGHT");
		this.tIN_ISTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.IN_ISTRING");
		this.pOptionalQualifiedName = new OptionalQualifiedNameElements();
		this.tSSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.SSTRING");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.SL_COMMENT");
		this.pQPREF = new QPREFElements();
		this.pQCREF = new QCREFElements();
		this.pSTAR = new STARElements();
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.STRING");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.sysmlv2.contract.Contract.ID");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.sysmlv2.contract.Contract".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//ContractLibrary:
	//    'package' name = ID ';'
	//    contractElements+=ContractElement*
	//;
	public ContractLibraryElements getContractLibraryAccess() {
		return pContractLibrary;
	}
	
	public ParserRule getContractLibraryRule() {
		return getContractLibraryAccess().getRule();
	}
	
	//NamedElement returns sysmlv2::Element: // aadl2::NamedElement:
	//    ContractElement | SingleValDeclaration | TupleName | SingleParameter
	//;
	public NamedElementElements getNamedElementAccess() {
		return pNamedElement;
	}
	
	public ParserRule getNamedElementRule() {
		return getNamedElementAccess().getRule();
	}
	
	//ContractElement:
	//    Implementation | Domain | Argument | Contract | VerificationPlan
	//;
	public ContractElementElements getContractElementAccess() {
		return pContractElement;
	}
	
	public ParserRule getContractElementRule() {
		return getContractElementAccess().getRule();
	}
	
	//Contract:
	//    'contract' name=ID '{'
	//    ('domains'
	//        Domains
	//    )?
	//    ('queries'
	//        Queries
	//    )?
	//    ('input' 'assumptions'
	//        inputs+=InputAssumption*
	//    )?
	//    ('assumptions'
	//        Assumptions
	//    )?
	//    ('guarantee'
	//        Exact guarantee=Guarantee ';'
	//    )?
	//    (('invocation' | 'analysis')
	//        Analyses
	//    )?
	//    '}'
	//;
	public ContractElements getContractAccess() {
		return pContract;
	}
	
	public ParserRule getContractRule() {
		return getContractAccess().getRule();
	}
	
	//fragment Exact*:
	//    '=>'
	//    | exact?='<=>'
	//;
	public ExactElements getExactAccess() {
		return pExact;
	}
	
	public ParserRule getExactRule() {
		return getExactAccess().getRule();
	}
	
	//fragment Queries*:
	//    (queries+=Query? ';')*
	//;
	public QueriesElements getQueriesAccess() {
		return pQueries;
	}
	
	public ParserRule getQueriesRule() {
		return getQueriesAccess().getRule();
	}
	
	//fragment Domains*:
	//    (domains+=[Domain|QPREF]? ';')*
	//;
	public DomainsElements getDomainsAccess() {
		return pDomains;
	}
	
	public ParserRule getDomainsRule() {
		return getDomainsAccess().getRule();
	}
	
	//fragment Assumptions*:
	//    (assumptions+=AssumptionElement? ';')*
	//;
	public AssumptionsElements getAssumptionsAccess() {
		return pAssumptions;
	}
	
	public ParserRule getAssumptionsRule() {
		return getAssumptionsAccess().getRule();
	}
	
	//fragment Analyses*:
	//    (analyses+=Analysis? ';')*
	//;
	public AnalysesElements getAnalysesAccess() {
		return pAnalyses;
	}
	
	public ParserRule getAnalysesRule() {
		return getAnalysesAccess().getRule();
	}
	
	//InputAssumption:
	//    {InputAssumption}
	//    (code=Source)? ';'
	//;
	public InputAssumptionElements getInputAssumptionAccess() {
		return pInputAssumption;
	}
	
	public ParserRule getInputAssumptionRule() {
		return getInputAssumptionAccess().getRule();
	}
	
	//AssumptionElement:
	//    (
	//        {ContractAssumption} 'contract' contract=[ContractElement|QPREF]
	//        | {ArgumentAssumption} 'argument' argument=[ContractElement|QPREF]
	//        | {CodeAssumption} code=Source     (Exact guarantee=Guarantee)?
	//    )
	//;
	public AssumptionElementElements getAssumptionElementAccess() {
		return pAssumptionElement;
	}
	
	public ParserRule getAssumptionElementRule() {
		return getAssumptionElementAccess().getRule();
	}
	
	//Guarantee:
	//    code=Source
	//;
	public GuaranteeElements getGuaranteeAccess() {
		return pGuarantee;
	}
	
	public ParserRule getGuaranteeRule() {
		return getGuaranteeAccess().getRule();
	}
	
	//Analysis:
	//    code=Source
	//;
	public AnalysisElements getAnalysisAccess() {
		return pAnalysis;
	}
	
	public ParserRule getAnalysisRule() {
		return getAnalysisAccess().getRule();
	}
	
	//Source:
	//    (language=Language)?
	//    (source=SSTRING | inter=IString)
	//;
	public SourceElements getSourceAccess() {
		return pSource;
	}
	
	public ParserRule getSourceRule() {
		return getSourceAccess().getRule();
	}
	
	//Implementation:
	//    'contract' 'implementation' name=ID '{'
	//        code=Source
	//    '}'
	//;
	public ImplementationElements getImplementationAccess() {
		return pImplementation;
	}
	
	public ParserRule getImplementationRule() {
		return getImplementationAccess().getRule();
	}
	
	//Domain:
	//    'domain' name=ID '{'
	//    ('queries'
	//        Queries
	//    )?
	//    ('declarations'
	//        code=Source
	//    )?
	//    '}'
	//;
	public DomainElements getDomainAccess() {
		return pDomain;
	}
	
	public ParserRule getDomainRule() {
		return getDomainAccess().getRule();
	}
	
	//Argument:
	//    'argument' name=ID '{'
	//    ('domains'
	//        Domains
	//    )?
	//    ('guarantee'
	//        Exact guarantee=Guarantee ';'
	//    )?
	//    ('argument'
	//        argumentExpression=ArgumentExpression ';'
	//    )?
	//    '}'
	//;
	public ArgumentElements getArgumentAccess() {
		return pArgument;
	}
	
	public ParserRule getArgumentRule() {
		return getArgumentAccess().getRule();
	}
	
	//ArgumentExpression:
	//    (
	//      ArgumentOr
	//    | ArgumentAnd
	//    | ArgumentNot
	//    )
	//;
	public ArgumentExpressionElements getArgumentExpressionAccess() {
		return pArgumentExpression;
	}
	
	public ParserRule getArgumentExpressionRule() {
		return getArgumentExpressionAccess().getRule();
	}
	
	//ArgumentAnd returns ArgumentExpression:
	//    {ArgumentAnd}
	//    'and' '('
	//        ArgumentTerm (','? ArgumentTerm)*
	//    ')'
	//;
	public ArgumentAndElements getArgumentAndAccess() {
		return pArgumentAnd;
	}
	
	public ParserRule getArgumentAndRule() {
		return getArgumentAndAccess().getRule();
	}
	
	//ArgumentOr returns ArgumentExpression:
	//    {ArgumentOr}
	//    'or' '('
	//        ArgumentTerm (','? ArgumentTerm)*
	//    ')'
	//;
	public ArgumentOrElements getArgumentOrAccess() {
		return pArgumentOr;
	}
	
	public ParserRule getArgumentOrRule() {
		return getArgumentOrAccess().getRule();
	}
	
	//ArgumentNot returns ArgumentExpression:
	//    {ArgumentNot}
	//    'not'
	//        (ArgumentTerm | '(' ArgumentTerm')')
	//;
	public ArgumentNotElements getArgumentNotAccess() {
		return pArgumentNot;
	}
	
	public ParserRule getArgumentNotRule() {
		return getArgumentNotAccess().getRule();
	}
	
	//fragment ArgumentTerm*:
	//    (
	//       'contract' contracts+=[ContractElement|QPREF]
	//     | 'argument' arguments+=[ContractElement|QPREF]
	//     | nested+=ArgumentExpression
	//    )
	//;
	public ArgumentTermElements getArgumentTermAccess() {
		return pArgumentTerm;
	}
	
	public ParserRule getArgumentTermRule() {
		return getArgumentTermAccess().getRule();
	}
	
	//VerificationPlan:
	//    'verification' 'plan' name=ID '{'
	//    'component'
	////        ID ':' componentImplementation=[aadl2::ComponentImplementation|QCREF] ';'
	//        ID ':' componentImplementation=[sysmlv2::OccurrenceDefinition|QCREF] ';'
	//    ('domains'
	//        Domains
	//    )?
	//    ('claims'
	//        Claims
	//    )?
	//    ('contracts'
	//        (contracts+=[Contract|QPREF]? ';')*
	//    )?
	//    '}'
	//;
	public VerificationPlanElements getVerificationPlanAccess() {
		return pVerificationPlan;
	}
	
	public ParserRule getVerificationPlanRule() {
		return getVerificationPlanAccess().getRule();
	}
	
	//fragment Claims*:
	//    (claims+=Source? ';')*
	//;
	public ClaimsElements getClaimsAccess() {
		return pClaims;
	}
	
	public ParserRule getClaimsRule() {
		return getClaimsAccess().getRule();
	}
	
	//enum Language:
	//    PYTHON='python' | JAVA='java' | SMT='smt'
	//;
	public LanguageElements getLanguageAccess() {
		return eLanguage;
	}
	
	public EnumRule getLanguageRule() {
		return getLanguageAccess().getRule();
	}
	
	//Query:
	//    SingleValDeclaration |
	//    {TupleDeclaration} 'val' '(' names+=TupleName (',' names+=TupleName)+ ')' '=' value=Expression
	//;
	public QueryElements getQueryAccess() {
		return pQuery;
	}
	
	public ParserRule getQueryRule() {
		return getQueryAccess().getRule();
	}
	
	//SingleValDeclaration:
	//    'val' name=ID '=' value=Expression
	//;
	public SingleValDeclarationElements getSingleValDeclarationAccess() {
		return pSingleValDeclaration;
	}
	
	public ParserRule getSingleValDeclarationRule() {
		return getSingleValDeclarationAccess().getRule();
	}
	
	//TupleName:
	//    name=ID
	//;
	public TupleNameElements getTupleNameAccess() {
		return pTupleName;
	}
	
	public ParserRule getTupleNameRule() {
		return getTupleNameAccess().getRule();
	}
	
	//Expression:
	//    AndExpression ({OrExpression.left=current} '||' right=AndExpression)*
	//;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//AndExpression returns Expression:
	//    NotExpression ({AndExpression.left=current} '&&' right=NotExpression)*
	//;
	public AndExpressionElements getAndExpressionAccess() {
		return pAndExpression;
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}
	
	//NotExpression returns Expression:
	//    CallExpression | {NotExpression} '!' operand=CallExpression
	//;
	public NotExpressionElements getNotExpressionAccess() {
		return pNotExpression;
	}
	
	public ParserRule getNotExpressionRule() {
		return getNotExpressionAccess().getRule();
	}
	
	//CallExpression returns Expression:
	//    TerminalExpression (
	//        {MemberCall.left=current} '.' right=ID ('<' typeArgument=ID '>')? ('(' argument=Expression ')')? lambda=Lambda? |
	////        {PropertyLookup.left=current} '#' right=[aadl2::Property|QPREF]
	//        {PropertyLookup.left=current} '#' right=[sysmlv2::AttributeDefinition|QPREF]
	//    )*
	//;
	public CallExpressionElements getCallExpressionAccess() {
		return pCallExpression;
	}
	
	public ParserRule getCallExpressionRule() {
		return getCallExpressionAccess().getRule();
	}
	
	//Lambda:
	//    '{' parameter=Parameter '->' Queries returnValue=Expression '}'
	//;
	public LambdaElements getLambdaAccess() {
		return pLambda;
	}
	
	public ParserRule getLambdaRule() {
		return getLambdaAccess().getRule();
	}
	
	//Parameter:
	//    SingleParameter |
	//    {TupleParameter} '(' names+=TupleName (',' names+=TupleName)+ ')'
	//;
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}
	
	//SingleParameter:
	//    name=ID
	//;
	public SingleParameterElements getSingleParameterAccess() {
		return pSingleParameter;
	}
	
	public ParserRule getSingleParameterRule() {
		return getSingleParameterAccess().getRule();
	}
	
	//TerminalExpression returns Expression:
	//    {SelfExpression} 'self' |
	//    {RootExpression} 'root' |
	//    {StringLiteral} value=STRING |
	////    {NameReference} reference=[aadl2::NamedElement] |
	//    {NameReference} reference=[sysmlv2::Element] |
	//    /*
	//     * Handles both parentheses and tuples. Combining these is necessary to avoid a left recursion problem. The
	//     * following doesn't work:
	//     *
	//     * {TupleExpression} '(' elements+=Expression (',' elements+=Expression)+ ')' |
	//     * '(' Expression ')'
	//     */
	//    '(' Expression ({TupleExpression.elements+=current} (',' elements+=Expression)+)? ')'
	//;
	public TerminalExpressionElements getTerminalExpressionAccess() {
		return pTerminalExpression;
	}
	
	public ParserRule getTerminalExpressionRule() {
		return getTerminalExpressionAccess().getRule();
	}
	
	//ContractSubclause:
	//    {ContractSubclause} ('use' useQueries+=[Contract|QPREF])*
	//    ('verify' verifyPlans+=[VerificationPlan|QPREF] ';')*
	//;
	public ContractSubclauseElements getContractSubclauseAccess() {
		return pContractSubclause;
	}
	
	public ParserRule getContractSubclauseRule() {
		return getContractSubclauseAccess().getRule();
	}
	
	//// interpolated strings
	//IString:
	//    parts+=IStringLiteral
	//    | parts+=IStringLeftLiteral parts+=IStringInter?
	//      (parts+=IStringMiddleLiteral parts+=IStringInter?)*
	//      parts+=IStringRightLiteral
	//;
	public IStringElements getIStringAccess() {
		return pIString;
	}
	
	public ParserRule getIStringRule() {
		return getIStringAccess().getRule();
	}
	
	//IStringPart:
	//    IStringLiteral | IStringInter
	//;
	public IStringPartElements getIStringPartAccess() {
		return pIStringPart;
	}
	
	public ParserRule getIStringPartRule() {
		return getIStringPartAccess().getRule();
	}
	
	//IStringLiteral:
	//    value=ISTRING_TEXT
	//;
	public IStringLiteralElements getIStringLiteralAccess() {
		return pIStringLiteral;
	}
	
	public ParserRule getIStringLiteralRule() {
		return getIStringLiteralAccess().getRule();
	}
	
	//IStringLeftLiteral returns IStringLiteral:
	//    value=ISTRING_LEFT
	//;
	public IStringLeftLiteralElements getIStringLeftLiteralAccess() {
		return pIStringLeftLiteral;
	}
	
	public ParserRule getIStringLeftLiteralRule() {
		return getIStringLeftLiteralAccess().getRule();
	}
	
	//IStringMiddleLiteral returns IStringLiteral:
	//    value=ISTRING_MIDDLE
	//;
	public IStringMiddleLiteralElements getIStringMiddleLiteralAccess() {
		return pIStringMiddleLiteral;
	}
	
	public ParserRule getIStringMiddleLiteralRule() {
		return getIStringMiddleLiteralAccess().getRule();
	}
	
	//IStringRightLiteral returns IStringLiteral:
	//    value=ISTRING_RIGHT
	//;
	public IStringRightLiteralElements getIStringRightLiteralAccess() {
		return pIStringRightLiteral;
	}
	
	public ParserRule getIStringRightLiteralRule() {
		return getIStringRightLiteralAccess().getRule();
	}
	
	//enum Predefined:
	//    ERROR='error0' | INFO='info0'
	//;
	public PredefinedElements getPredefinedAccess() {
		return ePredefined;
	}
	
	public EnumRule getPredefinedRule() {
		return getPredefinedAccess().getRule();
	}
	
	//IStringInter returns IStringVar:
	//    direct?=":"?
	//    (
	//      ((domain=[Domain|ID] '::')? query=([SingleValDeclaration|ID]))
	//    | predefined=Predefined
	//    )
	//;
	public IStringInterElements getIStringInterAccess() {
		return pIStringInter;
	}
	
	public ParserRule getIStringInterRule() {
		return getIStringInterAccess().getRule();
	}
	
	//terminal ISTRING_TEXT:
	//    "'''" IN_ISTRING* ("'''" | ("'" "'"?)? EOF)
	//;
	public TerminalRule getISTRING_TEXTRule() {
		return tISTRING_TEXT;
	}
	
	//terminal ISTRING_LEFT:
	//    "'''" IN_ISTRING* ("'" "'"?)? "${"
	//;
	public TerminalRule getISTRING_LEFTRule() {
		return tISTRING_LEFT;
	}
	
	//terminal ISTRING_MIDDLE:
	//    "$}" IN_ISTRING* ("'" "'"?)? "${"
	//;
	public TerminalRule getISTRING_MIDDLERule() {
		return tISTRING_MIDDLE;
	}
	
	//terminal ISTRING_RIGHT:
	//    "$}" IN_ISTRING* ("'''" | ("'" "'"?)? EOF)
	//;
	public TerminalRule getISTRING_RIGHTRule() {
		return tISTRING_RIGHT;
	}
	
	//terminal fragment IN_ISTRING:
	//    "''" !"'"
	//    | "'" !"'"
	//    | "$" !"{"
	//    | !("'" | "$")
	//;
	public TerminalRule getIN_ISTRINGRule() {
		return tIN_ISTRING;
	}
	
	//OptionalQualifiedName:
	//    (ID '::')? ID
	//;
	public OptionalQualifiedNameElements getOptionalQualifiedNameAccess() {
		return pOptionalQualifiedName;
	}
	
	public ParserRule getOptionalQualifiedNameRule() {
		return getOptionalQualifiedNameAccess().getRule();
	}
	
	//terminal SSTRING:
	//    "`" !("`")* "`"
	//;
	public TerminalRule getSSTRINGRule() {
		return tSSTRING;
	}
	
	//terminal SL_COMMENT:
	//    '--' !('\n'|'\r')* ('\r'? '\n')?
	//;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//QPREF:
	//    ID ('::' ID)?;
	public QPREFElements getQPREFAccess() {
		return pQPREF;
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}
	
	//QCREF:
	//    (ID '::')* ID ('.' ID)?;
	public QCREFElements getQCREFAccess() {
		return pQCREF;
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}
	
	//STAR : '*';
	public STARElements getSTARAccess() {
		return pSTAR;
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}
	
	//terminal STRING    :
	//            '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|'"') )* '"' |
	//            "'" ( '\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	////terminal ID          : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	//terminal ID:    ('a'..'z'
	//        |'A'..'Z'
	//        ) ( ('_')? ('a'..'z'
	//        |'A'..'Z'
	//        |'0'..'9'))*;
	public TerminalRule getIDRule() {
		return tID;
	}
}
