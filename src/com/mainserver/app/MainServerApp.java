package com.mainserver.app;

public class MainServerApp {

	public MainServerApp() {
	}

	public static void main(String[] args) {
		MainServerApp app = ApplicationSession.getInstance().getApp();
		app.run();
	}

	private void run() {
		ApplicationSession.getInstance().getGuiHandler().run();
	}

	public void prepareToExit() {
		// TODO Auto-generated method stub
		
	}

}