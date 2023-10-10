package com.salesianostriana.dam.ejemplorecordjsonviews.model.repos;

import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
