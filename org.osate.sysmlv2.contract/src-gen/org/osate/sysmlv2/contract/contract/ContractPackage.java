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
package org.osate.sysmlv2.contract.contract;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.omg.sysml.lang.sysml.SysMLPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.sysmlv2.contract.contract.ContractFactory
 * @model kind="package"
 * @generated
 */
public interface ContractPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contract";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/contract/ContractForSysMLv2";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contract";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContractPackage eINSTANCE = org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractLibraryImpl <em>Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ContractLibraryImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractLibrary()
   * @generated
   */
  int CONTRACT_LIBRARY = 0;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNING_MEMBERSHIP = SysMLPackage.ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNED_RELATIONSHIP = SysMLPackage.ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNING_RELATIONSHIP = SysMLPackage.ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNING_NAMESPACE = SysMLPackage.ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__ELEMENT_ID = SysMLPackage.ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNER = SysMLPackage.ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNED_ELEMENT = SysMLPackage.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__DOCUMENTATION = SysMLPackage.ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__OWNED_ANNOTATION = SysMLPackage.ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__TEXTUAL_REPRESENTATION = SysMLPackage.ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__ALIAS_IDS = SysMLPackage.ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__DECLARED_SHORT_NAME = SysMLPackage.ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__DECLARED_NAME = SysMLPackage.ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__SHORT_NAME = SysMLPackage.ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__NAME = SysMLPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__QUALIFIED_NAME = SysMLPackage.ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__IS_IMPLIED_INCLUDED = SysMLPackage.ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__IS_LIBRARY_ELEMENT = SysMLPackage.ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Contract Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY__CONTRACT_ELEMENTS = SysMLPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_LIBRARY_FEATURE_COUNT = SysMLPackage.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ContractElementImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractElement()
   * @generated
   */
  int CONTRACT_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNING_MEMBERSHIP = SysMLPackage.ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNED_RELATIONSHIP = SysMLPackage.ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNING_RELATIONSHIP = SysMLPackage.ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNING_NAMESPACE = SysMLPackage.ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__ELEMENT_ID = SysMLPackage.ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNER = SysMLPackage.ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNED_ELEMENT = SysMLPackage.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__DOCUMENTATION = SysMLPackage.ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__OWNED_ANNOTATION = SysMLPackage.ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION = SysMLPackage.ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__ALIAS_IDS = SysMLPackage.ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__DECLARED_SHORT_NAME = SysMLPackage.ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__DECLARED_NAME = SysMLPackage.ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__SHORT_NAME = SysMLPackage.ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__NAME = SysMLPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__QUALIFIED_NAME = SysMLPackage.ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED = SysMLPackage.ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT = SysMLPackage.ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ELEMENT_FEATURE_COUNT = SysMLPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractImpl <em>Contract</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ContractImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContract()
   * @generated
   */
  int CONTRACT = 2;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNING_MEMBERSHIP = CONTRACT_ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNED_RELATIONSHIP = CONTRACT_ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNING_RELATIONSHIP = CONTRACT_ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNING_NAMESPACE = CONTRACT_ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ELEMENT_ID = CONTRACT_ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNER = CONTRACT_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNED_ELEMENT = CONTRACT_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DOCUMENTATION = CONTRACT_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__OWNED_ANNOTATION = CONTRACT_ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__TEXTUAL_REPRESENTATION = CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ALIAS_IDS = CONTRACT_ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DECLARED_SHORT_NAME = CONTRACT_ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DECLARED_NAME = CONTRACT_ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__SHORT_NAME = CONTRACT_ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__NAME = CONTRACT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__QUALIFIED_NAME = CONTRACT_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__IS_IMPLIED_INCLUDED = CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__IS_LIBRARY_ELEMENT = CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Domains</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__DOMAINS = CONTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__QUERIES = CONTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__INPUTS = CONTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Assumptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ASSUMPTIONS = CONTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__EXACT = CONTRACT_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Guarantee</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__GUARANTEE = CONTRACT_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Analyses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT__ANALYSES = CONTRACT_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Contract</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_FEATURE_COUNT = CONTRACT_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.InputAssumptionImpl <em>Input Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.InputAssumptionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getInputAssumption()
   * @generated
   */
  int INPUT_ASSUMPTION = 3;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ASSUMPTION__CODE = 0;

  /**
   * The number of structural features of the '<em>Input Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ASSUMPTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.AssumptionElementImpl <em>Assumption Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.AssumptionElementImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAssumptionElement()
   * @generated
   */
  int ASSUMPTION_ELEMENT = 4;

  /**
   * The number of structural features of the '<em>Assumption Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.GuaranteeImpl <em>Guarantee</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.GuaranteeImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getGuarantee()
   * @generated
   */
  int GUARANTEE = 5;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARANTEE__CODE = 0;

  /**
   * The number of structural features of the '<em>Guarantee</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARANTEE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.AnalysisImpl <em>Analysis</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.AnalysisImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAnalysis()
   * @generated
   */
  int ANALYSIS = 6;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS__CODE = 0;

  /**
   * The number of structural features of the '<em>Analysis</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANALYSIS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.SourceImpl <em>Source</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.SourceImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSource()
   * @generated
   */
  int SOURCE = 7;

  /**
   * The feature id for the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__SOURCE = 1;

  /**
   * The feature id for the '<em><b>Inter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE__INTER = 2;

  /**
   * The number of structural features of the '<em>Source</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ImplementationImpl <em>Implementation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ImplementationImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getImplementation()
   * @generated
   */
  int IMPLEMENTATION = 8;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNING_MEMBERSHIP = CONTRACT_ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNED_RELATIONSHIP = CONTRACT_ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNING_RELATIONSHIP = CONTRACT_ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNING_NAMESPACE = CONTRACT_ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__ELEMENT_ID = CONTRACT_ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNER = CONTRACT_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNED_ELEMENT = CONTRACT_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__DOCUMENTATION = CONTRACT_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__OWNED_ANNOTATION = CONTRACT_ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__TEXTUAL_REPRESENTATION = CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__ALIAS_IDS = CONTRACT_ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__DECLARED_SHORT_NAME = CONTRACT_ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__DECLARED_NAME = CONTRACT_ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__SHORT_NAME = CONTRACT_ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__NAME = CONTRACT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__QUALIFIED_NAME = CONTRACT_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__IS_IMPLIED_INCLUDED = CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__IS_LIBRARY_ELEMENT = CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION__CODE = CONTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Implementation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_FEATURE_COUNT = CONTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.DomainImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 9;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNING_MEMBERSHIP = CONTRACT_ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNED_RELATIONSHIP = CONTRACT_ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNING_RELATIONSHIP = CONTRACT_ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNING_NAMESPACE = CONTRACT_ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ELEMENT_ID = CONTRACT_ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNER = CONTRACT_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNED_ELEMENT = CONTRACT_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DOCUMENTATION = CONTRACT_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__OWNED_ANNOTATION = CONTRACT_ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__TEXTUAL_REPRESENTATION = CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ALIAS_IDS = CONTRACT_ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DECLARED_SHORT_NAME = CONTRACT_ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DECLARED_NAME = CONTRACT_ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__SHORT_NAME = CONTRACT_ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__NAME = CONTRACT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__QUALIFIED_NAME = CONTRACT_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__IS_IMPLIED_INCLUDED = CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__IS_LIBRARY_ELEMENT = CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__QUERIES = CONTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__CODE = CONTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = CONTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentImpl <em>Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgument()
   * @generated
   */
  int ARGUMENT = 10;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNING_MEMBERSHIP = CONTRACT_ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_RELATIONSHIP = CONTRACT_ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNING_RELATIONSHIP = CONTRACT_ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNING_NAMESPACE = CONTRACT_ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__ELEMENT_ID = CONTRACT_ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNER = CONTRACT_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_ELEMENT = CONTRACT_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__DOCUMENTATION = CONTRACT_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_ANNOTATION = CONTRACT_ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__TEXTUAL_REPRESENTATION = CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__ALIAS_IDS = CONTRACT_ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__DECLARED_SHORT_NAME = CONTRACT_ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__DECLARED_NAME = CONTRACT_ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__SHORT_NAME = CONTRACT_ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__NAME = CONTRACT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__QUALIFIED_NAME = CONTRACT_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__IS_IMPLIED_INCLUDED = CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__IS_LIBRARY_ELEMENT = CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Domains</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__DOMAINS = CONTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__EXACT = CONTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guarantee</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__GUARANTEE = CONTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Argument Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__ARGUMENT_EXPRESSION = CONTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_FEATURE_COUNT = CONTRACT_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentExpressionImpl <em>Argument Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentExpression()
   * @generated
   */
  int ARGUMENT_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION__CONTRACTS = 0;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION__ARGUMENTS = 1;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION__NESTED = 2;

  /**
   * The number of structural features of the '<em>Argument Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl <em>Verification Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getVerificationPlan()
   * @generated
   */
  int VERIFICATION_PLAN = 12;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNING_MEMBERSHIP = CONTRACT_ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNED_RELATIONSHIP = CONTRACT_ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNING_RELATIONSHIP = CONTRACT_ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNING_NAMESPACE = CONTRACT_ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__ELEMENT_ID = CONTRACT_ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNER = CONTRACT_ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNED_ELEMENT = CONTRACT_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__DOCUMENTATION = CONTRACT_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OWNED_ANNOTATION = CONTRACT_ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__TEXTUAL_REPRESENTATION = CONTRACT_ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__ALIAS_IDS = CONTRACT_ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__DECLARED_SHORT_NAME = CONTRACT_ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__DECLARED_NAME = CONTRACT_ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__SHORT_NAME = CONTRACT_ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__NAME = CONTRACT_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__QUALIFIED_NAME = CONTRACT_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__IS_IMPLIED_INCLUDED = CONTRACT_ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__IS_LIBRARY_ELEMENT = CONTRACT_ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Occurence Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__OCCURENCE_DEFINITION = CONTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Domains</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__DOMAINS = CONTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Claims</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__CLAIMS = CONTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__CONTRACTS = CONTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Verification Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN_FEATURE_COUNT = CONTRACT_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.QueryImpl <em>Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.QueryImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getQuery()
   * @generated
   */
  int QUERY = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__VALUE = 0;

  /**
   * The number of structural features of the '<em>Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.SingleValDeclarationImpl <em>Single Val Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.SingleValDeclarationImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSingleValDeclaration()
   * @generated
   */
  int SINGLE_VAL_DECLARATION = 14;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNING_MEMBERSHIP = SysMLPackage.ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNED_RELATIONSHIP = SysMLPackage.ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNING_RELATIONSHIP = SysMLPackage.ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNING_NAMESPACE = SysMLPackage.ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__ELEMENT_ID = SysMLPackage.ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNER = SysMLPackage.ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNED_ELEMENT = SysMLPackage.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__DOCUMENTATION = SysMLPackage.ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__OWNED_ANNOTATION = SysMLPackage.ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__TEXTUAL_REPRESENTATION = SysMLPackage.ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__ALIAS_IDS = SysMLPackage.ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__DECLARED_SHORT_NAME = SysMLPackage.ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__DECLARED_NAME = SysMLPackage.ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__SHORT_NAME = SysMLPackage.ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__NAME = SysMLPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__QUALIFIED_NAME = SysMLPackage.ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__IS_IMPLIED_INCLUDED = SysMLPackage.ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__IS_LIBRARY_ELEMENT = SysMLPackage.ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION__VALUE = SysMLPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Single Val Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VAL_DECLARATION_FEATURE_COUNT = SysMLPackage.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleNameImpl <em>Tuple Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.TupleNameImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleName()
   * @generated
   */
  int TUPLE_NAME = 15;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNING_MEMBERSHIP = SysMLPackage.ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNED_RELATIONSHIP = SysMLPackage.ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNING_RELATIONSHIP = SysMLPackage.ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNING_NAMESPACE = SysMLPackage.ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__ELEMENT_ID = SysMLPackage.ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNER = SysMLPackage.ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNED_ELEMENT = SysMLPackage.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__DOCUMENTATION = SysMLPackage.ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__OWNED_ANNOTATION = SysMLPackage.ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__TEXTUAL_REPRESENTATION = SysMLPackage.ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__ALIAS_IDS = SysMLPackage.ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__DECLARED_SHORT_NAME = SysMLPackage.ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__DECLARED_NAME = SysMLPackage.ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__SHORT_NAME = SysMLPackage.ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__NAME = SysMLPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__QUALIFIED_NAME = SysMLPackage.ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__IS_IMPLIED_INCLUDED = SysMLPackage.ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME__IS_LIBRARY_ELEMENT = SysMLPackage.ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The number of structural features of the '<em>Tuple Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_NAME_FEATURE_COUNT = SysMLPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 16;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.LambdaImpl <em>Lambda</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.LambdaImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getLambda()
   * @generated
   */
  int LAMBDA = 17;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAMBDA__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAMBDA__QUERIES = 1;

  /**
   * The feature id for the '<em><b>Return Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAMBDA__RETURN_VALUE = 2;

  /**
   * The number of structural features of the '<em>Lambda</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAMBDA_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ParameterImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 18;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.SingleParameterImpl <em>Single Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.SingleParameterImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSingleParameter()
   * @generated
   */
  int SINGLE_PARAMETER = 19;

  /**
   * The feature id for the '<em><b>Owning Membership</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNING_MEMBERSHIP = SysMLPackage.ELEMENT__OWNING_MEMBERSHIP;

  /**
   * The feature id for the '<em><b>Owned Relationship</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNED_RELATIONSHIP = SysMLPackage.ELEMENT__OWNED_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Relationship</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNING_RELATIONSHIP = SysMLPackage.ELEMENT__OWNING_RELATIONSHIP;

  /**
   * The feature id for the '<em><b>Owning Namespace</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNING_NAMESPACE = SysMLPackage.ELEMENT__OWNING_NAMESPACE;

  /**
   * The feature id for the '<em><b>Element Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__ELEMENT_ID = SysMLPackage.ELEMENT__ELEMENT_ID;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNER = SysMLPackage.ELEMENT__OWNER;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNED_ELEMENT = SysMLPackage.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__DOCUMENTATION = SysMLPackage.ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Owned Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__OWNED_ANNOTATION = SysMLPackage.ELEMENT__OWNED_ANNOTATION;

  /**
   * The feature id for the '<em><b>Textual Representation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__TEXTUAL_REPRESENTATION = SysMLPackage.ELEMENT__TEXTUAL_REPRESENTATION;

  /**
   * The feature id for the '<em><b>Alias Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__ALIAS_IDS = SysMLPackage.ELEMENT__ALIAS_IDS;

  /**
   * The feature id for the '<em><b>Declared Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__DECLARED_SHORT_NAME = SysMLPackage.ELEMENT__DECLARED_SHORT_NAME;

  /**
   * The feature id for the '<em><b>Declared Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__DECLARED_NAME = SysMLPackage.ELEMENT__DECLARED_NAME;

  /**
   * The feature id for the '<em><b>Short Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__SHORT_NAME = SysMLPackage.ELEMENT__SHORT_NAME;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__NAME = SysMLPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__QUALIFIED_NAME = SysMLPackage.ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Is Implied Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__IS_IMPLIED_INCLUDED = SysMLPackage.ELEMENT__IS_IMPLIED_INCLUDED;

  /**
   * The feature id for the '<em><b>Is Library Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER__IS_LIBRARY_ELEMENT = SysMLPackage.ELEMENT__IS_LIBRARY_ELEMENT;

  /**
   * The number of structural features of the '<em>Single Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARAMETER_FEATURE_COUNT = SysMLPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringImpl <em>IString</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.IStringImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIString()
   * @generated
   */
  int ISTRING = 20;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING__PARTS = 0;

  /**
   * The number of structural features of the '<em>IString</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringPartImpl <em>IString Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.IStringPartImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringPart()
   * @generated
   */
  int ISTRING_PART = 21;

  /**
   * The number of structural features of the '<em>IString Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_PART_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringLiteralImpl <em>IString Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.IStringLiteralImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringLiteral()
   * @generated
   */
  int ISTRING_LITERAL = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_LITERAL__VALUE = ISTRING_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>IString Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_LITERAL_FEATURE_COUNT = ISTRING_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringVarImpl <em>IString Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.IStringVarImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringVar()
   * @generated
   */
  int ISTRING_VAR = 23;

  /**
   * The feature id for the '<em><b>Direct</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_VAR__DIRECT = ISTRING_PART_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Domain</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_VAR__DOMAIN = ISTRING_PART_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Query</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_VAR__QUERY = ISTRING_PART_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Predefined</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_VAR__PREDEFINED = ISTRING_PART_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>IString Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISTRING_VAR_FEATURE_COUNT = ISTRING_PART_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractAssumptionImpl <em>Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ContractAssumptionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractAssumption()
   * @generated
   */
  int CONTRACT_ASSUMPTION = 24;

  /**
   * The feature id for the '<em><b>Contract</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ASSUMPTION__CONTRACT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACT_ASSUMPTION_FEATURE_COUNT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentAssumptionImpl <em>Argument Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentAssumptionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentAssumption()
   * @generated
   */
  int ARGUMENT_ASSUMPTION = 25;

  /**
   * The feature id for the '<em><b>Argument</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ASSUMPTION__ARGUMENT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Argument Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_ASSUMPTION_FEATURE_COUNT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl <em>Code Assumption</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getCodeAssumption()
   * @generated
   */
  int CODE_ASSUMPTION = 26;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_ASSUMPTION__CODE = ASSUMPTION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_ASSUMPTION__EXACT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guarantee</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_ASSUMPTION__GUARANTEE = ASSUMPTION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Code Assumption</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_ASSUMPTION_FEATURE_COUNT = ASSUMPTION_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentAndImpl <em>Argument And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentAndImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentAnd()
   * @generated
   */
  int ARGUMENT_AND = 27;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_AND__CONTRACTS = ARGUMENT_EXPRESSION__CONTRACTS;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_AND__ARGUMENTS = ARGUMENT_EXPRESSION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_AND__NESTED = ARGUMENT_EXPRESSION__NESTED;

  /**
   * The number of structural features of the '<em>Argument And</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_AND_FEATURE_COUNT = ARGUMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentOrImpl <em>Argument Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentOrImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentOr()
   * @generated
   */
  int ARGUMENT_OR = 28;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_OR__CONTRACTS = ARGUMENT_EXPRESSION__CONTRACTS;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_OR__ARGUMENTS = ARGUMENT_EXPRESSION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_OR__NESTED = ARGUMENT_EXPRESSION__NESTED;

  /**
   * The number of structural features of the '<em>Argument Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_OR_FEATURE_COUNT = ARGUMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentNotImpl <em>Argument Not</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.ArgumentNotImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentNot()
   * @generated
   */
  int ARGUMENT_NOT = 29;

  /**
   * The feature id for the '<em><b>Contracts</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_NOT__CONTRACTS = ARGUMENT_EXPRESSION__CONTRACTS;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_NOT__ARGUMENTS = ARGUMENT_EXPRESSION__ARGUMENTS;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_NOT__NESTED = ARGUMENT_EXPRESSION__NESTED;

  /**
   * The number of structural features of the '<em>Argument Not</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_NOT_FEATURE_COUNT = ARGUMENT_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleDeclarationImpl <em>Tuple Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.TupleDeclarationImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleDeclaration()
   * @generated
   */
  int TUPLE_DECLARATION = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_DECLARATION__VALUE = QUERY__VALUE;

  /**
   * The feature id for the '<em><b>Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_DECLARATION__NAMES = QUERY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_DECLARATION_FEATURE_COUNT = QUERY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.OrExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 31;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.AndExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 32;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.NotExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 33;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.MemberCallImpl <em>Member Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.MemberCallImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getMemberCall()
   * @generated
   */
  int MEMBER_CALL = 34;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type Argument</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL__TYPE_ARGUMENT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL__ARGUMENT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Lambda</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL__LAMBDA = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Member Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEMBER_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl <em>Property Lookup</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getPropertyLookup()
   * @generated
   */
  int PROPERTY_LOOKUP = 35;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_LOOKUP__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_LOOKUP__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property Lookup</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_LOOKUP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleParameterImpl <em>Tuple Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.TupleParameterImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleParameter()
   * @generated
   */
  int TUPLE_PARAMETER = 36;

  /**
   * The feature id for the '<em><b>Names</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PARAMETER__NAMES = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.SelfExpressionImpl <em>Self Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.SelfExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSelfExpression()
   * @generated
   */
  int SELF_EXPRESSION = 37;

  /**
   * The number of structural features of the '<em>Self Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELF_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.StringLiteralImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 38;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.NameReferenceImpl <em>Name Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.NameReferenceImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getNameReference()
   * @generated
   */
  int NAME_REFERENCE = 39;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_REFERENCE__REFERENCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.UsageExpressionImpl <em>Usage Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.UsageExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getUsageExpression()
   * @generated
   */
  int USAGE_EXPRESSION = 40;

  /**
   * The feature id for the '<em><b>Usage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USAGE_EXPRESSION__USAGE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Usage Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USAGE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.impl.TupleExpressionImpl
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleExpression()
   * @generated
   */
  int TUPLE_EXPRESSION = 41;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_EXPRESSION__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.Language <em>Language</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.Language
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getLanguage()
   * @generated
   */
  int LANGUAGE = 42;

  /**
   * The meta object id for the '{@link org.osate.sysmlv2.contract.contract.Predefined <em>Predefined</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.sysmlv2.contract.contract.Predefined
   * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getPredefined()
   * @generated
   */
  int PREDEFINED = 43;


  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ContractLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Library</em>'.
   * @see org.osate.sysmlv2.contract.contract.ContractLibrary
   * @generated
   */
  EClass getContractLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.ContractLibrary#getContractElements <em>Contract Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contract Elements</em>'.
   * @see org.osate.sysmlv2.contract.contract.ContractLibrary#getContractElements()
   * @see #getContractLibrary()
   * @generated
   */
  EReference getContractLibrary_ContractElements();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ContractElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.osate.sysmlv2.contract.contract.ContractElement
   * @generated
   */
  EClass getContractElement();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Contract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contract</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract
   * @generated
   */
  EClass getContract();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.Contract#getDomains <em>Domains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Domains</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getDomains()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Domains();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Contract#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getQueries()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Queries();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Contract#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getInputs()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Inputs();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Contract#getAssumptions <em>Assumptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumptions</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getAssumptions()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Assumptions();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.Contract#isExact <em>Exact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exact</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#isExact()
   * @see #getContract()
   * @generated
   */
  EAttribute getContract_Exact();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Contract#getGuarantee <em>Guarantee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guarantee</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getGuarantee()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Guarantee();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Contract#getAnalyses <em>Analyses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Analyses</em>'.
   * @see org.osate.sysmlv2.contract.contract.Contract#getAnalyses()
   * @see #getContract()
   * @generated
   */
  EReference getContract_Analyses();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.InputAssumption <em>Input Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Assumption</em>'.
   * @see org.osate.sysmlv2.contract.contract.InputAssumption
   * @generated
   */
  EClass getInputAssumption();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.InputAssumption#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.InputAssumption#getCode()
   * @see #getInputAssumption()
   * @generated
   */
  EReference getInputAssumption_Code();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.AssumptionElement <em>Assumption Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption Element</em>'.
   * @see org.osate.sysmlv2.contract.contract.AssumptionElement
   * @generated
   */
  EClass getAssumptionElement();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Guarantee <em>Guarantee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guarantee</em>'.
   * @see org.osate.sysmlv2.contract.contract.Guarantee
   * @generated
   */
  EClass getGuarantee();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Guarantee#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.Guarantee#getCode()
   * @see #getGuarantee()
   * @generated
   */
  EReference getGuarantee_Code();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Analysis <em>Analysis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis</em>'.
   * @see org.osate.sysmlv2.contract.contract.Analysis
   * @generated
   */
  EClass getAnalysis();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Analysis#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.Analysis#getCode()
   * @see #getAnalysis()
   * @generated
   */
  EReference getAnalysis_Code();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Source <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source</em>'.
   * @see org.osate.sysmlv2.contract.contract.Source
   * @generated
   */
  EClass getSource();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.Source#getLanguage <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language</em>'.
   * @see org.osate.sysmlv2.contract.contract.Source#getLanguage()
   * @see #getSource()
   * @generated
   */
  EAttribute getSource_Language();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.Source#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see org.osate.sysmlv2.contract.contract.Source#getSource()
   * @see #getSource()
   * @generated
   */
  EAttribute getSource_Source();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Source#getInter <em>Inter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inter</em>'.
   * @see org.osate.sysmlv2.contract.contract.Source#getInter()
   * @see #getSource()
   * @generated
   */
  EReference getSource_Inter();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Implementation <em>Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implementation</em>'.
   * @see org.osate.sysmlv2.contract.contract.Implementation
   * @generated
   */
  EClass getImplementation();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Implementation#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.Implementation#getCode()
   * @see #getImplementation()
   * @generated
   */
  EReference getImplementation_Code();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.osate.sysmlv2.contract.contract.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Domain#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see org.osate.sysmlv2.contract.contract.Domain#getQueries()
   * @see #getDomain()
   * @generated
   */
  EReference getDomain_Queries();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Domain#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.Domain#getCode()
   * @see #getDomain()
   * @generated
   */
  EReference getDomain_Code();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Argument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument</em>'.
   * @see org.osate.sysmlv2.contract.contract.Argument
   * @generated
   */
  EClass getArgument();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.Argument#getDomains <em>Domains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Domains</em>'.
   * @see org.osate.sysmlv2.contract.contract.Argument#getDomains()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_Domains();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.Argument#isExact <em>Exact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exact</em>'.
   * @see org.osate.sysmlv2.contract.contract.Argument#isExact()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_Exact();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Argument#getGuarantee <em>Guarantee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guarantee</em>'.
   * @see org.osate.sysmlv2.contract.contract.Argument#getGuarantee()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_Guarantee();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Argument#getArgumentExpression <em>Argument Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.Argument#getArgumentExpression()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_ArgumentExpression();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ArgumentExpression <em>Argument Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentExpression
   * @generated
   */
  EClass getArgumentExpression();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.ArgumentExpression#getContracts <em>Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Contracts</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentExpression#getContracts()
   * @see #getArgumentExpression()
   * @generated
   */
  EReference getArgumentExpression_Contracts();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.ArgumentExpression#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Arguments</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentExpression#getArguments()
   * @see #getArgumentExpression()
   * @generated
   */
  EReference getArgumentExpression_Arguments();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.ArgumentExpression#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentExpression#getNested()
   * @see #getArgumentExpression()
   * @generated
   */
  EReference getArgumentExpression_Nested();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.VerificationPlan <em>Verification Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Plan</em>'.
   * @see org.osate.sysmlv2.contract.contract.VerificationPlan
   * @generated
   */
  EClass getVerificationPlan();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getOccurenceDefinition <em>Occurence Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Occurence Definition</em>'.
   * @see org.osate.sysmlv2.contract.contract.VerificationPlan#getOccurenceDefinition()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_OccurenceDefinition();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getDomains <em>Domains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Domains</em>'.
   * @see org.osate.sysmlv2.contract.contract.VerificationPlan#getDomains()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Domains();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getClaims <em>Claims</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claims</em>'.
   * @see org.osate.sysmlv2.contract.contract.VerificationPlan#getClaims()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Claims();

  /**
   * Returns the meta object for the reference list '{@link org.osate.sysmlv2.contract.contract.VerificationPlan#getContracts <em>Contracts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Contracts</em>'.
   * @see org.osate.sysmlv2.contract.contract.VerificationPlan#getContracts()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Contracts();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query</em>'.
   * @see org.osate.sysmlv2.contract.contract.Query
   * @generated
   */
  EClass getQuery();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Query#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.sysmlv2.contract.contract.Query#getValue()
   * @see #getQuery()
   * @generated
   */
  EReference getQuery_Value();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.SingleValDeclaration <em>Single Val Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Val Declaration</em>'.
   * @see org.osate.sysmlv2.contract.contract.SingleValDeclaration
   * @generated
   */
  EClass getSingleValDeclaration();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.TupleName <em>Tuple Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Name</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleName
   * @generated
   */
  EClass getTupleName();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Lambda <em>Lambda</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lambda</em>'.
   * @see org.osate.sysmlv2.contract.contract.Lambda
   * @generated
   */
  EClass getLambda();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Lambda#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameter</em>'.
   * @see org.osate.sysmlv2.contract.contract.Lambda#getParameter()
   * @see #getLambda()
   * @generated
   */
  EReference getLambda_Parameter();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.Lambda#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see org.osate.sysmlv2.contract.contract.Lambda#getQueries()
   * @see #getLambda()
   * @generated
   */
  EReference getLambda_Queries();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.Lambda#getReturnValue <em>Return Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Value</em>'.
   * @see org.osate.sysmlv2.contract.contract.Lambda#getReturnValue()
   * @see #getLambda()
   * @generated
   */
  EReference getLambda_ReturnValue();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.osate.sysmlv2.contract.contract.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.SingleParameter <em>Single Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Parameter</em>'.
   * @see org.osate.sysmlv2.contract.contract.SingleParameter
   * @generated
   */
  EClass getSingleParameter();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.IString <em>IString</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IString</em>'.
   * @see org.osate.sysmlv2.contract.contract.IString
   * @generated
   */
  EClass getIString();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.IString#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see org.osate.sysmlv2.contract.contract.IString#getParts()
   * @see #getIString()
   * @generated
   */
  EReference getIString_Parts();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.IStringPart <em>IString Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IString Part</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringPart
   * @generated
   */
  EClass getIStringPart();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.IStringLiteral <em>IString Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IString Literal</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringLiteral
   * @generated
   */
  EClass getIStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.IStringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringLiteral#getValue()
   * @see #getIStringLiteral()
   * @generated
   */
  EAttribute getIStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.IStringVar <em>IString Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IString Var</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringVar
   * @generated
   */
  EClass getIStringVar();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.IStringVar#isDirect <em>Direct</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direct</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringVar#isDirect()
   * @see #getIStringVar()
   * @generated
   */
  EAttribute getIStringVar_Direct();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.IStringVar#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Domain</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringVar#getDomain()
   * @see #getIStringVar()
   * @generated
   */
  EReference getIStringVar_Domain();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.IStringVar#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Query</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringVar#getQuery()
   * @see #getIStringVar()
   * @generated
   */
  EReference getIStringVar_Query();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.IStringVar#getPredefined <em>Predefined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Predefined</em>'.
   * @see org.osate.sysmlv2.contract.contract.IStringVar#getPredefined()
   * @see #getIStringVar()
   * @generated
   */
  EAttribute getIStringVar_Predefined();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ContractAssumption <em>Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption</em>'.
   * @see org.osate.sysmlv2.contract.contract.ContractAssumption
   * @generated
   */
  EClass getContractAssumption();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.ContractAssumption#getContract <em>Contract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Contract</em>'.
   * @see org.osate.sysmlv2.contract.contract.ContractAssumption#getContract()
   * @see #getContractAssumption()
   * @generated
   */
  EReference getContractAssumption_Contract();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ArgumentAssumption <em>Argument Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Assumption</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentAssumption
   * @generated
   */
  EClass getArgumentAssumption();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.ArgumentAssumption#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Argument</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentAssumption#getArgument()
   * @see #getArgumentAssumption()
   * @generated
   */
  EReference getArgumentAssumption_Argument();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.CodeAssumption <em>Code Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Assumption</em>'.
   * @see org.osate.sysmlv2.contract.contract.CodeAssumption
   * @generated
   */
  EClass getCodeAssumption();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.CodeAssumption#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see org.osate.sysmlv2.contract.contract.CodeAssumption#getCode()
   * @see #getCodeAssumption()
   * @generated
   */
  EReference getCodeAssumption_Code();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.CodeAssumption#isExact <em>Exact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exact</em>'.
   * @see org.osate.sysmlv2.contract.contract.CodeAssumption#isExact()
   * @see #getCodeAssumption()
   * @generated
   */
  EAttribute getCodeAssumption_Exact();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.CodeAssumption#getGuarantee <em>Guarantee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guarantee</em>'.
   * @see org.osate.sysmlv2.contract.contract.CodeAssumption#getGuarantee()
   * @see #getCodeAssumption()
   * @generated
   */
  EReference getCodeAssumption_Guarantee();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ArgumentAnd <em>Argument And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument And</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentAnd
   * @generated
   */
  EClass getArgumentAnd();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ArgumentOr <em>Argument Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Or</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentOr
   * @generated
   */
  EClass getArgumentOr();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.ArgumentNot <em>Argument Not</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Not</em>'.
   * @see org.osate.sysmlv2.contract.contract.ArgumentNot
   * @generated
   */
  EClass getArgumentNot();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.TupleDeclaration <em>Tuple Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Declaration</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleDeclaration
   * @generated
   */
  EClass getTupleDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.TupleDeclaration#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Names</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleDeclaration#getNames()
   * @see #getTupleDeclaration()
   * @generated
   */
  EReference getTupleDeclaration_Names();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.sysmlv2.contract.contract.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.sysmlv2.contract.contract.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.sysmlv2.contract.contract.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.sysmlv2.contract.contract.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.NotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.osate.sysmlv2.contract.contract.NotExpression#getOperand()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.MemberCall <em>Member Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Member Call</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall
   * @generated
   */
  EClass getMemberCall();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.MemberCall#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall#getLeft()
   * @see #getMemberCall()
   * @generated
   */
  EReference getMemberCall_Left();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.MemberCall#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Right</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall#getRight()
   * @see #getMemberCall()
   * @generated
   */
  EAttribute getMemberCall_Right();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.MemberCall#getTypeArgument <em>Type Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Argument</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall#getTypeArgument()
   * @see #getMemberCall()
   * @generated
   */
  EAttribute getMemberCall_TypeArgument();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.MemberCall#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall#getArgument()
   * @see #getMemberCall()
   * @generated
   */
  EReference getMemberCall_Argument();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.MemberCall#getLambda <em>Lambda</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lambda</em>'.
   * @see org.osate.sysmlv2.contract.contract.MemberCall#getLambda()
   * @see #getMemberCall()
   * @generated
   */
  EReference getMemberCall_Lambda();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.PropertyLookup <em>Property Lookup</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Lookup</em>'.
   * @see org.osate.sysmlv2.contract.contract.PropertyLookup
   * @generated
   */
  EClass getPropertyLookup();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.sysmlv2.contract.contract.PropertyLookup#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.sysmlv2.contract.contract.PropertyLookup#getLeft()
   * @see #getPropertyLookup()
   * @generated
   */
  EReference getPropertyLookup_Left();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.PropertyLookup#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right</em>'.
   * @see org.osate.sysmlv2.contract.contract.PropertyLookup#getRight()
   * @see #getPropertyLookup()
   * @generated
   */
  EReference getPropertyLookup_Right();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.TupleParameter <em>Tuple Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Parameter</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleParameter
   * @generated
   */
  EClass getTupleParameter();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.TupleParameter#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Names</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleParameter#getNames()
   * @see #getTupleParameter()
   * @generated
   */
  EReference getTupleParameter_Names();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.SelfExpression <em>Self Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Self Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.SelfExpression
   * @generated
   */
  EClass getSelfExpression();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.osate.sysmlv2.contract.contract.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.sysmlv2.contract.contract.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.sysmlv2.contract.contract.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.NameReference <em>Name Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Reference</em>'.
   * @see org.osate.sysmlv2.contract.contract.NameReference
   * @generated
   */
  EClass getNameReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.NameReference#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.osate.sysmlv2.contract.contract.NameReference#getReference()
   * @see #getNameReference()
   * @generated
   */
  EReference getNameReference_Reference();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.UsageExpression <em>Usage Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Usage Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.UsageExpression
   * @generated
   */
  EClass getUsageExpression();

  /**
   * Returns the meta object for the reference '{@link org.osate.sysmlv2.contract.contract.UsageExpression#getUsage <em>Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Usage</em>'.
   * @see org.osate.sysmlv2.contract.contract.UsageExpression#getUsage()
   * @see #getUsageExpression()
   * @generated
   */
  EReference getUsageExpression_Usage();

  /**
   * Returns the meta object for class '{@link org.osate.sysmlv2.contract.contract.TupleExpression <em>Tuple Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Expression</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleExpression
   * @generated
   */
  EClass getTupleExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.sysmlv2.contract.contract.TupleExpression#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.sysmlv2.contract.contract.TupleExpression#getElements()
   * @see #getTupleExpression()
   * @generated
   */
  EReference getTupleExpression_Elements();

  /**
   * Returns the meta object for enum '{@link org.osate.sysmlv2.contract.contract.Language <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Language</em>'.
   * @see org.osate.sysmlv2.contract.contract.Language
   * @generated
   */
  EEnum getLanguage();

  /**
   * Returns the meta object for enum '{@link org.osate.sysmlv2.contract.contract.Predefined <em>Predefined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Predefined</em>'.
   * @see org.osate.sysmlv2.contract.contract.Predefined
   * @generated
   */
  EEnum getPredefined();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContractFactory getContractFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractLibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ContractLibraryImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractLibrary()
     * @generated
     */
    EClass CONTRACT_LIBRARY = eINSTANCE.getContractLibrary();

    /**
     * The meta object literal for the '<em><b>Contract Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_LIBRARY__CONTRACT_ELEMENTS = eINSTANCE.getContractLibrary_ContractElements();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ContractElementImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractElement()
     * @generated
     */
    EClass CONTRACT_ELEMENT = eINSTANCE.getContractElement();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractImpl <em>Contract</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ContractImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContract()
     * @generated
     */
    EClass CONTRACT = eINSTANCE.getContract();

    /**
     * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__DOMAINS = eINSTANCE.getContract_Domains();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__QUERIES = eINSTANCE.getContract_Queries();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__INPUTS = eINSTANCE.getContract_Inputs();

    /**
     * The meta object literal for the '<em><b>Assumptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__ASSUMPTIONS = eINSTANCE.getContract_Assumptions();

    /**
     * The meta object literal for the '<em><b>Exact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACT__EXACT = eINSTANCE.getContract_Exact();

    /**
     * The meta object literal for the '<em><b>Guarantee</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__GUARANTEE = eINSTANCE.getContract_Guarantee();

    /**
     * The meta object literal for the '<em><b>Analyses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT__ANALYSES = eINSTANCE.getContract_Analyses();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.InputAssumptionImpl <em>Input Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.InputAssumptionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getInputAssumption()
     * @generated
     */
    EClass INPUT_ASSUMPTION = eINSTANCE.getInputAssumption();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ASSUMPTION__CODE = eINSTANCE.getInputAssumption_Code();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.AssumptionElementImpl <em>Assumption Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.AssumptionElementImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAssumptionElement()
     * @generated
     */
    EClass ASSUMPTION_ELEMENT = eINSTANCE.getAssumptionElement();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.GuaranteeImpl <em>Guarantee</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.GuaranteeImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getGuarantee()
     * @generated
     */
    EClass GUARANTEE = eINSTANCE.getGuarantee();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARANTEE__CODE = eINSTANCE.getGuarantee_Code();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.AnalysisImpl <em>Analysis</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.AnalysisImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAnalysis()
     * @generated
     */
    EClass ANALYSIS = eINSTANCE.getAnalysis();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANALYSIS__CODE = eINSTANCE.getAnalysis_Code();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.SourceImpl <em>Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.SourceImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSource()
     * @generated
     */
    EClass SOURCE = eINSTANCE.getSource();

    /**
     * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE__LANGUAGE = eINSTANCE.getSource_Language();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE__SOURCE = eINSTANCE.getSource_Source();

    /**
     * The meta object literal for the '<em><b>Inter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE__INTER = eINSTANCE.getSource_Inter();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ImplementationImpl <em>Implementation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ImplementationImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getImplementation()
     * @generated
     */
    EClass IMPLEMENTATION = eINSTANCE.getImplementation();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLEMENTATION__CODE = eINSTANCE.getImplementation_Code();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.DomainImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN__QUERIES = eINSTANCE.getDomain_Queries();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN__CODE = eINSTANCE.getDomain_Code();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentImpl <em>Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgument()
     * @generated
     */
    EClass ARGUMENT = eINSTANCE.getArgument();

    /**
     * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__DOMAINS = eINSTANCE.getArgument_Domains();

    /**
     * The meta object literal for the '<em><b>Exact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__EXACT = eINSTANCE.getArgument_Exact();

    /**
     * The meta object literal for the '<em><b>Guarantee</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__GUARANTEE = eINSTANCE.getArgument_Guarantee();

    /**
     * The meta object literal for the '<em><b>Argument Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__ARGUMENT_EXPRESSION = eINSTANCE.getArgument_ArgumentExpression();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentExpressionImpl <em>Argument Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentExpression()
     * @generated
     */
    EClass ARGUMENT_EXPRESSION = eINSTANCE.getArgumentExpression();

    /**
     * The meta object literal for the '<em><b>Contracts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_EXPRESSION__CONTRACTS = eINSTANCE.getArgumentExpression_Contracts();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_EXPRESSION__ARGUMENTS = eINSTANCE.getArgumentExpression_Arguments();

    /**
     * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_EXPRESSION__NESTED = eINSTANCE.getArgumentExpression_Nested();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl <em>Verification Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.VerificationPlanImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getVerificationPlan()
     * @generated
     */
    EClass VERIFICATION_PLAN = eINSTANCE.getVerificationPlan();

    /**
     * The meta object literal for the '<em><b>Occurence Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__OCCURENCE_DEFINITION = eINSTANCE.getVerificationPlan_OccurenceDefinition();

    /**
     * The meta object literal for the '<em><b>Domains</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__DOMAINS = eINSTANCE.getVerificationPlan_Domains();

    /**
     * The meta object literal for the '<em><b>Claims</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__CLAIMS = eINSTANCE.getVerificationPlan_Claims();

    /**
     * The meta object literal for the '<em><b>Contracts</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__CONTRACTS = eINSTANCE.getVerificationPlan_Contracts();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.QueryImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getQuery()
     * @generated
     */
    EClass QUERY = eINSTANCE.getQuery();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY__VALUE = eINSTANCE.getQuery_Value();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.SingleValDeclarationImpl <em>Single Val Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.SingleValDeclarationImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSingleValDeclaration()
     * @generated
     */
    EClass SINGLE_VAL_DECLARATION = eINSTANCE.getSingleValDeclaration();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleNameImpl <em>Tuple Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.TupleNameImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleName()
     * @generated
     */
    EClass TUPLE_NAME = eINSTANCE.getTupleName();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.LambdaImpl <em>Lambda</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.LambdaImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getLambda()
     * @generated
     */
    EClass LAMBDA = eINSTANCE.getLambda();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAMBDA__PARAMETER = eINSTANCE.getLambda_Parameter();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAMBDA__QUERIES = eINSTANCE.getLambda_Queries();

    /**
     * The meta object literal for the '<em><b>Return Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAMBDA__RETURN_VALUE = eINSTANCE.getLambda_ReturnValue();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ParameterImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.SingleParameterImpl <em>Single Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.SingleParameterImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSingleParameter()
     * @generated
     */
    EClass SINGLE_PARAMETER = eINSTANCE.getSingleParameter();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringImpl <em>IString</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.IStringImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIString()
     * @generated
     */
    EClass ISTRING = eINSTANCE.getIString();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ISTRING__PARTS = eINSTANCE.getIString_Parts();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringPartImpl <em>IString Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.IStringPartImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringPart()
     * @generated
     */
    EClass ISTRING_PART = eINSTANCE.getIStringPart();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringLiteralImpl <em>IString Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.IStringLiteralImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringLiteral()
     * @generated
     */
    EClass ISTRING_LITERAL = eINSTANCE.getIStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ISTRING_LITERAL__VALUE = eINSTANCE.getIStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.IStringVarImpl <em>IString Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.IStringVarImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getIStringVar()
     * @generated
     */
    EClass ISTRING_VAR = eINSTANCE.getIStringVar();

    /**
     * The meta object literal for the '<em><b>Direct</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ISTRING_VAR__DIRECT = eINSTANCE.getIStringVar_Direct();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ISTRING_VAR__DOMAIN = eINSTANCE.getIStringVar_Domain();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ISTRING_VAR__QUERY = eINSTANCE.getIStringVar_Query();

    /**
     * The meta object literal for the '<em><b>Predefined</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ISTRING_VAR__PREDEFINED = eINSTANCE.getIStringVar_Predefined();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ContractAssumptionImpl <em>Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ContractAssumptionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getContractAssumption()
     * @generated
     */
    EClass CONTRACT_ASSUMPTION = eINSTANCE.getContractAssumption();

    /**
     * The meta object literal for the '<em><b>Contract</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACT_ASSUMPTION__CONTRACT = eINSTANCE.getContractAssumption_Contract();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentAssumptionImpl <em>Argument Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentAssumptionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentAssumption()
     * @generated
     */
    EClass ARGUMENT_ASSUMPTION = eINSTANCE.getArgumentAssumption();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_ASSUMPTION__ARGUMENT = eINSTANCE.getArgumentAssumption_Argument();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl <em>Code Assumption</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.CodeAssumptionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getCodeAssumption()
     * @generated
     */
    EClass CODE_ASSUMPTION = eINSTANCE.getCodeAssumption();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODE_ASSUMPTION__CODE = eINSTANCE.getCodeAssumption_Code();

    /**
     * The meta object literal for the '<em><b>Exact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODE_ASSUMPTION__EXACT = eINSTANCE.getCodeAssumption_Exact();

    /**
     * The meta object literal for the '<em><b>Guarantee</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODE_ASSUMPTION__GUARANTEE = eINSTANCE.getCodeAssumption_Guarantee();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentAndImpl <em>Argument And</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentAndImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentAnd()
     * @generated
     */
    EClass ARGUMENT_AND = eINSTANCE.getArgumentAnd();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentOrImpl <em>Argument Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentOrImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentOr()
     * @generated
     */
    EClass ARGUMENT_OR = eINSTANCE.getArgumentOr();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.ArgumentNotImpl <em>Argument Not</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.ArgumentNotImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getArgumentNot()
     * @generated
     */
    EClass ARGUMENT_NOT = eINSTANCE.getArgumentNot();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleDeclarationImpl <em>Tuple Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.TupleDeclarationImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleDeclaration()
     * @generated
     */
    EClass TUPLE_DECLARATION = eINSTANCE.getTupleDeclaration();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_DECLARATION__NAMES = eINSTANCE.getTupleDeclaration_Names();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.OrExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.AndExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.NotExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__OPERAND = eINSTANCE.getNotExpression_Operand();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.MemberCallImpl <em>Member Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.MemberCallImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getMemberCall()
     * @generated
     */
    EClass MEMBER_CALL = eINSTANCE.getMemberCall();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER_CALL__LEFT = eINSTANCE.getMemberCall_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMBER_CALL__RIGHT = eINSTANCE.getMemberCall_Right();

    /**
     * The meta object literal for the '<em><b>Type Argument</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEMBER_CALL__TYPE_ARGUMENT = eINSTANCE.getMemberCall_TypeArgument();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER_CALL__ARGUMENT = eINSTANCE.getMemberCall_Argument();

    /**
     * The meta object literal for the '<em><b>Lambda</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEMBER_CALL__LAMBDA = eINSTANCE.getMemberCall_Lambda();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl <em>Property Lookup</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.PropertyLookupImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getPropertyLookup()
     * @generated
     */
    EClass PROPERTY_LOOKUP = eINSTANCE.getPropertyLookup();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_LOOKUP__LEFT = eINSTANCE.getPropertyLookup_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_LOOKUP__RIGHT = eINSTANCE.getPropertyLookup_Right();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleParameterImpl <em>Tuple Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.TupleParameterImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleParameter()
     * @generated
     */
    EClass TUPLE_PARAMETER = eINSTANCE.getTupleParameter();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_PARAMETER__NAMES = eINSTANCE.getTupleParameter_Names();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.SelfExpressionImpl <em>Self Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.SelfExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getSelfExpression()
     * @generated
     */
    EClass SELF_EXPRESSION = eINSTANCE.getSelfExpression();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.StringLiteralImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.NameReferenceImpl <em>Name Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.NameReferenceImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getNameReference()
     * @generated
     */
    EClass NAME_REFERENCE = eINSTANCE.getNameReference();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_REFERENCE__REFERENCE = eINSTANCE.getNameReference_Reference();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.UsageExpressionImpl <em>Usage Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.UsageExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getUsageExpression()
     * @generated
     */
    EClass USAGE_EXPRESSION = eINSTANCE.getUsageExpression();

    /**
     * The meta object literal for the '<em><b>Usage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USAGE_EXPRESSION__USAGE = eINSTANCE.getUsageExpression_Usage();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.impl.TupleExpressionImpl <em>Tuple Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.impl.TupleExpressionImpl
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getTupleExpression()
     * @generated
     */
    EClass TUPLE_EXPRESSION = eINSTANCE.getTupleExpression();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_EXPRESSION__ELEMENTS = eINSTANCE.getTupleExpression_Elements();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.Language <em>Language</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.Language
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getLanguage()
     * @generated
     */
    EEnum LANGUAGE = eINSTANCE.getLanguage();

    /**
     * The meta object literal for the '{@link org.osate.sysmlv2.contract.contract.Predefined <em>Predefined</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.sysmlv2.contract.contract.Predefined
     * @see org.osate.sysmlv2.contract.contract.impl.ContractPackageImpl#getPredefined()
     * @generated
     */
    EEnum PREDEFINED = eINSTANCE.getPredefined();

  }

} //ContractPackage
