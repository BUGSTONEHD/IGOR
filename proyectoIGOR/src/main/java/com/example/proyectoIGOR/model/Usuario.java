package com.example.proyectoIGOR.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String id; // Mongo usa String para el _id // Esta bien pe

    private String nombre;

    private String correo;

    private String contraseña;

    private int edad;

    private String rol;
}