package ru.ithub.algorithms.kt3;

import java.util.Arrays;

/**
 * Демонстрация примеров КТ№3. В IntelliJ IDEA: Run 'Kt3Main.main()'.
 */
public final class Kt3Main {

    public static void main(String[] args) {
        System.out.println("КТ№3 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Дни до более высокой цены");
        System.out.println(Arrays.toString(DaysUntilHigherPrice.daysToWait(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println();

        System.out.println("2. Кратчайший путь в лабиринте");
        System.out.println(ShortestPathInMaze.shortestPath(new char[][]{
                "S.#.".toCharArray(),
                ".#T.".toCharArray(),
                "....".toCharArray()
        }));
        System.out.println(ShortestPathInMaze.shortestPath(new char[][]{
                "S#T".toCharArray()
        }));
        System.out.println();

        System.out.println("3. Цикл в списке next[]");
        System.out.println(LinkedListCycle.hasCycle(new int[]{0, 2, 3, 1}, 1) ? "YES" : "NO");
        System.out.println(LinkedListCycle.hasCycle(new int[]{0, 2, -1}, 1) ? "YES" : "NO");
        System.out.println();

        System.out.println("4. Максимальный прямоугольник из единиц");
        System.out.println(MaximalRectangle.maxArea(new char[][]{
                "1010".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()
        }));
        System.out.println();

        System.out.println("5. Путь с ключами и дверями");
        System.out.println(ShortestPathWithKeys.shortestPath(new char[][]{
                "S.aA".toCharArray(),
                "###.".toCharArray(),
                "...T".toCharArray()
        }));
        System.out.println();

        System.out.println("6. Повторяющееся число");
        System.out.println(FindDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(FindDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
