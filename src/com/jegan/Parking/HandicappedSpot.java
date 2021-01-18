package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class HandicappedSpot extends ParkingSpot {

    public HandicappedSpot(String number, boolean free) {
        super(number, free, ParkingSpotType.HANDICAPPED);
    }

}
