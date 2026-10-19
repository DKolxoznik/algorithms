package ru.ithub.algorithms.kt6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt6StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1Reverse() {
        assertEquals("5 4 3 2 1", run(ReverseLinkedList::main, "5\n1 2 3 4 5\n"));
    }

    @Test
    void task2Connectivity() {
        assertEquals("YES\nNO\nYES", run(ConnectivityQueries::main, """
                3 5
                2 1 1
                2 1 2
                1 1 2
                1 2 3
                2 1 3
                """));
    }

    @Test
    void task3Topo() {
        assertEquals("1 2 3", run(LexicographicTopoSort::main, """
                3 2
                1 2
                1 3
                """));
    }

    @Test
    void task4ReverseK() {
        assertEquals("2 1 4 3 5", run(ReverseKGroup::main, "5 2\n1 2 3 4 5\n"));
    }

    @Test
    void task5Groups() {
        assertEquals("YES\nYES\nNO", run(BipartiteConstraints::main, """
                3 3
                1 2 0
                2 3 1
                1 3 0
                """));
    }

    @Test
    void task6Alien() {
        assertEquals("bac", run(AlienDictionary::main, """
                3 3
                ba
                bc
                ac
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
