package ua.khpi.oop.lab03;

public class Route {
    private String destination;
    private Bus bus;

    public Route(String destination, Bus bus) {
        if (bus == null) {
            throw new IllegalArgumentException("Автобус обов'язковий для рейсу");
        }
        this.destination = destination;
        this.bus = bus;
    }

    public String getDestination() { return destination; }
}