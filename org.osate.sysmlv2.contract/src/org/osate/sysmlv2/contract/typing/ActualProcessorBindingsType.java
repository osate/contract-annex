/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and
 * unlimited distribution.  Please see Copyright notice for non-US Government use and
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
package org.osate.sysmlv2.contract.typing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.sysml.lang.sysml.AllocationUsage;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.OccurrenceDefinition;
import org.omg.sysml.lang.sysml.PartUsage;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.osate.sysmlv2.modelsupport.scoping.SysMLv2GlobalScopeUtil;


public final class ActualProcessorBindingsType implements Type {
	public static final ActualProcessorBindingsType INSTANCE = new ActualProcessorBindingsType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("sw", new SwMember());
		MEMBERS.put("hw", new HwMember());
	}

	private ActualProcessorBindingsType() {
	}

	@Override
	public Map<String, Member> getMembers() {
		return MEMBERS;
	}

	@Override
	public boolean supportsAttributeLookup() {
		return true;
	}

	@Override
	public String toString() {
		return "ActualProcessorBindings";
	}

	private static OccurrenceDefinition getReferencedOccurrenceDefinition(final AllocationUsage receiver, final String endFeatureName) {
		for (var endFeature : receiver.getEndFeature()) {
			if (endFeature.getDeclaredName().equals(endFeatureName)) {
				// Get qualified name of the last named part reference
				var referencedFeature = endFeature.getOwnedReferenceSubsetting().getReferencedFeature();
				var featureChain = referencedFeature.getOwnedFeatureChaining();
				var qualifiedName = (featureChain.size() > 0)
						? featureChain.get(featureChain.size() - 1).getChainingFeature().getQualifiedName()
								: referencedFeature.getQualifiedName();
//				System.out.println("qname = " + qualifiedName);
				final PartUsage swPartUsage = SysMLv2GlobalScopeUtil.getLocal(
						referencedFeature, SysMLPackage.eINSTANCE.getConnector_ConnectorEnd(), qualifiedName);
				return (OccurrenceDefinition) swPartUsage.getDefinition().get(0);				
			}
		}
		throw new IllegalArgumentException("Thread allocation does not follow pattern");
	}
	
	private static class SwMember implements SimpleMember<AllocationUsage, OccurrenceDefinition> {
		@Override
		public Type getReturnType() {
			return OccurrenceDefintionType.INSTANCE;
		}

		@Override
		public OccurrenceDefinition evaluate(final AllocationUsage receiver) {
			return getReferencedOccurrenceDefinition(receiver, "sw");
		}
	}

	private static class HwMember implements SimpleMember<AllocationUsage, OccurrenceDefinition> {
		@Override
		public Type getReturnType() {
			return OccurrenceDefintionType.INSTANCE;
		}

		@Override
		public OccurrenceDefinition evaluate(final AllocationUsage receiver) {
			return getReferencedOccurrenceDefinition(receiver, "hw");
		}
	}
}