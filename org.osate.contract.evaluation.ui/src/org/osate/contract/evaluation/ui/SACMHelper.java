package org.osate.contract.evaluation.ui;

import java.util.Arrays;

import argumentation.ArgumentPackage;
import argumentation.ArgumentReasoning;
import argumentation.Argumentation_Factory;
import argumentation.ArtifactReference;
import argumentation.AssertedEvidence;
import argumentation.AssertedInference;
import argumentation.AssertionDeclaration;
import argumentation.Claim;
import artifact.ArtifactPackage;
import artifact.Artifact_Factory;
import artifact.Technique;
import assuranceCase.AssuranceCasePackage;
import assuranceCase.AssuranceCase_Factory;
import base.Base_Factory;
import base.Description;
import base.LangString;
import base.MultiLangString;

public final class SACMHelper {
	public static final String LANG_EN = "en";

	private SACMHelper() {
		super();
	}

	public static LangString newLangString(final String lang, final String content) {
		final LangString langString = Base_Factory.eINSTANCE.createLangString();
		langString.setLang(lang);
		langString.setContent(content);
		return langString;
	}

	public static MultiLangString newMultiLangString(final LangString... langStrings) {
		final MultiLangString mlString = Base_Factory.eINSTANCE.createMultiLangString();
		mlString.getValue().addAll(Arrays.asList(langStrings));
		return mlString;
	}

	public static final AssuranceCasePackage newAssuraceCasePackage(final LangString name) {
		final AssuranceCasePackage acp = AssuranceCase_Factory.eINSTANCE.createAssuranceCasePackage();
		acp.setName(name);
		return acp;
	}

	public static final ArgumentPackage newArgumentPackage(final LangString name) {
		final ArgumentPackage ap = Argumentation_Factory.eINSTANCE.createArgumentPackage();
		ap.setName(name);
		return ap;
	}

	public static final ArtifactPackage newArtifactPackage(final LangString name) {
		final ArtifactPackage ap = Artifact_Factory.eINSTANCE.createArtifactPackage();
		ap.setName(name);
		return ap;
	}

	public static Description newDescription(final MultiLangString content) {
		final Description description = Base_Factory.eINSTANCE.createDescription();
		description.setContent(content);
		return description;
	}

	public static Claim newClaim(final ArgumentPackage argPackage, final boolean assumed, final LangString name,
			final Description description) {
		final Claim claim = Argumentation_Factory.eINSTANCE.createClaim();
		argPackage.getArgumentationElement().add(claim);
		claim.setAssertionDeclaration((assumed) ? AssertionDeclaration.ASSUMED : AssertionDeclaration.ASSERTED);
		claim.setName(name);
		claim.setDescription(description);
		return claim;
	}

	public static Technique newTechnique(final ArtifactPackage artPackage, final LangString name,
			final Description description) {
		final Technique technique = Artifact_Factory.eINSTANCE.createTechnique();
		artPackage.getArtifactElement().add(technique);
		technique.setName(name);
		technique.setDescription(description);
		return technique;
	}

	public static ArtifactReference newArtifactReference(final ArgumentPackage argPackage, final LangString name,
			final Description description) {
		final ArtifactReference ref = Argumentation_Factory.eINSTANCE.createArtifactReference();
		argPackage.getArgumentationElement().add(ref);
		ref.setName(name);
		ref.setDescription(description);
		return ref;
	}

	public static AssertedInference newAssertedInference(final ArgumentPackage argPackage) {
		final AssertedInference inference = Argumentation_Factory.eINSTANCE.createAssertedInference();
		argPackage.getArgumentationElement().add(inference);
		return inference;
	}

	public static AssertedEvidence newAssertedEvidence(final ArgumentPackage argPackage) {
		final AssertedEvidence evidence = Argumentation_Factory.eINSTANCE.createAssertedEvidence();
		argPackage.getArgumentationElement().add(evidence);
		return evidence;
	}

	public static ArgumentReasoning newArgumentReasoning(final ArgumentPackage argPackage, final LangString name) {
		final ArgumentReasoning reasoning = Argumentation_Factory.eINSTANCE.createArgumentReasoning();
    	argPackage.getArgumentationElement().add(reasoning);
    	reasoning.setName(name);
    	return reasoning;
	}
}
