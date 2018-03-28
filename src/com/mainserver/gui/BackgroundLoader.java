package com.mainserver.gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BackgroundLoader {
	
	private Display display;
	private Shell shell;
	private Image image;
	private String imagePath;

	public BackgroundLoader(Shell shell) {
		this.imagePath = "background.jpg";
		image = new Image(display, imagePath);
		display=Display.getCurrent();
		this.shell=shell;
	}
	
	public void setBackgroundImage() {
		Canvas canvas = new Canvas(shell, SWT.NONE);

	    canvas.addPaintListener(new PaintListener() {
	      public void paintControl(PaintEvent e) {
	        e.gc.drawImage(image, 0, 0);
	        image.dispose();
	      }
	    });
	}

	public int getBackgroundWidth() {
		return image.getBounds().width;
	}

	public int getBackgroundHeght() {
		return image.getBounds().height;
	}
	

}
