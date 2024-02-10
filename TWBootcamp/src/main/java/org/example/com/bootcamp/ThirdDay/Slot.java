package org.example.com.bootcamp.ThirdDay;

public class Slot {
    private final Car car;

    public int getSlotNo() {
        return slotNo;
    }

    private final int slotNo;

    Slot(int slotNo, Car car) {
        this.slotNo = slotNo;
        this.car = car;
    }

}
