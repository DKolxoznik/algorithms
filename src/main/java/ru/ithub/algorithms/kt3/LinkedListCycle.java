package ru.ithub.algorithms.kt3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№3, задача 3. Есть ли цикл при обходе next[] из start.
 * Алгоритм Флойда, доп. память O(1).
 */
public final class LinkedListCycle {

    private LinkedListCycle() {
    }

    /**
     * @param next 1-индексированный массив: next[i] — следующий узел или -1
     * @param start начальный узел (1..n)
     */
    public static boolean hasCycle(int[] next, int start) {
        int slow = start;
        int fast = start;
        while (true) {
            slow = step(next, slow);
            if (slow == -1) {
                return false;
            }
            fast = step(next, fast);
            if (fast == -1) {
                return false;
            }
            fast = step(next, fast);
            if (fast == -1) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }

    private static int step(int[] next, int node) {
        if (node <= 0 || node >= next.length) {
            return -1;
        }
        int to = next[node];
        return to <= 0 ? -1 : to;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int start = in.nextInt();
        int[] next = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            next[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(hasCycle(next, start) ? "YES" : "NO");
        out.flush();
    }
}
