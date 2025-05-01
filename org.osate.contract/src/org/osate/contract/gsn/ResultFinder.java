package org.osate.contract.gsn;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

public class ResultFinder {

	IMarker[] markers = null;

	public ResultFinder() {
		var window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			var page = window.getActivePage();
			if (page != null) {
				try {
					markers = ResourcesPlugin.getWorkspace()
							.getRoot()
							.findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
				} catch (CoreException e) {
					var status = new Status(e.getStatus().getSeverity(), "org.osate.contract", e.getLocalizedMessage(),
							e);
					StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
				}
			}
		}
	}

	public  String getResult(String evalpath) {
		String result = "None";
		if (markers != null) {
			for (var marker : markers) {
				try {
					if (marker.getAttribute(IMarker.MESSAGE) instanceof String message && message.contains(evalpath)) {
						var severity = marker.getAttribute(IMarker.SEVERITY);
						if (severity instanceof Integer intSeverity) {
							if (intSeverity.intValue() == IMarker.SEVERITY_ERROR) {
								result = "false";
							} else if (intSeverity.intValue() == IMarker.SEVERITY_INFO) {
								result = "true";
							}
						}
						break;
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
