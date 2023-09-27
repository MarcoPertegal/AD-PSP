package com.salesianostriana.dam.ejecicioClaseMonumentos;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentoControlador {

    private final MonumentoRepositorio monumentoRepositorio;

    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> getAll(){
        List<Monumento> result = monumentoRepositorio.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

    return ResponseEntity.ok(result);
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> getId(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepositorio.findById(id));
    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento){
        Monumento nuevo = monumentoRepositorio.save(monumento);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id, @RequestBody Monumento monumento){
        return ResponseEntity.of(monumentoRepositorio.findById(id)
                .map(antiguo -> {
                        antiguo.setName(monumento.getName());
                        antiguo.setDescrip(monumento.getDescrip());
                        antiguo.setCity(monumento.getCity());
                        antiguo.setLatitude(monumento.getLatitude());
                        antiguo.setLogitude(monumento.getLogitude());
                        return monumentoRepositorio.save(antiguo);
                }));
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(monumentoRepositorio.existsById(id))
            monumentoRepositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }



}
