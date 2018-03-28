package com.mainserver.gui;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DetailsPage extends MyComposite {

	private Label label;

	public DetailsPage(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContent() {
		FormLayout formLayout = new FormLayout();
		setLayout(formLayout);
		label = new Label(this, SWT.NONE);
		label.setText("abc                            ");
	}

	public void receiveDataToDisplay(List<String> dataToDisplay) {
		//FIXME Label's text doesn't modify only if the length of the initial text is >= than the new text
		System.out.println("abcd");
		label.setText(dataToDisplay.toString());
	}

}
