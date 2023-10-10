package com.salesianostriana.dam.ejemplorecordjsonviews.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.RutaView.*;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ruta {
    //debemos importar la clase view manualmente para asi poder marcar los
    //atributos con jsonview y ponerle los corchetes porque estamos pasando
    //un array de clases, es decir que multiples vistas van a poder tener el
    //campo id por ejemplo asi que creamos un array con los corchetes
    //en cada campo se coloca una anotacion indicando la lista a la que queremos
    //que pertenezca

    @JsonView({RutaList.class})
    @Id @GeneratedValue
    private Long id;

    @JsonView({RutaList.class, RutaEdit.class})
    private String nombre;

    @JsonView({RutaList.class, RutaEdit.class})
    private int tiempo; // en minutos

    @JsonView({RutaList.class, RutaEdit.class})
    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @JsonView({RutaList.class, RutaEdit.class})
    @OneToMany
    private List<Monumento> monumentos;
}
