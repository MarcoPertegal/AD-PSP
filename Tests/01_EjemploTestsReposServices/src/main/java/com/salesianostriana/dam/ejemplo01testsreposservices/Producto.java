package com.salesianostriana.dam.ejemplo01testsreposservices;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private double precio;
    private String nombre;
    private boolean disponible;

}
