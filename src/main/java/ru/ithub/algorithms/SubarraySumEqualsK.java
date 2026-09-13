package ru.ithub.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Задача 4. Количество подмассивов с заданной суммой.
 * Время: O(n), память: O(n).
 */
public final class SubarraySumEqualsK {

    private SubarraySumEqualsK() {
    }

    public static long count(int[] nums, long k) {
        Map<Long, Integer> prefixFrequency = new HashMap<>();
        prefixFrequency.put(0L, 1);

        long prefix = 0;
        long total = 0;
        for (int num : nums) {
            prefix += num;
            total += prefixFrequency.getOrDefault(prefix - k, 0);
            prefixFrequency.merge(prefix, 1, Integer::sum);
        }
        return total;
    }
}
