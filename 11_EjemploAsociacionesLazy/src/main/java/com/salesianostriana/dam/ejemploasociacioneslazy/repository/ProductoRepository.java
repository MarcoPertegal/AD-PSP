package com.salesianostriana.dam.ejemploasociacioneslazy.repository;

import com.salesianostriana.dam.ejemploasociacioneslazy.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
