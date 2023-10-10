package dto;

import lombok.Builder;
import lombok.Value;
import modal.Producto;

@Value
@Builder
public class ProductoDTO {

    private Long id;

    private String nombre, imagen, nombreCategoria;
    private double pvp;

    public static ProductoDTO of(Producto producto){
        return ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .imagen(producto.getImagen().toString())
                .nombreCategoria(producto.getCategoria().toString())
                .pvp(producto.getPvp())
                .nombreCategoria(
                    producto.getCategoria() != null
                        ? producto.getCategoria().getNombre()
                            : "Sin cateogira"
                )
                .build();
    }
}
