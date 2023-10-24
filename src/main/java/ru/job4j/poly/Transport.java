package ru.job4j.poly;

public interface Transport {
    boolean ride();

    int passengers(int passengerCount);

    int refuel(int price);
}
