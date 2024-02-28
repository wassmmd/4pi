package com.bezkoder.springjwt.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class Tfa {
@Autowired
     JavaMailSender emailSender;
    public void sendEmail(String recipient) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(recipient);
            helper.setSubject("Test email");
            helper.setText("Bonjour, your code is 24983546");
            emailSender.send(message);
            System.out.println("Message envoye");
        } catch (MessagingException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
