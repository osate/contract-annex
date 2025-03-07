
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
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.osate.sysmlv2.contract.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.osate.sysmlv2.contract.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.osate.sysmlv2.contract.services.ContractGrammarAccess;

}
@parser::members {
	private ContractGrammarAccess grammarAccess;

	public void setGrammarAccess(ContractGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleRoot
entryRuleRoot
:
{ before(grammarAccess.getRootRule()); }
	 ruleRoot
{ after(grammarAccess.getRootRule()); } 
	 EOF 
;

// Rule Root
ruleRoot 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRootAccess().getContractLibraryParserRuleCall()); }
		ruleContractLibrary
		{ after(grammarAccess.getRootAccess().getContractLibraryParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleContractLibrary
entryRuleContractLibrary
:
{ before(grammarAccess.getContractLibraryRule()); }
	 ruleContractLibrary
{ after(grammarAccess.getContractLibraryRule()); } 
	 EOF 
;

// Rule ContractLibrary
ruleContractLibrary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContractLibraryAccess().getGroup()); }
		(rule__ContractLibrary__Group__0)
		{ after(grammarAccess.getContractLibraryAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleContractElement
entryRuleContractElement
:
{ before(grammarAccess.getContractElementRule()); }
	 ruleContractElement
{ after(grammarAccess.getContractElementRule()); } 
	 EOF 
;

// Rule ContractElement
ruleContractElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContractElementAccess().getAlternatives()); }
		(rule__ContractElement__Alternatives)
		{ after(grammarAccess.getContractElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleContract
entryRuleContract
:
{ before(grammarAccess.getContractRule()); }
	 ruleContract
{ after(grammarAccess.getContractRule()); } 
	 EOF 
;

// Rule Contract
ruleContract 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContractAccess().getGroup()); }
		(rule__Contract__Group__0)
		{ after(grammarAccess.getContractAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Exact
ruleExact 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExactAccess().getAlternatives()); }
		(rule__Exact__Alternatives)
		{ after(grammarAccess.getExactAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Queries
ruleQueries 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQueriesAccess().getGroup()); }
		(rule__Queries__Group__0)*
		{ after(grammarAccess.getQueriesAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Domains
ruleDomains 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDomainsAccess().getGroup()); }
		(rule__Domains__Group__0)*
		{ after(grammarAccess.getDomainsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Assumptions
ruleAssumptions 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssumptionsAccess().getGroup()); }
		(rule__Assumptions__Group__0)*
		{ after(grammarAccess.getAssumptionsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Analyses
ruleAnalyses 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnalysesAccess().getGroup()); }
		(rule__Analyses__Group__0)*
		{ after(grammarAccess.getAnalysesAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInputAssumption
entryRuleInputAssumption
:
{ before(grammarAccess.getInputAssumptionRule()); }
	 ruleInputAssumption
{ after(grammarAccess.getInputAssumptionRule()); } 
	 EOF 
;

// Rule InputAssumption
ruleInputAssumption 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInputAssumptionAccess().getGroup()); }
		(rule__InputAssumption__Group__0)
		{ after(grammarAccess.getInputAssumptionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssumptionElement
entryRuleAssumptionElement
:
{ before(grammarAccess.getAssumptionElementRule()); }
	 ruleAssumptionElement
{ after(grammarAccess.getAssumptionElementRule()); } 
	 EOF 
;

// Rule AssumptionElement
ruleAssumptionElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getAlternatives()); }
		(rule__AssumptionElement__Alternatives)
		{ after(grammarAccess.getAssumptionElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleGuarantee
entryRuleGuarantee
:
{ before(grammarAccess.getGuaranteeRule()); }
	 ruleGuarantee
{ after(grammarAccess.getGuaranteeRule()); } 
	 EOF 
;

// Rule Guarantee
ruleGuarantee 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGuaranteeAccess().getCodeAssignment()); }
		(rule__Guarantee__CodeAssignment)
		{ after(grammarAccess.getGuaranteeAccess().getCodeAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnalysis
entryRuleAnalysis
:
{ before(grammarAccess.getAnalysisRule()); }
	 ruleAnalysis
{ after(grammarAccess.getAnalysisRule()); } 
	 EOF 
;

// Rule Analysis
ruleAnalysis 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnalysisAccess().getCodeAssignment()); }
		(rule__Analysis__CodeAssignment)
		{ after(grammarAccess.getAnalysisAccess().getCodeAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSource
entryRuleSource
:
{ before(grammarAccess.getSourceRule()); }
	 ruleSource
{ after(grammarAccess.getSourceRule()); } 
	 EOF 
;

// Rule Source
ruleSource 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSourceAccess().getGroup()); }
		(rule__Source__Group__0)
		{ after(grammarAccess.getSourceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleImplementation
entryRuleImplementation
:
{ before(grammarAccess.getImplementationRule()); }
	 ruleImplementation
{ after(grammarAccess.getImplementationRule()); } 
	 EOF 
;

// Rule Implementation
ruleImplementation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getImplementationAccess().getGroup()); }
		(rule__Implementation__Group__0)
		{ after(grammarAccess.getImplementationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDomain
entryRuleDomain
:
{ before(grammarAccess.getDomainRule()); }
	 ruleDomain
{ after(grammarAccess.getDomainRule()); } 
	 EOF 
;

// Rule Domain
ruleDomain 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDomainAccess().getGroup()); }
		(rule__Domain__Group__0)
		{ after(grammarAccess.getDomainAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArgument
entryRuleArgument
:
{ before(grammarAccess.getArgumentRule()); }
	 ruleArgument
{ after(grammarAccess.getArgumentRule()); } 
	 EOF 
;

// Rule Argument
ruleArgument 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentAccess().getGroup()); }
		(rule__Argument__Group__0)
		{ after(grammarAccess.getArgumentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArgumentExpression
entryRuleArgumentExpression
:
{ before(grammarAccess.getArgumentExpressionRule()); }
	 ruleArgumentExpression
{ after(grammarAccess.getArgumentExpressionRule()); } 
	 EOF 
;

// Rule ArgumentExpression
ruleArgumentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentExpressionAccess().getAlternatives()); }
		(rule__ArgumentExpression__Alternatives)
		{ after(grammarAccess.getArgumentExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArgumentAnd
entryRuleArgumentAnd
:
{ before(grammarAccess.getArgumentAndRule()); }
	 ruleArgumentAnd
{ after(grammarAccess.getArgumentAndRule()); } 
	 EOF 
;

// Rule ArgumentAnd
ruleArgumentAnd 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentAndAccess().getGroup()); }
		(rule__ArgumentAnd__Group__0)
		{ after(grammarAccess.getArgumentAndAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArgumentOr
entryRuleArgumentOr
:
{ before(grammarAccess.getArgumentOrRule()); }
	 ruleArgumentOr
{ after(grammarAccess.getArgumentOrRule()); } 
	 EOF 
;

// Rule ArgumentOr
ruleArgumentOr 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentOrAccess().getGroup()); }
		(rule__ArgumentOr__Group__0)
		{ after(grammarAccess.getArgumentOrAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArgumentNot
entryRuleArgumentNot
:
{ before(grammarAccess.getArgumentNotRule()); }
	 ruleArgumentNot
{ after(grammarAccess.getArgumentNotRule()); } 
	 EOF 
;

// Rule ArgumentNot
ruleArgumentNot 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentNotAccess().getGroup()); }
		(rule__ArgumentNot__Group__0)
		{ after(grammarAccess.getArgumentNotAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule ArgumentTerm
ruleArgumentTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArgumentTermAccess().getAlternatives()); }
		(rule__ArgumentTerm__Alternatives)
		{ after(grammarAccess.getArgumentTermAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVerificationPlan
entryRuleVerificationPlan
:
{ before(grammarAccess.getVerificationPlanRule()); }
	 ruleVerificationPlan
{ after(grammarAccess.getVerificationPlanRule()); } 
	 EOF 
;

// Rule VerificationPlan
ruleVerificationPlan 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVerificationPlanAccess().getGroup()); }
		(rule__VerificationPlan__Group__0)
		{ after(grammarAccess.getVerificationPlanAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Claims
ruleClaims 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getClaimsAccess().getGroup()); }
		(rule__Claims__Group__0)*
		{ after(grammarAccess.getClaimsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQuery
entryRuleQuery
:
{ before(grammarAccess.getQueryRule()); }
	 ruleQuery
{ after(grammarAccess.getQueryRule()); } 
	 EOF 
;

// Rule Query
ruleQuery 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQueryAccess().getAlternatives()); }
		(rule__Query__Alternatives)
		{ after(grammarAccess.getQueryAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSingleValDeclaration
entryRuleSingleValDeclaration
:
{ before(grammarAccess.getSingleValDeclarationRule()); }
	 ruleSingleValDeclaration
{ after(grammarAccess.getSingleValDeclarationRule()); } 
	 EOF 
;

// Rule SingleValDeclaration
ruleSingleValDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSingleValDeclarationAccess().getGroup()); }
		(rule__SingleValDeclaration__Group__0)
		{ after(grammarAccess.getSingleValDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTupleName
entryRuleTupleName
:
{ before(grammarAccess.getTupleNameRule()); }
	 ruleTupleName
{ after(grammarAccess.getTupleNameRule()); } 
	 EOF 
;

// Rule TupleName
ruleTupleName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTupleNameAccess().getNameAssignment()); }
		(rule__TupleName__NameAssignment)
		{ after(grammarAccess.getTupleNameAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExpression
entryRuleExpression
:
{ before(grammarAccess.getExpressionRule()); }
	 ruleExpression
{ after(grammarAccess.getExpressionRule()); } 
	 EOF 
;

// Rule Expression
ruleExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getGroup()); }
		(rule__Expression__Group__0)
		{ after(grammarAccess.getExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAndExpression
entryRuleAndExpression
:
{ before(grammarAccess.getAndExpressionRule()); }
	 ruleAndExpression
{ after(grammarAccess.getAndExpressionRule()); } 
	 EOF 
;

// Rule AndExpression
ruleAndExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAndExpressionAccess().getGroup()); }
		(rule__AndExpression__Group__0)
		{ after(grammarAccess.getAndExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNotExpression
entryRuleNotExpression
:
{ before(grammarAccess.getNotExpressionRule()); }
	 ruleNotExpression
{ after(grammarAccess.getNotExpressionRule()); } 
	 EOF 
;

// Rule NotExpression
ruleNotExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNotExpressionAccess().getAlternatives()); }
		(rule__NotExpression__Alternatives)
		{ after(grammarAccess.getNotExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCallExpression
entryRuleCallExpression
:
{ before(grammarAccess.getCallExpressionRule()); }
	 ruleCallExpression
{ after(grammarAccess.getCallExpressionRule()); } 
	 EOF 
;

// Rule CallExpression
ruleCallExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCallExpressionAccess().getGroup()); }
		(rule__CallExpression__Group__0)
		{ after(grammarAccess.getCallExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLambda
entryRuleLambda
:
{ before(grammarAccess.getLambdaRule()); }
	 ruleLambda
{ after(grammarAccess.getLambdaRule()); } 
	 EOF 
;

// Rule Lambda
ruleLambda 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLambdaAccess().getGroup()); }
		(rule__Lambda__Group__0)
		{ after(grammarAccess.getLambdaAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameter
entryRuleParameter
:
{ before(grammarAccess.getParameterRule()); }
	 ruleParameter
{ after(grammarAccess.getParameterRule()); } 
	 EOF 
;

// Rule Parameter
ruleParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterAccess().getAlternatives()); }
		(rule__Parameter__Alternatives)
		{ after(grammarAccess.getParameterAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSingleParameter
entryRuleSingleParameter
:
{ before(grammarAccess.getSingleParameterRule()); }
	 ruleSingleParameter
{ after(grammarAccess.getSingleParameterRule()); } 
	 EOF 
;

// Rule SingleParameter
ruleSingleParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSingleParameterAccess().getNameAssignment()); }
		(rule__SingleParameter__NameAssignment)
		{ after(grammarAccess.getSingleParameterAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalExpression
entryRuleTerminalExpression
:
{ before(grammarAccess.getTerminalExpressionRule()); }
	 ruleTerminalExpression
{ after(grammarAccess.getTerminalExpressionRule()); } 
	 EOF 
;

// Rule TerminalExpression
ruleTerminalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getAlternatives()); }
		(rule__TerminalExpression__Alternatives)
		{ after(grammarAccess.getTerminalExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIString
entryRuleIString
:
{ before(grammarAccess.getIStringRule()); }
	 ruleIString
{ after(grammarAccess.getIStringRule()); } 
	 EOF 
;

// Rule IString
ruleIString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringAccess().getAlternatives()); }
		(rule__IString__Alternatives)
		{ after(grammarAccess.getIStringAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIStringLiteral
entryRuleIStringLiteral
:
{ before(grammarAccess.getIStringLiteralRule()); }
	 ruleIStringLiteral
{ after(grammarAccess.getIStringLiteralRule()); } 
	 EOF 
;

// Rule IStringLiteral
ruleIStringLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringLiteralAccess().getValueAssignment()); }
		(rule__IStringLiteral__ValueAssignment)
		{ after(grammarAccess.getIStringLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIStringLeftLiteral
entryRuleIStringLeftLiteral
:
{ before(grammarAccess.getIStringLeftLiteralRule()); }
	 ruleIStringLeftLiteral
{ after(grammarAccess.getIStringLeftLiteralRule()); } 
	 EOF 
;

// Rule IStringLeftLiteral
ruleIStringLeftLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringLeftLiteralAccess().getValueAssignment()); }
		(rule__IStringLeftLiteral__ValueAssignment)
		{ after(grammarAccess.getIStringLeftLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIStringMiddleLiteral
entryRuleIStringMiddleLiteral
:
{ before(grammarAccess.getIStringMiddleLiteralRule()); }
	 ruleIStringMiddleLiteral
{ after(grammarAccess.getIStringMiddleLiteralRule()); } 
	 EOF 
;

// Rule IStringMiddleLiteral
ruleIStringMiddleLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringMiddleLiteralAccess().getValueAssignment()); }
		(rule__IStringMiddleLiteral__ValueAssignment)
		{ after(grammarAccess.getIStringMiddleLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIStringRightLiteral
entryRuleIStringRightLiteral
:
{ before(grammarAccess.getIStringRightLiteralRule()); }
	 ruleIStringRightLiteral
{ after(grammarAccess.getIStringRightLiteralRule()); } 
	 EOF 
;

// Rule IStringRightLiteral
ruleIStringRightLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringRightLiteralAccess().getValueAssignment()); }
		(rule__IStringRightLiteral__ValueAssignment)
		{ after(grammarAccess.getIStringRightLiteralAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIStringInter
entryRuleIStringInter
:
{ before(grammarAccess.getIStringInterRule()); }
	 ruleIStringInter
{ after(grammarAccess.getIStringInterRule()); } 
	 EOF 
;

// Rule IStringInter
ruleIStringInter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIStringInterAccess().getGroup()); }
		(rule__IStringInter__Group__0)
		{ after(grammarAccess.getIStringInterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQPREF
entryRuleQPREF
:
{ before(grammarAccess.getQPREFRule()); }
	 ruleQPREF
{ after(grammarAccess.getQPREFRule()); } 
	 EOF 
;

// Rule QPREF
ruleQPREF 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQPREFAccess().getGroup()); }
		(rule__QPREF__Group__0)
		{ after(grammarAccess.getQPREFAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQCREF
entryRuleQCREF
:
{ before(grammarAccess.getQCREFRule()); }
	 ruleQCREF
{ after(grammarAccess.getQCREFRule()); } 
	 EOF 
;

// Rule QCREF
ruleQCREF 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQCREFAccess().getGroup()); }
		(rule__QCREF__Group__0)
		{ after(grammarAccess.getQCREFAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule Language
ruleLanguage
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLanguageAccess().getAlternatives()); }
		(rule__Language__Alternatives)
		{ after(grammarAccess.getLanguageAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule Predefined
rulePredefined
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredefinedAccess().getAlternatives()); }
		(rule__Predefined__Alternatives)
		{ after(grammarAccess.getPredefinedAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractElementAccess().getImplementationParserRuleCall_0()); }
		ruleImplementation
		{ after(grammarAccess.getContractElementAccess().getImplementationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getContractElementAccess().getDomainParserRuleCall_1()); }
		ruleDomain
		{ after(grammarAccess.getContractElementAccess().getDomainParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getContractElementAccess().getArgumentParserRuleCall_2()); }
		ruleArgument
		{ after(grammarAccess.getContractElementAccess().getArgumentParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getContractElementAccess().getContractParserRuleCall_3()); }
		ruleContract
		{ after(grammarAccess.getContractElementAccess().getContractParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getContractElementAccess().getVerificationPlanParserRuleCall_4()); }
		ruleVerificationPlan
		{ after(grammarAccess.getContractElementAccess().getVerificationPlanParserRuleCall_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Alternatives_8_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractAccess().getInvocationKeyword_8_0_0()); }
		'invocation'
		{ after(grammarAccess.getContractAccess().getInvocationKeyword_8_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getContractAccess().getAnalysisKeyword_8_0_1()); }
		'analysis'
		{ after(grammarAccess.getContractAccess().getAnalysisKeyword_8_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exact__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExactAccess().getEqualsSignGreaterThanSignKeyword_0()); }
		'=>'
		{ after(grammarAccess.getExactAccess().getEqualsSignGreaterThanSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getExactAccess().getExactAssignment_1()); }
		(rule__Exact__ExactAssignment_1)
		{ after(grammarAccess.getExactAccess().getExactAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getGroup_0()); }
		(rule__AssumptionElement__Group_0__0)
		{ after(grammarAccess.getAssumptionElementAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssumptionElementAccess().getGroup_1()); }
		(rule__AssumptionElement__Group_1__0)
		{ after(grammarAccess.getAssumptionElementAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getAssumptionElementAccess().getGroup_2()); }
		(rule__AssumptionElement__Group_2__0)
		{ after(grammarAccess.getAssumptionElementAccess().getGroup_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSourceAccess().getSourceAssignment_1_0()); }
		(rule__Source__SourceAssignment_1_0)
		{ after(grammarAccess.getSourceAccess().getSourceAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getSourceAccess().getInterAssignment_1_1()); }
		(rule__Source__InterAssignment_1_1)
		{ after(grammarAccess.getSourceAccess().getInterAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentExpressionAccess().getArgumentOrParserRuleCall_0()); }
		ruleArgumentOr
		{ after(grammarAccess.getArgumentExpressionAccess().getArgumentOrParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentExpressionAccess().getArgumentAndParserRuleCall_1()); }
		ruleArgumentAnd
		{ after(grammarAccess.getArgumentExpressionAccess().getArgumentAndParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentExpressionAccess().getArgumentNotParserRuleCall_2()); }
		ruleArgumentNot
		{ after(grammarAccess.getArgumentExpressionAccess().getArgumentNotParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_0()); }
		ruleArgumentTerm
		{ after(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentNotAccess().getGroup_2_1()); }
		(rule__ArgumentNot__Group_2_1__0)
		{ after(grammarAccess.getArgumentNotAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentTermAccess().getGroup_0()); }
		(rule__ArgumentTerm__Group_0__0)
		{ after(grammarAccess.getArgumentTermAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentTermAccess().getGroup_1()); }
		(rule__ArgumentTerm__Group_1__0)
		{ after(grammarAccess.getArgumentTermAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentTermAccess().getNestedAssignment_2()); }
		(rule__ArgumentTerm__NestedAssignment_2)
		{ after(grammarAccess.getArgumentTermAccess().getNestedAssignment_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getSingleValDeclarationParserRuleCall_0()); }
		ruleSingleValDeclaration
		{ after(grammarAccess.getQueryAccess().getSingleValDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getQueryAccess().getGroup_1()); }
		(rule__Query__Group_1__0)
		{ after(grammarAccess.getQueryAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNotExpressionAccess().getCallExpressionParserRuleCall_0()); }
		ruleCallExpression
		{ after(grammarAccess.getNotExpressionAccess().getCallExpressionParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNotExpressionAccess().getGroup_1()); }
		(rule__NotExpression__Group_1__0)
		{ after(grammarAccess.getNotExpressionAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getGroup_1_0()); }
		(rule__CallExpression__Group_1_0__0)
		{ after(grammarAccess.getCallExpressionAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getCallExpressionAccess().getGroup_1_1()); }
		(rule__CallExpression__Group_1_1__0)
		{ after(grammarAccess.getCallExpressionAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getSingleParameterParserRuleCall_0()); }
		ruleSingleParameter
		{ after(grammarAccess.getParameterAccess().getSingleParameterParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getParameterAccess().getGroup_1()); }
		(rule__Parameter__Group_1__0)
		{ after(grammarAccess.getParameterAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_0()); }
		(rule__TerminalExpression__Group_0__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_1()); }
		(rule__TerminalExpression__Group_1__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_2()); }
		(rule__TerminalExpression__Group_2__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_3()); }
		(rule__TerminalExpression__Group_3__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_3()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_4()); }
		(rule__TerminalExpression__Group_4__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsAssignment_0()); }
		(rule__IString__PartsAssignment_0)
		{ after(grammarAccess.getIStringAccess().getPartsAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getIStringAccess().getGroup_1()); }
		(rule__IString__Group_1__0)
		{ after(grammarAccess.getIStringAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringInterAccess().getGroup_1_0()); }
		(rule__IStringInter__Group_1_0__0)
		{ after(grammarAccess.getIStringInterAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getIStringInterAccess().getPredefinedAssignment_1_1()); }
		(rule__IStringInter__PredefinedAssignment_1_1)
		{ after(grammarAccess.getIStringInterAccess().getPredefinedAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Language__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0()); }
		('python')
		{ after(grammarAccess.getLanguageAccess().getPYTHONEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1()); }
		('java')
		{ after(grammarAccess.getLanguageAccess().getJAVAEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2()); }
		('smt')
		{ after(grammarAccess.getLanguageAccess().getSMTEnumLiteralDeclaration_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Predefined__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredefinedAccess().getERROREnumLiteralDeclaration_0()); }
		('error0')
		{ after(grammarAccess.getPredefinedAccess().getERROREnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredefinedAccess().getINFOEnumLiteralDeclaration_1()); }
		('info0')
		{ after(grammarAccess.getPredefinedAccess().getINFOEnumLiteralDeclaration_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractLibrary__Group__0__Impl
	rule__ContractLibrary__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractLibraryAccess().getPackageKeyword_0()); }
	'package'
	{ after(grammarAccess.getContractLibraryAccess().getPackageKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractLibrary__Group__1__Impl
	rule__ContractLibrary__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractLibraryAccess().getNameAssignment_1()); }
	(rule__ContractLibrary__NameAssignment_1)
	{ after(grammarAccess.getContractLibraryAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractLibrary__Group__2__Impl
	rule__ContractLibrary__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractLibraryAccess().getSemicolonKeyword_2()); }
	';'
	{ after(grammarAccess.getContractLibraryAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractLibrary__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_3()); }
	(rule__ContractLibrary__ContractElementsAssignment_3)*
	{ after(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__0__Impl
	rule__Contract__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getContractKeyword_0()); }
	'contract'
	{ after(grammarAccess.getContractAccess().getContractKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__1__Impl
	rule__Contract__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getNameAssignment_1()); }
	(rule__Contract__NameAssignment_1)
	{ after(grammarAccess.getContractAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__2__Impl
	rule__Contract__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__3__Impl
	rule__Contract__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_3()); }
	(rule__Contract__Group_3__0)?
	{ after(grammarAccess.getContractAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__4__Impl
	rule__Contract__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_4()); }
	(rule__Contract__Group_4__0)?
	{ after(grammarAccess.getContractAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__5__Impl
	rule__Contract__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_5()); }
	(rule__Contract__Group_5__0)?
	{ after(grammarAccess.getContractAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__6__Impl
	rule__Contract__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_6()); }
	(rule__Contract__Group_6__0)?
	{ after(grammarAccess.getContractAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__7__Impl
	rule__Contract__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_7()); }
	(rule__Contract__Group_7__0)?
	{ after(grammarAccess.getContractAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__8__Impl
	rule__Contract__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGroup_8()); }
	(rule__Contract__Group_8__0)?
	{ after(grammarAccess.getContractAccess().getGroup_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getRightCurlyBracketKeyword_9()); }
	'}'
	{ after(grammarAccess.getContractAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_3__0__Impl
	rule__Contract__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getDomainsKeyword_3_0()); }
	'domains'
	{ after(grammarAccess.getContractAccess().getDomainsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getDomainsParserRuleCall_3_1()); }
	ruleDomains
	{ after(grammarAccess.getContractAccess().getDomainsParserRuleCall_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_4__0__Impl
	rule__Contract__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getQueriesKeyword_4_0()); }
	'queries'
	{ after(grammarAccess.getContractAccess().getQueriesKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getQueriesParserRuleCall_4_1()); }
	ruleQueries
	{ after(grammarAccess.getContractAccess().getQueriesParserRuleCall_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_5__0__Impl
	rule__Contract__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getInputKeyword_5_0()); }
	'input'
	{ after(grammarAccess.getContractAccess().getInputKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_5__1__Impl
	rule__Contract__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getAssumptionsKeyword_5_1()); }
	'assumptions'
	{ after(grammarAccess.getContractAccess().getAssumptionsKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getInputsAssignment_5_2()); }
	(rule__Contract__InputsAssignment_5_2)*
	{ after(grammarAccess.getContractAccess().getInputsAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_6__0__Impl
	rule__Contract__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getAssumptionsKeyword_6_0()); }
	'assumptions'
	{ after(grammarAccess.getContractAccess().getAssumptionsKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getAssumptionsParserRuleCall_6_1()); }
	ruleAssumptions
	{ after(grammarAccess.getContractAccess().getAssumptionsParserRuleCall_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_7__0__Impl
	rule__Contract__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGuaranteeKeyword_7_0()); }
	'guarantee'
	{ after(grammarAccess.getContractAccess().getGuaranteeKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_7__1__Impl
	rule__Contract__Group_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getExactParserRuleCall_7_1()); }
	ruleExact
	{ after(grammarAccess.getContractAccess().getExactParserRuleCall_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_7__2__Impl
	rule__Contract__Group_7__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getGuaranteeAssignment_7_2()); }
	(rule__Contract__GuaranteeAssignment_7_2)
	{ after(grammarAccess.getContractAccess().getGuaranteeAssignment_7_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_7__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_7__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getSemicolonKeyword_7_3()); }
	';'
	{ after(grammarAccess.getContractAccess().getSemicolonKeyword_7_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Contract__Group_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_8__0__Impl
	rule__Contract__Group_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getAlternatives_8_0()); }
	(rule__Contract__Alternatives_8_0)
	{ after(grammarAccess.getContractAccess().getAlternatives_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Contract__Group_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__Group_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractAccess().getAnalysesParserRuleCall_8_1()); }
	ruleAnalyses
	{ after(grammarAccess.getContractAccess().getAnalysesParserRuleCall_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Queries__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Queries__Group__0__Impl
	rule__Queries__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Queries__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueriesAccess().getQueriesAssignment_0()); }
	(rule__Queries__QueriesAssignment_0)?
	{ after(grammarAccess.getQueriesAccess().getQueriesAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Queries__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Queries__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Queries__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueriesAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getQueriesAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Domains__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domains__Group__0__Impl
	rule__Domains__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Domains__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainsAccess().getDomainsAssignment_0()); }
	(rule__Domains__DomainsAssignment_0)?
	{ after(grammarAccess.getDomainsAccess().getDomainsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domains__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domains__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Domains__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainsAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getDomainsAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Assumptions__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assumptions__Group__0__Impl
	rule__Assumptions__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Assumptions__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionsAccess().getAssumptionsAssignment_0()); }
	(rule__Assumptions__AssumptionsAssignment_0)?
	{ after(grammarAccess.getAssumptionsAccess().getAssumptionsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assumptions__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assumptions__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Assumptions__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Analyses__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Analyses__Group__0__Impl
	rule__Analyses__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Analyses__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnalysesAccess().getAnalysesAssignment_0()); }
	(rule__Analyses__AnalysesAssignment_0)?
	{ after(grammarAccess.getAnalysesAccess().getAnalysesAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Analyses__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Analyses__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Analyses__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnalysesAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getAnalysesAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InputAssumption__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InputAssumption__Group__0__Impl
	rule__InputAssumption__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInputAssumptionAccess().getInputAssumptionAction_0()); }
	()
	{ after(grammarAccess.getInputAssumptionAccess().getInputAssumptionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InputAssumption__Group__1__Impl
	rule__InputAssumption__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInputAssumptionAccess().getCodeAssignment_1()); }
	(rule__InputAssumption__CodeAssignment_1)?
	{ after(grammarAccess.getInputAssumptionAccess().getCodeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InputAssumption__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInputAssumptionAccess().getSemicolonKeyword_2()); }
	';'
	{ after(grammarAccess.getInputAssumptionAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssumptionElement__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_0__0__Impl
	rule__AssumptionElement__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getContractAssumptionAction_0_0()); }
	()
	{ after(grammarAccess.getAssumptionElementAccess().getContractAssumptionAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_0__1__Impl
	rule__AssumptionElement__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getContractKeyword_0_1()); }
	'contract'
	{ after(grammarAccess.getAssumptionElementAccess().getContractKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getContractAssignment_0_2()); }
	(rule__AssumptionElement__ContractAssignment_0_2)
	{ after(grammarAccess.getAssumptionElementAccess().getContractAssignment_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssumptionElement__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_1__0__Impl
	rule__AssumptionElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getArgumentAssumptionAction_1_0()); }
	()
	{ after(grammarAccess.getAssumptionElementAccess().getArgumentAssumptionAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_1__1__Impl
	rule__AssumptionElement__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getArgumentKeyword_1_1()); }
	'argument'
	{ after(grammarAccess.getAssumptionElementAccess().getArgumentKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getArgumentAssignment_1_2()); }
	(rule__AssumptionElement__ArgumentAssignment_1_2)
	{ after(grammarAccess.getAssumptionElementAccess().getArgumentAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssumptionElement__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_2__0__Impl
	rule__AssumptionElement__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getCodeAssumptionAction_2_0()); }
	()
	{ after(grammarAccess.getAssumptionElementAccess().getCodeAssumptionAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_2__1__Impl
	rule__AssumptionElement__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getCodeAssignment_2_1()); }
	(rule__AssumptionElement__CodeAssignment_2_1)
	{ after(grammarAccess.getAssumptionElementAccess().getCodeAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getGroup_2_2()); }
	(rule__AssumptionElement__Group_2_2__0)?
	{ after(grammarAccess.getAssumptionElementAccess().getGroup_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssumptionElement__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_2_2__0__Impl
	rule__AssumptionElement__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getExactParserRuleCall_2_2_0()); }
	ruleExact
	{ after(grammarAccess.getAssumptionElementAccess().getExactParserRuleCall_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssumptionElement__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssumptionElementAccess().getGuaranteeAssignment_2_2_1()); }
	(rule__AssumptionElement__GuaranteeAssignment_2_2_1)
	{ after(grammarAccess.getAssumptionElementAccess().getGuaranteeAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Source__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group__0__Impl
	rule__Source__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getLanguageAssignment_0()); }
	(rule__Source__LanguageAssignment_0)?
	{ after(grammarAccess.getSourceAccess().getLanguageAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Source__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSourceAccess().getAlternatives_1()); }
	(rule__Source__Alternatives_1)
	{ after(grammarAccess.getSourceAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Implementation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__0__Impl
	rule__Implementation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getContractKeyword_0()); }
	'contract'
	{ after(grammarAccess.getImplementationAccess().getContractKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__1__Impl
	rule__Implementation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getImplementationKeyword_1()); }
	'implementation'
	{ after(grammarAccess.getImplementationAccess().getImplementationKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__2__Impl
	rule__Implementation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getNameAssignment_2()); }
	(rule__Implementation__NameAssignment_2)
	{ after(grammarAccess.getImplementationAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__3__Impl
	rule__Implementation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getImplementationAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__4__Impl
	rule__Implementation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getCodeAssignment_4()); }
	(rule__Implementation__CodeAssignment_4)
	{ after(grammarAccess.getImplementationAccess().getCodeAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Implementation__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getImplementationAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getImplementationAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Domain__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__0__Impl
	rule__Domain__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getDomainKeyword_0()); }
	'domain'
	{ after(grammarAccess.getDomainAccess().getDomainKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__1__Impl
	rule__Domain__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getNameAssignment_1()); }
	(rule__Domain__NameAssignment_1)
	{ after(grammarAccess.getDomainAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__2__Impl
	rule__Domain__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getDomainAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__3__Impl
	rule__Domain__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getGroup_3()); }
	(rule__Domain__Group_3__0)?
	{ after(grammarAccess.getDomainAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__4__Impl
	rule__Domain__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getGroup_4()); }
	(rule__Domain__Group_4__0)?
	{ after(grammarAccess.getDomainAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getDomainAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Domain__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group_3__0__Impl
	rule__Domain__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getQueriesKeyword_3_0()); }
	'queries'
	{ after(grammarAccess.getDomainAccess().getQueriesKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getQueriesParserRuleCall_3_1()); }
	ruleQueries
	{ after(grammarAccess.getDomainAccess().getQueriesParserRuleCall_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Domain__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group_4__0__Impl
	rule__Domain__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getDeclarationsKeyword_4_0()); }
	'declarations'
	{ after(grammarAccess.getDomainAccess().getDeclarationsKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Domain__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDomainAccess().getCodeAssignment_4_1()); }
	(rule__Domain__CodeAssignment_4_1)
	{ after(grammarAccess.getDomainAccess().getCodeAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Argument__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__0__Impl
	rule__Argument__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getArgumentKeyword_0()); }
	'argument'
	{ after(grammarAccess.getArgumentAccess().getArgumentKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__1__Impl
	rule__Argument__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getNameAssignment_1()); }
	(rule__Argument__NameAssignment_1)
	{ after(grammarAccess.getArgumentAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__2__Impl
	rule__Argument__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getArgumentAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__3__Impl
	rule__Argument__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getGroup_3()); }
	(rule__Argument__Group_3__0)?
	{ after(grammarAccess.getArgumentAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__4__Impl
	rule__Argument__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getGroup_4()); }
	(rule__Argument__Group_4__0)?
	{ after(grammarAccess.getArgumentAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__5__Impl
	rule__Argument__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getGroup_5()); }
	(rule__Argument__Group_5__0)?
	{ after(grammarAccess.getArgumentAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getArgumentAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Argument__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_3__0__Impl
	rule__Argument__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getDomainsKeyword_3_0()); }
	'domains'
	{ after(grammarAccess.getArgumentAccess().getDomainsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getDomainsParserRuleCall_3_1()); }
	ruleDomains
	{ after(grammarAccess.getArgumentAccess().getDomainsParserRuleCall_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Argument__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_4__0__Impl
	rule__Argument__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getGuaranteeKeyword_4_0()); }
	'guarantee'
	{ after(grammarAccess.getArgumentAccess().getGuaranteeKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_4__1__Impl
	rule__Argument__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getExactParserRuleCall_4_1()); }
	ruleExact
	{ after(grammarAccess.getArgumentAccess().getExactParserRuleCall_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_4__2__Impl
	rule__Argument__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getGuaranteeAssignment_4_2()); }
	(rule__Argument__GuaranteeAssignment_4_2)
	{ after(grammarAccess.getArgumentAccess().getGuaranteeAssignment_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getSemicolonKeyword_4_3()); }
	';'
	{ after(grammarAccess.getArgumentAccess().getSemicolonKeyword_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Argument__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_5__0__Impl
	rule__Argument__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getArgumentKeyword_5_0()); }
	'argument'
	{ after(grammarAccess.getArgumentAccess().getArgumentKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_5__1__Impl
	rule__Argument__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getArgumentExpressionAssignment_5_1()); }
	(rule__Argument__ArgumentExpressionAssignment_5_1)
	{ after(grammarAccess.getArgumentAccess().getArgumentExpressionAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Argument__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAccess().getSemicolonKeyword_5_2()); }
	';'
	{ after(grammarAccess.getArgumentAccess().getSemicolonKeyword_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentAnd__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__0__Impl
	rule__ArgumentAnd__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getArgumentAndAction_0()); }
	()
	{ after(grammarAccess.getArgumentAndAccess().getArgumentAndAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__1__Impl
	rule__ArgumentAnd__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getAndKeyword_1()); }
	'and'
	{ after(grammarAccess.getArgumentAndAccess().getAndKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__2__Impl
	rule__ArgumentAnd__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getArgumentAndAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__3__Impl
	rule__ArgumentAnd__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_3()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__4__Impl
	rule__ArgumentAnd__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getGroup_4()); }
	(rule__ArgumentAnd__Group_4__0)*
	{ after(grammarAccess.getArgumentAndAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getArgumentAndAccess().getRightParenthesisKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentAnd__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group_4__0__Impl
	rule__ArgumentAnd__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getCommaKeyword_4_0()); }
	(',')?
	{ after(grammarAccess.getArgumentAndAccess().getCommaKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentAnd__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentAnd__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_4_1()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentAndAccess().getArgumentTermParserRuleCall_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentOr__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__0__Impl
	rule__ArgumentOr__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getArgumentOrAction_0()); }
	()
	{ after(grammarAccess.getArgumentOrAccess().getArgumentOrAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__1__Impl
	rule__ArgumentOr__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getOrKeyword_1()); }
	'or'
	{ after(grammarAccess.getArgumentOrAccess().getOrKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__2__Impl
	rule__ArgumentOr__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getArgumentOrAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__3__Impl
	rule__ArgumentOr__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_3()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__4__Impl
	rule__ArgumentOr__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getGroup_4()); }
	(rule__ArgumentOr__Group_4__0)*
	{ after(grammarAccess.getArgumentOrAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getArgumentOrAccess().getRightParenthesisKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentOr__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group_4__0__Impl
	rule__ArgumentOr__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getCommaKeyword_4_0()); }
	(',')?
	{ after(grammarAccess.getArgumentOrAccess().getCommaKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentOr__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentOr__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_4_1()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentOrAccess().getArgumentTermParserRuleCall_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentNot__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group__0__Impl
	rule__ArgumentNot__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getArgumentNotAction_0()); }
	()
	{ after(grammarAccess.getArgumentNotAccess().getArgumentNotAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group__1__Impl
	rule__ArgumentNot__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getNotKeyword_1()); }
	'not'
	{ after(grammarAccess.getArgumentNotAccess().getNotKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getAlternatives_2()); }
	(rule__ArgumentNot__Alternatives_2)
	{ after(grammarAccess.getArgumentNotAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentNot__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_2_1__0__Impl
	rule__ArgumentNot__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_2_1_0()); }
	'('
	{ after(grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_2_1__1__Impl
	rule__ArgumentNot__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_1_1()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_2_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_2_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_2_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getRightParenthesisKeyword_2_1_2()); }
	')'
	{ after(grammarAccess.getArgumentNotAccess().getRightParenthesisKeyword_2_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentTerm__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentTerm__Group_0__0__Impl
	rule__ArgumentTerm__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentTermAccess().getContractKeyword_0_0()); }
	'contract'
	{ after(grammarAccess.getArgumentTermAccess().getContractKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentTerm__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentTermAccess().getContractsAssignment_0_1()); }
	(rule__ArgumentTerm__ContractsAssignment_0_1)
	{ after(grammarAccess.getArgumentTermAccess().getContractsAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentTerm__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentTerm__Group_1__0__Impl
	rule__ArgumentTerm__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentTermAccess().getArgumentKeyword_1_0()); }
	'argument'
	{ after(grammarAccess.getArgumentTermAccess().getArgumentKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentTerm__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentTermAccess().getArgumentsAssignment_1_1()); }
	(rule__ArgumentTerm__ArgumentsAssignment_1_1)
	{ after(grammarAccess.getArgumentTermAccess().getArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VerificationPlan__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__0__Impl
	rule__VerificationPlan__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0()); }
	'verification'
	{ after(grammarAccess.getVerificationPlanAccess().getVerificationKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__1__Impl
	rule__VerificationPlan__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getPlanKeyword_1()); }
	'plan'
	{ after(grammarAccess.getVerificationPlanAccess().getPlanKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__2__Impl
	rule__VerificationPlan__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getNameAssignment_2()); }
	(rule__VerificationPlan__NameAssignment_2)
	{ after(grammarAccess.getVerificationPlanAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__3__Impl
	rule__VerificationPlan__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getVerificationPlanAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__4__Impl
	rule__VerificationPlan__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getComponentKeyword_4()); }
	'component'
	{ after(grammarAccess.getVerificationPlanAccess().getComponentKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__5__Impl
	rule__VerificationPlan__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getIDTerminalRuleCall_5()); }
	RULE_ID
	{ after(grammarAccess.getVerificationPlanAccess().getIDTerminalRuleCall_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__6__Impl
	rule__VerificationPlan__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getColonKeyword_6()); }
	':'
	{ after(grammarAccess.getVerificationPlanAccess().getColonKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__7__Impl
	rule__VerificationPlan__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getComponentImplementationAssignment_7()); }
	(rule__VerificationPlan__ComponentImplementationAssignment_7)
	{ after(grammarAccess.getVerificationPlanAccess().getComponentImplementationAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__8__Impl
	rule__VerificationPlan__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_8()); }
	';'
	{ after(grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__9__Impl
	rule__VerificationPlan__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getGroup_9()); }
	(rule__VerificationPlan__Group_9__0)?
	{ after(grammarAccess.getVerificationPlanAccess().getGroup_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__10__Impl
	rule__VerificationPlan__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getGroup_10()); }
	(rule__VerificationPlan__Group_10__0)?
	{ after(grammarAccess.getVerificationPlanAccess().getGroup_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__11__Impl
	rule__VerificationPlan__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getGroup_11()); }
	(rule__VerificationPlan__Group_11__0)?
	{ after(grammarAccess.getVerificationPlanAccess().getGroup_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group__12__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getRightCurlyBracketKeyword_12()); }
	'}'
	{ after(grammarAccess.getVerificationPlanAccess().getRightCurlyBracketKeyword_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VerificationPlan__Group_9__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_9__0__Impl
	rule__VerificationPlan__Group_9__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_9__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getDomainsKeyword_9_0()); }
	'domains'
	{ after(grammarAccess.getVerificationPlanAccess().getDomainsKeyword_9_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_9__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_9__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getDomainsParserRuleCall_9_1()); }
	ruleDomains
	{ after(grammarAccess.getVerificationPlanAccess().getDomainsParserRuleCall_9_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VerificationPlan__Group_10__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_10__0__Impl
	rule__VerificationPlan__Group_10__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_10__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getClaimsKeyword_10_0()); }
	'claims'
	{ after(grammarAccess.getVerificationPlanAccess().getClaimsKeyword_10_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_10__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_10__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getClaimsParserRuleCall_10_1()); }
	ruleClaims
	{ after(grammarAccess.getVerificationPlanAccess().getClaimsParserRuleCall_10_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VerificationPlan__Group_11__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_11__0__Impl
	rule__VerificationPlan__Group_11__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getContractsKeyword_11_0()); }
	'contracts'
	{ after(grammarAccess.getVerificationPlanAccess().getContractsKeyword_11_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getGroup_11_1()); }
	(rule__VerificationPlan__Group_11_1__0)*
	{ after(grammarAccess.getVerificationPlanAccess().getGroup_11_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VerificationPlan__Group_11_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_11_1__0__Impl
	rule__VerificationPlan__Group_11_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getContractsAssignment_11_1_0()); }
	(rule__VerificationPlan__ContractsAssignment_11_1_0)?
	{ after(grammarAccess.getVerificationPlanAccess().getContractsAssignment_11_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VerificationPlan__Group_11_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__Group_11_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_11_1_1()); }
	';'
	{ after(grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_11_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Claims__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Claims__Group__0__Impl
	rule__Claims__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Claims__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClaimsAccess().getClaimsAssignment_0()); }
	(rule__Claims__ClaimsAssignment_0)?
	{ after(grammarAccess.getClaimsAccess().getClaimsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Claims__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Claims__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Claims__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClaimsAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getClaimsAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Query__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__0__Impl
	rule__Query__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getTupleDeclarationAction_1_0()); }
	()
	{ after(grammarAccess.getQueryAccess().getTupleDeclarationAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__1__Impl
	rule__Query__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getValKeyword_1_1()); }
	'val'
	{ after(grammarAccess.getQueryAccess().getValKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__2__Impl
	rule__Query__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getLeftParenthesisKeyword_1_2()); }
	'('
	{ after(grammarAccess.getQueryAccess().getLeftParenthesisKeyword_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__3__Impl
	rule__Query__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getNamesAssignment_1_3()); }
	(rule__Query__NamesAssignment_1_3)
	{ after(grammarAccess.getQueryAccess().getNamesAssignment_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__4__Impl
	rule__Query__Group_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getQueryAccess().getGroup_1_4()); }
		(rule__Query__Group_1_4__0)
		{ after(grammarAccess.getQueryAccess().getGroup_1_4()); }
	)
	(
		{ before(grammarAccess.getQueryAccess().getGroup_1_4()); }
		(rule__Query__Group_1_4__0)*
		{ after(grammarAccess.getQueryAccess().getGroup_1_4()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__5__Impl
	rule__Query__Group_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getRightParenthesisKeyword_1_5()); }
	')'
	{ after(grammarAccess.getQueryAccess().getRightParenthesisKeyword_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__6__Impl
	rule__Query__Group_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getEqualsSignKeyword_1_6()); }
	'='
	{ after(grammarAccess.getQueryAccess().getEqualsSignKeyword_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getValueAssignment_1_7()); }
	(rule__Query__ValueAssignment_1_7)
	{ after(grammarAccess.getQueryAccess().getValueAssignment_1_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Query__Group_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1_4__0__Impl
	rule__Query__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getCommaKeyword_1_4_0()); }
	','
	{ after(grammarAccess.getQueryAccess().getCommaKeyword_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Query__Group_1_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__Group_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQueryAccess().getNamesAssignment_1_4_1()); }
	(rule__Query__NamesAssignment_1_4_1)
	{ after(grammarAccess.getQueryAccess().getNamesAssignment_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SingleValDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingleValDeclaration__Group__0__Impl
	rule__SingleValDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingleValDeclarationAccess().getValKeyword_0()); }
	'val'
	{ after(grammarAccess.getSingleValDeclarationAccess().getValKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingleValDeclaration__Group__1__Impl
	rule__SingleValDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingleValDeclarationAccess().getNameAssignment_1()); }
	(rule__SingleValDeclaration__NameAssignment_1)
	{ after(grammarAccess.getSingleValDeclarationAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingleValDeclaration__Group__2__Impl
	rule__SingleValDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingleValDeclarationAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getSingleValDeclarationAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SingleValDeclaration__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSingleValDeclarationAccess().getValueAssignment_3()); }
	(rule__SingleValDeclaration__ValueAssignment_3)
	{ after(grammarAccess.getSingleValDeclarationAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Expression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group__0__Impl
	rule__Expression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0()); }
	ruleAndExpression
	{ after(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getGroup_1()); }
	(rule__Expression__Group_1__0)*
	{ after(grammarAccess.getExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Expression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group_1__0__Impl
	rule__Expression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group_1__1__Impl
	rule__Expression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1()); }
	'||'
	{ after(grammarAccess.getExpressionAccess().getVerticalLineVerticalLineKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Expression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getRightAssignment_1_2()); }
	(rule__Expression__RightAssignment_1_2)
	{ after(grammarAccess.getExpressionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AndExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndExpression__Group__0__Impl
	rule__AndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0()); }
	ruleNotExpression
	{ after(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndExpressionAccess().getGroup_1()); }
	(rule__AndExpression__Group_1__0)*
	{ after(grammarAccess.getAndExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AndExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndExpression__Group_1__0__Impl
	rule__AndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndExpression__Group_1__1__Impl
	rule__AndExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1()); }
	'&&'
	{ after(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AndExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); }
	(rule__AndExpression__RightAssignment_1_2)
	{ after(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NotExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NotExpression__Group_1__0__Impl
	rule__NotExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0()); }
	()
	{ after(grammarAccess.getNotExpressionAccess().getNotExpressionAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NotExpression__Group_1__1__Impl
	rule__NotExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1()); }
	'!'
	{ after(grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NotExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNotExpressionAccess().getOperandAssignment_1_2()); }
	(rule__NotExpression__OperandAssignment_1_2)
	{ after(grammarAccess.getNotExpressionAccess().getOperandAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CallExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group__0__Impl
	rule__CallExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getTerminalExpressionParserRuleCall_0()); }
	ruleTerminalExpression
	{ after(grammarAccess.getCallExpressionAccess().getTerminalExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getAlternatives_1()); }
	(rule__CallExpression__Alternatives_1)*
	{ after(grammarAccess.getCallExpressionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CallExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__0__Impl
	rule__CallExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getMemberCallLeftAction_1_0_0()); }
	()
	{ after(grammarAccess.getCallExpressionAccess().getMemberCallLeftAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__1__Impl
	rule__CallExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getFullStopKeyword_1_0_1()); }
	'.'
	{ after(grammarAccess.getCallExpressionAccess().getFullStopKeyword_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__2__Impl
	rule__CallExpression__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getRightAssignment_1_0_2()); }
	(rule__CallExpression__RightAssignment_1_0_2)
	{ after(grammarAccess.getCallExpressionAccess().getRightAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__3__Impl
	rule__CallExpression__Group_1_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getGroup_1_0_3()); }
	(rule__CallExpression__Group_1_0_3__0)?
	{ after(grammarAccess.getCallExpressionAccess().getGroup_1_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__4__Impl
	rule__CallExpression__Group_1_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getGroup_1_0_4()); }
	(rule__CallExpression__Group_1_0_4__0)?
	{ after(grammarAccess.getCallExpressionAccess().getGroup_1_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getLambdaAssignment_1_0_5()); }
	(rule__CallExpression__LambdaAssignment_1_0_5)?
	{ after(grammarAccess.getCallExpressionAccess().getLambdaAssignment_1_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CallExpression__Group_1_0_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_3__0__Impl
	rule__CallExpression__Group_1_0_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getLessThanSignKeyword_1_0_3_0()); }
	'<'
	{ after(grammarAccess.getCallExpressionAccess().getLessThanSignKeyword_1_0_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_3__1__Impl
	rule__CallExpression__Group_1_0_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getTypeArgumentAssignment_1_0_3_1()); }
	(rule__CallExpression__TypeArgumentAssignment_1_0_3_1)
	{ after(grammarAccess.getCallExpressionAccess().getTypeArgumentAssignment_1_0_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getGreaterThanSignKeyword_1_0_3_2()); }
	'>'
	{ after(grammarAccess.getCallExpressionAccess().getGreaterThanSignKeyword_1_0_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CallExpression__Group_1_0_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_4__0__Impl
	rule__CallExpression__Group_1_0_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_0_4_0()); }
	'('
	{ after(grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_0_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_4__1__Impl
	rule__CallExpression__Group_1_0_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getArgumentAssignment_1_0_4_1()); }
	(rule__CallExpression__ArgumentAssignment_1_0_4_1)
	{ after(grammarAccess.getCallExpressionAccess().getArgumentAssignment_1_0_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_0_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_0_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_0_4_2()); }
	')'
	{ after(grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_0_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CallExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_1__0__Impl
	rule__CallExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0()); }
	()
	{ after(grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_1__1__Impl
	rule__CallExpression__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getNumberSignKeyword_1_1_1()); }
	'#'
	{ after(grammarAccess.getCallExpressionAccess().getNumberSignKeyword_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CallExpression__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCallExpressionAccess().getRightAssignment_1_1_2()); }
	(rule__CallExpression__RightAssignment_1_1_2)
	{ after(grammarAccess.getCallExpressionAccess().getRightAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Lambda__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__0__Impl
	rule__Lambda__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getLeftCurlyBracketKeyword_0()); }
	'{'
	{ after(grammarAccess.getLambdaAccess().getLeftCurlyBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__1__Impl
	rule__Lambda__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getParameterAssignment_1()); }
	(rule__Lambda__ParameterAssignment_1)
	{ after(grammarAccess.getLambdaAccess().getParameterAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__2__Impl
	rule__Lambda__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getHyphenMinusGreaterThanSignKeyword_2()); }
	'->'
	{ after(grammarAccess.getLambdaAccess().getHyphenMinusGreaterThanSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__3__Impl
	rule__Lambda__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getQueriesParserRuleCall_3()); }
	ruleQueries
	{ after(grammarAccess.getLambdaAccess().getQueriesParserRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__4__Impl
	rule__Lambda__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getReturnValueAssignment_4()); }
	(rule__Lambda__ReturnValueAssignment_4)
	{ after(grammarAccess.getLambdaAccess().getReturnValueAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Lambda__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLambdaAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getLambdaAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parameter__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__0__Impl
	rule__Parameter__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getTupleParameterAction_1_0()); }
	()
	{ after(grammarAccess.getParameterAccess().getTupleParameterAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__1__Impl
	rule__Parameter__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getLeftParenthesisKeyword_1_1()); }
	'('
	{ after(grammarAccess.getParameterAccess().getLeftParenthesisKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__2__Impl
	rule__Parameter__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getNamesAssignment_1_2()); }
	(rule__Parameter__NamesAssignment_1_2)
	{ after(grammarAccess.getParameterAccess().getNamesAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__3__Impl
	rule__Parameter__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getParameterAccess().getGroup_1_3()); }
		(rule__Parameter__Group_1_3__0)
		{ after(grammarAccess.getParameterAccess().getGroup_1_3()); }
	)
	(
		{ before(grammarAccess.getParameterAccess().getGroup_1_3()); }
		(rule__Parameter__Group_1_3__0)*
		{ after(grammarAccess.getParameterAccess().getGroup_1_3()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getRightParenthesisKeyword_1_4()); }
	')'
	{ after(grammarAccess.getParameterAccess().getRightParenthesisKeyword_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parameter__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1_3__0__Impl
	rule__Parameter__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getCommaKeyword_1_3_0()); }
	','
	{ after(grammarAccess.getParameterAccess().getCommaKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getNamesAssignment_1_3_1()); }
	(rule__Parameter__NamesAssignment_1_3_1)
	{ after(grammarAccess.getParameterAccess().getNamesAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_0__0__Impl
	rule__TerminalExpression__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getSelfExpressionAction_0_0()); }
	()
	{ after(grammarAccess.getTerminalExpressionAccess().getSelfExpressionAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getSelfKeyword_0_1()); }
	'self'
	{ after(grammarAccess.getTerminalExpressionAccess().getSelfKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_1__0__Impl
	rule__TerminalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getRootExpressionAction_1_0()); }
	()
	{ after(grammarAccess.getTerminalExpressionAccess().getRootExpressionAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getRootKeyword_1_1()); }
	'root'
	{ after(grammarAccess.getTerminalExpressionAccess().getRootKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_2__0__Impl
	rule__TerminalExpression__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getStringLiteralAction_2_0()); }
	()
	{ after(grammarAccess.getTerminalExpressionAccess().getStringLiteralAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); }
	(rule__TerminalExpression__ValueAssignment_2_1)
	{ after(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_3__0__Impl
	rule__TerminalExpression__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getNameReferenceAction_3_0()); }
	()
	{ after(grammarAccess.getTerminalExpressionAccess().getNameReferenceAction_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getReferenceAssignment_3_1()); }
	(rule__TerminalExpression__ReferenceAssignment_3_1)
	{ after(grammarAccess.getTerminalExpressionAccess().getReferenceAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4__0__Impl
	rule__TerminalExpression__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0()); }
	'('
	{ after(grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4__1__Impl
	rule__TerminalExpression__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getExpressionParserRuleCall_4_1()); }
	ruleExpression
	{ after(grammarAccess.getTerminalExpressionAccess().getExpressionParserRuleCall_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4__2__Impl
	rule__TerminalExpression__Group_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getGroup_4_2()); }
	(rule__TerminalExpression__Group_4_2__0)?
	{ after(grammarAccess.getTerminalExpressionAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_4_3()); }
	')'
	{ after(grammarAccess.getTerminalExpressionAccess().getRightParenthesisKeyword_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4_2__0__Impl
	rule__TerminalExpression__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getTupleExpressionElementsAction_4_2_0()); }
	()
	{ after(grammarAccess.getTerminalExpressionAccess().getTupleExpressionElementsAction_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_4_2_1()); }
		(rule__TerminalExpression__Group_4_2_1__0)
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_4_2_1()); }
	)
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getGroup_4_2_1()); }
		(rule__TerminalExpression__Group_4_2_1__0)*
		{ after(grammarAccess.getTerminalExpressionAccess().getGroup_4_2_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalExpression__Group_4_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4_2_1__0__Impl
	rule__TerminalExpression__Group_4_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getCommaKeyword_4_2_1_0()); }
	','
	{ after(grammarAccess.getTerminalExpressionAccess().getCommaKeyword_4_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalExpression__Group_4_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__Group_4_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalExpressionAccess().getElementsAssignment_4_2_1_1()); }
	(rule__TerminalExpression__ElementsAssignment_4_2_1_1)
	{ after(grammarAccess.getTerminalExpressionAccess().getElementsAssignment_4_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IString__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1__0__Impl
	rule__IString__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getPartsAssignment_1_0()); }
	(rule__IString__PartsAssignment_1_0)
	{ after(grammarAccess.getIStringAccess().getPartsAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1__1__Impl
	rule__IString__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getPartsAssignment_1_1()); }
	(rule__IString__PartsAssignment_1_1)?
	{ after(grammarAccess.getIStringAccess().getPartsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1__2__Impl
	rule__IString__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getGroup_1_2()); }
	(rule__IString__Group_1_2__0)*
	{ after(grammarAccess.getIStringAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getPartsAssignment_1_3()); }
	(rule__IString__PartsAssignment_1_3)
	{ after(grammarAccess.getIStringAccess().getPartsAssignment_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IString__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1_2__0__Impl
	rule__IString__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getPartsAssignment_1_2_0()); }
	(rule__IString__PartsAssignment_1_2_0)
	{ after(grammarAccess.getIStringAccess().getPartsAssignment_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IString__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringAccess().getPartsAssignment_1_2_1()); }
	(rule__IString__PartsAssignment_1_2_1)?
	{ after(grammarAccess.getIStringAccess().getPartsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IStringInter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group__0__Impl
	rule__IStringInter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getDirectAssignment_0()); }
	(rule__IStringInter__DirectAssignment_0)?
	{ after(grammarAccess.getIStringInterAccess().getDirectAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getAlternatives_1()); }
	(rule__IStringInter__Alternatives_1)
	{ after(grammarAccess.getIStringInterAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IStringInter__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group_1_0__0__Impl
	rule__IStringInter__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getGroup_1_0_0()); }
	(rule__IStringInter__Group_1_0_0__0)?
	{ after(grammarAccess.getIStringInterAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getQueryAssignment_1_0_1()); }
	(rule__IStringInter__QueryAssignment_1_0_1)
	{ after(grammarAccess.getIStringInterAccess().getQueryAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IStringInter__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group_1_0_0__0__Impl
	rule__IStringInter__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getDomainAssignment_1_0_0_0()); }
	(rule__IStringInter__DomainAssignment_1_0_0_0)
	{ after(grammarAccess.getIStringInterAccess().getDomainAssignment_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IStringInter__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIStringInterAccess().getColonColonKeyword_1_0_0_1()); }
	'::'
	{ after(grammarAccess.getIStringInterAccess().getColonColonKeyword_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QPREF__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QPREF__Group__0__Impl
	rule__QPREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QPREF__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQPREFAccess().getGroup_1()); }
	(rule__QPREF__Group_1__0)?
	{ after(grammarAccess.getQPREFAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QPREF__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QPREF__Group_1__0__Impl
	rule__QPREF__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); }
	'::'
	{ after(grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QPREF__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QPREF__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group__0__Impl
	rule__QCREF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getGroup_0()); }
	(rule__QCREF__Group_0__0)*
	{ after(grammarAccess.getQCREFAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group__1__Impl
	rule__QCREF__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
	{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getGroup_2()); }
	(rule__QCREF__Group_2__0)?
	{ after(grammarAccess.getQCREFAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group_0__0__Impl
	rule__QCREF__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); }
	RULE_ID
	{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); }
	'::'
	{ after(grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QCREF__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group_2__0__Impl
	rule__QCREF__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); }
	'.'
	{ after(grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QCREF__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QCREF__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); }
	RULE_ID
	{ after(grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContractLibrary__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractLibraryAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getContractLibraryAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractLibrary__ContractElementsAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_3_0()); }
		ruleContractElement
		{ after(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__InputsAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractAccess().getInputsInputAssumptionParserRuleCall_5_2_0()); }
		ruleInputAssumption
		{ after(grammarAccess.getContractAccess().getInputsInputAssumptionParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Contract__GuaranteeAssignment_7_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractAccess().getGuaranteeGuaranteeParserRuleCall_7_2_0()); }
		ruleGuarantee
		{ after(grammarAccess.getContractAccess().getGuaranteeGuaranteeParserRuleCall_7_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exact__ExactAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0()); }
		(
			{ before(grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0()); }
			'<=>'
			{ after(grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0()); }
		)
		{ after(grammarAccess.getExactAccess().getExactLessThanSignEqualsSignGreaterThanSignKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Queries__QueriesAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueriesAccess().getQueriesQueryParserRuleCall_0_0()); }
		ruleQuery
		{ after(grammarAccess.getQueriesAccess().getQueriesQueryParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domains__DomainsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDomainsAccess().getDomainsDomainCrossReference_0_0()); }
		(
			{ before(grammarAccess.getDomainsAccess().getDomainsDomainQPREFParserRuleCall_0_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getDomainsAccess().getDomainsDomainQPREFParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getDomainsAccess().getDomainsDomainCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assumptions__AssumptionsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionsAccess().getAssumptionsAssumptionElementParserRuleCall_0_0()); }
		ruleAssumptionElement
		{ after(grammarAccess.getAssumptionsAccess().getAssumptionsAssumptionElementParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Analyses__AnalysesAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnalysesAccess().getAnalysesAnalysisParserRuleCall_0_0()); }
		ruleAnalysis
		{ after(grammarAccess.getAnalysesAccess().getAnalysesAnalysisParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InputAssumption__CodeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInputAssumptionAccess().getCodeSourceParserRuleCall_1_0()); }
		ruleSource
		{ after(grammarAccess.getInputAssumptionAccess().getCodeSourceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__ContractAssignment_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getContractContractElementCrossReference_0_2_0()); }
		(
			{ before(grammarAccess.getAssumptionElementAccess().getContractContractElementQPREFParserRuleCall_0_2_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getAssumptionElementAccess().getContractContractElementQPREFParserRuleCall_0_2_0_1()); }
		)
		{ after(grammarAccess.getAssumptionElementAccess().getContractContractElementCrossReference_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__ArgumentAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getArgumentContractElementCrossReference_1_2_0()); }
		(
			{ before(grammarAccess.getAssumptionElementAccess().getArgumentContractElementQPREFParserRuleCall_1_2_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getAssumptionElementAccess().getArgumentContractElementQPREFParserRuleCall_1_2_0_1()); }
		)
		{ after(grammarAccess.getAssumptionElementAccess().getArgumentContractElementCrossReference_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__CodeAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getCodeSourceParserRuleCall_2_1_0()); }
		ruleSource
		{ after(grammarAccess.getAssumptionElementAccess().getCodeSourceParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssumptionElement__GuaranteeAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssumptionElementAccess().getGuaranteeGuaranteeParserRuleCall_2_2_1_0()); }
		ruleGuarantee
		{ after(grammarAccess.getAssumptionElementAccess().getGuaranteeGuaranteeParserRuleCall_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Guarantee__CodeAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGuaranteeAccess().getCodeSourceParserRuleCall_0()); }
		ruleSource
		{ after(grammarAccess.getGuaranteeAccess().getCodeSourceParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Analysis__CodeAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnalysisAccess().getCodeSourceParserRuleCall_0()); }
		ruleSource
		{ after(grammarAccess.getAnalysisAccess().getCodeSourceParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__LanguageAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSourceAccess().getLanguageLanguageEnumRuleCall_0_0()); }
		ruleLanguage
		{ after(grammarAccess.getSourceAccess().getLanguageLanguageEnumRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__SourceAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSourceAccess().getSourceSSTRINGTerminalRuleCall_1_0_0()); }
		RULE_SSTRING
		{ after(grammarAccess.getSourceAccess().getSourceSSTRINGTerminalRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Source__InterAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSourceAccess().getInterIStringParserRuleCall_1_1_0()); }
		ruleIString
		{ after(grammarAccess.getSourceAccess().getInterIStringParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Implementation__CodeAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getImplementationAccess().getCodeSourceParserRuleCall_4_0()); }
		ruleSource
		{ after(grammarAccess.getImplementationAccess().getCodeSourceParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getDomainAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Domain__CodeAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDomainAccess().getCodeSourceParserRuleCall_4_1_0()); }
		ruleSource
		{ after(grammarAccess.getDomainAccess().getCodeSourceParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__GuaranteeAssignment_4_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentAccess().getGuaranteeGuaranteeParserRuleCall_4_2_0()); }
		ruleGuarantee
		{ after(grammarAccess.getArgumentAccess().getGuaranteeGuaranteeParserRuleCall_4_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Argument__ArgumentExpressionAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentAccess().getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0()); }
		ruleArgumentExpression
		{ after(grammarAccess.getArgumentAccess().getArgumentExpressionArgumentExpressionParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__ContractsAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentTermAccess().getContractsContractElementCrossReference_0_1_0()); }
		(
			{ before(grammarAccess.getArgumentTermAccess().getContractsContractElementQPREFParserRuleCall_0_1_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getArgumentTermAccess().getContractsContractElementQPREFParserRuleCall_0_1_0_1()); }
		)
		{ after(grammarAccess.getArgumentTermAccess().getContractsContractElementCrossReference_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__ArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentTermAccess().getArgumentsContractElementCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getArgumentTermAccess().getArgumentsContractElementQPREFParserRuleCall_1_1_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getArgumentTermAccess().getArgumentsContractElementQPREFParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getArgumentTermAccess().getArgumentsContractElementCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentTerm__NestedAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentTermAccess().getNestedArgumentExpressionParserRuleCall_2_0()); }
		ruleArgumentExpression
		{ after(grammarAccess.getArgumentTermAccess().getNestedArgumentExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVerificationPlanAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getVerificationPlanAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__ComponentImplementationAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVerificationPlanAccess().getComponentImplementationOccurrenceDefinitionCrossReference_7_0()); }
		(
			{ before(grammarAccess.getVerificationPlanAccess().getComponentImplementationOccurrenceDefinitionQCREFParserRuleCall_7_0_1()); }
			ruleQCREF
			{ after(grammarAccess.getVerificationPlanAccess().getComponentImplementationOccurrenceDefinitionQCREFParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getVerificationPlanAccess().getComponentImplementationOccurrenceDefinitionCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VerificationPlan__ContractsAssignment_11_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVerificationPlanAccess().getContractsContractCrossReference_11_1_0_0()); }
		(
			{ before(grammarAccess.getVerificationPlanAccess().getContractsContractQPREFParserRuleCall_11_1_0_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getVerificationPlanAccess().getContractsContractQPREFParserRuleCall_11_1_0_0_1()); }
		)
		{ after(grammarAccess.getVerificationPlanAccess().getContractsContractCrossReference_11_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Claims__ClaimsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClaimsAccess().getClaimsSourceParserRuleCall_0_0()); }
		ruleSource
		{ after(grammarAccess.getClaimsAccess().getClaimsSourceParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__NamesAssignment_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_3_0()); }
		ruleTupleName
		{ after(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__NamesAssignment_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_4_1_0()); }
		ruleTupleName
		{ after(grammarAccess.getQueryAccess().getNamesTupleNameParserRuleCall_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Query__ValueAssignment_1_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getQueryAccess().getValueExpressionParserRuleCall_1_7_0()); }
		ruleExpression
		{ after(grammarAccess.getQueryAccess().getValueExpressionParserRuleCall_1_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleValDeclaration__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingleValDeclarationAccess().getValueExpressionParserRuleCall_3_0()); }
		ruleExpression
		{ after(grammarAccess.getSingleValDeclarationAccess().getValueExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TupleName__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTupleNameAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getTupleNameAccess().getNameIDTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Expression__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); }
		ruleAndExpression
		{ after(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AndExpression__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0()); }
		ruleNotExpression
		{ after(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NotExpression__OperandAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNotExpressionAccess().getOperandCallExpressionParserRuleCall_1_2_0()); }
		ruleCallExpression
		{ after(grammarAccess.getNotExpressionAccess().getOperandCallExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__RightAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getRightIDTerminalRuleCall_1_0_2_0()); }
		RULE_ID
		{ after(grammarAccess.getCallExpressionAccess().getRightIDTerminalRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__TypeArgumentAssignment_1_0_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getTypeArgumentIDTerminalRuleCall_1_0_3_1_0()); }
		RULE_ID
		{ after(grammarAccess.getCallExpressionAccess().getTypeArgumentIDTerminalRuleCall_1_0_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__ArgumentAssignment_1_0_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getArgumentExpressionParserRuleCall_1_0_4_1_0()); }
		ruleExpression
		{ after(grammarAccess.getCallExpressionAccess().getArgumentExpressionParserRuleCall_1_0_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__LambdaAssignment_1_0_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getLambdaLambdaParserRuleCall_1_0_5_0()); }
		ruleLambda
		{ after(grammarAccess.getCallExpressionAccess().getLambdaLambdaParserRuleCall_1_0_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CallExpression__RightAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCallExpressionAccess().getRightAttributeDefinitionCrossReference_1_1_2_0()); }
		(
			{ before(grammarAccess.getCallExpressionAccess().getRightAttributeDefinitionQPREFParserRuleCall_1_1_2_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getCallExpressionAccess().getRightAttributeDefinitionQPREFParserRuleCall_1_1_2_0_1()); }
		)
		{ after(grammarAccess.getCallExpressionAccess().getRightAttributeDefinitionCrossReference_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__ParameterAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLambdaAccess().getParameterParameterParserRuleCall_1_0()); }
		ruleParameter
		{ after(grammarAccess.getLambdaAccess().getParameterParameterParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Lambda__ReturnValueAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLambdaAccess().getReturnValueExpressionParserRuleCall_4_0()); }
		ruleExpression
		{ after(grammarAccess.getLambdaAccess().getReturnValueExpressionParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__NamesAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_2_0()); }
		ruleTupleName
		{ after(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__NamesAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_3_1_0()); }
		ruleTupleName
		{ after(grammarAccess.getParameterAccess().getNamesTupleNameParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SingleParameter__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSingleParameterAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getSingleParameterAccess().getNameIDTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__ValueAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__ReferenceAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getReferenceElementCrossReference_3_1_0()); }
		(
			{ before(grammarAccess.getTerminalExpressionAccess().getReferenceElementIDTerminalRuleCall_3_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTerminalExpressionAccess().getReferenceElementIDTerminalRuleCall_3_1_0_1()); }
		)
		{ after(grammarAccess.getTerminalExpressionAccess().getReferenceElementCrossReference_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalExpression__ElementsAssignment_4_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalExpressionAccess().getElementsExpressionParserRuleCall_4_2_1_1_0()); }
		ruleExpression
		{ after(grammarAccess.getTerminalExpressionAccess().getElementsExpressionParserRuleCall_4_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringLiteralParserRuleCall_0_0()); }
		ruleIStringLiteral
		{ after(grammarAccess.getIStringAccess().getPartsIStringLiteralParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringLeftLiteralParserRuleCall_1_0_0()); }
		ruleIStringLeftLiteral
		{ after(grammarAccess.getIStringAccess().getPartsIStringLeftLiteralParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_1_0()); }
		ruleIStringInter
		{ after(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_1_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0()); }
		ruleIStringMiddleLiteral
		{ after(grammarAccess.getIStringAccess().getPartsIStringMiddleLiteralParserRuleCall_1_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_2_1_0()); }
		ruleIStringInter
		{ after(grammarAccess.getIStringAccess().getPartsIStringInterParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IString__PartsAssignment_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringAccess().getPartsIStringRightLiteralParserRuleCall_1_3_0()); }
		ruleIStringRightLiteral
		{ after(grammarAccess.getIStringAccess().getPartsIStringRightLiteralParserRuleCall_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringLiteralAccess().getValueISTRING_TEXTTerminalRuleCall_0()); }
		RULE_ISTRING_TEXT
		{ after(grammarAccess.getIStringLiteralAccess().getValueISTRING_TEXTTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringLeftLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringLeftLiteralAccess().getValueISTRING_LEFTTerminalRuleCall_0()); }
		RULE_ISTRING_LEFT
		{ after(grammarAccess.getIStringLeftLiteralAccess().getValueISTRING_LEFTTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringMiddleLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringMiddleLiteralAccess().getValueISTRING_MIDDLETerminalRuleCall_0()); }
		RULE_ISTRING_MIDDLE
		{ after(grammarAccess.getIStringMiddleLiteralAccess().getValueISTRING_MIDDLETerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringRightLiteral__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringRightLiteralAccess().getValueISTRING_RIGHTTerminalRuleCall_0()); }
		RULE_ISTRING_RIGHT
		{ after(grammarAccess.getIStringRightLiteralAccess().getValueISTRING_RIGHTTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__DirectAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0()); }
		(
			{ before(grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0()); }
			':'
			{ after(grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0()); }
		)
		{ after(grammarAccess.getIStringInterAccess().getDirectColonKeyword_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__DomainAssignment_1_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringInterAccess().getDomainDomainCrossReference_1_0_0_0_0()); }
		(
			{ before(grammarAccess.getIStringInterAccess().getDomainDomainIDTerminalRuleCall_1_0_0_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getIStringInterAccess().getDomainDomainIDTerminalRuleCall_1_0_0_0_0_1()); }
		)
		{ after(grammarAccess.getIStringInterAccess().getDomainDomainCrossReference_1_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__QueryAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationCrossReference_1_0_1_0()); }
		(
			{ before(grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationIDTerminalRuleCall_1_0_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationIDTerminalRuleCall_1_0_1_0_1()); }
		)
		{ after(grammarAccess.getIStringInterAccess().getQuerySingleValDeclarationCrossReference_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IStringInter__PredefinedAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIStringInterAccess().getPredefinedPredefinedEnumRuleCall_1_1_0()); }
		rulePredefined
		{ after(grammarAccess.getIStringInterAccess().getPredefinedPredefinedEnumRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ISTRING_TEXT : '\'\'\'' RULE_IN_ISTRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_ISTRING_LEFT : '\'\'\'' RULE_IN_ISTRING* ('\'' '\''?)? '${';

RULE_ISTRING_MIDDLE : '$}' RULE_IN_ISTRING* ('\'' '\''?)? '${';

RULE_ISTRING_RIGHT : '$}' RULE_IN_ISTRING* ('\'\'\''|('\'' '\''?)? EOF);

fragment RULE_IN_ISTRING : ('\'\'' ~('\'')|'\'' ~('\'')|'$' ~('{')|~(('\''|'$')));

RULE_SSTRING : '`' ~('`')* '`';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;
