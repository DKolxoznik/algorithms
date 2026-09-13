package ru.ithub.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задача 2. Тройки с нулевой суммой.
 * Время: O(n^2), память: O(1) сверх результата.
 */
public final class ZeroSumTriplets {

    private ZeroSumTriplets() {
    }

    public static List<List<Integer>> find(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length - 2; i++) {
            if (sorted[i] > 0) {
                break;
            }
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                long sum = (long) sorted[i] + sorted[left] + sorted[right];
                if (sum == 0) {
                    result.add(List.of(sorted[i], sorted[left], sorted[right]));
                    int leftValue = sorted[left];
                    int rightValue = sorted[right];
                    while (left < right && sorted[left] == leftValue) {
                        left++;
                    }
                    while (left < right && sorted[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
