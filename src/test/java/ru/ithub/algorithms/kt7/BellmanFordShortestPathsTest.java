package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BellmanFordShortestPathsTest {

    @Test
    void negativeEdge() {
        long[] dist = BellmanFordShortestPaths.distances(
                3, 1,
                new int[]{1, 2},
                new int[]{2, 3},
                new long[]{5, -2}
        );
        assertEquals(0, dist[1]);
        assertEquals(5, dist[2]);
        assertEquals(3, dist[3]);
    }

    @Test
    void unreachable() {
        long[] dist = BellmanFordShortestPaths.distances(
                2, 1,
                new int[]{},
                new int[]{},
                new long[]{}
        );
        assertEquals(BellmanFordShortestPaths.INF, dist[2]);
    }
}
