package ua.khpi.oop.lab01;

public class Route {
    private String routeNumber;
    private String destination;
    private Bus bus;
    private Driver driver;

    // Повний конструктор
    public Route(String routeNumber, String destination, Bus bus, Driver driver) {
        this.routeNumber = routeNumber;
        this.destination = destination;
        this.bus = bus;
        this.driver = driver;
    }

    public Route(String routeNumber, String destination, Bus bus) {
        this(routeNumber, destination, bus, null);
    }

    @Override
    public String toString() {
        return String.format("Рейс №%s до міста %s. %s, %s", 
            routeNumber, destination, bus, (driver != null ? driver : "Водій не призначений"));
    }
}