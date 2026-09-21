package ru.ithub.algorithms.kt2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * КТ№2, задача 3. Объединение пересекающихся и касающихся интервалов.
 * Время: O(n log n), память: O(n).
 */
public final class MergeIntervals {

    private MergeIntervals() {
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        int[][] sorted = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = new int[]{sorted[0][0], sorted[0][1]};
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] <= current[1]) {
                current[1] = Math.max(current[1], sorted[i][1]);
            } else {
                merged.add(current);
                current = new int[]{sorted[i][0], sorted[i][1]};
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
        }
        int[][] result = merge(intervals);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(result.length);
        for (int[] interval : result) {
            out.println(interval[0] + " " + interval[1]);
        }
        out.flush();
    }
}
