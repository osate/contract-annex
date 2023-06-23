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
import org.osate.contract.contract.Expression;
import org.osate.contract.contract.Lambda;
import org.osate.contract.contract.MemberCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.MemberCallImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.MemberCallImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.MemberCallImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.MemberCallImpl#getLambda <em>Lambda</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberCallImpl extends ExpressionImpl implements MemberCall
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
   * The default value of the '{@link #getRight() <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected static final String RIGHT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected String right = RIGHT_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected Expression argument;

  /**
   * The cached value of the '{@link #getLambda() <em>Lambda</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLambda()
   * @generated
   * @ordered
   */
  protected Lambda lambda;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MemberCallImpl()
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
    return ContractPackage.Literals.MEMBER_CALL;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__LEFT, oldLeft, newLeft);
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
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRight(String newRight)
  {
    String oldRight = right;
    right = newRight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__RIGHT, oldRight, right));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getArgument()
  {
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgument(Expression newArgument, NotificationChain msgs)
  {
    Expression oldArgument = argument;
    argument = newArgument;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__ARGUMENT, oldArgument, newArgument);
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
  public void setArgument(Expression newArgument)
  {
    if (newArgument != argument)
    {
      NotificationChain msgs = null;
      if (argument != null)
        msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__ARGUMENT, null, msgs);
      if (newArgument != null)
        msgs = ((InternalEObject)newArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__ARGUMENT, null, msgs);
      msgs = basicSetArgument(newArgument, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__ARGUMENT, newArgument, newArgument));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Lambda getLambda()
  {
    return lambda;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLambda(Lambda newLambda, NotificationChain msgs)
  {
    Lambda oldLambda = lambda;
    lambda = newLambda;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__LAMBDA, oldLambda, newLambda);
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
  public void setLambda(Lambda newLambda)
  {
    if (newLambda != lambda)
    {
      NotificationChain msgs = null;
      if (lambda != null)
        msgs = ((InternalEObject)lambda).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__LAMBDA, null, msgs);
      if (newLambda != null)
        msgs = ((InternalEObject)newLambda).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.MEMBER_CALL__LAMBDA, null, msgs);
      msgs = basicSetLambda(newLambda, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.MEMBER_CALL__LAMBDA, newLambda, newLambda));
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
      case ContractPackage.MEMBER_CALL__LEFT:
        return basicSetLeft(null, msgs);
      case ContractPackage.MEMBER_CALL__ARGUMENT:
        return basicSetArgument(null, msgs);
      case ContractPackage.MEMBER_CALL__LAMBDA:
        return basicSetLambda(null, msgs);
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
      case ContractPackage.MEMBER_CALL__LEFT:
        return getLeft();
      case ContractPackage.MEMBER_CALL__RIGHT:
        return getRight();
      case ContractPackage.MEMBER_CALL__ARGUMENT:
        return getArgument();
      case ContractPackage.MEMBER_CALL__LAMBDA:
        return getLambda();
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
      case ContractPackage.MEMBER_CALL__LEFT:
        setLeft((Expression)newValue);
        return;
      case ContractPackage.MEMBER_CALL__RIGHT:
        setRight((String)newValue);
        return;
      case ContractPackage.MEMBER_CALL__ARGUMENT:
        setArgument((Expression)newValue);
        return;
      case ContractPackage.MEMBER_CALL__LAMBDA:
        setLambda((Lambda)newValue);
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
      case ContractPackage.MEMBER_CALL__LEFT:
        setLeft((Expression)null);
        return;
      case ContractPackage.MEMBER_CALL__RIGHT:
        setRight(RIGHT_EDEFAULT);
        return;
      case ContractPackage.MEMBER_CALL__ARGUMENT:
        setArgument((Expression)null);
        return;
      case ContractPackage.MEMBER_CALL__LAMBDA:
        setLambda((Lambda)null);
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
      case ContractPackage.MEMBER_CALL__LEFT:
        return left != null;
      case ContractPackage.MEMBER_CALL__RIGHT:
        return RIGHT_EDEFAULT == null ? right != null : !RIGHT_EDEFAULT.equals(right);
      case ContractPackage.MEMBER_CALL__ARGUMENT:
        return argument != null;
      case ContractPackage.MEMBER_CALL__LAMBDA:
        return lambda != null;
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
    result.append(" (right: ");
    result.append(right);
    result.append(')');
    return result.toString();
  }

} //MemberCallImpl
