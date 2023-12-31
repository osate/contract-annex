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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.Argument#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.contract.contract.Argument#isExact <em>Exact</em>}</li>
 *   <li>{@link org.osate.contract.contract.Argument#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.osate.contract.contract.Argument#getArgumentExpression <em>Argument Expression</em>}</li>
 * </ul>
 *
 * @see org.osate.contract.contract.ContractPackage#getArgument()
 * @model
 * @generated
 */
public interface Argument extends ContractElement
{
  /**
   * Returns the value of the '<em><b>Domains</b></em>' reference list.
   * The list contents are of type {@link org.osate.contract.contract.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domains</em>' reference list.
   * @see org.osate.contract.contract.ContractPackage#getArgument_Domains()
   * @model
   * @generated
   */
  EList<Domain> getDomains();

  /**
   * Returns the value of the '<em><b>Exact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exact</em>' attribute.
   * @see #setExact(boolean)
   * @see org.osate.contract.contract.ContractPackage#getArgument_Exact()
   * @model
   * @generated
   */
  boolean isExact();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.Argument#isExact <em>Exact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exact</em>' attribute.
   * @see #isExact()
   * @generated
   */
  void setExact(boolean value);

  /**
   * Returns the value of the '<em><b>Guarantee</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guarantee</em>' containment reference.
   * @see #setGuarantee(Guarantee)
   * @see org.osate.contract.contract.ContractPackage#getArgument_Guarantee()
   * @model containment="true"
   * @generated
   */
  Guarantee getGuarantee();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.Argument#getGuarantee <em>Guarantee</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guarantee</em>' containment reference.
   * @see #getGuarantee()
   * @generated
   */
  void setGuarantee(Guarantee value);

  /**
   * Returns the value of the '<em><b>Argument Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument Expression</em>' containment reference.
   * @see #setArgumentExpression(ArgumentExpression)
   * @see org.osate.contract.contract.ContractPackage#getArgument_ArgumentExpression()
   * @model containment="true"
   * @generated
   */
  ArgumentExpression getArgumentExpression();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.Argument#getArgumentExpression <em>Argument Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument Expression</em>' containment reference.
   * @see #getArgumentExpression()
   * @generated
   */
  void setArgumentExpression(ArgumentExpression value);

} // Argument
