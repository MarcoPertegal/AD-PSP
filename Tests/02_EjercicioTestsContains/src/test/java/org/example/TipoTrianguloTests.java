package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TipoTrianguloTests {
    Triangulo t;

    @BeforeEach
    void setUp(){
        t = new Triangulo();
    }

    @AfterEach
    void tearDown(){
        t = null;
    }

    @ParameterizedTest
    @MethodSource("generatedTriangles")
    void testTipoTriangulo(int a, int b, int c, TipoTriangulo tT){
        assertEquals(tT, t.tipoDeTriangulo(a,b,c));
    }
    static Stream<Arguments> generatedTriangles(){
        return Stream.of(
                Arguments.arguments(3,3,1,TipoTriangulo.ISOSCELES),
                Arguments.arguments(3,3,3,TipoTriangulo.EQUILATERO),
                Arguments.arguments(3,2,1,TipoTriangulo.ESCALENO),
                Arguments.arguments(-1,0,3,TipoTriangulo.NOESUNTRIANGULO)

        );
    }
}
