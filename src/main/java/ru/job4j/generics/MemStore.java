package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findByIndex(id);
        if (index == -1) {
            System.out.println("Вы вышли за пределы массива");
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findByIndex(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.equals(id)) {
                return t;
            }
        }
        return null;
    }

    private int findByIndex(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
