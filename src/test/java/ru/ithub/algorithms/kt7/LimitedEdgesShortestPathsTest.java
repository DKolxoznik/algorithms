package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LimitedEdgesShortestPathsTest {

    @Test
    void exactTwoEdges() {
        LimitedEdgesShortestPaths.Result result = LimitedEdgesShortestPaths.compute(
                3, 1, 3, 2,
                new int[]{1, 2},
                new int[]{2, 3},
                new long[]{1, 1}
        );
        assertEquals(2, result.cost);
        assertEquals(1, result.ways);
    }

    @Test
    void emptyPathWhenSameVertex() {
        LimitedEdgesShortestPaths.Result result = LimitedEdgesShortestPaths.compute(
                1, 1, 1, 0,
                new int[]{},
                new int[]{},
                new long[]{}
        );
        assertEquals(0, result.cost);
        assertEquals(1, result.ways);
    }

    @Test
    void impossible() {
        assertNull(LimitedEdgesShortestPaths.compute(
                2, 1, 2, 0,
                new int[]{1},
                new int[]{2},
                new long[]{1}
        ));
    }

    @Test
    void parallelEdgesCountSeparately() {
        LimitedEdgesShortestPaths.Result result = LimitedEdgesShortestPaths.compute(
                2, 1, 2, 1,
                new int[]{1, 1},
                new int[]{2, 2},
                new long[]{5, 5}
        );
        assertEquals(5, result.cost);
        assertEquals(2, result.ways);
    }
}
