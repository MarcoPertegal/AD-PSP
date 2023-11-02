package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.repository;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
