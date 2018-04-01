package com.mainserver.gui;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DetailsPage extends MyComposite {

	private Text textTime;
	private Text textUser;
	private Text textDescription;
	private Text textLong;
	private Text textLat;
	private Text textStatus;
	
	

	public DetailsPage(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContent() {
		FormLayout formLayout = new FormLayout();
		setLayout(formLayout);
		
		int textWidth=300;

		Label labelTime = new Label(this, SWT.NONE);
		labelTime.setText("Time:");
		FormData labelTimeData = new FormData();
		labelTimeData.top = new FormAttachment(0, 20);
		labelTimeData.left = new FormAttachment(0, 20);
		labelTime.setLayoutData(labelTimeData);

		textTime = new Text(this, SWT.BORDER);
		FormData textTimeData = new FormData();
		textTimeData.top = new FormAttachment(0, 20);
		textTimeData.left = new FormAttachment(labelTime, 60);
		textTimeData.width=textWidth;
		textTime.setLayoutData(textTimeData);

		Label labelUser = new Label(this, SWT.NONE);
		labelUser.setText("User:");
		FormData labelUserData = new FormData();
		labelUserData.top = new FormAttachment(labelTime, 20);
		labelUserData.left = new FormAttachment(0, 20);
		labelUser.setLayoutData(labelUserData);

		textUser = new Text(this, SWT.BORDER);
		FormData textUserData = new FormData();
		textUserData.top = new FormAttachment(labelTime, 20);
		textUserData.left = new FormAttachment(labelTime, 60);
		textUserData.width=textWidth;
		textUser.setLayoutData(textUserData);

		Label labelDescription = new Label(this, SWT.NONE);
		labelDescription.setText("Description:");
		FormData labelDescriptionData = new FormData();
		labelDescriptionData.top = new FormAttachment(labelUser, 20);
		labelDescriptionData.left = new FormAttachment(0, 20);
		labelDescription.setLayoutData(labelDescriptionData);

		textDescription = new Text(this, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL);
		FormData textDescriptionData = new FormData();
		textDescriptionData.top = new FormAttachment(labelUser, 20);
		textDescriptionData.left = new FormAttachment(labelTime, 60);
		textDescriptionData.width = 300;
		textDescriptionData.height = 100;
		textDescription.setLayoutData(textDescriptionData);
		
		Label labelLong = new Label(this, SWT.NONE);
		labelLong.setText("Longitude:");
		FormData labelLongData = new FormData();
		labelLongData.top = new FormAttachment(textDescription, 20);
		labelLongData.left = new FormAttachment(0, 20);
		labelLong.setLayoutData(labelLongData);
		
		textLong=new Text(this, SWT.BORDER);
		FormData textLongData = new FormData();
		textLongData.top = new FormAttachment(textDescription, 20);
		textLongData.left = new FormAttachment(labelTime, 60);
		textLongData.width=textWidth;
		textLong.setLayoutData(textLongData);
		
		Label labelLat = new Label(this, SWT.NONE);
		labelLat.setText("Latitude:");
		FormData labelLatData = new FormData();
		labelLatData.top = new FormAttachment(labelLong, 20);
		labelLatData.left = new FormAttachment(0, 20);
		labelLat.setLayoutData(labelLatData);
		
		textLat=new Text(this, SWT.BORDER);
		FormData textLatData = new FormData();
		textLatData.top = new FormAttachment(labelLong, 20);
		textLatData.left = new FormAttachment(labelTime, 60);
		textLatData.width=textWidth;
		textLat.setLayoutData(textLatData);
		
		Button mapsButton=new Button(this, SWT.NONE);
		mapsButton.setText("Show On Maps");
		FormData mapsButtonData=new FormData();
		mapsButtonData.top=new FormAttachment(textLat,20);
		mapsButtonData.left= new FormAttachment(labelTime,60);
		mapsButton.setLayoutData(mapsButtonData);
		
		Label labelStatus = new Label(this, SWT.NONE);
		labelStatus.setText("Status:");
		FormData labelStatusData = new FormData();
		labelStatusData.top = new FormAttachment(mapsButton, 20);
		labelStatusData.left = new FormAttachment(0, 20);
		labelStatus.setLayoutData(labelStatusData);
		
		textStatus=new Text(this, SWT.BORDER);
		FormData textStatusData = new FormData();
		textStatusData.top = new FormAttachment(mapsButton, 20);
		textStatusData.left = new FormAttachment(labelTime, 60);
		textStatusData.width=textWidth;
		textStatus.setLayoutData(textStatusData);
		


	}

	public void receiveDataToDisplay(List<String> dataToDisplay) {
		// FIXME Label's text doesn't modify only if the length of the initial text is
		// >= than the new text
	}

}
