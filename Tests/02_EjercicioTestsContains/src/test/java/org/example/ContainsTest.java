package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsTest {

    /**
     * Returns if this array contains value.
     * @param identity If true, == comparision will be used
     * If False, .equals comparision will be used
     * @return true if array contains value, false if it doesn´t
     */
    /*
    public boolean contains(T value, boolean identity) {
        T[] items = this.items;
        int i = size - 1;
        if (identity || value == null) {
            while (i >= 0)
                if (items[i--] == value) return true;
        } else {
            while (i >= 0)
                if (value.equals(items[i--])) return true;
        }
        return false;
    }*/
    List<Integer> a;
    @BeforeEach
    void setUp(){
        a = new ArrayList<>();
    }
    @AfterEach
    void tearDown(){
        a = null;
    }

    @ParameterizedTest
    @MethodSource("generateArray")
    void test(List<Integer>c, int value, boolean expectedResult){
        a.addAll(c);
        assertEquals(expectedResult, a.contains(value));
    }
    static Stream<Arguments> generateArray(){
        return Stream.of(
                Arguments.arguments(List.of(1,2,3,4), 1, true),
                Arguments.arguments(List.of(1,2,3,4), 5, false),
                Arguments.arguments(List.of(), 5, false)
        );
    }
}
