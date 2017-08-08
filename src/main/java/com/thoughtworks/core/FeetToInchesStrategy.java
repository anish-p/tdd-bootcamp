package com.thoughtworks.core;

public class FeetToInchesStrategy implements MeasurementStrategy {

    public Measurement getMeasurement(int length) {
        return new Measurement(length * 12, "inches");
    }
}
