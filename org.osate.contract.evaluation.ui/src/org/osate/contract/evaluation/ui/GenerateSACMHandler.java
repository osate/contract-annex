package org.osate.contract.evaluation.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
import org.osate.contract.contract.Analysis;
import org.osate.contract.contract.Argument;
import org.osate.contract.contract.ArgumentAssumption;
import org.osate.contract.contract.ArgumentExpression;
import org.osate.contract.contract.CodeAssumption;
import org.osate.contract.contract.Contract;
import org.osate.contract.contract.ContractAssumption;
import org.osate.contract.contract.Guarantee;
import org.osate.contract.contract.IStringLiteral;
import org.osate.contract.contract.IStringVar;
import org.osate.contract.contract.Source;
import org.osate.contract.contract.VerificationPlan;

import argumentation.ArgumentPackage;
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

	// TODO: Make a new class for all this


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
		final SACMBuilder builder = new SACMBuilder(ap);
		builder.buildSACM(vp);
	}


//		// Process verification plan's "claims" as SACM "assumed" claims
//		final List<Claim> assumed = new ArrayList<>(vp.getClaims().size());
//		for (final Source src : vp.getClaims()) {
//			final Claim assumption = SACMHelper.newClaim(ap, true,
//					SACMHelper.newLangString(SACMHelper.LANG_EN, getClaimName(src, vp)),
//					SACMHelper.newDescription(
//							SACMHelper
//							.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, toString(src)))));
//			assumed.add(assumption);
//		}

//		// add inference between vp and its claims
//		final ArgumentReasoning analysis = SACMHelper.newAnalysis(ap,
//				SACMHelper.newLangString(SACMHelper.LANG_EN, "TBD"));
//		final AssertedInference inference = SACMHelper.newInference(ap);
//		inference.getSource().addAll(assumed);
//		inference.getTarget().add(vpClaim);
//		inference.setReasoning(analysis);



	private static class SACMBuilder {
		private final ArgumentPackage ap;
		protected static HashMap<Object, Object> parentContract = new HashMap<Object, Object>();
		private final Map<Source, Claim> claimsToClaims = new HashMap<>();
		private final Map<Contract, Claim> contractsToClaims = new HashMap<>();
		private final Map<Claim, List<Source>> claimsEdges = new HashMap<>();
		private final Map<Claim, List<Contract>> contractEdges = new HashMap<>();

		public SACMBuilder(final ArgumentPackage ap) {
			this.ap = ap;
		}

		public Claim buildSACM(final VerificationPlan vp) {
			final Claim vpClaim = generateVerificationPlan(vp);
			final NodeCollector collector = new NodeCollector(vp);
			collector.contractNodes.forEach((contract, contractNodes) -> {
				contractsToClaims.put(contract, generateContract(contract));
//				for (var assumption : contractNodes.assumptions) {
//					nodes.add(generateAssumption(assumption));
//				}
//				for (var analysis : contractNodes.analyses) {
//					nodes.add(generateAnalysis(analysis));
//				}
//				var argpath = getArgumentPath(contract);
//				files.add(new YamlFile(argpath, nodes));
			});

			return vpClaim;
		}

		private Claim generateVerificationPlan(final VerificationPlan vp) {
			final Claim vpClaim = SACMHelper.newClaim(ap, false,
					SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()), SACMHelper.newDescription(
							SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, vp.getName()))));
			claimsEdges.put(vpClaim, vp.getClaims());
			contractEdges.put(vpClaim, vp.getContracts());
			return vpClaim;
		}

		private Claim generateContract(final Contract contract) {
			final String description;
			final Guarantee guarantee = contract.getGuarantee();
			if (guarantee == null) {
				description = contract.getName();
			} else {
				var symbol = contract.isExact() ? "<=>" : "=>";
				var source = GenerateSACMHandler.toString(guarantee.getCode());
				description = symbol + ' ' + source;
			}
			final String argPath = getArgumentPath(contract);

			final Claim contractClaim = SACMHelper.newClaim(ap, false,
					SACMHelper.newLangString(SACMHelper.LANG_EN, argPath), SACMHelper.newDescription(
							SACMHelper.newMultiLangString(SACMHelper.newLangString(SACMHelper.LANG_EN, description))));
			contractsToClaims.put(contract, contractClaim);

			final List<String> supportedBy = new ArrayList<>();
			final List<String> inContextOf = new ArrayList<>();
			for (var assumption : contract.getAssumptions()) {
				if (assumption instanceof ContractAssumption contractAssumption
						&& contractAssumption.getContract() instanceof Contract referencedContract) {
					parentContract.put(referencedContract, contract);
					supportedBy.add(argPath + "." + referencedContract.getName());
				} else if (assumption instanceof ArgumentAssumption argumentAssumption
						&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
					parentContract.put(referencedArgument, contract);
					supportedBy.add(argPath + "." + referencedArgument.getName());
				} else if (assumption instanceof CodeAssumption codeAssumption) {
					parentContract.put(codeAssumption, contract);
					inContextOf.add(argPath + "." + getAssumptionName(codeAssumption));
				}
			}
			for (var analysis : contract.getAnalyses()) {
				parentContract.put(analysis, contract);
				supportedBy.add(argPath + "." + getAnalysisName(analysis));
			}

			// TODO: add stuff to claimEdges and contractEdges!!

//			if (supportedBy.isEmpty()) {
//				template.add("supportedBy", "");
//			} else {
//				template.add("supportedBy",
//						supportedBy.stream().distinct().collect(Collectors.joining(", ", "supportedBy: [", "]")));
//			}
//
//			if (inContextOf.isEmpty()) {
//				template.add("inContextOf", "");
//			} else {
//				template.add("inContextOf",
//						inContextOf.stream().distinct().collect(Collectors.joining(", ", "inContextOf: [", "]")));
//			}
//
//			if (supportedBy.isEmpty() && inContextOf.isEmpty()) {
//				template.add("undeveloped", "undeveloped: true");
//			} else {
//				template.add("undeveloped", "");
//			}

			return contractClaim;
		}

		// --

		private static class NodeCollector {
			public final Map<Contract, ContractNodes> contractNodes = new LinkedHashMap<>();
			public final Map<Argument, ArgumentNodes> argumentNodes = new LinkedHashMap<>();
			public final List<String> commonAssumptions = new ArrayList<>();
			public final List<String> commonAnalyses = new ArrayList<>();

			public NodeCollector(VerificationPlan verificationPlan) {
				for (var contract : verificationPlan.getContracts()) {
					parentContract.put(contract, verificationPlan);
					collect(contract);
				}

				var assumptionOccurrences = new LinkedHashMap<String, Integer>();
				var analysisOccurrences = new HashMap<String, Integer>();

				for (var nodes : contractNodes.values()) {
					for (var assumption : nodes.assumptions) {
						assumptionOccurrences.merge(assumption, 1, Integer::sum);
					}
					for (var analysis : nodes.analyses) {
						analysisOccurrences.merge(analysis, 1, Integer::sum);
					}
				}

				for (var entry : assumptionOccurrences.entrySet()) {
					if (entry.getValue() > 1) {
						commonAssumptions.add(entry.getKey());
					}
				}
				for (var entry : analysisOccurrences.entrySet()) {
					if (entry.getValue() > 1) {
						commonAnalyses.add(entry.getKey());
					}
				}

				for (var nodes : contractNodes.values()) {
					nodes.assumptions.removeAll(commonAssumptions);
					nodes.analyses.removeAll(commonAnalyses);
				}
			}

			private void collect(Contract contract) {
				var argpath = getArgumentPath(contract);
				var nodes = contractNodes.computeIfAbsent(contract, key -> new ContractNodes());
				for (var assumption : contract.getAssumptions()) {
					parentContract.put(assumption, contract);
					if (assumption instanceof ContractAssumption contractAssumption
							&& contractAssumption.getContract() instanceof Contract referencedContract) {
						collect(referencedContract);
					} else if (assumption instanceof ArgumentAssumption argumentAssumption
							&& argumentAssumption.getArgument() instanceof Argument referencedArgument) {
						collect(referencedArgument);
					} else if (assumption instanceof CodeAssumption codeAssumption) {
						nodes.assumptions.add(argpath + "." + getAssumptionName(codeAssumption));
					}
				}
				for (var analysis : contract.getAnalyses()) {
					nodes.analyses.add(argpath + "." + getAnalysisName(analysis));
				}
			}

			private void collect(Argument argument) {
				var nodes = argumentNodes.computeIfAbsent(argument, key -> new ArgumentNodes());
				if (argument.getArgumentExpression() != null) {
					parentContract.put(argument.getArgumentExpression(), argument);
					collect(argument.getArgumentExpression(), nodes);
				}
			}

			private void collect(ArgumentExpression expression, ArgumentNodes nodes) {
				nodes.argumentExpressions.add(expression);
				for (var referencedArgument : expression.getArguments()) {
					if (referencedArgument instanceof Argument castedArgument) {
						parentContract.put(castedArgument, expression);
						collect(castedArgument);
					}
				}
				for (var referencedContract : expression.getContracts()) {
					if (referencedContract instanceof Contract castedContract) {
						parentContract.put(castedContract, expression);
						collect(castedContract);
					}
				}
				for (var nested : expression.getNested()) {
					parentContract.put(nested, expression);
					collect(nested, nodes);
				}
			}
		}

		// --

		// unchanged
		public static String getArgumentPath(Object contract) {
			String path = "";
			Stack<String> pathSegments = new Stack<String>();

			Object parent = parentContract.get(contract);
			while (parent != null) {
				pathSegments.push(getName(parent));
				parent = parentContract.get(parent);
			}

			while (!pathSegments.isEmpty()) {
				String s = pathSegments.pop();
				if (s.length() > 0) {
					if (path.length() > 0) {
						path = path + "." + s;
					} else {
						path = path + s;
					}
				}
			}

			if (path.length() > 0) {
				path = path + "." + getName(contract);
			} else {
				path = getName(contract);
			}

			return path;
		}
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

	// unchanged

	// unchanged
	private static class ContractNodes {
		public final Set<String> assumptions = new LinkedHashSet<>();
		public final Set<String> analyses = new LinkedHashSet<>();
	}

	// unchanged
	private static class ArgumentNodes {
		public final Set<ArgumentExpression> argumentExpressions = new LinkedHashSet<>();
	}


	// unchanged
	public static String getName(Object c) {
		if (c instanceof Contract) {
			return ((Contract) c).getName();
		} else if (c instanceof VerificationPlan) {
			return ((VerificationPlan) c).getName();
		} else if (c instanceof Argument) {
			return ((Argument) c).getName();
		}

		return "";
	}

	// unchanged
	private static String getAssumptionName(CodeAssumption assumption) {
		return trimParens(toString(assumption.getCode()));
	}

	// unchanged
	private static String getAnalysisName(Analysis analysis) {
		return trimParens(toString(analysis.getCode()));
	}

	// unchanged
	private static String trimParens(String s) {
		var paren = s.indexOf('(');
		if (paren == -1) {
			return s;
		} else {
			return s.substring(0, paren);
		}
	}
}