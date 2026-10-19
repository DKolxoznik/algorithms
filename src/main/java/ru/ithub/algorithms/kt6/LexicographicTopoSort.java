package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * КТ№6, задача 3. Лексикографически наименьший топологический порядок этапов.
 * Алгоритм Кана с min-heap. При цикле — пустой результат.
 */
public final class LexicographicTopoSort {

    private LexicographicTopoSort() {
    }

    /**
     * @return порядок этапов 1..n или пустой массив, если невозможно
     */
    public static int[] sort(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[n];
        int pos = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[pos++] = u;
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return pos == n ? order : new int[0];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }
        int[] order = sort(n, edges);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        if (order.length == 0) {
            out.println(-1);
        } else {
            for (int i = 0; i < order.length; i++) {
                if (i > 0) {
                    out.print(' ');
                }
                out.print(order[i]);
            }
            out.println();
        }
        out.flush();
    }
}
