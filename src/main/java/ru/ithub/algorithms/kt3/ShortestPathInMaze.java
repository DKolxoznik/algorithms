package ru.ithub.algorithms.kt3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * КТ№3, задача 2. Кратчайший путь от S до T по свободным клеткам.
 * Время: O(n * m), память: O(n * m).
 */
public final class ShortestPathInMaze {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private ShortestPathInMaze() {
    }

    public static int shortestPath(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startRow = -1;
        int startCol = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 'S') {
                    startRow = r;
                    startCol = c;
                }
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            if (grid[r][c] == 'T') {
                return dist;
            }
            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k];
                int nc = c + DC[k];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (visited[nr][nc] || grid[nr][nc] == '#') {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dist + 1});
            }
        }
        return -1;
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
        out.println(shortestPath(grid));
        out.flush();
    }
}
