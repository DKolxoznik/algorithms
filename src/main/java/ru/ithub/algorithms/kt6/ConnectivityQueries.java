package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№6, задача 2. Связность станций: объединение и запросы (DSU).
 */
public final class ConnectivityQueries {

    private final int[] parent;
    private final int[] rank;

    public ConnectivityQueries(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public void connect(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) {
            return;
        }
        if (rank[ru] < rank[rv]) {
            parent[ru] = rv;
        } else if (rank[ru] > rank[rv]) {
            parent[rv] = ru;
        } else {
            parent[rv] = ru;
            rank[ru]++;
        }
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        ConnectivityQueries dsu = new ConnectivityQueries(n);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            int u = in.nextInt();
            int v = in.nextInt();
            if (type == 1) {
                dsu.connect(u, v);
            } else {
                out.println(dsu.connected(u, v) ? "YES" : "NO");
            }
        }
        out.flush();
    }
}
