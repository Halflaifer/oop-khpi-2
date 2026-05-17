package ua.khpi.oop.lab02;

public class Route {
    private String routeNumber;
    private String destination;
    private Bus bus;

    public Route(String routeNumber, String destination, Bus bus) {
        this.routeNumber = routeNumber;
        this.destination = destination;
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Рейс №" + routeNumber + " до м. " + destination + " (" + bus + ")";
    }
}