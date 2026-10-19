package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CouponShortestPathTest {

    @Test
    void usesCouponOnce() {
        List<List<CouponShortestPath.Edge>> graph = empty(3);
        graph.get(1).add(new CouponShortestPath.Edge(2, 10));
        graph.get(2).add(new CouponShortestPath.Edge(3, 10));
        assertEquals(15, CouponShortestPath.minCost(3, 1, 3, graph));
    }

    @Test
    void sameVertexZero() {
        assertEquals(0, CouponShortestPath.minCost(1, 1, 1, empty(1)));
    }

    @Test
    void unreachable() {
        assertEquals(-1, CouponShortestPath.minCost(2, 1, 2, empty(2)));
    }

    private static List<List<CouponShortestPath.Edge>> empty(int n) {
        List<List<CouponShortestPath.Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }
}
