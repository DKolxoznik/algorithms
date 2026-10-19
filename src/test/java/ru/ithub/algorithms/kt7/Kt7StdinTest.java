package ru.ithub.algorithms.kt7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt7StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1Dijkstra() {
        assertEquals("0 5 6", run(DijkstraShortestPaths::main, """
                3 2 1
                1 2 5
                2 3 1
                """));
    }

    @Test
    void task2BellmanFord() {
        assertEquals("0 5 3", run(BellmanFordShortestPaths::main, """
                3 2 1
                1 2 5
                2 3 -2
                """));
    }

    @Test
    void task3HelpStations() {
        assertEquals("1 0\n1 3\n3 0", run(NearestHelpStations::main, """
                3 2 2
                1 3
                1 2 3
                2 3 4
                """));
    }

    @Test
    void task4Coupon() {
        assertEquals("15", run(CouponShortestPath::main, """
                3 2 1 3
                1 2 10
                2 3 10
                """));
    }

    @Test
    void task5NegativeCycles() {
        assertEquals("0\n-\n-", run(NegativeCycleReachability::main, """
                3 3 1
                1 2 1
                2 3 1
                2 2 -1
                """));
    }

    @Test
    void task6LimitedEdges() {
        assertEquals("2 1", run(LimitedEdgesShortestPaths::main, """
                3 2 1 3 2
                1 2 1
                2 3 1
                """));
    }

    private static String run(MainMethod main, String input) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer, true, StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        System.setOut(out);
        main.run(new String[0]);
        out.flush();
        return buffer.toString(StandardCharsets.UTF_8).trim().replace("\r\n", "\n");
    }

    @FunctionalInterface
    private interface MainMethod {
        void run(String[] args);
    }
}
