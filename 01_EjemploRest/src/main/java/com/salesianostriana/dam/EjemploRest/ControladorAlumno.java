package com.salesianostriana.dam.EjemploRest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
//@RestControler = @Controller + @ResponseBody en cada metodo
public class ControladorAlumno {
    private final AlumnoRepositorio alumnoRepositorio;

    //El notfound estabalece el codigo de respuesta 404 el buld se usa pq motFound no es terminal
    //En <> del response entity hay una lista de alumnos poruq ese lo que voya devolver
    @GetMapping("/alumno/")
    public List<Alumno> getAll(){
        return alumnoRepositorio.findAll();
    }

    //Response Entuty of solo funciona con optional por lo que aqui si se pyuede usar es abrebiar lo qiue se hace
    //en el metodo de arriba
    @GetMapping("/alumno/{id}")
    public Alumno getById(@PathVariable long id){
        return alumnoRepositorio.findById(id).orElse(null);
    }

    //Se devuelve location null porque por regla deberiamos devolver la sruta donde de ha creado el nuevo alumno
    //Demomento se usa el numero de estatus de que se ha creado correctamente
    @PostMapping("/alumno/")
    public Alumno create (@RequestBody Alumno alumno){
        return alumnoRepositorio.save(alumno);
    }

    //REquest body recoge el cuerpo de la peticion transformandolo de json a java
    //map permite aplicar una función dada a cada elemento de una colección y devolver una nueva colección con los resultado
    //El metodo of es un atajo de acer un if que devuelva 404 o 200 dependiendo de si encuentra o no
    @PutMapping("/alumno/{id}")
    public Alumno edit(@PathVariable long id, Alumno alumno){
        return alumnoRepositorio.edit(alumno);
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Optional<Alumno> a = alumnoRepositorio.findById(id);
        if (a.isPresent())
            alumnoRepositorio.delete(a.get());
        return ResponseEntity.noContent().build();
    }
}
