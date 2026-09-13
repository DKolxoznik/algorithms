package ru.ithub.algorithms;

/**
 * Запуск примеров из КТ№1. В IntelliJ IDEA: Run 'Main.main()'.
 */
public final class Main {

    public static void main(String[] args) {
        System.out.println("КТ№1 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Самая длинная последовательность номеров");
        System.out.println(LongestConsecutiveSequence.findLength(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(LongestConsecutiveSequence.findLength(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(LongestConsecutiveSequence.findLength(new int[]{}));
        System.out.println();

        System.out.println("2. Тройки с нулевой суммой");
        System.out.println(ZeroSumTriplets.find(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(ZeroSumTriplets.find(new int[]{0, 0, 0, 0}));
        System.out.println(ZeroSumTriplets.find(new int[]{1, 2, -2, -1}));
        System.out.println();

        System.out.println("3. Самый длинный участок с ограниченным числом типов");
        System.out.println(LongestTwoTypesSubarray.findLength(new int[]{1, 2, 1}));
        System.out.println(LongestTwoTypesSubarray.findLength(new int[]{0, 1, 2, 2}));
        System.out.println(LongestTwoTypesSubarray.findLength(new int[]{1, 2, 3, 2, 2}));
        System.out.println();

        System.out.println("4. Количество подмассивов с заданной суммой");
        System.out.println(SubarraySumEqualsK.count(new int[]{1, 1, 1}, 2));
        System.out.println(SubarraySumEqualsK.count(new int[]{1, -1, 0}, 0));
        System.out.println();

        System.out.println("5. Максимальный объём воды между стенками");
        System.out.println(MaxWaterContainer.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(MaxWaterContainer.maxArea(new int[]{1, 1}));
        System.out.println();

        System.out.println("6. Минимальная подстрока-покрытие");
        System.out.println(MinCoveringSubstring.find("ADOBECODEBANC", "ABC"));
        System.out.println("\"" + MinCoveringSubstring.find("a", "aa") + "\"");
        System.out.println(MinCoveringSubstring.find("AAABBC", "AABC"));
    }
}
