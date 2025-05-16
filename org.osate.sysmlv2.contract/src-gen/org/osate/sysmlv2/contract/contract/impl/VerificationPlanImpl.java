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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.sysml.lang.sysml.OccurrenceDefinition;

import org.osate.sysmlv2.contract.contract.Contract;
import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.Domain;
import org.osate.sysmlv2.contract.contract.Source;
import org.osate.sysmlv2.contract.contract.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Plan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl#getOccurrenceDefinition <em>Occurrence Definition</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl#getClaims <em>Claims</em>}</li>
 *   <li>{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl#getContracts <em>Contracts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationPlanImpl extends ContractElementImpl implements VerificationPlan
{
  /**
   * The cached value of the '{@link #getOccurrenceDefinition() <em>Occurrence Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOccurrenceDefinition()
   * @generated
   * @ordered
   */
  protected OccurrenceDefinition occurrenceDefinition;

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
   * The cached value of the '{@link #getClaims() <em>Claims</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaims()
   * @generated
   * @ordered
   */
  protected EList<Source> claims;

  /**
   * The cached value of the '{@link #getContracts() <em>Contracts</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContracts()
   * @generated
   * @ordered
   */
  protected EList<Contract> contracts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationPlanImpl()
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
    return ContractPackage.Literals.VERIFICATION_PLAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OccurrenceDefinition getOccurrenceDefinition()
  {
    if (occurrenceDefinition != null && occurrenceDefinition.eIsProxy())
    {
      InternalEObject oldOccurrenceDefinition = (InternalEObject)occurrenceDefinition;
      occurrenceDefinition = (OccurrenceDefinition)eResolveProxy(oldOccurrenceDefinition);
      if (occurrenceDefinition != oldOccurrenceDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION, oldOccurrenceDefinition, occurrenceDefinition));
      }
    }
    return occurrenceDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OccurrenceDefinition basicGetOccurrenceDefinition()
  {
    return occurrenceDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOccurrenceDefinition(OccurrenceDefinition newOccurrenceDefinition)
  {
    OccurrenceDefinition oldOccurrenceDefinition = occurrenceDefinition;
    occurrenceDefinition = newOccurrenceDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION, oldOccurrenceDefinition, occurrenceDefinition));
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
      domains = new EObjectResolvingEList<Domain>(Domain.class, this, ContractPackage.VERIFICATION_PLAN__DOMAINS);
    }
    return domains;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Source> getClaims()
  {
    if (claims == null)
    {
      claims = new EObjectContainmentEList<Source>(Source.class, this, ContractPackage.VERIFICATION_PLAN__CLAIMS);
    }
    return claims;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Contract> getContracts()
  {
    if (contracts == null)
    {
      contracts = new EObjectResolvingEList<Contract>(Contract.class, this, ContractPackage.VERIFICATION_PLAN__CONTRACTS);
    }
    return contracts;
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
      case ContractPackage.VERIFICATION_PLAN__CLAIMS:
        return ((InternalEList<?>)getClaims()).basicRemove(otherEnd, msgs);
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
      case ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION:
        if (resolve) return getOccurrenceDefinition();
        return basicGetOccurrenceDefinition();
      case ContractPackage.VERIFICATION_PLAN__DOMAINS:
        return getDomains();
      case ContractPackage.VERIFICATION_PLAN__CLAIMS:
        return getClaims();
      case ContractPackage.VERIFICATION_PLAN__CONTRACTS:
        return getContracts();
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
      case ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION:
        setOccurrenceDefinition((OccurrenceDefinition)newValue);
        return;
      case ContractPackage.VERIFICATION_PLAN__DOMAINS:
        getDomains().clear();
        getDomains().addAll((Collection<? extends Domain>)newValue);
        return;
      case ContractPackage.VERIFICATION_PLAN__CLAIMS:
        getClaims().clear();
        getClaims().addAll((Collection<? extends Source>)newValue);
        return;
      case ContractPackage.VERIFICATION_PLAN__CONTRACTS:
        getContracts().clear();
        getContracts().addAll((Collection<? extends Contract>)newValue);
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
      case ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION:
        setOccurrenceDefinition((OccurrenceDefinition)null);
        return;
      case ContractPackage.VERIFICATION_PLAN__DOMAINS:
        getDomains().clear();
        return;
      case ContractPackage.VERIFICATION_PLAN__CLAIMS:
        getClaims().clear();
        return;
      case ContractPackage.VERIFICATION_PLAN__CONTRACTS:
        getContracts().clear();
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
      case ContractPackage.VERIFICATION_PLAN__OCCURRENCE_DEFINITION:
        return occurrenceDefinition != null;
      case ContractPackage.VERIFICATION_PLAN__DOMAINS:
        return domains != null && !domains.isEmpty();
      case ContractPackage.VERIFICATION_PLAN__CLAIMS:
        return claims != null && !claims.isEmpty();
      case ContractPackage.VERIFICATION_PLAN__CONTRACTS:
        return contracts != null && !contracts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VerificationPlanImpl
