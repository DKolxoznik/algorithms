package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDuplicateNumberTest {

    @Test
    void duplicateTwo() {
        assertEquals(2, FindDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void duplicateThree() {
        assertEquals(3, FindDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    void duplicateAtStartValues() {
        assertEquals(1, FindDuplicateNumber.findDuplicate(new int[]{1, 1}));
    }

    @Test
    void largerArray() {
        assertEquals(7, FindDuplicateNumber.findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 7}));
    }
}
