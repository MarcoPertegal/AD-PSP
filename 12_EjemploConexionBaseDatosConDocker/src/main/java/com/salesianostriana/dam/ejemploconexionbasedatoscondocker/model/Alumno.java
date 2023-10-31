package com.salesianostriana.dam.ejemploconexionbasedatoscondocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
}
