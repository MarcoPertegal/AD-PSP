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
    //usamos los tags como String o array nomral porque aunque en springboot 6 funciona con arraylist
    //en springboot 5 no acepta arraylist amenos que usemos una anotacion
    private String nombre, direccion, longitud, latitud, descripcion, imagen, tags;

}
