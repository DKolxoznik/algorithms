package ru.ithub.algorithms.kt8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№8, задача 3. Длина наибольшей общей подпоследовательности.
 */
public final class LongestCommonSubsequence {

    private LongestCommonSubsequence() {
    }

    public static int length(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + 1;
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }
        return prev[m];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        String s = in.next();
        String t = in.next();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(length(s, t));
        out.flush();
    }
}
