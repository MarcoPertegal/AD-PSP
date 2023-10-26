package com.salesianostriana.dam.ejemploasociacionesbasedatos.model;

import com.salesianostriana.dam.ejemploasociacionesbasedatos.repository.AlumnoRepository;
import com.salesianostriana.dam.ejemploasociacionesbasedatos.repository.CursoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    @PostConstruct
    public void init(){
        Curso c1 = Curso.builder()
                .nombre("a")
                .tutor("a")
                .build();

        cursoRepository.save(c1);

        Alumno a1 = Alumno.builder()
                .nombre("b")
                .apellidos("b")
                .email("b@.com")
                .curso(c1)
                .build();

        Alumno a2 = Alumno.builder()
                .nombre("c")
                .apellidos("c")
                .email("c@.com")
                .curso(c1)
                .build();
        alumnoRepository.save(a1);
        alumnoRepository.save(a2);
        /*
        c1.setAlumnos(List.of(a1));

        cursoRepository.save(c1);*/
    }
}
