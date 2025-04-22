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

import org.omg.sysml.lang.sysml.AttributeDefinition;

import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.Expression;
import org.osate.sysmlv2.contract.contract.PropertyLookup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Lookup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyLookupImpl extends ExpressionImpl implements PropertyLookup
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected Expression left;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected AttributeDefinition right;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyLookupImpl()
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
    return ContractPackage.Literals.PROPERTY_LOOKUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs)
  {
    Expression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.PROPERTY_LOOKUP__LEFT, oldLeft, newLeft);
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
  public void setLeft(Expression newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.PROPERTY_LOOKUP__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.PROPERTY_LOOKUP__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.PROPERTY_LOOKUP__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeDefinition getRight()
  {
    if (right != null && right.eIsProxy())
    {
      InternalEObject oldRight = (InternalEObject)right;
      right = (AttributeDefinition)eResolveProxy(oldRight);
      if (right != oldRight)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContractPackage.PROPERTY_LOOKUP__RIGHT, oldRight, right));
      }
    }
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeDefinition basicGetRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRight(AttributeDefinition newRight)
  {
    AttributeDefinition oldRight = right;
    right = newRight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.PROPERTY_LOOKUP__RIGHT, oldRight, right));
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
      case ContractPackage.PROPERTY_LOOKUP__LEFT:
        return basicSetLeft(null, msgs);
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
      case ContractPackage.PROPERTY_LOOKUP__LEFT:
        return getLeft();
      case ContractPackage.PROPERTY_LOOKUP__RIGHT:
        if (resolve) return getRight();
        return basicGetRight();
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
      case ContractPackage.PROPERTY_LOOKUP__LEFT:
        setLeft((Expression)newValue);
        return;
      case ContractPackage.PROPERTY_LOOKUP__RIGHT:
        setRight((AttributeDefinition)newValue);
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
      case ContractPackage.PROPERTY_LOOKUP__LEFT:
        setLeft((Expression)null);
        return;
      case ContractPackage.PROPERTY_LOOKUP__RIGHT:
        setRight((AttributeDefinition)null);
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
      case ContractPackage.PROPERTY_LOOKUP__LEFT:
        return left != null;
      case ContractPackage.PROPERTY_LOOKUP__RIGHT:
        return right != null;
    }
    return super.eIsSet(featureID);
  }

} //PropertyLookupImpl
