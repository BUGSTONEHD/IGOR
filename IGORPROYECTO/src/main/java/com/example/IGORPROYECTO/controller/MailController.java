package com.example.IGORPROYECTO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.IGORPROYECTO.service.EmailService;

@Controller   
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/form")
    public String mostrarFormulario() {
        return "AnalisisYReportes/enviarCorreo"; 
    }

    @PostMapping("/enviar")
    public String enviar(
            @RequestParam String destinatarios,
            @RequestParam String asunto,
            @RequestParam String mensaje
    ) {
        String[] lista = destinatarios.split(",");
        for (int i = 0; i < lista.length; i++) {
            lista[i] = lista[i].trim();
        }

        emailService.enviarCorreoMultiple(lista, asunto, mensaje);

        return "AnalisisYReportes/analisis"; 
    }
}
