package com.example.proyectoIGOR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String showMenu(Model model) {
        String[][] opciones = {
                {"Gestión de Proyectos", "/proyectos"},
                {"Gestión de Recursos", "#"},   // aún no implementado
                {"Gestión de Clientes", "#"},
                {"Documentación", "#"},
                {"Análisis y Reportes", "#"}
        };
        model.addAttribute("opciones", opciones);
        return "menu"; // apunta a menu.html
    }
}
