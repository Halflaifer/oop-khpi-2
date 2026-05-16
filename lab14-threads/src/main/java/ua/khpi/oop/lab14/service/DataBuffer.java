package ua.khpi.oop.lab14.service;

import ua.khpi.oop.lab14.model.SensorData;
import java.util.LinkedList;
import java.util.Queue;

public class DataBuffer {
    private final Queue<SensorData> buffer = new LinkedList<SensorData>();
    private final int capacity;

    public DataBuffer(int capacity) {
        this.capacity = capacity;
    }


    public synchronized void put(SensorData data) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(data);
        notifyAll(); 
    }


    public synchronized SensorData take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); 
        }
        SensorData data = buffer.poll();
        notifyAll(); 
        return data;
    }

    public synchronized int getSize() {
        return buffer.size();
    }
}