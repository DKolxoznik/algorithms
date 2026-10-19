package ru.ithub.algorithms.kt7;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * КТ№7, задача 5. Беллман–Форд с пометкой вершин, достижимых из отрицательных циклов.
 * * — недостижима, - — стоимость неограниченно уменьшается, иначе — конечная стоимость.
 */
public final class NegativeCycleReachability {

    public static final long INF = Long.MAX_VALUE / 4;

    private NegativeCycleReachability() {
    }

    public static String[] classify(int n, int s, int[] from, int[] to, long[] weight) {
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

        boolean[] bad = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            if (dist[from[i]] >= INF) {
                continue;
            }
            long nd = dist[from[i]] + weight[i];
            if (nd < dist[to[i]]) {
                bad[to[i]] = true;
            }
        }

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(from[i]).add(to[i]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (bad[i]) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!bad[v]) {
                    bad[v] = true;
                    queue.add(v);
                }
            }
        }

        String[] result = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dist[i] >= INF) {
                result[i] = "*";
            } else if (bad[i]) {
                result[i] = "-";
            } else {
                result[i] = Long.toString(dist[i]);
            }
        }
        return result;
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
        String[] result = classify(n, s, from, to, weight);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 1; i <= n; i++) {
            out.println(result[i]);
        }
        out.flush();
    }
}
