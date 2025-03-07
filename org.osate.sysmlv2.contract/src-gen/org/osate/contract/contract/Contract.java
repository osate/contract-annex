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
 * A representation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.Contract#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#isExact <em>Exact</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.osate.contract.contract.Contract#getAnalyses <em>Analyses</em>}</li>
 * </ul>
 *
 * @see org.osate.contract.contract.ContractPackage#getContract()
 * @model
 * @generated
 */
public interface Contract extends ContractElement
{
  /**
   * Returns the value of the '<em><b>Domains</b></em>' reference list.
   * The list contents are of type {@link org.osate.contract.contract.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domains</em>' reference list.
   * @see org.osate.contract.contract.ContractPackage#getContract_Domains()
   * @model
   * @generated
   */
  EList<Domain> getDomains();

  /**
   * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.contract.contract.Query}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Queries</em>' containment reference list.
   * @see org.osate.contract.contract.ContractPackage#getContract_Queries()
   * @model containment="true"
   * @generated
   */
  EList<Query> getQueries();

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.contract.contract.InputAssumption}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see org.osate.contract.contract.ContractPackage#getContract_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<InputAssumption> getInputs();

  /**
   * Returns the value of the '<em><b>Assumptions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.contract.contract.AssumptionElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assumptions</em>' containment reference list.
   * @see org.osate.contract.contract.ContractPackage#getContract_Assumptions()
   * @model containment="true"
   * @generated
   */
  EList<AssumptionElement> getAssumptions();

  /**
   * Returns the value of the '<em><b>Exact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exact</em>' attribute.
   * @see #setExact(boolean)
   * @see org.osate.contract.contract.ContractPackage#getContract_Exact()
   * @model
   * @generated
   */
  boolean isExact();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.Contract#isExact <em>Exact</em>}' attribute.
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
   * @see org.osate.contract.contract.ContractPackage#getContract_Guarantee()
   * @model containment="true"
   * @generated
   */
  Guarantee getGuarantee();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.Contract#getGuarantee <em>Guarantee</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guarantee</em>' containment reference.
   * @see #getGuarantee()
   * @generated
   */
  void setGuarantee(Guarantee value);

  /**
   * Returns the value of the '<em><b>Analyses</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.contract.contract.Analysis}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analyses</em>' containment reference list.
   * @see org.osate.contract.contract.ContractPackage#getContract_Analyses()
   * @model containment="true"
   * @generated
   */
  EList<Analysis> getAnalyses();

} // Contract
