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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.Source#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.Source#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.Source#getInter <em>Inter</em>}</li>
 * </ul>
 *
 * @see org.osate.sysmlv2.contract.contract.ContractPackage#getSource()
 * @model
 * @generated
 */
public interface Source extends EObject
{
  /**
   * Returns the value of the '<em><b>Language</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.sysmlv2.contract.contract.Language}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language</em>' attribute.
   * @see org.osate.sysmlv2.contract.contract.Language
   * @see #setLanguage(Language)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getSource_Language()
   * @model
   * @generated
   */
  Language getLanguage();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.Source#getLanguage <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language</em>' attribute.
   * @see org.osate.sysmlv2.contract.contract.Language
   * @see #getLanguage()
   * @generated
   */
  void setLanguage(Language value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getSource_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.Source#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>Inter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inter</em>' containment reference.
   * @see #setInter(IString)
   * @see org.osate.sysmlv2.contract.contract.ContractPackage#getSource_Inter()
   * @model containment="true"
   * @generated
   */
  IString getInter();

  /**
   * Sets the value of the '{@link org.osate.sysmlv2.contract.contract.Source#getInter <em>Inter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inter</em>' containment reference.
   * @see #getInter()
   * @generated
   */
  void setInter(IString value);

} // Source
