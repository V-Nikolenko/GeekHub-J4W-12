package edu.geekhub.homework.hw1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenIndexIterable<T> implements Iterable<T> {
    private List<T> values = new ArrayList<>();

    public void add(T value) {
        values.add(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new EvenIndexIterator<T>(values);
    }
}
