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
 * КТ№7, задача 3. Ближайший пункт помощи (мультистартовый Дейкстра).
 * При равном расстоянии выбирается пункт с меньшим номером.
 */
public final class NearestHelpStations {

    public static final long INF = Long.MAX_VALUE / 4;

    private NearestHelpStations() {
    }

    public static Result compute(int n, int[] stations, List<List<Edge>> graph) {
        long[] dist = new long[n + 1];
        int[] nearest = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(nearest, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator
                .comparingLong((long[] a) -> a[0])
                .thenComparingLong(a -> a[2]));

        for (int station : stations) {
            dist[station] = 0;
            nearest[station] = station;
            pq.offer(new long[]{0, station, station});
        }

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            int station = (int) cur[2];
            if (d != dist[u] || station != nearest[u]) {
                continue;
            }
            for (Edge e : graph.get(u)) {
                long nd = d + e.weight;
                if (nd < dist[e.to] || (nd == dist[e.to] && station < nearest[e.to])) {
                    dist[e.to] = nd;
                    nearest[e.to] = station;
                    pq.offer(new long[]{nd, e.to, station});
                }
            }
        }
        return new Result(nearest, dist);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] stations = new int[k];
        for (int i = 0; i < k; i++) {
            stations[i] = in.nextInt();
        }
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        Result result = compute(n, stations, graph);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 1; i <= n; i++) {
            if (result.nearest[i] == -1) {
                out.println("-1 -1");
            } else {
                out.println(result.nearest[i] + " " + result.dist[i]);
            }
        }
        out.flush();
    }

    public static final class Result {
        public final int[] nearest;
        public final long[] dist;

        Result(int[] nearest, long[] dist) {
            this.nearest = nearest;
            this.dist = dist;
        }
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
