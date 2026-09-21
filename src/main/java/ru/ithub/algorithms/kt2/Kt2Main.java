package ru.ithub.algorithms.kt2;

import java.util.Arrays;

/**
 * Демонстрация примеров КТ№2. В IntelliJ IDEA: Run 'Kt2Main.main()'.
 */
public final class Kt2Main {

    public static void main(String[] args) {
        System.out.println("КТ№2 — практикум по алгоритмам");
        System.out.println();

        System.out.println("1. Первая позиция вставки");
        System.out.println(SearchInsertPosition.findIndex(new int[]{1, 3, 5, 6}, 5));
        System.out.println(SearchInsertPosition.findIndex(new int[]{1, 3, 5, 6}, 2));
        System.out.println(SearchInsertPosition.findIndex(new int[]{1, 3, 3, 3, 5}, 3));
        System.out.println();

        System.out.println("2. Суммы на отрезках");
        System.out.println(Arrays.toString(RangeSumQueries.answer(
                new int[]{1, 2, 3, 4},
                new int[][]{{0, 3}, {1, 2}})));
        System.out.println();

        System.out.println("3. Объединение интервалов");
        printIntervals(MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        printIntervals(MergeIntervals.merge(new int[][]{{1, 4}, {4, 5}}));
        System.out.println();

        System.out.println("4. Минимальная вместимость корабля");
        System.out.println(MinShipCapacity.findCapacity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println();

        System.out.println("5. Подмассивы с суммой k");
        System.out.println(CountSubarraysWithSum.count(new int[]{1, 1, 1}, 2));
        System.out.println(CountSubarraysWithSum.count(new int[]{1, -1, 0}, 0));
        System.out.println();

        System.out.println("6. Минимум переговорных комнат");
        System.out.println(MinMeetingRooms.countRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(MinMeetingRooms.countRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(MinMeetingRooms.countRooms(new int[][]{{1, 2}, {2, 3}}));
    }

    private static void printIntervals(int[][] intervals) {
        System.out.println(Arrays.deepToString(intervals));
    }
}
