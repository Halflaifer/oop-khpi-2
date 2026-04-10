package ua.khpi.oop.lab05.model;

public class Beverage extends MenuItem {
    private int volumeMl;

    public Beverage(String name, double price, int volumeMl) {
        super(name, price);
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() { return volumeMl; }

    @Override
    public String description() {
        return super.description() + ", об'єм: " + volumeMl + "мл";
    }
}