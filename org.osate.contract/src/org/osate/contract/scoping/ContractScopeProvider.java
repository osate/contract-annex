/*******************************************************************************
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
 *******************************************************************************/
/*
 * generated by Xtext 2.27.0
 */
package org.osate.contract.scoping;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.osate.aadl2.NamedElement;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Lambda;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.contract.NameReference;
import org.osate.contract.contract.SingleParameter;
import org.osate.contract.contract.SingleValDeclaration;
import org.osate.contract.contract.TupleDeclaration;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.naming.ContractQualifiedNameProvider;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.contract.typing.LongWithUnitsType;
import org.osate.contract.typing.OptionalType;
import org.osate.contract.typing.RecordType;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class ContractScopeProvider extends AbstractContractScopeProvider {
	@Inject
	IQualifiedNameConverter converter;

	@Inject
	private ContractTypeSystem typeSystem;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference.equals(ContractPackage.eINSTANCE.getContractSubclause_UseQueries())
				|| reference.equals(ContractPackage.eINSTANCE.getContractSubclause_VerifyPlans())) {
			return scopeForContractSubclauseUseQueries(context, reference);
		} else if (reference.equals(ContractPackage.eINSTANCE.getNameReference_Reference())) {
			return scopeForNameReferenceReference(context);
		} else if (reference.equals(ContractPackage.eINSTANCE.getIStringVar_Query())) {
			return scopeForQueryReference(context);
		} else if (reference.equals(ContractPackage.eINSTANCE.getArgument_Domains())
				|| reference.equals(ContractPackage.eINSTANCE.getArgumentAssumption_Argument())
				|| reference.equals(ContractPackage.eINSTANCE.getContractAssumption_Contract())
				|| reference.equals(ContractPackage.eINSTANCE.getArgumentAssumption_Argument())
				|| reference.equals(ContractPackage.eINSTANCE.getContract_Domains())
				|| reference.equals(ContractPackage.eINSTANCE.getArgumentExpression_Contracts())
				|| reference.equals(ContractPackage.eINSTANCE.getArgumentExpression_Arguments())
				|| reference.equals(ContractPackage.eINSTANCE.getVerificationPlan_Contracts())
				|| reference.equals(ContractPackage.eINSTANCE.getVerificationPlan_Domains())
				|| reference.equals(ContractPackage.eINSTANCE.getIStringVar_Domain())) {
			return annexLibraryScope(context, reference);
		} else {
			return super.getScope(context, reference);
		}
	}

	private IScope scopeForContractSubclauseUseQueries(EObject context, EReference reference) {
		var descriptions = new ArrayList<IEObjectDescription>();
		for (var element : super.getScope(context, reference).getAllElements()) {
			var name = element.getName().toString("::");
			if (name.startsWith(ContractQualifiedNameProvider.PREFIX)) {
				var strippedName = name.substring(ContractQualifiedNameProvider.PREFIX.length());
				var qname = converter.toQualifiedName(strippedName);
				descriptions.add(EObjectDescription.create(qname, element.getEObjectOrProxy()));
			} else {
				descriptions.add(element);
			}
		}
		return new SimpleScope(descriptions);
	}

	private IScope scopeForNameReferenceReference(EObject context) {
		/*
		 * Special handling for LongWithUnits.scaledTo() and Record.get(). Scoping looks up the names of the argument
		 * based on the type of the left side of the MemberCall expression.
		 */
		if (context instanceof NameReference nameReference
				&& nameReference.eContainer() instanceof MemberCall memberCall
				&& memberCall.getArgument() == nameReference) {
			var receiverType = switch (memberCall.getOperator()) {
			case NORMAL -> typeSystem.expressionType(memberCall.getLeft()).getValue();
			case OPTIONAL ->
				typeSystem.expressionType(memberCall.getLeft()).getValue() instanceof OptionalType optionalType
						? optionalType.getElementType()
						: null;
			};
			switch (memberCall.getRight()) {
			case "scaledTo":
				if (receiverType instanceof LongWithUnitsType longType) {
					var descriptions = new ArrayList<IEObjectDescription>();
					for (var literal : longType.getUnitsType().getOwnedLiterals()) {
						descriptions.add(EObjectDescription.create(literal.getName(), literal));
					}
					return new SimpleScope(descriptions, true);
				}
			case "get":
				if (receiverType instanceof RecordType recordType) {
					var descriptions = new ArrayList<IEObjectDescription>();
					for (var field : recordType.getRecordType().getOwnedFields()) {
						descriptions.add(EObjectDescription.create(field.getName(), field));
					}
					return new SimpleScope(descriptions, true);
				}
			}
		}
		var names = new ArrayList<NamedElement>();
		for (var current = context.eContainer(); current != null; current = current.eContainer()) {
			if (current instanceof Lambda lambda) {
				if (lambda.getParameter() instanceof SingleParameter singleParameter) {
					names.add(singleParameter);
				} else if (lambda.getParameter() instanceof TupleParameter tupleParameter) {
					names.addAll(tupleParameter.getNames());
				}
				for (var query : lambda.getQueries()) {
					if (EcoreUtil.isAncestor(query, context)) {
						break;
					}
					if (query instanceof SingleValDeclaration singleValDeclaration) {
						names.add(singleValDeclaration);
					} else if (query instanceof TupleDeclaration tupleDeclaration) {
						names.addAll(tupleDeclaration.getNames());
					}
				}
			} else if (current instanceof Contract contract) {
				for (var query : contract.getQueries()) {
					if (EcoreUtil.isAncestor(query, context)) {
						break;
					}
					if (query instanceof SingleValDeclaration singleValDeclaration) {
						names.add(singleValDeclaration);
					} else if (query instanceof TupleDeclaration tupleDeclaration) {
						names.addAll(tupleDeclaration.getNames());
					}
				}
				for (var domain : contract.getDomains()) {
					for (var query : domain.getQueries()) {
						if (query instanceof SingleValDeclaration singleValDeclaration) {
							names.add(singleValDeclaration);
						} else if (query instanceof TupleDeclaration tupleDeclaration) {
							names.addAll(tupleDeclaration.getNames());
						}
					}
				}
			} else if (current instanceof VerificationPlan plan) {
				for (var domain : plan.getDomains()) {
					for (var query : domain.getQueries()) {
						if (query instanceof SingleValDeclaration singleValDeclaration) {
							names.add(singleValDeclaration);
						} else if (query instanceof TupleDeclaration tupleDeclaration) {
							names.addAll(tupleDeclaration.getNames());
						}
					}
				}
			} else if (current instanceof Domain domain) {
				for (var query : domain.getQueries()) {
					if (EcoreUtil.isAncestor(query, context)) {
						break;
					}
					if (query instanceof SingleValDeclaration singleValDeclaration) {
						names.add(singleValDeclaration);
					} else if (query instanceof TupleDeclaration tupleDeclaration) {
						names.addAll(tupleDeclaration.getNames());
					}
				}
			}
		}
		return Scopes.scopeFor(names);
	}

	private IScope scopeForQueryReference(EObject context) {
		if (context instanceof IStringVar isv) {
			if (isv.getDomain() == null) {
				return scopeForNameReferenceReference(context);
			}
			return new FilteringScope(Scopes.scopeFor(isv.getDomain().getQueries()),
					(d) -> d.getEObjectOrProxy() instanceof SingleValDeclaration);
		}
		return IScope.NULLSCOPE;
	}

	private IScope annexLibraryScope(EObject context, EReference reference) {
		var library = EcoreUtil2.getContainerOfType(context, ContractLibrary.class);
		return Scopes.scopeFor(library.eContents(), strippedScope(context, reference));
	}

	private IScope strippedScope(EObject context, EReference reference) {
		return strippedScope(super.getScope(context, reference), ContractQualifiedNameProvider.PREFIX);
	}

	private IScope strippedScope(IScope delegate, String prefix) {
		return new IScope() {
			Function<IEObjectDescription, IEObjectDescription> filter = (desc) -> {
				var name = converter.toString(desc.getName());
				if (name.startsWith(prefix)) {
					var strippedName = name.substring(ContractQualifiedNameProvider.PREFIX.length());
					return EObjectDescription.create(strippedName, desc.getEObjectOrProxy());
				} else {
					return desc;
				}
			};

			@Override
			public Iterable<IEObjectDescription> getAllElements() {
				return Iterables.transform(delegate.getAllElements(), filter);
			}

			@Override
			public Iterable<IEObjectDescription> getElements(EObject object) {
				return Iterables.transform(delegate.getElements(object), filter);
			}

			@Override
			public Iterable<IEObjectDescription> getElements(QualifiedName name) {
				return Iterables.transform(delegate.getElements(addPrefix(name)), filter);
			}

			@Override
			public IEObjectDescription getSingleElement(EObject object) {
				Iterable<IEObjectDescription> elements = getElements(object);
				return getFirst(elements);
			}

			@Override
			public IEObjectDescription getSingleElement(QualifiedName name) {
				Iterable<IEObjectDescription> elements = getElements(addPrefix(name));
				return getFirst(elements);
			}

			protected IEObjectDescription getFirst(Iterable<IEObjectDescription> elements) {
				Iterator<IEObjectDescription> iterator = elements.iterator();
				if (iterator.hasNext()) {
					return iterator.next();
				}
				return null;
			}

			private QualifiedName addPrefix(QualifiedName name) {
				var s = converter.toString(name);
				return s.startsWith(prefix) ? name : converter.toQualifiedName(prefix + s);
			}
		};
	}
}