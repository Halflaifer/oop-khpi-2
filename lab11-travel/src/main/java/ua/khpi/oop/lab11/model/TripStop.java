package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class TripStop {
    private final String stopId;      
    private final String cityName;    
    private final String stationName; 

    public TripStop(String stopId, String cityName, String stationName) {
        this.stopId = stopId;
        this.cityName = cityName;
        this.stationName = stationName;
    }

    public String getStopId() { return stopId; }
    public String getCityName() { return cityName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripStop tripStop = (TripStop) o;
        return Objects.equals(stopId, tripStop.stopId); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopId); 
    }

    @Override
    public String toString() {
        return String.format("Зупинка #%s: %s (вокзал %s)", stopId, cityName, stationName);
    }
}