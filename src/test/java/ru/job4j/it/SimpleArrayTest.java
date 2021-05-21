package ru.job4j.it;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Objects;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        array.add("first1");
        array.add("first2");
        array.add("first3");
        array.add("first4");
        String rsl = array.get(4);
        assertThat(rsl, is("first4"));
    }

    @Test
    public void whenAddThenSet() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        array.set(0, "second");
        String rsl = array.get(0);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenRemove() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        array.add("second");
        array.remove(0);
        String rsl = array.get(0);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }
}