package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("The car's coming");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of planters 4");
    }

    @Override
    public double refuel(double price) {
        return 27.5;
    }
}
