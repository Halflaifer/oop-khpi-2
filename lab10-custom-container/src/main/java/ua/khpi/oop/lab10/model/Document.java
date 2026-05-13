package ua.khpi.oop.lab10.model;

import java.io.Serializable;
import java.util.Objects;

public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;

    public Document(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(title, document.title);
    }

    @Override
    public int hashCode() { return Objects.hash(title); }

    @Override
    public String toString() { return "Document{title='" + title + "'}"; }
}