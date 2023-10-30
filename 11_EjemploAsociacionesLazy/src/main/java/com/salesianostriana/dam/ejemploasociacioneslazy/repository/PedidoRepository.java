package com.salesianostriana.dam.ejemploasociacioneslazy.repository;


import com.salesianostriana.dam.ejemploasociacioneslazy.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
