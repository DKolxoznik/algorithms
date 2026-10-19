package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;

/**
 * КТ№6, задача 6. Восстановление лексикографически наименьшего порядка k букв.
 * Граф предшествования + топосорт Кана с min-heap.
 */
public final class AlienDictionary {

    private AlienDictionary() {
    }

    /**
     * @return строка порядка или {@code null}, если невозможно
     */
    public static String findOrder(int k, String[] words) {
        boolean[][] edge = new boolean[k][k];
        int[] indegree = new int[k];

        for (int i = 0; i + 1 < words.length; i++) {
            String left = words[i];
            String right = words[i + 1];
            int min = Math.min(left.length(), right.length());
            boolean differ = false;
            for (int j = 0; j < min; j++) {
                int a = left.charAt(j) - 'a';
                int b = right.charAt(j) - 'a';
                if (a != b) {
                    if (!edge[a][b]) {
                        edge[a][b] = true;
                        indegree[b]++;
                    }
                    differ = true;
                    break;
                }
            }
            if (!differ && left.length() > right.length()) {
                return null;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder order = new StringBuilder(k);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.append((char) ('a' + u));
            for (int v = 0; v < k; v++) {
                if (edge[u][v]) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
        }
        return order.length() == k ? order.toString() : null;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        String order = findOrder(k, words);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(order == null ? "IMPOSSIBLE" : order);
        out.flush();
    }
}
