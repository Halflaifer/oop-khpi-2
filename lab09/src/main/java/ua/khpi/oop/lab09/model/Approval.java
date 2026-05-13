package ua.khpi.oop.lab09.model;

import java.time.LocalDate;

/**
 * Клас, що представляє сутність погодження (рішення).
 */
public class Approval {
    private final String status;
    private final String comment;
    private final LocalDate date;

    public Approval(String status, String comment) {
        this.status = status;
        this.comment = comment;
        this.date = LocalDate.now();
    }

    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Погодження{статус='" + status + "', коментар='" + comment + "', дата=" + date + "}";
    }
}