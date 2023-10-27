package com.salesianostriana.dam.ejemploasociacionesbasedatos.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    //Helpers faltan alguno
    public void addToCurso(Curso curso){
        this.curso = curso;
        curso.getAlumnos().add(this);
    }


}
