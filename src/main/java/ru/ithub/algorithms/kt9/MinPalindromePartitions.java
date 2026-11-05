package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№9, задача 1. Минимальное число палиндромных подряд идущих частей.
 * DP O(n²).
 */
public final class MinPalindromePartitions {

    private MinPalindromePartitions() {
    }

    public static int minParts(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (pal[j][i - 1]) {
                    best = Math.min(best, dp[j] + 1);
                }
            }
            dp[i] = best;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        String s = in.next();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(minParts(s));
        out.flush();
    }
}
