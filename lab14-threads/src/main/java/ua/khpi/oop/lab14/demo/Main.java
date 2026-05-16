package ua.khpi.oop.lab14.demo;

import ua.khpi.oop.lab14.service.DataBuffer;
import ua.khpi.oop.lab14.service.SensorSimulator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Запуск системи багатопотокового ІоТ-моніторингу ===\n");

        DataBuffer buffer = new DataBuffer(3);

        Thread sensor1 = new Thread(new SensorSimulator("TEMP-01", buffer), "Потік-Датчик-1");
        Thread sensor2 = new Thread(new SensorSimulator("TEMP-02", buffer), "Потік-Датчик-2");
        Thread sensor3 = new Thread(new SensorSimulator("TEMP-03", buffer), "Потік-Датчик-3");


        Thread analyzer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 15; i++) {
                        ua.khpi.oop.lab14.model.SensorData data = buffer.take();
                        System.out.println("[Споживач] Аналізатор обробив: " + data.getSensorId() + " -> Значення: " + String.format("%.2f", data.getValue()));
                        Thread.sleep(300); 
                    }
                } catch (InterruptedException e) {
                    System.out.println("Аналізатор перервано.");
                }
            }
        }, "Потік-Аналізатор");


        analyzer.start();
        sensor1.start();
        sensor2.start();
        sensor3.start();

        try {
            sensor1.join();
            sensor2.join();
            sensor3.join();
            analyzer.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("\n=== Роботу системи моніторингу успішно завершено ===");
    }
}