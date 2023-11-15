package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.error;

public class ProfesorNotFoundException extends RuntimeException{
    public ProfesorNotFoundException(Long id) {
        super("Profesor with id: "+ id+" not found");
    }
}
