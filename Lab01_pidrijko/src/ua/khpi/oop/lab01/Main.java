package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Driver driver1 = new Driver("Іван Петровичу", 10);
        Driver driver2 = new Driver("Іван Петровичу", 10); // Для перевірки equals
        Bus bus = new Bus("AX1234CB", 45);
        
        Route route = new Route("102-А", "Київ", bus, driver1);

        // Демонстрація методів
        System.out.println("--- Інформація про рейс ---");
        System.out.println(route.toString());

        System.out.println("\n--- Перевірка спеціальних методів ---");
        System.out.println("Об'єкти водіїв однакові: " + driver1.equals(driver2));
        System.out.println("HashCode 1: " + driver1.hashCode());
        System.out.println("HashCode 2: " + driver2.hashCode());
    }
}