package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

/**
 * КТ№4, задача 6. Медианы скользящего окна длины k.
 * Два мультисета (TreeMap). Время: O(n log k).
 */
public final class SlidingWindowMedian {

    private SlidingWindowMedian() {
    }

    public static double[] compute(int[] nums, int k) {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();
        int[] lowSize = {0};
        int[] highSize = {0};
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            add(low, high, lowSize, highSize, nums[i]);
            rebalance(low, high, lowSize, highSize);
            if (i >= k - 1) {
                result[i - k + 1] = medianOf(low, high, lowSize, highSize, k);
                remove(low, high, lowSize, highSize, nums[i - k + 1]);
                rebalance(low, high, lowSize, highSize);
            }
        }
        return result;
    }

    private static void add(
            TreeMap<Integer, Integer> low,
            TreeMap<Integer, Integer> high,
            int[] lowSize,
            int[] highSize,
            int value
    ) {
        if (lowSize[0] == 0 || value <= low.lastKey()) {
            insert(low, value);
            lowSize[0]++;
        } else {
            insert(high, value);
            highSize[0]++;
        }
    }

    private static void remove(
            TreeMap<Integer, Integer> low,
            TreeMap<Integer, Integer> high,
            int[] lowSize,
            int[] highSize,
            int value
    ) {
        if (low.containsKey(value)) {
            erase(low, value);
            lowSize[0]--;
        } else {
            erase(high, value);
            highSize[0]--;
        }
    }

    private static void rebalance(
            TreeMap<Integer, Integer> low,
            TreeMap<Integer, Integer> high,
            int[] lowSize,
            int[] highSize
    ) {
        while (lowSize[0] > highSize[0] + 1) {
            int moved = low.lastKey();
            erase(low, moved);
            lowSize[0]--;
            insert(high, moved);
            highSize[0]++;
        }
        while (highSize[0] > lowSize[0]) {
            int moved = high.firstKey();
            erase(high, moved);
            highSize[0]--;
            insert(low, moved);
            lowSize[0]++;
        }
    }

    private static double medianOf(
            TreeMap<Integer, Integer> low,
            TreeMap<Integer, Integer> high,
            int[] lowSize,
            int[] highSize,
            int k
    ) {
        if ((k & 1) == 1) {
            return low.lastKey();
        }
        return ((double) low.lastKey() + high.firstKey()) / 2.0;
    }

    private static void insert(TreeMap<Integer, Integer> map, int value) {
        map.merge(value, 1, Integer::sum);
    }

    private static void erase(TreeMap<Integer, Integer> map, int value) {
        int count = map.get(value);
        if (count == 1) {
            map.remove(value);
        } else {
            map.put(value, count - 1);
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        double[] medians = compute(nums, k);
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
