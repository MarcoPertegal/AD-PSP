package com.salesianostriana.dam.EjecicioEvaluacion;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/place")
public class RestauranteControlador {

    public final RestauranteRepositorio restauranteRepositorio;

    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> getAll(){
        List<Restaurante> resultado = restauranteRepositorio.findAll();

        if (resultado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getId(@PathVariable Long id){
        return ResponseEntity.of(restauranteRepositorio.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Restaurante> create(@RequestBody Restaurante restaurante){
        Restaurante nuevo = restauranteRepositorio.save(restaurante);
        return ResponseEntity.status(201).body(nuevo);
    }

    //Creo que abria que usar @RequestMapping para no repetir ID pero no recuerdo
    //como hacerlo dentro de la clase
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> edit(@PathVariable Long id, @RequestBody Restaurante restaurante){
        return ResponseEntity.of
    }

    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Restaurante> addTag(@PathVariable Long id){
        return
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Restaurante> deleteTag(@PathVariable Long id,
                                                 @PathVariable String deleteTag){
        return ResponseEntity.of();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurante> delete(@PathVariable Long id){
       if (restauranteRepositorio.existsById(id))
            restauranteRepositorio.deleteById(id);

       return ResponseEntity.noContent();
    }


}
