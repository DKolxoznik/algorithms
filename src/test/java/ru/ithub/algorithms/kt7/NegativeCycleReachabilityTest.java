package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NegativeCycleReachabilityTest {

    @Test
    void marksReachableFromNegativeCycle() {
        String[] result = NegativeCycleReachability.classify(
                3, 1,
                new int[]{1, 2, 2},
                new int[]{2, 3, 2},
                new long[]{1, 1, -1}
        );
        assertEquals("0", result[1]);
        assertEquals("-", result[2]);
        assertEquals("-", result[3]);
    }

    @Test
    void unreachableStar() {
        String[] result = NegativeCycleReachability.classify(
                2, 1,
                new int[]{},
                new int[]{},
                new long[]{}
        );
        assertEquals("0", result[1]);
        assertEquals("*", result[2]);
    }

    @Test
    void finiteNegativePath() {
        String[] result = NegativeCycleReachability.classify(
                3, 1,
                new int[]{1, 2},
                new int[]{2, 3},
                new long[]{5, -2}
        );
        assertArrayEquals(new String[]{null, "0", "5", "3"}, result);
    }
}
