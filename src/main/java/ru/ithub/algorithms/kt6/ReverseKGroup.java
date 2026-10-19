package ru.ithub.algorithms.kt6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * КТ№6, задача 4. Разворот блоков по k узлов; хвост короче k не трогаем.
 * Доп. память O(1).
 */
public final class ReverseKGroup {

    private ReverseKGroup() {
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while (cur != groupNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode newGroupHead = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = newGroupHead;
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        ListNode head = reverseKGroup(ListNode.fromArray(values), k);
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
