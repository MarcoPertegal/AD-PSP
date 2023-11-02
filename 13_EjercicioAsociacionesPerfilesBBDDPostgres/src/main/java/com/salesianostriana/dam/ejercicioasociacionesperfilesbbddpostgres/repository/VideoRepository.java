package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.repository;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
