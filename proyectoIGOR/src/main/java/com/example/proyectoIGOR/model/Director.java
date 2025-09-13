package com.example.proyectoIGOR.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document (collection="Director")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    private String id;

    private String nombre_completo;
    private String usuario;
    private String contrasena;
    private String rol;
    private String correo;
    private int no_documento;
    private int telefono;
    private String dirrecion;
    private LocalDateTime fecha_registro;
}

