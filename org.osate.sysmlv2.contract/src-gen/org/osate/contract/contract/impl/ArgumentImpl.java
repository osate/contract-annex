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
package org.osate.contract.contract.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.Guarantee;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentImpl#isExact <em>Exact</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentImpl#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentImpl#getArgumentExpression <em>Argument Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArgumentImpl extends ContractElementImpl implements Argument
{
  /**
   * The cached value of the '{@link #getDomains() <em>Domains</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomains()
   * @generated
   * @ordered
   */
  protected EList<Domain> domains;

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
   * The cached value of the '{@link #getArgumentExpression() <em>Argument Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgumentExpression()
   * @generated
   * @ordered
   */
  protected ArgumentExpression argumentExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArgumentImpl()
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
    return ContractPackage.Literals.ARGUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Domain> getDomains()
  {
    if (domains == null)
    {
      domains = new EObjectResolvingEList<Domain>(Domain.class, this, ContractPackage.ARGUMENT__DOMAINS);
    }
    return domains;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ARGUMENT__EXACT, oldExact, exact));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.ARGUMENT__GUARANTEE, oldGuarantee, newGuarantee);
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
        msgs = ((InternalEObject)guarantee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.ARGUMENT__GUARANTEE, null, msgs);
      if (newGuarantee != null)
        msgs = ((InternalEObject)newGuarantee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.ARGUMENT__GUARANTEE, null, msgs);
      msgs = basicSetGuarantee(newGuarantee, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ARGUMENT__GUARANTEE, newGuarantee, newGuarantee));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArgumentExpression getArgumentExpression()
  {
    return argumentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgumentExpression(ArgumentExpression newArgumentExpression, NotificationChain msgs)
  {
    ArgumentExpression oldArgumentExpression = argumentExpression;
    argumentExpression = newArgumentExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION, oldArgumentExpression, newArgumentExpression);
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
  public void setArgumentExpression(ArgumentExpression newArgumentExpression)
  {
    if (newArgumentExpression != argumentExpression)
    {
      NotificationChain msgs = null;
      if (argumentExpression != null)
        msgs = ((InternalEObject)argumentExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION, null, msgs);
      if (newArgumentExpression != null)
        msgs = ((InternalEObject)newArgumentExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION, null, msgs);
      msgs = basicSetArgumentExpression(newArgumentExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION, newArgumentExpression, newArgumentExpression));
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
      case ContractPackage.ARGUMENT__GUARANTEE:
        return basicSetGuarantee(null, msgs);
      case ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION:
        return basicSetArgumentExpression(null, msgs);
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
      case ContractPackage.ARGUMENT__DOMAINS:
        return getDomains();
      case ContractPackage.ARGUMENT__EXACT:
        return isExact();
      case ContractPackage.ARGUMENT__GUARANTEE:
        return getGuarantee();
      case ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION:
        return getArgumentExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ContractPackage.ARGUMENT__DOMAINS:
        getDomains().clear();
        getDomains().addAll((Collection<? extends Domain>)newValue);
        return;
      case ContractPackage.ARGUMENT__EXACT:
        setExact((Boolean)newValue);
        return;
      case ContractPackage.ARGUMENT__GUARANTEE:
        setGuarantee((Guarantee)newValue);
        return;
      case ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION:
        setArgumentExpression((ArgumentExpression)newValue);
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
      case ContractPackage.ARGUMENT__DOMAINS:
        getDomains().clear();
        return;
      case ContractPackage.ARGUMENT__EXACT:
        setExact(EXACT_EDEFAULT);
        return;
      case ContractPackage.ARGUMENT__GUARANTEE:
        setGuarantee((Guarantee)null);
        return;
      case ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION:
        setArgumentExpression((ArgumentExpression)null);
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
      case ContractPackage.ARGUMENT__DOMAINS:
        return domains != null && !domains.isEmpty();
      case ContractPackage.ARGUMENT__EXACT:
        return exact != EXACT_EDEFAULT;
      case ContractPackage.ARGUMENT__GUARANTEE:
        return guarantee != null;
      case ContractPackage.ARGUMENT__ARGUMENT_EXPRESSION:
        return argumentExpression != null;
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

} //ArgumentImpl
