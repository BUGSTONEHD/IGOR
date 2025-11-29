package com.example.proyectoIGOR.controller;

import com.example.proyectoIGOR.model.Proyecto;
import com.example.proyectoIGOR.repository.ProyectoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;

    public ProyectoController(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // Listar proyectos
    @GetMapping
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoRepository.findAll());
        return "proyectos/lista";
    }

    // Mostrar formulario de creación
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyectos/formulario";
    }

    // Guardar proyecto
    @PostMapping
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return "redirect:/proyectos";
    }

    // Editar proyecto
    @GetMapping("/editar/{id}")
    public String editarProyecto(@PathVariable String id, Model model) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        model.addAttribute("proyecto", proyecto);
        return "proyectos/formulario";
    }

    // Eliminar proyecto
    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable String id) {
        proyectoRepository.deleteById(id);
        return "redirect:/proyectos";
    }
}
