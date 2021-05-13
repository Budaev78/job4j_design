package ru.job4j.it;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private int index = 0;
    private T[] values;

    public ArrayIterator(T[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public T next() {
        return values[index++];
    }
}
