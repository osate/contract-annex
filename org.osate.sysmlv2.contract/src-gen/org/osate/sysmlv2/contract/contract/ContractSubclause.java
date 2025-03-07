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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.ContractSubclause#getUseQueries <em>Use Queries</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.ContractSubclause#getVerifyPlans <em>Verify Plans</em>}</li>
 * </ul>
 *
 * @see org.osate.sysmlv2.contract.contract.ContractPackage#getContractSubclause()
 * @model
 * @generated
 */
public interface ContractSubclause extends EObject
{
  /**
   * Returns the value of the '<em><b>Use Queries</b></em>' reference list.
   * The list contents are of type {@link org.osate.sysmlv2.contract.contract.Contract}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Queries</em>' reference list.
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getContractSubclause_UseQueries()
   * @model
   * @generated
   */
  EList<Contract> getUseQueries();

  /**
   * Returns the value of the '<em><b>Verify Plans</b></em>' reference list.
   * The list contents are of type {@link org.osate.sysmlv2.contract.contract.VerificationPlan}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verify Plans</em>' reference list.
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getContractSubclause_VerifyPlans()
   * @model
   * @generated
   */
  EList<VerificationPlan> getVerifyPlans();

} // ContractSubclause
