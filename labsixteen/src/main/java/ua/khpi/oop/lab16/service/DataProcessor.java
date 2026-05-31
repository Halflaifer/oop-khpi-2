package ua.khpi.oop.lab16.service;
import ua.khpi.oop.lab16.model.SensorData;
import java.util.List;

public class DataProcessor {
    
    public double calculateAverage(List<SensorData> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0;
        for (SensorData data : dataList) {
            sum += data.getValue();
        }
        
        return sum / dataList.size();
    }
}