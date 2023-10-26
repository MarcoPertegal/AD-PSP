package com.salesianostriana.dam.ejemploasociacionesbasedatos.model;

import jakarta.persistence.*;
import lombok.*;

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
    /*
    @OneToMany(mappedBy="curso")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Alumno> alumnos;
    */
}

