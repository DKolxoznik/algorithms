package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortestCommonSupersequenceTest {

    @Test
    void classicExample() {
        String result = ShortestCommonSupersequence.build("abac", "cab");
        assertEquals(5, result.length());
        assertTrue(isSubsequence("abac", result));
        assertTrue(isSubsequence("cab", result));
    }

    @Test
    void prefersLexicographicallySmaller() {
        assertEquals("abc", ShortestCommonSupersequence.build("ab", "ac"));
    }

    @Test
    void identicalStrings() {
        assertEquals("xyz", ShortestCommonSupersequence.build("xyz", "xyz"));
    }

    private static boolean isSubsequence(String pattern, String text) {
        int i = 0;
        for (int j = 0; j < text.length() && i < pattern.length(); j++) {
            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
            }
        }
        return i == pattern.length();
    }
}
