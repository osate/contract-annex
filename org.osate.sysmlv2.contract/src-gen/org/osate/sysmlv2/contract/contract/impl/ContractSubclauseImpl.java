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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.sysmlv2.contract.contract.Contract;
import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.ContractSubclause;
import org.osate.sysmlv2.contract.contract.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.ContractSubclauseImpl#getUseQueries <em>Use Queries</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.ContractSubclauseImpl#getVerifyPlans <em>Verify Plans</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractSubclauseImpl extends MinimalEObjectImpl.Container implements ContractSubclause
{
  /**
   * The cached value of the '{@link #getUseQueries() <em>Use Queries</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseQueries()
   * @generated
   * @ordered
   */
  protected EList<Contract> useQueries;

  /**
   * The cached value of the '{@link #getVerifyPlans() <em>Verify Plans</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerifyPlans()
   * @generated
   * @ordered
   */
  protected EList<VerificationPlan> verifyPlans;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractSubclauseImpl()
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
    return ContractPackage.Literals.CONTRACT_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Contract> getUseQueries()
  {
    if (useQueries == null)
    {
      useQueries = new EObjectResolvingEList<Contract>(Contract.class, this, ContractPackage.CONTRACT_SUBCLAUSE__USE_QUERIES);
    }
    return useQueries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VerificationPlan> getVerifyPlans()
  {
    if (verifyPlans == null)
    {
      verifyPlans = new EObjectResolvingEList<VerificationPlan>(VerificationPlan.class, this, ContractPackage.CONTRACT_SUBCLAUSE__VERIFY_PLANS);
    }
    return verifyPlans;
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
      case ContractPackage.CONTRACT_SUBCLAUSE__USE_QUERIES:
        return getUseQueries();
      case ContractPackage.CONTRACT_SUBCLAUSE__VERIFY_PLANS:
        return getVerifyPlans();
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
      case ContractPackage.CONTRACT_SUBCLAUSE__USE_QUERIES:
        getUseQueries().clear();
        getUseQueries().addAll((Collection<? extends Contract>)newValue);
        return;
      case ContractPackage.CONTRACT_SUBCLAUSE__VERIFY_PLANS:
        getVerifyPlans().clear();
        getVerifyPlans().addAll((Collection<? extends VerificationPlan>)newValue);
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
      case ContractPackage.CONTRACT_SUBCLAUSE__USE_QUERIES:
        getUseQueries().clear();
        return;
      case ContractPackage.CONTRACT_SUBCLAUSE__VERIFY_PLANS:
        getVerifyPlans().clear();
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
      case ContractPackage.CONTRACT_SUBCLAUSE__USE_QUERIES:
        return useQueries != null && !useQueries.isEmpty();
      case ContractPackage.CONTRACT_SUBCLAUSE__VERIFY_PLANS:
        return verifyPlans != null && !verifyPlans.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ContractSubclauseImpl
