package ru.ithub.algorithms.kt8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt8StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1Platforms() {
        assertEquals("20", run(MinPlatformCost::main, "4\n10 20 30 10\n"));
    }

    @Test
    void task2Knapsack() {
        assertEquals("7", run(ZeroOneKnapsack::main, """
                3 5
                2 3
                3 4
                4 5
                """));
    }

    @Test
    void task3Lcs() {
        assertEquals("3", run(LongestCommonSubsequence::main, "abcde\nace\n"));
    }

    @Test
    void task4Unbounded() {
        assertEquals("9 2", run(UnboundedKnapsackExact::main, """
                2 5
                2 4
                3 5
                """));
    }

    @Test
    void task5Lis() {
        assertEquals("3 2", run(LisCount::main, "4\n1 3 2 4\n"));
    }

    @Test
    void task6Scs() {
        assertEquals("abc", run(ShortestCommonSupersequence::main, "ab\nac\n"));
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
