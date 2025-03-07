package org.osate.sysmlv2.contract.evaluation.ui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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
					var subMonitor = SubMonitor.convert(monitor, "Generating YAML-GSN", yamlFolder.files().size() + 4);
					var folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1));
					subMonitor.setWorkRemaining(folder.members().length + yamlFolder.files().size() + 2);

					for (var member : folder.members()) {
						member.delete(false, subMonitor.split(1));
					}

					var yamlIFolder = folder.getFolder(new Path("yaml"));
					yamlIFolder.create(false, true, subMonitor.split(1));

					for (var yamlFile : yamlFolder.files()) {
						var file = yamlIFolder.getFile(new Path(yamlFile.name()));
						var stream = new ByteArrayInputStream(yamlFile.contents().getBytes());
						file.create(stream, false, subMonitor.split(1));
					}

					try {
						String commandName;
						Process process;
						/*
						 * First try calling gsn2x. If that doesn't work, then try calling gsn2x-Linux, gsn2x-macOS, or
						 * gsn2x-Windows.
						 */
						try {
							commandName = "gsn2x";
							process = callGsn2x(commandName, yamlFolder, yamlIFolder);
						} catch (IOException e) {
							/*
							 * Assume that an IOException means that gsn2x isn't available. Go ahead and try
							 * gsn2x-Linux, gsn2x-macOS, or gsn2x-Windows.
							 */
							commandName = getOSBasedCommandName();
							if (commandName != null) {
								process = callGsn2x(commandName, yamlFolder, yamlIFolder);
							} else {
								throw new IOException("OS not supported by gsn2x: " + System.getProperty("os.name"));
							}
						}
						var exitCode = process.waitFor();
						if (exitCode != 0) {
							var message = new StringBuilder(
									commandName + " returned exit code " + exitCode + ":" + System.lineSeparator());
							process.inputReader()
									.lines()
									.forEach(line -> message.append("  " + line + System.lineSeparator()));
							throw new IOException(message.toString());
						}
					} catch (IOException e) {
						throw new InvocationTargetException(e);
					}

					folder.refreshLocal(IResource.DEPTH_INFINITE, subMonitor.split(1));
				}
			});
		} catch (InvocationTargetException e) {
			var status = Status.error("Error while generating YAML-GSN.", e.getTargetException());
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
		} catch (InterruptedException e) {
		}
		return null;
	}

	private static Process callGsn2x(String commandName, YamlFolder yamlFolder, IContainer folder) throws IOException {
		var command = new ArrayList<String>();
		command.add(commandName);
		command.add("-o");
		command.add(".." + File.separatorChar + "svg");
		for (var yamlFile : yamlFolder.files()) {
			command.add(yamlFile.name());
		}
		return new ProcessBuilder(command).directory(new File(folder.getRawLocation().toOSString()))
				.redirectErrorStream(true)
				.start();
	}

	private static String getOSBasedCommandName() {
		var osName = System.getProperty("os.name").toLowerCase();
		String osPostfix = null;
		if (osName.contains("linux")) {
			osPostfix = "Linux";
		} else if (osName.contains("mac")) {
			osPostfix = "macOS";
		} else if (osName.contains("windows")) {
			osPostfix = "Windows";
		}
		if (osPostfix != null) {
			return "gsn2x-" + osPostfix;
		} else {
			return null;
		}
	}

	private record GeneratedYAML(IProject project, YamlFolder folder) {
	}
}