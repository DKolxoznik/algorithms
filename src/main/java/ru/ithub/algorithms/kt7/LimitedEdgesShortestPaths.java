package ru.ithub.algorithms.kt7;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№7, задача 6. Мин. стоимость пути s→t не более чем из K рёбер и число таких путей.
 * DP по числу рёбер; рёбра нумеруются порядком ввода.
 */
public final class LimitedEdgesShortestPaths {

    private static final long INF = Long.MAX_VALUE / 4;
    private static final int MOD = 1_000_000_007;

    private LimitedEdgesShortestPaths() {
    }

    public static Result compute(int n, int s, int t, int k, int[] from, int[] to, long[] weight) {
        long[][] dist = new long[k + 1][n + 1];
        int[][] count = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][s] = 0;
        count[0][s] = 1;

        int m = from.length;
        for (int edges = 0; edges < k; edges++) {
            for (int e = 0; e < m; e++) {
                int u = from[e];
                int v = to[e];
                if (dist[edges][u] >= INF || count[edges][u] == 0) {
                    continue;
                }
                long nd = dist[edges][u] + weight[e];
                if (nd < dist[edges + 1][v]) {
                    dist[edges + 1][v] = nd;
                    count[edges + 1][v] = count[edges][u];
                } else if (nd == dist[edges + 1][v]) {
                    count[edges + 1][v] = (count[edges + 1][v] + count[edges][u]) % MOD;
                }
            }
        }

        long best = INF;
        for (int edges = 0; edges <= k; edges++) {
            best = Math.min(best, dist[edges][t]);
        }
        if (best >= INF) {
            return null;
        }
        int ways = 0;
        for (int edges = 0; edges <= k; edges++) {
            if (dist[edges][t] == best) {
                ways = (ways + count[edges][t]) % MOD;
            }
        }
        return new Result(best, ways);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int k = in.nextInt();
        int[] from = new int[m];
        int[] to = new int[m];
        long[] weight = new long[m];
        for (int i = 0; i < m; i++) {
            from[i] = in.nextInt();
            to[i] = in.nextInt();
            weight[i] = in.nextLong();
        }
        Result result = compute(n, s, t, k, from, to, weight);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        if (result == null) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(result.cost + " " + result.ways);
        }
        out.flush();
    }

    public static final class Result {
        public final long cost;
        public final int ways;

        Result(long cost, int ways) {
            this.cost = cost;
            this.ways = ways;
        }
    }
}
