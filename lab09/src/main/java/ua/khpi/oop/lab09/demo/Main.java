package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.model.*;
import java.util.*;

public class Main {

    /**
     * Узагальнений метод з обмеженням Comparable[cite: 3065, 3092, 3812].
     * Знаходить "найбільший" елемент у списку.
     */
    public static <T extends Comparable<T>> T findMax(List<T> items) {
        if (items == null || items.isEmpty()) return null;
        T max = items.get(0);
        for (T item : items) {
            if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }

    public static void main(String[] args) {
        // Конкретизація 1: Документ + Співробітник [cite: 3310, 3864-3866]
        Document doc1 = new Document("Контракт №101", "Юридичний");
        Employee boss = new Employee("Олександр Мнушка", "Директор");
        ApprovalEntry<Document, Employee> entry1 = new ApprovalEntry<>(doc1, boss);
        System.out.println("Конкретизація 1: " + entry1);

        // Конкретизація 2: Документ + String (текстовий статус) [cite: 3321, 3869-3871]
        ApprovalEntry<Document, String> entry2 = new ApprovalEntry<>(doc1, "ЗАТВЕРДЖЕНО");
        System.out.println("Конкретизація 2: " + entry2);

        // Демонстрація generic-методу [cite: 3328, 3872]
        List<Document> docs = Arrays.asList(
            new Document("Акт прийомки", "Фінансовий"),
            new Document("Заява на відпустку", "HR"),
            new Document("Наказ №5", "Адміністративний")
        );
        Document maxDoc = findMax(docs);
        System.out.println("\nРезультат generic-методу (Max документ за назвою): " + maxDoc);
    }
}