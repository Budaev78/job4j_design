package ru.job4j.it;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Simple<T> {

    private T[] value;

    private int position = 0;

    public SimpleArray() {
        value = (T[]) new Object[0];
    }

    public static void main(String[] args) {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        System.out.println(Objects.checkIndex(0, array.size()));
    }

    @Override
    public boolean add(T model) {
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
    public int size() {
        return value.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(value);
    }
}
