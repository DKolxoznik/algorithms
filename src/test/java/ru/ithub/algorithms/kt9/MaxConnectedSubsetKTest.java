package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConnectedSubsetKTest {

    @Test
    void sampleK2() {
        assertEquals(7, MaxConnectedSubsetK.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}},
                2
        ));
    }

    @Test
    void takeAll() {
        assertEquals(10, MaxConnectedSubsetK.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}},
                4
        ));
    }

    @Test
    void singleBest() {
        assertEquals(4, MaxConnectedSubsetK.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}},
                1
        ));
    }
}
