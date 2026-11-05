package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LisCountTest {

    @Test
    void twoLisOfLengthThree() {
        assertArrayEquals(new int[]{3, 2}, LisCount.solve(new int[]{1, 3, 2, 4}));
    }

    @Test
    void strictlyDecreasing() {
        assertArrayEquals(new int[]{1, 3}, LisCount.solve(new int[]{3, 2, 1}));
    }

    @Test
    void equalElements() {
        assertArrayEquals(new int[]{1, 4}, LisCount.solve(new int[]{2, 2, 2, 2}));
    }

    @Test
    void increasing() {
        assertArrayEquals(new int[]{4, 1}, LisCount.solve(new int[]{1, 2, 3, 4}));
    }
}
