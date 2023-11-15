package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.service;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error.ProfesorNotFoundException;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Profesor;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public Profesor create (Profesor nuevo){
        Profesor p = new Profesor();
        p.setNombre(nuevo.getNombre());
        p.setEmail(nuevo.getEmail());
        p.setPuntuacion(nuevo.getPuntuacion());
        return profesorRepository.save(p);
    }
    public Profesor getById(Long id){
        return profesorRepository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException(id));
    }
    public List<Profesor> getAll(){
        return profesorRepository.findAll();
    }
}
