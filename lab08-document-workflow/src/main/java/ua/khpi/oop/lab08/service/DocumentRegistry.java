package ua.khpi.oop.lab08.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ua.khpi.oop.lab08.model.Document;

public class DocumentRegistry implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Document> documents = new ArrayList<>();

    public void addDocument(Document doc) {
        documents.add(doc);
    }

    public List<Document> getDocuments() {
        // Виправлено: List.copyOf замінено на сумісний з Java 8 ArrayList [cite: 1606]
        return new ArrayList<>(documents);
    }
    
    public int size() { 
        return documents.size(); 
    }
}