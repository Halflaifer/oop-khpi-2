package ua.khpi.oop.lab14.service;

import ua.khpi.oop.lab14.model.SensorData;
import java.time.LocalDateTime;
import java.util.Random;

public class SensorSimulator implements Runnable {
    private final String sensorId;
    private final DataBuffer buffer;
    private final Random random = new Random();

    public SensorSimulator(String sensorId, DataBuffer buffer) {
        this.sensorId = sensorId;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double value = 15.0 + (random.nextDouble() * 25.0); 
                SensorData data = new SensorData(sensorId, value, LocalDateTime.now());
                
                buffer.put(data);
                System.out.println("[Продюсер] " + Thread.currentThread().getName() + " записав: " + data);
                
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Датчик " + sensorId + " перервано.");
        }
    }
}