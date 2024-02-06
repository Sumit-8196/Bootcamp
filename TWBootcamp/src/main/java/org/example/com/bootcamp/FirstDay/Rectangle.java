package org.example.com.bootcamp.FirstDay;

import org.example.com.bootcamp.SecondDay.LengthScale;

import java.security.InvalidParameterException;

public class Rectangle {

    private final int length;
    private final int breadth;

    private final LengthScale scale;

    public Rectangle(int length, int breadth, LengthScale scale) {
        this.length = length;
        this.breadth = breadth;
        this.scale = scale;
    }

    public String getArea() {
        if (length < 0 || breadth < 0) {
            throw new IllegalArgumentException("side should be non-negative integer");
        }
        return length * breadth + " " + scale.toString() + "SQR";
    }

    public String getPerimeter() {
        if (length < 0 || breadth < 0) {
            throw new IllegalArgumentException("side should be non-negative integer");
        }
        return 2 * (length + breadth) + scale.toString();
    }

}
