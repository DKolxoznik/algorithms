package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {

    @Test
    void classicExample() {
        assertEquals(3, LongestCommonSubsequence.length("abcde", "ace"));
    }

    @Test
    void noCommon() {
        assertEquals(0, LongestCommonSubsequence.length("abc", "def"));
    }

    @Test
    void identical() {
        assertEquals(4, LongestCommonSubsequence.length("test", "test"));
    }
}
