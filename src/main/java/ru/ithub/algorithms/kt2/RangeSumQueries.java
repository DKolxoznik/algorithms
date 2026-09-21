package ru.ithub.algorithms.kt2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№2, задача 2. Сумма на отрезке [L, R] по запросам.
 * Подготовка: O(n), запрос: O(1), память: O(n).
 */
public final class RangeSumQueries {

    private RangeSumQueries() {
    }

    public static long[] prefixSums(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    public static long rangeSum(long[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static long[] answer(int[] nums, int[][] queries) {
        long[] prefix = prefixSums(nums);
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = rangeSum(prefix, queries[i][0], queries[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long[] prefix = prefixSums(nums);
        int q = in.nextInt();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < q; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            out.println(rangeSum(prefix, left, right));
        }
        out.flush();
    }
}
