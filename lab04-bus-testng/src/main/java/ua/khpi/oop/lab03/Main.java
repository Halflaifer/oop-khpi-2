package ua.khpi.oop.lab03;

public class Main {
    public static void main(String[] args) {
        // 1. Створюємо водія
        Driver driver = new Driver("Олексій Коваленко");

        // 2. Створюємо автобус
        Bus bus = new Bus("KA 7788 BT", 52);

        // 3. Створюємо рейси (Використовуємо клас Route, а не BusSystemTest!)
        Route route1 = new Route("Львів", bus);
        Route route2 = new Route("Київ", bus);

        // 4. Реалізуємо зв'язок
        driver.addRoute(route1);
        driver.addRoute(route2);

        // 5. Вивід результатів
        System.out.println(driver);
        System.out.println("Рейс 1 до м. " + route1.getDestination());
        System.out.println("Рейс 2 до м. " + route2.getDestination());
    }
}