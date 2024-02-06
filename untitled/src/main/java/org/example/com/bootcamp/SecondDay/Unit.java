package org.example.com.bootcamp.SecondDay;

public enum Unit {
    KM(100000),
    CM(1),
    M(100);

    private final double scale;
    Unit(double scale){
        this.scale = scale;
    }
    public double getScale(){
        return this.scale;
    }
}
