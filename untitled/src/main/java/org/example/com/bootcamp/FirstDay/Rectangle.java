package org.example.com.bootcamp.FirstDay;

import java.security.InvalidParameterException;

public class Rectangle {

    private final int length;
    private final int breadth;
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public int getArea(){
        if(length < 0 || breadth < 0){
            throw new IllegalArgumentException("side should be non-negative integer");
        }
        return length*breadth;
    }
    public int getPerimeter(){
        if(length < 0 || breadth < 0){
            throw new IllegalArgumentException("side should be non-negative integer");
        }
        return 2*(length + breadth);
    }

}
