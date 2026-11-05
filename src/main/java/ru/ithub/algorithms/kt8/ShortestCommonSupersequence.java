package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№8, задача 6. Кратчайшая общая суперпоследовательность,
 * лексикографически наименьшая среди минимальных по длине.
 */
public final class ShortestCommonSupersequence {

    private ShortestCommonSupersequence() {
    }

    public static String build(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] len = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            len[i][m] = n - i;
        }
        for (int j = m - 1; j >= 0; j--) {
            len[n][j] = m - j;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    len[i][j] = 1 + len[i + 1][j + 1];
                } else {
                    len[i][j] = 1 + Math.min(len[i + 1][j], len[i][j + 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder(len[0][0]);
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            if (i < n && j < m && s.charAt(i) == t.charAt(j)) {
                result.append(s.charAt(i));
                i++;
                j++;
                continue;
            }
            boolean canTakeS = i < n && len[i][j] == 1 + len[i + 1][j];
            boolean canTakeT = j < m && len[i][j] == 1 + len[i][j + 1];
            if (canTakeS && canTakeT) {
                if (s.charAt(i) <= t.charAt(j)) {
                    result.append(s.charAt(i));
                    i++;
                } else {
                    result.append(t.charAt(j));
                    j++;
                }
            } else if (canTakeS) {
                result.append(s.charAt(i));
                i++;
            } else {
                result.append(t.charAt(j));
                j++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        String s = in.next();
        String t = in.next();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(build(s, t));
        out.flush();
    }
}
