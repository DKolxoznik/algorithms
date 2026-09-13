package ru.ithub.algorithms;

/**
 * Задача 6. Минимальная подстрока-покрытие.
 * Время: O(n + m), память: O(1) для ASCII.
 */
public final class MinCoveringSubstring {

    private MinCoveringSubstring() {
    }

    public static String find(String source, String target) {
        if (source == null || target == null || source.isEmpty() || target.isEmpty()) {
            return "";
        }
        if (target.length() > source.length()) {
            return "";
        }

        int[] need = new int[128];
        int required = 0;
        for (int i = 0; i < target.length(); i++) {
            char symbol = target.charAt(i);
            if (need[symbol] == 0) {
                required++;
            }
            need[symbol]++;
        }

        int[] window = new int[128];
        int formed = 0;
        int bestLength = Integer.MAX_VALUE;
        int bestLeft = 0;
        int left = 0;

        for (int right = 0; right < source.length(); right++) {
            char added = source.charAt(right);
            window[added]++;
            if (need[added] > 0 && window[added] == need[added]) {
                formed++;
            }

            while (formed == required) {
                int length = right - left + 1;
                if (length < bestLength) {
                    bestLength = length;
                    bestLeft = left;
                }

                char removed = source.charAt(left);
                if (need[removed] > 0 && window[removed] == need[removed]) {
                    formed--;
                }
                window[removed]--;
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE
                ? ""
                : source.substring(bestLeft, bestLeft + bestLength);
    }
}
