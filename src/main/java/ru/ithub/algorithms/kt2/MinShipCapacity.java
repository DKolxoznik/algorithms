package ru.ithub.algorithms.kt2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№2, задача 4. Минимальная вместимость корабля за days дней.
 * Время: O(n log S), где S — сумма весов.
 */
public final class MinShipCapacity {

    private MinShipCapacity() {
    }

    public static long findCapacity(int[] weights, int days) {
        long low = 0;
        long high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean canShip(int[] weights, int days, long capacity) {
        int usedDays = 1;
        long loaded = 0;
        for (int weight : weights) {
            if (loaded + weight <= capacity) {
                loaded += weight;
            } else {
                usedDays++;
                loaded = weight;
                if (usedDays > days) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int days = in.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(findCapacity(weights, days));
        out.flush();
    }
}
