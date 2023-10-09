package com.salesianostriana.dam.ejemplodtoconrecod.model.entities;

import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Categoria;
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
public class Monumento {
    @Id @GeneratedValue
    private Long id;

    private String codigoPais, pais, ciudad,
            loc, nombre, descripcion;

    @ElementCollection // Obligatoria en Spring Boot 2.
    private List<String> imagenes;

    @ManyToOne
    private Categoria categoria;
}
