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
package org.osate.contract.contracts.countcontract;

import java.util.LinkedList;
import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.contract.tuples.Tuple;

public final class CountContract {
//	# compReqs is a JAVA list of Java tuple (ComponentInstance, Java list of Java (Classifier, Long))
//	def flattenRequirements(compReqs):
//		output = []
//		for i in range(compReqs.size()):
//			compListPair = compReqs.get(i)
//			comp = compListPair.getElements().get(0)
//
//			print("****", comp.getName())
//
//			list = compListPair.getElements().get(1)
//			for j in range(list.size()):
//				tuple = list.get(j)
//				classifier = tuple.getElements().get(0)
//				count = tuple.getElements().get(1)
//
//				print("Classifier", classifier.getName())
//				print("Count", count)
//
//				output.append( (comp, classifier, count) )
//		print("Flattened ", output)
//		return output
//

	// XXX: Temp function until "flatMap" function is added to the query language
	private static List<Tuple> flatten(final List<Tuple> compReqs) {
		final List<Tuple> output = new LinkedList<>();
		for (final Tuple in : compReqs) {
			final ComponentInstance ci = (ComponentInstance) in.getElements().get(0);
			@SuppressWarnings("unchecked")
			final List<Tuple> list = (List<Tuple>) in.getElements().get(1);
			for (final Tuple nested : list) {
				output.add(new Tuple(List.of(ci, nested.getElements().get(0), nested.getElements().get(1))));
			}
		}
		return output;
	}

	public boolean checkCounts(final List<Tuple> flattenMe) {
		final List<Tuple> requiredCounts = flatten(flattenMe);
		boolean allGood = true;
		for (final Tuple tuple : requiredCounts) {
			final ComponentInstance comp = (ComponentInstance) tuple.getElements().get(0);
			final Classifier requiredClassifier = (Classifier) tuple.getElements().get(1);
			final long requiredCount = (Long) tuple.getElements().get(2);
			System.out.println(
					"*** " + comp.getName() + " for " + requiredCount + " of " + requiredClassifier.getFullName());
			final int numFound = countClassiifer(comp, requiredClassifier);
			if (numFound < requiredCount) {
				allGood = false;
				System.out.println(" BAD: Only found " + numFound);
			} else {
				System.out.println(" Satisdied, found " + numFound);
			}

		}
		return allGood;
	}

	private static int countClassiifer(final ComponentInstance root, final Classifier classifier) {
		int numFound = 0;
		for (final ComponentInstance current : root.getAllComponentInstances()) {
			if (current != root) {
				final Classifier k = current.getClassifier();
				if (k != null && k.isDescendentOf(classifier)) {
					numFound += 1;
				}
			}
		}
		return numFound;
	}

	public boolean getTrue(SystemInstance root) {
		return true;
	}

	public boolean getFalse(SystemInstance root) {
		return false;
	}

}
