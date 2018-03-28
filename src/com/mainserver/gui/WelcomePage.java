package com.mainserver.gui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class WelcomePage extends MyComposite{
	
	public WelcomePage(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createContent() {
		setLayout(new FormLayout());
		setBounds(0, 0, 300, 300);
		//Label l=new Label(this, SWT.NONE);
		guiHandler.getBackgroundLoader().setBackgroundImage(this);
		Button button=new Button(this, SWT.None/*getBackgroundMode()*/);
		button.setBounds(0, 0, 10, 10);
	}

}
