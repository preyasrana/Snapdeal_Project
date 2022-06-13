package StepDefinition;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import Utility.testbase;

public class mail extends testbase {

	@Test
	public void mailsend() {

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		// props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		// props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.starttls.enable", true);
		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of SMTP server
		props.put("mail.smtp.port", "587");

		// This will handle the complete authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(configreader.init_prop().getProperty("email_username"),
						configreader.init_prop().getProperty("email_password"));
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(configreader.init_prop().getProperty("email_from")));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(configreader.init_prop().getProperty("email_to")));
			// below code only requires if your want cc email address
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(configreader.init_prop().getProperty("email_cc")));
			// below code only requires if your want bcc email address
			message.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(configreader.init_prop().getProperty("email_bcc")));
			message.setSubject(configreader.init_prop().getProperty("email_subject"));
			// message.setText(msg);

			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(configreader.init_prop().getProperty("email_body_message"));

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = System.getProperty("user.dir") + configreader.init_prop().getProperty("email_file_path");
			System.out.println("Uploaded file name: " + filename);
			// Mention the file which you want to send

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			System.out.println("Sending");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
