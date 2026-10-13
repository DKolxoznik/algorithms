package ru.ithub.algorithms.kt3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * КТ№3, задача 1. Для каждого дня — сколько дней ждать более высокую цену.
 * Время: O(n), память: O(n).
 */
public final class DaysUntilHigherPrice {

    private DaysUntilHigherPrice() {
    }

    public static int[] daysToWait(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                int day = stack.pop();
                answer[day] = i - day;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        int[] answer = daysToWait(prices);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        for (int i = 0; i < answer.length; i++) {
            if (i > 0) {
                out.print(' ');
            }
            out.print(answer[i]);
        }
        out.println();
        out.flush();
    }
}
