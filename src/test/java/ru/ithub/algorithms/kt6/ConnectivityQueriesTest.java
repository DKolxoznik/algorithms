package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConnectivityQueriesTest {

    @Test
    void connectAndQuery() {
        ConnectivityQueries dsu = new ConnectivityQueries(4);
        assertTrue(dsu.connected(2, 2));
        assertFalse(dsu.connected(1, 3));
        dsu.connect(1, 2);
        dsu.connect(2, 3);
        assertTrue(dsu.connected(1, 3));
        assertFalse(dsu.connected(1, 4));
        dsu.connect(1, 2);
        assertTrue(dsu.connected(1, 2));
    }
}
