package org.example.com.bootcamp.ThirdDay.actor;

public class ParkingSecurity {
    private boolean trafficRedirected;

    public boolean isTrafficRedirected() {
        return trafficRedirected;
    }

    public void getNotifyForParkingALotFull(boolean parkingALotIsFull) {
        trafficRedirected = parkingALotIsFull;
    }


}
