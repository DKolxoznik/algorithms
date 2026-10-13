package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthPairSumTest {

    @Test
    void thirdSmallest() {
        assertEquals(7, KthPairSum.find(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    @Test
    void firstIsMinimalSum() {
        assertEquals(3, KthPairSum.find(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 1));
    }

    @Test
    void lastPair() {
        assertEquals(17, KthPairSum.find(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 9));
    }

    @Test
    void duplicatesCountedSeparately() {
        // pairs: 1+1=2, 1+1=2, 2+1=3, 2+1=3 → 2nd is 2
        assertEquals(2, KthPairSum.find(new int[]{1, 2}, new int[]{1, 1}, 2));
    }

    @Test
    void negativeNumbers() {
        assertEquals(-1, KthPairSum.find(new int[]{-5, -1}, new int[]{0, 4}, 2));
    }
}
