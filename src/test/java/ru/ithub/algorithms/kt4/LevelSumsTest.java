package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LevelSumsTest {

    @Test
    void threeLevels() {
        BinaryTree tree = new BinaryTree(
                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 3, -1, -1, -1},
                new int[]{2, 4, -1, -1, -1}
        );
        assertArrayEquals(new long[]{1, 5, 9}, LevelSums.compute(tree));
    }

    @Test
    void singleNode() {
        BinaryTree tree = new BinaryTree(new int[]{42}, new int[]{-1}, new int[]{-1});
        assertArrayEquals(new long[]{42}, LevelSums.compute(tree));
    }

    @Test
    void negativeValues() {
        BinaryTree tree = new BinaryTree(
                new int[]{-1, -2, -3},
                new int[]{1, -1, -1},
                new int[]{2, -1, -1}
        );
        assertArrayEquals(new long[]{-1, -5}, LevelSums.compute(tree));
    }
}
