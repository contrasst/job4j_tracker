package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName() + " start fly!");
    }
}