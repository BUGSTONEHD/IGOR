package com.example.proyectoIGOR.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    @Id
    private String id;

    private String usuario;
    private String contrasena;
    private String telefono;

    @Field("numero_proyectos")
    private int numeroProyectos;
    private String pagos;
}
