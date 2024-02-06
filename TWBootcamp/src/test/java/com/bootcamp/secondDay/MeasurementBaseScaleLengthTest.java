package com.bootcamp.secondDay;

import org.example.com.bootcamp.SecondDay.*;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class MeasurementBaseScaleLengthTest {

    @Test
    public void verifyLengthAndUnitWithOneCm() {
        MeasurementCalculation MeasurementCalculation = new MeasurementCalculation(LengthScale.CM, 1);
        assertTrue(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.CM, 1)));
    }

    @Test
    public void should_return_false_when_LengthAndUnit_notEqualTo_OneCm() {
        MeasurementCalculation MeasurementCalculation = new MeasurementCalculation(LengthScale.CM, 1);
        assertFalse(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.CM, 2)));
    }

    @Test
    public void verify_for_quantity_given_in_meter() {
        MeasurementCalculation MeasurementCalculation = new MeasurementCalculation(LengthScale.CM, 100);
        assertTrue(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.M, 1)));
        assertFalse(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.M, 2)));
        assertFalse(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.M, 1.1)));

    }

    @Test
    public void verify_for_quantity_given_in_km() {
        MeasurementCalculation MeasurementCalculation = new MeasurementCalculation(LengthScale.CM, 100);
        assertTrue(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.KM, 0.001)));
        assertFalse(MeasurementCalculation.equals(new MeasurementCalculation(LengthScale.KM, 0.01)));
    }

    @Test
    public void verify_sum_of_cm_and_m_unit() {
        MeasurementCalculation lengthCalculationOne = new MeasurementCalculation(LengthScale.CM, 100);
        MeasurementCalculation lengthCalculationTwo = new MeasurementCalculation(LengthScale.M, 1);
        MeasurementCalculation lengthCalculationThree = lengthCalculationOne.add(lengthCalculationTwo);
        assertEquals(lengthCalculationOne.getScale(), lengthCalculationThree.getScale());
        assertEquals(200, lengthCalculationThree.getQuantity(), 0.001);
    }

    @Test
    public void verify_sum_of_m_and_cm_unit() {
        MeasurementCalculation lengthCalculationOne = new MeasurementCalculation(LengthScale.M, 2);
        MeasurementCalculation lengthCalculationTwo = new MeasurementCalculation(LengthScale.CM, 150);
        MeasurementCalculation lengthCalculationThree = lengthCalculationOne.add(lengthCalculationTwo);
        assertEquals(lengthCalculationOne.getScale(), lengthCalculationThree.getScale());
        assertEquals(3.5, lengthCalculationThree.getQuantity(), 0.001);
    }

    @Test
    public void verify_temperature_equality_with_celsius_and_kelvin() {
        MeasurementCalculation temperatureCalculationOne = new MeasurementCalculation(TemperatureScale.CELSIUS, 0);
        MeasurementCalculation temperatureCalculationTwo = new MeasurementCalculation(TemperatureScale.KELVIN, 273.15);
        assertEquals(temperatureCalculationOne, temperatureCalculationTwo);

    }

    @Test
    public void verify_temperature_equality_with_celsius_and_fahrenheit() {
        MeasurementCalculation temperatureCalculationOne = new MeasurementCalculation(TemperatureScale.CELSIUS, 0);
        MeasurementCalculation temperatureCalculationTwo = new MeasurementCalculation(TemperatureScale.FAHRENHEIT, 1);
        MeasurementCalculation temperatureCalculationThree = new MeasurementCalculation(TemperatureScale.FAHRENHEIT, 32);
        assertNotEquals(temperatureCalculationOne, temperatureCalculationTwo);
        assertEquals(temperatureCalculationOne, temperatureCalculationThree);
    }

    @Test
    public void verify_temperature_conversion_from_celsius_to_kelvin() {
        MeasurementCalculation temperatureInCelsius = new MeasurementCalculation(TemperatureScale.CELSIUS, 15.22);
        MeasurementCalculation temperatureInKelvin = new MeasurementCalculation(TemperatureScale.KELVIN, 273.15 + 15.22);
        assertEquals(temperatureInKelvin, temperatureInCelsius.convertTo(TemperatureScale.KELVIN));
    }

    @Test
    public void verify_temperature_conversion_from_fahrenheit_to_kelvin() {
        MeasurementCalculation temperatureInFahrenheit = new MeasurementCalculation(TemperatureScale.FAHRENHEIT, 10);
        MeasurementCalculation temperatureInKelvin = new MeasurementCalculation(TemperatureScale.KELVIN, ((double) 5 / 9) * (469.67));
        assertEquals(temperatureInKelvin, temperatureInFahrenheit.convertTo(TemperatureScale.KELVIN));
    }

    @Test(expected = InvalidParameterException.class)
    public void should_throw_exception_when_two_temperature_added() throws InvalidParameterException {
        MeasurementCalculation temperatureFirst = new MeasurementCalculation(TemperatureScale.CELSIUS, 2);
        MeasurementCalculation temperatureSecond = new MeasurementCalculation(TemperatureScale.CELSIUS, 150);
        temperatureFirst.add(temperatureSecond);
    }


}
