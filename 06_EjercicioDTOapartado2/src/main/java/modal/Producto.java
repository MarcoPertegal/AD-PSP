package modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, desc;
    private double pvp;
    private List <String> imagen;

    @ManyToOne
    private Categoria categoria;


}
