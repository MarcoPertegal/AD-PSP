package com.salesianostriana.dam.EjecicioEvaluacion;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class RestauranteControlador {

    public final RestauranteRepositorio restauranteRepositorio;

    //como el metodo notFound no es un metodo teerminal hay que añadirle el builder
    //Es dcir cuando no hayamos llamado a .ok , .of , .body el resto lo necisita
    //como el retorno es un responseEntity y los metodos que no son los 3 de arraiba devielve
    //otras cosas da error
    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> getAll(){
        List<Restaurante> result = restauranteRepositorio.findAll();

        if (result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    //el .of recibe un opnional y devuelve 404 o 200 y find by id devuelve un optional
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getId(@PathVariable Long id){
        return ResponseEntity.of(restauranteRepositorio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Restaurante> create(@RequestBody Restaurante restaurante){
        return ResponseEntity.status(201).body(restauranteRepositorio.save(restaurante));
    }
    //metodo .map recibe una intancia de una interfaz funcional que se llama funtion(curso alan)
    //se usa para transformar un objeto en otro objeto o modificar el propio obejto
    //atiguo es el que ha encontrado el findbyid
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> edit(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return ResponseEntity.of(
                restauranteRepositorio.findById(id)
                        .map(antiguo -> {
                            antiguo.setNombre(restaurante.getNombre());
                            antiguo.setDireccion(restaurante.getDireccion());
                            antiguo.setDescripcion(restaurante.getDescripcion());
                            return restauranteRepositorio.save(antiguo);
                        })
        );
    }

    //Comprueba que no se repitan los tags
    //este metodo
    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Restaurante> addTag(@PathVariable Long id,
                                              @PathVariable String nuevo){
        return ResponseEntity.of(
                restauranteRepositorio.findById(id)
                        .map(place -> {
                            if (!place.getTags().contains(nuevo)) {
                                place.setTags(
                                        place.getTags() + ", " + nuevo);
                                return restauranteRepositorio.save(place);
                            }
                            return place;

                        })
        );
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Restaurante> deleteTag(@PathVariable Long id,
                                                 @PathVariable String deleteTag){
        return ResponseEntity.of();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurante> deleteByID(@PathVariable Long id){
       if (restauranteRepositorio.existsById(id))
            restauranteRepositorio.deleteById(id);

       return ResponseEntity.noContent().build();
    }

    //Refercia a metodos
    //es otra manera de escribir una lambda

}
