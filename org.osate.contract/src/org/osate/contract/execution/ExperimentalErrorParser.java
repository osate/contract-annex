package org.osate.contract.execution;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;

public class ExperimentalErrorParser {

	public class ErrorPair {
		public Element element;
		public String error;

		public ErrorPair(Element e, String err) {
			element = e;
			error = err;
		}
	}

	public static ExperimentalErrorParser getParser() {
		return new ExperimentalErrorParser();
	}

	PythonHelper phelper = PythonHelper.get();
	AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
			new MarkerAnalysisErrorReporter.Factory(AadlConstants.AADLOBJECTMARKER));

	public InstanceObject getObjectInstanceFromId(int id) {
		return phelper.getInstanceObjectMapper().getInstanceObject(id);
	}

	public void markErrors(String errString) {
		ArrayList<ExperimentalErrorParser.ErrorPair> errors = parseErrors(null, errString);
		for (ErrorPair pair : errors) {
			errManager.error(pair.element, pair.error);
		}
	}

	public void markInfo(String errString) {
		ArrayList<ExperimentalErrorParser.ErrorPair> errors = parseErrors(null, errString);
		for (ErrorPair pair : errors) {
			errManager.info(pair.element, pair.error);
		}
	}

	public ArrayList<ErrorPair> parseErrors(Element root, String errString) {

		ArrayList<ErrorPair> errors = new ArrayList<ErrorPair>();

		if (errString.length() == 0) {
			return errors;
		}

		if (errString.charAt(0) == '[') {
			errString = errString.substring(1);
		}

		if (errString.charAt(errString.length() - 1) == ']') {
			errString = errString.substring(0, errString.length() - 1);
		}

		StringTokenizer errorTokenizer = new StringTokenizer(errString, "|");
		String contractName = "";
		while (errorTokenizer.hasMoreTokens()) {
			String token = errorTokenizer.nextToken();

			token = token.trim();

			if (token.length() == 0) {
				continue;
			}

			// Skip the unique error number needed for unique z3 assert_and_track() call
			if (token.charAt(0) == '#') {
				continue;
			}

			InstanceObject instance = (InstanceObject) root;

			if (token.contains("{")) {
				String ref = token.substring(token.indexOf("{") + 1, token.indexOf("}"));
				String errMessage = token.substring(token.indexOf("}") + 1);
				int index = Integer.parseInt(ref);
				instance = getObjectInstanceFromId(index);
				errors.add(new ErrorPair(instance, contractName + ":" + errMessage));
			}
		}

		return errors;
	}

}
