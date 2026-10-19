package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixDictionaryTest {

    @Test
    void countAfterAddAndRemove() {
        PrefixDictionary dictionary = new PrefixDictionary();
        dictionary.add("apple");
        dictionary.add("app");
        dictionary.add("apply");
        assertEquals(3, dictionary.count("app"));
        assertEquals(1, dictionary.count("apple"));
        dictionary.remove("app");
        assertEquals(2, dictionary.count("app"));
        assertEquals(0, dictionary.count("z"));
    }

    @Test
    void emptyPrefixMeansAllWords() {
        PrefixDictionary dictionary = new PrefixDictionary();
        dictionary.add("a");
        dictionary.add("b");
        assertEquals(2, dictionary.count(""));
    }
}
