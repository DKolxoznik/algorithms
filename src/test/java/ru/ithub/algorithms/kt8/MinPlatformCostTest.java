package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPlatformCostTest {

    @Test
    void classicExample() {
        assertEquals(20, MinPlatformCost.minCost(new int[]{10, 20, 30, 10}));
    }

    @Test
    void twoPlatforms() {
        assertEquals(5, MinPlatformCost.minCost(new int[]{1, 6}));
    }

    @Test
    void preferDoubleJump() {
        assertEquals(10, MinPlatformCost.minCost(new int[]{0, 100, 10}));
    }
}
