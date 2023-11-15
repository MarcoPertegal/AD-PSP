package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.controller;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.dto.EditProfesorDto;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error.ProfesorNotFoundException;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Profesor;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.service.ProfesorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping("/")
    public  ResponseEntity<Profesor> create(@Valid @RequestBody EditProfesorDto profesorDto){
        Profesor created = profesorService.save(profesorDto);

        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(createdURI).body(created);
    }

    @GetMapping("/{id}")
    public Profesor getProfesorById(@PathVariable Long id){
        return profesorService.getById(id);
    }
    @GetMapping("/")
    public ResponseEntity<List<Profesor>> getAll(){
        List<Profesor> result =  profesorService.getAll();
        return ResponseEntity.ok(result);

    }
}
