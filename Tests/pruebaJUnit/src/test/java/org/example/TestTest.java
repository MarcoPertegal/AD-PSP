package org.example;

import org.junit.jupiter.api.*;

public class TestTest {

    @BeforeAll
    static void initAll(){
        System.out.println("El primero");
    }

    @BeforeEach
    void init(){
        System.out.println("Antes de cada test");
    }

    //con esta anotacion podemos desactivar un test
    @Test
    @Disabled
    void testDisabled(){

    }
    @AfterEach
    static void tearDown(){
        System.out.println("Despues de cada test");
    }
    @AfterAll
    static void tearDownAll(){
        System.out.println("Al final de todo");
    }

}
