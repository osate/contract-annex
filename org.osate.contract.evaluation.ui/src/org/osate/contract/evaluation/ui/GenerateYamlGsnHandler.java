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
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.gsn.YamlFolder;
import org.osate.contract.gsn.YamlGsnGenerator;

public class GenerateYamlGsnHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var node = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		var generatedYaml = node.readOnly(state -> {
			var verificationPlan = (VerificationPlan) state;
			var project = OsateResourceUtil.toIFile(verificationPlan.eResource().getURI()).getProject();
			return new GeneratedYAML(project, YamlGsnGenerator.generateYamlGsn(verificationPlan));
		});
		var yamlFolder = generatedYaml.folder();
		var folderPath = generatedYaml.project().getFullPath().append("yaml-gen").append(yamlFolder.name());
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException, InterruptedException {
					var subMonitor = SubMonitor.convert(monitor, "Generating YAML-GSN", yamlFolder.files().size() + 1);
					var folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1));
					for (var yamlFile : yamlFolder.files()) {
						var file = folder.getFile(new Path(yamlFile.name()));
						var stream = new ByteArrayInputStream(yamlFile.contents().getBytes());
						if (file.exists()) {
							file.setContents(stream, false, true, subMonitor.split(1));
						} else {
							file.create(stream, false, subMonitor.split(1));
						}
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

	private record GeneratedYAML(IProject project, YamlFolder folder) {
	}
}