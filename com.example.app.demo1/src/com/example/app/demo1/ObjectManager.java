package com.example.app.demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.Platform;

public class ObjectManager implements IObjectManager {

	private static final String EXTENSION_ID = "com.example.app.demo.dyanmic";
	private Collection<Object> objectPool;

	public ObjectManager() {
		init();
	}

	private void init() {
		objectPool = new ArrayList<Object>();
		Platform.getExtensionRegistry().addListener(registryListener, EXTENSION_ID);
		readRegistry();
	}

	@Override
	public <T> T getExternalTool(Class<T> t) {

		for (Object object : objectPool) {
			boolean b = t.isAssignableFrom(object.getClass());
			if (b) {
				return (T) object;
			}
		}
		return null;
	}

	public void readRegistry() {
		synchronized (objectPool) {
			objectPool.clear();
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			
				IConfigurationElement[] configurationElements = extensionRegistry.getConfigurationElementsFor(EXTENSION_ID);
				
					for (IConfigurationElement element : configurationElements) {
						try {
							Object object = element.createExecutableExtension("class");
							objectPool.add(object);
						} catch (CoreException e) {
							e.printStackTrace();
						}
					
				
			}
		}

	}

	@Override
	protected void finalize() throws Throwable {
		Platform.getExtensionRegistry().removeListener(registryListener);
		super.finalize();
	}

	private IRegistryEventListener registryListener = new IRegistryEventListener() {
		@Override
		public void removed(IExtensionPoint[] extensionPoints) {
			readRegistry();
		}

		@Override
		public void removed(IExtension[] extensions) {
			readRegistry();
		}

		@Override
		public void added(IExtensionPoint[] extensionPoints) {
			readRegistry();
		}

		@Override
		public void added(IExtension[] extensions) {
			readRegistry();
		}
	};

}
