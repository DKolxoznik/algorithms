package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseKGroupTest {

    @Test
    void kEqualsTwo() {
        assertArrayEquals(
                new int[]{2, 1, 4, 3, 5},
                ListNode.toArray(ReverseKGroup.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2))
        );
    }

    @Test
    void kEqualsThree() {
        assertArrayEquals(
                new int[]{3, 2, 1, 4, 5},
                ListNode.toArray(ReverseKGroup.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 3))
        );
    }

    @Test
    void kGreaterThanN() {
        assertArrayEquals(
                new int[]{1, 2, 3},
                ListNode.toArray(ReverseKGroup.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3}), 5))
        );
    }

    @Test
    void kEqualsOne() {
        assertArrayEquals(
                new int[]{1, 2, 3},
                ListNode.toArray(ReverseKGroup.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3}), 1))
        );
    }
}
