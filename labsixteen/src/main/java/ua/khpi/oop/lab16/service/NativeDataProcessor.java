package ua.khpi.oop.lab16.service;

public class NativeDataProcessor {
    static {

        System.loadLibrary("nativecalc"); 
    }


    public native double calculateAverageNative(double[] values);
}