package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWaterContainerTest {

    @Test
    void exampleFromAssignment() {
        assertEquals(49, MaxWaterContainer.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void twoWalls() {
        assertEquals(1, MaxWaterContainer.maxArea(new int[]{1, 1}));
    }

    @Test
    void increasingHeights() {
        assertEquals(6, MaxWaterContainer.maxArea(new int[]{1, 2, 3, 4, 5}));
    }
}
