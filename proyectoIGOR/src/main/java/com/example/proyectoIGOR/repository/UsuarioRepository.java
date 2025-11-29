package com.example.proyectoIGOR.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.proyectoIGOR.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    // Si quieres, puedes definir métodos extra como:
    // Optional<Usuario> findByCorreo(String correo);
}
