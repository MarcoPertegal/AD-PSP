package com.salesianostriana.dam.ejemplodtoconrecod.dto;

import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Categoria;

public record GetCategoriaDto(Long id, String nombreCategoria) {


    public static GetCategoriaDto of (Categoria c) {
        return new GetCategoriaDto(
                c.getId(),
                c.getNombre()
        );
    }
}
