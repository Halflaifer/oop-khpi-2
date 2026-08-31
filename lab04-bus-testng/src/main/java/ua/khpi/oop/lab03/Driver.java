package ua.khpi.oop.lab03;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String fullName;
    private List<Route> assignedRoutes = new ArrayList<>();

    public Driver(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім'я водія не може бути порожнім");
        }
        this.fullName = fullName;
    }

    public void addRoute(Route route) {
        if (route == null) {
            throw new IllegalArgumentException("Рейс не може бути порожнім (null)");
        }
        assignedRoutes.add(route);
    }

    public int getRoutesCount() { return assignedRoutes.size(); }
    public String getFullName() { return fullName; }
}