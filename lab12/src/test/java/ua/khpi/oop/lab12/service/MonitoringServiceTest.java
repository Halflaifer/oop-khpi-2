package ua.khpi.oop.lab12.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.*;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class MonitoringServiceTest {
    @Test
    void testCriticalFiltering() {
        MonitoringService service = new MonitoringService();
        Sensor s = new Sensor("1", "Type");
        service.addMeasurement(new Measurement(s, 10, LocalDateTime.now(), AlertType.INFO));
        service.addMeasurement(new Measurement(s, 50, LocalDateTime.now(), AlertType.CRITICAL));
        
        assertEquals(1, service.getCriticalAlerts().size());
        assertEquals(AlertType.CRITICAL, service.getCriticalAlerts().get(0).getAlert());
    }
}