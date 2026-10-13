package ru.ithub.algorithms.kt4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№4, задача 5. k-я наименьшая сумма A[i] + B[j] для отсортированных массивов.
 * Бинарный поиск по ответу. Время: O((n + m) log R).
 */
public final class KthPairSum {

    private KthPairSum() {
    }

    public static long find(int[] a, int[] b, long k) {
        long low = (long) a[0] + b[0];
        long high = (long) a[a.length - 1] + b[b.length - 1];
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessOrEqual(a, b, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static long countLessOrEqual(int[] a, int[] b, long limit) {
        long count = 0;
        int j = b.length - 1;
        for (int value : a) {
            while (j >= 0 && (long) value + b[j] > limit) {
                j--;
            }
            count += j + 1L;
            if (j < 0) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        out.println(find(a, b, k));
        out.flush();
    }
}
