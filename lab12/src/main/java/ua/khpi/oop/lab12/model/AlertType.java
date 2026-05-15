package ua.khpi.oop.lab12.model;

public enum AlertType {
    INFO("Норма"), 
    WARNING("Увага"), 
    CRITICAL("Критично");

    private final String description;
    AlertType(String description) { this.description = description; }
    public String getDescription() { return description; }
}