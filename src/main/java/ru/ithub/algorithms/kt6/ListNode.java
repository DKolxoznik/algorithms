package ru.ithub.algorithms.kt6;

/**
 * Узел односвязного списка для задач КТ№6.
 */
public final class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static ListNode fromArray(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int value : values) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static int[] toArray(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        int[] values = new int[size];
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            values[i++] = cur.value;
        }
        return values;
    }
}
