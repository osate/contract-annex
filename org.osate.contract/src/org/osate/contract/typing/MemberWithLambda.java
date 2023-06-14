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
package org.osate.contract.typing;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class MemberWithLambda implements Member {
	private final Type lambdaParameterType;
	private final Function<Type, Optional<String>> validateLambdaReturnTypeFunction;
	private final Function<Type, Type> returnTypeFunction;
	private BiFunction<Object, Function<Object, Object>, Object> evaluateFunction;

	public MemberWithLambda(Type lambdaParameterType, Function<Type, Optional<String>> validateLambdaReturnTypeFunction,
			Function<Type, Type> returnTypeFunction,
			BiFunction<Object, Function<Object, Object>, Object> evaluateFunction) {
		this.lambdaParameterType = lambdaParameterType;
		this.validateLambdaReturnTypeFunction = validateLambdaReturnTypeFunction;
		this.returnTypeFunction = returnTypeFunction;
		this.evaluateFunction = evaluateFunction;
	}

	public Type getLambdaParameterType() {
		return lambdaParameterType;
	}

	public Optional<String> validateLambdaReturnType(Type lambdaReturnType) {
		return validateLambdaReturnTypeFunction.apply(lambdaReturnType);
	}

	public Type getReturnType(Type lambdaType) {
		return returnTypeFunction.apply(lambdaType);
	}

	public Object evaluate(Object receiver, Function<Object, Object> evaluateLambda) {
		return evaluateFunction.apply(receiver, evaluateLambda);
	}
}