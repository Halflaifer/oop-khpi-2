package ua.khpi.oop.lab05.demo;

import org.openjdk.jol.info.ClassLayout;
import ua.khpi.oop.lab05.model.SpecialtyCoffee;

public class lab05JolDemo {
    public static void main(String[] args) {
        SpecialtyCoffee coffee = new SpecialtyCoffee("Arabica", 95.0, 200, "Medium", "Brazil");
        System.out.println(ClassLayout.parseInstance(coffee).toPrintable());
    }
}