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
package org.osate.contract.execution;

import java.util.List;
import java.util.Map;

import org.eclipse.ease.ScriptResult;
import org.eclipse.ease.service.EngineDescription;

public class ScriptRunner {

	private EngineDescription engineDescription;

	private List<String> error;
	private List<String> info;

	public ScriptRunner(EngineDescription description, List<String> error, List<String> info) {
		engineDescription = description;
		this.error = error;
		this.info = info;
	}

	public Boolean run(String pyCode, Map<String, Object> variables) {
		if (engineDescription != null) {
			var engine = engineDescription.createEngine();

			variables.put("error0", error);
			variables.put("info0", info);

			if (variables.isEmpty()) {
				System.out.println("No global variables");
			} else {
				System.out.println("Global variables:");
			}
			for (var entry : variables.entrySet()) {
				engine.setVariable(entry.getKey(), entry.getValue());
				System.out.println("  " + entry.getKey());
			}

			ScriptResult sresult = engine.execute(pyCode);
			engine.schedule();
			String o = sresult.toString().trim();
			var res = o.toLowerCase().startsWith("true");

			if (!res) {
				System.out.println("Error Explanations: " + error);
				ExperimentalErrorParser errorParser = ExperimentalErrorParser.getParser();
				errorParser.markErrors(error.get(0));
			} else {
				ExperimentalErrorParser errorParser = ExperimentalErrorParser.getParser();
				errorParser.markInfo(info.get(0));
			}

			System.out.println("Result is " + res);
			System.out.println("msg: " + error.get(0));
			return res;
		}
		return null;
	}

	public String eval(String pyCode, Map<String, Object> variables) {
		if (engineDescription != null) {
			var engine = engineDescription.createEngine();

			for (var entry : variables.entrySet()) {
				engine.setVariable(entry.getKey(), entry.getValue());
			}
			ScriptResult sresult = engine.execute(pyCode);
			engine.schedule();
			return sresult.toString();
		}
		return null;
	}

}
