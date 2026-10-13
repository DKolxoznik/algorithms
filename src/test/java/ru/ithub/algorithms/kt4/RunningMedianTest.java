package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RunningMedianTest {

    @Test
    void growingSequence() {
        assertArrayEquals(
                new double[]{1.0, 1.5, 2.0, 2.5},
                RunningMedian.compute(new int[]{1, 2, 3, 4}),
                1e-9
        );
    }

    @Test
    void singleElement() {
        assertArrayEquals(new double[]{5.0}, RunningMedian.compute(new int[]{5}), 1e-9);
    }

    @Test
    void descending() {
        assertArrayEquals(
                new double[]{3.0, 2.5, 2.0},
                RunningMedian.compute(new int[]{3, 2, 1}),
                1e-9
        );
    }
}
