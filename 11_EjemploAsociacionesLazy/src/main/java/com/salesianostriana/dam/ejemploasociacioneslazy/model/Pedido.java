package com.salesianostriana.dam.ejemploasociacioneslazy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "linea_pedido_id")
    private LineaPedido lineaPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}