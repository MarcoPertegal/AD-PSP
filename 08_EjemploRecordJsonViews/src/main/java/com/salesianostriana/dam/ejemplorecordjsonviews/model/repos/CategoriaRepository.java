package com.salesianostriana.dam.ejemplorecordjsonviews.model.repos;

import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
