package org.example.com.bootcamp.SecondDay;

import java.util.Objects;

public class LengthMeasurementService extends Measurement {
    private final LengthUnit type;
    private final double quantity;

    private final TemperatureUnit temperatureUnit;

    public LengthMeasurementService(LengthUnit type, double quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public LengthMeasurementService(TemperatureUnit type, double quantity) {
        this.temperatureUnit = type;
        this.quantity = quantity;
    }

    public LengthUnit getType() {
        return type;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthMeasurementService givenLengthMeasurementService = (LengthMeasurementService) o;
        return quantity == givenLengthMeasurementService.type.getScale() * givenLengthMeasurementService.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, quantity);
    }

    public LengthMeasurementService add(LengthMeasurementService lengthMeasurementService) {

        double sumValue = this.type.getScale() * this.quantity + lengthMeasurementService.type.getScale() * lengthMeasurementService.quantity;
        return new LengthMeasurementService(this.type,
                switch (this.type) {
                    case LengthUnit.M -> sumValue / 100;
                    case LengthUnit.KM -> sumValue / 10000;
                    default -> sumValue;
                });
    }

    // F = (9/5)C + 32
    public TemperatureUnit convertTemperatureUnit(TemperatureUnit temperatureUnit) {
        temperatureUnit.getScaleValue()
    }
}
