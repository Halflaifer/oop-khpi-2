package ua.khpi.oop.lab06.demo;

import ua.khpi.oop.lab06.model.*;

public class Main {
    public static void main(String[] args) {
        // Поліморфна колекція (масив базового типу)
        MonitoringTask[] tasks = {
            new TemperatureMonitoring("Парк Горького", 18.5),
            new AirQualityMonitoring("Сумська", 120),
            new NoiseMonitoring("Вокзал", 95.0)
        };

        System.out.println("=== Результати екологічного моніторингу ===");
        for (MonitoringTask task : tasks) {
            // Динамічна диспетчеризація: Java сама знає, який метод викликати
            System.out.println(task.getSummary());
            System.out.println("Дія: " + task.executeTask());
            System.out.println("-------------------------------------------");
        }
    }
}