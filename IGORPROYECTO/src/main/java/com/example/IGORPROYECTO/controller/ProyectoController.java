package com.example.IGORPROYECTO.controller;

import com.example.IGORPROYECTO.model.Proyecto;
import com.example.IGORPROYECTO.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // Mostrar formulario para crear nuevo proyecto
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyectos/nuevo"; // coincide con la carpeta y archivo
    }

    // Guardar proyecto (POST)
    @PostMapping("/nuevo")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.nuevo(proyecto);  // llama al service correcto
        return "redirect:/proyectos";     // redirige a la lista
    }

    // Ver detalles de un proyecto
    //@GetMapping("/{id}")
    //public String verProyecto(@PathVariable String id, Model model) {
    //    model.addAttribute("proyecto", proyectoService.buscarPorId(id));
    //    return "proyectos/detalle";
    //}

    // Eliminar proyecto
    //@GetMapping("/eliminar/{id}")
    //public String eliminarProyecto(@PathVariable String id) {
    //    proyectoService.eliminar(id);
    //    return "redirect:/proyectos";
    //}

    @GetMapping
    public String menuProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.menuTodos());
        return "proyectos/menu";
    }

    @GetMapping("/consultar")
    public String consultarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.consultarTodos());
        return "proyectos/consultar"; // muestra la tabla con los proyectos
    }

    // ---------------------------
    // 🔹 NUEVO: Editar Proyecto
    // ---------------------------

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Proyecto proyecto = proyectoService.buscarPorId(id); // tu service debe tener este método
        model.addAttribute("proyecto", proyecto);
        return "proyectos/editar"; // la vista editar.html
    }

    // Guardar cambios del proyecto editado
    @PostMapping("/editar/{id}")
    public String guardarCambios(@PathVariable String id, @ModelAttribute Proyecto proyecto) {
        proyectoService.actualizar(id, proyecto); // tu service debe implementar esto
        return "redirect:/proyectos/consultar"; // vuelve a la tabla
    }
}
