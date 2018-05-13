package com.mainserver.app;

import com.mainserver.gui.GUIHandler;

public class ApplicationSession {

	private static ApplicationSession instance;
	private GUIHandler guiHandler;
	private MainServerApp app;
	private EmailSender emailSender;
	private HTTPPostHandler postHandler;

	private ApplicationSession() {
		setGuiHandler(new GUIHandler());
		setApp(new MainServerApp());
		setEmailSender(new EmailSender());
		postHandler=new HTTPPostHandler();
	}

	public GUIHandler getGuiHandler() {
		return guiHandler;
	}

	public void setGuiHandler(GUIHandler guiHandler) {
		this.guiHandler = guiHandler;
	}

	public static ApplicationSession getInstance() {
		if (instance == null) {
			synchronized (ApplicationSession.class) {
				if (instance == null) {
					instance = new ApplicationSession();
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

	public EmailSender getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public HTTPPostHandler getPostHandler() {
		return postHandler;
	}

	public void setPostHandler(HTTPPostHandler postHandler) {
		this.postHandler = postHandler;
	}
}
