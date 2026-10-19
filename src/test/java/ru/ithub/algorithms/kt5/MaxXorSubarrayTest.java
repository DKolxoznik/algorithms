package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxXorSubarrayTest {

    @Test
    void classicExample() {
        assertEquals(7, MaxXorSubarray.findMax(new int[]{1, 2, 3, 4}));
    }

    @Test
    void singleElement() {
        assertEquals(5, MaxXorSubarray.findMax(new int[]{5}));
    }

    @Test
    void allZeros() {
        assertEquals(0, MaxXorSubarray.findMax(new int[]{0, 0, 0}));
    }

    @Test
    void increasingPowers() {
        assertEquals(7, MaxXorSubarray.findMax(new int[]{1, 2, 4}));
    }
}
