package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //los metodos asset comprueban que se cumple algo, es una especie de comprobacion if

    @Test
    void test1(){

        HashSet<Integer> hs = new HashSet<>(List.of(1,2,3,4,5));
        Collection<Integer> c = Collections.emptyList();

        assertFalse(hs.removeAll(c));
        //assertEquals()

    }
}
