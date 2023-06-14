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
package org.osate.contract.contract;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.contract.contract.ContractPackage
 * @generated
 */
public interface ContractFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContractFactory eINSTANCE = org.osate.contract.contract.impl.ContractFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Library</em>'.
   * @generated
   */
  ContractLibrary createContractLibrary();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  ContractElement createContractElement();

  /**
   * Returns a new object of class '<em>Contract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Contract</em>'.
   * @generated
   */
  Contract createContract();

  /**
   * Returns a new object of class '<em>Input Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Assumption</em>'.
   * @generated
   */
  InputAssumption createInputAssumption();

  /**
   * Returns a new object of class '<em>Assumption Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assumption Element</em>'.
   * @generated
   */
  AssumptionElement createAssumptionElement();

  /**
   * Returns a new object of class '<em>Guarantee</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guarantee</em>'.
   * @generated
   */
  Guarantee createGuarantee();

  /**
   * Returns a new object of class '<em>Analysis</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Analysis</em>'.
   * @generated
   */
  Analysis createAnalysis();

  /**
   * Returns a new object of class '<em>Source</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Source</em>'.
   * @generated
   */
  Source createSource();

  /**
   * Returns a new object of class '<em>Implementation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation</em>'.
   * @generated
   */
  Implementation createImplementation();

  /**
   * Returns a new object of class '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain</em>'.
   * @generated
   */
  Domain createDomain();

  /**
   * Returns a new object of class '<em>Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument</em>'.
   * @generated
   */
  Argument createArgument();

  /**
   * Returns a new object of class '<em>Argument Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Expression</em>'.
   * @generated
   */
  ArgumentExpression createArgumentExpression();

  /**
   * Returns a new object of class '<em>Verification Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Plan</em>'.
   * @generated
   */
  VerificationPlan createVerificationPlan();

  /**
   * Returns a new object of class '<em>Query</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query</em>'.
   * @generated
   */
  Query createQuery();

  /**
   * Returns a new object of class '<em>Single Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Val Declaration</em>'.
   * @generated
   */
  SingleValDeclaration createSingleValDeclaration();

  /**
   * Returns a new object of class '<em>Tuple Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Name</em>'.
   * @generated
   */
  TupleName createTupleName();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Lambda</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lambda</em>'.
   * @generated
   */
  Lambda createLambda();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Single Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Parameter</em>'.
   * @generated
   */
  SingleParameter createSingleParameter();

  /**
   * Returns a new object of class '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subclause</em>'.
   * @generated
   */
  ContractSubclause createContractSubclause();

  /**
   * Returns a new object of class '<em>IString</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IString</em>'.
   * @generated
   */
  IString createIString();

  /**
   * Returns a new object of class '<em>IString Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IString Part</em>'.
   * @generated
   */
  IStringPart createIStringPart();

  /**
   * Returns a new object of class '<em>IString Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IString Literal</em>'.
   * @generated
   */
  IStringLiteral createIStringLiteral();

  /**
   * Returns a new object of class '<em>IString Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IString Var</em>'.
   * @generated
   */
  IStringVar createIStringVar();

  /**
   * Returns a new object of class '<em>Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assumption</em>'.
   * @generated
   */
  ContractAssumption createContractAssumption();

  /**
   * Returns a new object of class '<em>Argument Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Argument Assumption</em>'.
   * @generated
   */
  ArgumentAssumption createArgumentAssumption();

  /**
   * Returns a new object of class '<em>Code Assumption</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Assumption</em>'.
   * @generated
   */
  CodeAssumption createCodeAssumption();

  /**
   * Returns a new object of class '<em>Tuple Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Declaration</em>'.
   * @generated
   */
  TupleDeclaration createTupleDeclaration();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Expression</em>'.
   * @generated
   */
  NotExpression createNotExpression();

  /**
   * Returns a new object of class '<em>Member Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Member Call</em>'.
   * @generated
   */
  MemberCall createMemberCall();

  /**
   * Returns a new object of class '<em>Property Lookup</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Lookup</em>'.
   * @generated
   */
  PropertyLookup createPropertyLookup();

  /**
   * Returns a new object of class '<em>Tuple Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Parameter</em>'.
   * @generated
   */
  TupleParameter createTupleParameter();

  /**
   * Returns a new object of class '<em>Self Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Self Expression</em>'.
   * @generated
   */
  SelfExpression createSelfExpression();

  /**
   * Returns a new object of class '<em>Root Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root Expression</em>'.
   * @generated
   */
  RootExpression createRootExpression();

  /**
   * Returns a new object of class '<em>Name Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Reference</em>'.
   * @generated
   */
  NameReference createNameReference();

  /**
   * Returns a new object of class '<em>Tuple Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Expression</em>'.
   * @generated
   */
  TupleExpression createTupleExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ContractPackage getContractPackage();

} //ContractFactory
