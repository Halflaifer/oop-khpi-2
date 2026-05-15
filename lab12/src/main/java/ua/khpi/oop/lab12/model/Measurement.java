package ua.khpi.oop.lab12.model;

import java.time.LocalDateTime;

public class Measurement {
    private final Sensor sensor;
    private final double value;
    private final LocalDateTime timestamp;
    private final AlertType alert;

    public Measurement(Sensor sensor, double value, LocalDateTime timestamp, AlertType alert) {
        this.sensor = sensor;
        this.value = value;
        this.timestamp = timestamp;
        this.alert = alert;
    }

    public Sensor getSensor() { return sensor; }
    public double getValue() { return value; }
    public AlertType getAlert() { return alert; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f (%s)", timestamp, sensor.getId(), value, alert.getDescription());
    }
}