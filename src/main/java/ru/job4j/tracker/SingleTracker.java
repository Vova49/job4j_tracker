package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public void replace(int id, Item item) {
        tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }
}
