package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int position;

    private int size;

    private int modCount;

    private int expectedModCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        this.container[position++] = value;
        modCount++;
        size++;
        if (position == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length);
        container[index] = newValue;
        modCount++;
        return newValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        modCount++;
        size--;
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                expectedModCount++;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }
        };
    }
}
