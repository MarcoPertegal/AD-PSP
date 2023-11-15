package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.dto;

import com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model.Profesor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditProfesorDto{
        @NotEmpty(message = "{editProductDto.name.notempty}")
        String nombre;
        @Email(message = "{editProductDto.email}")
        String email;
        @Min(value = 0, message = "{editProductDto.price.min}")
        double puntuacion;

    public static Profesor toProfesor(EditProfesorDto dto){
        return Profesor.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .puntuacion(dto.getPuntuacion())
                .build();

    }
}
