package ru.ithub.algorithms.kt9;

/**
 * Демонстрация примеров КТ№9. В IntelliJ IDEA: Run 'Kt9Main.main()'.
 */
public final class Kt9Main {

    public static void main(String[] args) {
        System.out.println("КТ№9 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Палиндромные части");
        System.out.println(MinPalindromePartitions.minParts("aab"));
        System.out.println();

        System.out.println("2. Пути по карте");
        System.out.println(GridPathsCount.count(new char[][]{
                {'.', '.', '.'},
                {'.', '#', '.'},
                {'.', '.', '.'}
        }));
        System.out.println();

        System.out.println("3. Независимое множество");
        System.out.println(MaxIndependentSetTree.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}}
        ));
        System.out.println();

        System.out.println("4. Объединение групп");
        System.out.println(MinMergeCost.minCost(new long[]{1, 2, 3, 4}));
        System.out.println();

        System.out.println("5. Путь с экранами");
        System.out.println(MaxPathWithScreens.maxSum(new long[][]{
                {1, -2},
                {-3, 4}
        }, 1));
        System.out.println();

        System.out.println("6. Связное подмножество размера k");
        System.out.println(MaxConnectedSubsetK.maxValue(
                new long[]{1, 2, 3, 4},
                new int[][]{{1, 2}, {1, 3}, {3, 4}},
                2
        ));
    }
}
