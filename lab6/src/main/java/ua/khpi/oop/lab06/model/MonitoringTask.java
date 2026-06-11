package ua.khpi.oop.lab06.model;

import java.time.LocalDateTime;

public abstract class MonitoringTask {
    protected final String location;
    protected final LocalDateTime timestamp;

    protected MonitoringTask(String location) {
        this.location = location;
        this.timestamp = LocalDateTime.now();
    }

    public String getSummary() {
        return "[" + timestamp + "] Локація: " + location;
    }

    // Абстрактний метод: кожен нащадок реалізує його по-своєму
    public abstract String executeTask();
}