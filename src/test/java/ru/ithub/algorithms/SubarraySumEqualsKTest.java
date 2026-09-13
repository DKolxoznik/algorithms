package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumEqualsKTest {

    @Test
    void overlappingOnes() {
        assertEquals(2, SubarraySumEqualsK.count(new int[]{1, 1, 1}, 2));
    }

    @Test
    void zerosAndNegatives() {
        assertEquals(3, SubarraySumEqualsK.count(new int[]{1, -1, 0}, 0));
    }

    @Test
    void noMatches() {
        assertEquals(0, SubarraySumEqualsK.count(new int[]{1, 2, 3}, 7));
    }

    @Test
    void wholeArray() {
        assertEquals(1, SubarraySumEqualsK.count(new int[]{1, 2, 3}, 6));
    }
}
