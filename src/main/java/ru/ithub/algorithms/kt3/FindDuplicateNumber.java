package ru.ithub.algorithms.kt3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№3, задача 6. Найти повторяющееся число в nums длины n+1 со значениями 1..n.
 * Алгоритм Флойда (цикл в функциональном графе), O(1) доп. памяти, массив не меняется.
 */
public final class FindDuplicateNumber {

    private FindDuplicateNumber() {
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nums[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(findDuplicate(nums));
        out.flush();
    }
}
