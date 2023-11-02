package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.repository;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
