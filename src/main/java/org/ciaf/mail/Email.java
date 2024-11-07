package org.ciaf.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Email {

    public static void sendEmail(String addressee, String
            affair, String
            message, File archiveAttach){

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.example.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("pruebasjocasa@gmail.com", "jcs123");
            }
        });

        try {
            Message mail = new MimeMessage(session);
            mail.setFrom(new InternetAddress("pruebasjocasa@gmail.com"));
            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressee));
            mail.setSubject(affair);

            MimeBodyPart bodymessage = new MimeBodyPart();
            bodymessage.setText(message);

            MimeBodyPart affair2 = new MimeBodyPart();
            affair2.attachFile(archiveAttach);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodymessage);
            multipart.addBodyPart(affair2);

            mail.setContent(multipart);

            Transport.send(mail);
            System.out.println("Mail sent successfully.");

        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
