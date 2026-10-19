package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NQueensCountTest {

    @Test
    void fourQueensNoForbidden() {
        assertEquals(2, NQueensCount.count(4, new boolean[4][4]));
    }

    @Test
    void oneQueen() {
        assertEquals(1, NQueensCount.count(1, new boolean[1][1]));
    }

    @Test
    void forbiddenBlocksAll() {
        boolean[][] forbidden = new boolean[1][1];
        forbidden[0][0] = true;
        assertEquals(0, NQueensCount.count(1, forbidden));
    }

    @Test
    void eightQueens() {
        assertEquals(92, NQueensCount.count(8, new boolean[8][8]));
    }
}
