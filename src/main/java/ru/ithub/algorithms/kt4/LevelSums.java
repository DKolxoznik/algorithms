package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * КТ№4, задача 1. Суммы значений вершин по уровням бинарного дерева.
 * Время: O(n), память: O(n).
 */
public final class LevelSums {

    private LevelSums() {
    }

    public static long[] compute(BinaryTree tree) {
        List<Long> sums = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                sum += tree.value[node];
                if (tree.left[node] != -1) {
                    queue.add(tree.left[node]);
                }
                if (tree.right[node] != -1) {
                    queue.add(tree.right[node]);
                }
            }
            sums.add(sum);
        }

        long[] result = new long[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            result[i] = sums.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            left[i] = in.nextInt();
            right[i] = in.nextInt();
        }
        long[] sums = compute(new BinaryTree(value, left, right));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < sums.length; i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.print(sums[i]);
        }
        out.println();
        out.flush();
    }
}
