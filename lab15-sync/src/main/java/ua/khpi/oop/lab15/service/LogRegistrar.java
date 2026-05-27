package ua.khpi.oop.lab15.service;

import ua.khpi.oop.lab15.model.EventCounter;

public class LogRegistrar implements Runnable {
    private final EventCounter counter;
    private final boolean useSynchronization;
    private final int iterations;

    public LogRegistrar(EventCounter counter, boolean useSynchronization, int iterations) {
        this.counter = counter;
        this.useSynchronization = useSynchronization;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            if (useSynchronization) {
                counter.incrementSafe();
            } else {
                counter.incrementUnsafe();
            }
        }
    }
}