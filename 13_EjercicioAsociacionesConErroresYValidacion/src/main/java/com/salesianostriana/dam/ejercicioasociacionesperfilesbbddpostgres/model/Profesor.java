package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private double puntuacion;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> listCursos = new ArrayList<>();

}
