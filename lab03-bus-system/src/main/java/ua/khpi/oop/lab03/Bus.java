package ua.khpi.oop.lab03;

public class Bus {
    private String licensePlate;
    private int capacity;

    public Bus(String licensePlate, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути більшою за 0");
        }
        if (licensePlate == null || licensePlate.isEmpty()) {
            throw new IllegalArgumentException("Номер не може бути порожнім");
        }
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
    public String getLicensePlate() { return licensePlate; }

    @Override
    public String toString() { return "Автобус [" + licensePlate + "]"; }
}