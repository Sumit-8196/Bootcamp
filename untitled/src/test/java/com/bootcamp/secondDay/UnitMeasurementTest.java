package com.bootcamp.secondDay;

import org.example.com.bootcamp.SecondDay.Unit;
import org.example.com.bootcamp.SecondDay.UnitMeasurement;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitMeasurementTest {

    @Test
    public void verifyLengthAndUnitWithOneCm(){
        UnitMeasurement unitMeasurement = new UnitMeasurement(Unit.CM, 1);
        assertTrue(unitMeasurement.equals(new UnitMeasurement(Unit.CM, 1)));
    }
    @Test
    public void should_return_false_when_LengthAndUnit_notEqualTo_OneCm(){
        UnitMeasurement unitMeasurement = new UnitMeasurement(Unit.CM, 1);
        assertFalse(unitMeasurement.equals(new UnitMeasurement(Unit.CM, 2)));
    }

    @Test
    public void verify_for_quantity_given_in_meter(){
        UnitMeasurement unitMeasurement = new UnitMeasurement(Unit.CM, 100);
        assertTrue(unitMeasurement.equals(new UnitMeasurement(Unit.M, 1)));
        assertFalse(unitMeasurement.equals(new UnitMeasurement(Unit.M, 2)));
        assertFalse(unitMeasurement.equals(new UnitMeasurement(Unit.M, 1.1)));

    }
    //todo
    //¯replace with equals method
    @Test
    public void verify_for_quantity_given_in_km(){
        UnitMeasurement unitMeasurement = new UnitMeasurement(Unit.CM, 100);
        assertTrue(unitMeasurement.equals(new UnitMeasurement(Unit.KM, 0.001)));
        assertFalse(unitMeasurement.equals(new UnitMeasurement(Unit.KM, 0.01)));
    }
    // 100cm + 1m = 200cm
    @Test
    public void verify_sum_of_cm_and_m_unit(){
        UnitMeasurement unitMeasurementOne = new UnitMeasurement(Unit.CM, 100);
        UnitMeasurement unitMeasurementTwo = new UnitMeasurement(Unit.M, 1);
        UnitMeasurement unitMeasurementThree = unitMeasurementOne.add(unitMeasurementTwo);
        assertEquals(unitMeasurementOne.getType(), unitMeasurementThree.getType());
        assertEquals(200, unitMeasurementThree.getQuantity(),0.001);
    }
    @Test
    public void verify_sum_of_m_and_cm_unit(){
        UnitMeasurement unitMeasurementOne = new UnitMeasurement(Unit.M, 2);
        UnitMeasurement unitMeasurementTwo = new UnitMeasurement(Unit.CM, 150);
        UnitMeasurement unitMeasurementThree = unitMeasurementOne.add(unitMeasurementTwo);
        assertEquals(unitMeasurementOne.getType(), unitMeasurementThree.getType());
        assertEquals(3.5, unitMeasurementThree.getQuantity(), 0.001);
    }





}
