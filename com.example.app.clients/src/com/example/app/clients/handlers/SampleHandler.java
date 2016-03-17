package com.example.app.clients.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.example.app.api.circle.Circle;
import com.example.app.api.rectangle.Rectangle;
import com.example.app.clients.Activator;
import com.example.app.demo1.IObjectManager;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IObjectManager manager = getObjectManager();
		manager.readRegistry();
		Circle circle = manager.getExternalTool(Circle.class);
		Rectangle rectangle = manager.getExternalTool(Rectangle.class);
		MessageDialog.openInformation(window.getShell(), "Client",
				"Circle Area " + circle.area(7.) + "\n" + "Rectangle Area " + rectangle.area(10, 10));
		return null;
	}

	private IObjectManager getObjectManager() {
		BundleContext bundleContext = Activator.getDefault().getBundle().getBundleContext();
		ServiceReference<?> reference = bundleContext.getServiceReference(IObjectManager.class.getName());
		IObjectManager manager = (IObjectManager) bundleContext.getService(reference);
		return manager;
	}
}
