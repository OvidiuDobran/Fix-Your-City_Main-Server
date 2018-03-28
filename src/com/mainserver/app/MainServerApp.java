package com.mainserver.app;

import com.mainserver.gui.GUIHandler;

public class MainServerApp {

	private GUIHandler guiHandler;

	public MainServerApp() {
		guiHandler=new GUIHandler();
	}

	public static void main(String[] args) {
		MainServerApp app = new MainServerApp();
		app.run();
	}

	private void run() {
		guiHandler.run();
	}

}