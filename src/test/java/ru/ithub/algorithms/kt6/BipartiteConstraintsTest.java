package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BipartiteConstraintsTest {

    @Test
    void becomesInconsistentThenStays() {
        BipartiteConstraints solver = new BipartiteConstraints(3);
        assertTrue(solver.addConstraint(1, 2, 0));
        assertTrue(solver.addConstraint(2, 3, 1));
        assertFalse(solver.addConstraint(1, 3, 0));
        assertFalse(solver.addConstraint(1, 2, 0));
    }

    @Test
    void selfDifferentIsContradiction() {
        BipartiteConstraints solver = new BipartiteConstraints(2);
        assertFalse(solver.addConstraint(1, 1, 1));
    }

    @Test
    void selfSameIsOk() {
        BipartiteConstraints solver = new BipartiteConstraints(2);
        assertTrue(solver.addConstraint(1, 1, 0));
    }

    @Test
    void consistentChain() {
        BipartiteConstraints solver = new BipartiteConstraints(4);
        assertTrue(solver.addConstraint(1, 2, 1));
        assertTrue(solver.addConstraint(2, 3, 1));
        assertTrue(solver.addConstraint(1, 3, 0));
    }
}
