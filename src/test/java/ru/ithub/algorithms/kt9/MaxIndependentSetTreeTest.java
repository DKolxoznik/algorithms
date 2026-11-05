package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxIndependentSetTreeTest {

    @Test
    void sampleTree() {
        assertEquals(6, MaxIndependentSetTree.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}}
        ));
    }

    @Test
    void singleNegative() {
        assertEquals(0, MaxIndependentSetTree.maxValue(new long[]{-5}, new int[0][2]));
    }

    @Test
    void line() {
        assertEquals(4, MaxIndependentSetTree.maxValue(
                new long[]{1, 2, 3},
                new int[][]{{1, 2}, {2, 3}}
        ));
    }
}
