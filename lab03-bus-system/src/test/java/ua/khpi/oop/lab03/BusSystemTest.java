package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BusSystemTest {
    private Driver testDriver;
    private Bus testBus;

    @BeforeEach
    void init() {
        testDriver = new Driver("Олексій Коваленко");
        testBus = new Bus("AX1111AA", 50);
    }

    @Test
    @DisplayName("Перевірка успішного створення об'єктів")
    void testCreationSuccess() {
        assertEquals("Олексій Коваленко", testDriver.getFullName());
        assertEquals(50, testBus.getCapacity());
    }

    @Test
    @DisplayName("Перевірка додавання рейсу")
    void testAddRouteUpdatesState() {
        Route route = new Route("Харків-Київ", testBus);
        testDriver.addRoute(route);
        assertEquals(1, testDriver.getRoutesCount());
    }

    @Test
    @DisplayName("Негативний сценарій: некоректна місткість автобуса")
    void testNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Bus("BT7777CB", 0);
        });
    }

    @Test
    @DisplayName("Негативний сценарій: додавання null-рейсу водію")
    void testAddNullRoute() {
        assertThrows(IllegalArgumentException.class, () -> {
            testDriver.addRoute(null);
        });
    }
}