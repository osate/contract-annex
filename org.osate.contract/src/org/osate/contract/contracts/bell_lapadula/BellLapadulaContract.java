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
package org.osate.contract.contracts.bell_lapadula;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.contract.contracts.verificationproperties.Verificationproperties;

public final class BellLapadulaContract {
	public boolean check(final List<ComponentInstance> systems) {
		boolean good = true;
		for (final ComponentInstance sys : systems) {
			System.out.println("** Checking system " + sys.getFullName() + " **");
			// Get the security level of the system -- Assume value exists!
			final Long sysLevel = Verificationproperties.getLevel(sys).getAsLong();

			/*
			 * For each feature, if it's an in port then compare it against the
			 * security level of the component, and against each out port.
			 */
			final List<FeatureInstance> features = sys.getAllFeatureInstances();
			final List<Long> levels = new ArrayList<Long>(features.size());
			for (final FeatureInstance f : features) {
				// XXX: Assume the property exists
				levels.add(Verificationproperties.getLevel(f).getAsLong());
			}

			final Iterator<FeatureInstance> fIter = features.iterator();
			final Iterator<Long> lIter = levels.iterator();
			while (fIter.hasNext()) {
				final FeatureInstance curFeature = fIter.next();
				final Long curLevel = lIter.next();
				System.out.println(">>>> Checking feature " + curFeature.getFullName() + " <<<<*");
				if (curFeature.getDirection() == DirectionType.IN) {
					if (curLevel > sysLevel) {
						System.out.println("Security level of IN feature " + curFeature.getFullName()
								+ " is greater than the security level of the its component");
						good = false;
					}
					// check against all the out ports
					final Iterator<Long> oIter = levels.iterator();
					for (final FeatureInstance other : features) {
						final Long oLevel = oIter.next();
						if (other.getDirection() == DirectionType.OUT) {
							if (curLevel > oLevel) {
								System.out.println("Security level of IN feature " + curFeature.getFullName()
										+ " is greater than the security level of OUT feature " + other.getFullName());
								good = false;
							}
						}
					}
				}
			}
		}
		return good;
	}
}
