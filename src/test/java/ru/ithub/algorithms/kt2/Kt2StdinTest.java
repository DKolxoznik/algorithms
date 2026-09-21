package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kt2StdinTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void task1SearchInsert() {
        assertEquals("2", run(SearchInsertPosition::main, "4 5\n1 3 5 6\n"));
    }

    @Test
    void task2RangeSums() {
        assertEquals("10\n5", run(RangeSumQueries::main, "4\n1 2 3 4\n2\n0 3\n1 2\n"));
    }

    @Test
    void task3MergeIntervals() {
        assertEquals("2\n1 6\n8 10", run(MergeIntervals::main, "3\n1 3\n2 6\n8 10\n"));
    }

    @Test
    void task4ShipCapacity() {
        assertEquals("15", run(MinShipCapacity::main, "10 5\n1 2 3 4 5 6 7 8 9 10\n"));
    }

    @Test
    void task5SubarraySum() {
        assertEquals("2", run(CountSubarraysWithSum::main, "3 2\n1 1 1\n"));
    }

    @Test
    void task6MeetingRooms() {
        assertEquals("2", run(MinMeetingRooms::main, "3\n0 30\n5 10\n15 20\n"));
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
