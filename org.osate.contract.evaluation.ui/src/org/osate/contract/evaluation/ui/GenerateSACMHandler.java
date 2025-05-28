package org.osate.contract.evaluation.ui;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.contract.contract.VerificationPlan;
import org.osate.contract.sacm.SACMGenerator;

public class GenerateSACMHandler extends AbstractHandler {
	private static final String SACM_DIR = "sacm";
	private static final String SACM_FILE_EXT = "assurancecase_";
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final EObjectNode vpNode = (EObjectNode) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();

		final Job job = new KickoffJob(vpNode);
		job.setRule(null); // doesn't use resources
		job.schedule();

		// Supposed to always return null
		return null;
	}

	private final class KickoffJob extends Job {
		private final EObjectNode vpNode;

		public KickoffJob(final EObjectNode vpNode) {
			super("Generate SACM");
			this.vpNode = vpNode;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			vpNode.readOnly(state -> {
				final VerificationPlan vp = (VerificationPlan) state;

				try {
					createSACMModelFile(vp);
				} catch (CoreException | IOException e) {
					// XXX: What to do with it?
					System.err.println(e);
				}

				return null;
			});

			return Status.OK_STATUS;
		}
	}

	// TODO: Make a new class for all this


	private static final void createSACMModelFile(final VerificationPlan vp) throws CoreException, IOException {
		final URI modelURI = getSACMModeURI(vp);
		final IFile file = OsateResourceUtil.toIFile(modelURI);
		if (file != null && file.isAccessible()) {
			file.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		}
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource sacmResource = resourceSet.createResource(modelURI);

		SACMGenerator.createAssuraceCasePackage(sacmResource, vp);

		sacmResource.save(null);
		sacmResource.unload();
	}

	private static URI getSACMModeURI(final VerificationPlan vp) {
		final Resource res = vp.eResource();
		final URI modeluri = res.getURI();
		final String filename = vp.getName();
		final URI path = modeluri.trimSegments(1);
		URI instanceURI = path.appendSegment(SACM_DIR).appendSegment(filename).appendFileExtension(SACM_FILE_EXT);
		return instanceURI;
	}
}