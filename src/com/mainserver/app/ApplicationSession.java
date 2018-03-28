package com.mainserver.app;

import com.mainserver.gui.GUIHandler;

public class ApplicationSession {

	private static ApplicationSession instance;
	private GUIHandler guiHandler;
	private MainServerApp app;

	private ApplicationSession() {
		setGuiHandler(new GUIHandler());
		setApp(new MainServerApp());
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

	public MainServerApp getApp() {
		return app;
	}

	public void setApp(MainServerApp app) {
		this.app = app;
	}
}
