package com.example.proyectoIGOR.model;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document (collection=("Supervisor"))
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Supervisor {
    @Id
    private String id;

    private String nombre_completo;
    private String usuario;
    private String contrasena;
    private int proyectos_asignados;
}
