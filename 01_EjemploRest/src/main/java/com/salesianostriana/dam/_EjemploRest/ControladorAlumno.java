package com.salesianostriana.dam._EjemploRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
//@RestControler = @Controller + @ResponseBody en cada metodo
public class ControladorAlumno {
    private final RepositorioAlumno repositorioAlumno;

    @GetMapping("/alumno/")
    public List<Alumno> getAll(){
        return repositorioAlumno.findAll();
    }

    @GetMapping("/alumno/{id}")
    public Alumno getById(@PathVariable int id){
        return repositorioAlumno.findById(id).orElse(null);
    }

    @PostMapping("/alumno/")
    public Alumno create (@RequestBody Alumno alumno){
        return repositorioAlumno.save(alumno);
    }

    @PutMapping("/alumno/{id}")
    public Alumno edit(@PathVariable int id, Alumno alumno){
        return repositorioAlumno.edit(alumno);
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Alumno> a = repositorioAlumno.findById(id);
        if (a.isPresent())
            repositorioAlumno.delete(a.get());
        return ResponseEntity.noContent().build();
    }
}
