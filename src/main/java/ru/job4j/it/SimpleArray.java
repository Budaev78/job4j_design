package ru.job4j.it;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Simple<T> {

    private T[] value;

    public SimpleArray() {
        value = (T[]) new Object[0];
    }

    @Override
    public boolean add(T model) {
        try {
            T[] temp = value;
            value = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, value, 0, temp.length);
            value[value.length - 1] = model;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void set(int index, T model) {
        value[index] = model;
    }

    @Override
    public void remove(int index) {
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
        return value[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(value);
    }
}
