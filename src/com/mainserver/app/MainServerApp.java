package com.mainserver.app;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainServerApp {

	public List<Problem> problems;
	public List<Receiver> receivers;

	public MainServerApp() {
		problems = new ArrayList<Problem>();
		receivers = new ArrayList<Receiver>();
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
				Desktop.getDesktop().browse(new URI("https://www.google.com/maps/?q=" + longitude + "," + latitude));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	

	public void getProblemsFromDB() {
		problems=ApplicationSession.getInstance().getPostHandler().getAllNewProblemsFromDB();
	}

	public void getReceiversFromDB() {
		//TODO http
		/*receivers = new ArrayList<Receiver>();
		receivers.add(new Receiver("Politie"));
		receivers.add(new Receiver("Primarie"));
		receivers.add(new Receiver("Pompieri"));*/
		receivers=ApplicationSession.getInstance().getPostHandler().getReceiversFromDB();
	}

	public void sentProblemToReceiver(Problem problem, Receiver receiver) {
		ApplicationSession.getInstance().getPostHandler().sentProblemToReceiver(problem.getId(),receiver.getName());
	}

	public Problem getProblemById(int id) {
		for (Problem problem : problems) {
			if (problem.getId() == id) {
				return problem;
			}
		}
		return null;
	}

	public void sendConfirmationEmail(Problem problem) {
		String to = problem.getUser().getEmail();
		String subject = "Problem sent";
		String body = "<i><b>Greetings!</i></b><br><br><br>";
		body += "The problem you had sent has been sent further, to the suitable authority.\n<br><br>"
				+ "<font color=green><b><i>Problem you sent: </i></b></font>" + problem.getDescription() + "\n</b><br><br>"
				+ "<i><b>Sent to: </i></b>" + problem.getReceiver().getName();

		ApplicationSession.getInstance().getEmailSender().sendEmail(to, subject, body);
	}
	
	/*String body = "<i><b>Greetings!</i></b><br><br><br>";
		body += "The problem you had sent has been sent further, to the suitable authority.\n<br><br>"
						+ "<font color=green><b><i>Problem you sent: </i></b></font>" + problem.getDescription() + "\n</b><br><br>"
						+ "<i><b>Sent to: </i></b>" + problem.getReceiver().getName();
Chat Conversation End
Type a message...*/

	public Receiver getReceiverByName(String name) {
		for (Receiver receiver : receivers) {
			if (receiver.getName().equals(name)) {
				return receiver;
			}
		}
		return null;
	}

}