package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            if (customer != null && customer.getAmount() >= 0) {
                lastHappyCustomer = customer.getName();
            }
        }
        return lastHappyCustomer;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = null;
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            if (customer != null) {
                if (customer.getAmount() > count) {
                    firstUpsetCustomer = customer.getName();
                    break;
                }
            }
        }
        return firstUpsetCustomer;
    }
}
