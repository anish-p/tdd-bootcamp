package com.thoughtworks.core;

public class YardsToInchesStrategy implements MeasurementStrategy {

    public Measurement getMeasurement(int length) {
        return new Measurement(length * 36, "inches");
    }
}
