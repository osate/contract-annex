package org.osate.contract.uriHandler;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.markers.MarkerViewUtil;

public class GSNURIMarkerCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		@SuppressWarnings("unchecked")
		Map<String, String> set = event.getParameters();
		String analysisName = set.get("org.osate.contract.uriHandler.GSNURIMarker.analysisName");
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPage page = window.getActivePage();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource resource = workspace.getRoot();
		IMarker[] markers;
		try {
			markers = resource.findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
			for (IMarker m : markers) {
				String message = (String) m.getAttribute(IMarker.MESSAGE);
				if (message != null && message.contains(analysisName)) {
					MarkerViewUtil.showMarker(page, m, true);
					break;
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return null;
	}

}
