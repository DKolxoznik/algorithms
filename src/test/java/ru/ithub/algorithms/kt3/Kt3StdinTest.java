package ru.ithub.algorithms.kt3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt3StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1DaysUntilHigherPrice() {
        assertEquals("1 1 4 2 1 1 0 0", run(DaysUntilHigherPrice::main, "8\n73 74 75 71 69 72 76 73\n"));
    }

    @Test
    void task2ShortestPath() {
        assertEquals("5", run(ShortestPathInMaze::main, "3 4\nS.#.\n.#T.\n....\n"));
    }

    @Test
    void task3CycleYes() {
        assertEquals("YES", run(LinkedListCycle::main, "3 1\n2 3 1\n"));
    }

    @Test
    void task3CycleNo() {
        assertEquals("NO", run(LinkedListCycle::main, "2 1\n2 -1\n"));
    }

    @Test
    void task4MaximalRectangle() {
        assertEquals("6", run(MaximalRectangle::main, "3 4\n1010\n1111\n1110\n"));
    }

    @Test
    void task5KeysAndDoors() {
        assertEquals("5", run(ShortestPathWithKeys::main, "3 4\nS.aA\n###.\n...T\n"));
    }

    @Test
    void task6FindDuplicate() {
        assertEquals("2", run(FindDuplicateNumber::main, "4\n1 3 4 2 2\n"));
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
