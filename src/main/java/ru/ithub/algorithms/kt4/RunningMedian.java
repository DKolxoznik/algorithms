package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * КТ№4, задача 3. Медиана после каждого нового числа (два хипа).
 * Время: O(n log n), память: O(n).
 */
public final class RunningMedian {

    private RunningMedian() {
    }

    public static double[] compute(int[] nums) {
        PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();
        double[] medians = new double[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (low.isEmpty() || nums[i] <= low.peek()) {
                low.offer(nums[i]);
            } else {
                high.offer(nums[i]);
            }
            rebalance(low, high);
            medians[i] = medianOf(low, high);
        }
        return medians;
    }

    private static void rebalance(PriorityQueue<Integer> low, PriorityQueue<Integer> high) {
        if (low.size() > high.size() + 1) {
            high.offer(low.poll());
        } else if (high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    private static double medianOf(PriorityQueue<Integer> low, PriorityQueue<Integer> high) {
        if (low.size() > high.size()) {
            return low.peek();
        }
        return ((double) low.peek() + high.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        double[] medians = compute(nums);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < medians.length; i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.printf(java.util.Locale.US, "%.1f", medians[i]);
        }
        out.println();
        out.flush();
    }
}
