package ua.khpi.oop.lab12.model;

import java.util.Objects;

public class Sensor {
    private final String id;
    private final String type; 

    public Sensor(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() { return id; }
    public String getType() { return type; }

    @Override
    public String toString() { return "Датчик " + id + " (" + type + ")"; }
}