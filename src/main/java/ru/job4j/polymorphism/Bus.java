package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int count) {

    }

    @Override
    public int tuck(int fuel) {
        int price = fuel * 50;
        return price;
    }
}
