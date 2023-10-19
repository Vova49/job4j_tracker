package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int newSize = 0;
        for (int index = 0; index < size; index++) {
            if (key.equals(items[index].getName())) {
                result[newSize++] = items[index];
            }
        }
        return Arrays.copyOf(result, newSize);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean valid = index != -1;
        if (valid) {
            item.setId(id);
            items[index] = item;
        }
        return valid;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean valid = index != -1;
        if (valid) {
            if (size - index - 1 > 0) {
                System.arraycopy(items, index + 1, items, index, size - index - 1);
            }
            items[size - 1] = null;
            size--;
        }
        return valid;
    }
}