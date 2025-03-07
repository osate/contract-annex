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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Predefined;
import org.osate.contract.contract.SingleValDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IString Var</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.IStringVarImpl#isDirect <em>Direct</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.IStringVarImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.IStringVarImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.IStringVarImpl#getPredefined <em>Predefined</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IStringVarImpl extends IStringPartImpl implements IStringVar
{
  /**
   * The default value of the '{@link #isDirect() <em>Direct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDirect()
   * @generated
   * @ordered
   */
  protected static final boolean DIRECT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDirect() <em>Direct</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDirect()
   * @generated
   * @ordered
   */
  protected boolean direct = DIRECT_EDEFAULT;

  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected Domain domain;

  /**
   * The cached value of the '{@link #getQuery() <em>Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected SingleValDeclaration query;

  /**
   * The default value of the '{@link #getPredefined() <em>Predefined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredefined()
   * @generated
   * @ordered
   */
  protected static final Predefined PREDEFINED_EDEFAULT = Predefined.ERROR;

  /**
   * The cached value of the '{@link #getPredefined() <em>Predefined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredefined()
   * @generated
   * @ordered
   */
  protected Predefined predefined = PREDEFINED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IStringVarImpl()
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
    return ContractPackage.Literals.ISTRING_VAR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDirect()
  {
    return direct;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDirect(boolean newDirect)
  {
    boolean oldDirect = direct;
    direct = newDirect;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ISTRING_VAR__DIRECT, oldDirect, direct));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Domain getDomain()
  {
    if (domain != null && domain.eIsProxy())
    {
      InternalEObject oldDomain = (InternalEObject)domain;
      domain = (Domain)eResolveProxy(oldDomain);
      if (domain != oldDomain)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContractPackage.ISTRING_VAR__DOMAIN, oldDomain, domain));
      }
    }
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain basicGetDomain()
  {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDomain(Domain newDomain)
  {
    Domain oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ISTRING_VAR__DOMAIN, oldDomain, domain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleValDeclaration getQuery()
  {
    if (query != null && query.eIsProxy())
    {
      InternalEObject oldQuery = (InternalEObject)query;
      query = (SingleValDeclaration)eResolveProxy(oldQuery);
      if (query != oldQuery)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContractPackage.ISTRING_VAR__QUERY, oldQuery, query));
      }
    }
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleValDeclaration basicGetQuery()
  {
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuery(SingleValDeclaration newQuery)
  {
    SingleValDeclaration oldQuery = query;
    query = newQuery;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ISTRING_VAR__QUERY, oldQuery, query));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Predefined getPredefined()
  {
    return predefined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPredefined(Predefined newPredefined)
  {
    Predefined oldPredefined = predefined;
    predefined = newPredefined == null ? PREDEFINED_EDEFAULT : newPredefined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.ISTRING_VAR__PREDEFINED, oldPredefined, predefined));
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
      case ContractPackage.ISTRING_VAR__DIRECT:
        return isDirect();
      case ContractPackage.ISTRING_VAR__DOMAIN:
        if (resolve) return getDomain();
        return basicGetDomain();
      case ContractPackage.ISTRING_VAR__QUERY:
        if (resolve) return getQuery();
        return basicGetQuery();
      case ContractPackage.ISTRING_VAR__PREDEFINED:
        return getPredefined();
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
      case ContractPackage.ISTRING_VAR__DIRECT:
        setDirect((Boolean)newValue);
        return;
      case ContractPackage.ISTRING_VAR__DOMAIN:
        setDomain((Domain)newValue);
        return;
      case ContractPackage.ISTRING_VAR__QUERY:
        setQuery((SingleValDeclaration)newValue);
        return;
      case ContractPackage.ISTRING_VAR__PREDEFINED:
        setPredefined((Predefined)newValue);
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
      case ContractPackage.ISTRING_VAR__DIRECT:
        setDirect(DIRECT_EDEFAULT);
        return;
      case ContractPackage.ISTRING_VAR__DOMAIN:
        setDomain((Domain)null);
        return;
      case ContractPackage.ISTRING_VAR__QUERY:
        setQuery((SingleValDeclaration)null);
        return;
      case ContractPackage.ISTRING_VAR__PREDEFINED:
        setPredefined(PREDEFINED_EDEFAULT);
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
      case ContractPackage.ISTRING_VAR__DIRECT:
        return direct != DIRECT_EDEFAULT;
      case ContractPackage.ISTRING_VAR__DOMAIN:
        return domain != null;
      case ContractPackage.ISTRING_VAR__QUERY:
        return query != null;
      case ContractPackage.ISTRING_VAR__PREDEFINED:
        return predefined != PREDEFINED_EDEFAULT;
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
    result.append(" (direct: ");
    result.append(direct);
    result.append(", predefined: ");
    result.append(predefined);
    result.append(')');
    return result.toString();
  }

} //IStringVarImpl
