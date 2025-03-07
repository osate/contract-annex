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
package org.osate.sysmlv2.contract.contract.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.sysmlv2.contract.contract.CodeAssumption;
import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.Guarantee;
import org.osate.sysmlv2.contract.contract.Source;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Assumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl#isExact <em>Exact</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl#getGuarantee <em>Guarantee</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeAssumptionImpl extends AssumptionElementImpl implements CodeAssumption
{
  /**
   * The cached value of the '{@link #getCode() <em>Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode()
   * @generated
   * @ordered
   */
  protected Source code;

  /**
   * The default value of the '{@link #isExact() <em>Exact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExact()
   * @generated
   * @ordered
   */
  protected static final boolean EXACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExact() <em>Exact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExact()
   * @generated
   * @ordered
   */
  protected boolean exact = EXACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getGuarantee() <em>Guarantee</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuarantee()
   * @generated
   * @ordered
   */
  protected Guarantee guarantee;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeAssumptionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ContractPackage.Literals.CODE_ASSUMPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Source getCode()
  {
    return code;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCode(Source newCode, NotificationChain msgs)
  {
    Source oldCode = code;
    code = newCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.CODE_ASSUMPTION__CODE, oldCode, newCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCode(Source newCode)
  {
    if (newCode != code)
    {
      NotificationChain msgs = null;
      if (code != null)
        msgs = ((InternalEObject)code).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CODE_ASSUMPTION__CODE, null, msgs);
      if (newCode != null)
        msgs = ((InternalEObject)newCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CODE_ASSUMPTION__CODE, null, msgs);
      msgs = basicSetCode(newCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.CODE_ASSUMPTION__CODE, newCode, newCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isExact()
  {
    return exact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExact(boolean newExact)
  {
    boolean oldExact = exact;
    exact = newExact;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.CODE_ASSUMPTION__EXACT, oldExact, exact));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Guarantee getGuarantee()
  {
    return guarantee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuarantee(Guarantee newGuarantee, NotificationChain msgs)
  {
    Guarantee oldGuarantee = guarantee;
    guarantee = newGuarantee;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.CODE_ASSUMPTION__GUARANTEE, oldGuarantee, newGuarantee);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setGuarantee(Guarantee newGuarantee)
  {
    if (newGuarantee != guarantee)
    {
      NotificationChain msgs = null;
      if (guarantee != null)
        msgs = ((InternalEObject)guarantee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CODE_ASSUMPTION__GUARANTEE, null, msgs);
      if (newGuarantee != null)
        msgs = ((InternalEObject)newGuarantee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CODE_ASSUMPTION__GUARANTEE, null, msgs);
      msgs = basicSetGuarantee(newGuarantee, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.CODE_ASSUMPTION__GUARANTEE, newGuarantee, newGuarantee));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ContractPackage.CODE_ASSUMPTION__CODE:
        return basicSetCode(null, msgs);
      case ContractPackage.CODE_ASSUMPTION__GUARANTEE:
        return basicSetGuarantee(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ContractPackage.CODE_ASSUMPTION__CODE:
        return getCode();
      case ContractPackage.CODE_ASSUMPTION__EXACT:
        return isExact();
      case ContractPackage.CODE_ASSUMPTION__GUARANTEE:
        return getGuarantee();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ContractPackage.CODE_ASSUMPTION__CODE:
        setCode((Source)newValue);
        return;
      case ContractPackage.CODE_ASSUMPTION__EXACT:
        setExact((Boolean)newValue);
        return;
      case ContractPackage.CODE_ASSUMPTION__GUARANTEE:
        setGuarantee((Guarantee)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ContractPackage.CODE_ASSUMPTION__CODE:
        setCode((Source)null);
        return;
      case ContractPackage.CODE_ASSUMPTION__EXACT:
        setExact(EXACT_EDEFAULT);
        return;
      case ContractPackage.CODE_ASSUMPTION__GUARANTEE:
        setGuarantee((Guarantee)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ContractPackage.CODE_ASSUMPTION__CODE:
        return code != null;
      case ContractPackage.CODE_ASSUMPTION__EXACT:
        return exact != EXACT_EDEFAULT;
      case ContractPackage.CODE_ASSUMPTION__GUARANTEE:
        return guarantee != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (exact: ");
    result.append(exact);
    result.append(')');
    return result.toString();
  }

} //CodeAssumptionImpl
