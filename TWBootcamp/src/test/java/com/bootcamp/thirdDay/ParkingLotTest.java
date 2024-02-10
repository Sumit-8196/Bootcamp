package com.bootcamp.thirdDay;

import org.example.com.bootcamp.ThirdDay.Car;
import org.example.com.bootcamp.ThirdDay.ParkingALot;
import org.example.com.bootcamp.ThirdDay.actor.ParkingOwner;
import org.example.com.bootcamp.ThirdDay.actor.ParkingSecurity;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void driver_should_park_car_when_slot_available() {
        Car car = new Car("123");
        ParkingALot parkingALot = new ParkingALot(10);
        assertTrue(parkingALot.parkCar(car));

    }

    @Test
    public void driver_should_not_park_as_parkingLot_is_full() {
        ParkingOwner owner = new ParkingOwner();
        ParkingALot parkingALot = new ParkingALot(1, owner);
        owner.assignParkingALot(parkingALot);
        parkingALot.parkCar(new Car("123"));
        assertFalse(parkingALot.parkCar(new Car("ABC123")));

    }

    @Test
    public void driver_should_able_to_unpark() {
        Car car = new Car("ABC");
        ParkingALot parkingALot = new ParkingALot(2);
        parkingALot.parkCar(car);
        //parkingALot.unparkCar(car);
        assertTrue(parkingALot.unparkCar((car)));
    }

    @Test
    public void driver_should_not_able_to_unpark_when_not_park() {
        Car car = new Car("ABC");
        ParkingALot parkingALot = new ParkingALot(2);
        assertFalse(parkingALot.unparkCar(car));
    }

    @Test
    public void notify_owner_when_parking_is_full() {
        ParkingOwner owner = new ParkingOwner();
        ParkingALot parkingALot = new ParkingALot(2, owner);
        owner.assignParkingALot(parkingALot);

        assertFalse(parkingALot.getParkingOwner().isParkingALotIsFull());
        parkingALot.parkCar(new Car("ABC"));
        parkingALot.parkCar(new Car("ABD"));
        assertTrue(parkingALot.getParkingOwner().isParkingALotIsFull());
    }

    @Test
    public void notify_owner_when_parking_is_available() {
        ParkingOwner owner = new ParkingOwner();
        ParkingALot parkingALot = new ParkingALot(2, owner);
        owner.assignParkingALot(parkingALot);

        parkingALot.parkCar(new Car("ABC"));
        parkingALot.parkCar(new Car("ABD"));
        assertTrue(parkingALot.getParkingOwner().isParkingALotIsFull());
        parkingALot.unparkCar(new Car("ABC"));
        assertFalse(parkingALot.getParkingOwner().isParkingALotIsFull());
    }

    @Test
    public void notify_security_when_parking_is_available() {

        ParkingOwner owner = new ParkingOwner();
        ParkingSecurity security = new ParkingSecurity();
        ParkingALot parkingALot = new ParkingALot(2, owner, security);
        owner.assignParkingALot(parkingALot);
        parkingALot.parkCar(new Car("123"));
        parkingALot.parkCar(new Car("124"));

        assertTrue(security.isTrafficRedirected());

    }
}

/// Car class : Car registration no is unique idetifier for parking
// Parking Lot: Max_size, cur_size, register_car(method), isAvailable()
