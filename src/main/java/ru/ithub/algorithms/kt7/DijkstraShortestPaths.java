package ru.ithub.algorithms.kt7;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * КТ№7, задача 1. Дейкстра от s по неотрицательным весам.
 */
public final class DijkstraShortestPaths {

    public static final long INF = Long.MAX_VALUE / 4;

    private DijkstraShortestPaths() {
    }

    public static long[] distances(int n, int s, List<List<Edge>> graph) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, s});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d != dist[u]) {
                continue;
            }
            for (Edge e : graph.get(u)) {
                long nd = d + e.weight;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{nd, e.to});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            graph.get(u).add(new Edge(v, w));
        }
        long[] dist = distances(n, s, graph);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                out.print(' ');
            }
            out.print(dist[i] >= INF ? "INF" : Long.toString(dist[i]));
        }
        out.println();
        out.flush();
    }

    public static final class Edge {
        final int to;
        final long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
