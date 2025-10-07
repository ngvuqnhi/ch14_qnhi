package com.chap14;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailUtil {
    public static void sendMail(String to, String subject, String body) throws MessagingException {
        // Cấu hình SMTP (Gmail)
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Đăng nhập Gmail
        final String username = System.getenv("EMAIL_USER");
        final String password = System.getenv("EMAIL_PASS");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        // Soạn mail
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setContent(body, "text/html; charset=UTF-8");

        // Gửi mail
        Transport.send(message);
    }
}
