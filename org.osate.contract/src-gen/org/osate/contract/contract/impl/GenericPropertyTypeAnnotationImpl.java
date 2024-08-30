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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.GenericPropertyTypeAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Property Type Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getPropertySet <em>Property Set</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getPropertyType <em>Property Type</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.GenericPropertyTypeAnnotationImpl#getFields <em>Fields</em>}</li>
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
   * The default value of the '{@link #getPropertySet() <em>Property Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertySet()
   * @generated
   * @ordered
   */
  protected static final String PROPERTY_SET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPropertySet() <em>Property Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertySet()
   * @generated
   * @ordered
   */
  protected String propertySet = PROPERTY_SET_EDEFAULT;

  /**
   * The default value of the '{@link #getPropertyType() <em>Property Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyType()
   * @generated
   * @ordered
   */
  protected static final String PROPERTY_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPropertyType() <em>Property Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyType()
   * @generated
   * @ordered
   */
  protected String propertyType = PROPERTY_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<String> fields;

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
  public String getPropertySet()
  {
    return propertySet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPropertySet(String newPropertySet)
  {
    String oldPropertySet = propertySet;
    propertySet = newPropertySet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_SET, oldPropertySet, propertySet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPropertyType()
  {
    return propertyType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPropertyType(String newPropertyType)
  {
    String oldPropertyType = propertyType;
    propertyType = newPropertyType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_TYPE, oldPropertyType, propertyType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getFields()
  {
    if (fields == null)
    {
      fields = new EDataTypeEList<String>(String.class, this, ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__FIELDS);
    }
    return fields;
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_SET:
        return getPropertySet();
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_TYPE:
        return getPropertyType();
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__FIELDS:
        return getFields();
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__BASE_TYPE:
        setBaseType((String)newValue);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_SET:
        setPropertySet((String)newValue);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_TYPE:
        setPropertyType((String)newValue);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends String>)newValue);
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_SET:
        setPropertySet(PROPERTY_SET_EDEFAULT);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_TYPE:
        setPropertyType(PROPERTY_TYPE_EDEFAULT);
        return;
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__FIELDS:
        getFields().clear();
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
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_SET:
        return PROPERTY_SET_EDEFAULT == null ? propertySet != null : !PROPERTY_SET_EDEFAULT.equals(propertySet);
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__PROPERTY_TYPE:
        return PROPERTY_TYPE_EDEFAULT == null ? propertyType != null : !PROPERTY_TYPE_EDEFAULT.equals(propertyType);
      case ContractPackage.GENERIC_PROPERTY_TYPE_ANNOTATION__FIELDS:
        return fields != null && !fields.isEmpty();
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
    result.append(", propertySet: ");
    result.append(propertySet);
    result.append(", propertyType: ");
    result.append(propertyType);
    result.append(", fields: ");
    result.append(fields);
    result.append(')');
    return result.toString();
  }

} //GenericPropertyTypeAnnotationImpl
