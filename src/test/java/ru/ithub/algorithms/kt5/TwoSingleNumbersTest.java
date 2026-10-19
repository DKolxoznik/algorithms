package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSingleNumbersTest {

    @Test
    void classicExample() {
        assertArrayEquals(new int[]{3, 5}, TwoSingleNumbers.find(new int[]{1, 2, 1, 3, 2, 5}));
    }

    @Test
    void alreadySortedOutput() {
        assertArrayEquals(new int[]{1, 2}, TwoSingleNumbers.find(new int[]{1, 2, 4, 4}));
    }

    @Test
    void zerosAllowed() {
        assertArrayEquals(new int[]{0, 7}, TwoSingleNumbers.find(new int[]{0, 1, 1, 7}));
    }
}
