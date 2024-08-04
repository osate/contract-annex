package org.osate.contract.evaluation.ui;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
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
	String pathtoYaml = "";
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
		pathtoYaml = "";
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor monitor)
						throws CoreException, InvocationTargetException, InterruptedException {
					var subMonitor = SubMonitor.convert(monitor, "Generating YAML-GSN", yamlFolder.files().size() + 1);
					var folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1));

					for (var yamlFile : yamlFolder.files()) {
						var file = folder.getFile(new Path(yamlFile.name()));

						// Dio: for temporal the yaml compilation
						if (pathtoYaml.length() == 0) {
							pathtoYaml = file.getParent().getRawLocation().toOSString();
						}
						// Dio: end of yaml compilation piece

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

		/**
		 * Dio: This is a temporary call to compile the yaml files.
		 * It should be replaced by the proper one
		 */
		try {
			// folderPath contains the path where all the yaml files are located
			String osname = System.getProperty("os.name");

			if (osname.equalsIgnoreCase("LINUX")) {
				ProcessBuilder pb = new ProcessBuilder("sh", "-c", "gsn2x *.yaml");

				String abspath = pathtoYaml;

				pb.directory(new File(abspath));
				Process process = pb.start();

				StringBuilder output = new StringBuilder();
				BufferedReader reader
				= new BufferedReader(new InputStreamReader(
						process.getInputStream()));

				String line;
				while ((line = reader.readLine()) != null) {
					output.append(line + "\n");
				}

				int exitVal = process.waitFor();
				if (exitVal == 0) {
					System.out.println(" --- GSN2X SVG GENERATION PROCESS OUTPUT ---");
					System.out.println(output);
				} else {
					System.out.println("gsn2x svg generation process error: "+exitVal);
				}
			} else {
				System.out.println("Could not compile yaml files. Feature only enabled in Linux. Now running on:"+osname);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		/**
		 * Dio: End of yaml -> svg generation
		 */

		return null;
	}

	private record GeneratedYAML(IProject project, YamlFolder folder) {
	}
}