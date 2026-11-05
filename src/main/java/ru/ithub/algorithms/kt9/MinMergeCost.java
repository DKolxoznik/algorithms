package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№9, задача 4. Минимальная стоимость объединения соседних групп.
 * DP O(n³).
 */
public final class MinMergeCost {

    private MinMergeCost() {
    }

    public static long minCost(long[] a) {
        int n = a.length;
        if (n <= 1) {
            return 0;
        }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + a[i];
        }
        long[][] dp = new long[n][n];
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 4);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                long sum = prefix[j + 1] - prefix[i];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(minCost(a));
        out.flush();
    }
}
