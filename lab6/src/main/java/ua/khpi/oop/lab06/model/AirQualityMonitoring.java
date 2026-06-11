package ua.khpi.oop.lab06.model;

public class AirQualityMonitoring extends MonitoringTask {
    private final int aqiIndex;

    public AirQualityMonitoring(String location, int aqiIndex) {
        super(location);
        this.aqiIndex = aqiIndex;
    }

    @Override
    public String executeTask() {
        String status = (aqiIndex > 100) ? "НЕБЕЗПЕЧНО" : "НОРМА";
        return "Аналіз повітря (AQI): " + aqiIndex + " [" + status + "]";
    }
}