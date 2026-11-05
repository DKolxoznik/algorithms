package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№9, задача 5. Максимальная сумма пути вправо/вниз с до k экранами.
 * DP O(n·m·k).
 */
public final class MaxPathWithScreens {

    private static final long NEG = Long.MIN_VALUE / 4;

    private MaxPathWithScreens() {
    }

    public static long maxSum(long[][] a, int k) {
        int n = a.length;
        int m = a[0].length;
        long[][] prev = new long[m][k + 1];
        long[][] cur = new long[m][k + 1];
        for (int j = 0; j < m; j++) {
            Arrays.fill(prev[j], NEG);
            Arrays.fill(cur[j], NEG);
        }

        applyCell(prev[0], a[0][0], newStartState(k));

        for (int j = 1; j < m; j++) {
            applyCell(prev[j], a[0][j], prev[j - 1]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(cur[j], NEG);
            }
            applyCell(cur[0], a[i][0], prev[0]);
            for (int j = 1; j < m; j++) {
                long[] from = mergeStates(prev[j], cur[j - 1], k);
                applyCell(cur[j], a[i][j], from);
            }
            long[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        long ans = NEG;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, prev[m - 1][t]);
        }
        return ans;
    }

    private static long[] newStartState(int k) {
        long[] state = new long[k + 1];
        Arrays.fill(state, NEG);
        state[0] = 0;
        return state;
    }

    private static long[] mergeStates(long[] a, long[] b, int k) {
        long[] merged = new long[k + 1];
        for (int t = 0; t <= k; t++) {
            merged[t] = Math.max(a[t], b[t]);
        }
        return merged;
    }

    private static void applyCell(long[] dest, long value, long[] from) {
        int k = dest.length - 1;
        Arrays.fill(dest, NEG);
        for (int t = 0; t <= k; t++) {
            if (from[t] == NEG) {
                continue;
            }
            dest[t] = Math.max(dest[t], from[t] + value);
            if (value < 0 && t + 1 <= k) {
                dest[t + 1] = Math.max(dest[t + 1], from[t]);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextLong();
            }
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(maxSum(a, k));
        out.flush();
    }
}
