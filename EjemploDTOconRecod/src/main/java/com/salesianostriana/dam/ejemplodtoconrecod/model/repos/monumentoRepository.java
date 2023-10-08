package com.salesianostriana.dam.ejemplodtoconrecod.model.repos;

import com.salesianostriana.dam.ejemplodtoconrecod.model.entities.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface monumentoRepository extends JpaRepository<Monumento, Long> {
}
