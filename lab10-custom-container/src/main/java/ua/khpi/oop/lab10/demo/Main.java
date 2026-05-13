package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.container.DocumentContainer;
import ua.khpi.oop.lab10.model.Document;

public class Main {
    public static void main(String[] args) {
        DocumentContainer<Document> myDocs = new DocumentContainer<>();

        // Додаємо дані
        myDocs.add(new Document("Контракт №1"));
        myDocs.add(new Document("Наказ №2"));
        myDocs.add(new Document("Заява №3"));

        System.out.println("Розмір контейнера: " + myDocs.size());

        // Демонстрація ітератора через for-each [cite: 75, 83]
        System.out.println("Перелік документів через ітератор:");
        for (Document doc : myDocs) {
            System.out.println("- " + doc);
        }

        myDocs.clear();
        System.out.println("Після очищення, розмір: " + myDocs.size());
    }
}