package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinMergeCostTest {

    @Test
    void sample() {
        assertEquals(19, MinMergeCost.minCost(new long[]{1, 2, 3, 4}));
    }

    @Test
    void single() {
        assertEquals(0, MinMergeCost.minCost(new long[]{42}));
    }

    @Test
    void two() {
        assertEquals(5, MinMergeCost.minCost(new long[]{2, 3}));
    }
}
