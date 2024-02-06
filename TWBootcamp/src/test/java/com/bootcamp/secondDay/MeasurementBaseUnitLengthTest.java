package com.bootcamp.secondDay;

import org.example.com.bootcamp.SecondDay.TemperatureUnit;
import org.example.com.bootcamp.SecondDay.LengthUnit;
import org.example.com.bootcamp.SecondDay.LengthMeasurementService;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementBaseUnitLengthTest {

    @Test
    public void verifyLengthAndUnitWithOneCm() {
        LengthMeasurementService lengthMeasurementService = new LengthMeasurementService(LengthUnit.CM, 1);
        assertTrue(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.CM, 1)));
    }

    @Test
    public void should_return_false_when_LengthAndUnit_notEqualTo_OneCm() {
        LengthMeasurementService lengthMeasurementService = new LengthMeasurementService(LengthUnit.CM, 1);
        assertFalse(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.CM, 2)));
    }

    @Test
    public void verify_for_quantity_given_in_meter() {
        LengthMeasurementService lengthMeasurementService = new LengthMeasurementService(LengthUnit.CM, 100);
        assertTrue(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.M, 1)));
        assertFalse(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.M, 2)));
        assertFalse(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.M, 1.1)));

    }

    @Test
    public void verify_for_quantity_given_in_km() {
        LengthMeasurementService lengthMeasurementService = new LengthMeasurementService(LengthUnit.CM, 100);
        assertTrue(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.KM, 0.001)));
        assertFalse(lengthMeasurementService.equals(new LengthMeasurementService(LengthUnit.KM, 0.01)));
    }

    // 100cm + 1m = 200cm
    @Test
    public void verify_sum_of_cm_and_m_unit() {
        LengthMeasurementService lengthMeasurementServiceOne = new LengthMeasurementService(LengthUnit.CM, 100);
        LengthMeasurementService lengthMeasurementServiceTwo = new LengthMeasurementService(LengthUnit.M, 1);
        LengthMeasurementService lengthMeasurementServiceThree = lengthMeasurementServiceOne.add(lengthMeasurementServiceTwo);
        assertEquals(lengthMeasurementServiceOne.getType(), lengthMeasurementServiceThree.getType());
        assertEquals(200, lengthMeasurementServiceThree.getQuantity(), 0.001);
    }

    @Test
    public void verify_sum_of_m_and_cm_unit() {
        LengthMeasurementService lengthMeasurementServiceOne = new LengthMeasurementService(LengthUnit.M, 2);
        LengthMeasurementService lengthMeasurementServiceTwo = new LengthMeasurementService(LengthUnit.CM, 150);
        LengthMeasurementService lengthMeasurementServiceThree = lengthMeasurementServiceOne.add(lengthMeasurementServiceTwo);
        assertEquals(lengthMeasurementServiceOne.getType(), lengthMeasurementServiceThree.getType());
        assertEquals(3.5, lengthMeasurementServiceThree.getQuantity(), 0.001);
    }

    @Test
    public void verify_temperature_equality() {
        LengthMeasurementService lengthMeasurementServiceOne = new LengthMeasurementService(TemperatureUnit.C, 0);
        LengthMeasurementService lengthMeasurementServiceTwo = new LengthMeasurementService(TemperatureUnit.F, 32);
        LengthMeasurementService lengthMeasurementServiceThree = lengthMeasurementServiceOne.convertTemperatureUnit(lengthMeasurementServiceTwo);
        assertEquals(lengthMeasurementServiceThree.getTemperatureUnit(), lengthMeasurementServiceOne.getTemperatureUnit());

    }


}
