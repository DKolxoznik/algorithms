package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMedianTest {

    @Test
    void classicOddWindow() {
        assertArrayEquals(
                new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0},
                SlidingWindowMedian.compute(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3),
                1e-9
        );
    }

    @Test
    void evenWindow() {
        assertArrayEquals(
                new double[]{1.5, 2.5, 3.5},
                SlidingWindowMedian.compute(new int[]{1, 2, 3, 4}, 2),
                1e-9
        );
    }

    @Test
    void windowEqualsArray() {
        assertArrayEquals(
                new double[]{2.0},
                SlidingWindowMedian.compute(new int[]{1, 2, 3}, 3),
                1e-9
        );
    }

    @Test
    void windowSizeOne() {
        assertArrayEquals(
                new double[]{4.0, 1.0, 7.0},
                SlidingWindowMedian.compute(new int[]{4, 1, 7}, 1),
                1e-9
        );
    }

    @Test
    void duplicates() {
        assertArrayEquals(
                new double[]{2.0, 2.0},
                SlidingWindowMedian.compute(new int[]{2, 2, 2, 2}, 3),
                1e-9
        );
    }
}
