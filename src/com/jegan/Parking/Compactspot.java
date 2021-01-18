package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class Compactspot extends ParkingSpot {
    public Compactspot(String number, boolean free) {
        super(number, free, ParkingSpotType.COMPACT);
    }
}
