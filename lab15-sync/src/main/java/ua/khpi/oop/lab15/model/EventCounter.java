package ua.khpi.oop.lab15.model;

public class EventCounter {
    private int criticalEventsCount = 0;


    public void incrementUnsafe() {
        criticalEventsCount++;
    }

    public synchronized void incrementSafe() {
        criticalEventsCount++;
    }

    public int getCount() {
        return criticalEventsCount;
    }

    public void reset() {
        this.criticalEventsCount = 0;
    }
}