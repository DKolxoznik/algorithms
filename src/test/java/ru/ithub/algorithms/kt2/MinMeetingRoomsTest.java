package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinMeetingRoomsTest {

    @Test
    void twoRoomsNeeded() {
        assertEquals(2, MinMeetingRooms.countRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    @Test
    void disjointMeetingsShareOneRoom() {
        assertEquals(1, MinMeetingRooms.countRooms(new int[][]{{7, 10}, {2, 4}}));
    }

    @Test
    void halfOpenIntervalsCanShareRoom() {
        assertEquals(1, MinMeetingRooms.countRooms(new int[][]{{1, 2}, {2, 3}}));
    }

    @Test
    void emptySchedule() {
        assertEquals(0, MinMeetingRooms.countRooms(new int[][]{}));
    }

    @Test
    void threeOverlap() {
        assertEquals(3, MinMeetingRooms.countRooms(new int[][]{{1, 5}, {2, 6}, {3, 4}}));
    }
}
