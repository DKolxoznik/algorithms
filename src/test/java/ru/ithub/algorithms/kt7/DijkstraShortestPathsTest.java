package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraShortestPathsTest {

    @Test
    void simplePath() {
        List<List<DijkstraShortestPaths.Edge>> graph = empty(3);
        graph.get(1).add(new DijkstraShortestPaths.Edge(2, 5));
        graph.get(2).add(new DijkstraShortestPaths.Edge(3, 1));
        long[] dist = DijkstraShortestPaths.distances(3, 1, graph);
        assertEquals(0, dist[1]);
        assertEquals(5, dist[2]);
        assertEquals(6, dist[3]);
    }

    @Test
    void unreachable() {
        List<List<DijkstraShortestPaths.Edge>> graph = empty(2);
        long[] dist = DijkstraShortestPaths.distances(2, 1, graph);
        assertEquals(0, dist[1]);
        assertEquals(DijkstraShortestPaths.INF, dist[2]);
    }

    private static List<List<DijkstraShortestPaths.Edge>> empty(int n) {
        List<List<DijkstraShortestPaths.Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }
}
