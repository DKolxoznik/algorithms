package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListTest {

    @Test
    void reverseFive() {
        assertArrayEquals(
                new int[]{5, 4, 3, 2, 1},
                ListNode.toArray(ReverseLinkedList.reverse(ListNode.fromArray(new int[]{1, 2, 3, 4, 5})))
        );
    }

    @Test
    void singleNode() {
        assertArrayEquals(
                new int[]{7},
                ListNode.toArray(ReverseLinkedList.reverse(ListNode.fromArray(new int[]{7})))
        );
    }
}
