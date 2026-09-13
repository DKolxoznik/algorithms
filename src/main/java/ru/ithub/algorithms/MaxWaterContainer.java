package ru.ithub.algorithms;

/**
 * Задача 5. Максимальный объём воды между стенками.
 * Время: O(n), память: O(1).
 */
public final class MaxWaterContainer {

    private MaxWaterContainer() {
    }

    public static long maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        long best = 0;

        while (left < right) {
            long area = (long) (right - left) * Math.min(height[left], height[right]);
            best = Math.max(best, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }
}
