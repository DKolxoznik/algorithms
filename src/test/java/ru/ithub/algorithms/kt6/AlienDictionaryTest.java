package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AlienDictionaryTest {

    @Test
    void classicOrder() {
        assertEquals("bac", AlienDictionary.findOrder(3, new String[]{"ba", "bc", "ac"}));
    }

    @Test
    void longerBeforePrefixImpossible() {
        assertNull(AlienDictionary.findOrder(2, new String[]{"ab", "a"}));
    }

    @Test
    void unusedLettersIncludedLexSmallest() {
        assertEquals("abc", AlienDictionary.findOrder(3, new String[]{"a", "b"}));
    }

    @Test
    void cycleImpossible() {
        assertNull(AlienDictionary.findOrder(2, new String[]{"ab", "ba", "aa"}));
    }

    @Test
    void equalNeighborsOk() {
        assertEquals("ab", AlienDictionary.findOrder(2, new String[]{"a", "a", "b"}));
    }
}
