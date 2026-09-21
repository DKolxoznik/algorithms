package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeIntervalsTest {

    @Test
    void overlappingIntervals() {
        assertArrayEquals(
                new int[][]{{1, 6}, {8, 10}, {15, 18}},
                MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})
        );
    }

    @Test
    void sharedBoundaryIsMerged() {
        assertArrayEquals(
                new int[][]{{1, 5}},
                MergeIntervals.merge(new int[][]{{1, 4}, {4, 5}})
        );
    }

    @Test
    void emptyInput() {
        assertEquals(0, MergeIntervals.merge(new int[][]{}).length);
    }

    @Test
    void alreadyDisjoint() {
        assertArrayEquals(
                new int[][]{{1, 2}, {4, 5}},
                MergeIntervals.merge(new int[][]{{4, 5}, {1, 2}})
        );
    }
}
