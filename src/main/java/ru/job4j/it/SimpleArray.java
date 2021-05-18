package ru.job4j.it;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Simple<T> {

    private T[] value;

    private int position = 0;

    public SimpleArray() {
        value = (T[]) new Object[0];
    }

    @Override
    public boolean add(T model) {
        SimpleArray<T> simpleArray = new SimpleArray<>();
        int index = simpleArray.findByIndex(model);
        Objects.checkIndex(index, simpleArray.size());
        try {
            value = (T[]) new Object[3];
            if (position == value.length) { // не могу понять почему он здесь сбрасывает увеличенный массив
                T[] temp = value;
                value = (T[]) new Object[temp.length + temp.length / 2];
                System.arraycopy(temp, 0, value, 0, temp.length);
                return true;
            }
            this.value[position++] = model;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void set(int index, T model) {
        SimpleArray<T> simpleArray = new SimpleArray<>();
        Objects.checkIndex(index, simpleArray.size());
        value[index] = model;
    }

    @Override
    public void remove(int index) {
        SimpleArray<T> simpleArray = new SimpleArray<>();
        Objects.checkIndex(index, simpleArray.size());
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
        SimpleArray<T> simpleArray = new SimpleArray<>();
        Objects.checkIndex(index, simpleArray.size());
        return value[index];
    }

    @Override
    public int size() {
        return value.length;
    }

    @Override
    public int findByIndex(T model) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(model)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(value);
    }
}
