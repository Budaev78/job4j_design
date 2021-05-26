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
        this.value[position++] = model;
        return true;
    }

    @Override
    public void set(int index, T model) {
        Objects.checkIndex(index, position);
        value[index] = model;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, position);
        T result  = (T) value[index];
        System.arraycopy(value, index + 1, value, index, value.length - index - 1);
        value[value.length - 1] = null;
        position--;
        return result;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, position);
        return value[index];
    }

    @Override
    public int size() {
        for (T t : value) {
            if (t != null) {
                position++;
            }
        }
        return position;
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
