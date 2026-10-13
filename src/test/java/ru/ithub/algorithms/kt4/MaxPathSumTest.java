package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPathSumTest {

    @Test
    void classicExample() {
        BinaryTree tree = new BinaryTree(
                new int[]{-10, 9, 20, 15, 7},
                new int[]{1, -1, 3, -1, -1},
                new int[]{2, -1, 4, -1, -1}
        );
        assertEquals(42, MaxPathSum.compute(tree));
    }

    @Test
    void singleNegative() {
        BinaryTree tree = new BinaryTree(new int[]{-3}, new int[]{-1}, new int[]{-1});
        assertEquals(-3, MaxPathSum.compute(tree));
    }

    @Test
    void allPositive() {
        BinaryTree tree = new BinaryTree(
                new int[]{1, 2, 3},
                new int[]{1, -1, -1},
                new int[]{2, -1, -1}
        );
        assertEquals(6, MaxPathSum.compute(tree));
    }
}
