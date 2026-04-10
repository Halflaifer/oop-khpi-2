package ua.khpi.oop.lab01;

public class Bus {
    private String licensePlate;
    private int capacity;

    public Bus(String licensePlate, int capacity) {
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Автобус [" + licensePlate + "], місць: " + capacity;
    }
}