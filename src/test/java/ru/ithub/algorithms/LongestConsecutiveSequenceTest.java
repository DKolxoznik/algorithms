package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest {

    @Test
    void exampleFromAssignment() {
        assertEquals(4, LongestConsecutiveSequence.findLength(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    void consecutiveAlmostFullRange() {
        assertEquals(9, LongestConsecutiveSequence.findLength(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, LongestConsecutiveSequence.findLength(new int[]{}));
    }

    @Test
    void singleElement() {
        assertEquals(1, LongestConsecutiveSequence.findLength(new int[]{42}));
    }

    @Test
    void duplicatesDoNotExtendSequence() {
        assertEquals(3, LongestConsecutiveSequence.findLength(new int[]{1, 2, 2, 3, 3, 3}));
    }
}
