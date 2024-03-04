
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
package org.osate.contract.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.AndExpression;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAnd;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ArgumentNot;
import org.osate.contract.contract.ArgumentOr;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.ContractSubclause;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.Guarantee;
import org.osate.contract.contract.IString;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Implementation;
import org.osate.contract.contract.InputAssumption;
import org.osate.contract.contract.Lambda;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.contract.NameReference;
import org.osate.contract.contract.NotExpression;
import org.osate.contract.contract.OrExpression;
import org.osate.contract.contract.PropertyLookup;
import org.osate.contract.contract.RootExpression;
import org.osate.contract.contract.SelfExpression;
import org.osate.contract.contract.SingleParameter;
import org.osate.contract.contract.SingleValDeclaration;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.TupleDeclaration;
import org.osate.contract.contract.TupleExpression;
import org.osate.contract.contract.TupleName;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.services.ContractGrammarAccess;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;

@SuppressWarnings("all")
public class ContractSemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private ContractGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_VALUE:
				sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == ContractPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ContractPackage.ANALYSIS:
				sequence_Analysis(context, (Analysis) semanticObject); 
				return; 
			case ContractPackage.AND_EXPRESSION:
				sequence_AndExpression(context, (AndExpression) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT:
				sequence_Argument_Domains_Exact(context, (Argument) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT_AND:
				sequence_ArgumentAnd_ArgumentTerm(context, (ArgumentAnd) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT_ASSUMPTION:
				sequence_AssumptionElement(context, (ArgumentAssumption) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT_EXPRESSION:
				sequence_ArgumentTerm(context, (ArgumentExpression) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT_NOT:
				sequence_ArgumentNot_ArgumentTerm(context, (ArgumentNot) semanticObject); 
				return; 
			case ContractPackage.ARGUMENT_OR:
				sequence_ArgumentOr_ArgumentTerm(context, (ArgumentOr) semanticObject); 
				return; 
			case ContractPackage.CODE_ASSUMPTION:
				sequence_AssumptionElement_Exact(context, (CodeAssumption) semanticObject); 
				return; 
			case ContractPackage.CONTRACT:
				sequence_Analyses_Assumptions_Contract_Domains_Exact_Queries(context, (Contract) semanticObject); 
				return; 
			case ContractPackage.CONTRACT_ASSUMPTION:
				sequence_AssumptionElement(context, (ContractAssumption) semanticObject); 
				return; 
			case ContractPackage.CONTRACT_LIBRARY:
				sequence_ContractLibrary(context, (ContractLibrary) semanticObject); 
				return; 
			case ContractPackage.CONTRACT_SUBCLAUSE:
				sequence_ContractSubclause(context, (ContractSubclause) semanticObject); 
				return; 
			case ContractPackage.DOMAIN:
				sequence_Domain_Queries(context, (Domain) semanticObject); 
				return; 
			case ContractPackage.GUARANTEE:
				sequence_Guarantee(context, (Guarantee) semanticObject); 
				return; 
			case ContractPackage.ISTRING:
				sequence_IString(context, (IString) semanticObject); 
				return; 
			case ContractPackage.ISTRING_LITERAL:
				if (rule == grammarAccess.getIStringLeftLiteralRule()) {
					sequence_IStringLeftLiteral(context, (IStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getIStringPartRule()
						|| rule == grammarAccess.getIStringLiteralRule()) {
					sequence_IStringLiteral(context, (IStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getIStringMiddleLiteralRule()) {
					sequence_IStringMiddleLiteral(context, (IStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getIStringRightLiteralRule()) {
					sequence_IStringRightLiteral(context, (IStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case ContractPackage.ISTRING_VAR:
				sequence_IStringInter(context, (IStringVar) semanticObject); 
				return; 
			case ContractPackage.IMPLEMENTATION:
				sequence_Implementation(context, (Implementation) semanticObject); 
				return; 
			case ContractPackage.INPUT_ASSUMPTION:
				sequence_InputAssumption(context, (InputAssumption) semanticObject); 
				return; 
			case ContractPackage.LAMBDA:
				sequence_Lambda_Queries(context, (Lambda) semanticObject); 
				return; 
			case ContractPackage.MEMBER_CALL:
				sequence_CallExpression(context, (MemberCall) semanticObject); 
				return; 
			case ContractPackage.NAME_REFERENCE:
				sequence_TerminalExpression(context, (NameReference) semanticObject); 
				return; 
			case ContractPackage.NOT_EXPRESSION:
				sequence_NotExpression(context, (NotExpression) semanticObject); 
				return; 
			case ContractPackage.OR_EXPRESSION:
				sequence_Expression(context, (OrExpression) semanticObject); 
				return; 
			case ContractPackage.PROPERTY_LOOKUP:
				sequence_CallExpression(context, (PropertyLookup) semanticObject); 
				return; 
			case ContractPackage.ROOT_EXPRESSION:
				sequence_TerminalExpression(context, (RootExpression) semanticObject); 
				return; 
			case ContractPackage.SELF_EXPRESSION:
				sequence_TerminalExpression(context, (SelfExpression) semanticObject); 
				return; 
			case ContractPackage.SINGLE_PARAMETER:
				sequence_SingleParameter(context, (SingleParameter) semanticObject); 
				return; 
			case ContractPackage.SINGLE_VAL_DECLARATION:
				sequence_SingleValDeclaration(context, (SingleValDeclaration) semanticObject); 
				return; 
			case ContractPackage.SOURCE:
				sequence_Source(context, (Source) semanticObject); 
				return; 
			case ContractPackage.STRING_LITERAL:
				sequence_TerminalExpression(context, (org.osate.contract.contract.StringLiteral) semanticObject); 
				return; 
			case ContractPackage.TUPLE_DECLARATION:
				sequence_Query(context, (TupleDeclaration) semanticObject); 
				return; 
			case ContractPackage.TUPLE_EXPRESSION:
				sequence_TerminalExpression(context, (TupleExpression) semanticObject); 
				return; 
			case ContractPackage.TUPLE_NAME:
				sequence_TupleName(context, (TupleName) semanticObject); 
				return; 
			case ContractPackage.TUPLE_PARAMETER:
				sequence_Parameter(context, (TupleParameter) semanticObject); 
				return; 
			case ContractPackage.VERIFICATION_PLAN:
				sequence_Claims_Domains_VerificationPlan(context, (VerificationPlan) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Contract
	 *     ContractElement returns Contract
	 *     Contract returns Contract
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         domains+=[Domain|QPREF]* 
	 *         queries+=Query* 
	 *         inputs+=InputAssumption* 
	 *         assumptions+=AssumptionElement* 
	 *         (exact?='&lt;=&gt;'? guarantee=Guarantee)? 
	 *         analyses+=Analysis*
	 *     )
	 * </pre>
	 */
	protected void sequence_Analyses_Assumptions_Contract_Domains_Exact_Queries(ISerializationContext context, Contract semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Analysis returns Analysis
	 *
	 * Constraint:
	 *     code=Source
	 * </pre>
	 */
	protected void sequence_Analysis(ISerializationContext context, Analysis semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ANALYSIS__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ANALYSIS__CODE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAnalysisAccess().getCodeSourceParserRuleCall_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns AndExpression
	 *     Expression.OrExpression_1_0 returns AndExpression
	 *     AndExpression returns AndExpression
	 *     AndExpression.AndExpression_1_0 returns AndExpression
	 *     NotExpression returns AndExpression
	 *     CallExpression returns AndExpression
	 *     CallExpression.MemberCall_1_0_0 returns AndExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns AndExpression
	 *     TerminalExpression returns AndExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns AndExpression
	 *
	 * Constraint:
	 *     (left=AndExpression_AndExpression_1_0 right=NotExpression)
	 * </pre>
	 */
	protected void sequence_AndExpression(ISerializationContext context, AndExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.AND_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.AND_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.AND_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.AND_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentExpression returns ArgumentAnd
	 *     ArgumentAnd returns ArgumentAnd
	 *
	 * Constraint:
	 *     (contracts+=[ContractElement|QPREF] | arguments+=[ContractElement|QPREF] | nested+=ArgumentExpression)+
	 * </pre>
	 */
	protected void sequence_ArgumentAnd_ArgumentTerm(ISerializationContext context, ArgumentAnd semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentExpression returns ArgumentNot
	 *     ArgumentNot returns ArgumentNot
	 *
	 * Constraint:
	 *     (contracts+=[ContractElement|QPREF] | arguments+=[ContractElement|QPREF] | nested+=ArgumentExpression)
	 * </pre>
	 */
	protected void sequence_ArgumentNot_ArgumentTerm(ISerializationContext context, ArgumentNot semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentExpression returns ArgumentOr
	 *     ArgumentOr returns ArgumentOr
	 *
	 * Constraint:
	 *     (contracts+=[ContractElement|QPREF] | arguments+=[ContractElement|QPREF] | nested+=ArgumentExpression)+
	 * </pre>
	 */
	protected void sequence_ArgumentOr_ArgumentTerm(ISerializationContext context, ArgumentOr semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ArgumentExpression returns ArgumentExpression
	 *     ArgumentNot returns ArgumentExpression
	 *
	 * Constraint:
	 *     (contracts+=[ContractElement|QPREF] | arguments+=[ContractElement|QPREF] | nested+=ArgumentExpression)
	 * </pre>
	 */
	protected void sequence_ArgumentTerm(ISerializationContext context, ArgumentExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Argument
	 *     ContractElement returns Argument
	 *     Argument returns Argument
	 *
	 * Constraint:
	 *     (name=ID domains+=[Domain|QPREF]* (exact?='&lt;=&gt;'? guarantee=Guarantee)? argumentExpression=ArgumentExpression?)
	 * </pre>
	 */
	protected void sequence_Argument_Domains_Exact(ISerializationContext context, Argument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssumptionElement returns ArgumentAssumption
	 *
	 * Constraint:
	 *     argument=[ContractElement|QPREF]
	 * </pre>
	 */
	protected void sequence_AssumptionElement(ISerializationContext context, ArgumentAssumption semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ARGUMENT_ASSUMPTION__ARGUMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ARGUMENT_ASSUMPTION__ARGUMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssumptionElementAccess().getArgumentContractElementQPREFParserRuleCall_1_2_0_1(), semanticObject.eGet(ContractPackage.Literals.ARGUMENT_ASSUMPTION__ARGUMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssumptionElement returns ContractAssumption
	 *
	 * Constraint:
	 *     contract=[ContractElement|QPREF]
	 * </pre>
	 */
	protected void sequence_AssumptionElement(ISerializationContext context, ContractAssumption semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.CONTRACT_ASSUMPTION__CONTRACT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.CONTRACT_ASSUMPTION__CONTRACT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssumptionElementAccess().getContractContractElementQPREFParserRuleCall_0_2_0_1(), semanticObject.eGet(ContractPackage.Literals.CONTRACT_ASSUMPTION__CONTRACT, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssumptionElement returns CodeAssumption
	 *
	 * Constraint:
	 *     (code=Source (exact?='&lt;=&gt;'? guarantee=Guarantee)?)
	 * </pre>
	 */
	protected void sequence_AssumptionElement_Exact(ISerializationContext context, CodeAssumption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns MemberCall
	 *     Expression.OrExpression_1_0 returns MemberCall
	 *     AndExpression returns MemberCall
	 *     AndExpression.AndExpression_1_0 returns MemberCall
	 *     NotExpression returns MemberCall
	 *     CallExpression returns MemberCall
	 *     CallExpression.MemberCall_1_0_0 returns MemberCall
	 *     CallExpression.PropertyLookup_1_1_0 returns MemberCall
	 *     TerminalExpression returns MemberCall
	 *     TerminalExpression.TupleExpression_4_2_0 returns MemberCall
	 *
	 * Constraint:
	 *     (left=CallExpression_MemberCall_1_0_0 right=ID typeArgument=ID? argument=Expression? lambda=Lambda?)
	 * </pre>
	 */
	protected void sequence_CallExpression(ISerializationContext context, MemberCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns PropertyLookup
	 *     Expression.OrExpression_1_0 returns PropertyLookup
	 *     AndExpression returns PropertyLookup
	 *     AndExpression.AndExpression_1_0 returns PropertyLookup
	 *     NotExpression returns PropertyLookup
	 *     CallExpression returns PropertyLookup
	 *     CallExpression.MemberCall_1_0_0 returns PropertyLookup
	 *     CallExpression.PropertyLookup_1_1_0 returns PropertyLookup
	 *     TerminalExpression returns PropertyLookup
	 *     TerminalExpression.TupleExpression_4_2_0 returns PropertyLookup
	 *
	 * Constraint:
	 *     (left=CallExpression_PropertyLookup_1_1_0 right=[Property|QPREF])
	 * </pre>
	 */
	protected void sequence_CallExpression(ISerializationContext context, PropertyLookup semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.PROPERTY_LOOKUP__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.PROPERTY_LOOKUP__LEFT));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.PROPERTY_LOOKUP__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.PROPERTY_LOOKUP__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCallExpressionAccess().getPropertyLookupLeftAction_1_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getCallExpressionAccess().getRightPropertyQPREFParserRuleCall_1_1_2_0_1(), semanticObject.eGet(ContractPackage.Literals.PROPERTY_LOOKUP__RIGHT, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns VerificationPlan
	 *     ContractElement returns VerificationPlan
	 *     VerificationPlan returns VerificationPlan
	 *
	 * Constraint:
	 *     (name=ID componentImplementation=[ComponentImplementation|QCREF] domains+=[Domain|QPREF]* claims+=Source* contracts+=[Contract|QPREF]*)
	 * </pre>
	 */
	protected void sequence_Claims_Domains_VerificationPlan(ISerializationContext context, VerificationPlan semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AnnexLibrary returns ContractLibrary
	 *     ContractLibrary returns ContractLibrary
	 *
	 * Constraint:
	 *     contractElements+=ContractElement*
	 * </pre>
	 */
	protected void sequence_ContractLibrary(ISerializationContext context, ContractLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AnnexSubclause returns ContractSubclause
	 *     ContractSubclause returns ContractSubclause
	 *
	 * Constraint:
	 *     (useQueries+=[Contract|QPREF]* verifyPlans+=[VerificationPlan|QPREF]*)
	 * </pre>
	 */
	protected void sequence_ContractSubclause(ISerializationContext context, ContractSubclause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Domain
	 *     ContractElement returns Domain
	 *     Domain returns Domain
	 *
	 * Constraint:
	 *     (name=ID queries+=Query* code=Source?)
	 * </pre>
	 */
	protected void sequence_Domain_Queries(ISerializationContext context, Domain semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns OrExpression
	 *     Expression.OrExpression_1_0 returns OrExpression
	 *     AndExpression returns OrExpression
	 *     AndExpression.AndExpression_1_0 returns OrExpression
	 *     NotExpression returns OrExpression
	 *     CallExpression returns OrExpression
	 *     CallExpression.MemberCall_1_0_0 returns OrExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns OrExpression
	 *     TerminalExpression returns OrExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns OrExpression
	 *
	 * Constraint:
	 *     (left=Expression_OrExpression_1_0 right=AndExpression)
	 * </pre>
	 */
	protected void sequence_Expression(ISerializationContext context, OrExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.OR_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.OR_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.OR_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.OR_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExpressionAccess().getOrExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Guarantee returns Guarantee
	 *
	 * Constraint:
	 *     code=Source
	 * </pre>
	 */
	protected void sequence_Guarantee(ISerializationContext context, Guarantee semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.GUARANTEE__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.GUARANTEE__CODE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGuaranteeAccess().getCodeSourceParserRuleCall_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IStringPart returns IStringVar
	 *     IStringInter returns IStringVar
	 *
	 * Constraint:
	 *     (direct?=':'? ((domain=[Domain|ID]? query=[SingleValDeclaration|ID]) | predefined=Predefined))
	 * </pre>
	 */
	protected void sequence_IStringInter(ISerializationContext context, IStringVar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IStringLeftLiteral returns IStringLiteral
	 *
	 * Constraint:
	 *     value=ISTRING_LEFT
	 * </pre>
	 */
	protected void sequence_IStringLeftLiteral(ISerializationContext context, IStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIStringLeftLiteralAccess().getValueISTRING_LEFTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IStringPart returns IStringLiteral
	 *     IStringLiteral returns IStringLiteral
	 *
	 * Constraint:
	 *     value=ISTRING_TEXT
	 * </pre>
	 */
	protected void sequence_IStringLiteral(ISerializationContext context, IStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIStringLiteralAccess().getValueISTRING_TEXTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IStringMiddleLiteral returns IStringLiteral
	 *
	 * Constraint:
	 *     value=ISTRING_MIDDLE
	 * </pre>
	 */
	protected void sequence_IStringMiddleLiteral(ISerializationContext context, IStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIStringMiddleLiteralAccess().getValueISTRING_MIDDLETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IStringRightLiteral returns IStringLiteral
	 *
	 * Constraint:
	 *     value=ISTRING_RIGHT
	 * </pre>
	 */
	protected void sequence_IStringRightLiteral(ISerializationContext context, IStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.ISTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIStringRightLiteralAccess().getValueISTRING_RIGHTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IString returns IString
	 *
	 * Constraint:
	 *     (
	 *         parts+=IStringLiteral | 
	 *         (parts+=IStringLeftLiteral parts+=IStringInter? (parts+=IStringMiddleLiteral parts+=IStringInter?)* parts+=IStringRightLiteral)
	 *     )
	 * </pre>
	 */
	protected void sequence_IString(ISerializationContext context, IString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Implementation
	 *     ContractElement returns Implementation
	 *     Implementation returns Implementation
	 *
	 * Constraint:
	 *     (name=ID code=Source)
	 * </pre>
	 */
	protected void sequence_Implementation(ISerializationContext context, Implementation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.IMPLEMENTATION__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.IMPLEMENTATION__CODE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImplementationAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getImplementationAccess().getCodeSourceParserRuleCall_4_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     InputAssumption returns InputAssumption
	 *
	 * Constraint:
	 *     code=Source?
	 * </pre>
	 */
	protected void sequence_InputAssumption(ISerializationContext context, InputAssumption semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Lambda
	 *     Lambda returns Lambda
	 *
	 * Constraint:
	 *     (parameter=Parameter queries+=Query* returnValue=Expression)
	 * </pre>
	 */
	protected void sequence_Lambda_Queries(ISerializationContext context, Lambda semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns NotExpression
	 *     Expression.OrExpression_1_0 returns NotExpression
	 *     AndExpression returns NotExpression
	 *     AndExpression.AndExpression_1_0 returns NotExpression
	 *     NotExpression returns NotExpression
	 *     CallExpression returns NotExpression
	 *     CallExpression.MemberCall_1_0_0 returns NotExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns NotExpression
	 *     TerminalExpression returns NotExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns NotExpression
	 *
	 * Constraint:
	 *     operand=CallExpression
	 * </pre>
	 */
	protected void sequence_NotExpression(ISerializationContext context, NotExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.NOT_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.NOT_EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNotExpressionAccess().getOperandCallExpressionParserRuleCall_1_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns TupleParameter
	 *     Parameter returns TupleParameter
	 *
	 * Constraint:
	 *     (names+=TupleName names+=TupleName+)
	 * </pre>
	 */
	protected void sequence_Parameter(ISerializationContext context, TupleParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns TupleDeclaration
	 *     Query returns TupleDeclaration
	 *
	 * Constraint:
	 *     (names+=TupleName names+=TupleName+ value=Expression)
	 * </pre>
	 */
	protected void sequence_Query(ISerializationContext context, TupleDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns SingleParameter
	 *     NamedElement returns SingleParameter
	 *     Parameter returns SingleParameter
	 *     SingleParameter returns SingleParameter
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_SingleParameter(ISerializationContext context, SingleParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleParameterAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns SingleValDeclaration
	 *     NamedElement returns SingleValDeclaration
	 *     Query returns SingleValDeclaration
	 *     SingleValDeclaration returns SingleValDeclaration
	 *
	 * Constraint:
	 *     (name=ID value=Expression)
	 * </pre>
	 */
	protected void sequence_SingleValDeclaration(ISerializationContext context, SingleValDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.QUERY__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.QUERY__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSingleValDeclarationAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSingleValDeclarationAccess().getValueExpressionParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Source returns Source
	 *
	 * Constraint:
	 *     (language=Language? (source=SSTRING | inter=IString))
	 * </pre>
	 */
	protected void sequence_Source(ISerializationContext context, Source semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns NameReference
	 *     Expression.OrExpression_1_0 returns NameReference
	 *     AndExpression returns NameReference
	 *     AndExpression.AndExpression_1_0 returns NameReference
	 *     NotExpression returns NameReference
	 *     CallExpression returns NameReference
	 *     CallExpression.MemberCall_1_0_0 returns NameReference
	 *     CallExpression.PropertyLookup_1_1_0 returns NameReference
	 *     TerminalExpression returns NameReference
	 *     TerminalExpression.TupleExpression_4_2_0 returns NameReference
	 *
	 * Constraint:
	 *     reference=[NamedElement|ID]
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, NameReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.NAME_REFERENCE__REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.NAME_REFERENCE__REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getReferenceNamedElementIDTerminalRuleCall_3_1_0_1(), semanticObject.eGet(ContractPackage.Literals.NAME_REFERENCE__REFERENCE, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns RootExpression
	 *     Expression.OrExpression_1_0 returns RootExpression
	 *     AndExpression returns RootExpression
	 *     AndExpression.AndExpression_1_0 returns RootExpression
	 *     NotExpression returns RootExpression
	 *     CallExpression returns RootExpression
	 *     CallExpression.MemberCall_1_0_0 returns RootExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns RootExpression
	 *     TerminalExpression returns RootExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns RootExpression
	 *
	 * Constraint:
	 *     {RootExpression}
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, RootExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns SelfExpression
	 *     Expression.OrExpression_1_0 returns SelfExpression
	 *     AndExpression returns SelfExpression
	 *     AndExpression.AndExpression_1_0 returns SelfExpression
	 *     NotExpression returns SelfExpression
	 *     CallExpression returns SelfExpression
	 *     CallExpression.MemberCall_1_0_0 returns SelfExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns SelfExpression
	 *     TerminalExpression returns SelfExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns SelfExpression
	 *
	 * Constraint:
	 *     {SelfExpression}
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, SelfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns StringLiteral
	 *     Expression.OrExpression_1_0 returns StringLiteral
	 *     AndExpression returns StringLiteral
	 *     AndExpression.AndExpression_1_0 returns StringLiteral
	 *     NotExpression returns StringLiteral
	 *     CallExpression returns StringLiteral
	 *     CallExpression.MemberCall_1_0_0 returns StringLiteral
	 *     CallExpression.PropertyLookup_1_1_0 returns StringLiteral
	 *     TerminalExpression returns StringLiteral
	 *     TerminalExpression.TupleExpression_4_2_0 returns StringLiteral
	 *
	 * Constraint:
	 *     value=STRING
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, org.osate.contract.contract.StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.STRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns TupleExpression
	 *     Expression.OrExpression_1_0 returns TupleExpression
	 *     AndExpression returns TupleExpression
	 *     AndExpression.AndExpression_1_0 returns TupleExpression
	 *     NotExpression returns TupleExpression
	 *     CallExpression returns TupleExpression
	 *     CallExpression.MemberCall_1_0_0 returns TupleExpression
	 *     CallExpression.PropertyLookup_1_1_0 returns TupleExpression
	 *     TerminalExpression returns TupleExpression
	 *     TerminalExpression.TupleExpression_4_2_0 returns TupleExpression
	 *
	 * Constraint:
	 *     (elements+=TerminalExpression_TupleExpression_4_2_0 elements+=Expression+)
	 * </pre>
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, TupleExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns TupleName
	 *     TupleName returns TupleName
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_TupleName(ISerializationContext context, TupleName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTupleNameAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
