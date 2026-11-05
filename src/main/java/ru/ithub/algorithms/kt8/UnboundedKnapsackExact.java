package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№8, задача 4. Неограниченный рюкзак на массу ровно C:
 * макс. прибыль, затем мин. число грузов.
 */
public final class UnboundedKnapsackExact {

    private static final long NEG = Long.MIN_VALUE / 4;

    private UnboundedKnapsackExact() {
    }

    public static long[] solve(int capacity, int[] weights, long[] profits) {
        long[] bestProfit = new long[capacity + 1];
        int[] bestCount = new int[capacity + 1];
        Arrays.fill(bestProfit, NEG);
        bestProfit[0] = 0;

        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            long p = profits[i];
            for (int c = w; c <= capacity; c++) {
                if (bestProfit[c - w] == NEG) {
                    continue;
                }
                long candProfit = bestProfit[c - w] + p;
                int candCount = bestCount[c - w] + 1;
                if (candProfit > bestProfit[c]
                        || (candProfit == bestProfit[c] && candCount < bestCount[c])) {
                    bestProfit[c] = candProfit;
                    bestCount[c] = candCount;
                }
            }
        }

        if (bestProfit[capacity] == NEG) {
            return null;
        }
        return new long[]{bestProfit[capacity], bestCount[capacity]};
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] weights = new int[n];
        long[] profits = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            profits[i] = in.nextLong();
        }
        long[] answer = solve(c, weights, profits);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        if (answer == null) {
            out.println(-1);
        } else {
            out.println(answer[0] + " " + answer[1]);
        }
        out.flush();
    }
}
