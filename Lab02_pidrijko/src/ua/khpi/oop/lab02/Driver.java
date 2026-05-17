package ua.khpi.oop.lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver {
    private String fullName;
    // Асоціація: водій знає про свої рейси [cite: 558]
    private List<Route> assignedRoutes = new ArrayList<>(); 

    public Driver(String fullName) {
        this.fullName = fullName;
    }

    public void addRoute(Route route) {
        assignedRoutes.add(route);
    }

    @Override
    public String toString() {
        return "Водій: " + fullName + " (Кількість рейсів: " + assignedRoutes.size() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}