package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LexicographicTopoSortTest {

    @Test
    void prefersSmallerNumbers() {
        assertArrayEquals(new int[]{1, 2, 3}, LexicographicTopoSort.sort(3, new int[][]{{1, 2}, {1, 3}}));
    }

    @Test
    void cycleImpossible() {
        assertEquals(0, LexicographicTopoSort.sort(2, new int[][]{{1, 2}, {2, 1}}).length);
    }

    @Test
    void noEdges() {
        assertArrayEquals(new int[]{1, 2, 3}, LexicographicTopoSort.sort(3, new int[][]{}));
    }

    @Test
    void diamond() {
        assertArrayEquals(
                new int[]{1, 2, 3, 4},
                LexicographicTopoSort.sort(4, new int[][]{{1, 3}, {1, 2}, {2, 4}, {3, 4}})
        );
    }
}
