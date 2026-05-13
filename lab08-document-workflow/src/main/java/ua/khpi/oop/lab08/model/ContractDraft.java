package ua.khpi.oop.lab08.model;

public class ContractDraft extends Document {
    private static final long serialVersionUID = 1L;
    private double budget;

    public ContractDraft(String title, String author, double budget) {
        super(title, author);
        this.budget = budget;
    }

    @Override
    public String toTextLine() {
        // Формат: тип;назва;автор;бюджет [cite: 1287, 1456]
        return "CONTRACT;" + title + ";" + author + ";" + budget;
    }

    @Override
    public String toString() {
        return "Контракт: " + title + " (Автор: " + author + ", Бюджет: " + budget + ")";
    }
}