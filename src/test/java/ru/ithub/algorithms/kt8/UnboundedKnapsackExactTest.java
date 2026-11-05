package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UnboundedKnapsackExactTest {

    @Test
    void exactCapacity() {
        assertArrayEquals(
                new long[]{9, 2},
                UnboundedKnapsackExact.solve(5, new int[]{2, 3}, new long[]{4, 5})
        );
    }

    @Test
    void prefersHigherProfitThenFewerItems() {
        // C=6: 3*2 → profit 12, count 3; 2*3 → profit 10, count 2
        assertArrayEquals(
                new long[]{12, 3},
                UnboundedKnapsackExact.solve(6, new int[]{2, 3}, new long[]{4, 5})
        );
    }

    @Test
    void impossible() {
        assertNull(UnboundedKnapsackExact.solve(5, new int[]{2, 4}, new long[]{1, 1}));
    }
}
