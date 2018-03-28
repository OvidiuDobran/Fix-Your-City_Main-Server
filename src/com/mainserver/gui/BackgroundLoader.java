package com.mainserver.gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class BackgroundLoader {
	
	private Display display;
	private Image image;
	private String imagePath;

	public BackgroundLoader() {
		this.setImagePath("background.jpg");
		display=Display.getCurrent();
		image = new Image(display, getImagePath());
	}
	
	public void setBackgroundImage(Composite composite) {
	    Label label = new Label(composite, SWT.BORDER );
	    label.setImage(new Image(display,"background.jpg"));
	}

	public int getBackgroundWidth() {
		return image.getBounds().width;
	}

	public int getBackgroundHeight() {
		return image.getBounds().height;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
