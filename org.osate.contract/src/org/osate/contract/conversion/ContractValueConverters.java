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
package org.osate.contract.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.osate.xtext.aadl2.valueconversion.Aadl2ValueConverter;

public class ContractValueConverters extends Aadl2ValueConverter {

	SSTRINGValueConverter sstringValueConverter = new SSTRINGValueConverter();

	@ValueConverter(rule = "SSTRING")
	public IValueConverter<String> SSTRING() {
		return sstringValueConverter;
	}

	ISTRING_TEXTValueConverter iStringTextValueConverter = new ISTRING_TEXTValueConverter();

	@ValueConverter(rule = "ISTRING_TEXT")
	public IValueConverter<String> ISTRING_TEXT() {
		return iStringTextValueConverter;
	}

	ISTRING_LEFTValueConverter iStringLeftValueConverter = new ISTRING_LEFTValueConverter();

	@ValueConverter(rule = "ISTRING_LEFT")
	public IValueConverter<String> ISTRING_LEFT() {
		return iStringLeftValueConverter;
	}

	ISTRING_MIDDLEValueConverter iStringMiddleValueConverter = new ISTRING_MIDDLEValueConverter();

	@ValueConverter(rule = "ISTRING_MIDDLE")
	public IValueConverter<String> ISTRING_MIDDLE() {
		return iStringMiddleValueConverter;
	}

	ISTRING_RIGHTValueConverter iStringRightValueConverter = new ISTRING_RIGHTValueConverter();

	@ValueConverter(rule = "ISTRING_RIGHT")
	public IValueConverter<String> ISTRING_RIGHT() {
		return iStringRightValueConverter;
	}

}
