package com.thoughtworks.core;

public class Measurement {

    private final static String YARDS = "yards";
    private final static String FEET = "feet";
    private final static String INCHES = "inches";
    private int length;
    private String unit;

    public Measurement(int length, String unit) {
        this.length = length;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        Measurement measurement = (Measurement) obj;
        return this.length == measurement.length && this.unit.equalsIgnoreCase(measurement.unit);
    }

    public Measurement add(Measurement measurement) {
        if (!INCHES.equalsIgnoreCase(measurement.unit)) {
            measurement = measurement.convertToInches();
        }
        return new Measurement(length + measurement.length, unit);
    }

    private Measurement convertToInches() {
        if (YARDS.equalsIgnoreCase(unit))
            return new YardsToInchesStrategy().getMeasurement(this.length);
        else if (FEET.equalsIgnoreCase(unit)) {
            return new FeetToInchesStrategy().getMeasurement(this.length);
        } else {
            return null;
        }
    }
}

