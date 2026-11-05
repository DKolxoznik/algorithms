package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPalindromePartitionsTest {

    @Test
    void sampleAab() {
        assertEquals(2, MinPalindromePartitions.minParts("aab"));
    }

    @Test
    void alreadyPalindrome() {
        assertEquals(1, MinPalindromePartitions.minParts("aba"));
    }

    @Test
    void allDistinct() {
        assertEquals(3, MinPalindromePartitions.minParts("abc"));
    }
}
