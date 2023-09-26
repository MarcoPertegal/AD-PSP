package com.salesianostriana.dam._EjemploRest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    private int id;
    private String nombre, apellidos, email;
    private int edad;

}
