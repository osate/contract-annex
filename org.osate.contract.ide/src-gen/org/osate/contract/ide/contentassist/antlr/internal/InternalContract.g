
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
package org.osate.contract.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.osate.contract.ide.contentassist.antlr.internal;

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
import org.osate.contract.services.ContractGrammarAccess;

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

// Entry rule entryRuleAnnexLibrary
entryRuleAnnexLibrary
:
{ before(grammarAccess.getAnnexLibraryRule()); }
	 ruleAnnexLibrary
{ after(grammarAccess.getAnnexLibraryRule()); } 
	 EOF 
;

// Rule AnnexLibrary
ruleAnnexLibrary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnexLibraryAccess().getContractLibraryParserRuleCall()); }
		ruleContractLibrary
		{ after(grammarAccess.getAnnexLibraryAccess().getContractLibraryParserRuleCall()); }
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
		{ before(grammarAccess.getArgumentNotAccess().getAlternatives()); }
		(rule__ArgumentNot__Alternatives)
		{ after(grammarAccess.getArgumentNotAccess().getAlternatives()); }
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

// Entry rule entryRuleContractSubclause
entryRuleContractSubclause
:
{ before(grammarAccess.getContractSubclauseRule()); }
	 ruleContractSubclause
{ after(grammarAccess.getContractSubclauseRule()); } 
	 EOF 
;

// Rule ContractSubclause
ruleContractSubclause 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContractSubclauseAccess().getGroup()); }
		(rule__ContractSubclause__Group__0)
		{ after(grammarAccess.getContractSubclauseAccess().getGroup()); }
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

// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation
:
{ before(grammarAccess.getContainedPropertyAssociationRule()); }
	 ruleContainedPropertyAssociation
{ after(grammarAccess.getContainedPropertyAssociationRule()); } 
	 EOF 
;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup()); }
		(rule__ContainedPropertyAssociation__Group__0)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleContainmentPath
entryRuleContainmentPath
:
{ before(grammarAccess.getContainmentPathRule()); }
	 ruleContainmentPath
{ after(grammarAccess.getContainmentPathRule()); } 
	 EOF 
;

// Rule ContainmentPath
ruleContainmentPath 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContainmentPathAccess().getPathAssignment()); }
		(rule__ContainmentPath__PathAssignment)
		{ after(grammarAccess.getContainmentPathAccess().getPathAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue
:
{ before(grammarAccess.getOptionalModalPropertyValueRule()); }
	 ruleOptionalModalPropertyValue
{ after(grammarAccess.getOptionalModalPropertyValueRule()); } 
	 EOF 
;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup()); }
		(rule__OptionalModalPropertyValue__Group__0)
		{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePropertyValue
entryRulePropertyValue
:
{ before(grammarAccess.getPropertyValueRule()); }
	 rulePropertyValue
{ after(grammarAccess.getPropertyValueRule()); } 
	 EOF 
;

// Rule PropertyValue
rulePropertyValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment()); }
		(rule__PropertyValue__OwnedValueAssignment)
		{ after(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePropertyExpression
entryRulePropertyExpression
:
{ before(grammarAccess.getPropertyExpressionRule()); }
	 rulePropertyExpression
{ after(grammarAccess.getPropertyExpressionRule()); } 
	 EOF 
;

// Rule PropertyExpression
rulePropertyExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getAlternatives()); }
		(rule__PropertyExpression__Alternatives)
		{ after(grammarAccess.getPropertyExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm
:
{ before(grammarAccess.getLiteralorReferenceTermRule()); }
	 ruleLiteralorReferenceTerm
{ after(grammarAccess.getLiteralorReferenceTermRule()); } 
	 EOF 
;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment()); }
		(rule__LiteralorReferenceTerm__NamedValueAssignment)
		{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral
:
{ before(grammarAccess.getBooleanLiteralRule()); }
	 ruleBooleanLiteral
{ after(grammarAccess.getBooleanLiteralRule()); } 
	 EOF 
;

// Rule BooleanLiteral
ruleBooleanLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getGroup()); }
		(rule__BooleanLiteral__Group__0)
		{ after(grammarAccess.getBooleanLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConstantValue
entryRuleConstantValue
:
{ before(grammarAccess.getConstantValueRule()); }
	 ruleConstantValue
{ after(grammarAccess.getConstantValueRule()); } 
	 EOF 
;

// Rule ConstantValue
ruleConstantValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConstantValueAccess().getNamedValueAssignment()); }
		(rule__ConstantValue__NamedValueAssignment)
		{ after(grammarAccess.getConstantValueAccess().getNamedValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm
:
{ before(grammarAccess.getReferenceTermRule()); }
	 ruleReferenceTerm
{ after(grammarAccess.getReferenceTermRule()); } 
	 EOF 
;

// Rule ReferenceTerm
ruleReferenceTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReferenceTermAccess().getGroup()); }
		(rule__ReferenceTerm__Group__0)
		{ after(grammarAccess.getReferenceTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRecordTerm
entryRuleRecordTerm
:
{ before(grammarAccess.getRecordTermRule()); }
	 ruleRecordTerm
{ after(grammarAccess.getRecordTermRule()); } 
	 EOF 
;

// Rule RecordTerm
ruleRecordTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRecordTermAccess().getGroup()); }
		(rule__RecordTerm__Group__0)
		{ after(grammarAccess.getRecordTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleComputedTerm
entryRuleComputedTerm
:
{ before(grammarAccess.getComputedTermRule()); }
	 ruleComputedTerm
{ after(grammarAccess.getComputedTermRule()); } 
	 EOF 
;

// Rule ComputedTerm
ruleComputedTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getComputedTermAccess().getGroup()); }
		(rule__ComputedTerm__Group__0)
		{ after(grammarAccess.getComputedTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm
:
{ before(grammarAccess.getComponentClassifierTermRule()); }
	 ruleComponentClassifierTerm
{ after(grammarAccess.getComponentClassifierTermRule()); } 
	 EOF 
;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getComponentClassifierTermAccess().getGroup()); }
		(rule__ComponentClassifierTerm__Group__0)
		{ after(grammarAccess.getComponentClassifierTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleListTerm
entryRuleListTerm
:
{ before(grammarAccess.getListTermRule()); }
	 ruleListTerm
{ after(grammarAccess.getListTermRule()); } 
	 EOF 
;

// Rule ListTerm
ruleListTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getListTermAccess().getGroup()); }
		(rule__ListTerm__Group__0)
		{ after(grammarAccess.getListTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation
:
{ before(grammarAccess.getFieldPropertyAssociationRule()); }
	 ruleFieldPropertyAssociation
{ after(grammarAccess.getFieldPropertyAssociationRule()); } 
	 EOF 
;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFieldPropertyAssociationAccess().getGroup()); }
		(rule__FieldPropertyAssociation__Group__0)
		{ after(grammarAccess.getFieldPropertyAssociationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement
:
{ before(grammarAccess.getContainmentPathElementRule()); }
	 ruleContainmentPathElement
{ after(grammarAccess.getContainmentPathElementRule()); } 
	 EOF 
;

// Rule ContainmentPathElement
ruleContainmentPathElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getContainmentPathElementAccess().getGroup()); }
		(rule__ContainmentPathElement__Group__0)
		{ after(grammarAccess.getContainmentPathElementAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePlusMinus
entryRulePlusMinus
:
{ before(grammarAccess.getPlusMinusRule()); }
	 rulePlusMinus
{ after(grammarAccess.getPlusMinusRule()); } 
	 EOF 
;

// Rule PlusMinus
rulePlusMinus 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPlusMinusAccess().getAlternatives()); }
		(rule__PlusMinus__Alternatives)
		{ after(grammarAccess.getPlusMinusAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStringTerm
entryRuleStringTerm
:
{ before(grammarAccess.getStringTermRule()); }
	 ruleStringTerm
{ after(grammarAccess.getStringTermRule()); } 
	 EOF 
;

// Rule StringTerm
ruleStringTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStringTermAccess().getValueAssignment()); }
		(rule__StringTerm__ValueAssignment)
		{ after(grammarAccess.getStringTermAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString
:
{ before(grammarAccess.getNoQuoteStringRule()); }
	 ruleNoQuoteString
{ after(grammarAccess.getNoQuoteStringRule()); } 
	 EOF 
;

// Rule NoQuoteString
ruleNoQuoteString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
		RULE_STRING
		{ after(grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArrayRange
entryRuleArrayRange
:
{ before(grammarAccess.getArrayRangeRule()); }
	 ruleArrayRange
{ after(grammarAccess.getArrayRangeRule()); } 
	 EOF 
;

// Rule ArrayRange
ruleArrayRange 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArrayRangeAccess().getGroup()); }
		(rule__ArrayRange__Group__0)
		{ after(grammarAccess.getArrayRangeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSignedConstant
entryRuleSignedConstant
:
{ before(grammarAccess.getSignedConstantRule()); }
	 ruleSignedConstant
{ after(grammarAccess.getSignedConstantRule()); } 
	 EOF 
;

// Rule SignedConstant
ruleSignedConstant 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSignedConstantAccess().getGroup()); }
		(rule__SignedConstant__Group__0)
		{ after(grammarAccess.getSignedConstantAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm
:
{ before(grammarAccess.getIntegerTermRule()); }
	 ruleIntegerTerm
{ after(grammarAccess.getIntegerTermRule()); } 
	 EOF 
;

// Rule IntegerTerm
ruleIntegerTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIntegerTermAccess().getGroup()); }
		(rule__IntegerTerm__Group__0)
		{ after(grammarAccess.getIntegerTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSignedInt
entryRuleSignedInt
:
{ before(grammarAccess.getSignedIntRule()); }
	 ruleSignedInt
{ after(grammarAccess.getSignedIntRule()); } 
	 EOF 
;

// Rule SignedInt
ruleSignedInt 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSignedIntAccess().getGroup()); }
		(rule__SignedInt__Group__0)
		{ after(grammarAccess.getSignedIntAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRealTerm
entryRuleRealTerm
:
{ before(grammarAccess.getRealTermRule()); }
	 ruleRealTerm
{ after(grammarAccess.getRealTermRule()); } 
	 EOF 
;

// Rule RealTerm
ruleRealTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRealTermAccess().getGroup()); }
		(rule__RealTerm__Group__0)
		{ after(grammarAccess.getRealTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSignedReal
entryRuleSignedReal
:
{ before(grammarAccess.getSignedRealRule()); }
	 ruleSignedReal
{ after(grammarAccess.getSignedRealRule()); } 
	 EOF 
;

// Rule SignedReal
ruleSignedReal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSignedRealAccess().getGroup()); }
		(rule__SignedReal__Group__0)
		{ after(grammarAccess.getSignedRealAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm
:
{ before(grammarAccess.getNumericRangeTermRule()); }
	 ruleNumericRangeTerm
{ after(grammarAccess.getNumericRangeTermRule()); } 
	 EOF 
;

// Rule NumericRangeTerm
ruleNumericRangeTerm 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumericRangeTermAccess().getGroup()); }
		(rule__NumericRangeTerm__Group__0)
		{ after(grammarAccess.getNumericRangeTermAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumAlt
entryRuleNumAlt
:
{ before(grammarAccess.getNumAltRule()); }
	 ruleNumAlt
{ after(grammarAccess.getNumAltRule()); } 
	 EOF 
;

// Rule NumAlt
ruleNumAlt 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumAltAccess().getAlternatives()); }
		(rule__NumAlt__Alternatives)
		{ after(grammarAccess.getNumAltAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAppliesToKeywords
entryRuleAppliesToKeywords
:
{ before(grammarAccess.getAppliesToKeywordsRule()); }
	 ruleAppliesToKeywords
{ after(grammarAccess.getAppliesToKeywordsRule()); } 
	 EOF 
;

// Rule AppliesToKeywords
ruleAppliesToKeywords 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAppliesToKeywordsAccess().getGroup()); }
		(rule__AppliesToKeywords__Group__0)
		{ after(grammarAccess.getAppliesToKeywordsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords
:
{ before(grammarAccess.getInBindingKeywordsRule()); }
	 ruleInBindingKeywords
{ after(grammarAccess.getInBindingKeywordsRule()); } 
	 EOF 
;

// Rule InBindingKeywords
ruleInBindingKeywords 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInBindingKeywordsAccess().getGroup()); }
		(rule__InBindingKeywords__Group__0)
		{ after(grammarAccess.getInBindingKeywordsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords
:
{ before(grammarAccess.getInModesKeywordsRule()); }
	 ruleInModesKeywords
{ after(grammarAccess.getInModesKeywordsRule()); } 
	 EOF 
;

// Rule InModesKeywords
ruleInModesKeywords 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInModesKeywordsAccess().getGroup()); }
		(rule__InModesKeywords__Group__0)
		{ after(grammarAccess.getInModesKeywordsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleINTVALUE
entryRuleINTVALUE
:
{ before(grammarAccess.getINTVALUERule()); }
	 ruleINTVALUE
{ after(grammarAccess.getINTVALUERule()); } 
	 EOF 
;

// Rule INTVALUE
ruleINTVALUE 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); }
		RULE_INTEGER_LIT
		{ after(grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); }
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

// Entry rule entryRuleSTAR
entryRuleSTAR
:
{ before(grammarAccess.getSTARRule()); }
	 ruleSTAR
{ after(grammarAccess.getSTARRule()); } 
	 EOF 
;

// Rule STAR
ruleSTAR 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSTARAccess().getAsteriskKeyword()); }
		'*'
		{ after(grammarAccess.getSTARAccess().getAsteriskKeyword()); }
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

rule__ArgumentNot__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArgumentNotAccess().getGroup_0()); }
		(rule__ArgumentNot__Group_0__0)
		{ after(grammarAccess.getArgumentNotAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getArgumentNotAccess().getGroup_1()); }
		(rule__ArgumentNot__Group_1__0)
		{ after(grammarAccess.getArgumentNotAccess().getGroup_1()); }
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

rule__ContainedPropertyAssociation__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0()); }
		'=>'
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1()); }
		(rule__ContainedPropertyAssociation__AppendAssignment_1_1)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); }
		ruleRecordTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); }
		ruleReferenceTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); }
		ruleComponentClassifierTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); }
		ruleComputedTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); }
		ruleStringTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); }
		ruleNumericRangeTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); }
		ruleRealTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); }
		ruleIntegerTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); }
		ruleListTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); }
		ruleBooleanLiteral
		{ after(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); }
	)
	|
	(
		{ before(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); }
		ruleLiteralorReferenceTerm
		{ after(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); }
		(rule__BooleanLiteral__ValueAssignment_1_0)
		{ after(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); }
		'false'
		{ after(grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PlusMinus__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); }
		'+'
		{ after(grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); }
		'-'
		{ after(grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); }
		'+'
		{ after(grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); }
		'-'
		{ after(grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); }
		'+'
		{ after(grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); }
		'-'
		{ after(grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumAlt__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); }
		ruleRealTerm
		{ after(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); }
		ruleIntegerTerm
		{ after(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); }
		ruleSignedConstant
		{ after(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); }
		ruleConstantValue
		{ after(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); }
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
	{ before(grammarAccess.getContractLibraryAccess().getContractLibraryAction_0()); }
	()
	{ after(grammarAccess.getContractLibraryAccess().getContractLibraryAction_0()); }
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
	{ before(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_1()); }
	(rule__ContractLibrary__ContractElementsAssignment_1)*
	{ after(grammarAccess.getContractLibraryAccess().getContractElementsAssignment_1()); }
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


rule__ArgumentNot__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_0__0__Impl
	rule__ArgumentNot__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getArgumentNotAction_0_0()); }
	()
	{ after(grammarAccess.getArgumentNotAccess().getArgumentNotAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_0__1__Impl
	rule__ArgumentNot__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getNotKeyword_0_1()); }
	'not'
	{ after(grammarAccess.getArgumentNotAccess().getNotKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_0_2()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArgumentNot__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_1__0__Impl
	rule__ArgumentNot__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_1_0()); }
	'('
	{ after(grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_1__1__Impl
	rule__ArgumentNot__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_1_1()); }
	ruleArgumentTerm
	{ after(grammarAccess.getArgumentNotAccess().getArgumentTermParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArgumentNot__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArgumentNot__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArgumentNotAccess().getRightParenthesisKeyword_1_2()); }
	')'
	{ after(grammarAccess.getArgumentNotAccess().getRightParenthesisKeyword_1_2()); }
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


rule__ContractSubclause__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group__0__Impl
	rule__ContractSubclause__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getContractSubclauseAction_0()); }
	()
	{ after(grammarAccess.getContractSubclauseAccess().getContractSubclauseAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group__1__Impl
	rule__ContractSubclause__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getGroup_1()); }
	(rule__ContractSubclause__Group_1__0)*
	{ after(grammarAccess.getContractSubclauseAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getGroup_2()); }
	(rule__ContractSubclause__Group_2__0)*
	{ after(grammarAccess.getContractSubclauseAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContractSubclause__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group_1__0__Impl
	rule__ContractSubclause__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getUseKeyword_1_0()); }
	'use'
	{ after(grammarAccess.getContractSubclauseAccess().getUseKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getUseQueriesAssignment_1_1()); }
	(rule__ContractSubclause__UseQueriesAssignment_1_1)
	{ after(grammarAccess.getContractSubclauseAccess().getUseQueriesAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContractSubclause__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group_2__0__Impl
	rule__ContractSubclause__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getVerifyKeyword_2_0()); }
	'verify'
	{ after(grammarAccess.getContractSubclauseAccess().getVerifyKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group_2__1__Impl
	rule__ContractSubclause__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getVerifyPlansAssignment_2_1()); }
	(rule__ContractSubclause__VerifyPlansAssignment_2_1)
	{ after(grammarAccess.getContractSubclauseAccess().getVerifyPlansAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContractSubclause__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContractSubclauseAccess().getSemicolonKeyword_2_2()); }
	';'
	{ after(grammarAccess.getContractSubclauseAccess().getSemicolonKeyword_2_2()); }
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


rule__ContainedPropertyAssociation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__0__Impl
	rule__ContainedPropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0()); }
	(rule__ContainedPropertyAssociation__PropertyAssignment_0)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__1__Impl
	rule__ContainedPropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1()); }
	(rule__ContainedPropertyAssociation__Alternatives_1)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__2__Impl
	rule__ContainedPropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2()); }
	(rule__ContainedPropertyAssociation__ConstantAssignment_2)?
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__3__Impl
	rule__ContainedPropertyAssociation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3()); }
	(rule__ContainedPropertyAssociation__Group_3__0)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__4__Impl
	rule__ContainedPropertyAssociation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4()); }
	(rule__ContainedPropertyAssociation__Group_4__0)?
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__5__Impl
	rule__ContainedPropertyAssociation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5()); }
	(rule__ContainedPropertyAssociation__Group_5__0)?
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6()); }
	';'
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_3__0__Impl
	rule__ContainedPropertyAssociation__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0()); }
	(rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1()); }
	(rule__ContainedPropertyAssociation__Group_3_1__0)*
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_3_1__0__Impl
	rule__ContainedPropertyAssociation__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0()); }
	','
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1()); }
	(rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_4__0__Impl
	rule__ContainedPropertyAssociation__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); }
	ruleAppliesToKeywords
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_4__1__Impl
	rule__ContainedPropertyAssociation__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1()); }
	(rule__ContainedPropertyAssociation__AppliesToAssignment_4_1)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2()); }
	(rule__ContainedPropertyAssociation__Group_4_2__0)*
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_4_2__0__Impl
	rule__ContainedPropertyAssociation__Group_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0()); }
	','
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1()); }
	(rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainedPropertyAssociation__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_5__0__Impl
	rule__ContainedPropertyAssociation__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); }
	ruleInBindingKeywords
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_5__1__Impl
	rule__ContainedPropertyAssociation__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1()); }
	'('
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_5__2__Impl
	rule__ContainedPropertyAssociation__Group_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2()); }
	(rule__ContainedPropertyAssociation__InBindingAssignment_5_2)
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainedPropertyAssociation__Group_5__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__Group_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3()); }
	')'
	{ after(grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group__0__Impl
	rule__OptionalModalPropertyValue__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0()); }
	(rule__OptionalModalPropertyValue__OwnedValueAssignment_0)
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1()); }
	(rule__OptionalModalPropertyValue__Group_1__0)?
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1__0__Impl
	rule__OptionalModalPropertyValue__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); }
	ruleInModesKeywords
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1__1__Impl
	rule__OptionalModalPropertyValue__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1()); }
	'('
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1__2__Impl
	rule__OptionalModalPropertyValue__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2()); }
	(rule__OptionalModalPropertyValue__InModeAssignment_1_2)
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1__3__Impl
	rule__OptionalModalPropertyValue__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3()); }
	(rule__OptionalModalPropertyValue__Group_1_3__0)*
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4()); }
	')'
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OptionalModalPropertyValue__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1_3__0__Impl
	rule__OptionalModalPropertyValue__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0()); }
	','
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OptionalModalPropertyValue__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1()); }
	(rule__OptionalModalPropertyValue__InModeAssignment_1_3_1)
	{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__BooleanLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__0__Impl
	rule__BooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
	()
	{ after(grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__BooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
	(rule__BooleanLiteral__Alternatives_1)
	{ after(grammarAccess.getBooleanLiteralAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReferenceTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferenceTerm__Group__0__Impl
	rule__ReferenceTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceTermAccess().getReferenceKeyword_0()); }
	'reference'
	{ after(grammarAccess.getReferenceTermAccess().getReferenceKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferenceTerm__Group__1__Impl
	rule__ReferenceTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferenceTerm__Group__2__Impl
	rule__ReferenceTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceTermAccess().getPathAssignment_2()); }
	(rule__ReferenceTerm__PathAssignment_2)
	{ after(grammarAccess.getReferenceTermAccess().getPathAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferenceTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RecordTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RecordTerm__Group__0__Impl
	rule__RecordTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RecordTerm__Group__1__Impl
	rule__RecordTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
		(rule__RecordTerm__OwnedFieldValueAssignment_1)
		{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
	)
	(
		{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
		(rule__RecordTerm__OwnedFieldValueAssignment_1)*
		{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RecordTerm__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2()); }
	']'
	{ after(grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ComputedTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComputedTerm__Group__0__Impl
	rule__ComputedTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComputedTermAccess().getComputeKeyword_0()); }
	'compute'
	{ after(grammarAccess.getComputedTermAccess().getComputeKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComputedTerm__Group__1__Impl
	rule__ComputedTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComputedTerm__Group__2__Impl
	rule__ComputedTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComputedTermAccess().getFunctionAssignment_2()); }
	(rule__ComputedTerm__FunctionAssignment_2)
	{ after(grammarAccess.getComputedTermAccess().getFunctionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComputedTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ComponentClassifierTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComponentClassifierTerm__Group__0__Impl
	rule__ComponentClassifierTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0()); }
	'classifier'
	{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComponentClassifierTerm__Group__1__Impl
	rule__ComponentClassifierTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComponentClassifierTerm__Group__2__Impl
	rule__ComponentClassifierTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2()); }
	(rule__ComponentClassifierTerm__ClassifierAssignment_2)
	{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComponentClassifierTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group__0__Impl
	rule__ListTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getListValueAction_0()); }
	()
	{ after(grammarAccess.getListTermAccess().getListValueAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group__1__Impl
	rule__ListTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group__2__Impl
	rule__ListTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getGroup_2()); }
	(rule__ListTerm__Group_2__0)?
	{ after(grammarAccess.getListTermAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getListTermAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group_2__0__Impl
	rule__ListTerm__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0()); }
	(rule__ListTerm__OwnedListElementAssignment_2_0)
	{ after(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getGroup_2_1()); }
	(rule__ListTerm__Group_2_1__0)*
	{ after(grammarAccess.getListTermAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ListTerm__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group_2_1__0__Impl
	rule__ListTerm__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getCommaKeyword_2_1_0()); }
	','
	{ after(grammarAccess.getListTermAccess().getCommaKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ListTerm__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1()); }
	(rule__ListTerm__OwnedListElementAssignment_2_1_1)
	{ after(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FieldPropertyAssociation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FieldPropertyAssociation__Group__0__Impl
	rule__FieldPropertyAssociation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0()); }
	(rule__FieldPropertyAssociation__PropertyAssignment_0)
	{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FieldPropertyAssociation__Group__1__Impl
	rule__FieldPropertyAssociation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }
	'=>'
	{ after(grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FieldPropertyAssociation__Group__2__Impl
	rule__FieldPropertyAssociation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2()); }
	(rule__FieldPropertyAssociation__OwnedValueAssignment_2)
	{ after(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FieldPropertyAssociation__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3()); }
	';'
	{ after(grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group__0__Impl
	rule__ContainmentPathElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getGroup_0()); }
	(rule__ContainmentPathElement__Group_0__0)
	{ after(grammarAccess.getContainmentPathElementAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getGroup_1()); }
	(rule__ContainmentPathElement__Group_1__0)?
	{ after(grammarAccess.getContainmentPathElementAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group_0__0__Impl
	rule__ContainmentPathElement__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0()); }
	(rule__ContainmentPathElement__NamedElementAssignment_0_0)
	{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1()); }
	(rule__ContainmentPathElement__ArrayRangeAssignment_0_1)*
	{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ContainmentPathElement__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group_1__0__Impl
	rule__ContainmentPathElement__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ContainmentPathElement__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1()); }
	(rule__ContainmentPathElement__PathAssignment_1_1)
	{ after(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group__0__Impl
	rule__ArrayRange__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getArrayRangeAction_0()); }
	()
	{ after(grammarAccess.getArrayRangeAccess().getArrayRangeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group__1__Impl
	rule__ArrayRange__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1()); }
	'['
	{ after(grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group__2__Impl
	rule__ArrayRange__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2()); }
	(rule__ArrayRange__LowerBoundAssignment_2)
	{ after(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group__3__Impl
	rule__ArrayRange__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getGroup_3()); }
	(rule__ArrayRange__Group_3__0)?
	{ after(grammarAccess.getArrayRangeAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4()); }
	']'
	{ after(grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayRange__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group_3__0__Impl
	rule__ArrayRange__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0()); }
	'..'
	{ after(grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayRange__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1()); }
	(rule__ArrayRange__UpperBoundAssignment_3_1)
	{ after(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SignedConstant__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedConstant__Group__0__Impl
	rule__SignedConstant__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedConstantAccess().getOpAssignment_0()); }
	(rule__SignedConstant__OpAssignment_0)
	{ after(grammarAccess.getSignedConstantAccess().getOpAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedConstant__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1()); }
	(rule__SignedConstant__OwnedPropertyExpressionAssignment_1)
	{ after(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IntegerTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerTerm__Group__0__Impl
	rule__IntegerTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); }
	(rule__IntegerTerm__ValueAssignment_0)
	{ after(grammarAccess.getIntegerTermAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IntegerTerm__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); }
	(rule__IntegerTerm__UnitAssignment_1)?
	{ after(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SignedInt__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedInt__Group__0__Impl
	rule__SignedInt__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedIntAccess().getAlternatives_0()); }
	(rule__SignedInt__Alternatives_0)?
	{ after(grammarAccess.getSignedIntAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedInt__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedInt__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); }
	RULE_INTEGER_LIT
	{ after(grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RealTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RealTerm__Group__0__Impl
	rule__RealTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRealTermAccess().getValueAssignment_0()); }
	(rule__RealTerm__ValueAssignment_0)
	{ after(grammarAccess.getRealTermAccess().getValueAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RealTerm__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRealTermAccess().getUnitAssignment_1()); }
	(rule__RealTerm__UnitAssignment_1)?
	{ after(grammarAccess.getRealTermAccess().getUnitAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SignedReal__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedReal__Group__0__Impl
	rule__SignedReal__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedRealAccess().getAlternatives_0()); }
	(rule__SignedReal__Alternatives_0)?
	{ after(grammarAccess.getSignedRealAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SignedReal__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedReal__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); }
	RULE_REAL_LIT
	{ after(grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group__0__Impl
	rule__NumericRangeTerm__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0()); }
	(rule__NumericRangeTerm__MinimumAssignment_0)
	{ after(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group__1__Impl
	rule__NumericRangeTerm__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1()); }
	'..'
	{ after(grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group__2__Impl
	rule__NumericRangeTerm__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2()); }
	(rule__NumericRangeTerm__MaximumAssignment_2)
	{ after(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getGroup_3()); }
	(rule__NumericRangeTerm__Group_3__0)?
	{ after(grammarAccess.getNumericRangeTermAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NumericRangeTerm__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group_3__0__Impl
	rule__NumericRangeTerm__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0()); }
	'delta'
	{ after(grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NumericRangeTerm__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1()); }
	(rule__NumericRangeTerm__DeltaAssignment_3_1)
	{ after(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AppliesToKeywords__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AppliesToKeywords__Group__0__Impl
	rule__AppliesToKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AppliesToKeywords__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); }
	'applies'
	{ after(grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AppliesToKeywords__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AppliesToKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AppliesToKeywords__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); }
	'to'
	{ after(grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InBindingKeywords__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InBindingKeywords__Group__0__Impl
	rule__InBindingKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InBindingKeywords__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); }
	'in'
	{ after(grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InBindingKeywords__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InBindingKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InBindingKeywords__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); }
	'binding'
	{ after(grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InModesKeywords__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InModesKeywords__Group__0__Impl
	rule__InModesKeywords__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InModesKeywords__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); }
	'in'
	{ after(grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InModesKeywords__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InModesKeywords__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InModesKeywords__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); }
	'modes'
	{ after(grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); }
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


rule__ContractLibrary__ContractElementsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_1_0()); }
		ruleContractElement
		{ after(grammarAccess.getContractLibraryAccess().getContractElementsContractElementParserRuleCall_1_0()); }
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
		{ before(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationCrossReference_7_0()); }
		(
			{ before(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationQCREFParserRuleCall_7_0_1()); }
			ruleQCREF
			{ after(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationQCREFParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getVerificationPlanAccess().getComponentImplementationComponentImplementationCrossReference_7_0()); }
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
		{ before(grammarAccess.getCallExpressionAccess().getRightPropertyCrossReference_1_1_2_0()); }
		(
			{ before(grammarAccess.getCallExpressionAccess().getRightPropertyQPREFParserRuleCall_1_1_2_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getCallExpressionAccess().getRightPropertyQPREFParserRuleCall_1_1_2_0_1()); }
		)
		{ after(grammarAccess.getCallExpressionAccess().getRightPropertyCrossReference_1_1_2_0()); }
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
		{ before(grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementCrossReference_3_1_0()); }
		(
			{ before(grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementIDTerminalRuleCall_3_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementIDTerminalRuleCall_3_1_0_1()); }
		)
		{ after(grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementCrossReference_3_1_0()); }
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

rule__ContractSubclause__UseQueriesAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractSubclauseAccess().getUseQueriesContractCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getContractSubclauseAccess().getUseQueriesContractQPREFParserRuleCall_1_1_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getContractSubclauseAccess().getUseQueriesContractQPREFParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getContractSubclauseAccess().getUseQueriesContractCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContractSubclause__VerifyPlansAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanCrossReference_2_1_0()); }
		(
			{ before(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanQPREFParserRuleCall_2_1_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanQPREFParserRuleCall_2_1_0_1()); }
		)
		{ after(grammarAccess.getContractSubclauseAccess().getVerifyPlansVerificationPlanCrossReference_2_1_0()); }
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

rule__ContainedPropertyAssociation__PropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
		(
			{ before(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppendAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
		(
			{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
			'+=>'
			{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
		)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__ConstantAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
		(
			{ before(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
			'constant'
			{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
		)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); }
		ruleOptionalModalPropertyValue
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); }
		ruleOptionalModalPropertyValue
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppliesToAssignment_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); }
		ruleContainmentPath
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); }
		ruleContainmentPath
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainedPropertyAssociation__InBindingAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierQCREFParserRuleCall_5_2_0_1()); }
			ruleQCREF
			{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierQCREFParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPath__PathAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); }
		ruleContainmentPathElement
		{ after(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__OwnedValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); }
		rulePropertyExpression
		{ after(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__InModeAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); }
		(
			{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_2_0_1()); }
			RULE_ID
			{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_2_0_1()); }
		)
		{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OptionalModalPropertyValue__InModeAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); }
		(
			{ before(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeIDTerminalRuleCall_1_3_1_0_1()); }
		)
		{ after(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PropertyValue__OwnedValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); }
		rulePropertyExpression
		{ after(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralorReferenceTerm__NamedValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); }
		(
			{ before(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1()); }
		)
		{ after(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__BooleanLiteral__ValueAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
			'true'
			{ after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConstantValue__NamedValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); }
		(
			{ before(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantQPREFParserRuleCall_0_1()); }
			ruleQPREF
			{ after(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantQPREFParserRuleCall_0_1()); }
		)
		{ after(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferenceTerm__PathAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); }
		ruleContainmentPathElement
		{ after(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RecordTerm__OwnedFieldValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); }
		ruleFieldPropertyAssociation
		{ after(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComputedTerm__FunctionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComponentClassifierTerm__ClassifierAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); }
		(
			{ before(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierQCREFParserRuleCall_2_0_1()); }
			ruleQCREF
			{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierQCREFParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__OwnedListElementAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); }
		rulePropertyExpression
		{ after(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ListTerm__OwnedListElementAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); }
		rulePropertyExpression
		{ after(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__PropertyAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); }
		(
			{ before(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyIDTerminalRuleCall_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyIDTerminalRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldPropertyAssociation__OwnedValueAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); }
		rulePropertyExpression
		{ after(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__NamedElementAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); }
		(
			{ before(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementIDTerminalRuleCall_0_0_0_1()); }
		)
		{ after(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__ArrayRangeAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); }
		ruleArrayRange
		{ after(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ContainmentPathElement__PathAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); }
		ruleContainmentPathElement
		{ after(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StringTerm__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
		ruleNoQuoteString
		{ after(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__LowerBoundAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); }
		ruleINTVALUE
		{ after(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayRange__UpperBoundAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); }
		ruleINTVALUE
		{ after(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__OpAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); }
		rulePlusMinus
		{ after(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SignedConstant__OwnedPropertyExpressionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); }
		ruleConstantValue
		{ after(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); }
		ruleSignedInt
		{ after(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IntegerTerm__UnitAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
		(
			{ before(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__ValueAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); }
		ruleSignedReal
		{ after(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RealTerm__UnitAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
		(
			{ before(grammarAccess.getRealTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getRealTermAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__MinimumAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); }
		ruleNumAlt
		{ after(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__MaximumAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); }
		ruleNumAlt
		{ after(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NumericRangeTerm__DeltaAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); }
		ruleNumAlt
		{ after(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); }
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
