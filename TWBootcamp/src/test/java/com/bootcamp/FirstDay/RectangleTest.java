package com.bootcamp.FirstDay;

import org.example.com.bootcamp.FirstDay.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void verifyAreaForValidDimension() {
        assertEquals(12, new Rectangle(3, 4).getArea());
        assertEquals(8, new Rectangle(2, 4).getArea());
        assertEquals(3, new Rectangle(3, 1).getArea());
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyAreaForInvalidDimension() {
        new Rectangle(-3, 4).getArea();
    }
}
