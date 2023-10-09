package com.salesianostriana.dam.ejemplodtoconrecod.controller;

import com.salesianostriana.dam.ejemplodtoconrecod.dto.GetRutaDto;
import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Ruta;
import com.salesianostriana.dam.ejemplodtoconrecod.model.repos.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {
    private final RutaRepository rutaRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetRutaDto>> todas() {

        List<Ruta> rutas = rutaRepository.findAll();

        if (rutas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }


        //transformacion a dtorecotd
        return ResponseEntity.ok(
                rutas.stream()
                        .map(GetRutaDto::of)
                        .toList()
        );

    }
}
