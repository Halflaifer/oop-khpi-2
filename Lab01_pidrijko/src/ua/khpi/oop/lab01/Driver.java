package ua.khpi.oop.lab01;

import java.util.Objects;

public class Driver {
    private String fullName;
    private int experienceYears;

    public Driver(String fullName, int experienceYears) {
        this.fullName = fullName;
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "Водій: " + fullName + " (стаж: " + experienceYears + " р.)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return experienceYears == driver.experienceYears && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, experienceYears);
    }
}