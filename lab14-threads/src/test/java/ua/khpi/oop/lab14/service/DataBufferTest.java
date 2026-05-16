package ua.khpi.oop.lab14.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab14.model.SensorData;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DataBufferTest {

    @Test
    void testBufferPutAndTake() throws InterruptedException {
        DataBuffer buffer = new DataBuffer(2);
        SensorData testData = new SensorData("TEST-01", 25.5, LocalDateTime.now());

        buffer.put(testData);
        assertEquals(1, buffer.getSize());

        SensorData pulledData = buffer.take();
        assertEquals(0, buffer.getSize());
        assertEquals("TEST-01", pulledData.getSensorId());
        assertEquals(25.5, pulledData.getValue());
    }
}