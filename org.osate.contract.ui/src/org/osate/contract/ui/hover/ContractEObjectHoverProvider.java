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
package org.osate.contract.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.osate.aadl2.NamedElement;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.contract.RootExpression;
import org.osate.contract.contract.SelfExpression;
import org.osate.contract.typing.ComponentInstanceType;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.contract.typing.SystemInstanceType;

import com.google.inject.Inject;

public class ContractEObjectHoverProvider extends DefaultEObjectHoverProvider {
	@Inject
	private ContractTypeSystem typeSystem;

	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof NamedElement named) {
			return typeSystem.namedType(named).getValue() != null;
		} else if (o instanceof SelfExpression) {
			return true;
		} else if (o instanceof RootExpression) {
			return true;
		} else if (o instanceof MemberCall memberCall) {
			return typeSystem.expressionType(memberCall.getLeft()).getValue() != null
					&& typeSystem.expressionType(memberCall).getValue() != null;
		} else {
			return false;
		}
	}

	@Override
	protected String getFirstLine(EObject o) {
		String label;
		if (o instanceof NamedElement named) {
			var type = typeSystem.namedType(named).getValue();
			label = named.getName() + ": " + type;
		} else if (o instanceof SelfExpression) {
			label = "self: " + ComponentInstanceType.INSTANCE;
		} else if (o instanceof RootExpression) {
			label = "root: " + SystemInstanceType.INSTANCE;
		} else if (o instanceof MemberCall memberCall) {
			var leftType = typeSystem.expressionType(memberCall.getLeft()).getValue();
			var resultType = typeSystem.expressionType(memberCall).getValue();
			label = leftType + "." + memberCall.getRight() + ": " + resultType;
		} else {
			throw new RuntimeException("Invalid object: " + o);
		}
		return "<b>" + label.replace("<", "&lt;").replace(">", "&gt;") + "</b>";
	}
}