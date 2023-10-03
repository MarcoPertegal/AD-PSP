package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais, pais, ciudad, region;

    @ManyToOne
    private Categoria cartegoria;
}
