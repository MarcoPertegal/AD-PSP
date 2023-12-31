package com.salesianostriana.dam.ejemplodtoconrecod.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ruta {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private int tiempo; // en minutos

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @OneToMany
    private List<Monumento> monumentos;
}
