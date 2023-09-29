package com.salesianostriana.dam.ejecicioClaseMonumentos;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RestControler = @Controller + @ResponseBody en cada metodo
@RequestMapping("/monumento")
//para acortar las rutas
public class MonumentoControlador {

    private final MonumentoRepositorio monumentoRepositorio;


    //El notfound estabalece el codigo de respuesta 404 el buld se usa pq motFound no es terminal
    //En <> del response entity hay una lista de alumnos poruq ese lo que voya devolver
    @GetMapping("/")
    public ResponseEntity<List<Monumento>> getAll(){
        List<Monumento> result = monumentoRepositorio.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

    return ResponseEntity.ok(result);
    }

    //Response Entuty of solo funciona con optional por lo que aqui si se pyuede usar es abrebiar lo qiue se hace
    //en el metodo de arriba
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getId(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepositorio.findById(id));
    }

    //Se devuelve location null porque por regla deberiamos devolver la sruta donde de ha creado el nuevo alumno
    //Demomento se usa el numero de estatus de que se ha creado correctamente
    @PostMapping("/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento){
        Monumento nuevo = monumentoRepositorio.save(monumento);
        return ResponseEntity.status(201).body(nuevo);
    }

    //REquest body recoge el cuerpo de la peticion transformandolo de json a java
    //map permite aplicar una función dada a cada elemento de una colección y devolver una nueva colección con los resultado
    //El metodo of es un atajo de acer un if que devuelva 404 o 200 dependiendo de si encuentra o no
    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(monumentoRepositorio.existsById(id))
            monumentoRepositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
