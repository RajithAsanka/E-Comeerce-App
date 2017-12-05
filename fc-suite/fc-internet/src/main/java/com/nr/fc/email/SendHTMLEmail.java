/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.email;

import com.nr.fc.enums.EmailEnum;
import com.nr.fc.properties.EmailProperty;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Madhuranga Samarasinghe
 */
public class SendHTMLEmail {

    public String sendEmail(EmailProperty emailProperty) throws Exception {

        String result = "";

        Properties props = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("email_config.properties");
        props.load(input);

        props.put("mail.smtp.host", props.getProperty("smtpHost"));
        props.put("mail.smtp.auth", props.getProperty("smtpAuth"));
        props.put("mail.smtp.starttls.enable", props.getProperty("starttls"));
        props.put("mail.smtp.from", props.getProperty("smtpUsername"));
        props.put("mail.smtp.port", props.getProperty("smtpPort"));

        final String username = props.getProperty("smtpUsername");
        final String password = props.getProperty("smtpPassword");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailProperty.getToAddresses()));

            // Set Subject: header field
            message.setSubject(props.getProperty("smtpSubject"));

            // Send the actual HTML message, as big as you like
            message.setContent(emailProperty.getBody(), "text/html");

            // Send message
            Transport.send(message);

            result = EmailEnum.SENT;

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
            result = EmailEnum.NOT_SENT;
        }

        return result;
    }
}
