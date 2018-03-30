package com.mainserver.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.mainserver.app.ApplicationSession;

public class GUIHandler {
	private Display display;
	private Shell shell;
	private BackgroundLoader backgroundLoader;
	private int buttonWidth = 70;
	private int buttonHeight = 30;
	private WelcomePage welcomePage;
	private InboxPage inboxPage;
	private Composite contentPanel;
	private StackLayout layout;
	private DetailsPage detailsPage;

	public GUIHandler() {
		setDisplay(new Display());
		setShell(new Shell(getDisplay(), SWT.ALT | SWT.MIN | SWT.CLOSE));
		setBackgroundLoader(new BackgroundLoader());
	}

	public void run() {
		shell.setLayout(new FormLayout());
		shell.setSize(backgroundLoader.getBackgroundWidth(), backgroundLoader.getBackgroundHeight() + 100);

		contentPanel = new Composite(shell, SWT.BORDER);
		// contentPanel.setBounds(10, 10, 300, 300);
		layout = new StackLayout();
		contentPanel.setLayout(layout);

		welcomePage = new WelcomePage(contentPanel, SWT.NONE);
		inboxPage = new InboxPage(contentPanel, SWT.NONE);
		detailsPage = new DetailsPage(contentPanel, SWT.NONE);
		changeToPage(welcomePage);

		FormData dataContentPanel = new FormData();
		dataContentPanel.top = new FormAttachment(0, 0);
		dataContentPanel.right = new FormAttachment(100, 0);
		dataContentPanel.left = new FormAttachment(0, 0);
		contentPanel.setLayoutData(dataContentPanel);

		Button exit = new Button(shell, SWT.NONE);
		exit.setText("Exit");
		FormData exitData = new FormData();
		exitData.bottom = new FormAttachment(100, -10);
		exitData.right = new FormAttachment(100, -10);
		exitData.width = buttonWidth;
		exitData.height = buttonHeight;
		exit.setLayoutData(exitData);

		Button next = new Button(shell, SWT.NONE);
		next.setText("Next");
		FormData nextData = new FormData();
		nextData.bottom = new FormAttachment(100, -10);
		nextData.right = new FormAttachment(exit, -20);
		nextData.width = buttonWidth;
		nextData.height = buttonHeight;
		next.setLayoutData(nextData);

		exit.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				shell.close();
				ApplicationSession.getInstance().getApp().prepareToExit();
			}
		});

		next.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (layout.topControl == welcomePage) {
					changeToPage(inboxPage);
					inboxPage.refresh();
				} else if (layout.topControl == inboxPage) {
					if (inboxPage.isItemSelected()) {
						changeToPage(detailsPage);
						detailsPage.receiveDataToDisplay(inboxPage.getDataToSend());
					}else {
						MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING );
				        messageBox.setText("Select a record");
				        messageBox.setMessage("You need to select a record to continue");
				        messageBox.open();
					}
				}
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				// If no more entries in event queue
				display.sleep();
			}
		}
		display.dispose();
	}

	private void changeToPage(Composite page) {
		layout.topControl = page;
		contentPanel.layout();
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
