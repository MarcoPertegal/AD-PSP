package com.salesianostriana.dam.ejemploasociacioneslazy.model;

import com.salesianostriana.dam.ejemploasociacioneslazy.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class initData {

    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;
    private final LineaPedidoRepository lineaPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void init(){
        Categoria c1 = Categoria.builder()
                .nombre("Ropa")
                .build();


    }
}
