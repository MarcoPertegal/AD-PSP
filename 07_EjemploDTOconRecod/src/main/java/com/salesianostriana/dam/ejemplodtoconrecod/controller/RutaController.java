package com.salesianostriana.dam.ejemplodtoconrecod.controller;

import com.salesianostriana.dam.ejemplodtoconrecod.dto.EditRutaDto;
import com.salesianostriana.dam.ejemplodtoconrecod.dto.GetRutaDto;
import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Ruta;
import com.salesianostriana.dam.ejemplodtoconrecod.model.repos.RutaRepository;
import com.salesianostriana.dam.ejemplodtoconrecod.sevice.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {
    private final RutaRepository rutaRepository;

    private final RutaService rutaService;

    @GetMapping("/")
    public ResponseEntity<List<GetRutaDto>> todas() {

        List<Ruta> rutas = rutaRepository.findAll();

        if (rutas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                rutas.stream()
                        .map(GetRutaDto::of)
                        .toList()
        );

    }

    @PostMapping("/")
    public ResponseEntity<GetRutaDto> nuevaRuta(
            @RequestBody EditRutaDto nuevo) {

        Ruta ruta = rutaService.save(nuevo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GetRutaDto.of(ruta));

    }
}
