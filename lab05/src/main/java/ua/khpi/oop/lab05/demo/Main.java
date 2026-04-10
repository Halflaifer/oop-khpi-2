package ua.khpi.oop.lab05.demo;

import ua.khpi.oop.lab05.model.SpecialtyCoffee;

public class Main {
    public static void main(String[] args) {
        SpecialtyCoffee coffee = new SpecialtyCoffee("Ефіопія", 120.0, 250, "Світле", "Африка");
        System.out.println(coffee.description());
    }
}