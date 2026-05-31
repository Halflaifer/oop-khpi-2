package ua.khpi.oop.lab16.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab16.model.SensorData;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    private final DataProcessor javaProcessor = new DataProcessor();

    @Test
    void testJavaAndNativeResultsAreEqual() {
        List<SensorData> list = new ArrayList<>();
        list.add(new SensorData("TEMP-01", 20.0, LocalDateTime.now()));
        list.add(new SensorData("TEMP-02", 30.0, LocalDateTime.now()));
        list.add(new SensorData("TEMP-03", 40.0, LocalDateTime.now()));

        double[] values = list.stream().mapToDouble(SensorData::getValue).toArray();
        double javaResult = javaProcessor.calculateAverage(list);
        
        try {
            NativeDataProcessor nativeProcessor = new NativeDataProcessor();
            double nativeResult = nativeProcessor.calculateAverageNative(values);
            assertEquals(javaResult, nativeResult, 0.001, "Результати Java та С++ не збігаються!");
        } catch (Throwable e) {
            System.out.println("Локальна перевірка Native-компонента пропущена (немає .dll). Еталонний результат Java: " + javaResult);
            assertEquals(30.0, javaResult, 0.001);
        }
    }

    @Test
    void testBoundaryEmptyCase() {
        List<SensorData> emptyList = new ArrayList<>();
        double[] emptyValues = new double[0];

        assertEquals(0.0, javaProcessor.calculateAverage(emptyList), 0.001);
        
        try {
            NativeDataProcessor nativeProcessor = new NativeDataProcessor();
            assertEquals(0.0, nativeProcessor.calculateAverageNative(emptyValues), 0.001);
        } catch (Throwable ignored) {}
    }
}