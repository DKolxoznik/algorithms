package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№8, задача 2. Рюкзак 0/1: максимум полезности при массе ≤ W.
 */
public final class ZeroOneKnapsack {

    private ZeroOneKnapsack() {
    }

    public static long maxValue(int capacity, int[] weights, long[] values) {
        long[] dp = new long[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            long v = values[i];
            for (int c = capacity; c >= w; c--) {
                dp[c] = Math.max(dp[c], dp[c - w] + v);
            }
        }
        long best = 0;
        for (long x : dp) {
            best = Math.max(best, x);
        }
        return best;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int[] weights = new int[n];
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextLong();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(maxValue(w, weights, values));
        out.flush();
    }
}
