package org.example.com.bootcamp.SecondDay;

import java.util.Objects;

public class UnitMeasurement {
    private final Unit type;
    private final double quantity;

    public UnitMeasurement(Unit type, double quantity){
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitMeasurement givenUnitMeasurement = (UnitMeasurement) o;
        return quantity == givenUnitMeasurement.type.getScale()*givenUnitMeasurement.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, quantity);
    }

    public UnitMeasurement add(UnitMeasurement unitMeasurement){

        double sumValue = this.type.getScale()*this.quantity + unitMeasurement.type.getScale()* unitMeasurement.quantity;
        return new UnitMeasurement(this.type,
                switch (this.type) {
                case Unit.M -> sumValue / 100;
                case Unit.KM -> sumValue / 10000;
                default -> sumValue;
        });
    }
}
