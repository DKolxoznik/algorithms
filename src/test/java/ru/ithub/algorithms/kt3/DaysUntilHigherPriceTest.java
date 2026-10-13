package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DaysUntilHigherPriceTest {

    @Test
    void classicExample() {
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                DaysUntilHigherPrice.daysToWait(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
        );
    }

    @Test
    void strictlyDecreasing() {
        assertArrayEquals(new int[]{0, 0, 0}, DaysUntilHigherPrice.daysToWait(new int[]{5, 4, 3}));
    }

    @Test
    void strictlyIncreasing() {
        assertArrayEquals(new int[]{1, 1, 0}, DaysUntilHigherPrice.daysToWait(new int[]{1, 2, 3}));
    }

    @Test
    void singleDay() {
        assertArrayEquals(new int[]{0}, DaysUntilHigherPrice.daysToWait(new int[]{10}));
    }
}
