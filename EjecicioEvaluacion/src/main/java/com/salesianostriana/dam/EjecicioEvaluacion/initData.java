package com.salesianostriana.dam.EjecicioEvaluacion;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class initData {
    //Esta calse sirbe para insertar datos de ejemplo
    // COMO insertar datos de ejemplo
    private final  RestauranteRepositorio restauranteRepositorio;

    @PostConstruct
    public void init(){
        //insertar datos ejemplo
    }
}
