package com.example.IGORPROYECTO.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.IGORPROYECTO.model.Proyecto;
import com.example.IGORPROYECTO.repository.ProyectoRepository;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // Listar todos los proyectos
    public List<Proyecto> menuTodos() {
        return proyectoRepository.findAll();
    }

    // Crear un proyecto
    public Proyecto nuevo(Proyecto proyecto) {
        proyecto.setFechaCreacion(new Date());
        return proyectoRepository.save(proyecto);
    }

    // Consultar todos los proyectos
    public List<Proyecto> consultarTodos() {
        return proyectoRepository.findAll();
    }

    // Buscar proyecto por id (String porque Mongo usa String en @Id)
    public Proyecto buscarPorId(String id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    // Actualizar proyecto
    public Proyecto actualizar(String id, Proyecto proyectoActualizado) {
        return proyectoRepository.findById(id).map(proyecto -> {
            proyecto.setNombre(proyectoActualizado.getNombre());
            proyecto.setDescripcion(proyectoActualizado.getDescripcion());
            proyecto.setEstado(proyectoActualizado.getEstado());
            proyecto.setPrograma(proyectoActualizado.getPrograma());
            proyecto.setFechaInicio(proyectoActualizado.getFechaInicio());
            proyecto.setFechaFinal(proyectoActualizado.getFechaFinal());
            proyecto.setResponsable(proyectoActualizado.getResponsable());
            proyecto.setCliente(proyectoActualizado.getCliente());
            proyecto.setSerial(proyectoActualizado.getSerial());
            return proyectoRepository.save(proyecto);
        }).orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id: " + id));
    }
}