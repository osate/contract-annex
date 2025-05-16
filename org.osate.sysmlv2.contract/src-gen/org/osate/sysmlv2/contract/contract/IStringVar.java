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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IString Var</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.IStringVar#isDirect <em>Direct</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.IStringVar#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.IStringVar#getQuery <em>Query</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.IStringVar#getPredefined <em>Predefined</em>}</li>
 * </ul>
 *
 * @see org.osate.sysmlv2.contract.contract.ContractPackage#getIStringVar()
 * @model
 * @generated
 */
public interface IStringVar extends IStringPart
{
  /**
   * Returns the value of the '<em><b>Direct</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direct</em>' attribute.
   * @see #setDirect(boolean)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getIStringVar_Direct()
   * @model
   * @generated
   */
  boolean isDirect();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.IStringVar#isDirect <em>Direct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direct</em>' attribute.
   * @see #isDirect()
   * @generated
   */
  void setDirect(boolean value);

  /**
   * Returns the value of the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' reference.
   * @see #setDomain(Domain)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getIStringVar_Domain()
   * @model
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.IStringVar#getDomain <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>Query</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query</em>' reference.
   * @see #setQuery(SingleValDeclaration)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getIStringVar_Query()
   * @model
   * @generated
   */
  SingleValDeclaration getQuery();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.IStringVar#getQuery <em>Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(SingleValDeclaration value);

  /**
   * Returns the value of the '<em><b>Predefined</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.sysmlv2.contract.contract.Predefined}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predefined</em>' attribute.
   * @see org.osate.sysmlv2.contract.contract.Predefined
   * @see #setPredefined(Predefined)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getIStringVar_Predefined()
   * @model
   * @generated
   */
  Predefined getPredefined();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.IStringVar#getPredefined <em>Predefined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predefined</em>' attribute.
   * @see org.osate.sysmlv2.contract.contract.Predefined
   * @see #getPredefined()
   * @generated
   */
  void setPredefined(Predefined value);

} // IStringVar
