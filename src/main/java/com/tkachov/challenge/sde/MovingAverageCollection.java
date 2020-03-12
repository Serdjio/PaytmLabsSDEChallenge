package com.tkachov.challenge.sde;
/**
 * The user of this interface has ability to add elements into collection.
 * The user can retrieve all elements from collection, and get the average value.
 * It allows to store duplicate elements. It is not inconceivable that someone might wish to implement
 * a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert duplicate.
 *
 * */
public interface MovingAverageCollection<T> {
    void addElement(T value);
    T getAverage();
    T[] getElements();
}
