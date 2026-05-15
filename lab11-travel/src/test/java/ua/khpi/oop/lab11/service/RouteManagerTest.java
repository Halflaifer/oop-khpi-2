package ua.khpi.oop.lab11.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.TripStop;
import static org.junit.jupiter.api.Assertions.*;

public class RouteManagerTest {
    @Test
    void testAddAndOrder() {
        RouteManager manager = new RouteManager();
        TripStop s1 = new TripStop("ID1", "City1", "Station1");
        TripStop s2 = new TripStop("ID2", "City2", "Station2");
        
        manager.addStop(s1);
        manager.addStop(s2);
        
        assertEquals(2, manager.getFullRoute().size());
        assertEquals(s1, manager.getFullRoute().get(0)); 
    }

    @Test
    void testDuplicateIdThrowsException() {
        RouteManager manager = new RouteManager();
        manager.addStop(new TripStop("SAME", "City1", "St1"));
        

        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStop(new TripStop("SAME", "City2", "St2"));
        });
    }

    @Test
    void testUniqueCities() {
        RouteManager manager = new RouteManager();
        manager.addStop(new TripStop("1", "Львів", "А"));
        manager.addStop(new TripStop("2", "Львів", "Б")); 
        

        assertEquals(1, manager.getCities().size());
    }
}