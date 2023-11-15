package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
