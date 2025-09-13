package com.example.proyectoIGOR.repository;

import com.example.proyectoIGOR.model.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProyectoRepository extends MongoRepository<Proyecto, String> {
    // Aquí podrías crear métodos personalizados si quieres
}
