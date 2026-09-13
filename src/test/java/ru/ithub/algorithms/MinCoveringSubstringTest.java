package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCoveringSubstringTest {

    @Test
    void classicExample() {
        assertEquals("BANC", MinCoveringSubstring.find("ADOBECODEBANC", "ABC"));
    }

    @Test
    void impossible() {
        assertEquals("", MinCoveringSubstring.find("a", "aa"));
    }

    @Test
    void repeatedLetters() {
        assertEquals("AABBC", MinCoveringSubstring.find("AAABBC", "AABC"));
    }

    @Test
    void wholeSource() {
        assertEquals("abc", MinCoveringSubstring.find("abc", "cba"));
    }

    @Test
    void caseSensitive() {
        assertEquals("", MinCoveringSubstring.find("abc", "A"));
    }
}
