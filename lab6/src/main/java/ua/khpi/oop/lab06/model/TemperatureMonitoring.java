package ua.khpi.oop.lab06.model;

public class TemperatureMonitoring extends MonitoringTask {
    private final double temperature;

    public TemperatureMonitoring(String location, double temperature) {
        super(location);
        this.temperature = temperature;
    }

    @Override
    public String executeTask() {
        return "Вимірювання температури: " + temperature + "°C";
    }
}