package com.unvise.oop.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MostCommonCharAppTest {

    @Test
    void mostCommonCharEntryTest() {
        // given
        String ex1 = "Hello";
        String ex2 = "Abracadabra";
        String ex3 = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
        var res1 = MostCommonCharApp.mostCommonCharEntry(ex1);
        var res2 = MostCommonCharApp.mostCommonCharEntry(ex2);
        var res3 = MostCommonCharApp.mostCommonCharEntry(ex3);
        // then
        assertAll(
                () -> assertEquals(Character.valueOf('l'), res1.getKey()),
                () -> assertEquals(2, res1.getValue()),
                () -> assertEquals(Character.valueOf('a'), res2.getKey()),
                () -> assertEquals(4, res2.getValue()),
                () -> assertEquals(Character.valueOf(' '), res3.getKey()),
                () -> assertEquals(13, res3.getValue())
        );
    }
}