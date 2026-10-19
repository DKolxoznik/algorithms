package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№5, задача 3. Два числа, встречающиеся по одному разу; остальные — по два.
 * XOR + разделение по биту. Время: O(n), память: O(1).
 */
public final class TwoSingleNumbers {

    private TwoSingleNumbers() {
    }

    public static int[] find(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }
        int bit = xorAll & -xorAll;
        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }
        if (first > second) {
            int tmp = first;
            first = second;
            second = tmp;
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] answer = find(nums);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(answer[0] + " " + answer[1]);
        out.flush();
    }
}
