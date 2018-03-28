package com.mainserver.gui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class InboxPage extends MyComposite {

	
	protected Table table;
	private List<String>dataToSend;
	
	public InboxPage(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createContent() {
		FormLayout formLayout = new FormLayout();
		setLayout(formLayout);
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		String[] titles = { "Time", "User", "Problem","Status" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.CENTER);
			column.setText(titles[i]);
			column.setWidth(200);
		}

		refresh();

		FormData tableFormData = new FormData();
		tableFormData.top = new FormAttachment(0, 10);
		tableFormData.bottom = new FormAttachment(100, -30);
		tableFormData.left = new FormAttachment(0, 10);
		tableFormData.right = new FormAttachment(100, -30);
		table.setLayoutData(tableFormData);

		table.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				int index = table.getSelectionIndex();
				TableItem item = table.getItem(index);
				/*System.out.print(item.getText(0));
				System.out.print(item.getText(1));
				System.out.println(item.getText(2));*/
				for (int i=0;i<table.getColumnCount();i++) {
					getDataToSend().add(item.getText(i));
				}
			}
		});

	}

	public void refresh() {
		setDataToSend(new ArrayList<String>());
		populateTable();
	}

	private void populateTable() {
		table.removeAll();
		//TODO here will be a call to a method that will get the records from the DB
		for (int i = 0; i < 20; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, "x");
			item.setText(1, "y");
			item.setText(2, "!");
			item.setText(3,"NEW");
		}
	}

	public List<String> getDataToSend() {
		return dataToSend;
	}

	public void setDataToSend(List<String> dataToSend) {
		this.dataToSend = dataToSend;
	}
	
	public boolean isItemSelected() {
		return table.getSelectionIndex()!=-1;
	}
	
}
