package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№4, задача 4. Максимальная стоимость пути в бинарном дереве.
 * Время: O(n), память: O(h) на рекурсию.
 */
public final class MaxPathSum {

    private MaxPathSum() {
    }

    public static long compute(BinaryTree tree) {
        long[] best = {Long.MIN_VALUE};
        dfs(0, tree, best);
        return best[0];
    }

    private static long dfs(int node, BinaryTree tree, long[] best) {
        long leftGain = 0;
        long rightGain = 0;
        if (tree.left[node] != -1) {
            leftGain = Math.max(0, dfs(tree.left[node], tree, best));
        }
        if (tree.right[node] != -1) {
            rightGain = Math.max(0, dfs(tree.right[node], tree, best));
        }
        best[0] = Math.max(best[0], tree.value[node] + leftGain + rightGain);
        return tree.value[node] + Math.max(leftGain, rightGain);
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
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(compute(new BinaryTree(value, left, right)));
        out.flush();
    }
}
