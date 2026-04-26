package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonitoringPolymorphismTest {
    @Test
    void shouldDispatchExecuteTaskCorrectly() {
        MonitoringTask[] tasks = {
            new TemperatureMonitoring("Loc1", 20.0),
            new AirQualityMonitoring("Loc2", 50),
            new NoiseMonitoring("Loc3", 40.0)
        };

        assertTrue(tasks[0].executeTask().contains("температури"));
        assertTrue(tasks[1].executeTask().contains("AQI"));
        assertTrue(tasks[2].executeTask().contains("шуму"));
    }
}