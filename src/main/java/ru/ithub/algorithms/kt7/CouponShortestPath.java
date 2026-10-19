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
 * КТ№7, задача 4. Кратчайший путь s→t с одним купоном (стоимость ⌊w/2⌋).
 * Состояния: (вершина, купон использован?).
 */
public final class CouponShortestPath {

    private static final long INF = Long.MAX_VALUE / 4;

    private CouponShortestPath() {
    }

    public static long minCost(int n, int s, int t, List<List<Edge>> graph) {
        long[][] dist = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[s][0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, s, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            int used = (int) cur[2];
            if (d != dist[u][used]) {
                continue;
            }
            for (Edge e : graph.get(u)) {
                long nd = d + e.weight;
                if (nd < dist[e.to][used]) {
                    dist[e.to][used] = nd;
                    pq.offer(new long[]{nd, e.to, used});
                }
                if (used == 0) {
                    long withCoupon = d + e.weight / 2;
                    if (withCoupon < dist[e.to][1]) {
                        dist[e.to][1] = withCoupon;
                        pq.offer(new long[]{withCoupon, e.to, 1});
                    }
                }
            }
        }
        long answer = Math.min(dist[t][0], dist[t][1]);
        return answer >= INF ? -1 : answer;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
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
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(minCost(n, s, t, graph));
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
