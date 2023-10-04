package controller;

import dto.ProductoDTO;
import lombok.RequiredArgsConstructor;
import modal.Producto;
import modal.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoRepository productoRepository;

    @GetMapping("/")
    public ResponseEntity<List<ProductoDTO>> getAll(){
        List<Producto> data = productoRepository.findAll();

        if (data.isEmpty())
            return ResponseEntity.notFound().build();
        List<ProductoDTO> result =
                data.stream()
                        .map(ProductoDTO::of)
                        .toList();
        return ResponseEntity.ok(result);
    }
}
