package ru.ithub.algorithms.kt4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt4StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1LevelSums() {
        assertEquals("1 5 9", run(LevelSums::main, """
                5
                1 1 2
                2 3 4
                3 -1 -1
                4 -1 -1
                5 -1 -1
                """));
    }

    @Test
    void task2TopK() {
        assertEquals("1 2", run(TopKFrequent::main, "6 2\n1 1 1 2 2 3\n"));
    }

    @Test
    void task3RunningMedian() {
        assertEquals("1.0 1.5 2.0 2.5", run(RunningMedian::main, "4\n1 2 3 4\n"));
    }

    @Test
    void task4MaxPath() {
        assertEquals("42", run(MaxPathSum::main, """
                5
                -10 1 2
                9 -1 -1
                20 3 4
                15 -1 -1
                7 -1 -1
                """));
    }

    @Test
    void task5KthPairSum() {
        assertEquals("7", run(KthPairSum::main, "3 3 3\n1 7 11\n2 4 6\n"));
    }

    @Test
    void task6SlidingMedian() {
        assertEquals(
                "1.0 -1.0 -1.0 3.0 5.0 6.0",
                run(SlidingWindowMedian::main, "8 3\n1 3 -1 -3 5 3 6 7\n")
        );
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
