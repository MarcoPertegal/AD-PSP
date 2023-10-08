package com.salesianostriana.dam.ejemplodtoconrecod.model.repos;

import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriaRepository extends JpaRepository<Ruta, Long> {
}
