package com.salesianostriana.dam.ejemplo01testsreposservices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioLessThan(int precio);
}
