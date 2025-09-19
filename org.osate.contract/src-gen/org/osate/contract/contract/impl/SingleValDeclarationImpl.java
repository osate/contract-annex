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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.Expression;
import org.osate.contract.contract.SingleDeclaration;
import org.osate.contract.contract.SingleValDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Val Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.contract.contract.impl.SingleValDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.SingleValDeclarationImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.SingleValDeclarationImpl#getOwnedPropertyAssociations <em>Owned Property Association</em>}</li>
 *   <li>{@link org.osate.contract.contract.impl.SingleValDeclarationImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleValDeclarationImpl extends QueryImpl implements SingleValDeclaration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected static final String QUALIFIED_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOwnedPropertyAssociations() <em>Owned Property Association</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedPropertyAssociations()
   * @generated
   * @ordered
   */
  protected EList<PropertyAssociation> ownedPropertyAssociations;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Expression value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleValDeclarationImpl()
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
    return ContractPackage.Literals.SINGLE_VAL_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
		eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.SINGLE_VAL_DECLARATION__NAME, oldName, name));
	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getQualifiedName()
  {
		return getName();
    // TODO: implement this method to return the 'Qualified Name' attribute
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyAssociation> getOwnedPropertyAssociations()
  {
    if (ownedPropertyAssociations == null)
    {
      ownedPropertyAssociations = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class, this, ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION);
    }
    return ownedPropertyAssociations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs)
  {
    Expression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContractPackage.SINGLE_VAL_DECLARATION__VALUE, oldValue, newValue);
      if (msgs == null) {
		msgs = notification;
	} else {
		msgs.add(notification);
	}
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValue(Expression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null) {
		msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContractPackage.SINGLE_VAL_DECLARATION__VALUE, null, msgs);
	}
      if (newValue != null) {
		msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContractPackage.SINGLE_VAL_DECLARATION__VALUE, null, msgs);
	}
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) {
		msgs.dispatch();
	}
    }
    else if (eNotificationRequired()) {
		eNotify(new ENotificationImpl(this, Notification.SET, ContractPackage.SINGLE_VAL_DECLARATION__VALUE, newValue, newValue));
	}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Namespace getNamespace()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String qualifiedName()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PropertyExpression> getPropertyValues(String propertySetName, String propertyName)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
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
      case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION:
        return ((InternalEList<?>)getOwnedPropertyAssociations()).basicRemove(otherEnd, msgs);
      case ContractPackage.SINGLE_VAL_DECLARATION__VALUE:
        return basicSetValue(null, msgs);
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
      case ContractPackage.SINGLE_VAL_DECLARATION__NAME:
        return getName();
      case ContractPackage.SINGLE_VAL_DECLARATION__QUALIFIED_NAME:
        return getQualifiedName();
      case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION:
        return getOwnedPropertyAssociations();
      case ContractPackage.SINGLE_VAL_DECLARATION__VALUE:
        return getValue();
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
      case ContractPackage.SINGLE_VAL_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION:
        getOwnedPropertyAssociations().clear();
        getOwnedPropertyAssociations().addAll((Collection<? extends PropertyAssociation>)newValue);
        return;
      case ContractPackage.SINGLE_VAL_DECLARATION__VALUE:
        setValue((Expression)newValue);
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
      case ContractPackage.SINGLE_VAL_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION:
        getOwnedPropertyAssociations().clear();
        return;
      case ContractPackage.SINGLE_VAL_DECLARATION__VALUE:
        setValue((Expression)null);
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
      case ContractPackage.SINGLE_VAL_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ContractPackage.SINGLE_VAL_DECLARATION__QUALIFIED_NAME:
        return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
      case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION:
        return ownedPropertyAssociations != null && !ownedPropertyAssociations.isEmpty();
      case ContractPackage.SINGLE_VAL_DECLARATION__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == NamedElement.class)
    {
      switch (derivedFeatureID)
      {
        case ContractPackage.SINGLE_VAL_DECLARATION__NAME: return Aadl2Package.NAMED_ELEMENT__NAME;
        case ContractPackage.SINGLE_VAL_DECLARATION__QUALIFIED_NAME: return Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;
        case ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION: return Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;
        default: return -1;
      }
    }
    if (baseClass == SingleDeclaration.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == NamedElement.class)
    {
      switch (baseFeatureID)
      {
        case Aadl2Package.NAMED_ELEMENT__NAME: return ContractPackage.SINGLE_VAL_DECLARATION__NAME;
        case Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME: return ContractPackage.SINGLE_VAL_DECLARATION__QUALIFIED_NAME;
        case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION: return ContractPackage.SINGLE_VAL_DECLARATION__OWNED_PROPERTY_ASSOCIATION;
        default: return -1;
      }
    }
    if (baseClass == SingleDeclaration.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) {
		return super.toString();
	}

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

	@Override
	public PropertyAssociation createOwnedPropertyAssociation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PropertyExpression getSimplePropertyValue(Property property)
			throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyAcc getPropertyValue(Property property, boolean all) throws IllegalStateException,
			InvalidModelException, PropertyDoesNotApplyToHolderException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyAcc getPropertyValue(Property property) throws IllegalStateException, InvalidModelException,
			PropertyDoesNotApplyToHolderException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptsProperty(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getPropertyValueInternal(Property property, PropertyAcc pas, boolean fromInstanceSlaveCall, boolean all)
			throws InvalidModelException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getPropertyValueInternal(Property property, PropertyAcc pas, boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		// TODO Auto-generated method stub

	}

	@Override
	public PropertyAssociation setPropertyValue(Property pd, List<? extends PropertyExpression> pvl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkPropertyAssociation(Property pd, Collection<? extends PropertyExpression> vals) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyAssociations(Property pd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyAssociations(Property pd, List<? extends Mode> modes) {
		// TODO Auto-generated method stub

	}

	@Override
	public PropertyAssociation setPropertyValue(Property pd, List<? extends PropertyExpression> pvl,
			List<? extends Mode> modes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends PropertyExpression> getPropertyValueList(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyAssociation setPropertyValue(Property pd, PropertyValue pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyExpression getNonModalPropertyValue(Property pd) {
		// TODO Auto-generated method stub
		return null;
	}

} //SingleValDeclarationImpl
