package org.osate.contract.evaluation.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;

import argumentation.ArgumentPackage;
import argumentation.ArgumentReasoning;
import argumentation.AssertedInference;
import argumentation.Claim;
import assuranceCase.AssuranceCasePackage;
import base.LangString;

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

	private static final void createSACMModelFile(final VerificationPlan vp) throws CoreException, IOException {
		final URI modelURI = getSACMModeURI(vp);
		final IFile file = OsateResourceUtil.toIFile(modelURI);
		if (file != null && file.isAccessible()) {
			file.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		}
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource sacmResource = resourceSet.createResource(modelURI);

		createAssuraceCasePackage(sacmResource, vp);

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

	private static final void createAssuraceCasePackage(
			final Resource sacmResource, final VerificationPlan vp) {
		final LangString pName = SACMHelper.newLangString(SACMHelper.LANG_EN, "Verification Plan " + vp.getFullName());
		final AssuranceCasePackage acp = SACMHelper.newAssuraceCasePackage(pName);
		sacmResource.getContents().add(acp);
		createAssurancePackage(acp, vp);
	}

	private static void createAssurancePackage(final AssuranceCasePackage acp, final VerificationPlan vp) {
		final LangString pName = SACMHelper.newLangString(SACMHelper.LANG_EN, "The Argument");
		final ArgumentPackage ap = SACMHelper.newArgumentPackage(pName);
		acp.getArgumentPackage().add(ap);
		processVerificationPlan(ap, vp);
	}

	private static void processVerificationPlan(final ArgumentPackage ap, final VerificationPlan vp) {
		final Claim vpClaim = SACMHelper.newClaim(ap, false, SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()),
				SACMHelper.newDescription(
						SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()))));

		// Process verification plan's "claims" as SACM "assumed" claims
		final List<Claim> assumed = new ArrayList<>(vp.getClaims().size());
		for (final Source src : vp.getClaims()) {
			final Claim assumption = SACMHelper.newClaim(ap, true,
					SACMHelper.newLangString(SACMHelper.LANG_EN, getClaimName(src, vp)),
					SACMHelper.newDescription(
							SACMHelper
							.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, toString(src)))));
			assumed.add(assumption);
		}

		// add inference between vp and its claims
		final ArgumentReasoning analysis = SACMHelper.newAnalysis(ap,
				SACMHelper.newLangString(SACMHelper.LANG_EN, "TBD"));
		final AssertedInference inference = SACMHelper.newInference(ap);
		inference.getSource().addAll(assumed);
		inference.getTarget().add(vpClaim);
		inference.setReasoning(analysis);

	}

	// unchanged
	private static String getClaimName(Source claim, VerificationPlan verificationPlan) {
		return verificationPlan.getName() + "_claim_" + (verificationPlan.getClaims().indexOf(claim) + 1);
	}

	// unchanged
	private static String toString(Source source) {
		if (source.getSource() != null) {
			return source.getSource();
		} else if (source.getInter() != null) {
			var result = new StringBuilder();
			for (var part : source.getInter().getParts()) {
				if (part instanceof IStringLiteral stringLiteral) {
					result.append(stringLiteral.getValue());
				} else if (part instanceof IStringVar stringVar) {
					result.append("${");
					if (stringVar.isDirect()) {
						result.append(':');
					}
					if (stringVar.getQuery() != null) {
						if (stringVar.getDomain() != null) {
							result.append(stringVar.getDomain().getName());
							result.append("::");
						}
						result.append(stringVar.getQuery().getName());
					} else {
						result.append(stringVar.getPredefined());
					}
					result.append("$}");
				} else {
					throw new AssertionError("Unexpected class: " + part.getClass());
				}
			}
			return result.toString();
		} else {
			throw new AssertionError("Unexpected condition: source and inter are both null for " + source);
		}
	}

}