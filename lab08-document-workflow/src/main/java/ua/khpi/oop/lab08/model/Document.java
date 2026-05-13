package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public abstract class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String title;
    protected String author;

    public Document(String title, String author) {
        // Виправлено: isBlank() замінено на сумісний з Java 8 варіант [cite: 1359]
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва не може бути порожньою");
        }
        this.title = title;
        this.author = author;
    }

    public abstract String toTextLine();
    
    public String getTitle() { 
        return title; 
    }
}