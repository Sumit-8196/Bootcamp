package org.example.com.bootcamp.SecondDay;

public enum LengthScale implements BaseScale {
    KM(100 * 1000),
    CM(1),
    M(100);

    private final double scale;

    LengthScale(double scale) {
        this.scale = scale;
    }

    @Override
    public double convertToBase(double quantity) {
        return scale * quantity;
    }

    @Override
    public double convertFromBase(double quantity) {
        return quantity / scale;
    }
}
