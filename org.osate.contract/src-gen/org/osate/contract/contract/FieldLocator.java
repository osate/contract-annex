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

import org.osate.aadl2.BasicProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Locator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.FieldLocator#getPrevious <em>Previous</em>}</li>
 *   <li>{@link org.osate.contract.contract.FieldLocator#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see org.osate.contract.contract.ContractPackage#getFieldLocator()
 * @model
 * @generated
 */
public interface FieldLocator extends PropertyTypeLocator
{
  /**
   * Returns the value of the '<em><b>Previous</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Previous</em>' containment reference.
   * @see #setPrevious(PropertyTypeLocator)
   * @see org.osate.contract.contract.ContractPackage#getFieldLocator_Previous()
   * @model containment="true"
   * @generated
   */
  PropertyTypeLocator getPrevious();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.FieldLocator#getPrevious <em>Previous</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Previous</em>' containment reference.
   * @see #getPrevious()
   * @generated
   */
  void setPrevious(PropertyTypeLocator value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' reference.
   * @see #setField(BasicProperty)
   * @see org.osate.contract.contract.ContractPackage#getFieldLocator_Field()
   * @model
   * @generated
   */
  BasicProperty getField();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.FieldLocator#getField <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' reference.
   * @see #getField()
   * @generated
   */
  void setField(BasicProperty value);

} // FieldLocator
