package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedPrefixDictionaryTest {

    @Test
    void shorterWordComesFirst() {
        OrderedPrefixDictionary dictionary = new OrderedPrefixDictionary();
        dictionary.add("apply");
        dictionary.add("app");
        dictionary.add("apple");
        assertEquals("app", dictionary.kth("app", 1));
        assertEquals("apple", dictionary.kth("app", 2));
        assertEquals("apply", dictionary.kth("app", 3));
        assertEquals("NONE", dictionary.kth("app", 4));
    }

    @Test
    void missingPrefix() {
        OrderedPrefixDictionary dictionary = new OrderedPrefixDictionary();
        dictionary.add("cat");
        assertEquals("NONE", dictionary.kth("dog", 1));
    }

    @Test
    void afterRemove() {
        OrderedPrefixDictionary dictionary = new OrderedPrefixDictionary();
        dictionary.add("ab");
        dictionary.add("ac");
        dictionary.remove("ab");
        assertEquals("ac", dictionary.kth("a", 1));
        assertEquals("NONE", dictionary.kth("a", 2));
    }
}
