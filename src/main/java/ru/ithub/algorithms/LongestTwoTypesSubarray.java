package ru.ithub.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Задача 3. Самый длинный участок с ограниченным числом типов.
 * Время: O(n), память: O(1).
 */
public final class LongestTwoTypesSubarray {

    private LongestTwoTypesSubarray() {
    }

    public static int findLength(int[] items) {
        if (items == null || items.length == 0) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < items.length; right++) {
            counts.merge(items[right], 1, Integer::sum);
            while (counts.size() > 2) {
                int leftItem = items[left];
                int remaining = counts.get(leftItem) - 1;
                if (remaining == 0) {
                    counts.remove(leftItem);
                } else {
                    counts.put(leftItem, remaining);
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
