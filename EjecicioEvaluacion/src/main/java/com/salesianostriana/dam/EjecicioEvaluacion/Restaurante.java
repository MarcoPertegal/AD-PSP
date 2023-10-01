package com.salesianostriana.dam.EjecicioEvaluacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurante {

    @GeneratedValue
    @Id
    private Long id;

    private String nombre, direccion, longitud, latitud, descripcion, imagen;
    private List listaTags = new ArrayList<String>();


}
