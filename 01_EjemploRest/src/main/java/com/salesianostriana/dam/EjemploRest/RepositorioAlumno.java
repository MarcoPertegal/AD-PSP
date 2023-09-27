package com.salesianostriana.dam.EjemploRest;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositorioAlumno {

    private List<Alumno> alumnos;
    
    /*public RepositorioAlumno(List<Alumno> alumnos) {
        alumnos = new ArrayList<>();

        alumnos.add(
                Alumno.builder()
                        .id(1)
                        .nombre("pepe")
                        .apellidos("Gonzalez")
                        .edad(23)
                        .build()

        );
    }
    public Alumno save(Alumno a){
        alumnos.add(a);
        return a;
    }

    public Alumno edit(Alumno a){
        int pos;
        if ((pos = indexOf(a.getId())) == -1){
            return save(a);
        }else{
            return alumnos.set(pos, a);
        }
    }

    public void delete(Alumno a){
        int pos;
        if ((pos = indexOf(a.getId())) == -1){
            alumnos.remove(pos);
        }
    }

    public List<Alumno> findAll(){
        return (List<Alumno>) Collections.unmodifiableCollection(alumnos);
    }

    public Optional<Alumno> findById(int id){
        return alumnos.stream()
                .filter(alumno -> alumno.getId() == id)
                .findFirst();
    }

    private int indexOf(int id){
        int pos = -1;

        for (int i = 0; i < alumnos.size() && pos == -1; i++){
            if (alumnos.get(i).getId() == id)
                pos = i;
        }
        return pos;
    }*/
}
