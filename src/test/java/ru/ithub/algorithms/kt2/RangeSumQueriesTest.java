package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumQueriesTest {

    @Test
    void severalQueries() {
        long[] answers = RangeSumQueries.answer(
                new int[]{1, 2, 3, 4},
                new int[][]{{0, 3}, {1, 2}, {3, 3}}
        );
        assertArrayEquals(new long[]{10, 5, 4}, answers);
    }

    @Test
    void negativeNumbers() {
        assertEquals(-3, RangeSumQueries.answer(new int[]{-1, -2, 5}, new int[][]{{0, 1}})[0]);
    }

    @Test
    void singleElement() {
        assertEquals(9, RangeSumQueries.answer(new int[]{9}, new int[][]{{0, 0}})[0]);
    }
}
