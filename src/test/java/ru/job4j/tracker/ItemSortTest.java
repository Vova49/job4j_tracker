package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemSortTest {

    @Test
    public void testSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("C"));
        items.add(new Item("A"));
        items.add(new Item("B"));
        List<Item> expected = new ArrayList<>(items);
        Collections.sort(expected, new ItemAscByName());
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void testSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("C"));
        items.add(new Item("A"));
        items.add(new Item("B"));
        List<Item> expected = new ArrayList<>(items);
        Collections.sort(expected, new ItemDescByName());
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}
