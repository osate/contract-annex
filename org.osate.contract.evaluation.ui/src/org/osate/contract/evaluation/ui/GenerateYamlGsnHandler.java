package org.osate.contract.evaluation.ui;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.gsn.YamlGsnGenerator;

public class GenerateYamlGsnHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var node = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		var generatedYaml = node.readOnly(state -> {
			var verificationPlan = (VerificationPlan) state;
			var project = OsateResourceUtil.toIFile(verificationPlan.eResource().getURI()).getProject();
			var aadlPackage = EcoreUtil2.getContainerOfType(verificationPlan, AadlPackage.class);
			var outputFileName = aadlPackage.getName() + "_" + verificationPlan.getName() + ".gsn.yaml";
			return new GeneratedYAML(project, outputFileName, YamlGsnGenerator.generateYamlGsn(verificationPlan));
		});
		var folderPath = generatedYaml.project().getFullPath().append("yaml-gen");
		var stream = new ByteArrayInputStream(generatedYaml.contents().getBytes());
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException, InterruptedException {
					var subMonitor = SubMonitor.convert(monitor, "Generating YAML-GSN", 2);
					var folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1));
					var file = folder.getFile(new Path(generatedYaml.fileName()));
					if (file.exists()) {
						file.setContents(stream, false, true, subMonitor.split(1));
					} else {
						file.create(stream, false, subMonitor.split(1));
					}
				}
			});
		} catch (InvocationTargetException e) {
			var status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while generating YAML-GSN.",
					e.getTargetException());
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
		} catch (InterruptedException e) {
		}
		return null;
	}

	private record GeneratedYAML(IProject project, String fileName, String contents) {
	}
}