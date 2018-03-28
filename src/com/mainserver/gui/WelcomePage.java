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
		guiHandler.getBackgroundLoader().setBackgroundImage(this);
	}

}
