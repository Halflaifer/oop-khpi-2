package ua.khpi.oop.lab14.model;

import java.time.LocalDateTime;

public class SensorData {
    private final String sensorId;
    private final double value;
    private final LocalDateTime timestamp;

    public SensorData(String sensorId, double value, LocalDateTime timestamp) {
        this.sensorId = sensorId;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getSensorId() { return sensorId; }
    public double getValue() { return value; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] Датчик: %s | Показник: %.2f", timestamp, sensorId, value);
    }
}