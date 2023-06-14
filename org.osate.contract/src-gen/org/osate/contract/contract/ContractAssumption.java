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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.ContractAssumption#getContract <em>Contract</em>}</li>
 * </ul>
 *
 * @see org.osate.contract.contract.ContractPackage#getContractAssumption()
 * @model
 * @generated
 */
public interface ContractAssumption extends AssumptionElement
{
  /**
   * Returns the value of the '<em><b>Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contract</em>' reference.
   * @see #setContract(ContractElement)
   * @see org.osate.contract.contract.ContractPackage#getContractAssumption_Contract()
   * @model
   * @generated
   */
  ContractElement getContract();

  /**
   * Sets the value of the '{@link org.osate.contract.contract.ContractAssumption#getContract <em>Contract</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contract</em>' reference.
   * @see #getContract()
   * @generated
   */
  void setContract(ContractElement value);

} // ContractAssumption
