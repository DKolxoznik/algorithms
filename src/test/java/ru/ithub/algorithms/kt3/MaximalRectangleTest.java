package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximalRectangleTest {

    @Test
    void classicMatrix() {
        assertEquals(6, MaximalRectangle.maxArea(new char[][]{
                "1010".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()
        }));
    }

    @Test
    void allOnes() {
        assertEquals(4, MaximalRectangle.maxArea(new char[][]{
                "11".toCharArray(),
                "11".toCharArray()
        }));
    }

    @Test
    void allZeros() {
        assertEquals(0, MaximalRectangle.maxArea(new char[][]{
                "00".toCharArray(),
                "00".toCharArray()
        }));
    }

    @Test
    void singleOne() {
        assertEquals(1, MaximalRectangle.maxArea(new char[][]{
                "01".toCharArray()
        }));
    }

    @Test
    void histogramHelper() {
        assertEquals(5, MaximalRectangle.largestRectangle(new int[]{2, 1, 2, 3, 1}));
    }
}
