package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NearestHelpStationsTest {

    @Test
    void tieBreakByStationId() {
        List<List<NearestHelpStations.Edge>> graph = empty(3);
        addUndirected(graph, 1, 2, 3);
        addUndirected(graph, 2, 3, 4);
        NearestHelpStations.Result result = NearestHelpStations.compute(3, new int[]{1, 3}, graph);
        assertEquals(1, result.nearest[1]);
        assertEquals(0, result.dist[1]);
        assertEquals(1, result.nearest[2]);
        assertEquals(3, result.dist[2]);
        assertEquals(3, result.nearest[3]);
        assertEquals(0, result.dist[3]);
    }

    @Test
    void equalDistancePrefersSmallerId() {
        List<List<NearestHelpStations.Edge>> graph = empty(3);
        addUndirected(graph, 1, 2, 5);
        addUndirected(graph, 3, 2, 5);
        NearestHelpStations.Result result = NearestHelpStations.compute(3, new int[]{1, 3}, graph);
        assertEquals(1, result.nearest[2]);
        assertEquals(5, result.dist[2]);
    }

    private static List<List<NearestHelpStations.Edge>> empty(int n) {
        List<List<NearestHelpStations.Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    private static void addUndirected(List<List<NearestHelpStations.Edge>> graph, int u, int v, long w) {
        graph.get(u).add(new NearestHelpStations.Edge(v, w));
        graph.get(v).add(new NearestHelpStations.Edge(u, w));
    }
}
