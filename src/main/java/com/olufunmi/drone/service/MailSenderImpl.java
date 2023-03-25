package com.olufunmi.drone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Component
@RequiredArgsConstructor
public class MailSenderImpl implements MailSender{
    private final JavaMailSender javaMailSender;

    String text = "Routine check has been done on the drone batteries";
    String subject = "Drone Battery Report";
    String to = "adeyinkawale13@gmail.com";

    @Override
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }


}
