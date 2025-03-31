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

import java.io.PrintStream;
import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.sysmlv2.contract.contract.VerificationPlan;
import org.osate.sysmlv2.contract.execution.ContractProcessor;

abstract class AbstractPlanHandler extends AbstractHandler {
	protected abstract boolean checkCompleteness();
	
	@Override
	public final Object execute(ExecutionEvent event) throws ExecutionException {
		var selection = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		final URI eObjectURI = selection.getEObjectURI();
		final VerificationPlan vp =	(VerificationPlan) new ResourceSetImpl().getEObject(eObjectURI, true);

		final var scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
		final var processor = new ContractProcessor(vp,
				scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine"));
		WorkspaceJob job = new WorkspaceJob("Execute verification plan") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				Display.getDefault().syncExec(() -> linkConsole(event));
				processor.processVerificationPlans(checkCompleteness());
				unlinkConsole();
				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();
		return null;
	}

	private static final String CONTRACT_CONSOLE = "Contract Console";

	private static PrintStream out;

	private static void linkConsole(ExecutionEvent event) {
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(IConsoleConstants.ID_CONSOLE_VIEW);
		} catch (PartInitException e) {
			ConsolePlugin.log(e);
		}
		var consoleMgr = ConsolePlugin.getDefault().getConsoleManager();
		var console = Arrays.stream(consoleMgr.getConsoles())
				.filter(con -> con.getName().equals(CONTRACT_CONSOLE) && con instanceof MessageConsole)
				.map(MessageConsole.class::cast)
				.findFirst()
				.orElseGet(() -> {
					var con = new MessageConsole(CONTRACT_CONSOLE, null);
					consoleMgr.addConsoles(new IConsole[] { con });
					return con;
				});
		console.clearConsole();
		out = new PrintStream(console.newMessageStream(), true);
		System.setOut(out);
		System.setErr(out);
	}

	private static void unlinkConsole() {
		System.setOut(System.out);
		System.setErr(System.err);
		out.close();
	}
}