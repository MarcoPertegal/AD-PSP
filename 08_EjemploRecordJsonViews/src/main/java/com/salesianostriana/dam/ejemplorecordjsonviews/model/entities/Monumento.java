package com.salesianostriana.dam.ejemplorecordjsonviews.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.MonumentoView.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monumento {

    @JsonView({MonumentoList.class})
    @Id @GeneratedValue
    private Long id;

    @JsonView({MonumentoList.class})
    private String nombre;

    @JsonView({MonumentoId.class})
    private String codigoPais;

    @JsonView({MonumentoId.class})
    private String pais;

    @JsonView({MonumentoList.class})
    private String ciudad;

    @JsonView({MonumentoList.class})
    private String loc;

    @JsonView({MonumentoId.class})
    private String descripcion;

    @JsonView({MonumentoList.class})
    @ElementCollection // Obligatoria en Spring Boot 2.
    private List<String> imagenes;

    @JsonView({MonumentoList.class})
    @ManyToOne
    private Categoria categoria;
}
