package org.example.com.bootcamp.ThirdDay;

import org.example.com.bootcamp.ThirdDay.actor.ParkingOwner;
import org.example.com.bootcamp.ThirdDay.actor.ParkingSecurity;

import java.util.*;

public class ParkingALot {
    int capacity;
    private final Slot[] bookedSLots;
    int currentOccupiedSize = 0;
    Map<String, Integer> map = new HashMap<>(); // car no -> slot no

    boolean signBoardIsUp;

    public ParkingOwner getParkingOwner() {
        return parkingOwner;
    }

    private ParkingOwner parkingOwner;
    private ParkingSecurity parkingSecurity;

    public ParkingALot(int capacity) {
        bookedSLots = new Slot[capacity];
        this.capacity = capacity;
    }

    public ParkingALot(int capacity, ParkingOwner parkingOwner) {
        this(capacity);
        this.parkingOwner = parkingOwner;
    }

    public ParkingALot(int capacity, ParkingOwner parkingOwner, ParkingSecurity parkingSecurity) {
        this(capacity, parkingOwner);
        this.parkingSecurity = parkingSecurity;
    }

    public boolean parkCar(Car car) {
        if (signBoardIsUp || currentOccupiedSize == capacity) {
            return false;
            //throw new IndexOutOfBoundsException("Parking slot is full");
        }
        int nextAvailableSlot = nextAvailableSlots();
        Slot slot = new Slot(nextAvailableSlot, car);
        bookedSLots[nextAvailableSlot - 1] = slot;
        map.put(car.getCarNumber(), slot.getSlotNo());
        currentOccupiedSize++;
        if (currentOccupiedSize == capacity) {
            //notifyu the user
            parkingOwner.getNotifyForParkingALot(true);
            if (parkingSecurity != null) {
                parkingSecurity.getNotifyForParkingALotFull(true);
            }
        }
        return true;
    }

    public boolean unparkCar(Car car) {
        if (map.get(car.getCarNumber()) == null) {
            return false;
            //throw new RuntimeException("Car is not parked");
        }
        if (currentOccupiedSize == capacity) {
            parkingOwner.getNotifyForParkingALot(false);
            if (parkingSecurity != null) {
                parkingSecurity.getNotifyForParkingALotFull(false);
            }
        }
        bookedSLots[map.get(car.getCarNumber()) - 1] = null;
        map.remove(car.getCarNumber());
        currentOccupiedSize--;
        return true;
    }

    public int nextAvailableSlots() {
        //Slot slot = Arrays.stream(bookedSLots).filter(Objects::isNull).findFirst().get();
        for (int i = 0; i < capacity; i++) {
            if (bookedSLots[i] == null) {
                return i + 1;
            }
        }
        return 0;
    }

    public void setFullSignBoard() {
        signBoardIsUp = true;
    }

    public void removeFullSignBoard() {
        signBoardIsUp = false;
    }
}
