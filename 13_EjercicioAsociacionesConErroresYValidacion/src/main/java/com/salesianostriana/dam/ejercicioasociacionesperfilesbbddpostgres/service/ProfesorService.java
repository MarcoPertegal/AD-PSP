package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.service;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.dto.EditProfesorDto;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error.ProfesorNotFoundException;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Profesor;
import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.repository.ProfesorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public Profesor save(EditProfesorDto editProfesorDto){
        return profesorRepository.save(editProfesorDto.toProfesor(editProfesorDto));
    }
    public Profesor getById(Long id){
        return profesorRepository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException(id));
    }
    public List<Profesor> getAll(){
        return profesorRepository.findAll();
    }
}
