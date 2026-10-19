package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * КТ№5, задача 1. Все правильные скобочные последовательности из n пар.
 * Лексикографический порядок: '(' < ')'. Время: O(C_n * n).
 */
public final class GenerateParentheses {

    private GenerateParentheses() {
    }

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        char[] path = new char[2 * n];
        dfs(n, 0, 0, 0, path, result);
        return result;
    }

    private static void dfs(int n, int open, int close, int pos, char[] path, List<String> result) {
        if (pos == path.length) {
            result.add(new String(path));
            return;
        }
        if (open < n) {
            path[pos] = '(';
            dfs(n, open + 1, close, pos + 1, path, result);
        }
        if (close < open) {
            path[pos] = ')';
            dfs(n, open, close + 1, pos + 1, path, result);
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (String sequence : generate(n)) {
            out.println(sequence);
        }
        out.flush();
    }
}
