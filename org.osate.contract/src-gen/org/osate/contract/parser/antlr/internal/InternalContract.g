
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
grammar InternalContract;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.osate.contract.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.contract.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.contract.services.ContractGrammarAccess;

}

@parser::members {

 	private ContractGrammarAccess grammarAccess;

    public InternalContractParser(TokenStream input, ContractGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "AnnexLibrary";
   	}

   	@Override
   	protected ContractGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleAnnexLibrary
entryRuleAnnexLibrary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnnexLibraryRule()); }
	iv_ruleAnnexLibrary=ruleAnnexLibrary
	{ $current=$iv_ruleAnnexLibrary.current; }
	EOF;

// Rule AnnexLibrary
ruleAnnexLibrary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getAnnexLibraryAccess().getContractLibraryParserRuleCall());
	}
	this_ContractLibrary_0=ruleContractLibrary
	{
		$current = $this_ContractLibrary_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleContractLibrary
entryRuleContractLibrary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContractLibraryRule()); }
	iv_ruleContractLibrary=ruleContractLibrary
	{ $current=$iv_ruleContractLibrary.current; }
	EOF;

// Rule ContractLibrary
ruleContractLibrary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getContractLibraryAccess().getContractLibraryAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_1_0());
				}
				lv_contractElements_1_0=ruleContractElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getContractLibraryRule());
					}
					add(
						$current,
						"contractElements",
						lv_contractElements_1_0,
						"org.osate.contract.Contract.ContractElement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleContractElement
entryRuleContractElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContractElementRule()); }
	iv_ruleContractElement=ruleContractElement
	{ $current=$iv_ruleContractElement.current; }
	EOF;

// Rule ContractElement
ruleContractElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getContractElementAccess().getImplementationParserRuleCall_0());
		}
		this_Implementation_0=ruleImplementation
		{
			$current = $this_Implementation_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getContractElementAccess().getDomainParserRuleCall_1());
		}
		this_Domain_1=ruleDomain
		{
			$current = $this_Domain_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getContractElementAccess().getArgumentParserRuleCall_2());
		}
		this_Argument_2=ruleArgument
		{
			$current = $this_Argument_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getContractElementAccess().getContractParserRuleCall_3());
		}
		this_Contract_3=ruleContract
		{
			$current = $this_Contract_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getContractElementAccess().getVerificationPlanParserRuleCall_4());
		}
		this_VerificationPlan_4=ruleVerificationPlan
		{
			$current = $this_VerificationPlan_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleContract
entryRuleContract returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContractRule()); }
	iv_ruleContract=ruleContract
	{ $current=$iv_ruleContract.current; }
	EOF;

// Rule Contract
ruleContract returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='contract'
		{
			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContractRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			otherlv_3='domains'
			{
				newLeafNode(otherlv_3, grammarAccess.getContractAccess().getDomainsKeyword_3_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getContractRule());
				}
				newCompositeNode(grammarAccess.getContractAccess().getDomainsParserRuleCall_3_1());
			}
			this_Domains_4=ruleDomains[$current]
			{
				$current = $this_Domains_4.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_5='queries'
			{
				newLeafNode(otherlv_5, grammarAccess.getContractAccess().getQueriesKeyword_4_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getContractRule());
				}
				newCompositeNode(grammarAccess.getContractAccess().getQueriesParserRuleCall_4_1());
			}
			this_Queries_6=ruleQueries[$current]
			{
				$current = $this_Queries_6.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_7='input'
			{
				newLeafNode(otherlv_7, grammarAccess.getContractAccess().getInputKeyword_5_0());
			}
			otherlv_8='assumptions'
			{
				newLeafNode(otherlv_8, grammarAccess.getContractAccess().getAssumptionsKeyword_5_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContractAccess().getInputsInputAssumptionParserRuleCall_5_2_0());
					}
					lv_inputs_9_0=ruleInputAssumption
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContractRule());
						}
						add(
							$current,
							"inputs",
							lv_inputs_9_0,
							"org.osate.contract.Contract.InputAssumption");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
		(
			otherlv_10='assumptions'
			{
				newLeafNode(otherlv_10, grammarAccess.getContractAccess().getAssumptionsKeyword_6_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getContractRule());
				}
				newCompositeNode(grammarAccess.getContractAccess().getAssumptionsParserRuleCall_6_1());
			}
			this_Assumptions_11=ruleAssumptions[$current]
			{
				$current = $this_Assumptions_11.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_12='guarantee'
			{
				newLeafNode(otherlv_12, grammarAccess.getContractAccess().getGuaranteeKeyword_7_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getContractRule());
				}
				newCompositeNode(grammarAccess.getContractAccess().getExactParserRuleCall_7_1());
			}
			this_Exact_13=ruleExact[$current]
			{
				$current = $this_Exact_13.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContractAccess().getGuaranteeGuaranteeParserRuleCall_7_2_0());
					}
					lv_guarantee_14_0=ruleGuarantee
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContractRule());
						}
						set(
							$current,
							"guarantee",
							lv_guarantee_14_0,
							"org.osate.contract.Contract.Guarantee");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_15=';'
			{
				newLeafNode(otherlv_15, grammarAccess.getContractAccess().getSemicolonKeyword_7_3());
			}
		)?
		(
			(
				otherlv_16='invocation'
				{
					newLeafNode(otherlv_16, grammarAccess.getContractAccess().getInvocationKeyword_8_0_0());
				}
				    |
				otherlv_17='analysis'
				{
					newLeafNode(otherlv_17, grammarAccess.getContractAccess().getAnalysisKeyword_8_0_1());
				}
			)
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getContractRule());
				}
				newCompositeNode(grammarAccess.getContractAccess().getAnalysesParserRuleCall_8_1());
			}
			this_Analyses_18=ruleAnalyses[$current]
			{
				$current = $this_Analyses_18.current;
				afterParserOrEnumRuleCall();
			}
		)?
		otherlv_19='}'
		{
			newLeafNode(otherlv_19, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_9());
		}
	)
;


// Rule Exact
ruleExact[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='=>'
		{
			newLeafNode(otherlv_0, grammarAccess.getExactAccess().getEqualsSignGreaterThanSignKeyword_0());
		}
		    |
		(
			(
				lv_exact_1_0='<=>'
				{
					newLeafNode(lv_exact_1_0, grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getExactRule());
					}
					setWithLastConsumed($current, "exact", lv_exact_1_0 != null, "<=>");
				}
			)
		)
	)
;


// Rule Queries
ruleQueries[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getQueriesAccess().getQueriesQueryParserRuleCall_0_0());
				}
				lv_queries_0_0=ruleQuery
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getQueriesRule());
					}
					add(
						$current,
						"queries",
						lv_queries_0_0,
						"org.osate.contract.Contract.Query");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getQueriesAccess().getSemicolonKeyword_1());
		}
	)*
;


// Rule Domains
ruleDomains[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDomainsRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDomainsAccess().getDomainsDomainCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getDomainsAccess().getSemicolonKeyword_1());
		}
	)*
;


// Rule Assumptions
ruleAssumptions[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAssumptionsAccess().getAssumptionsAssumptionElementParserRuleCall_0_0());
				}
				lv_assumptions_0_0=ruleAssumptionElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssumptionsRule());
					}
					add(
						$current,
						"assumptions",
						lv_assumptions_0_0,
						"org.osate.contract.Contract.AssumptionElement");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1());
		}
	)*
;


// Rule Analyses
ruleAnalyses[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getAnalysesAccess().getAnalysesAnalysisParserRuleCall_0_0());
				}
				lv_analyses_0_0=ruleAnalysis
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAnalysesRule());
					}
					add(
						$current,
						"analyses",
						lv_analyses_0_0,
						"org.osate.contract.Contract.Analysis");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getAnalysesAccess().getSemicolonKeyword_1());
		}
	)*
;

// Entry rule entryRuleInputAssumption
entryRuleInputAssumption returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInputAssumptionRule()); }
	iv_ruleInputAssumption=ruleInputAssumption
	{ $current=$iv_ruleInputAssumption.current; }
	EOF;

// Rule InputAssumption
ruleInputAssumption returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getInputAssumptionAccess().getInputAssumptionAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getInputAssumptionAccess().getCodeSourceParserRuleCall_1_0());
				}
				lv_code_1_0=ruleSource
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInputAssumptionRule());
					}
					set(
						$current,
						"code",
						lv_code_1_0,
						"org.osate.contract.Contract.Source");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getInputAssumptionAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleAssumptionElement
entryRuleAssumptionElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssumptionElementRule()); }
	iv_ruleAssumptionElement=ruleAssumptionElement
	{ $current=$iv_ruleAssumptionElement.current; }
	EOF;

// Rule AssumptionElement
ruleAssumptionElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAssumptionElementAccess().getContractAssumptionAction_0_0(),
						$current);
				}
			)
			otherlv_1='contract'
			{
				newLeafNode(otherlv_1, grammarAccess.getAssumptionElementAccess().getContractKeyword_0_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAssumptionElementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getAssumptionElementAccess().getContractContractElementCrossReference_0_2_0());
					}
					ruleQPREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAssumptionElementAccess().getArgumentAssumptionAction_1_0(),
						$current);
				}
			)
			otherlv_4='argument'
			{
				newLeafNode(otherlv_4, grammarAccess.getAssumptionElementAccess().getArgumentKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAssumptionElementRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getAssumptionElementAccess().getArgumentContractElementCrossReference_1_2_0());
					}
					ruleQPREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAssumptionElementAccess().getCodeAssumptionAction_2_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAssumptionElementAccess().getCodeSourceParserRuleCall_2_1_0());
					}
					lv_code_7_0=ruleSource
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAssumptionElementRule());
						}
						set(
							$current,
							"code",
							lv_code_7_0,
							"org.osate.contract.Contract.Source");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAssumptionElementRule());
					}
					newCompositeNode(grammarAccess.getAssumptionElementAccess().getExactParserRuleCall_2_2_0());
				}
				this_Exact_8=ruleExact[$current]
				{
					$current = $this_Exact_8.current;
					afterParserOrEnumRuleCall();
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getAssumptionElementAccess().getGuaranteeGuaranteeParserRuleCall_2_2_1_0());
						}
						lv_guarantee_9_0=ruleGuarantee
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getAssumptionElementRule());
							}
							set(
								$current,
								"guarantee",
								lv_guarantee_9_0,
								"org.osate.contract.Contract.Guarantee");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleGuarantee
entryRuleGuarantee returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGuaranteeRule()); }
	iv_ruleGuarantee=ruleGuarantee
	{ $current=$iv_ruleGuarantee.current; }
	EOF;

// Rule Guarantee
ruleGuarantee returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getGuaranteeAccess().getCodeSourceParserRuleCall_0());
			}
			lv_code_0_0=ruleSource
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getGuaranteeRule());
				}
				set(
					$current,
					"code",
					lv_code_0_0,
					"org.osate.contract.Contract.Source");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleAnalysis
entryRuleAnalysis returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAnalysisRule()); }
	iv_ruleAnalysis=ruleAnalysis
	{ $current=$iv_ruleAnalysis.current; }
	EOF;

// Rule Analysis
ruleAnalysis returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getAnalysisAccess().getCodeSourceParserRuleCall_0());
			}
			lv_code_0_0=ruleSource
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getAnalysisRule());
				}
				set(
					$current,
					"code",
					lv_code_0_0,
					"org.osate.contract.Contract.Source");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleSource
entryRuleSource returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSourceRule()); }
	iv_ruleSource=ruleSource
	{ $current=$iv_ruleSource.current; }
	EOF;

// Rule Source
ruleSource returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSourceAccess().getLanguageLanguageEnumRuleCall_0_0());
				}
				lv_language_0_0=ruleLanguage
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSourceRule());
					}
					set(
						$current,
						"language",
						lv_language_0_0,
						"org.osate.contract.Contract.Language");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				(
					lv_source_1_0=RULE_SSTRING
					{
						newLeafNode(lv_source_1_0, grammarAccess.getSourceAccess().getSourceSSTRINGTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSourceRule());
						}
						setWithLastConsumed(
							$current,
							"source",
							lv_source_1_0,
							"org.osate.contract.Contract.SSTRING");
					}
				)
			)
			    |
			(
				(
					{
						newCompositeNode(grammarAccess.getSourceAccess().getInterIStringParserRuleCall_1_1_0());
					}
					lv_inter_2_0=ruleIString
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSourceRule());
						}
						set(
							$current,
							"inter",
							lv_inter_2_0,
							"org.osate.contract.Contract.IString");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleImplementation
entryRuleImplementation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getImplementationRule()); }
	iv_ruleImplementation=ruleImplementation
	{ $current=$iv_ruleImplementation.current; }
	EOF;

// Rule Implementation
ruleImplementation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='contract'
		{
			newLeafNode(otherlv_0, grammarAccess.getImplementationAccess().getContractKeyword_0());
		}
		otherlv_1='implementation'
		{
			newLeafNode(otherlv_1, grammarAccess.getImplementationAccess().getImplementationKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getImplementationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getImplementationAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getImplementationAccess().getCodeSourceParserRuleCall_4_0());
				}
				lv_code_4_0=ruleSource
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getImplementationRule());
					}
					set(
						$current,
						"code",
						lv_code_4_0,
						"org.osate.contract.Contract.Source");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getImplementationAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleDomain
entryRuleDomain returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDomainRule()); }
	iv_ruleDomain=ruleDomain
	{ $current=$iv_ruleDomain.current; }
	EOF;

// Rule Domain
ruleDomain returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='domain'
		{
			newLeafNode(otherlv_0, grammarAccess.getDomainAccess().getDomainKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDomainRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			otherlv_3='queries'
			{
				newLeafNode(otherlv_3, grammarAccess.getDomainAccess().getQueriesKeyword_3_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getDomainRule());
				}
				newCompositeNode(grammarAccess.getDomainAccess().getQueriesParserRuleCall_3_1());
			}
			this_Queries_4=ruleQueries[$current]
			{
				$current = $this_Queries_4.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_5='declarations'
			{
				newLeafNode(otherlv_5, grammarAccess.getDomainAccess().getDeclarationsKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDomainAccess().getCodeSourceParserRuleCall_4_1_0());
					}
					lv_code_6_0=ruleSource
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDomainRule());
						}
						set(
							$current,
							"code",
							lv_code_6_0,
							"org.osate.contract.Contract.Source");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleArgument
entryRuleArgument returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArgumentRule()); }
	iv_ruleArgument=ruleArgument
	{ $current=$iv_ruleArgument.current; }
	EOF;

// Rule Argument
ruleArgument returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='argument'
		{
			newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getArgumentKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getArgumentRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getArgumentAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			otherlv_3='domains'
			{
				newLeafNode(otherlv_3, grammarAccess.getArgumentAccess().getDomainsKeyword_3_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getArgumentRule());
				}
				newCompositeNode(grammarAccess.getArgumentAccess().getDomainsParserRuleCall_3_1());
			}
			this_Domains_4=ruleDomains[$current]
			{
				$current = $this_Domains_4.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_5='guarantee'
			{
				newLeafNode(otherlv_5, grammarAccess.getArgumentAccess().getGuaranteeKeyword_4_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getArgumentRule());
				}
				newCompositeNode(grammarAccess.getArgumentAccess().getExactParserRuleCall_4_1());
			}
			this_Exact_6=ruleExact[$current]
			{
				$current = $this_Exact_6.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArgumentAccess().getGuaranteeGuaranteeParserRuleCall_4_2_0());
					}
					lv_guarantee_7_0=ruleGuarantee
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArgumentRule());
						}
						set(
							$current,
							"guarantee",
							lv_guarantee_7_0,
							"org.osate.contract.Contract.Guarantee");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_8=';'
			{
				newLeafNode(otherlv_8, grammarAccess.getArgumentAccess().getSemicolonKeyword_4_3());
			}
		)?
		(
			otherlv_9='argument'
			{
				newLeafNode(otherlv_9, grammarAccess.getArgumentAccess().getArgumentKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArgumentAccess().getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0());
					}
					lv_argumentExpression_10_0=ruleArgumentExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArgumentRule());
						}
						set(
							$current,
							"argumentExpression",
							lv_argumentExpression_10_0,
							"org.osate.contract.Contract.ArgumentExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_11='}'
		{
			newLeafNode(otherlv_11, grammarAccess.getArgumentAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleArgumentExpression
entryRuleArgumentExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArgumentExpressionRule()); }
	iv_ruleArgumentExpression=ruleArgumentExpression
	{ $current=$iv_ruleArgumentExpression.current; }
	EOF;

// Rule ArgumentExpression
ruleArgumentExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getArgumentExpressionAccess().getArgumentExpressionAction_0(),
					$current);
			}
		)
		otherlv_1='or'
		{
			newLeafNode(otherlv_1, grammarAccess.getArgumentExpressionAccess().getOrKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getArgumentExpressionAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				otherlv_3='contract'
				{
					newLeafNode(otherlv_3, grammarAccess.getArgumentExpressionAccess().getContractKeyword_3_0_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getArgumentExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getArgumentExpressionAccess().getContractsContractElementCrossReference_3_0_1_0());
						}
						ruleQPREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			    |
			(
				otherlv_5='argument'
				{
					newLeafNode(otherlv_5, grammarAccess.getArgumentExpressionAccess().getArgumentKeyword_3_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getArgumentExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getArgumentExpressionAccess().getArgumentsContractElementCrossReference_3_1_1_0());
						}
						ruleQPREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
		otherlv_7=')'
		{
			newLeafNode(otherlv_7, grammarAccess.getArgumentExpressionAccess().getRightParenthesisKeyword_4());
		}
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getArgumentExpressionAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleVerificationPlan
entryRuleVerificationPlan returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVerificationPlanRule()); }
	iv_ruleVerificationPlan=ruleVerificationPlan
	{ $current=$iv_ruleVerificationPlan.current; }
	EOF;

// Rule VerificationPlan
ruleVerificationPlan returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='verification'
		{
			newLeafNode(otherlv_0, grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0());
		}
		otherlv_1='plan'
		{
			newLeafNode(otherlv_1, grammarAccess.getVerificationPlanAccess().getPlanKeyword_1());
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getVerificationPlanAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVerificationPlanRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getVerificationPlanAccess().getLeftCurlyBracketKeyword_3());
		}
		otherlv_4='component'
		{
			newLeafNode(otherlv_4, grammarAccess.getVerificationPlanAccess().getComponentKeyword_4());
		}
		this_ID_5=RULE_ID
		{
			newLeafNode(this_ID_5, grammarAccess.getVerificationPlanAccess().getIDTerminalRuleCall_5());
		}
		otherlv_6=':'
		{
			newLeafNode(otherlv_6, grammarAccess.getVerificationPlanAccess().getColonKeyword_6());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVerificationPlanRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationCrossReference_7_0());
				}
				ruleQCREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_8=';'
		{
			newLeafNode(otherlv_8, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_8());
		}
		(
			otherlv_9='domains'
			{
				newLeafNode(otherlv_9, grammarAccess.getVerificationPlanAccess().getDomainsKeyword_9_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getVerificationPlanRule());
				}
				newCompositeNode(grammarAccess.getVerificationPlanAccess().getDomainsParserRuleCall_9_1());
			}
			this_Domains_10=ruleDomains[$current]
			{
				$current = $this_Domains_10.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_11='claims'
			{
				newLeafNode(otherlv_11, grammarAccess.getVerificationPlanAccess().getClaimsKeyword_10_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getVerificationPlanRule());
				}
				newCompositeNode(grammarAccess.getVerificationPlanAccess().getClaimsParserRuleCall_10_1());
			}
			this_Claims_12=ruleClaims[$current]
			{
				$current = $this_Claims_12.current;
				afterParserOrEnumRuleCall();
			}
		)?
		(
			otherlv_13='contracts'
			{
				newLeafNode(otherlv_13, grammarAccess.getVerificationPlanAccess().getContractsKeyword_11_0());
			}
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getVerificationPlanRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getVerificationPlanAccess().getContractsContractCrossReference_11_1_0_0());
						}
						ruleQPREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)?
				otherlv_15=';'
				{
					newLeafNode(otherlv_15, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_11_1_1());
				}
			)*
		)?
		otherlv_16='}'
		{
			newLeafNode(otherlv_16, grammarAccess.getVerificationPlanAccess().getRightCurlyBracketKeyword_12());
		}
	)
;


// Rule Claims
ruleClaims[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getClaimsAccess().getClaimsSourceParserRuleCall_0_0());
				}
				lv_claims_0_0=ruleSource
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getClaimsRule());
					}
					add(
						$current,
						"claims",
						lv_claims_0_0,
						"org.osate.contract.Contract.Source");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_1=';'
		{
			newLeafNode(otherlv_1, grammarAccess.getClaimsAccess().getSemicolonKeyword_1());
		}
	)*
;

// Entry rule entryRuleQuery
entryRuleQuery returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getQueryRule()); }
	iv_ruleQuery=ruleQuery
	{ $current=$iv_ruleQuery.current; }
	EOF;

// Rule Query
ruleQuery returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQueryAccess().getSingleValDeclarationParserRuleCall_0());
		}
		this_SingleValDeclaration_0=ruleSingleValDeclaration
		{
			$current = $this_SingleValDeclaration_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getQueryAccess().getTupleDeclarationAction_1_0(),
						$current);
				}
			)
			otherlv_2='val'
			{
				newLeafNode(otherlv_2, grammarAccess.getQueryAccess().getValKeyword_1_1());
			}
			otherlv_3='('
			{
				newLeafNode(otherlv_3, grammarAccess.getQueryAccess().getLeftParenthesisKeyword_1_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_3_0());
					}
					lv_names_4_0=ruleTupleName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQueryRule());
						}
						add(
							$current,
							"names",
							lv_names_4_0,
							"org.osate.contract.Contract.TupleName");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=','
				{
					newLeafNode(otherlv_5, grammarAccess.getQueryAccess().getCommaKeyword_1_4_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_4_1_0());
						}
						lv_names_6_0=ruleTupleName
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getQueryRule());
							}
							add(
								$current,
								"names",
								lv_names_6_0,
								"org.osate.contract.Contract.TupleName");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
			otherlv_7=')'
			{
				newLeafNode(otherlv_7, grammarAccess.getQueryAccess().getRightParenthesisKeyword_1_5());
			}
			otherlv_8='='
			{
				newLeafNode(otherlv_8, grammarAccess.getQueryAccess().getEqualsSignKeyword_1_6());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getQueryAccess().getValueExpressionParserRuleCall_1_7_0());
					}
					lv_value_9_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getQueryRule());
						}
						set(
							$current,
							"value",
							lv_value_9_0,
							"org.osate.contract.Contract.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleSingleValDeclaration
entryRuleSingleValDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSingleValDeclarationRule()); }
	iv_ruleSingleValDeclaration=ruleSingleValDeclaration
	{ $current=$iv_ruleSingleValDeclaration.current; }
	EOF;

// Rule SingleValDeclaration
ruleSingleValDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='val'
		{
			newLeafNode(otherlv_0, grammarAccess.getSingleValDeclarationAccess().getValKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSingleValDeclarationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getSingleValDeclarationAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSingleValDeclarationAccess().getValueExpressionParserRuleCall_3_0());
				}
				lv_value_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingleValDeclarationRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"org.osate.contract.Contract.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleTupleName
entryRuleTupleName returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleNameRule()); }
	iv_ruleTupleName=ruleTupleName
	{ $current=$iv_ruleTupleName.current; }
	EOF;

// Rule TupleName
ruleTupleName returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getTupleNameAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getTupleNameRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ID");
			}
		)
	)
;

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0());
		}
		this_AndExpression_0=ruleAndExpression
		{
			$current = $this_AndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='||'
			{
				newLeafNode(otherlv_2, grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.contract.Contract.AndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleAndExpression
entryRuleAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndExpressionRule()); }
	iv_ruleAndExpression=ruleAndExpression
	{ $current=$iv_ruleAndExpression.current; }
	EOF;

// Rule AndExpression
ruleAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0());
		}
		this_NotExpression_0=ruleNotExpression
		{
			$current = $this_NotExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='&&'
			{
				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleNotExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.contract.Contract.NotExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleNotExpression
entryRuleNotExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNotExpressionRule()); }
	iv_ruleNotExpression=ruleNotExpression
	{ $current=$iv_ruleNotExpression.current; }
	EOF;

// Rule NotExpression
ruleNotExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getNotExpressionAccess().getCallExpressionParserRuleCall_0());
		}
		this_CallExpression_0=ruleCallExpression
		{
			$current = $this_CallExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0(),
						$current);
				}
			)
			otherlv_2='!'
			{
				newLeafNode(otherlv_2, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNotExpressionAccess().getOperandCallExpressionParserRuleCall_1_2_0());
					}
					lv_operand_3_0=ruleCallExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNotExpressionRule());
						}
						set(
							$current,
							"operand",
							lv_operand_3_0,
							"org.osate.contract.Contract.CallExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleCallExpression
entryRuleCallExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCallExpressionRule()); }
	iv_ruleCallExpression=ruleCallExpression
	{ $current=$iv_ruleCallExpression.current; }
	EOF;

// Rule CallExpression
ruleCallExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getCallExpressionAccess().getTerminalExpressionParserRuleCall_0());
		}
		this_TerminalExpression_0=ruleTerminalExpression
		{
			$current = $this_TerminalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getCallExpressionAccess().getMemberCallLeftAction_1_0_0(),
							$current);
					}
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getCallExpressionAccess().getOperatorMemberCallOperatorEnumRuleCall_1_0_1_0());
						}
						lv_operator_2_0=ruleMemberCallOperator
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCallExpressionRule());
							}
							set(
								$current,
								"operator",
								lv_operator_2_0,
								"org.osate.contract.Contract.MemberCallOperator");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						lv_right_3_0=RULE_ID
						{
							newLeafNode(lv_right_3_0, grammarAccess.getCallExpressionAccess().getRightIDTerminalRuleCall_1_0_2_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getCallExpressionRule());
							}
							setWithLastConsumed(
								$current,
								"right",
								lv_right_3_0,
								"org.osate.xtext.aadl2.properties.Properties.ID");
						}
					)
				)
				(
					otherlv_4='<'
					{
						newLeafNode(otherlv_4, grammarAccess.getCallExpressionAccess().getLessThanSignKeyword_1_0_3_0());
					}
					(
						(
							lv_typeArgument_5_0=RULE_ID
							{
								newLeafNode(lv_typeArgument_5_0, grammarAccess.getCallExpressionAccess().getTypeArgumentIDTerminalRuleCall_1_0_3_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getCallExpressionRule());
								}
								setWithLastConsumed(
									$current,
									"typeArgument",
									lv_typeArgument_5_0,
									"org.osate.xtext.aadl2.properties.Properties.ID");
							}
						)
					)
					otherlv_6='>'
					{
						newLeafNode(otherlv_6, grammarAccess.getCallExpressionAccess().getGreaterThanSignKeyword_1_0_3_2());
					}
				)?
				(
					otherlv_7='('
					{
						newLeafNode(otherlv_7, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_0_4_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getCallExpressionAccess().getArgumentExpressionParserRuleCall_1_0_4_1_0());
							}
							lv_argument_8_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getCallExpressionRule());
								}
								set(
									$current,
									"argument",
									lv_argument_8_0,
									"org.osate.contract.Contract.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
					otherlv_9=')'
					{
						newLeafNode(otherlv_9, grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_0_4_2());
					}
				)?
				(
					(
						{
							newCompositeNode(grammarAccess.getCallExpressionAccess().getLambdaLambdaParserRuleCall_1_0_5_0());
						}
						lv_lambda_10_0=ruleLambda
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getCallExpressionRule());
							}
							set(
								$current,
								"lambda",
								lv_lambda_10_0,
								"org.osate.contract.Contract.Lambda");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)
			    |
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0(),
							$current);
					}
				)
				otherlv_12='#'
				{
					newLeafNode(otherlv_12, grammarAccess.getCallExpressionAccess().getNumberSignKeyword_1_1_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getCallExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getCallExpressionAccess().getRightPropertyCrossReference_1_1_2_0());
						}
						ruleQPREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)*
	)
;

// Entry rule entryRuleLambda
entryRuleLambda returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLambdaRule()); }
	iv_ruleLambda=ruleLambda
	{ $current=$iv_ruleLambda.current; }
	EOF;

// Rule Lambda
ruleLambda returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='{'
		{
			newLeafNode(otherlv_0, grammarAccess.getLambdaAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLambdaAccess().getParameterParameterParserRuleCall_1_0());
				}
				lv_parameter_1_0=ruleParameter
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLambdaRule());
					}
					set(
						$current,
						"parameter",
						lv_parameter_1_0,
						"org.osate.contract.Contract.Parameter");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='->'
		{
			newLeafNode(otherlv_2, grammarAccess.getLambdaAccess().getHyphenMinusGreaterThanSignKeyword_2());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getLambdaRule());
			}
			newCompositeNode(grammarAccess.getLambdaAccess().getQueriesParserRuleCall_3());
		}
		this_Queries_3=ruleQueries[$current]
		{
			$current = $this_Queries_3.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLambdaAccess().getReturnValueExpressionParserRuleCall_4_0());
				}
				lv_returnValue_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLambdaRule());
					}
					set(
						$current,
						"returnValue",
						lv_returnValue_4_0,
						"org.osate.contract.Contract.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getLambdaAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleParameter
entryRuleParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParameterRule()); }
	iv_ruleParameter=ruleParameter
	{ $current=$iv_ruleParameter.current; }
	EOF;

// Rule Parameter
ruleParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getParameterAccess().getSingleParameterParserRuleCall_0());
		}
		this_SingleParameter_0=ruleSingleParameter
		{
			$current = $this_SingleParameter_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getParameterAccess().getTupleParameterAction_1_0(),
						$current);
				}
			)
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_2_0());
					}
					lv_names_3_0=ruleTupleName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParameterRule());
						}
						add(
							$current,
							"names",
							lv_names_3_0,
							"org.osate.contract.Contract.TupleName");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_3_1_0());
						}
						lv_names_5_0=ruleTupleName
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getParameterRule());
							}
							add(
								$current,
								"names",
								lv_names_5_0,
								"org.osate.contract.Contract.TupleName");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)+
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getRightParenthesisKeyword_1_4());
			}
		)
	)
;

// Entry rule entryRuleSingleParameter
entryRuleSingleParameter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSingleParameterRule()); }
	iv_ruleSingleParameter=ruleSingleParameter
	{ $current=$iv_ruleSingleParameter.current; }
	EOF;

// Rule SingleParameter
ruleSingleParameter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getSingleParameterAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getSingleParameterRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ID");
			}
		)
	)
;

// Entry rule entryRuleTerminalExpression
entryRuleTerminalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTerminalExpressionRule()); }
	iv_ruleTerminalExpression=ruleTerminalExpression
	{ $current=$iv_ruleTerminalExpression.current; }
	EOF;

// Rule TerminalExpression
ruleTerminalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getSelfExpressionAction_0_0(),
						$current);
				}
			)
			otherlv_1='self'
			{
				newLeafNode(otherlv_1, grammarAccess.getTerminalExpressionAccess().getSelfKeyword_0_1());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getRootExpressionAction_1_0(),
						$current);
				}
			)
			otherlv_3='root'
			{
				newLeafNode(otherlv_3, grammarAccess.getTerminalExpressionAccess().getRootKeyword_1_1());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getStringLiteralAction_2_0(),
						$current);
				}
			)
			(
				(
					lv_value_5_0=RULE_STRING
					{
						newLeafNode(lv_value_5_0, grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTerminalExpressionRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_5_0,
							"org.osate.xtext.aadl2.properties.Properties.STRING");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getTerminalExpressionAccess().getNameReferenceAction_3_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTerminalExpressionRule());
						}
					}
					otherlv_7=RULE_ID
					{
						newLeafNode(otherlv_7, grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementCrossReference_3_1_0());
					}
				)
			)
		)
		    |
		(
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0());
			}
			{
				newCompositeNode(grammarAccess.getTerminalExpressionAccess().getExpressionParserRuleCall_4_1());
			}
			this_Expression_9=ruleExpression
			{
				$current = $this_Expression_9.current;
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						$current = forceCreateModelElementAndAdd(
							grammarAccess.getTerminalExpressionAccess().getTupleExpressionElementsAction_4_2_0(),
							$current);
					}
				)
				(
					otherlv_11=','
					{
						newLeafNode(otherlv_11, grammarAccess.getTerminalExpressionAccess().getCommaKeyword_4_2_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getTerminalExpressionAccess().getElementsExpressionParserRuleCall_4_2_1_1_0());
							}
							lv_elements_12_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getTerminalExpressionRule());
								}
								add(
									$current,
									"elements",
									lv_elements_12_0,
									"org.osate.contract.Contract.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)+
			)?
			otherlv_13=')'
			{
				newLeafNode(otherlv_13, grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_4_3());
			}
		)
	)
;

// Entry rule entryRuleContractSubclause
entryRuleContractSubclause returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContractSubclauseRule()); }
	iv_ruleContractSubclause=ruleContractSubclause
	{ $current=$iv_ruleContractSubclause.current; }
	EOF;

// Rule ContractSubclause
ruleContractSubclause returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getContractSubclauseAccess().getContractSubclauseAction_0(),
					$current);
			}
		)
		(
			otherlv_1='use'
			{
				newLeafNode(otherlv_1, grammarAccess.getContractSubclauseAccess().getUseKeyword_1_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContractSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getContractSubclauseAccess().getUseQueriesContractCrossReference_1_1_0());
					}
					ruleQPREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			otherlv_3='verify'
			{
				newLeafNode(otherlv_3, grammarAccess.getContractSubclauseAccess().getVerifyKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContractSubclauseRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanCrossReference_2_1_0());
					}
					ruleQPREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_5=';'
			{
				newLeafNode(otherlv_5, grammarAccess.getContractSubclauseAccess().getSemicolonKeyword_2_2());
			}
		)*
	)
;

// Entry rule entryRuleIString
entryRuleIString returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringRule()); }
	iv_ruleIString=ruleIString
	{ $current=$iv_ruleIString.current; }
	EOF;

// Rule IString
ruleIString returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringLiteralParserRuleCall_0_0());
				}
				lv_parts_0_0=ruleIStringLiteral
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIStringRule());
					}
					add(
						$current,
						"parts",
						lv_parts_0_0,
						"org.osate.contract.Contract.IStringLiteral");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringLeftLiteralParserRuleCall_1_0_0());
					}
					lv_parts_1_0=ruleIStringLeftLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIStringRule());
						}
						add(
							$current,
							"parts",
							lv_parts_1_0,
							"org.osate.contract.Contract.IStringLeftLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_1_0());
					}
					lv_parts_2_0=ruleIStringInter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIStringRule());
						}
						add(
							$current,
							"parts",
							lv_parts_2_0,
							"org.osate.contract.Contract.IStringInter");
						afterParserOrEnumRuleCall();
					}
				)
			)?
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0());
						}
						lv_parts_3_0=ruleIStringMiddleLiteral
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getIStringRule());
							}
							add(
								$current,
								"parts",
								lv_parts_3_0,
								"org.osate.contract.Contract.IStringMiddleLiteral");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					(
						{
							newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_2_1_0());
						}
						lv_parts_4_0=ruleIStringInter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getIStringRule());
							}
							add(
								$current,
								"parts",
								lv_parts_4_0,
								"org.osate.contract.Contract.IStringInter");
							afterParserOrEnumRuleCall();
						}
					)
				)?
			)*
			(
				(
					{
						newCompositeNode(grammarAccess.getIStringAccess().getPartsIStringRightLiteralParserRuleCall_1_3_0());
					}
					lv_parts_5_0=ruleIStringRightLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIStringRule());
						}
						add(
							$current,
							"parts",
							lv_parts_5_0,
							"org.osate.contract.Contract.IStringRightLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleIStringLiteral
entryRuleIStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringLiteralRule()); }
	iv_ruleIStringLiteral=ruleIStringLiteral
	{ $current=$iv_ruleIStringLiteral.current; }
	EOF;

// Rule IStringLiteral
ruleIStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_ISTRING_TEXT
			{
				newLeafNode(lv_value_0_0, grammarAccess.getIStringLiteralAccess().getValueISTRING_TEXTTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getIStringLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.contract.Contract.ISTRING_TEXT");
			}
		)
	)
;

// Entry rule entryRuleIStringLeftLiteral
entryRuleIStringLeftLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringLeftLiteralRule()); }
	iv_ruleIStringLeftLiteral=ruleIStringLeftLiteral
	{ $current=$iv_ruleIStringLeftLiteral.current; }
	EOF;

// Rule IStringLeftLiteral
ruleIStringLeftLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_ISTRING_LEFT
			{
				newLeafNode(lv_value_0_0, grammarAccess.getIStringLeftLiteralAccess().getValueISTRING_LEFTTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getIStringLeftLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.contract.Contract.ISTRING_LEFT");
			}
		)
	)
;

// Entry rule entryRuleIStringMiddleLiteral
entryRuleIStringMiddleLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringMiddleLiteralRule()); }
	iv_ruleIStringMiddleLiteral=ruleIStringMiddleLiteral
	{ $current=$iv_ruleIStringMiddleLiteral.current; }
	EOF;

// Rule IStringMiddleLiteral
ruleIStringMiddleLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_ISTRING_MIDDLE
			{
				newLeafNode(lv_value_0_0, grammarAccess.getIStringMiddleLiteralAccess().getValueISTRING_MIDDLETerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getIStringMiddleLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.contract.Contract.ISTRING_MIDDLE");
			}
		)
	)
;

// Entry rule entryRuleIStringRightLiteral
entryRuleIStringRightLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringRightLiteralRule()); }
	iv_ruleIStringRightLiteral=ruleIStringRightLiteral
	{ $current=$iv_ruleIStringRightLiteral.current; }
	EOF;

// Rule IStringRightLiteral
ruleIStringRightLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_ISTRING_RIGHT
			{
				newLeafNode(lv_value_0_0, grammarAccess.getIStringRightLiteralAccess().getValueISTRING_RIGHTTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getIStringRightLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.contract.Contract.ISTRING_RIGHT");
			}
		)
	)
;

// Entry rule entryRuleIStringInter
entryRuleIStringInter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIStringInterRule()); }
	iv_ruleIStringInter=ruleIStringInter
	{ $current=$iv_ruleIStringInter.current; }
	EOF;

// Rule IStringInter
ruleIStringInter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_direct_0_0=':'
				{
					newLeafNode(lv_direct_0_0, grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIStringInterRule());
					}
					setWithLastConsumed($current, "direct", lv_direct_0_0 != null, ":");
				}
			)
		)?
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getIStringInterRule());
						}
					}
					otherlv_1=RULE_ID
					{
						newLeafNode(otherlv_1, grammarAccess.getIStringInterAccess().getDomainDomainCrossReference_1_0_0());
					}
				)
			)
			otherlv_2='::'
			{
				newLeafNode(otherlv_2, grammarAccess.getIStringInterAccess().getColonColonKeyword_1_1());
			}
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIStringInterRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationCrossReference_2_0());
				}
			)
		)
	)
;

// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); }
	iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation
	{ $current=$iv_ruleContainedPropertyAssociation.current; }
	EOF;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1='=>'
			{
				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
			}
			    |
			(
				(
					lv_append_2_0='+=>'
					{
						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
						setWithLastConsumed($current, "append", lv_append_2_0 != null, "+=>");
					}
				)
			)
		)
		(
			(
				lv_constant_3_0='constant'
				{
					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
					setWithLastConsumed($current, "constant", lv_constant_3_0 != null, "constant");
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
					}
					lv_ownedValue_4_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"ownedValue",
							lv_ownedValue_4_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=','
				{
					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
						}
						lv_ownedValue_6_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"ownedValue",
								lv_ownedValue_6_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
			}
			ruleAppliesToKeywords
			{
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
					}
					lv_appliesTo_8_0=ruleContainmentPath
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"appliesTo",
							lv_appliesTo_8_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=','
				{
					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
						}
						lv_appliesTo_10_0=ruleContainmentPath
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"appliesTo",
								lv_appliesTo_10_0,
								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
			}
			ruleInBindingKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_12='('
			{
				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
					}
					ruleQCREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_14=')'
			{
				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_15=';'
		{
			newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRuleContainmentPath
entryRuleContainmentPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathRule()); }
	iv_ruleContainmentPath=ruleContainmentPath
	{ $current=$iv_ruleContainmentPath.current; }
	EOF;

// Rule ContainmentPath
ruleContainmentPath returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
			}
			lv_path_0_0=ruleContainmentPathElement
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getContainmentPathRule());
				}
				set(
					$current,
					"path",
					lv_path_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); }
	iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue
	{ $current=$iv_ruleOptionalModalPropertyValue.current; }
	EOF;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
				}
				lv_ownedValue_0_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_0_0,
						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			{
				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
			}
			ruleInModesKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
							}
						}
						otherlv_5=RULE_ID
						{
							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
						}
					)
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
			}
		)?
	)
;

// Entry rule entryRulePropertyValue
entryRulePropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyValueRule()); }
	iv_rulePropertyValue=rulePropertyValue
	{ $current=$iv_rulePropertyValue.current; }
	EOF;

// Rule PropertyValue
rulePropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
			}
			lv_ownedValue_0_0=rulePropertyExpression
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPropertyValueRule());
				}
				set(
					$current,
					"ownedValue",
					lv_ownedValue_0_0,
					"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRulePropertyExpression
entryRulePropertyExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyExpressionRule()); }
	iv_rulePropertyExpression=rulePropertyExpression
	{ $current=$iv_rulePropertyExpression.current; }
	EOF;

// Rule PropertyExpression
rulePropertyExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0());
		}
		this_RecordTerm_0=ruleRecordTerm
		{
			$current = $this_RecordTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1());
		}
		this_ReferenceTerm_1=ruleReferenceTerm
		{
			$current = $this_ReferenceTerm_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2());
		}
		this_ComponentClassifierTerm_2=ruleComponentClassifierTerm
		{
			$current = $this_ComponentClassifierTerm_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3());
		}
		this_ComputedTerm_3=ruleComputedTerm
		{
			$current = $this_ComputedTerm_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4());
		}
		this_StringTerm_4=ruleStringTerm
		{
			$current = $this_StringTerm_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5());
		}
		this_NumericRangeTerm_5=ruleNumericRangeTerm
		{
			$current = $this_NumericRangeTerm_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6());
		}
		this_RealTerm_6=ruleRealTerm
		{
			$current = $this_RealTerm_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7());
		}
		this_IntegerTerm_7=ruleIntegerTerm
		{
			$current = $this_IntegerTerm_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8());
		}
		this_ListTerm_8=ruleListTerm
		{
			$current = $this_ListTerm_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9());
		}
		this_BooleanLiteral_9=ruleBooleanLiteral
		{
			$current = $this_BooleanLiteral_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10());
		}
		this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm
		{
			$current = $this_LiteralorReferenceTerm_10.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); }
	iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm
	{ $current=$iv_ruleLiteralorReferenceTerm.current; }
	EOF;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0());
			}
			ruleQPREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
	iv_ruleBooleanLiteral=ruleBooleanLiteral
	{ $current=$iv_ruleBooleanLiteral.current; }
	EOF;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_0='true'
					{
						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBooleanLiteralRule());
						}
						setWithLastConsumed($current, "value", lv_value_1_0 != null, "true");
					}
				)
			)
			    |
			otherlv_2='false'
			{
				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
			}
		)
	)
;

// Entry rule entryRuleConstantValue
entryRuleConstantValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstantValueRule()); }
	iv_ruleConstantValue=ruleConstantValue
	{ $current=$iv_ruleConstantValue.current; }
	EOF;

// Rule ConstantValue
ruleConstantValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getConstantValueRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
			}
			ruleQPREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceTermRule()); }
	iv_ruleReferenceTerm=ruleReferenceTerm
	{ $current=$iv_ruleReferenceTerm.current; }
	EOF;

// Rule ReferenceTerm
ruleReferenceTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='reference'
		{
			newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
				}
				lv_path_2_0=ruleContainmentPathElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReferenceTermRule());
					}
					set(
						$current,
						"path",
						lv_path_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleRecordTerm
entryRuleRecordTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRecordTermRule()); }
	iv_ruleRecordTerm=ruleRecordTerm
	{ $current=$iv_ruleRecordTerm.current; }
	EOF;

// Rule RecordTerm
ruleRecordTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
				}
				lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRecordTermRule());
					}
					add(
						$current,
						"ownedFieldValue",
						lv_ownedFieldValue_1_0,
						"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_2=']'
		{
			newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
		}
	)
;

// Entry rule entryRuleComputedTerm
entryRuleComputedTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComputedTermRule()); }
	iv_ruleComputedTerm=ruleComputedTerm
	{ $current=$iv_ruleComputedTerm.current; }
	EOF;

// Rule ComputedTerm
ruleComputedTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='compute'
		{
			newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				lv_function_2_0=RULE_ID
				{
					newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComputedTermRule());
					}
					setWithLastConsumed(
						$current,
						"function",
						lv_function_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentClassifierTermRule()); }
	iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm
	{ $current=$iv_ruleComponentClassifierTerm.current; }
	EOF;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='classifier'
		{
			newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getComponentClassifierTermRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
				}
				ruleQCREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleListTerm
entryRuleListTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListTermRule()); }
	iv_ruleListTerm=ruleListTerm
	{ $current=$iv_ruleListTerm.current; }
	EOF;

// Rule ListTerm
ruleListTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getListTermAccess().getListValueAction_0(),
					$current);
			}
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
					}
					lv_ownedListElement_2_0=rulePropertyExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getListTermRule());
						}
						add(
							$current,
							"ownedListElement",
							lv_ownedListElement_2_0,
							"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
						}
						lv_ownedListElement_4_0=rulePropertyExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getListTermRule());
							}
							add(
								$current,
								"ownedListElement",
								lv_ownedListElement_4_0,
								"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); }
	iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation
	{ $current=$iv_ruleFieldPropertyAssociation.current; }
	EOF;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
				}
			)
		)
		otherlv_1='=>'
		{
			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
				}
				lv_ownedValue_2_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_2_0,
						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathElementRule()); }
	iv_ruleContainmentPathElement=ruleContainmentPathElement
	{ $current=$iv_ruleContainmentPathElement.current; }
	EOF;

// Rule ContainmentPathElement
ruleContainmentPathElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainmentPathElementRule());
						}
					}
					otherlv_0=RULE_ID
					{
						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
					}
					lv_arrayRange_1_0=ruleArrayRange
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						add(
							$current,
							"arrayRange",
							lv_arrayRange_1_0,
							"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		(
			otherlv_2='.'
			{
				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
					}
					lv_path_3_0=ruleContainmentPathElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						set(
							$current,
							"path",
							lv_path_3_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRulePlusMinus
entryRulePlusMinus returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPlusMinusRule()); }
	iv_rulePlusMinus=rulePlusMinus
	{ $current=$iv_rulePlusMinus.current.getText(); }
	EOF;

// Rule PlusMinus
rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='+'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
		}
		    |
		kw='-'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleStringTerm
entryRuleStringTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStringTermRule()); }
	iv_ruleStringTerm=ruleStringTerm
	{ $current=$iv_ruleStringTerm.current; }
	EOF;

// Rule StringTerm
ruleStringTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
			}
			lv_value_0_0=ruleNoQuoteString
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getStringTermRule());
				}
				set(
					$current,
					"value",
					lv_value_0_0,
					"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNoQuoteStringRule()); }
	iv_ruleNoQuoteString=ruleNoQuoteString
	{ $current=$iv_ruleNoQuoteString.current.getText(); }
	EOF;

// Rule NoQuoteString
ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_STRING_0=RULE_STRING
	{
		$current.merge(this_STRING_0);
	}
	{
		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleArrayRange
entryRuleArrayRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArrayRangeRule()); }
	iv_ruleArrayRange=ruleArrayRange
	{ $current=$iv_ruleArrayRange.current; }
	EOF;

// Rule ArrayRange
ruleArrayRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
					$current);
			}
		)
		otherlv_1='['
		{
			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
				}
				lv_lowerBound_2_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
					}
					set(
						$current,
						"lowerBound",
						lv_lowerBound_2_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3='..'
			{
				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
					}
					lv_upperBound_4_0=ruleINTVALUE
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
						}
						set(
							$current,
							"upperBound",
							lv_upperBound_4_0,
							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5=']'
		{
			newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleSignedConstant
entryRuleSignedConstant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignedConstantRule()); }
	iv_ruleSignedConstant=ruleSignedConstant
	{ $current=$iv_ruleSignedConstant.current; }
	EOF;

// Rule SignedConstant
ruleSignedConstant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
				}
				lv_op_0_0=rulePlusMinus
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					set(
						$current,
						"op",
						lv_op_0_0,
						"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
				}
				lv_ownedPropertyExpression_1_0=ruleConstantValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					add(
						$current,
						"ownedPropertyExpression",
						lv_ownedPropertyExpression_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntegerTermRule()); }
	iv_ruleIntegerTerm=ruleIntegerTerm
	{ $current=$iv_ruleIntegerTerm.current; }
	EOF;

// Rule IntegerTerm
ruleIntegerTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedInt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntegerTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.xtext.aadl2.properties.Properties.SignedInt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIntegerTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleSignedInt
entryRuleSignedInt returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedIntRule()); }
	iv_ruleSignedInt=ruleSignedInt
	{ $current=$iv_ruleSignedInt.current.getText(); }
	EOF;

// Rule SignedInt
ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='+'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
			}
			    |
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
			}
		)?
		this_INTEGER_LIT_2=RULE_INTEGER_LIT
		{
			$current.merge(this_INTEGER_LIT_2);
		}
		{
			newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleRealTerm
entryRuleRealTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRealTermRule()); }
	iv_ruleRealTerm=ruleRealTerm
	{ $current=$iv_ruleRealTerm.current; }
	EOF;

// Rule RealTerm
ruleRealTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedReal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRealTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.xtext.aadl2.properties.Properties.SignedReal");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRealTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleSignedReal
entryRuleSignedReal returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedRealRule()); }
	iv_ruleSignedReal=ruleSignedReal
	{ $current=$iv_ruleSignedReal.current.getText(); }
	EOF;

// Rule SignedReal
ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='+'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());
			}
			    |
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1());
			}
		)?
		this_REAL_LIT_2=RULE_REAL_LIT
		{
			$current.merge(this_REAL_LIT_2);
		}
		{
			newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumericRangeTermRule()); }
	iv_ruleNumericRangeTerm=ruleNumericRangeTerm
	{ $current=$iv_ruleNumericRangeTerm.current; }
	EOF;

// Rule NumericRangeTerm
ruleNumericRangeTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
				}
				lv_minimum_0_0=ruleNumAlt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
					}
					set(
						$current,
						"minimum",
						lv_minimum_0_0,
						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='..'
		{
			newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
				}
				lv_maximum_2_0=ruleNumAlt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
					}
					set(
						$current,
						"maximum",
						lv_maximum_2_0,
						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3='delta'
			{
				newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0());
					}
					lv_delta_4_0=ruleNumAlt
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
						}
						set(
							$current,
							"delta",
							lv_delta_4_0,
							"org.osate.xtext.aadl2.properties.Properties.NumAlt");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleNumAlt
entryRuleNumAlt returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumAltRule()); }
	iv_ruleNumAlt=ruleNumAlt
	{ $current=$iv_ruleNumAlt.current; }
	EOF;

// Rule NumAlt
ruleNumAlt returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
		}
		this_RealTerm_0=ruleRealTerm
		{
			$current = $this_RealTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
		}
		this_IntegerTerm_1=ruleIntegerTerm
		{
			$current = $this_IntegerTerm_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
		}
		this_SignedConstant_2=ruleSignedConstant
		{
			$current = $this_SignedConstant_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
		}
		this_ConstantValue_3=ruleConstantValue
		{
			$current = $this_ConstantValue_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAppliesToKeywords
entryRuleAppliesToKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); }
	iv_ruleAppliesToKeywords=ruleAppliesToKeywords
	{ $current=$iv_ruleAppliesToKeywords.current.getText(); }
	EOF;

// Rule AppliesToKeywords
ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='applies'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0());
		}
		kw='to'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1());
		}
	)
;

// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInBindingKeywordsRule()); }
	iv_ruleInBindingKeywords=ruleInBindingKeywords
	{ $current=$iv_ruleInBindingKeywords.current.getText(); }
	EOF;

// Rule InBindingKeywords
ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='in'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0());
		}
		kw='binding'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1());
		}
	)
;

// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInModesKeywordsRule()); }
	iv_ruleInModesKeywords=ruleInModesKeywords
	{ $current=$iv_ruleInModesKeywords.current.getText(); }
	EOF;

// Rule InModesKeywords
ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='in'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0());
		}
		kw='modes'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1());
		}
	)
;

// Entry rule entryRuleINTVALUE
entryRuleINTVALUE returns [String current=null]:
	{ newCompositeNode(grammarAccess.getINTVALUERule()); }
	iv_ruleINTVALUE=ruleINTVALUE
	{ $current=$iv_ruleINTVALUE.current.getText(); }
	EOF;

// Rule INTVALUE
ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_INTEGER_LIT_0=RULE_INTEGER_LIT
	{
		$current.merge(this_INTEGER_LIT_0);
	}
	{
		newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
	}
;

// Entry rule entryRuleQPREF
entryRuleQPREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQPREFRule()); }
	iv_ruleQPREF=ruleQPREF
	{ $current=$iv_ruleQPREF.current.getText(); }
	EOF;

// Rule QPREF
ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='::'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
			}
		)?
	)
;

// Entry rule entryRuleQCREF
entryRuleQCREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQCREFRule()); }
	iv_ruleQCREF=ruleQCREF
	{ $current=$iv_ruleQCREF.current.getText(); }
	EOF;

// Rule QCREF
ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_ID_0=RULE_ID
			{
				$current.merge(this_ID_0);
			}
			{
				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
			}
			kw='::'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
			}
		)*
		this_ID_2=RULE_ID
		{
			$current.merge(this_ID_2);
		}
		{
			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0());
			}
			this_ID_4=RULE_ID
			{
				$current.merge(this_ID_4);
			}
			{
				newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
			}
		)?
	)
;

// Entry rule entryRuleSTAR
entryRuleSTAR returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSTARRule()); }
	iv_ruleSTAR=ruleSTAR
	{ $current=$iv_ruleSTAR.current.getText(); }
	EOF;

// Rule STAR
ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='*'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
	}
;

// Rule Language
ruleLanguage returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='python'
			{
				$current = grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='java'
			{
				$current = grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='smt'
			{
				$current = grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2());
			}
		)
	)
;

// Rule MemberCallOperator
ruleMemberCallOperator returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='.'
			{
				$current = grammarAccess.getMemberCallOperatorAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getMemberCallOperatorAccess().getNORMALEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='?.'
			{
				$current = grammarAccess.getMemberCallOperatorAccess().getOPTIONALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getMemberCallOperatorAccess().getOPTIONALEnumLiteralDeclaration_1());
			}
		)
	)
;

RULE_ISTRING_TEXT : '\'\'\'' RULE_IN_ISTRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_ISTRING_LEFT : '\'\'\'' RULE_IN_ISTRING* ('\'' '\''?)? '${';

RULE_ISTRING_MIDDLE : '$}' RULE_IN_ISTRING* ('\'' '\''?)? '${';

RULE_ISTRING_RIGHT : '$}' RULE_IN_ISTRING* ('\'\'\''|('\'' '\''?)? EOF);

fragment RULE_IN_ISTRING : ('\'\'' ~('\'')|'\'' ~('\'')|'$' ~('{')|~(('\''|'$')));

RULE_SSTRING : '`' ~('`')* '`';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
