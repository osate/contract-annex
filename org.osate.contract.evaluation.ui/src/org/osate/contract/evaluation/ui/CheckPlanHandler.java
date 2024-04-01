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
import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ease.service.IScriptService;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.contract.execution.ContractProcessor;

public class CheckPlanHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		ComponentInstance component;
		if (selection instanceof IFile file) {
			var resource = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI(file), true);
			component = (SystemInstance) resource.getContents().get(0);
		} else if (selection instanceof EObjectURIWrapper wrapper) {
			component = (ComponentInstance) new ResourceSetImpl().getEObject(wrapper.getUri(), true);
		} else {
			throw new ExecutionException("Unexpected selection: " + selection);
		}
		var scriptService = PlatformUI.getWorkbench().getService(IScriptService.class);
		var processor = new ContractProcessor(component,
				scriptService.getEngineByID("org.eclipse.ease.lang.python.py4j.engine"));
//		processor.processContract(component);
		linkConsole(event);
		processor.processVerificationPlan(component, true);
		unlinkConsole();
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
		out = new PrintStream(console.newMessageStream());
		System.setOut(out);
		System.setErr(out);
	}

	private static void unlinkConsole() {
		System.setOut(System.out);
		System.setErr(System.err);
		out.close();
	}
}