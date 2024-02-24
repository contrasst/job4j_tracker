package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus start go");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of passengers: " + count);
    }

    @Override
    public int tuck(int fuel) {
        int price = fuel * 50;
        return price;
    }
}
