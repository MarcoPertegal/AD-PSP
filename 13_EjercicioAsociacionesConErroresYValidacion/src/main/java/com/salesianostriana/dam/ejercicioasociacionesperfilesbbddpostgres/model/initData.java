package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class initData {

    @PostConstruct
    public void init(){
        Profesor p1 = Profesor.builder()
                .nombre("Juan")
                .email("juan@gmail.com")
                .puntuacion(20)
                .build();
    }
}
