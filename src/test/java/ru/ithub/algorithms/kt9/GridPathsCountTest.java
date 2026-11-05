package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridPathsCountTest {

    @Test
    void openGrid() {
        assertEquals(2, GridPathsCount.count(new char[][]{
                {'.', '.'},
                {'.', '.'}
        }));
    }

    @Test
    void withBlock() {
        assertEquals(2, GridPathsCount.count(new char[][]{
                {'.', '.', '.'},
                {'.', '#', '.'},
                {'.', '.', '.'}
        }));
    }

    @Test
    void startBlocked() {
        assertEquals(0, GridPathsCount.count(new char[][]{
                {'#', '.'},
                {'.', '.'}
        }));
    }
}
