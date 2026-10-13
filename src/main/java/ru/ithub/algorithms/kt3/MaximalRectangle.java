package ru.ithub.algorithms.kt3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * КТ№3, задача 4. Максимальная площадь прямоугольника из единиц.
 * Время: O(n * m), память: O(m).
 */
public final class MaximalRectangle {

    private MaximalRectangle() {
    }

    public static int maxArea(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int best = 0;
        for (char[] row : matrix) {
            for (int c = 0; c < cols; c++) {
                heights[c] = row[c] == '1' ? heights[c] + 1 : 0;
            }
            best = Math.max(best, largestRectangle(heights));
        }
        return best;
    }

    static int largestRectangle(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > current) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                best = Math.max(best, height * width);
            }
            stack.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = in.next();
            matrix[i] = row.toCharArray();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(maxArea(matrix));
        out.flush();
    }
}
