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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.contract.contract.ContractLibrary;
import org.osate.contract.contract.Domain;
import org.osate.contract.contract.Implementation;
import org.osate.contract.contract.Language;
import org.osate.contract.contract.Source;

public class PythonBuilder {

	protected boolean z3Import = false;

	protected Set<ContractLibrary> addedLibraries = new HashSet<>();

	protected Set<Domain> addedDomains = new HashSet<>();

	protected StringBuilder implementations = new StringBuilder();

	protected StringBuilder domains = new StringBuilder();

	protected StringBuilder script = new StringBuilder();

	protected Map<String, Object> variables = new HashMap<>();

	ComponentInstance context;

	PythonHelper python;

	JavaHelper java;

	int indent = 0;

	PythonBuilder(ComponentInstance context) {
		this.context = context;
		python = PythonHelper.get();
		java = JavaHelper.get();
	}

	PythonBuilder addZ3Import() {
		z3Import = true;
		return this;
	}

	PythonBuilder addDomain(Domain domain) {
		if (addedDomains.add(domain)) {
			// XXX: ugly hack
			var i = indent;
			indent = 0;
			addCode(domains, domain.getCode());
			indent = i;
		}
		return this;
	}

	PythonBuilder addImplementations(ContractLibrary library) {
		if (addedLibraries.add(library)) {
			String pyCode = library.getContractElements()
					.stream()
					.filter(Implementation.class::isInstance)
					.map(Implementation.class::cast)
					.map(Implementation::getCode)
					.filter(c -> c.getLanguage() == Language.PYTHON)
					.map(Source::getSource) // no interpolation
					.map(String::stripIndent)
					.collect(Collectors.joining("\n", "", "\n"));
			implementations.append(pyCode);
		}
		return this;
	}

	public void addCode(Source code) {
		addCode(code, "");
	}

	public void addCode(Source code, String term) {
		addCode(script, code, term);
	}

	private void addCode(StringBuilder section, Source code) {
		addCode(section, code, "");
	}

	private void addCode(StringBuilder section, Source code, String term) {
		var txt = "";

		if (code.getLanguage() == Language.JAVA) {
			if (code.getInter() != null) {
				txt = java.callJava(context, code.getInter()) ? "True" : "False";
				txt += term;
			}
		} else {
			if (!Strings.isEmpty(code.getSource())) {
				txt = code.getSource() + term;
			} else if (code.getInter() != null) {
				txt = python.interpolateIString(context, code.getInter(), variables) + term;
			}
		}
		if (!Strings.isEmpty(txt)) {
			section.append(txt.stripIndent().indent(indent));
		}
	}

	PythonBuilder addCode(String str) {
		script.append(str.indent(indent));
		return this;
	}

	PythonBuilder indent() {
		return indent(1);
	}

	PythonBuilder indent(int i) {
		indent += 4 * i;
		return this;
	}

	PythonBuilder outdent() {
		return outdent(1);
	}

	PythonBuilder outdent(int i) {
		indent = Math.max(0, indent - 4 * i);
		return this;
	}

	String getScript() {
		StringBuilder result = new StringBuilder();
		if (z3Import) {
			result.append("from z3 import *\n");
		}
		result.append(implementations.toString());
		result.append(domains.toString());
		result.append(script.toString());
		return result.toString();
	}

	Map<String, Object> getVariables() {
		return variables;
	}

}
