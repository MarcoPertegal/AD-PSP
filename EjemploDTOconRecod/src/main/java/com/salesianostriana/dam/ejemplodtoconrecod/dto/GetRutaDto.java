package com.salesianostriana.dam.ejemplodtoconrecod.dto;

import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Ruta;

import java.util.List;

public record GetRutaDto(
        Long id,
        String nombre,
        String dificultad,
        String tiempo,
        List<GetMonumentoDto> monumentos
) {
    public static GetRutaDto of (Ruta r)  {

        return new GetRutaDto(
                r.getId(),
                r.getNombre(),
                r.getDificultad().name(),
                Integer.toString(r.getTiempo()),
                r.getMonumentos()
                        .stream()
                        .map(GetMonumentoDto::of)
                        .toList()
        );


    }
}
