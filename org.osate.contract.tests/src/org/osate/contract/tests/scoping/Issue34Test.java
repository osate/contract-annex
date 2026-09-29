/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023, 2026 Carnegie Mellon University.
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
package org.osate.contract.tests.scoping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.contract.contract.ContractPackage;
import org.osate.contract.contract.ContractSubclause;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.tests.ContractInjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

@ExtendWith(InjectionExtension.class)
@InjectWith(ContractInjectorProvider.class)
public class Issue34Test {
	private static final String PATH = "org.osate.contract.tests/models/issue34/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IResourceScopeCache cache;

	@Test
	public void sameFileComponentImplementation() {
		assertReferences(testHelper.parseFile(PATH + "Issue34.aadl"));
	}

	@Test
	public void emv2BeforeContract() {
		assertReferences(testHelper.parseFile(PATH + "Emv2BeforeContract.aadl"));
	}

	@Test
	public void emv2AfterContract() {
		assertReferences(testHelper.parseFile(PATH + "Emv2AfterContract.aadl"));
	}

	@Test
	public void contractScopeFirst() {
		var pkg = testHelper.parseFile(PATH + "Emv2BeforeContract.aadl");
		cache.clear(pkg.eResource());
		var plan = EcoreUtil2.getAllContentsOfType(pkg, VerificationPlan.class).get(0);
		getLocalScopeProvider("contract").getScope(plan,
				ContractPackage.eINSTANCE.getVerificationPlan_ComponentImplementation());
		assertReferences(pkg);
	}

	@Test
	public void aadlScopeFirst() {
		var pkg = testHelper.parseFile(PATH + "Emv2BeforeContract.aadl");
		cache.clear(pkg.eResource());
		var implementation = EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class).get(0);
		getLocalScopeProvider("aadl").getScope(implementation,
				Aadl2Package.eINSTANCE.getComponentImplementation_Type());
		assertReferences(pkg);
	}

	@Test
	public void emv2ScopeFirst() {
		var pkg = testHelper.parseFile(PATH + "Emv2BeforeContract.aadl");
		cache.clear(pkg.eResource());
		var token = EcoreUtil2.getAllContentsOfType(pkg, TypeToken.class).get(0);
		getLocalScopeProvider("emv2").getScope(token, ErrorModelPackage.eINSTANCE.getTypeToken_Type());
		assertReferences(pkg);
	}

	private void assertReferences(AadlPackage pkg) {
		validationHelper.assertNoIssues(pkg);
		var plan = EcoreUtil2.getAllContentsOfType(pkg, VerificationPlan.class).get(0);
		var implementation = EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class).get(0);
		var subclause = EcoreUtil2.getAllContentsOfType(implementation, ContractSubclause.class).get(0);
		assertSame(implementation, plan.getComponentImplementation());
		assertSame(plan, subclause.getVerifyPlans().get(0));

		var contractScopeProvider = getInjector("contract").getInstance(IScopeProvider.class);
		var scope = contractScopeProvider.getScope(subclause,
				ContractPackage.eINSTANCE.getContractSubclause_VerifyPlans());
		var matches = scope.getElements(QualifiedName.create(pkg.getName(), plan.getName()));
		assertEquals(1, Iterables.size(matches));
		assertSame(plan, matches.iterator().next().getEObjectOrProxy());

		var tokens = EcoreUtil2.getAllContentsOfType(pkg, TypeToken.class);
		if (!tokens.isEmpty()) {
			var errorType = EcoreUtil2.getAllContentsOfType(pkg, ErrorType.class).get(0);
			assertSame(errorType, tokens.get(0).getType().get(0));
		}
	}

	private IScopeProvider getLocalScopeProvider(String extension) {
		return getInjector(extension).getInstance(Key.get(IScopeProvider.class,
				Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)));
	}

	private Injector getInjector(String extension) {
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createURI("dummy." + extension))
				.get(Injector.class);
	}
}
