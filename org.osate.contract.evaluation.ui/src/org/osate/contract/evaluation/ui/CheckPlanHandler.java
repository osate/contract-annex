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
package org.osate.contract.evaluation.ui;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.execution.ContractProcessor;

public class CheckPlanHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		ComponentInstance component;
		IProject project;

		if (selection instanceof IFile file) {
			project = file.getProject();
			var resource = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI(file), true);
			component = (SystemInstance) resource.getContents().get(0);
		} else if (selection instanceof EObjectURIWrapper wrapper) {
			project = OsateResourceUtil.toIFile(wrapper.getUri()).getProject();
			component = (ComponentInstance) new ResourceSetImpl().getEObject(wrapper.getUri(), true);
		} else if (selection instanceof SystemInstance si) {
			project = OsateResourceUtil.toIFile(si.eResource().getURI()).getProject();
			component = si;
		} else {
			throw new ExecutionException("Unexpected selection: " + selection);
		}

		System.out.println("PROJECT = " + project.getFullPath());
		final Iterable<VerificationPlan> plans = findAllVerificationPlans(project);
		for (final VerificationPlan vp : plans) {
			System.out.println("  found vp " + vp.getFullName());
		}

		var scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
		var processor = new ContractProcessor(component, plans,
				scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine"));
		WorkspaceJob job = new WorkspaceJob("Check verification plan") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
				Display.getDefault().syncExec(() -> linkConsole(event));
				processor.processVerificationPlans(true);
				unlinkConsole();
				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();
		return null;
	}

	/* XXX: Should do this using the global scope provider, but I'm not sure how to do it. */
	private static Iterable<VerificationPlan> findAllVerificationPlans(final IProject project) {
		final List<VerificationPlan> vps = new ArrayList<>();
		try {
			findAllVerificationPlans(project.members(), vps);
		} catch (final CoreException e) {
			// Eat it
		}
		return Collections.unmodifiableList(vps);
	}

	private static void findAllVerificationPlans(final IResource[] rsrcs, final Collection<VerificationPlan> vps)
			throws CoreException {
		for (final IResource rsrc : rsrcs) {
			if (rsrc instanceof IContainer container) {
				findAllVerificationPlans(container.members(), vps);
			} else {
				final String ext = rsrc.getFileExtension();
				if (ext != null && ext.equals("contract")) {
					final URI resourceURI = OsateResourceUtil.toResourceURI(rsrc);
					final Resource res = new ResourceSetImpl().getResource(resourceURI, true);

					for (final EObject root : res.getContents()) {
						vps.addAll(EcoreUtil2.getAllContentsOfType(root, VerificationPlan.class));
					}
				}
			}
		}
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