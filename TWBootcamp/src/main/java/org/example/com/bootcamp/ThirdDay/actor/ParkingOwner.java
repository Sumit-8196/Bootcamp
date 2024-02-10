package org.example.com.bootcamp.ThirdDay.actor;

import org.example.com.bootcamp.ThirdDay.ParkingALot;

public class ParkingOwner {

    private boolean parkingALotIsFull;

    private ParkingALot parkingALot;

    public void assignParkingALot(ParkingALot parkingALot) {
        this.parkingALot = parkingALot;
    }

    public void getNotifyForParkingALot(boolean parkingALotIsFull) {
        this.parkingALotIsFull = parkingALotIsFull;
        if (parkingALotIsFull) {
            putSignBoard();
        } else {
            removeSignBoard();
        }
        //can put/remove some kind of notice board
    }

    public boolean isParkingALotIsFull() {
        return parkingALotIsFull;
    }

    public void putSignBoard() {
        parkingALot.setFullSignBoard();
    }

    public void removeSignBoard() {
        parkingALot.removeFullSignBoard();
    }


}
