package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№6, задача 1. Разворот односвязного списка на месте, O(1) доп. памяти.
 */
public final class ReverseLinkedList {

    private ReverseLinkedList() {
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        ListNode head = reverse(ListNode.fromArray(values));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
        boolean first = true;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (!first) {
                out.print(' ');
            }
            out.print(cur.value);
            first = false;
        }
        out.println();
        out.flush();
    }
}
