package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * КТ№4, задача 2. k самых частых чисел: по убыванию частоты, при равенстве — меньшее раньше.
 * Время: O(n + u log u), u — число уникальных значений.
 */
public final class TopKFrequent {

    private TopKFrequent() {
    }

    public static int[] find(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> {
            int byFreq = Integer.compare(b.getValue(), a.getValue());
            if (byFreq != 0) {
                return byFreq;
            }
            return Integer.compare(a.getKey(), b.getKey());
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] answer = find(nums, k);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < answer.length; i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.print(answer[i]);
        }
        out.println();
        out.flush();
    }
}
