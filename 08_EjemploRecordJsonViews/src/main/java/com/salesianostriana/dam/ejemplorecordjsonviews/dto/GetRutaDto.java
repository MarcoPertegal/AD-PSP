package com.salesianostriana.dam.ejemplorecordjsonviews.dto;

import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Ruta;

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
