package ua.khpi.oop.lab06.model;

public class NoiseMonitoring extends MonitoringTask {
    private final double decibels;

    public NoiseMonitoring(String location, double decibels) {
        super(location);
        this.decibels = decibels;
    }

    @Override
    public String executeTask() {
        return "Рівень шуму: " + decibels + " дБ";
    }
}