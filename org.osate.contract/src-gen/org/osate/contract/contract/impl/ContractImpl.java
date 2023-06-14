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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.AssumptionElement;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.Guarantee;
import org.osate.contract.contract.InputAssumption;
import org.osate.contract.contract.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#isExact <em>Exact</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getGuarantee <em>Guarantee</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.ContractImpl#getAnalyses <em>Analyses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractImpl extends ContractElementImpl implements Contract
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
   * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueries()
   * @generated
   * @ordered
   */
  protected EList<Query> queries;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<InputAssumption> inputs;

  /**
   * The cached value of the '{@link #getAssumptions() <em>Assumptions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssumptions()
   * @generated
   * @ordered
   */
  protected EList<AssumptionElement> assumptions;

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
   * The cached value of the '{@link #getAnalyses() <em>Analyses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalyses()
   * @generated
   * @ordered
   */
  protected EList<Analysis> analyses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractImpl()
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
    return ContractPackage.Literals.CONTRACT;
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
      domains = new EObjectResolvingEList<Domain>(Domain.class, this, ContractPackage.CONTRACT__DOMAINS);
    }
    return domains;
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
      queries = new EObjectContainmentEList<Query>(Query.class, this, ContractPackage.CONTRACT__QUERIES);
    }
    return queries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InputAssumption> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<InputAssumption>(InputAssumption.class, this, ContractPackage.CONTRACT__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AssumptionElement> getAssumptions()
  {
    if (assumptions == null)
    {
      assumptions = new EObjectContainmentEList<AssumptionElement>(AssumptionElement.class, this, ContractPackage.CONTRACT__ASSUMPTIONS);
    }
    return assumptions;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.CONTRACT__EXACT, oldExact, exact));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.CONTRACT__GUARANTEE, oldGuarantee, newGuarantee);
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
        msgs = ((InternalEObject)guarantee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CONTRACT__GUARANTEE, null, msgs);
      if (newGuarantee != null)
        msgs = ((InternalEObject)newGuarantee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.CONTRACT__GUARANTEE, null, msgs);
      msgs = basicSetGuarantee(newGuarantee, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.CONTRACT__GUARANTEE, newGuarantee, newGuarantee));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Analysis> getAnalyses()
  {
    if (analyses == null)
    {
      analyses = new EObjectContainmentEList<Analysis>(Analysis.class, this, ContractPackage.CONTRACT__ANALYSES);
    }
    return analyses;
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
      case ContractPackage.CONTRACT__QUERIES:
        return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
      case ContractPackage.CONTRACT__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case ContractPackage.CONTRACT__ASSUMPTIONS:
        return ((InternalEList<?>)getAssumptions()).basicRemove(otherEnd, msgs);
      case ContractPackage.CONTRACT__GUARANTEE:
        return basicSetGuarantee(null, msgs);
      case ContractPackage.CONTRACT__ANALYSES:
        return ((InternalEList<?>)getAnalyses()).basicRemove(otherEnd, msgs);
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
      case ContractPackage.CONTRACT__DOMAINS:
        return getDomains();
      case ContractPackage.CONTRACT__QUERIES:
        return getQueries();
      case ContractPackage.CONTRACT__INPUTS:
        return getInputs();
      case ContractPackage.CONTRACT__ASSUMPTIONS:
        return getAssumptions();
      case ContractPackage.CONTRACT__EXACT:
        return isExact();
      case ContractPackage.CONTRACT__GUARANTEE:
        return getGuarantee();
      case ContractPackage.CONTRACT__ANALYSES:
        return getAnalyses();
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
      case ContractPackage.CONTRACT__DOMAINS:
        getDomains().clear();
        getDomains().addAll((Collection<? extends Domain>)newValue);
        return;
      case ContractPackage.CONTRACT__QUERIES:
        getQueries().clear();
        getQueries().addAll((Collection<? extends Query>)newValue);
        return;
      case ContractPackage.CONTRACT__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends InputAssumption>)newValue);
        return;
      case ContractPackage.CONTRACT__ASSUMPTIONS:
        getAssumptions().clear();
        getAssumptions().addAll((Collection<? extends AssumptionElement>)newValue);
        return;
      case ContractPackage.CONTRACT__EXACT:
        setExact((Boolean)newValue);
        return;
      case ContractPackage.CONTRACT__GUARANTEE:
        setGuarantee((Guarantee)newValue);
        return;
      case ContractPackage.CONTRACT__ANALYSES:
        getAnalyses().clear();
        getAnalyses().addAll((Collection<? extends Analysis>)newValue);
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
      case ContractPackage.CONTRACT__DOMAINS:
        getDomains().clear();
        return;
      case ContractPackage.CONTRACT__QUERIES:
        getQueries().clear();
        return;
      case ContractPackage.CONTRACT__INPUTS:
        getInputs().clear();
        return;
      case ContractPackage.CONTRACT__ASSUMPTIONS:
        getAssumptions().clear();
        return;
      case ContractPackage.CONTRACT__EXACT:
        setExact(EXACT_EDEFAULT);
        return;
      case ContractPackage.CONTRACT__GUARANTEE:
        setGuarantee((Guarantee)null);
        return;
      case ContractPackage.CONTRACT__ANALYSES:
        getAnalyses().clear();
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
      case ContractPackage.CONTRACT__DOMAINS:
        return domains != null && !domains.isEmpty();
      case ContractPackage.CONTRACT__QUERIES:
        return queries != null && !queries.isEmpty();
      case ContractPackage.CONTRACT__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case ContractPackage.CONTRACT__ASSUMPTIONS:
        return assumptions != null && !assumptions.isEmpty();
      case ContractPackage.CONTRACT__EXACT:
        return exact != EXACT_EDEFAULT;
      case ContractPackage.CONTRACT__GUARANTEE:
        return guarantee != null;
      case ContractPackage.CONTRACT__ANALYSES:
        return analyses != null && !analyses.isEmpty();
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

} //ContractImpl
