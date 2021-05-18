package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private int index = 0;
    private T[] values;

    public ArrayIterator(T[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (T t : values) {
            if (t != null) {
                count++;
            }
        }
        return index < count;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
