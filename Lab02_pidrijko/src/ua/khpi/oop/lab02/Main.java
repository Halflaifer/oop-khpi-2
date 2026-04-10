package ua.khpi.oop.lab02;

public class Main {
    public static void main(String[] args) {
        // 1. Створюємо водія (тепер тільки ім'я, без стажу)
        Driver driver = new Driver("Олексій Коваленко");

        // 2. Створюємо автобус
        Bus bus = new Bus("KA 7788 BT", 52);

        // 3. Створюємо рейси (без передачі водія в конструктор)
        Route route1 = new Route("405", "Львів", bus);
        Route route2 = new Route("102", "Київ", bus);

        // 4. Реалізуємо зв'язок: додаємо рейси водію
        driver.addRoute(route1);
        driver.addRoute(route2);

        // 5. Вивід результатів
        System.out.println(driver);
        System.out.println(route1);
        System.out.println(route2);
    }
}