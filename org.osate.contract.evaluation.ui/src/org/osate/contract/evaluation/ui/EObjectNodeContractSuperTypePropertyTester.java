package org.osate.contract.evaluation.ui;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.contract.contract.ContractPackage;

public class EObjectNodeContractSuperTypePropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof EObjectNode node && property.equals("superType")
				&& expectedValue instanceof String expectedName) {
			var expectedClass = ContractPackage.eINSTANCE.getEClassifier(expectedName);
			var receiverClass = node.getEClass();
			return receiverClass.equals(expectedClass) || receiverClass.getEAllSuperTypes().contains(expectedClass);
		} else {
			return false;
		}
	}
}