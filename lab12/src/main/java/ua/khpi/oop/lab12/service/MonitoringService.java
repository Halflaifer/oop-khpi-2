package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.AlertType;
import ua.khpi.oop.lab12.model.Measurement;
import java.util.*;
import java.util.stream.Collectors;

public class MonitoringService {
    private final List<Measurement> measurements = new ArrayList<>();

    public void addMeasurement(Measurement m) { measurements.add(m); }


    public List<Measurement> getCriticalAlerts() {
        return measurements.stream()
                .filter(m -> m.getAlert() == AlertType.CRITICAL)
                .collect(Collectors.toList());
    }


    public List<Double> getSortedValues() {
        return measurements.stream()
                .map(Measurement::getValue)
                .sorted()
                .collect(Collectors.toList());
    }


    public Optional<Measurement> getMaxMeasurement() {
        return measurements.stream()
                .max(Comparator.comparingDouble(Measurement::getValue));
    }


    public Map<AlertType, List<Measurement>> groupByAlertType() {
        return measurements.stream()
                .collect(Collectors.groupingBy(Measurement::getAlert));
    }


    public OptionalDouble getAverageValue() {
        return measurements.stream()
                .mapToDouble(Measurement::getValue)
                .average();
    }

    public List<Measurement> getAll() { return Collections.unmodifiableList(measurements); }
}