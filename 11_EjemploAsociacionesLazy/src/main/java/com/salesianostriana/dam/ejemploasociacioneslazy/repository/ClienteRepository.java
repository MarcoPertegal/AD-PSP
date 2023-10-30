package com.salesianostriana.dam.ejemploasociacioneslazy.repository;

import com.salesianostriana.dam.ejemploasociacioneslazy.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
