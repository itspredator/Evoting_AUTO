package custodian;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


public class MailSender {
//
//	public static void mailSender(String mailSender, 
//			String evenNo, String attachment) throws Exception {
//
//		String smtpHostServer = "172.19.45.53";
//		String smtpHostPort = "25";
//		String fromEmail = "surajkumarj@nsdl.com";
//
//		String subject = "RTA View Module " + evenNo;
//		String Greetings = "Dear Team,";
//		
//		String messageBody = "PFA.";
//
//		String Regard1 = "Thanks & Regards";
//		String Regard2 = "Suraj Jaiswar";
//
//		String finalMessage = Greetings + "\n" + "\n" + messageBody + "\n" + "\n" + "\n" + Regard1 + "\n"
//				+ Regard2;
//
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//		String currentDate = dateFormatter.format(new Date());
//
//		Properties props = System.getProperties();
//		props.put("mail.smtp.host", smtpHostServer);
//		props.put("mail.smtp.port", smtpHostPort);
//
//		Session session = Session.getInstance(props, null);
//
//		// Calling method to read files for Receipents
//
//		sendEmail(session, fromEmail, subject, finalMessage, currentDate, mailSender,
//				attachment);
//
//	}
//
//	private static void sendEmail(Session session, String fromEmail, String subject,
//			String message, String date, String mailSender, String attachment) {
//
//		try {
//
//			MimeMessage msg = new MimeMessage(session);
//			// set message headers
//
//			msg.addHeader("Content-type", "text/html; charset=UTF-8");
//			msg.addHeader("format", "flowed");
//			msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//			msg.setFrom(new InternetAddress(fromEmail));
//
//			msg.setSubject(subject);
//
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//
//			messageBodyPart1.setText(message);
//
//			// 4) create new MimeBodyPart object and set DataHandler object to this object
//			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//
//			DataSource source1 = new FileDataSource(attachment);
//			// System.out.println("1------------------>"+oUTPUTPATH);
//			messageBodyPart2.setDataHandler(new DataHandler(source1));
//			messageBodyPart2.setFileName(new File(attachment).getName());
//
//			// 5) create Multipart object and add MimeBodyPart objects to this object
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart1);
//			multipart.addBodyPart(messageBodyPart2);
//
//			// 6) set the multiplart object to the message object
//			msg.setContent(multipart);
//
//			msg.setSentDate(new Date());
//
//			msg.addRecipients(Message.RecipientType.TO, mailSender);
//
//			Transport.send(msg);
//
//			System.out.println("Email Sent Successfully!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
}
