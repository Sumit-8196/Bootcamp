package org.example.com.bootcamp.FirstDay;

public class Rectangle {

    private final int length;
    private final int breadth;
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public int getArea(){
        return length*breadth;
    }
    public int getPerimeter(){
        return 2*(length + breadth);
    }
}
