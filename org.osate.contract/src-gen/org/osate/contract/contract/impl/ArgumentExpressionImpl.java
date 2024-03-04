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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.ContractElement;
import org.osate.contract.contract.ContractPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Argument Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentExpressionImpl#getContracts <em>Contracts</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentExpressionImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ArgumentExpressionImpl#getNested <em>Nested</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArgumentExpressionImpl extends MinimalEObjectImpl.Container implements ArgumentExpression
{
  /**
   * The cached value of the '{@link #getContracts() <em>Contracts</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContracts()
   * @generated
   * @ordered
   */
  protected EList<ContractElement> contracts;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<ContractElement> arguments;

  /**
   * The cached value of the '{@link #getNested() <em>Nested</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNested()
   * @generated
   * @ordered
   */
  protected EList<ArgumentExpression> nested;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArgumentExpressionImpl()
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
    return ContractPackage.Literals.ARGUMENT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ContractElement> getContracts()
  {
    if (contracts == null)
    {
      contracts = new EObjectResolvingEList<ContractElement>(ContractElement.class, this, ContractPackage.ARGUMENT_EXPRESSION__CONTRACTS);
    }
    return contracts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ContractElement> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectResolvingEList<ContractElement>(ContractElement.class, this, ContractPackage.ARGUMENT_EXPRESSION__ARGUMENTS);
    }
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArgumentExpression> getNested()
  {
    if (nested == null)
    {
      nested = new EObjectContainmentEList<ArgumentExpression>(ArgumentExpression.class, this, ContractPackage.ARGUMENT_EXPRESSION__NESTED);
    }
    return nested;
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
      case ContractPackage.ARGUMENT_EXPRESSION__NESTED:
        return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
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
      case ContractPackage.ARGUMENT_EXPRESSION__CONTRACTS:
        return getContracts();
      case ContractPackage.ARGUMENT_EXPRESSION__ARGUMENTS:
        return getArguments();
      case ContractPackage.ARGUMENT_EXPRESSION__NESTED:
        return getNested();
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
      case ContractPackage.ARGUMENT_EXPRESSION__CONTRACTS:
        getContracts().clear();
        getContracts().addAll((Collection<? extends ContractElement>)newValue);
        return;
      case ContractPackage.ARGUMENT_EXPRESSION__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends ContractElement>)newValue);
        return;
      case ContractPackage.ARGUMENT_EXPRESSION__NESTED:
        getNested().clear();
        getNested().addAll((Collection<? extends ArgumentExpression>)newValue);
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
      case ContractPackage.ARGUMENT_EXPRESSION__CONTRACTS:
        getContracts().clear();
        return;
      case ContractPackage.ARGUMENT_EXPRESSION__ARGUMENTS:
        getArguments().clear();
        return;
      case ContractPackage.ARGUMENT_EXPRESSION__NESTED:
        getNested().clear();
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
      case ContractPackage.ARGUMENT_EXPRESSION__CONTRACTS:
        return contracts != null && !contracts.isEmpty();
      case ContractPackage.ARGUMENT_EXPRESSION__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
      case ContractPackage.ARGUMENT_EXPRESSION__NESTED:
        return nested != null && !nested.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ArgumentExpressionImpl
