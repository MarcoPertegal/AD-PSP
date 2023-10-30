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
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String imagen;
    private String descripcion;
    private double precio;
    private double precioOferta;
    @ElementCollection
    private List<String> tags;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<LineaPedido> listaLineaPedidos = new ArrayList<>();

    public void addLineaPedido(LineaPedido lP){
        lP.setProducto(this);
        this.listaLineaPedidos.add(lP);
    }

    public void removeLineaPedido(LineaPedido lP){
        this.listaLineaPedidos.remove(lP);
        lP.setProducto(null);

    }

}
