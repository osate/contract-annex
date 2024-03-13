package org.osate.contract.evaluation.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.contract.contract.VerificationPlan;

public class GenerateYamlGsnHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var node = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		node.readOnly(new IUnitOfWork.Void<EObject>() {
			@Override
			public void process(EObject state) throws Exception {
				var verificationPlan = (VerificationPlan) state;
				System.out.println("verificationPlan: " + verificationPlan);
			}
		});
		return null;
	}
}