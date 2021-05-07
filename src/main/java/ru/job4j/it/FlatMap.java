package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }

    @Override
    public boolean hasNext() {
        selectCurrentIterator();
        return (cursor != null && cursor.hasNext());
    }

    @Override
    public T next() {
        selectCurrentIterator();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    private void selectCurrentIterator() {
        if (cursor != null && cursor.hasNext()) {
            return;
        }
        cursor = null;
        while (data.hasNext()) {
            Iterator<T> nextIterator = data.next();
            if (nextIterator.hasNext()) {
                cursor = nextIterator;
                break;
            }
        }
    }
}