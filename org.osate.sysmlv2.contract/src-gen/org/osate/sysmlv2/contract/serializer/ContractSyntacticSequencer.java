
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
package org.osate.sysmlv2.contract.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.sysmlv2.contract.services.ContractGrammarAccess;

@SuppressWarnings("all")
public class ContractSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ContractGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Analyses_SemicolonKeyword_1_a;
	protected AbstractElementAlias match_Analyses_SemicolonKeyword_1_p;
	protected AbstractElementAlias match_ArgumentAnd_CommaKeyword_4_0_q;
	protected AbstractElementAlias match_ArgumentNot_LeftParenthesisKeyword_2_1_0_q;
	protected AbstractElementAlias match_ArgumentOr_CommaKeyword_4_0_q;
	protected AbstractElementAlias match_Assumptions_SemicolonKeyword_1_a;
	protected AbstractElementAlias match_Assumptions_SemicolonKeyword_1_p;
	protected AbstractElementAlias match_Claims_SemicolonKeyword_1_a;
	protected AbstractElementAlias match_Claims_SemicolonKeyword_1_p;
	protected AbstractElementAlias match_Contract_AnalysisKeyword_8_0_1_or_InvocationKeyword_8_0_0;
	protected AbstractElementAlias match_Contract___InputKeyword_5_0_AssumptionsKeyword_5_1__q;
	protected AbstractElementAlias match_Domains_SemicolonKeyword_1_a;
	protected AbstractElementAlias match_Domains_SemicolonKeyword_1_p;
	protected AbstractElementAlias match_Queries_SemicolonKeyword_1_a;
	protected AbstractElementAlias match_Queries_SemicolonKeyword_1_p;
	protected AbstractElementAlias match_TerminalExpression_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_TerminalExpression_LeftParenthesisKeyword_4_0_p;
	protected AbstractElementAlias match_VerificationPlan_SemicolonKeyword_6_1_1_a;
	protected AbstractElementAlias match_VerificationPlan_SemicolonKeyword_6_1_1_p;
	protected AbstractElementAlias match_VerificationPlan___ContractsKeyword_6_0_SemicolonKeyword_6_1_1_a__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ContractGrammarAccess) access;
		match_Analyses_SemicolonKeyword_1_a = new TokenAlias(true, true, grammarAccess.getAnalysesAccess().getSemicolonKeyword_1());
		match_Analyses_SemicolonKeyword_1_p = new TokenAlias(true, false, grammarAccess.getAnalysesAccess().getSemicolonKeyword_1());
		match_ArgumentAnd_CommaKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getArgumentAndAccess().getCommaKeyword_4_0());
		match_ArgumentNot_LeftParenthesisKeyword_2_1_0_q = new TokenAlias(false, true, grammarAccess.getArgumentNotAccess().getLeftParenthesisKeyword_2_1_0());
		match_ArgumentOr_CommaKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getArgumentOrAccess().getCommaKeyword_4_0());
		match_Assumptions_SemicolonKeyword_1_a = new TokenAlias(true, true, grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1());
		match_Assumptions_SemicolonKeyword_1_p = new TokenAlias(true, false, grammarAccess.getAssumptionsAccess().getSemicolonKeyword_1());
		match_Claims_SemicolonKeyword_1_a = new TokenAlias(true, true, grammarAccess.getClaimsAccess().getSemicolonKeyword_1());
		match_Claims_SemicolonKeyword_1_p = new TokenAlias(true, false, grammarAccess.getClaimsAccess().getSemicolonKeyword_1());
		match_Contract_AnalysisKeyword_8_0_1_or_InvocationKeyword_8_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getContractAccess().getAnalysisKeyword_8_0_1()), new TokenAlias(false, false, grammarAccess.getContractAccess().getInvocationKeyword_8_0_0()));
		match_Contract___InputKeyword_5_0_AssumptionsKeyword_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getContractAccess().getInputKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getContractAccess().getAssumptionsKeyword_5_1()));
		match_Domains_SemicolonKeyword_1_a = new TokenAlias(true, true, grammarAccess.getDomainsAccess().getSemicolonKeyword_1());
		match_Domains_SemicolonKeyword_1_p = new TokenAlias(true, false, grammarAccess.getDomainsAccess().getSemicolonKeyword_1());
		match_Queries_SemicolonKeyword_1_a = new TokenAlias(true, true, grammarAccess.getQueriesAccess().getSemicolonKeyword_1());
		match_Queries_SemicolonKeyword_1_p = new TokenAlias(true, false, grammarAccess.getQueriesAccess().getSemicolonKeyword_1());
		match_TerminalExpression_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0());
		match_TerminalExpression_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_4_0());
		match_VerificationPlan_SemicolonKeyword_6_1_1_a = new TokenAlias(true, true, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_6_1_1());
		match_VerificationPlan_SemicolonKeyword_6_1_1_p = new TokenAlias(true, false, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_6_1_1());
		match_VerificationPlan___ContractsKeyword_6_0_SemicolonKeyword_6_1_1_a__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationPlanAccess().getContractsKeyword_6_0()), new TokenAlias(true, true, grammarAccess.getVerificationPlanAccess().getSemicolonKeyword_6_1_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Analyses_SemicolonKeyword_1_a.equals(syntax))
				emit_Analyses_SemicolonKeyword_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Analyses_SemicolonKeyword_1_p.equals(syntax))
				emit_Analyses_SemicolonKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ArgumentAnd_CommaKeyword_4_0_q.equals(syntax))
				emit_ArgumentAnd_CommaKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ArgumentNot_LeftParenthesisKeyword_2_1_0_q.equals(syntax))
				emit_ArgumentNot_LeftParenthesisKeyword_2_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ArgumentOr_CommaKeyword_4_0_q.equals(syntax))
				emit_ArgumentOr_CommaKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Assumptions_SemicolonKeyword_1_a.equals(syntax))
				emit_Assumptions_SemicolonKeyword_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Assumptions_SemicolonKeyword_1_p.equals(syntax))
				emit_Assumptions_SemicolonKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Claims_SemicolonKeyword_1_a.equals(syntax))
				emit_Claims_SemicolonKeyword_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Claims_SemicolonKeyword_1_p.equals(syntax))
				emit_Claims_SemicolonKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Contract_AnalysisKeyword_8_0_1_or_InvocationKeyword_8_0_0.equals(syntax))
				emit_Contract_AnalysisKeyword_8_0_1_or_InvocationKeyword_8_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Contract___InputKeyword_5_0_AssumptionsKeyword_5_1__q.equals(syntax))
				emit_Contract___InputKeyword_5_0_AssumptionsKeyword_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Domains_SemicolonKeyword_1_a.equals(syntax))
				emit_Domains_SemicolonKeyword_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Domains_SemicolonKeyword_1_p.equals(syntax))
				emit_Domains_SemicolonKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Queries_SemicolonKeyword_1_a.equals(syntax))
				emit_Queries_SemicolonKeyword_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Queries_SemicolonKeyword_1_p.equals(syntax))
				emit_Queries_SemicolonKeyword_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TerminalExpression_LeftParenthesisKeyword_4_0_a.equals(syntax))
				emit_TerminalExpression_LeftParenthesisKeyword_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TerminalExpression_LeftParenthesisKeyword_4_0_p.equals(syntax))
				emit_TerminalExpression_LeftParenthesisKeyword_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationPlan_SemicolonKeyword_6_1_1_a.equals(syntax))
				emit_VerificationPlan_SemicolonKeyword_6_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationPlan_SemicolonKeyword_6_1_1_p.equals(syntax))
				emit_VerificationPlan_SemicolonKeyword_6_1_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationPlan___ContractsKeyword_6_0_SemicolonKeyword_6_1_1_a__q.equals(syntax))
				emit_VerificationPlan___ContractsKeyword_6_0_SemicolonKeyword_6_1_1_a__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     assumptions+=AssumptionElement ';'+ ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 *     declaredName=ID '{' ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 *     domains+=[Domain|QPREF] ';'+ ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 *     guarantee=Guarantee ';' ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 *     inputs+=InputAssumption ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 *     queries+=Query ';'+ ('invocation' | 'analysis') (ambiguity) analyses+=Analysis
	 
	 * </pre>
	 */
	protected void emit_Analyses_SemicolonKeyword_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     analyses+=Analysis (ambiguity) '}' (rule end)
	 *     analyses+=Analysis (ambiguity) analyses+=Analysis
	 
	 * </pre>
	 */
	protected void emit_Analyses_SemicolonKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     arguments+=[ContractElement|QPREF] (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     arguments+=[ContractElement|QPREF] (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     arguments+=[ContractElement|QPREF] (ambiguity) nested+=ArgumentExpression
	 *     contracts+=[ContractElement|QPREF] (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     contracts+=[ContractElement|QPREF] (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     contracts+=[ContractElement|QPREF] (ambiguity) nested+=ArgumentExpression
	 *     nested+=ArgumentExpression (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     nested+=ArgumentExpression (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     nested+=ArgumentExpression (ambiguity) nested+=ArgumentExpression
	 
	 * </pre>
	 */
	protected void emit_ArgumentAnd_CommaKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'not' (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     (rule start) 'not' (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     (rule start) 'not' (ambiguity) nested+=ArgumentExpression
	 
	 * </pre>
	 */
	protected void emit_ArgumentNot_LeftParenthesisKeyword_2_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     arguments+=[ContractElement|QPREF] (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     arguments+=[ContractElement|QPREF] (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     arguments+=[ContractElement|QPREF] (ambiguity) nested+=ArgumentExpression
	 *     contracts+=[ContractElement|QPREF] (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     contracts+=[ContractElement|QPREF] (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     contracts+=[ContractElement|QPREF] (ambiguity) nested+=ArgumentExpression
	 *     nested+=ArgumentExpression (ambiguity) 'argument' arguments+=[ContractElement|QPREF]
	 *     nested+=ArgumentExpression (ambiguity) 'contract' contracts+=[ContractElement|QPREF]
	 *     nested+=ArgumentExpression (ambiguity) nested+=ArgumentExpression
	 
	 * </pre>
	 */
	protected void emit_ArgumentOr_CommaKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     declaredName=ID '{' ('input' 'assumptions')? 'assumptions' (ambiguity) assumptions+=AssumptionElement
	 *     domains+=[Domain|QPREF] ';'+ ('input' 'assumptions')? 'assumptions' (ambiguity) assumptions+=AssumptionElement
	 *     inputs+=InputAssumption 'assumptions' (ambiguity) assumptions+=AssumptionElement
	 *     queries+=Query ';'+ ('input' 'assumptions')? 'assumptions' (ambiguity) assumptions+=AssumptionElement
	 
	 * </pre>
	 */
	protected void emit_Assumptions_SemicolonKeyword_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     assumptions+=AssumptionElement (ambiguity) 'guarantee' '=&gt;' guarantee=Guarantee
	 *     assumptions+=AssumptionElement (ambiguity) 'guarantee' exact?='&lt;=&gt;'
	 *     assumptions+=AssumptionElement (ambiguity) '}' (rule end)
	 *     assumptions+=AssumptionElement (ambiguity) ('invocation' | 'analysis') ';'* analyses+=Analysis
	 *     assumptions+=AssumptionElement (ambiguity) assumptions+=AssumptionElement
	 
	 * </pre>
	 */
	protected void emit_Assumptions_SemicolonKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     declaredName=ID '{' 'claims' (ambiguity) claims+=Source
	 *     domains+=[Domain|QPREF] ';'+ 'claims' (ambiguity) claims+=Source
	 
	 * </pre>
	 */
	protected void emit_Claims_SemicolonKeyword_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     claims+=Source (ambiguity) 'contracts' ';'* contracts+=[Contract|QPREF]
	 *     claims+=Source (ambiguity) ('contracts' ';'*)? '}' (rule end)
	 *     claims+=Source (ambiguity) claims+=Source
	 
	 * </pre>
	 */
	protected void emit_Claims_SemicolonKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'invocation' | 'analysis'
	 *
	 * This ambiguous syntax occurs at:
	 *     assumptions+=AssumptionElement ';'+ (ambiguity) ';'* analyses+=Analysis
	 *     declaredName=ID '{' (ambiguity) ';'* analyses+=Analysis
	 *     domains+=[Domain|QPREF] ';'+ (ambiguity) ';'* analyses+=Analysis
	 *     guarantee=Guarantee ';' (ambiguity) ';'* analyses+=Analysis
	 *     inputs+=InputAssumption (ambiguity) ';'* analyses+=Analysis
	 *     queries+=Query ';'+ (ambiguity) ';'* analyses+=Analysis
	 
	 * </pre>
	 */
	protected void emit_Contract_AnalysisKeyword_8_0_1_or_InvocationKeyword_8_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('input' 'assumptions')?
	 *
	 * This ambiguous syntax occurs at:
	 *     declaredName=ID '{' (ambiguity) 'assumptions' ';'* assumptions+=AssumptionElement
	 *     domains+=[Domain|QPREF] ';'+ (ambiguity) 'assumptions' ';'* assumptions+=AssumptionElement
	 *     queries+=Query ';'+ (ambiguity) 'assumptions' ';'* assumptions+=AssumptionElement
	 
	 * </pre>
	 */
	protected void emit_Contract___InputKeyword_5_0_AssumptionsKeyword_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     declaredName=ID '{' 'domains' (ambiguity) domains+=[Domain|QPREF]
	 
	 * </pre>
	 */
	protected void emit_Domains_SemicolonKeyword_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     domains+=[Domain|QPREF] (ambiguity) 'argument' argumentExpression=ArgumentExpression
	 *     domains+=[Domain|QPREF] (ambiguity) 'claims' ';'* claims+=Source
	 *     domains+=[Domain|QPREF] (ambiguity) 'contracts' ';'* contracts+=[Contract|QPREF]
	 *     domains+=[Domain|QPREF] (ambiguity) 'guarantee' '=&gt;' guarantee=Guarantee
	 *     domains+=[Domain|QPREF] (ambiguity) 'guarantee' exact?='&lt;=&gt;'
	 *     domains+=[Domain|QPREF] (ambiguity) 'input' 'assumptions' inputs+=InputAssumption
	 *     domains+=[Domain|QPREF] (ambiguity) 'queries' ';'* queries+=Query
	 *     domains+=[Domain|QPREF] (ambiguity) '}' (rule end)
	 *     domains+=[Domain|QPREF] (ambiguity) ('contracts' ';'*)? '}' (rule end)
	 *     domains+=[Domain|QPREF] (ambiguity) ('input' 'assumptions')? 'assumptions' ';'* assumptions+=AssumptionElement
	 *     domains+=[Domain|QPREF] (ambiguity) ('invocation' | 'analysis') ';'* analyses+=Analysis
	 *     domains+=[Domain|QPREF] (ambiguity) domains+=[Domain|QPREF]
	 
	 * </pre>
	 */
	protected void emit_Domains_SemicolonKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     declaredName=ID '{' 'queries' (ambiguity) queries+=Query
	 *     domains+=[Domain|QPREF] ';'+ 'queries' (ambiguity) queries+=Query
	 *     parameter=Parameter '-&gt;' (ambiguity) queries+=Query
	 *     parameter=Parameter '-&gt;' (ambiguity) returnValue=Expression
	 
	 * </pre>
	 */
	protected void emit_Queries_SemicolonKeyword_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     queries+=Query (ambiguity) 'declarations' code=Source
	 *     queries+=Query (ambiguity) 'guarantee' '=&gt;' guarantee=Guarantee
	 *     queries+=Query (ambiguity) 'guarantee' exact?='&lt;=&gt;'
	 *     queries+=Query (ambiguity) 'input' 'assumptions' inputs+=InputAssumption
	 *     queries+=Query (ambiguity) '}' (rule end)
	 *     queries+=Query (ambiguity) ('input' 'assumptions')? 'assumptions' ';'* assumptions+=AssumptionElement
	 *     queries+=Query (ambiguity) ('invocation' | 'analysis') ';'* analyses+=Analysis
	 *     queries+=Query (ambiguity) queries+=Query
	 *     queries+=Query (ambiguity) returnValue=Expression
	 
	 * </pre>
	 */
	protected void emit_Queries_SemicolonKeyword_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' operand=CallExpression
	 *     (rule start) (ambiguity) '@' usage=[Usage|QPREF]
	 *     (rule start) (ambiguity) 'self' (rule start)
	 *     (rule start) (ambiguity) reference=[Element|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {AndExpression.left=}
	 *     (rule start) (ambiguity) {MemberCall.left=}
	 *     (rule start) (ambiguity) {OrExpression.left=}
	 *     (rule start) (ambiguity) {PropertyLookup.left=}
	 *     (rule start) (ambiguity) {TupleExpression.elements+=}
	 
	 * </pre>
	 */
	protected void emit_TerminalExpression_LeftParenthesisKeyword_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' operand=CallExpression
	 *     (rule start) (ambiguity) '@' usage=[Usage|QPREF]
	 *     (rule start) (ambiguity) 'self' (rule start)
	 *     (rule start) (ambiguity) reference=[Element|ID]
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {AndExpression.left=}
	 *     (rule start) (ambiguity) {MemberCall.left=}
	 *     (rule start) (ambiguity) {OrExpression.left=}
	 *     (rule start) (ambiguity) {PropertyLookup.left=}
	 *     (rule start) (ambiguity) {TupleExpression.elements+=}
	 
	 * </pre>
	 */
	protected void emit_TerminalExpression_LeftParenthesisKeyword_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'*
	 *
	 * This ambiguous syntax occurs at:
	 *     claims+=Source ';'+ 'contracts' (ambiguity) contracts+=[Contract|QPREF]
	 *     declaredName=ID '{' 'contracts' (ambiguity) contracts+=[Contract|QPREF]
	 *     domains+=[Domain|QPREF] ';'+ 'contracts' (ambiguity) contracts+=[Contract|QPREF]
	 
	 * </pre>
	 */
	protected void emit_VerificationPlan_SemicolonKeyword_6_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'+
	 *
	 * This ambiguous syntax occurs at:
	 *     contracts+=[Contract|QPREF] (ambiguity) '}' (rule end)
	 *     contracts+=[Contract|QPREF] (ambiguity) contracts+=[Contract|QPREF]
	 
	 * </pre>
	 */
	protected void emit_VerificationPlan_SemicolonKeyword_6_1_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('contracts' ';'*)?
	 *
	 * This ambiguous syntax occurs at:
	 *     claims+=Source ';'+ (ambiguity) '}' (rule end)
	 *     declaredName=ID '{' (ambiguity) '}' (rule end)
	 *     domains+=[Domain|QPREF] ';'+ (ambiguity) '}' (rule end)
	 
	 * </pre>
	 */
	protected void emit_VerificationPlan___ContractsKeyword_6_0_SemicolonKeyword_6_1_1_a__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
