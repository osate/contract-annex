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
package org.osate.fia.analysis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.fia.contrib.FaultImpactanalysisProperties;
import org.osate.slicer.SlicerRepresentation;
import org.osate.slicer.SlicerRepresentation.ErrorStateValidity;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;


public class FaultImpactHandler2 extends AaxlReadOnlyHandlerAsJob {

	public boolean runAnalysis(Element root) {
		boolean result = true;
		SystemInstance si;
		if (root instanceof InstanceObject) {
			si = ((InstanceObject) root).getSystemInstance();
		} else {
			System.err.println("A SystemInstance was not received");
			return false;
		}

		SlicerRepresentation slicer = new SlicerRepresentation();
		slicer.buildGraph(si);
		Property sinkAcceptability;

		for (ErrorSinkInstance esi : slicer.getErrorSinks(ErrorStateValidity.INVALID)) {
			sinkAcceptability = FaultImpactanalysisProperties.getAcceptable_Property(esi);
			if (!PropertyUtils.getBooleanValue(esi, sinkAcceptability)) {
				System.err.println("An unacceptable error state is reachable!");
				result = false;
			}
		}
		return result;
	}

	@Override
	protected String getActionName() {
		// TODO Auto-generated method stub
		return "Fault Impact Analysis";
	}

	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		// TODO Auto-generated method stub
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		runAnalysis(root);
		monitor.done();
	}
}
