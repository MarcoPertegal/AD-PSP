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
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> listaProductos = new ArrayList<>();

    public void addProducto(Producto p){
        p.setCategoria(this);
        this.listaProductos.add(p);
    }

    public void removeProducto(Producto p){
        this.listaProductos.remove(p);
        p.setCategoria(null);

    }

}