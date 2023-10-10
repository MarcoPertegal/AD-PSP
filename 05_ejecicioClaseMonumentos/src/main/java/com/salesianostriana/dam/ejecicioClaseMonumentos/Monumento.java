package com.salesianostriana.dam.ejecicioClaseMonumentos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {
    @Id
    @GeneratedValue
    private long id;
    private String countryCode, country, city, name, descrip, imageUrl, logitude, latitude;
}
