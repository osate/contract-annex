package org.osate.sysmlv2.contract.execution;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.omg.sysml.lang.sysml.Element;
import org.osate.sysmlv2.modelsupport.SysMlv2Constants;
import org.osate.sysmlv2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.sysmlv2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;

public class ExperimentalErrorParser {

	AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
			new MarkerAnalysisErrorReporter.Factory(SysMlv2Constants.SYSMLOBJECTMARKER));

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

	public void markErrors(PythonHelper pythonHelper, String errString) {
		ArrayList<ExperimentalErrorParser.ErrorPair> errors = parseErrors(pythonHelper, errString);
		for (ErrorPair pair : errors) {
			errManager.error(pair.element, pair.error);
		}
	}

	public void markUnfulfilledObjectives(PythonHelper pythonHelper, String errString) {
		ArrayList<ExperimentalErrorParser.ErrorPair> errors = parseErrors(pythonHelper, errString);
		for (ErrorPair pair : errors) {
			errManager.error(pair.element, pair.error + " Unfulfilled. Not enough details to satisfy all assumptions");
		}
	}

	public void markInfo(PythonHelper pythonHelper, String errString) {
		ArrayList<ExperimentalErrorParser.ErrorPair> errors = parseErrors(pythonHelper, errString);
		for (ErrorPair pair : errors) {
			errManager.info(pair.element, pair.error);
		}
	}

	public ArrayList<ErrorPair> parseErrors(PythonHelper pythonHelper, String errString) {

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

			// Skip any token with a leading comma
			if (token.charAt(0) == ',') {
				continue;
			}

			Element instance = null;
			String errMessage = token;
			if (token.contains("{")) {
				String ref = token.substring(token.indexOf("{") + 1, token.indexOf("}"));
				errMessage = token.substring(token.indexOf("}") + 1);
				int index = Integer.parseInt(ref);
				instance = pythonHelper.getInstanceObjectMapper().getInstanceObject(index);
			}
			errors.add(new ErrorPair(instance, contractName + ":" + errMessage));
		}

		return errors;
	}

}
