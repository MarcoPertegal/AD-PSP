package com.salesianostriana.dam.EjecicioEvaluacion;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    //el .of recibe un optional y devuelve 404 o 200 y find by id devuelve un optional
    //Por lo que se usan juntos
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getId(@PathVariable Long id){
        return ResponseEntity.of(restauranteRepositorio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Restaurante> create(@RequestBody Restaurante restaurante){
        return ResponseEntity.status(201).body(restauranteRepositorio.save(restaurante));
    }
    //metodo .map recibe una intancia de una interfaz funcional que se llama funtion(curso alan)
    //se usa para transformar un objeto en otro objeto o modificar el propio objeto
    //antiguo es el objeto que ha encontrado el findbyid
    //En este metodo a antiguo se le setean los datos y se guarda de nuevo con los nuevos datos que
    //vienen del obejto restaurante que se le pasa en los parametros al metodo
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
    //Como los tags son un mismo string separados por coma
    //EL metodo contains comprueba si la cadena "nuevo" ya se encuentra dentro del string, si no entra
    //después lo setea cogiendo los caracteres existentes y agregandole la coma y el nuevo atrás
    //por ultimo guarda de nuevo el objeto encontrado con el atributo tags modificado
    //Siempre que se edite o se cree se usa el método save para volver a guardar
    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Restaurante> addTag(@PathVariable Long id, @PathVariable String nuevo){
        return ResponseEntity.of(
                restauranteRepositorio.findById(id)
                        .map(Restaurante -> {
                            if (!Restaurante.getTags().contains(nuevo)) {
                                Restaurante.setTags(Restaurante.getTags() + ", " + nuevo);
                                return restauranteRepositorio.save(Restaurante);
                            }
                            return Restaurante;

                        })
        );
    }

    //el metodo noContent devuelve un 204 indica que la solicitud se ha procesado con éxito, pero no hay contenido
    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurante> deleteById(@PathVariable Long id){
       if (restauranteRepositorio.existsById(id))
            restauranteRepositorio.deleteById(id);

       return ResponseEntity.noContent().build();
    }

    //este metodo elimina dentro de el string tags del objeto encontrado la palabra que coincida
    //con el string eliminar el metodo replace reemplaza el primer argumento por el segundo dado
    @PutMapping("/{id}/tag/del/{eliminar}")
    public ResponseEntity<Restaurante> deleteTag(@PathVariable Long id, @PathVariable String eliminar){
        return ResponseEntity.of(
                restauranteRepositorio.findById(id)
                        .map(restaurante -> {
                            if (restaurante.getTags().contains(eliminar)){
                                String tags = restaurante.getTags();
                                tags.replace(eliminar,"");
                                tags.replace(",,", ",");
                                //Si se elimina la ultima palabra del String se queda una coma suelta
                                //esto comprueba y si es asi se elimina
                                if (tags.endsWith(","))
                                    tags = tags.substring(0, tags.length()-1);

                                //se vuelve a setear los nuevos tags
                                restaurante.setTags(tags);

                                return restauranteRepositorio.save(restaurante);
                            }

                            return restaurante;
                        })
        );
    }

    //Refercia a metodos
    //es otra manera de escribir una lambda
    //VERSION PRO de borrar un tag
    public ResponseEntity<Restaurante> delTagV2(@PathVariable Long id, @PathVariable String eliminar) {
        return ResponseEntity.of(
                restauranteRepositorio.findById(id)
                        .map(restaurante -> {

                            String tags = restaurante.getTags();

                            tags = Arrays.stream(tags.split(","))
                                    .map(String::trim)
                                    .filter(t -> !t.equalsIgnoreCase(eliminar))
                                    .collect(Collectors.joining(","));

                            restaurante.setTags(tags);

                            return restauranteRepositorio.save(restaurante);


                        })
        );


    }

}


