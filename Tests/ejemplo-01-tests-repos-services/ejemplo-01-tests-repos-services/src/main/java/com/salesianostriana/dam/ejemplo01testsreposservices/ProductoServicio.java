package com.salesianostriana.dam.ejemplo01testsreposservices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicio {

    private final ProductoRepositorio repositorio;

    //siempre para dar de alta usamos un dtos aunque aqui no lo hagamos
    //hay algunos metodos que no merewcen la pena ser testeado, solo los servicios que tengancierto
    //procesamiento son los que merece la pena testear
    public Producto save(Producto p){
        return repositorio.save(p);
    }

    public List<Producto> saveAll(List<Producto> p){
        return repositorio.saveAll(p);
    }

    public List<Producto> findAll(){
        return repositorio.findAll();
    }

    public List<Producto> precioMenorQue10(){
        return repositorio.findByPrecioLessThan(10);
    }

    public List<GetProductoDto> precioMenorQue10yDisponible(){
        List<Producto> todos = repositorio.findAll();

        List<GetProductoDto> resultado = new ArrayList<>();

        for (Producto p: todos) {
            if (p.getPrecio()<10){
                if (p.isDisponible()){
                    resultado.add(GetProductoDto.of(p));
                }
            }
        }
        if ()
    }
}
