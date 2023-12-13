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
package org.osate.contract.execution;

import java.util.HashMap;

import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

public class InstanceObjectIDMapper {

	private SystemInstance root;

	private HashMap<InstanceObject, Integer> io2id = new HashMap<>();

	private HashMap<Integer, InstanceObject> id2io = new HashMap<>();

	private static InstanceObjectIDMapper mapper = null;

	public static InstanceObjectIDMapper getMapper(SystemInstance root) {
		if (mapper != null && mapper.root == root) {
			return mapper;
		}
		mapper = new InstanceObjectIDMapper(root);
		return mapper;
	}

	private InstanceObjectIDMapper(SystemInstance root) {
		this.root = root;
		int id = 0;
		// aadl resource may contain additional root objects for instantiated referenced classifiers
		var iter = root.eResource().getAllContents();
		while (iter.hasNext()) {
			var e = iter.next();

			if (e instanceof InstanceObject io) {
				if (!io2id.containsKey(io)) {
					io2id.put(io, id);
					id2io.put(id, io);
					id += 1;
				}
			} else {
				iter.prune();
			}
		}
	}

	public Integer getID(InstanceObject io) {
		return io2id.get(io);
	}

	public InstanceObject getInstanceObject(Integer id) {
		return id2io.get(id);
	}

}
