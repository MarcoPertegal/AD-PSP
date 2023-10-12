package com.salesianostriana.dam.ejemplorecordjsonviews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.ejemplorecordjsonviews.dto.EditRutaDto;
import com.salesianostriana.dam.ejemplorecordjsonviews.dto.GetRutaDto;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Ruta;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.repos.RutaRepository;
import com.salesianostriana.dam.ejemplorecordjsonviews.sevice.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.RutaView.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
@RequiredArgsConstructor
public class RutaController {
    private final RutaRepository rutaRepository;

    private final RutaService rutaService;

    //para vinular las listas se usa jsonview he importarlas
    //igual que con la entidad
    /*CON DTO
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

    }*/

    //CON JSON VIEW
    @GetMapping("/")
    @JsonView(RutaList.class)
    public ResponseEntity<List<Ruta>> todas() {

        List<Ruta> rutas = rutaRepository.findAll();

        if (rutas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rutas);

    }

    /*CON DTO
    @PostMapping("/")
    public ResponseEntity<GetRutaDto> nuevaRuta(
            @RequestBody EditRutaDto nuevo) {

        Ruta ruta = rutaService.save(nuevo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GetRutaDto.of(ruta));

    }*/

    //CON JSON VIEW
    @PostMapping("/")
    @JsonView(RutaEdit.class)
    public ResponseEntity<Ruta> nuevaRuta(
            @RequestBody EditRutaDto nuevo) {

        Ruta ruta = rutaService.save(nuevo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ruta);

    }
}
