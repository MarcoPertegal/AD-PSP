package com.salesianostriana.dam.ejemplodto.dto;

import com.salesianostriana.dam.ejemplodto.model.Monumento;
import lombok.Builder;
import lombok.Value;

//Value es una anotacion la cual genera getters setters equals hascode tostring y un contructor
//con todos los atributos, se usa para crear clases inmutables y ahorar codigo
@Value
@Builder
public class GetMonumentoDto {

    private Long id;

    private String nombre, localizacion, urlFoto, nombreCategoria;

    public static GetMonumentoDto of(Monumento monumento) {
        return GetMonumentoDto.builder()
                .id(monumento.getId())
                .nombre(monumento.getNombre())
                .localizacion(monumento.getLoc())
                .urlFoto(monumento.getUrlImagen())
                //.nombreCategoria(monumento.getCategoria().getNombre())
                //Si la categoria puede ser nula se hace así
                .nombreCategoria(
                        monumento.getCartegoria() != null
                                ? monumento.getCartegoria().getNombre()
                                : "Sin categoría"
                )
                .build();
    }

}
