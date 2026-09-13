package ru.ithub.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача 1. Самая длинная последовательность номеров.
 * Время: O(n), память: O(n).
 */
public final class LongestConsecutiveSequence {

    private LongestConsecutiveSequence() {
    }

    public static int findLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> values = new HashSet<>(nums.length * 2);
        for (int num : nums) {
            values.add(num);
        }

        int longest = 0;
        for (int num : values) {
            if (values.contains(num - 1)) {
                continue;
            }
            int current = num;
            int length = 1;
            while (values.contains(current + 1)) {
                current++;
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
