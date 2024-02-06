package org.example.com.bootcamp.SecondDay;

public enum TemperatureUnit implements BaseUnit {
    C(1, 0),
    K(1, 273.15),
    F(0.56, 17.77);
    private final double scale;
    private final double baseValue;

    TemperatureUnit(double multiplier, double baseValue) {
        this.scale = multiplier;
        this.baseValue = baseValue;
    }

    public double getBaseValue() {
        return this.baseValue;
    }

    @Override
    public double getScaleValue() {
        return this.scale;
    }
    // y = mx + c;
}
