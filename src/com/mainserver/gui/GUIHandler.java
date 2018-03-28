package com.mainserver.gui;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GUIHandler {
	private Display display;
	private Shell shell;
	private BackgroundLoader backgroundLoader;

	public GUIHandler() {
		setDisplay(new Display());
		setShell(new Shell(getDisplay()));
		setBackgroundLoader(new BackgroundLoader(shell));
	}

	public void run() {
		shell.setLayout(new FillLayout());
		shell.setSize(backgroundLoader.getBackgroundWidth(), backgroundLoader.getBackgroundHeght());
		backgroundLoader.setBackgroundImage();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				// If no more entries in event queue
				display.sleep();
			}
		}
		display.dispose();
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public BackgroundLoader getBackgroundLoader() {
		return backgroundLoader;
	}

	public void setBackgroundLoader(BackgroundLoader backgroundLoader) {
		this.backgroundLoader = backgroundLoader;
	}
}
