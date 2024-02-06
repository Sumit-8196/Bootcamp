package com.bootcamp.FirstDay;

import org.example.com.bootcamp.FirstDay.Rectangle;
import org.example.com.bootcamp.SecondDay.LengthScale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void verifyAreaForValidDimension() {
        assertEquals("12 CMSQR", new Rectangle(3, 4, LengthScale.CM).getArea());
        assertEquals("8 KMSQR", new Rectangle(2, 4, LengthScale.KM).getArea());
        assertEquals("3 MSQR", new Rectangle(3, 1, LengthScale.M).getArea());
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyAreaForInvalidDimension() {
        new Rectangle(-3, 4, LengthScale.CM).getArea();
    }

    @Test
    public void verifyPerimeterForValidDimension() {
        assertEquals("14CM", new Rectangle(3, 4, LengthScale.CM).getPerimeter());
        assertEquals("12KM", new Rectangle(2, 4, LengthScale.KM).getPerimeter());
        assertEquals("8M", new Rectangle(3, 1, LengthScale.M).getPerimeter());
    }
}
