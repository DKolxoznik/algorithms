package ru.ithub.algorithms.kt9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt9StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1PalindromeParts() {
        assertEquals("2", run(MinPalindromePartitions::main, "aab\n"));
    }

    @Test
    void task2GridPaths() {
        assertEquals("2", run(GridPathsCount::main, """
                3 3
                ...
                .#.
                ...
                """));
    }

    @Test
    void task3IndependentSet() {
        assertEquals("6", run(MaxIndependentSetTree::main, """
                4
                1 2 3 4
                1 2
                1 3
                3 4
                """));
    }

    @Test
    void task4MergeCost() {
        assertEquals("19", run(MinMergeCost::main, """
                4
                1 2 3 4
                """));
    }

    @Test
    void task5PathScreens() {
        assertEquals("5", run(MaxPathWithScreens::main, """
                2 2 1
                1 -2
                -3 4
                """));
    }

    @Test
    void task6ConnectedK() {
        assertEquals("7", run(MaxConnectedSubsetK::main, """
                4 2
                1 2 3 4
                1 2
                1 3
                3 4
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
