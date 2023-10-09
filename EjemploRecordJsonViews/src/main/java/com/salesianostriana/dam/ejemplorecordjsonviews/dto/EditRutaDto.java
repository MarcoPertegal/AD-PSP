package com.salesianostriana.dam.ejemplorecordjsonviews.dto;

import java.util.List;

public record EditRutaDto(
        String nombre,
        int duracion,
        String dificultad,
        List<Long> monumentos) {


}