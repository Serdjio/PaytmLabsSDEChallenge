package com.tkachov.challenge.sde;

/** Algorithm is based on a storing elements in an array of size n, where n - number of last elements in array.
 * Implementation guaranties O(1) time complexity.
 *
 * */
public class DoubleMovingAverageOfLastN implements MovingAverageCollection<Double> {
    private Double[] elements;
    private Double averageValue;
    private int maxTotal;
    private int totalElements;
    private int pivot;

    public DoubleMovingAverageOfLastN(int n) {
        this.maxTotal = n;
        elements = new Double[n];
        averageValue = (double) 0;
    }

    public void addElement(Double value) {
        Double previousSum = totalElements * averageValue;

        if(totalElements == maxTotal) {
            previousSum -= elements[pivot];
            totalElements--;
        }

        pivot = (pivot +1) % maxTotal;
        int freeSlot = (maxTotal + pivot - 1) % maxTotal;
        elements[freeSlot] = value;

        double newSum = previousSum + value;
        totalElements++;
        averageValue = newSum / totalElements;
    }

    public Double getAverage() {
        return averageValue;
    }

    public Double[] getElements() {
        return elements.clone();
    }
}
