package com.salesianostriana.dam.ejemploasociacionesbasedatos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Alumno {

    @Id
    @GeneratedValue
            (strategy= GenerationType.AUTO)
    private long id;

    private String nombre;
    private String apellidos;
    private String email;

    @ManyToOne
    private Curso curso;



}
