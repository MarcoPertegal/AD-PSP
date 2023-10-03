package com.salesianostriana.dam.ejemplodto.controller;

import com.salesianostriana.dam.ejemplodto.dto.GetMonumentoDto;
import com.salesianostriana.dam.ejemplodto.model.Monumento;
import lombok.RequiredArgsConstructor;
import com.salesianostriana.dam.ejemplodto.model.MonumentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/monumento")
    @RequiredArgsConstructor
    public class
    MonumentoController {

        private final MonumentoRepository monumentoRepository;

        @GetMapping("/")
        public ResponseEntity<List<GetMonumentoDto>> getAll() {

            List<Monumento> data = monumentoRepository.findAll();

            if (data.isEmpty())
                return ResponseEntity.notFound().build();

            // Aquí hacemos la transformación de Monumento -> GetMonumentoDto
            //De esta
            List<GetMonumentoDto> result =
                    //Convierte la lista data en un flujo (stream) de elementos
                    data.stream()
                            //aplica una función de mapeo GetMonumentoDto::of a cada elemento del flujo.
                            //toma el objeto monumento y lo transforma en gentMonumentoDto
                            .map(GetMonumentoDto::of)
                            //Vuelve a convertirlo en una lista
                            .toList();

            return ResponseEntity.ok(result);

        }

    }

