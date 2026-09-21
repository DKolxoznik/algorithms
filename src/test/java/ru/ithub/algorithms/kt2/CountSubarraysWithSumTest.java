package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSubarraysWithSumTest {

    @Test
    void overlappingOnes() {
        assertEquals(2, CountSubarraysWithSum.count(new int[]{1, 1, 1}, 2));
    }

    @Test
    void zerosAndNegatives() {
        assertEquals(3, CountSubarraysWithSum.count(new int[]{1, -1, 0}, 0));
    }

    @Test
    void noMatches() {
        assertEquals(0, CountSubarraysWithSum.count(new int[]{1, 2, 3}, 7));
    }

    @Test
    void wholeArray() {
        assertEquals(1, CountSubarraysWithSum.count(new int[]{1, 2, 3}, 6));
    }
}
