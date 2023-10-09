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

    }

    @GetMapping("/{id}")
    @JsonView(MonumentoId.class)
    public ResponseEntity<GetMonumentoDetailsDto> porId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(GetMonumentoDetailsDto::of));
    }

}
