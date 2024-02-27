package ru.job4j.cast;

public class VehicleMain {
    public static void main(String[] args) {

        Plane plane = new Plane();
        Bus bus = new Bus();
        Train train = new Train();

        Vehicle[] vehicles = new Vehicle[] {plane, bus, train};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}
