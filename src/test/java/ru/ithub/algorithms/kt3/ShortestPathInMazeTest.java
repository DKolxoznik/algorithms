package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathInMazeTest {

    @Test
    void reachablePath() {
        assertEquals(5, ShortestPathInMaze.shortestPath(new char[][]{
                "S.#.".toCharArray(),
                ".#T.".toCharArray(),
                "....".toCharArray()
        }));
    }

    @Test
    void blocked() {
        assertEquals(-1, ShortestPathInMaze.shortestPath(new char[][]{
                "S#T".toCharArray()
        }));
    }

    @Test
    void adjacent() {
        assertEquals(1, ShortestPathInMaze.shortestPath(new char[][]{
                "ST".toCharArray()
        }));
    }

    @Test
    void startIsTargetImpossibleSameCellNotAllowedByInputButSAndTDistinct() {
        assertEquals(2, ShortestPathInMaze.shortestPath(new char[][]{
                "S.T".toCharArray()
        }));
    }
}
