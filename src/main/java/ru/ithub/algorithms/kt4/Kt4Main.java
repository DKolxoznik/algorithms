package ru.ithub.algorithms.kt4;

import java.util.Arrays;
import java.util.Locale;

/**
 * Демонстрация примеров КТ№4. В IntelliJ IDEA: Run 'Kt4Main.main()'.
 */
public final class Kt4Main {

    public static void main(String[] args) {
        System.out.println("КТ№4 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Суммы по уровням");
        BinaryTree tree1 = new BinaryTree(
                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 3, -1, -1, -1},
                new int[]{2, 4, -1, -1, -1}
        );
        System.out.println(Arrays.toString(LevelSums.compute(tree1)));
        System.out.println();

        System.out.println("2. Top-K частых");
        System.out.println(Arrays.toString(TopKFrequent.find(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println();

        System.out.println("3. Бегущая медиана");
        printDoubles(RunningMedian.compute(new int[]{1, 2, 3, 4}));
        System.out.println();

        System.out.println("4. Максимальный путь");
        BinaryTree tree4 = new BinaryTree(
                new int[]{-10, 9, 20, 15, 7},
                new int[]{1, -1, 3, -1, -1},
                new int[]{2, -1, 4, -1, -1}
        );
        System.out.println(MaxPathSum.compute(tree4));
        System.out.println();

        System.out.println("5. k-я сумма пары");
        System.out.println(KthPairSum.find(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println();

        System.out.println("6. Медианы окна");
        printDoubles(SlidingWindowMedian.compute(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    private static void printDoubles(double[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(String.format(Locale.US, "%.1f", values[i]));
        }
        System.out.println(sb);
    }
}
