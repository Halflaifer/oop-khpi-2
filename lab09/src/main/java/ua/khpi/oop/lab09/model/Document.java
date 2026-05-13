package ua.khpi.oop.lab09.model;

public class Document implements Comparable<Document> {
    private final String title;
    private final String type;

    public Document(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() { return title; }

    @Override
    public int compareTo(Document other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Документ{назва='" + title + "', тип='" + type + "'}";
    }
}