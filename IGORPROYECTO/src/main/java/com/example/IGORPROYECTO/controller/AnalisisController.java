package com.example.IGORPROYECTO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.IGORPROYECTO.service.AnalisisService;

@Controller
@RequestMapping("/analisis")
public class AnalisisController {

    private final AnalisisService analisisService;

    public AnalisisController(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    // Carga analisis.html cuando se accede a /analisis
    @GetMapping("")
    public String menuAnalisis() {
        return "AnalisisYReportes/analisis"; 
    }

    @GetMapping("/kpi")
    public String registrarKPI() {
        return "AnalisisYReportes/registrarKPI"; // coincide con el archivo
    }

    @GetMapping("/peticiones")
    public String hacerPeticiones() {
        return "AnalisisYReportes/hacerPeticion"; // coincide con el archivo
    }

    @GetMapping("/solicitud")
    public String solicitudPeticion() {
        return "AnalisisYReportes/solicitudPeticion"; // coincide con el archivo
    }
}
