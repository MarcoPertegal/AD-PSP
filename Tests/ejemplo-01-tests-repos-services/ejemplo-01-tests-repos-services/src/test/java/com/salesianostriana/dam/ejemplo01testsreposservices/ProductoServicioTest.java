package com.salesianostriana.dam.ejemplo01testsreposservices;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductoServicioTest {
    //mock crea un doble no va a instanciar la clase deberda sino que escanea el codigo y crea un doble
    @Mock
    ProductoRepositorio repositorio;
    //Esta se instancia de verda pero sus dependencias que tenga van a ser de mentira en este caso el repositorio
    //si dependiera del repositorio y de dos servicios mas baria que mockear esos servicos tambie
    @InjectMocks
    ProductoServicio productoServicio;

    @Test
    void precioMenorQue10yDisponible() {

        List<Producto> data = List.of(
                new Producto(1L, 3, "Producto 1", false),
                new Producto(2L, 11, "Producto 2", true),
                new Producto(3L, 3, "Producto 3", true)
        );

        Mockito.when(repositorio.findAll()).thenReturn(data);
        //este debe ser el resultado que debe devolver el test
        /*
        GetProductoDto expectedResult = List.of(GetProductoDto.builder()
                .id(3L)
                .nombre("Producto3")
                .build());
        List<GetProductoDto> result = productoServicio.precioMenorQue10yDisponible();

        //debe devolver una lista de tamaño uno
        //assertEquals(expectedResult, result);
        assertEquals(1, result.size());
        */
    }
}