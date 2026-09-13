package ru.ithub.algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ZeroSumTripletsTest {

    @Test
    void exampleFromAssignment() {
        assertTriplets(
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                ZeroSumTriplets.find(new int[]{-1, 0, 1, 2, -1, -4})
        );
    }

    @Test
    void allZeros() {
        assertTriplets(
                List.of(List.of(0, 0, 0)),
                ZeroSumTriplets.find(new int[]{0, 0, 0, 0})
        );
    }

    @Test
    void noTriplets() {
        assertTrue(ZeroSumTriplets.find(new int[]{1, 2, -2, -1}).isEmpty());
    }

    private static void assertTriplets(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }

    private static Set<List<Integer>> normalize(List<List<Integer>> triplets) {
        return triplets.stream()
                .map(triplet -> triplet.stream().sorted().toList())
                .collect(Collectors.toCollection(HashSet::new));
    }
}
