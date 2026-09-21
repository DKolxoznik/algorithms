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
}
