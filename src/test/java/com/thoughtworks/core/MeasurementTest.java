package com.thoughtworks.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class MeasurementTest {

    @Test
    public void shouldReturnTheLengthInInches() {
        Measurement measurement = new Measurement(1, "inches");
        assertThat(measurement, is(new Measurement(1, "inches")));
    }

    @Test
    public void shouldNotBeEqualFor2DifferentMeasurements() {
        Measurement measurementInInches = new Measurement(10, "inches");
        Measurement measurementInYards = new Measurement(10, "yards");
        assertNotEquals(measurementInInches, measurementInYards);
    }

    @Test
    public void shouldAdd2Measurements() {
        Measurement measurement = new Measurement(10, "inches");

        Measurement addition = measurement.add(new Measurement(12, "inches"));

        assertThat(new Measurement(22, "inches"), is(addition));
    }

    @Test
    public void shouldAdd2DifferentMeasurements() {
        Measurement measurement = new Measurement(1, "inches");

        Measurement additionBetweenInchesAndYards = measurement.add(new Measurement(1, "yards"));

        assertThat(additionBetweenInchesAndYards, is(new Measurement(37, "inches")));

        assertThat(measurement.add(new Measurement(1, "feet")), is(new Measurement(13, "inches")));
    }

}
