package ua.khpi.oop.lab08.persistence;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ua.khpi.oop.lab08.service.DocumentRegistry;
import ua.khpi.oop.lab08.model.Document;

public class DocumentFileManager {

    public void saveAsText(DocumentRegistry registry, Path path) throws IOException {
        // Виправлено: .toList() замінено на .collect(Collectors.toList()) [cite: 1032-1036, 1660]
        List<String> lines = registry.getDocuments().stream()
                .map(Document::toTextLine)
                .collect(Collectors.toList());
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public void serialize(DocumentRegistry registry, Path path) throws IOException {
        // Використання try-with-resources для автоматичного закриття [cite: 995-998, 1713]
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(registry);
        }
    }

    public DocumentRegistry deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            return (DocumentRegistry) in.readObject();
        }
    }
}