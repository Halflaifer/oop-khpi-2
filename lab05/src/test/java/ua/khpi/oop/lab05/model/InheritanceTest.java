package ua.khpi.oop.lab05.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InheritanceTest {
    @Test
    void testFullHierarchyAccess() {
        SpecialtyCoffee sc = new SpecialtyCoffee("Latte", 75.0, 300, "Dark", "Colombia");
        
        assertEquals("Latte", sc.getName());
        assertEquals(75.0, sc.getPrice());
        assertEquals(300, sc.getVolumeMl());
        assertEquals("Dark", sc.getRoastLevel());
        assertEquals("Colombia", sc.getOriginRegion());
    }

    @Test
    void testDescriptionOverride() {
        SpecialtyCoffee sc = new SpecialtyCoffee("Flat White", 80.0, 200, "Light", "Vietnam");
        String desc = sc.description();
        
        assertTrue(desc.contains("Flat White"));
        assertTrue(desc.contains("Vietnam"));
    }
}