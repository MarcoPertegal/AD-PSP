package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //los metodos asset comprueban que se cumple algo, es una especie de comprobacion if
    //TEST Basados en la tabla de los apuntes
    //con removeAll se eliminan todos los elementos de la lista que coincidan con la lista c
    @Test
    void test1(){

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
    void test3(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        List<Integer> c = List.of(1,2,3,4,5,6);

        assertTrue(hs.removeAll(c));
        assertEquals(0, hs.size());
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
