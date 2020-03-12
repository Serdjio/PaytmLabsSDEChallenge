package com.tkachov.challenge.sde;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleMovingAverageOfLastNTest {
    @Test
    void calculateAverage_threeElements() {

        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);
        movAverage.addElement(1D);
        movAverage.addElement(2D);
        movAverage.addElement(3D);

        int expectedAverage = (1 + 2 + 3) / 3;
        assertEquals(expectedAverage, movAverage.getAverage());
    }

    @Test
    void calculateAverage_withOneElement() {
        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);
        movAverage.addElement(1D);

        int expectedAverage = 1;
        assertEquals(expectedAverage, movAverage.getAverage());
    }

    @Test
    void calculateAverage_withoutElements() {
        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);

        int expectedAverage = 0;
        assertEquals(expectedAverage, movAverage.getAverage());
    }

    @Test
    void calculateAverage_averageChangedWhenAddedNPlusTwoElement() {
        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);
        movAverage.addElement(1D);
        movAverage.addElement(2D);
        movAverage.addElement(3D);
        movAverage.addElement(4.5D);
        movAverage.addElement(5.5D);

        Double expectedAverage = (5.5D + 4.5D + 3D) / 3D;
        assertEquals(expectedAverage, movAverage.getAverage());
    }

    @Test
    void addElement_threeElementsStored() {
        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);
        movAverage.addElement(1D);
        movAverage.addElement(2D);
        movAverage.addElement(3D);

        assertEquals(movAverage.getElements().length, 3);
    }

    @Test
    void addElement_onlyLastThreeElementsExist() {
        DoubleMovingAverageOfLastN movAverage = new DoubleMovingAverageOfLastN(3);
        movAverage.addElement(1D);
        movAverage.addElement(2D);
        movAverage.addElement(3D);
        movAverage.addElement(4D);
        movAverage.addElement(5D);
        movAverage.addElement(6D);

        assertEquals(movAverage.getElements().length, 3);
    }
}
