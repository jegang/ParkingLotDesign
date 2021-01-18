package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(String number, boolean free) {
        super(number, free, ParkingSpotType.LARGE);
    }
}
