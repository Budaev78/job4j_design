package ru.job4j.it;

public interface Simple<T> extends Iterable<T> {
    boolean add(T model);
    void set(int index, T model);
    void remove(int index);
    T get(int index);
}
