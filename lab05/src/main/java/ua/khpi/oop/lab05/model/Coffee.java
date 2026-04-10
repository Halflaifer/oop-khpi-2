package ua.khpi.oop.lab05.model;

public class Coffee extends Beverage {
    private String roastLevel;

    public Coffee(String name, double price, int volumeMl, String roastLevel) {
        super(name, price, volumeMl);
        this.roastLevel = roastLevel;
    }

    public String getRoastLevel() { return roastLevel; }

    @Override
    public String description() {
        return super.description() + ", обсмаження: " + roastLevel;
    }
}