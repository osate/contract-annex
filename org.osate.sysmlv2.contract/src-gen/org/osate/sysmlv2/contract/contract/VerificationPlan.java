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
package org.osate.sysmlv2.contract.contract;

import org.eclipse.emf.common.util.EList;

import org.omg.sysml.lang.sysml.OccurrenceDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getOccurrenceDefinition <em>Occurrence Definition</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getClaims <em>Claims</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getContracts <em>Contracts</em>}</li>
 * </ul>
 *
 * @see org.osate.sysmlv2.contract.contract.ContractPackage#getVerificationPlan()
 * @model
 * @generated
 */
public interface VerificationPlan extends ContractElement
{
  /**
   * Returns the value of the '<em><b>Occurrence Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Occurrence Definition</em>' reference.
   * @see #setOccurrenceDefinition(OccurrenceDefinition)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getVerificationPlan_OccurrenceDefinition()
   * @model
   * @generated
   */
  OccurrenceDefinition getOccurrenceDefinition();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getOccurrenceDefinition <em>Occurrence Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Occurrence Definition</em>' reference.
   * @see #getOccurrenceDefinition()
   * @generated
   */
  void setOccurrenceDefinition(OccurrenceDefinition value);

  /**
   * Returns the value of the '<em><b>Domains</b></em>' reference list.
   * The list contents are of type {@link org.osate.sysmlv2.contract.contract.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domains</em>' reference list.
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getVerificationPlan_Domains()
   * @model
   * @generated
   */
  EList<Domain> getDomains();

  /**
   * Returns the value of the '<em><b>Claims</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.sysmlv2.contract.contract.Source}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Claims</em>' containment reference list.
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getVerificationPlan_Claims()
   * @model containment="true"
   * @generated
   */
  EList<Source> getClaims();

  /**
   * Returns the value of the '<em><b>Contracts</b></em>' reference list.
   * The list contents are of type {@link org.osate.sysmlv2.contract.contract.Contract}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contracts</em>' reference list.
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getVerificationPlan_Contracts()
   * @model
   * @generated
   */
  EList<Contract> getContracts();

} // VerificationPlan
