package ru.ithub.algorithms.kt9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№9, задача 2. Число путей вправо/вниз по карте.
 * DP O(n·m).
 */
public final class GridPathsCount {

    private static final int MOD = 1_000_000_007;

    private GridPathsCount() {
    }

    public static int count(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == '#' || grid[n - 1][m - 1] == '#') {
            return 0;
        }
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    dp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                    continue;
                }
                int fromLeft = j > 0 ? dp[j - 1] : 0;
                int fromUp = i > 0 ? dp[j] : 0;
                dp[j] = fromLeft + fromUp;
                if (dp[j] >= MOD) {
                    dp[j] -= MOD;
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = in.next();
            grid[i] = row.toCharArray();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(count(grid));
        out.flush();
    }
}
