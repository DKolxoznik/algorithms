package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathWithKeysTest {

    @Test
    void needKeyForDoor() {
        assertEquals(5, ShortestPathWithKeys.shortestPath(new char[][]{
                "S.aA".toCharArray(),
                "###.".toCharArray(),
                "...T".toCharArray()
        }));
    }

    @Test
    void doorWithoutKeyBlocked() {
        assertEquals(-1, ShortestPathWithKeys.shortestPath(new char[][]{
                "SA#T".toCharArray()
        }));
    }

    @Test
    void noDoorsSimplePath() {
        assertEquals(2, ShortestPathWithKeys.shortestPath(new char[][]{
                "S.T".toCharArray()
        }));
    }

    @Test
    void keyOnPath() {
        assertEquals(3, ShortestPathWithKeys.shortestPath(new char[][]{
                "SaAT".toCharArray()
        }));
    }
}
