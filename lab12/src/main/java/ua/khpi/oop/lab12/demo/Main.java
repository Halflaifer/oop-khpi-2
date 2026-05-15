package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.*;
import ua.khpi.oop.lab12.service.MonitoringService;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MonitoringService service = new MonitoringService();
        Sensor tempSensor = new Sensor("T-101", "Температура");
        
        service.addMeasurement(new Measurement(tempSensor, 22.5, LocalDateTime.now(), AlertType.INFO));
        service.addMeasurement(new Measurement(tempSensor, 35.0, LocalDateTime.now().plusHours(1), AlertType.WARNING));
        service.addMeasurement(new Measurement(tempSensor, 48.2, LocalDateTime.now().plusHours(2), AlertType.CRITICAL));

        System.out.println("=== Всі вимірювання ===");
        service.getAll().forEach(System.out::println);

        System.out.println("\n=== Тільки критичні (Stream filter) ===");
        service.getCriticalAlerts().forEach(System.out::println);

        System.out.println("\n=== Середнє значення (Stream aggregation) ===");
        service.getAverageValue().ifPresent(avg -> System.out.printf("Середнє: %.2f\n", avg));

        System.out.println("\n=== Групування за статусом (Stream groupingBy) ===");
        service.groupByAlertType().forEach((alert, list) -> 
            System.out.println(alert + ": " + list.size() + " записів"));
    }
}