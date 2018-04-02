package com.mainserver.app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainServerApp {

	public List<Problem> problems;

	public MainServerApp() {
		problems = new ArrayList<Problem>();
	}

	public static void main(String[] args) {
		MainServerApp app = ApplicationSession.getInstance().getApp();
		app.run();
	}

	private void run() {
		ApplicationSession.getInstance().getGuiHandler().run();
	}

	public void openInBrowser(String longitude, String latitude) {
		if (Desktop.isDesktopSupported()) {
		    try {
				Desktop.getDesktop().browse(new URI("https://www.google.com/maps/?q="+longitude+","+latitude));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	public void prepareToExit() {
		// TODO Auto-generated method stub

	}

	public void getProblemsFromDB() {
		Problem problem1 = new Problem((new Date()).toString(), new User("ion", "ion"), "pisica in copac", "45.749455",
				"21.231243",Status.NEW);
		Problem problem2 = new Problem((new Date()).toString(), new User("ion", "ion"), "pisica in copac", "45.749455",
				"21.231243",Status.NEW);
		Problem problem3 = new Problem((new Date()).toString(), new User("ion", "ion"), "pisica in copac", "45.749455",
				"21.231243",Status.NEW);
		Problem problem4 = new Problem((new Date()).toString(), new User("ion", "ion"), "pisica in copac", "45.749455",
				"21.231243",Status.NEW);

		problems = new ArrayList<Problem>();
		problems.add(problem1);
		problems.add(problem2);
		problems.add(problem3);
		problems.add(problem4);
	}
	
	public Problem getProblemById(int id){
		for(Problem problem:problems) {
			if (problem.getId()==id) {
				return problem;
			}
		}
		return null;
	}

}