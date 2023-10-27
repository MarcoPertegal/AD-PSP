package com.salesianostriana.dam.ejemploasociacionesbasedatos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Curso {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nombre;
    private String tutor;

    @ToString.Exclude
    @OneToMany(mappedBy = "curso")
    @Builder.Default
    private List<Alumno> alumnos = new ArrayList<>();

}

