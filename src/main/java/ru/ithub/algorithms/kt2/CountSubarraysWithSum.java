package ru.ithub.algorithms.kt2;

import ru.ithub.algorithms.SubarraySumEqualsK;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№2, задача 5. Количество подмассивов с суммой k.
 * Использует решение из КТ№1: {@link SubarraySumEqualsK}.
 */
public final class CountSubarraysWithSum {

    private CountSubarraysWithSum() {
    }

    public static long count(int[] nums, long k) {
        return SubarraySumEqualsK.count(nums, k);
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(count(nums, k));
        out.flush();
    }
}
