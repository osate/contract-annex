package org.osate.sysmlv2.modelsupport.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @since 6.1
 */
public class DelegatingEClassGlobalScopeProvider implements IDelegatingEClassGlobalScopeProvider {

	static IEClassGlobalScopeProvider delegate = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.contract")).get(IEClassGlobalScopeProvider.class);

	@Override
	public IEClassGlobalScopeProvider getDelegate() {
		return delegate;
	}

}
