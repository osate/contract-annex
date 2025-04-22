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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.Expression;
import org.osate.sysmlv2.contract.contract.Lambda;
import org.osate.sysmlv2.contract.contract.Parameter;
import org.osate.sysmlv2.contract.contract.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lambda</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.LambdaImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.LambdaImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.LambdaImpl#getReturnValue <em>Return Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LambdaImpl extends MinimalEObjectImpl.Container implements Lambda
{
  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected Parameter parameter;

  /**
   * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueries()
   * @generated
   * @ordered
   */
  protected EList<Query> queries;

  /**
   * The cached value of the '{@link #getReturnValue() <em>Return Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnValue()
   * @generated
   * @ordered
   */
  protected Expression returnValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LambdaImpl()
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
    return ContractPackage.Literals.LAMBDA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Parameter getParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs)
  {
    Parameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.LAMBDA__PARAMETER, oldParameter, newParameter);
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
  public void setParameter(Parameter newParameter)
  {
    if (newParameter != parameter)
    {
      NotificationChain msgs = null;
      if (parameter != null)
        msgs = ((InternalEObject)parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.LAMBDA__PARAMETER, null, msgs);
      if (newParameter != null)
        msgs = ((InternalEObject)newParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.LAMBDA__PARAMETER, null, msgs);
      msgs = basicSetParameter(newParameter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.LAMBDA__PARAMETER, newParameter, newParameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Query> getQueries()
  {
    if (queries == null)
    {
      queries = new EObjectContainmentEList<Query>(Query.class, this, ContractPackage.LAMBDA__QUERIES);
    }
    return queries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getReturnValue()
  {
    return returnValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnValue(Expression newReturnValue, NotificationChain msgs)
  {
    Expression oldReturnValue = returnValue;
    returnValue = newReturnValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.LAMBDA__RETURN_VALUE, oldReturnValue, newReturnValue);
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
  public void setReturnValue(Expression newReturnValue)
  {
    if (newReturnValue != returnValue)
    {
      NotificationChain msgs = null;
      if (returnValue != null)
        msgs = ((InternalEObject)returnValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.LAMBDA__RETURN_VALUE, null, msgs);
      if (newReturnValue != null)
        msgs = ((InternalEObject)newReturnValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.LAMBDA__RETURN_VALUE, null, msgs);
      msgs = basicSetReturnValue(newReturnValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.LAMBDA__RETURN_VALUE, newReturnValue, newReturnValue));
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
      case ContractPackage.LAMBDA__PARAMETER:
        return basicSetParameter(null, msgs);
      case ContractPackage.LAMBDA__QUERIES:
        return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
      case ContractPackage.LAMBDA__RETURN_VALUE:
        return basicSetReturnValue(null, msgs);
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
      case ContractPackage.LAMBDA__PARAMETER:
        return getParameter();
      case ContractPackage.LAMBDA__QUERIES:
        return getQueries();
      case ContractPackage.LAMBDA__RETURN_VALUE:
        return getReturnValue();
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
      case ContractPackage.LAMBDA__PARAMETER:
        setParameter((Parameter)newValue);
        return;
      case ContractPackage.LAMBDA__QUERIES:
        getQueries().clear();
        getQueries().addAll((Collection<? extends Query>)newValue);
        return;
      case ContractPackage.LAMBDA__RETURN_VALUE:
        setReturnValue((Expression)newValue);
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
      case ContractPackage.LAMBDA__PARAMETER:
        setParameter((Parameter)null);
        return;
      case ContractPackage.LAMBDA__QUERIES:
        getQueries().clear();
        return;
      case ContractPackage.LAMBDA__RETURN_VALUE:
        setReturnValue((Expression)null);
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
      case ContractPackage.LAMBDA__PARAMETER:
        return parameter != null;
      case ContractPackage.LAMBDA__QUERIES:
        return queries != null && !queries.isEmpty();
      case ContractPackage.LAMBDA__RETURN_VALUE:
        return returnValue != null;
    }
    return super.eIsSet(featureID);
  }

} //LambdaImpl
