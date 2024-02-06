package org.example.com.bootcamp.SecondDay;

public class Measurement {
    double quantity = 0;
    BaseUnit unit;

    public Measurement(BaseUnit unit, double quantity) {
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthMeasurementService givenLengthMeasurementService = (LengthMeasurementService) o;
        return quantity == givenLengthMeasurementService.type.getScale() * givenLengthMeasurementService.quantity;
    }


}
