package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    //para no importar assertions todo el rato se puede hacer un import statico
    //la forma buena de probarlo es mvn test
    //cada vez que compilemos la aplicacion los test unitarios se van a ejecutar lo suyo es que se
    // esten pasando todo el rato para comprobar que todo funciona correctamene
    //cuando el noimbre descriptivo del metodo se hace muy largo se puede usar display name
    //los test tienen un ciclo de vida para ello usamos @BeforeAll y @AfterAll,beforeEach y AfterEach
    @Test
    @DisplayName("1+1=2")
    void sumarDosNumeros(){
        Calculadora c = new Calculadora();
        int esperado = 2;
        assertEquals(esperado, c.sumar(1, 1));
    }


}
