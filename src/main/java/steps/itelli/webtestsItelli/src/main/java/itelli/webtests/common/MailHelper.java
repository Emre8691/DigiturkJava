package steps.itelli.webtestsItelli.src.main.java.itelli.webtests.common;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class MailHelper {

	/*
	public static boolean SendTestResultMail(String userName, DemandExecution demandExecution) {
		UserRights userRights = demandExecutionCommonServices.getUserRights(userName);
		if (userRights != null) {
			if (userRights.geteMail() != null && !userRights.geteMail().equals("")) {
				String body = "<body>";
				body = "Test execution is completed.<br/>";
				body = body + "<a href='http://10.176.222.88/#/report?executionId="+demandExecution.getExecutionId()+"'>View report<a/>";
				body = body + "</body>";
				return SendMail(userRights.geteMail(), "Test Execution Result", body);
			}
		}
		return false;
	}
	*/
	
	public static boolean SendMail(String recipient, String subject, String body, String filename, byte[] attachment) {
		String from = "test-automation@bshg.com";
		String host = "10.176.222.88";
	    int port = 25;

		Properties properties = System.getProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.port", port); 
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject);
			//message.setText(body);
			//message.setContent(body, "text/html; charset=utf-8");

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			
			/*
			String filename = "/home/manisha/file.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			*/
			
			if (filename != null) {
				MimeBodyPart attachmentPart = new MimeBodyPart();

				try {
				  DataSource ds = new ByteArrayDataSource(attachment, "application/octet-stream");
				  attachmentPart = new MimeBodyPart();
				  attachmentPart.setDataHandler(new DataHandler(ds));
				} 
				catch (Exception e) {
				}

				attachmentPart.setFileName(filename);
				multipart.addBodyPart(attachmentPart);
			}
			
			message.setContent(multipart);
			
			
			Transport transport = session.getTransport();
			transport.connect(host,"","");
            transport.sendMessage(message, message.getAllRecipients());
			
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		return true;

	}
}
