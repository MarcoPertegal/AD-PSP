package com.salesianostriana.dam._ejemploopenapi.controller;

import com.salesianostriana.dam._ejemploopenapi.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/*
Con el tag explicamos la clase y con operation el metodo summary descripcion corta
ApiResponses los estatus que devuelve cada estado que devuelve se anota con
ApiResponse y dentro iría toda la info sobre ello
Si el metodo recibiese un parametro también habría que indicarlo
con @Hidden se pueden excluir clases de la documentacion
 */
@RestController
@RequestMapping("/api")
@Tag(name="Employee", description = "Employee Api Rest with CRUD operations")
public class EmployeeController {

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Return employees",  content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Employee.class)))})
    })
    @Operation(summary = "Find all employees", description = "It returns all employees")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        //meter datos
        return ResponseEntity.ok(List.of(
                new Employee(1L, "emp1", LocalDate.of(1990, 1, 1), 40000, true),
                new Employee(1L, "emp1", LocalDate.of(1990, 1, 1), 40000, true),
                new Employee(1L, "emp1", LocalDate.of(1990, 1, 1), 40000, true)
        ));
    }
}
