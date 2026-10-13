package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListCycleTest {

    @Test
    void cycleExists() {
        // 1 -> 2 -> 3 -> 1
        assertTrue(LinkedListCycle.hasCycle(new int[]{0, 2, 3, 1}, 1));
    }

    @Test
    void noCycle() {
        // 1 -> 2 -> end
        assertFalse(LinkedListCycle.hasCycle(new int[]{0, 2, -1}, 1));
    }

    @Test
    void selfLoop() {
        assertTrue(LinkedListCycle.hasCycle(new int[]{0, 1}, 1));
    }

    @Test
    void cycleNotReachableFromStart() {
        // start at 1 -> end; cycle 2 -> 3 -> 2
        assertFalse(LinkedListCycle.hasCycle(new int[]{0, -1, 3, 2}, 1));
    }

    @Test
    void longPathIntoCycle() {
        // 1 -> 2 -> 3 -> 4 -> 3
        assertTrue(LinkedListCycle.hasCycle(new int[]{0, 2, 3, 4, 3}, 1));
    }
}
