package org.example.com.bootcamp.SecondDay;

public enum LengthUnit implements BaseUnit {
    KM(100000),
    CM(1),
    M(100);

    private final double scale;

    LengthUnit(double scale) {
        this.scale = scale;
    }

    @Override
    public double getScaleValue() {
        return scale;
    }
}
