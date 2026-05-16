package ua.khpi.oop.lab15.demo;

import ua.khpi.oop.lab15.model.EventCounter;
import ua.khpi.oop.lab15.service.LogRegistrar;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Запуск системи синхронізації ІоТ-подій ===\n");

        final int NUM_THREADS = 5;       
        final int ITERATIONS = 20000;    
        final int EXPECTED_TOTAL = NUM_THREADS * ITERATIONS; 

        EventCounter counter = new EventCounter();

        System.out.println("1. Запуск потоків БЕЗ синхронізації...");
        Thread[] unsafeThreads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            unsafeThreads[i] = new Thread(new LogRegistrar(counter, false, ITERATIONS));
            unsafeThreads[i].start();
        }


        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                unsafeThreads[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Головний потік було перервано.");
        }

        System.out.println("-> Очікували зафіксувати тривог : " + EXPECTED_TOTAL);
        System.out.println("-> Реально пораховано (Unsafe): " + counter.getCount());
        System.out.println("-> Втрата даних (Помилка)      : " + (EXPECTED_TOTAL - counter.getCount()) + "\n");


        counter.reset(); 
        System.out.println("2. Запуск потоків З СИНХРОНІЗАЦІЄЮ...");
        Thread[] safeThreads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            safeThreads[i] = new Thread(new LogRegistrar(counter, true, ITERATIONS));
            safeThreads[i].start();
        }

        try {
            for (int i = 0; i < NUM_THREADS; i++) {
                safeThreads[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Головний потік було перервано.");
        }

        System.out.println("-> Очікували зафіксувати тривог : " + EXPECTED_TOTAL);
        System.out.println("-> Реально пораховано (Safe)  : " + counter.getCount());
        System.out.println("-> Втрата даних (Помилка)      : " + (EXPECTED_TOTAL - counter.getCount()));
        
        System.out.println("\n=== Симуляцію успішно завершено ===");
    }
}