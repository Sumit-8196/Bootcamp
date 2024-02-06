package org.example.com.bootcamp.SecondDay;

import java.util.function.DoubleUnaryOperator;

public enum TemperatureScale implements BaseScale {
    CELSIUS(c -> c, c -> c),
    FAHRENHEIT(f -> ((double) 5 / 9) * (f - 32), c -> ((double) 9 / 5) * c + 32),
    KELVIN(k -> k - 273.15, c -> c + 273.15);
    private final DoubleUnaryOperator toBaseUnit;
    private final DoubleUnaryOperator fromBaseUnit;

    TemperatureScale(DoubleUnaryOperator toBaseUnit, DoubleUnaryOperator fromBaseUnit) {
        this.toBaseUnit = toBaseUnit;
        this.fromBaseUnit = fromBaseUnit;
    }

    public double convertFromBase(double quantity) {
        return fromBaseUnit.applyAsDouble(quantity);
    }

    public double convertToBase(double quantity) {
        return toBaseUnit.applyAsDouble(quantity);
    }

}
