package ru.ithub.algorithms.kt7;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№7, задача 2. Беллман–Форд при возможных отрицательных весах
 * (отрицательный цикл из s недостижим).
 */
public final class BellmanFordShortestPaths {

    public static final long INF = Long.MAX_VALUE / 4;

    private BellmanFordShortestPaths() {
    }

    public static long[] distances(int n, int s, int[] from, int[] to, long[] weight) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        int m = from.length;
        for (int iter = 1; iter < n; iter++) {
            boolean changed = false;
            for (int i = 0; i < m; i++) {
                if (dist[from[i]] >= INF) {
                    continue;
                }
                long nd = dist[from[i]] + weight[i];
                if (nd < dist[to[i]]) {
                    dist[to[i]] = nd;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int[] from = new int[m];
        int[] to = new int[m];
        long[] weight = new long[m];
        for (int i = 0; i < m; i++) {
            from[i] = in.nextInt();
            to[i] = in.nextInt();
            weight[i] = in.nextLong();
        }
        long[] dist = distances(n, s, from, to, weight);
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
}
