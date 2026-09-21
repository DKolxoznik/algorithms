package ru.ithub.algorithms.kt2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinShipCapacityTest {

    @Test
    void classicExample() {
        assertEquals(15, MinShipCapacity.findCapacity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    @Test
    void oneDayMeansFullSum() {
        assertEquals(10, MinShipCapacity.findCapacity(new int[]{1, 2, 3, 4}, 1));
    }

    @Test
    void onePackagePerDay() {
        assertEquals(4, MinShipCapacity.findCapacity(new int[]{1, 2, 3, 4}, 4));
    }

    @Test
    void capacityMustHoldHeaviestPackage() {
        assertFalse(MinShipCapacity.canShip(new int[]{3, 2, 2, 4, 1, 4}, 3, 5));
        assertTrue(MinShipCapacity.canShip(new int[]{3, 2, 2, 4, 1, 4}, 3, 6));
        assertEquals(6, MinShipCapacity.findCapacity(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }
}
