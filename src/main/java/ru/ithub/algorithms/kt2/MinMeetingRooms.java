package ru.ithub.algorithms.kt2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * КТ№2, задача 6. Минимум переговорных комнат для полуоткрытых интервалов [start, end).
 * Время: O(n log n), память: O(n).
 */
public final class MinMeetingRooms {

    private MinMeetingRooms() {
    }

    public static int countRooms(int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        int n = meetings.length;
        long[] starts = new long[n];
        long[] ends = new long[n];
        for (int i = 0; i < n; i++) {
            starts[i] = meetings[i][0];
            ends[i] = meetings[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int best = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < n) {
            if (starts[startIndex] < ends[endIndex]) {
                rooms++;
                best = Math.max(best, rooms);
                startIndex++;
            } else {
                rooms--;
                endIndex++;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = in.nextInt();
            meetings[i][1] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(countRooms(meetings));
        out.flush();
    }
}
