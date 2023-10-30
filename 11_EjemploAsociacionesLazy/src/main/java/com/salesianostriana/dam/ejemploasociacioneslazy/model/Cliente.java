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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String pin;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> listaPedidos = new ArrayList<>();

    public void addListaPedidos(Pedido p){
        p.setCliente(this);
        this.listaPedidos.add(p);
    }

    public void removeProducto(Pedido p){
        this.listaPedidos.remove(p);
        p.setCliente(null);
    }

}