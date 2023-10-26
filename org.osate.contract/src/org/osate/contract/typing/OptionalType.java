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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

public final class OptionalType implements Type {
	private final Type elementType;
	private final Map<String, Member> members;

	public OptionalType(Type elementType) {
		this.elementType = elementType;

		members = new LinkedHashMap<>();
		members.put("isEmpty", new SimpleMember(BooleanType.INSTANCE, receiver -> isEmpty((Optional<?>) receiver)));
		members.put("filterType", new MemberWithTypeParameter(genericType -> new OptionalType(genericType),
				(receiver, genericType) -> filterType((Optional<?>) receiver, genericType)));
		members.put("map",
				new MemberWithLambda(elementType, lambdaReturnType -> Optional.empty(),
						lambdaType -> lambdaType != null ? new OptionalType(lambdaType) : null,
						(receiver, evaluateLambda) -> map((Optional<?>) receiver, evaluateLambda)));
		members.put("flatMap",
				new MemberWithLambda(elementType,
						lambdaReturnType -> lambdaReturnType instanceof OptionalType ? Optional.empty()
								: Optional.of("Optional"),
						lambdaType -> lambdaType instanceof OptionalType nestedLambdaType ? nestedLambdaType : null,
						(receiver, evaluateLambda) -> flatMap((Optional<?>) receiver, evaluateLambda)));
	}

	public Type getElementType() {
		return elementType;
	}

	@Override
	public Map<String, Member> getMembers() {
		return members;
	}

	@Override
	public String toString() {
		return elementType + "?";
	}

	private static Boolean isEmpty(Optional<?> receiver) {
		return receiver.isEmpty();
	}

	private static Optional<?> filterType(Optional<?> receiver, Type genericType) {
		Class<?> javaClass;
		if (genericType instanceof BooleanType) {
			javaClass = Boolean.class;
		} else if (genericType instanceof ClassifierType) {
			javaClass = Classifier.class;
		} else if (genericType instanceof ComponentInstanceType) {
			javaClass = ComponentInstance.class;
		} else if (genericType instanceof ConnectionInstanceType) {
			javaClass = ConnectionInstance.class;
		} else if (genericType instanceof DoubleType) {
			javaClass = Double.class;
		} else if (genericType instanceof EndToEndFlowInstanceType) {
			javaClass = EndToEndFlowInstance.class;
		} else if (genericType instanceof EventInstanceType) {
			javaClass = EventInstance.class;
		} else if (genericType instanceof FeatureInstanceType) {
			javaClass = FeatureInstance.class;
		} else if (genericType instanceof FlowSpecificationInstanceType) {
			javaClass = FlowSpecificationInstance.class;
		} else if (genericType instanceof InstanceObjectType) {
			javaClass = InstanceObject.class;
		} else if (genericType instanceof LongType) {
			javaClass = Long.class;
		} else if (genericType instanceof ModeInstanceType) {
			javaClass = ModeInstance.class;
		} else if (genericType instanceof StateInstanceType) {
			javaClass = StateInstance.class;
		} else if (genericType instanceof StringType) {
			javaClass = String.class;
		} else if (genericType instanceof SystemInstanceType) {
			javaClass = SystemInstance.class;
		} else if (genericType instanceof SystemOperationModeType) {
			javaClass = SystemOperationMode.class;
		} else {
			return null;
		}

		return receiver.filter(javaClass::isInstance);
	}

	private static Optional<?> map(Optional<?> receiver, Function<Object, Object> evaluateLambda) {
		return receiver.map(evaluateLambda);
	}

	private static Optional<?> flatMap(Optional<?> receiver, Function<Object, Object> evaluateLambda) {
		return receiver.flatMap(value -> (Optional<?>) evaluateLambda.apply(value));
	}

}