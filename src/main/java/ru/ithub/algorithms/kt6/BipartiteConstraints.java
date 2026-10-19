package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№6, задача 5. Две группы с ограничениями same/different (DSU с чётностью).
 * После первого NO все ответы NO.
 */
public final class BipartiteConstraints {

    private final int[] parent;
    private final int[] rank;
    private final int[] parity;
    private boolean consistent = true;

    public BipartiteConstraints(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        parity = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    /**
     * @param relation 0 — одна группа, 1 — разные
     * @return true, если все утверждения пока совместимы
     */
    public boolean addConstraint(int u, int v, int relation) {
        if (!consistent) {
            return false;
        }
        if (u == v) {
            if (relation == 1) {
                consistent = false;
            }
            return consistent;
        }

        int rootU = find(u);
        int rootV = find(v);
        int parityU = parity[u];
        int parityV = parity[v];

        if (rootU == rootV) {
            if ((parityU ^ parityV) != relation) {
                consistent = false;
            }
            return consistent;
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
            parity[rootU] = parityU ^ relation ^ parityV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            parity[rootV] = parityV ^ relation ^ parityU;
        } else {
            parent[rootV] = rootU;
            parity[rootV] = parityV ^ relation ^ parityU;
            rank[rootU]++;
        }
        return true;
    }

    public boolean isConsistent() {
        return consistent;
    }

    private int find(int x) {
        if (parent[x] != x) {
            int p = parent[x];
            parent[x] = find(p);
            parity[x] ^= parity[p];
        }
        return parent[x];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        BipartiteConstraints solver = new BipartiteConstraints(n);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < q; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int r = in.nextInt();
            out.println(solver.addConstraint(u, v, r) ? "YES" : "NO");
        }
        out.flush();
    }
}
