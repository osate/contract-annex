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

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.MemberCall#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.contract.contract.MemberCall#getRight <em>Right</em>}</li>
 *   <li>{@link org.osate.contract.contract.MemberCall#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.osate.contract.contract.MemberCall#getLambda <em>Lambda</em>}</li>
 * </ul>
 *
 * @see org.osate.contract.contract.ContractPackage#getMemberCall()
 * @model
 * @generated
 */
public interface MemberCall extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see org.osate.contract.contract.ContractPackage#getMemberCall_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.MemberCall#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' attribute.
   * @see #setRight(String)
   * @see org.osate.contract.contract.ContractPackage#getMemberCall_Right()
   * @model
   * @generated
   */
  String getRight();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.MemberCall#getRight <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' attribute.
   * @see #getRight()
   * @generated
   */
  void setRight(String value);

  /**
   * Returns the value of the '<em><b>Argument</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument</em>' reference.
   * @see #setArgument(NamedElement)
   * @see org.osate.contract.contract.ContractPackage#getMemberCall_Argument()
   * @model
   * @generated
   */
  NamedElement getArgument();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.MemberCall#getArgument <em>Argument</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(NamedElement value);

  /**
   * Returns the value of the '<em><b>Lambda</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lambda</em>' containment reference.
   * @see #setLambda(Lambda)
   * @see org.osate.contract.contract.ContractPackage#getMemberCall_Lambda()
   * @model containment="true"
   * @generated
   */
  Lambda getLambda();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.MemberCall#getLambda <em>Lambda</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lambda</em>' containment reference.
   * @see #getLambda()
   * @generated
   */
  void setLambda(Lambda value);

} // MemberCall
