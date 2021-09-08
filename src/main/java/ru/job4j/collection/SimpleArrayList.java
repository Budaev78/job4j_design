package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public void expansion() {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public void add(T value) {
        this.container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        container[index] = newValue;
        modCount++;
        return container[index];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        modCount++;
        size--;
        return container[index];
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator<>(container, size);
    }

    private class SimpleIterator<T> implements Iterator<T> {

        private int index;

        private int expectedModCount = 0;

        private T[] data;

        public SimpleIterator(T[] data, int size) {
            this.expectedModCount = size;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[index++];
        }
    }

}
