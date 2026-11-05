package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroOneKnapsackTest {

    @Test
    void classicExample() {
        assertEquals(7, ZeroOneKnapsack.maxValue(5, new int[]{2, 3, 4}, new long[]{3, 4, 5}));
    }

    @Test
    void singleItemFits() {
        assertEquals(10, ZeroOneKnapsack.maxValue(5, new int[]{5}, new long[]{10}));
    }

    @Test
    void nothingFits() {
        assertEquals(0, ZeroOneKnapsack.maxValue(1, new int[]{2}, new long[]{100}));
    }
}
