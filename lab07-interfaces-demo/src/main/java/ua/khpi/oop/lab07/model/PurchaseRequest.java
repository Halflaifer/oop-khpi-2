package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Approvable;

public class PurchaseRequest implements Approvable {
    private final double amount;

    public PurchaseRequest(double amount) {
        this.amount = amount;
    }

    @Override
    public String approve(String approverName) {
        return "Запит на закупівлю (" + amount + " грн) затверджено: " + approverName;
    }
}