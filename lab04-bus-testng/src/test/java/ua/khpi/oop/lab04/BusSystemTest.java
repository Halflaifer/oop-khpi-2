package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ua.khpi.oop.lab03.Bus;
import ua.khpi.oop.lab03.Driver;
import ua.khpi.oop.lab03.Route;

public class BusSystemTest {
    private Driver driver;
    private Bus bus;

    @BeforeMethod(groups = {"smoke", "negative", "boundary"})
    public void setUp() {
        // Фікстура перед кожним методом 
        driver = new Driver("Олексій Коваленко");
        bus = new Bus("KA 7788 BT", 50);
    }

    // 1. Параметризований тест через DataProvider 
    @DataProvider(name = "busData")
    public Object[][] getBusData() {
        return new Object[][] {
            {"AA 1111 AA", 20},
            {"BB 2222 BB", 45},
            {"CC 3333 CC", 80}
        };
    }

    @Test(dataProvider = "busData", groups = {"smoke"})
    public void testBusCreation(String plate, int capacity) {
        Bus b = new Bus(plate, capacity);
        Assert.assertEquals(b.getCapacity(), capacity);
    }

    // 2. Негативний сценарій з очікуваним винятком 
    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative"})
    public void testInvalidBusCapacity() {
        new Bus("ERROR", 0);
    }

    // 3. Тест зі зміною стану
    @Test(groups = {"smoke"})
    public void testAddRouteUpdatesCount() {
        Route route = new Route("Харків", bus);
        driver.addRoute(route);
        Assert.assertEquals(driver.getRoutesCount(), 1);
    }

    // 4. Граничний сценарій
    @Test(groups = {"boundary"})
    public void testMinimumCapacity() {
        Bus tinyBus = new Bus("MINI", 1);
        Assert.assertEquals(tinyBus.getCapacity(), 1);
    }
}