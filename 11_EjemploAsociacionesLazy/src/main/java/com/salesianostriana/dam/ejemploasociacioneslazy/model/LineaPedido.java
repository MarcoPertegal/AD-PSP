package com.salesianostriana.dam.ejemploasociacioneslazy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "linea_pedido")
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long codLinea;

    private double precioUnitario;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @OneToMany(mappedBy = "lineaPedido")
    private List<Pedido> listaPedidos = new ArrayList<>();

    public void addListaPedidos(Pedido p){
        p.setLineaPedido(this);
        this.listaPedidos.add(p);
    }

    public void removeProducto(Pedido p){
        this.listaPedidos.remove(p);
        p.setLineaPedido(null);
    }

}