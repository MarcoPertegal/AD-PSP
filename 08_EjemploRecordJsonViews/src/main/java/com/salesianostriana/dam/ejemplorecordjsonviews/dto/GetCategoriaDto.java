package com.salesianostriana.dam.ejemplorecordjsonviews.dto;


import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Categoria;

public record GetCategoriaDto(
        Long id,
        String nombreCategoria
) {
    public static GetCategoriaDto of (Categoria c) {
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }
}
