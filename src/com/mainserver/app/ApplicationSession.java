package com.mainserver.app;

import com.mainserver.gui.GUIHandler;

public class ApplicationSession {

	private static ApplicationSession instance;
	private GUIHandler guiHandler;

	private ApplicationSession() {
		setGuiHandler(new GUIHandler());
	}

	public GUIHandler getGuiHandler() {
		return guiHandler;
	}

	public void setGuiHandler(GUIHandler guiHandler) {
		this.guiHandler = guiHandler;
	}

	public static ApplicationSession getInstance() {
		if(instance==null) {
			synchronized (ApplicationSession.class) {
				if(instance==null) {
					instance=new ApplicationSession();
				}
			}
		}
		return instance;
	}
}
