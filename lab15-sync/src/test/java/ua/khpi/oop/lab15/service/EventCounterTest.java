package ua.khpi.oop.lab15.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab15.model.EventCounter;
import static org.junit.jupiter.api.Assertions.*;

class EventCounterTest {

    @Test
    void testSynchronizedIncrement() throws InterruptedException {
        final EventCounter counter = new EventCounter();
        final int iterations = 1000;

        Thread t1 = new Thread(new LogRegistrar(counter, true, iterations));
        Thread t2 = new Thread(new LogRegistrar(counter, true, iterations));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertEquals(2000, counter.getCount(), "Синхронізований лічильник втратив дані під час паралельної роботи!");
    }
}