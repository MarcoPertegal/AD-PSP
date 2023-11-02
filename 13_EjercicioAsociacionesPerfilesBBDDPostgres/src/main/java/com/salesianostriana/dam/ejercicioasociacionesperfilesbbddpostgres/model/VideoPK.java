package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class VideoPK implements Serializable {
    private Curso curso;
    private Long codVideo;

    private VideoPK() { }
}
