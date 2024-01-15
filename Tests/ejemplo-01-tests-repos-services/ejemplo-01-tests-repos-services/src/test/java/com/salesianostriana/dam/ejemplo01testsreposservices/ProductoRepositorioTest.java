package com.salesianostriana.dam.ejemplo01testsreposservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class ProductoRepositorioTest {
    //la unidad de persistencia es un reflejo de la base de nuestra base de datos relacional
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProductoRepositorio repositorio;

    @Test
    void precioMenorQue(){
        Producto p1 = Producto.builder()
                .nombre("Producto 1")
                .precio(8)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Producto 2")
                .precio(10)
                .build();

        Producto p3 = Producto.builder()
                .nombre("Producto 3")
                .precio(12)
                .build();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);

        List<Producto> resultado = repositorio.findByPrecioLessThan(10);

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals(8, resultado.get(0).getPrecio());
        Assertions.assertEquals("Producto 1", resultado.get(0).getNombre());
    }
}
