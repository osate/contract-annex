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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleEnvironmentEntry;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.contract.contract.IString;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.typing.ContractInterpreter;

public class JavaHelper {

	private static final JavaHelper INSTANCE = new JavaHelper();

	private ContractInterpreter queryInterpreter = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.contract"))
			.get(ContractInterpreter.class);

	public static JavaHelper get() {
		return INSTANCE;
	}

	private JavaHelper() {
	}

	public boolean callJava(ComponentInstance context, IString is) {
		var env = new RuleEnvironment(new RuleEnvironmentEntry("self", context));
		String name = "";
		List<Object> args = new ArrayList<>();
		boolean first = true;

		for (var part : is.getParts()) {
			if (first && part instanceof IStringLiteral literal) {
				var str = literal.getValue();
				name = str.substring(0, str.indexOf('(')).trim();
				first = false;
			} else if (part instanceof IStringVar varRef) {
				var q = varRef.getQuery();
				var result = queryInterpreter.evaluateQuery(env, q);
				if (result.failed()) {
					System.out.println(result.getRuleFailedException());
				} else {
					args.add(extractOptional(result.getValue().get(q.getName())));
				}
			}
		}
		return execute(name, args.toArray());
	}

	private Object extractOptional(Object o) {
		if (o instanceof Optional<?> opt) {
			return opt.orElse(null);
		}
		return o;
	}

	private boolean execute(String name, Object[] params) {
		boolean ret = false;
		String className = name.substring(0, name.lastIndexOf('.'));
		String methodName = name.substring(name.lastIndexOf('.') + 1);
		Object instance = null;
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
			instance = clazz.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		if (instance != null) {
			Method[] allMethods = clazz.getDeclaredMethods();
			for (Method m : allMethods) {
				String mname = m.getName();
				if (!mname.startsWith(methodName) || (m.getGenericReturnType() != boolean.class)) {
					continue;
				}
				Type[] pType = m.getGenericParameterTypes();

				if (pType.length != params.length) {
					continue;
				}

				try {
					Object retObj = m.invoke(instance, params);
					ret = ((Boolean) retObj);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return ret;
	}

}
