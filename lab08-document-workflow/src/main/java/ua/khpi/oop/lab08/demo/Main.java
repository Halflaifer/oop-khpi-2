package ua.khpi.oop.lab08.demo;

import java.nio.file.Path;
import java.nio.file.Paths; // Додано імпорт Paths
import ua.khpi.oop.lab08.model.ContractDraft;
import ua.khpi.oop.lab08.persistence.DocumentFileManager;
import ua.khpi.oop.lab08.service.DocumentRegistry;

public class Main {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();
        registry.addDocument(new ContractDraft("Контракт №1", "Савченко", 45000));

        DocumentFileManager fm = new DocumentFileManager();
        // Виправлено: Path.of замінено на Paths.get [cite: 1832]
        Path txtPath = Paths.get("docs.txt");
        Path binPath = Paths.get("docs.bin");

        try {
            fm.saveAsText(registry, txtPath);
            fm.serialize(registry, binPath);
            
            DocumentRegistry restored = fm.deserialize(binPath);
            System.out.println("Відновлено документів: " + restored.size());
            restored.getDocuments().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}