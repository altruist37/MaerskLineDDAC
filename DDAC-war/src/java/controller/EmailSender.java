/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author abspk
 */
public class EmailSender {

    private String subject, body;
    private final String sendGridUser = "azure_fef1915ad129e6f17f501f43e31d74ad@azure.com";
    private final String sendGridPassword = "Lolz!@#@1$";
    private final String FROM = "uzair@linux.com";

    public void sendEmail(String to, String body, String subject) {
        /* TODO output your page here. You may use following sample code. */

        try {
            //Code from SendGrid Java Mail sender Example. @https://docs.microsoft.com/en-us/azure/store-sendgrid-java-how-to-send-email
            // The SendGrid SMTP server.
            String SMTP_HOST_NAME = "smtp.sendgrid.net";

            Properties properties;

            properties = new Properties();

            // Specify SMTP values.
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.host", SMTP_HOST_NAME);
            properties.put("mail.smtp.port", 587);
            properties.put("mail.smtp.auth", "true");

            // Display the email fields entered by the user. 
            // Create the authenticator object.
            Authenticator authenticator = new SMTPAuthenticator();

            // Create the mail session object.
            Session mailSession;
            mailSession = Session.getInstance(properties, authenticator);// getDefaultInstance(properties, authenticator);
            mailSession.setDebug(true);

            // Create the message and message part objects.
            MimeMessage message;
            Multipart multipart;
            MimeBodyPart messagePart;

            message = new MimeMessage(mailSession);

            multipart = new MimeMultipart("alternative");
            messagePart = new MimeBodyPart();
            messagePart.setContent(body, "text/html");
            multipart.addBodyPart(messagePart);

            // Specify the email To, From, Subject and Content. 
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(multipart);

            
            Transport transport;
            transport = mailSession.getTransport();
            // Connect the transport object.
            transport.connect();
            // Send the message.
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            // Close the connection.
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SMTPAuthenticator extends Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = sendGridUser;
            String password = sendGridPassword;

            return new PasswordAuthentication(username, password);
        }
    }

}
