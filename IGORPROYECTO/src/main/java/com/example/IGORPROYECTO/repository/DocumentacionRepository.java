package com.example.IGORPROYECTO.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.IGORPROYECTO.model.Documentacion;

public interface DocumentacionRepository extends MongoRepository<Documentacion, String> {
    // Buscar usuario por el campo "usuario"
   
}