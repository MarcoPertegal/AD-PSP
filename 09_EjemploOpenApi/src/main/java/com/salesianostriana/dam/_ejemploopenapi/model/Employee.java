package com.salesianostriana.dam._ejemploopenapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    //Con schema podemos documentar un atributo: descripcion del campo, un valor de ejemplo, etc
    @Schema(example = "4", description = "Identificador clave primaria empleado numerico autoincrementado")
    private Long id;

    @Schema(example = "Marco", description = "Nombre completo empleado")
    private String name;

    @Schema(example = "2022-03-05", description = "Nacimiento yyyy-MM-dd")
    private LocalDate birthDate;

    @Schema(example = "34432.50", description = "Salario actual bruto")
    private double salary;

    @Schema(example = "true", description = "Situacion casado")
    private boolean married;
}
