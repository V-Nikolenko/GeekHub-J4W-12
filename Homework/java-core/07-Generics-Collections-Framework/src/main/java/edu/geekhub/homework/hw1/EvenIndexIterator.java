package edu.geekhub.homework.hw1;

import java.util.Iterator;
import java.util.List;

public class EvenIndexIterator<E> implements Iterator<E> {
    private List<E> data;
    int position = 1;

    public EvenIndexIterator(List<E> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        // write your code here
        return true;
    }

    @Override
    public E next() {
        //write your code here
        E nextValue = null;
        position = 0;
        return nextValue;
    }
}
