package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * КТ№9, задача 6. Максимальная ценность ровно k связных вершин дерева.
 * Tree knapsack DP O(n·k²).
 */
public final class MaxConnectedSubsetK {

    private static final long NEG = Long.MIN_VALUE / 4;

    private MaxConnectedSubsetK() {
    }

    public static long maxValue(long[] values, int[][] edges, int k) {
        int n = values.length;
        List<Integer>[] adj = buildAdj(n, edges);
        long[][] dp = new long[n][k + 1];
        for (long[] row : dp) {
            Arrays.fill(row, NEG);
        }
        int[] subSize = new int[n];
        dfs(0, -1, adj, values, k, dp, subSize);
        long ans = NEG;
        for (int u = 0; u < n; u++) {
            ans = Math.max(ans, dp[u][k]);
        }
        return ans;
    }

    private static void dfs(
            int u,
            int parent,
            List<Integer>[] adj,
            long[] values,
            int k,
            long[][] dp,
            int[] subSize
    ) {
        dp[u][1] = values[u];
        subSize[u] = 1;
        for (int v : adj[u]) {
            if (v == parent) {
                continue;
            }
            dfs(v, u, adj, values, k, dp, subSize);
            long[] next = new long[k + 1];
            Arrays.fill(next, NEG);
            int maxI = Math.min(subSize[u], k);
            for (int i = 1; i <= maxI; i++) {
                if (dp[u][i] == NEG) {
                    continue;
                }
                next[i] = Math.max(next[i], dp[u][i]);
                int maxJ = Math.min(subSize[v], k - i);
                for (int j = 1; j <= maxJ; j++) {
                    if (dp[v][j] == NEG) {
                        continue;
                    }
                    next[i + j] = Math.max(next[i + j], dp[u][i] + dp[v][j]);
                }
            }
            dp[u] = next;
            subSize[u] = Math.min(k, subSize[u] + subSize[v]);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] buildAdj(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int a = e[0] - 1;
            int b = e[1] - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        return adj;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
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
        out.println(maxValue(values, edges, k));
        out.flush();
    }
}
