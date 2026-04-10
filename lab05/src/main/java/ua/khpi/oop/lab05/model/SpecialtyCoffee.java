package ua.khpi.oop.lab05.model;

public final class SpecialtyCoffee extends Coffee {
    private String originRegion;

    public SpecialtyCoffee(String name, double price, int volumeMl, String roast, String region) {
        super(name, price, volumeMl, roast);
        this.originRegion = region;
    }

    public String getOriginRegion() { return originRegion; }

    @Override
    public String description() {
        return super.description() + ", регіон: " + originRegion;
    }
}