package com.mainserver.app;

public class MainServerApp {

	public MainServerApp() {
	}

	public static void main(String[] args) {
		MainServerApp app = new MainServerApp();
		app.run();
	}

	private void run() {
		ApplicationSession.getInstance().getGuiHandler().run();
	}

}