package org.example.com.bootcamp.SecondDay;

import java.security.InvalidParameterException;
import java.util.Objects;

public class MeasurementCalculation {
    private final BaseScale scale;
    private final double quantity;

    public MeasurementCalculation(BaseScale type, double quantity) {
        this.scale = type;
        this.quantity = quantity;
    }

    public BaseScale getScale() {
        return scale;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasurementCalculation o1 = (MeasurementCalculation) o;
        return round2(this.scale.convertToBase(this.quantity)) == round2(o1.scale.convertToBase(o1.quantity));
    }

    @Override
    public int hashCode() {
        return Objects.hash(scale, quantity);
    }

    public MeasurementCalculation add(MeasurementCalculation otherLength) throws InvalidParameterException {
        if (otherLength.getScale() instanceof TemperatureScale) {
            throw new InvalidParameterException("temperature unit cannot be added");
        }
        double sumValue = this.scale.convertToBase(this.quantity) + otherLength.getScale().convertToBase(otherLength.getQuantity());
        return new MeasurementCalculation(this.scale, this.scale.convertFromBase(sumValue));
    }

    public MeasurementCalculation convertTo(BaseScale to) {
        return new MeasurementCalculation(to, to.convertFromBase(this.scale.convertToBase(this.quantity)));
    }

    private static double round2(double d) {
        return Math.round(d * 100) / 100.0;
    }
}
