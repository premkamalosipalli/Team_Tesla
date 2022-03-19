package com.movie.booking;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;

class Mailer {
	private String mailhost = "smtp.gmail.com";
	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public void send(String from, String password, String to, String sub, String msg) {

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setSender(new InternetAddress(from));
			message.setSubject(sub);
			message.setContent(msg, "text/plain");
			if (to.indexOf(',') > 0)
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			else
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			Transport.send(message);
		} catch (MessagingException e) {
			LOGGER.info("Error in Mailer Class");
			throw new RuntimeException(e);
		}

	}
}