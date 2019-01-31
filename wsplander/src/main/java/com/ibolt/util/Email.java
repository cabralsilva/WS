package com.ibolt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class Email {

	public void send(HttpServletRequest request) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String mensagem = "<strong><u>Mensagem de Log Erro do site www.plander.com.br</u></strong><br><br><br>"
				+ "<strong>Descrição: </strong>Falha de autenticação<br><br>" + "<strong>Data: </strong>"
				+ fmt.format(new Date()) + "<br><br>" + "<strong>URL: </strong>" + request.getRequestURL() + "<br><br>"
				+ "<strong>IP Cliente: </strong>" + ipAddress + "<br><br>";

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.iboltsys.com.br");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("log@iboltsys.com.br", "ib@017*");
			}
		};

		Session mailSession = Session.getDefaultInstance(props, auth);
		// uncomment for debugging infos to stdout
		// mailSession.setDebug(true);
		Transport transport;
		try {
			transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("log@iboltsys.com.br"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("suporte@iboltsys.com.br"));
			message.setSubject("Log erro www.plander.com.br");
			message.setSentDate(new Date());
			message.setContent(mensagem, "text/html");

			transport.connect();
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
