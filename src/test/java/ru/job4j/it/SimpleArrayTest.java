package ru.job4j.it;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenSet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.set(0, "second");
        String rsl = array.get(0);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenRemove() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.remove(0);
        String rsl = array.get(0);
        assertThat(rsl, is("second"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.get(1);
    }
}