package com.salesianostriana.dam.ejemplorecordjsonviews.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.ejemplorecordjsonviews.dto.GetMonumentoDetailsDto;
import com.salesianostriana.dam.ejemplorecordjsonviews.dto.GetMonumentoDto;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Monumento;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.repos.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.MonumentoView.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    /*USANDO DTO
    @GetMapping("/")
    @JsonView(MonumentoList.class)
    public ResponseEntity<List<GetMonumentoDto>> todos() {

        List<Monumento> data = monumentoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();

        // Aquí hacemos la transformación de Monumento -> GetMonumentoDto
        List<GetMonumentoDto> result =
                data.stream()
                        .map(GetMonumentoDto::of)
                        .toList();

        return ResponseEntity.ok(result);

    }*/

    //USANDO JSONVIEW
    @GetMapping("/")
    @JsonView(MonumentoList.class)
    public ResponseEntity<List<Monumento>> todos() {
        List<Monumento> data = monumentoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(data);

    }

    /*USANDO DTO
    @GetMapping("/{id}")
    @JsonView(MonumentoId.class)
    public ResponseEntity<GetMonumentoDetailsDto> porId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(GetMonumentoDetailsDto::of));
    }*/

    //USANDO JSON VIEW
    @GetMapping("/{id}")
    @JsonView(MonumentoId.class)
    public ResponseEntity<Monumento> porId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

}
