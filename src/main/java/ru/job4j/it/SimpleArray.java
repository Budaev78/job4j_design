package ru.job4j.it;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Simple<T> {

    private T[] value;

    private int position = 0;

    public SimpleArray(int capacity) {
        this.value = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T model) {
        Objects.checkIndex(findByIndex(model), size());
        this.value[position++] = model;
        return true;
    }

    @Override
    public void set(int index, T model) {
        Objects.checkIndex(index, size());
        value[index] = model;
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size());
        try {
            T[] temp = value;
            value = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, value, 0, index);
            System.arraycopy(temp, index + 1, value, index, temp.length - index - 1);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size());
        return value[index];
    }

    @Override
    public int size() {
        int count = 0;
        for (T t : value) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int findByIndex(T model) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(model)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(value);
    }
}
