/**
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
 */
package org.osate.contract.contract.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.contract.contract.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContractFactoryImpl extends EFactoryImpl implements ContractFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ContractFactory init()
  {
    try
    {
      ContractFactory theContractFactory = (ContractFactory)EPackage.Registry.INSTANCE.getEFactory(ContractPackage.eNS_URI);
      if (theContractFactory != null)
      {
        return theContractFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ContractFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ContractPackage.CONTRACT_LIBRARY: return createContractLibrary();
      case ContractPackage.CONTRACT_ELEMENT: return createContractElement();
      case ContractPackage.CONTRACT: return createContract();
      case ContractPackage.INPUT_ASSUMPTION: return createInputAssumption();
      case ContractPackage.ASSUMPTION_ELEMENT: return createAssumptionElement();
      case ContractPackage.GUARANTEE: return createGuarantee();
      case ContractPackage.ANALYSIS: return createAnalysis();
      case ContractPackage.SOURCE: return createSource();
      case ContractPackage.IMPLEMENTATION: return createImplementation();
      case ContractPackage.DOMAIN: return createDomain();
      case ContractPackage.ARGUMENT: return createArgument();
      case ContractPackage.ARGUMENT_EXPRESSION: return createArgumentExpression();
      case ContractPackage.VERIFICATION_PLAN: return createVerificationPlan();
      case ContractPackage.QUERY: return createQuery();
      case ContractPackage.SINGLE_VAL_DECLARATION: return createSingleValDeclaration();
      case ContractPackage.TUPLE_NAME: return createTupleName();
      case ContractPackage.EXPRESSION: return createExpression();
      case ContractPackage.LAMBDA: return createLambda();
      case ContractPackage.PARAMETER: return createParameter();
      case ContractPackage.SINGLE_PARAMETER: return createSingleParameter();
      case ContractPackage.CONTRACT_SUBCLAUSE: return createContractSubclause();
      case ContractPackage.ISTRING: return createIString();
      case ContractPackage.ISTRING_PART: return createIStringPart();
      case ContractPackage.ISTRING_LITERAL: return createIStringLiteral();
      case ContractPackage.ISTRING_VAR: return createIStringVar();
      case ContractPackage.CONTRACT_ASSUMPTION: return createContractAssumption();
      case ContractPackage.ARGUMENT_ASSUMPTION: return createArgumentAssumption();
      case ContractPackage.CODE_ASSUMPTION: return createCodeAssumption();
      case ContractPackage.TUPLE_DECLARATION: return createTupleDeclaration();
      case ContractPackage.OR_EXPRESSION: return createOrExpression();
      case ContractPackage.AND_EXPRESSION: return createAndExpression();
      case ContractPackage.NOT_EXPRESSION: return createNotExpression();
      case ContractPackage.MEMBER_CALL: return createMemberCall();
      case ContractPackage.PROPERTY_LOOKUP: return createPropertyLookup();
      case ContractPackage.TUPLE_PARAMETER: return createTupleParameter();
      case ContractPackage.SELF_EXPRESSION: return createSelfExpression();
      case ContractPackage.ROOT_EXPRESSION: return createRootExpression();
      case ContractPackage.NAME_REFERENCE: return createNameReference();
      case ContractPackage.TUPLE_EXPRESSION: return createTupleExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ContractPackage.LANGUAGE:
        return createLanguageFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ContractPackage.LANGUAGE:
        return convertLanguageToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractLibrary createContractLibrary()
  {
    ContractLibraryImpl contractLibrary = new ContractLibraryImpl();
    return contractLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractElement createContractElement()
  {
    ContractElementImpl contractElement = new ContractElementImpl();
    return contractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Contract createContract()
  {
    ContractImpl contract = new ContractImpl();
    return contract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InputAssumption createInputAssumption()
  {
    InputAssumptionImpl inputAssumption = new InputAssumptionImpl();
    return inputAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssumptionElement createAssumptionElement()
  {
    AssumptionElementImpl assumptionElement = new AssumptionElementImpl();
    return assumptionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Guarantee createGuarantee()
  {
    GuaranteeImpl guarantee = new GuaranteeImpl();
    return guarantee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Analysis createAnalysis()
  {
    AnalysisImpl analysis = new AnalysisImpl();
    return analysis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Source createSource()
  {
    SourceImpl source = new SourceImpl();
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Implementation createImplementation()
  {
    ImplementationImpl implementation = new ImplementationImpl();
    return implementation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Domain createDomain()
  {
    DomainImpl domain = new DomainImpl();
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Argument createArgument()
  {
    ArgumentImpl argument = new ArgumentImpl();
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpression createArgumentExpression()
  {
    ArgumentExpressionImpl argumentExpression = new ArgumentExpressionImpl();
    return argumentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VerificationPlan createVerificationPlan()
  {
    VerificationPlanImpl verificationPlan = new VerificationPlanImpl();
    return verificationPlan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Query createQuery()
  {
    QueryImpl query = new QueryImpl();
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleValDeclaration createSingleValDeclaration()
  {
    SingleValDeclarationImpl singleValDeclaration = new SingleValDeclarationImpl();
    return singleValDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleName createTupleName()
  {
    TupleNameImpl tupleName = new TupleNameImpl();
    return tupleName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Lambda createLambda()
  {
    LambdaImpl lambda = new LambdaImpl();
    return lambda;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleParameter createSingleParameter()
  {
    SingleParameterImpl singleParameter = new SingleParameterImpl();
    return singleParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractSubclause createContractSubclause()
  {
    ContractSubclauseImpl contractSubclause = new ContractSubclauseImpl();
    return contractSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IString createIString()
  {
    IStringImpl iString = new IStringImpl();
    return iString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IStringPart createIStringPart()
  {
    IStringPartImpl iStringPart = new IStringPartImpl();
    return iStringPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IStringLiteral createIStringLiteral()
  {
    IStringLiteralImpl iStringLiteral = new IStringLiteralImpl();
    return iStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IStringVar createIStringVar()
  {
    IStringVarImpl iStringVar = new IStringVarImpl();
    return iStringVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractAssumption createContractAssumption()
  {
    ContractAssumptionImpl contractAssumption = new ContractAssumptionImpl();
    return contractAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentAssumption createArgumentAssumption()
  {
    ArgumentAssumptionImpl argumentAssumption = new ArgumentAssumptionImpl();
    return argumentAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CodeAssumption createCodeAssumption()
  {
    CodeAssumptionImpl codeAssumption = new CodeAssumptionImpl();
    return codeAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleDeclaration createTupleDeclaration()
  {
    TupleDeclarationImpl tupleDeclaration = new TupleDeclarationImpl();
    return tupleDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotExpression createNotExpression()
  {
    NotExpressionImpl notExpression = new NotExpressionImpl();
    return notExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MemberCall createMemberCall()
  {
    MemberCallImpl memberCall = new MemberCallImpl();
    return memberCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyLookup createPropertyLookup()
  {
    PropertyLookupImpl propertyLookup = new PropertyLookupImpl();
    return propertyLookup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleParameter createTupleParameter()
  {
    TupleParameterImpl tupleParameter = new TupleParameterImpl();
    return tupleParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SelfExpression createSelfExpression()
  {
    SelfExpressionImpl selfExpression = new SelfExpressionImpl();
    return selfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RootExpression createRootExpression()
  {
    RootExpressionImpl rootExpression = new RootExpressionImpl();
    return rootExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NameReference createNameReference()
  {
    NameReferenceImpl nameReference = new NameReferenceImpl();
    return nameReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleExpression createTupleExpression()
  {
    TupleExpressionImpl tupleExpression = new TupleExpressionImpl();
    return tupleExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Language createLanguageFromString(EDataType eDataType, String initialValue)
  {
    Language result = Language.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertLanguageToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractPackage getContractPackage()
  {
    return (ContractPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ContractPackage getPackage()
  {
    return ContractPackage.eINSTANCE;
  }

} //ContractFactoryImpl
