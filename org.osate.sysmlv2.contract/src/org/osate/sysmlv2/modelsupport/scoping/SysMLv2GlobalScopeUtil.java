package org.osate.sysmlv2.modelsupport.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.omg.sysml.lang.sysml.SysMLPackage;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class SysMLv2GlobalScopeUtil {
	private SysMLv2GlobalScopeUtil() {
		// empty
	}
	
	@Inject
	static IEClassGlobalScopeProvider globalScope;

	@Inject
	static IQualifiedNameConverter qnameConverter;

	@Inject
	static IScopeProvider scopeProvider;
	
	static {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.sysml")).get(Injector.class);
		globalScope = injector.getInstance(IEClassGlobalScopeProvider.class);
		qnameConverter = injector.getInstance(IQualifiedNameConverter.class);
		scopeProvider = injector.getInstance(IScopeProvider.class);
	}

	/**
	 * Find a SysMLv2 element by EClass in the global scope.
	 *
	 * @param context The starting point for the global scope.
	 * @param eClass The meta class of the element to find.
	 * @param qname The qualified name to search.
	 * @return The EObject that matches class and name, null if the name cannot be found.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T get(EObject context, EClass eClass, String qname) {
		T result = null;
		IScope scope = globalScope.getScope(context.eResource(), eClass);
		IEObjectDescription desc = scope.getSingleElement(qnameConverter.toQualifiedName(qname));
		if (desc != null) {
			EObject o = desc.getEObjectOrProxy();
			if (o.eIsProxy()) {
				o = EcoreUtil.resolve(o, context);
			}
			result = o.eIsProxy() ? null : (T) o;
		}		
		return result;
	}


	/**
	 * Find a SysMLv2 element by EClass in a local scope given by the reference
	 *
	 * @param context The starting point for the global scope.
	 * @param eClass The meta class of the element to find.
	 * @param qname The qualified name to search.
	 * @return The EObject that matches class and name, null if the name cannot be found.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getLocal(EObject context, EReference ref, String qname) {
		T result = null;
		final IScope localScope = scopeProvider.getScope(context, ref);
		var fromLocal = localScope.getSingleElement(qnameConverter.toQualifiedName(qname));
		if (fromLocal != null) {
			EObject o = fromLocal.getEObjectOrProxy();
			if (o.eIsProxy()) {
				o = EcoreUtil.resolve(o, context);
			}
			result = o.eIsProxy() ? null : (T) o;
		}		
		return result;
	}
}
