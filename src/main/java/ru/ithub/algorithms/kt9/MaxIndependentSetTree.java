package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * КТ№9, задача 3. Максимальное независимое множество на дереве.
 * Tree DP O(n).
 */
public final class MaxIndependentSetTree {

    private MaxIndependentSetTree() {
    }

    public static long maxValue(long[] values, int[][] edges) {
        int n = values.length;
        List<Integer>[] adj = buildAdj(n, edges);
        long[] take = new long[n];
        long[] skip = new long[n];
        dfs(0, -1, adj, values, take, skip);
        return Math.max(take[0], skip[0]);
    }

    private static void dfs(int u, int parent, List<Integer>[] adj, long[] values, long[] take, long[] skip) {
        take[u] = values[u];
        skip[u] = 0;
        for (int v : adj[u]) {
            if (v == parent) {
                continue;
            }
            dfs(v, u, adj, values, take, skip);
            take[u] += skip[v];
            skip[u] += Math.max(take[v], skip[v]);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildAdj(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        return adj;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextLong();
        }
        int[][] edges = new int[Math.max(0, n - 1)][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(maxValue(values, edges));
        out.flush();
    }
}
