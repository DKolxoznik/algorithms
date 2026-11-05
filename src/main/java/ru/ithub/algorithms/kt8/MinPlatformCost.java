package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№8, задача 1. Минимальная стоимость пути по платформам (шаг +1 или +2).
 * DP O(n).
 */
public final class MinPlatformCost {

    private MinPlatformCost() {
    }

    public static long minCost(int[] h) {
        int n = h.length;
        long prev2 = 0;
        long prev1 = Math.abs((long) h[1] - h[0]);
        for (int i = 2; i < n; i++) {
            long cur = Math.min(
                    prev1 + Math.abs((long) h[i] - h[i - 1]),
                    prev2 + Math.abs((long) h[i] - h[i - 2])
            );
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(minCost(h));
        out.flush();
    }
}
