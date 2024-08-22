package org.osate.contract.uriHandler;

import java.net.URI;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.markers.MarkerViewUtil;
import org.eclipse.urischeme.IUriSchemeHandler;

public class GSNMarkerUriSchemeHandler implements IUriSchemeHandler {
	public void handle(String uri) {
		var analysisName = URI.create(uri).getHost();
		if (analysisName != null) {
			Display.getDefault().asyncExec(() -> {
				var window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (window != null) {
					var page = window.getActivePage();
					if (page != null) {
						try {
							var markers = ResourcesPlugin.getWorkspace()
									.getRoot()
									.findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
							for (var marker : markers) {
								if (marker.getAttribute(IMarker.MESSAGE) instanceof String message
										&& message.contains(analysisName)) {
									MarkerViewUtil.showMarker(page, marker, true);
									break;
								}
							}
						} catch (CoreException e) {
							var status = new Status(e.getStatus().getSeverity(), "org.osate.contract",
									e.getLocalizedMessage(), e);
							StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.SHOW);
						}
					}
				}
			});
		}
	}
}