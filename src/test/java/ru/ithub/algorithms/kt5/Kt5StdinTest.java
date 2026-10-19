package ru.ithub.algorithms.kt5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt5StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1Parentheses() {
        assertEquals("()", run(GenerateParentheses::main, "1\n"));
    }

    @Test
    void task2Dictionary() {
        assertEquals("3\n2", run(PrefixDictionary::main, """
                6
                ADD apple
                ADD app
                ADD apply
                COUNT app
                REMOVE app
                COUNT app
                """));
    }

    @Test
    void task3TwoSingles() {
        assertEquals("3 5", run(TwoSingleNumbers::main, "6\n1 2 1 3 2 5\n"));
    }

    @Test
    void task4Queens() {
        assertEquals("2", run(NQueensCount::main, "4 0\n"));
    }

    @Test
    void task5Kth() {
        assertEquals("app\napple\nNONE", run(OrderedPrefixDictionary::main, """
                6
                ADD app
                ADD apple
                ADD apply
                KTH app 1
                KTH app 2
                KTH app 4
                """));
    }

    @Test
    void task6MaxXor() {
        assertEquals("7", run(MaxXorSubarray::main, "4\n1 2 3 4\n"));
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
