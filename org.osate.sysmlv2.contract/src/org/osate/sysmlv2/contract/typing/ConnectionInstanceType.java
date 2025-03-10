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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

public final class ConnectionInstanceType implements Type {
	public static final ConnectionInstanceType INSTANCE = new ConnectionInstanceType();
	private static final Map<String, Member> MEMBERS;

	static {
		MEMBERS = new LinkedHashMap<>();
		MEMBERS.put("name", new NameMember());
		MEMBERS.put("source", new SourceMember());
		MEMBERS.put("destination", new DestinationMember());
		MEMBERS.put("allEndPoints", new AllEndPointsMember());
	}

	private ConnectionInstanceType() {
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
		return "ConnectionInstance";
	}

	private static class NameMember implements SimpleMember<ConnectionInstance, String> {
		@Override
		public Type getReturnType() {
			return StringType.INSTANCE;
		}

		@Override
		public String evaluate(ConnectionInstance receiver) {
			return receiver.getName();
		}
	}

	private static class SourceMember implements SimpleMember<ConnectionInstance, ConnectionInstanceEnd> {
		@Override
		public Type getReturnType() {
			return ConnectionInstanceEndType.INSTANCE;
		}

		@Override
		public ConnectionInstanceEnd evaluate(ConnectionInstance receiver) {
			return receiver.getSource();
		}
	}

	private static class DestinationMember implements SimpleMember<ConnectionInstance, ConnectionInstanceEnd> {
		@Override
		public Type getReturnType() {
			return ConnectionInstanceEndType.INSTANCE;
		}

		@Override
		public ConnectionInstanceEnd evaluate(ConnectionInstance receiver) {
			return receiver.getDestination();
		}
	}

	private static class AllEndPointsMember implements SimpleMember<ConnectionInstance, List<ConnectionInstanceEnd>> {
		@Override
		public Type getReturnType() {
			return new ListType(ConnectionInstanceEndType.INSTANCE);
		}

		@Override
		public List<ConnectionInstanceEnd> evaluate(ConnectionInstance receiver) {
			var endPoints = new LinkedHashSet<ConnectionInstanceEnd>();
			for (var connectionReference : receiver.getConnectionReferences()) {
				endPoints.add(connectionReference.getSource());
				endPoints.add(connectionReference.getDestination());
			}
			return List.copyOf(endPoints);
		}
	}
}