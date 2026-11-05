package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPathWithScreensTest {

    @Test
    void withOneScreen() {
        assertEquals(5, MaxPathWithScreens.maxSum(new long[][]{
                {1, -2},
                {-3, 4}
        }, 1));
    }

    @Test
    void noScreens() {
        assertEquals(3, MaxPathWithScreens.maxSum(new long[][]{
                {1, -2},
                {-3, 4}
        }, 0));
    }

    @Test
    void singleCell() {
        assertEquals(0, MaxPathWithScreens.maxSum(new long[][]{{-7}}, 1));
        assertEquals(-7, MaxPathWithScreens.maxSum(new long[][]{{-7}}, 0));
    }
}
