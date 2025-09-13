package com.example.proyectoIGOR.model;
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

@Document (collection=("Trabajador"))
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trabajador {
    @Id
    private String id;

    private String usuario;
    private String trabajador;
    private String proyecto;
    private int tareas_completadas;
    private int tareas_pendientes;
    private float  puntualidad;
}
