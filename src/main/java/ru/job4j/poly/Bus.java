package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean ride() {
        return true;
    }

    @Override
    public int passengers(int passengerCount) {
        return 5;
    }

    @Override
    public int refuel(int price) {
        return 27;
    }
}
