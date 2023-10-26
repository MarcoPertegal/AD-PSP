package com.salesianostriana.dam.ejemploasociacionesbasedatos.repository;

import com.salesianostriana.dam.ejemploasociacionesbasedatos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
