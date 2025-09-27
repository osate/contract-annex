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
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.contract.contract.IString;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Predefined;
import org.osate.contract.contract.Query;
import org.osate.contract.contract.SingleSysMLDeclaration;
import org.osate.contract.contract.SingleValDeclaration;
import org.osate.contract.contract.impl.SingleSysMLDeclarationImpl;
import org.osate.contract.tuples.Tuple;
import org.osate.contract.typing.ContractInterpreter;
import org.osate.contract.uml.SysMLQueryInterpreter;

public class PythonHelper {

	private static final PythonHelper INSTANCE = new PythonHelper();

	private ContractInterpreter queryInterpreter = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.contract"))
			.get(ContractInterpreter.class);

	private InstanceObjectIDMapper ioid = null;

	SysMLQueryInterpreter sysmlInterpreter = new SysMLQueryInterpreter();

	public static PythonHelper get() {
		return INSTANCE;
	}

	public SysMLQueryInterpreter getSysMLQueryInterpreter() {
		return sysmlInterpreter;
	}

	public InstanceObjectIDMapper getInstanceObjectMapper() {
		return ioid;
	}

	public PythonHelper() {
	}

	public String interpolateIString(ComponentInstance context, IString is, Map<String, Object> variables) {
		var env = new RuleEnvironment(new RuleEnvironmentEntry("self", context));
		var sb = new StringBuilder();

		var root = (SystemInstance) context.eResource().getContents().get(0);
		ioid = InstanceObjectIDMapper.getMapper(root);

		// TODO:Dio:sysmlv1:execute the sysval replacement here
		for (var part : is.getParts()) {
			if (part instanceof IStringLiteral literal) {
				sb.append(literal.getValue());
			} else if (part instanceof IStringVar svar) {
				if (svar.getQuery() == null) {
					if (svar.getPredefined() == Predefined.ERROR) {
						sb.append("error0");
					} else if (svar.getPredefined() == Predefined.INFO) {
						sb.append("info0");
					}
				} else {
					var q = svar.getQuery();

					if (q instanceof SingleSysMLDeclarationImpl decl) {
						String objvalue = (String) sysmlInterpreter.getQueryVariableValue(decl.getName());
						String value = "";
						if (objvalue == null) {
							value = sysmlInterpreter.parseAndExecuteQuery(decl.getName(), decl.getValue());
						}
						if (objvalue instanceof String) {
							value = objvalue;
						}
						decl.setValue(value);
						sb.append(decl.getValue());
					} else {
						var result = queryInterpreter.evaluateQuery(env, (Query) q);
						if (result.failed()) {
							System.out.println(result.getRuleFailedException());
						} else {
							var name1 = switch (q) {
							case SingleValDeclaration decl -> decl.getName();
							case SingleSysMLDeclaration decl -> decl.getName();
							default -> "";
							};

							Object o = result.getValue().get(name1);
							if (svar.isDirect()) {
								if (variables.containsKey(name1)) {
									if (variables.get(name1) != o) {
										throw new IllegalArgumentException("Inconsistent value for query " + name1);
									}
								} else {
									variables.put(name1, o);
								}
								sb.append(name1);
							} else {
								var value = toPythonString(o);
								sb.append(value);
							}
						}
					}
				}
			}
		}
		return sb.toString();
	}

	String toPythonString(Object o) {
		var result = "";
		o = extractOptional(o);

		if (o == null) {
			result = "None";
		} else if (o instanceof Boolean b) {
			result = b ? "True" : "False";
		} else if (o instanceof String s) {
			result = "'" + s + "'";
		} else if (o instanceof Integer i) {
			result = i.toString();
		} else if (o instanceof Long l) {
			result = l.toString();
		} else if (o instanceof Double d) {
			result = d.toString();
		} else if (o instanceof EnumerationLiteral e) {
			result = "'" + e.getName() + "'";
		} else if (o instanceof InstanceObject io) {
			result = ioid.getID(io).toString();
		} else if (o instanceof List<?> list) {
			result = list.stream()//
					.map(this::toPythonString)
					.collect(Collectors.joining(", ", "[", "]"));
		} else if (o instanceof Tuple tuple) {
			result = tuple.getElements()
					.stream()//
					.map(this::toPythonString)
					.collect(Collectors.joining(", ", "(", ")"));
		}

		return result;
	}

	private Object extractOptional(Object o) {
		if (o instanceof Optional<?> opt) {
			return opt.orElse(null);
		}
		return o;
	}
}
