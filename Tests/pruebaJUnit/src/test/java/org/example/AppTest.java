package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //los metodos asset comprueban que se cumple algo, es una especie de comprobacion if
    //TEST Basados en la tabla de los apuntes
    //con removeAll se eliminan todos los elementos de la lista que coincidan con la lista c
    //realizar un test si se cumple una condicion usamos asumptions es como un if para que se realicce el test si se cumpl euna condicon


    //para no instanciar el hashset todo el rato
    HashSet<Integer> hs;
    List<Integer> c;

    @BeforeEach
    void setUp(){
        hs = new HashSet<>();
        c = new ArrayList<>();
    }
    @AfterEach
    void tearDown(){
        hs = null;
        c = null;
    }

    @Test
    void hashSetSizeLessThanCollectionSize(){
        //solo queda el valor 4
        hs.addAll(List.of(1,2,3,4,5));
        c.addAll(List.of(1,2,3,4,5,5,6));

        assertTrue(hs.removeAll(c));
        assertEquals(1, hs.size());
        assertTrue(hs.contains(4));
    }

    @Test
    void hashSetSizeGreaterThanCollectionSize(){
        //solo queda el valor 4
        hs.addAll(List.of(1,2,3,5,6,7,8));
        c.addAll(List.of(1,2,3,4,5));

        assertTrue(hs.removeAll(c));
        assertEquals(3, hs.size());
    }


    //cuando los test tienen el mismo cuerpo se puede variar el valor de los parametros, para no reescribir codigo
    @ParameterizedTest
    @CsvSource({
        "1,1,2",
        "0,1,1"
    })
    void sumarDosNuemrosPArametrizado(int a, int b, int resultado){
        Calculadora c = new Calculadora();
        assertEquals(resultado, c.sumar(a,b));
    }

    //Para pasar varios parametros a un mismo test
    @ParameterizedTest
    @MethodSource("generateCollectionsWithElements")
    void testWhenBothCollectionsAreNotNull(List<Integer>a, List<Integer>b,boolean expectedResult,  int sizeResult){
        hs.addAll(a);
        c.addAll(b);
        assertEquals(expectedResult, hs.removeAll(c));
        assertEquals(sizeResult, hs.size());
    }
    static Stream<Arguments> generateCollectionsWithElements(){
        return Stream.of(
                arguments(List.of(1,2,3,4), List.of(1,2,3,5,6,7,8),true, 1),
                arguments(List.of(1,2,3,5,6,7,8), List.of(1,2,3,4),true, 4),
                arguments(List.of(), List.of(1), false, 0),
                arguments(List.of(1,2,3,4),List.of(), false, 4)
        );
    }

    @Test
    static void test1(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        Collection<Integer> c = Collections.emptyList();

        assertFalse(hs.removeAll(c));
        assertEquals(5, hs.size());
    }

    @Test
    void test2(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        List<Integer> c = List.of(1);

        assertTrue(hs.removeAll(c));
        assertEquals(4, hs.size());
    }


    @Test
    void test4(){

        HashSet<Integer> hs = new HashSet<>();
        List<Integer> c = List.of(1,2,3,4,5,6);

        assertFalse(hs.removeAll(c));
        assertEquals(0, hs.size());
    }

    @Test
    void test5(){

        HashSet<Integer> hs = new HashSet<>(List.of(7,8));
        List<Integer> c = List.of(1,2,3,4,5,6);

        assertFalse(hs.removeAll(c));
        assertEquals(2, hs.size());
    }

    @Test
    void test7(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        List<Integer> c = List.of(6);

        assertFalse(hs.removeAll(c));
        assertEquals(5, hs.size());
    }
    /*
    @Test
    void nullPointer(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        List<Integer> c = List.of(null);

        assertFalse(hs.removeAll(c));
    }*/
}
