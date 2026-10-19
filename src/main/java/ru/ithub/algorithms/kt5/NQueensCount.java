package ru.ithub.algorithms.kt5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№5, задача 4. Число расстановок n ферзей с запрещёнными клетками.
 * Бэктрекинг с битовыми масками. n ≤ 14.
 */
public final class NQueensCount {

    private NQueensCount() {
    }

    public static long count(int n, boolean[][] forbidden) {
        return dfs(0, 0, 0, 0, n, forbidden);
    }

    private static long dfs(int row, int cols, int diag1, int diag2, int n, boolean[][] forbidden) {
        if (row == n) {
            return 1;
        }
        long total = 0;
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);
        while (available != 0) {
            int bit = available & -available;
            available ^= bit;
            int col = Integer.numberOfTrailingZeros(bit);
            if (forbidden[row][col]) {
                continue;
            }
            total += dfs(
                    row + 1,
                    cols | bit,
                    (diag1 | bit) << 1,
                    (diag2 | bit) >> 1,
                    n,
                    forbidden
            );
        }
        return total;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        boolean[][] forbidden = new boolean[n][n];
        for (int i = 0; i < b; i++) {
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            forbidden[row][col] = true;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(count(n, forbidden));
        out.flush();
    }
}
