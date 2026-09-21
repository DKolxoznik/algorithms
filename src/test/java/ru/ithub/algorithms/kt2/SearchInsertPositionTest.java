package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertPositionTest {

    @Test
    void existingValue() {
        assertEquals(2, SearchInsertPosition.findIndex(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    void insertInTheMiddle() {
        assertEquals(1, SearchInsertPosition.findIndex(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    void insertAtTheEnd() {
        assertEquals(4, SearchInsertPosition.findIndex(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    void firstOccurrenceOfDuplicates() {
        assertEquals(1, SearchInsertPosition.findIndex(new int[]{1, 3, 3, 3, 5}, 3));
    }

    @Test
    void emptyArray() {
        assertEquals(0, SearchInsertPosition.findIndex(new int[]{}, 1));
    }
}
