package com.example.IGORPROYECTO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoMultiple(String[] destinatarios, String asunto, String mensaje) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("TU_CORREO@gmail.com");
        mail.setTo(destinatarios);
        mail.setSubject(asunto);
        mail.setText(mensaje);

        mailSender.send(mail);
    }
}
