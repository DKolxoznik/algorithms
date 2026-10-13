package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentTest {

    @Test
    void classicExample() {
        assertArrayEquals(new int[]{1, 2}, TopKFrequent.find(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    void tieBreakBySmallerValue() {
        assertArrayEquals(new int[]{1, 2}, TopKFrequent.find(new int[]{2, 1, 2, 1}, 2));
    }

    @Test
    void allUniqueTakeSmallerFirstWhenSameFreq() {
        assertArrayEquals(new int[]{1, 2, 3}, TopKFrequent.find(new int[]{3, 1, 2}, 3));
    }

    @Test
    void single() {
        assertArrayEquals(new int[]{7}, TopKFrequent.find(new int[]{7, 7, 7}, 1));
    }
}
