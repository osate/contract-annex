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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.GenericPropertyTypeAnnotation;
import org.osate.contract.contract.PropertyTypeLocator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Property Type Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getGenericType <em>Generic Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericPropertyTypeAnnotationImpl extends TypeAnnotationImpl implements GenericPropertyTypeAnnotation
{
  /**
   * The default value of the '{@link #getBaseType() <em>Base Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
  protected static final String BASE_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
  protected String baseType = BASE_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenericType() <em>Generic Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericType()
   * @generated
   * @ordered
   */
  protected PropertyTypeLocator genericType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenericPropertyTypeAnnotationImpl()
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
    return ContractPackage.Literals.GENERIC_PROPERTY_TYPE_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBaseType()
  {
    return baseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBaseType(String newBaseType)
  {
    String oldBaseType = baseType;
    baseType = newBaseType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE, oldBaseType, baseType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyTypeLocator getGenericType()
  {
    return genericType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGenericType(PropertyTypeLocator newGenericType, NotificationChain msgs)
  {
    PropertyTypeLocator oldGenericType = genericType;
    genericType = newGenericType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE, oldGenericType, newGenericType);
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
  public void setGenericType(PropertyTypeLocator newGenericType)
  {
    if (newGenericType != genericType)
    {
      NotificationChain msgs = null;
      if (genericType != null)
        msgs = ((InternalEObject)genericType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE, null, msgs);
      if (newGenericType != null)
        msgs = ((InternalEObject)newGenericType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE, null, msgs);
      msgs = basicSetGenericType(newGenericType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE, newGenericType, newGenericType));
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE:
        return basicSetGenericType(null, msgs);
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE:
        return getBaseType();
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE:
        return getGenericType();
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE:
        setBaseType((String)newValue);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE:
        setGenericType((PropertyTypeLocator)newValue);
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE:
        setBaseType(BASE_TYPE_EDEFAULT);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE:
        setGenericType((PropertyTypeLocator)null);
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE:
        return BASE_TYPE_EDEFAULT == null ? baseType != null : !BASE_TYPE_EDEFAULT.equals(baseType);
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__GENERIC_TYPE:
        return genericType != null;
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
    result.append(" (baseType: ");
    result.append(baseType);
    result.append(')');
    return result.toString();
  }

} //GenericPropertyTypeAnnotationImpl
