package ru.ithub.algorithms.kt8;

import java.util.Arrays;

/**
 * Демонстрация примеров КТ№8. В IntelliJ IDEA: Run 'Kt8Main.main()'.
 */
public final class Kt8Main {

    public static void main(String[] args) {
        System.out.println("КТ№8 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Платформы");
        System.out.println(MinPlatformCost.minCost(new int[]{10, 20, 30, 10}));
        System.out.println();

        System.out.println("2. Рюкзак 0/1");
        System.out.println(ZeroOneKnapsack.maxValue(5, new int[]{2, 3, 4}, new long[]{3, 4, 5}));
        System.out.println();

        System.out.println("3. НОП");
        System.out.println(LongestCommonSubsequence.length("abcde", "ace"));
        System.out.println();

        System.out.println("4. Неограниченный рюкзак");
        System.out.println(Arrays.toString(
                UnboundedKnapsackExact.solve(5, new int[]{2, 3}, new long[]{4, 5})
        ));
        System.out.println();

        System.out.println("5. НВП + количество");
        System.out.println(Arrays.toString(LisCount.solve(new int[]{1, 3, 2, 4})));
        System.out.println();

        System.out.println("6. SCS");
        System.out.println(ShortestCommonSupersequence.build("abac", "cab"));
    }
}
