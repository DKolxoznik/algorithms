package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestTwoTypesSubarrayTest {

    @Test
    void wholeArrayFits() {
        assertEquals(3, LongestTwoTypesSubarray.findLength(new int[]{1, 2, 1}));
    }

    @Test
    void dropsFirstType() {
        assertEquals(3, LongestTwoTypesSubarray.findLength(new int[]{0, 1, 2, 2}));
    }

    @Test
    void suffixWithTwoTypes() {
        assertEquals(4, LongestTwoTypesSubarray.findLength(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, LongestTwoTypesSubarray.findLength(new int[]{}));
    }

    @Test
    void singleType() {
        assertEquals(4, LongestTwoTypesSubarray.findLength(new int[]{7, 7, 7, 7}));
    }
}
