package ua.khpi.oop.lab11.demo;

import ua.khpi.oop.lab11.model.TripStop;
import ua.khpi.oop.lab11.service.RouteManager;

public class Main {
    public static void main(String[] args) {
        RouteManager manager = new RouteManager();

        // Додавання даних (демонстрація роботи колекцій)
        manager.addStop(new TripStop("S01", "Харків", "Південний"));
        manager.addStop(new TripStop("S02", "Полтава", "Київська"));
        manager.addStop(new TripStop("S03", "Полтава", "Південна")); 
        manager.addStop(new TripStop("S04", "Київ", "Пасажирський"));

        System.out.println("=== Послідовність маршруту (List) ===");
        for (TripStop s : manager.getFullRoute()) {
            System.out.println(s);
        }

        System.out.println("\n=== Міста в маршруті (Set - без повторів) ===");
        manager.getCities().forEach(city -> System.out.println("- " + city));

        String search = "S02";
        System.out.println("\nПошук зупинки " + search + " (Map):");
        System.out.println(manager.findById(search));
    }
}