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
package org.osate.sysmlv2.contract.evaluation.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.sysmlv2.contract.contract.VerificationPlan;
import org.osate.sysmlv2.contract.typing.ContractInterpreter;

public class EvaluationHandler extends AbstractHandler {
	private final ContractInterpreter interpreter = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.contract"))
			.get(ContractInterpreter.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var selection = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		final URI eObjectURI = selection.getEObjectURI();
		VerificationPlan vp = (VerificationPlan) new ResourceSetImpl().getEObject(eObjectURI, true);
		
		System.out.println(vp);

		executeQueries(vp);
//		component.eAllContents().forEachRemaining(element -> {
//			if (element instanceof ComponentInstance subcomponent) {
//				executeQueries(subcomponent);
//			}
//		});

		return null;
	}

	private void executeQueries(final VerificationPlan vp) {
		var environment = new RuleEnvironment(new RuleEnvironmentEntry("self", vp.getOccurrenceDefinition()));
		for (var contract : vp.getContracts()) {
			for (var query : contract.getQueries()) {
				var result = interpreter.evaluateQuery(environment, query);
				if (result.failed()) {
					System.out.println(result.getRuleFailedException());
				} else {
					result.getValue().forEach((name, value) -> System.out.println(name + ": " + value));
				}
			}
		}
	}
}