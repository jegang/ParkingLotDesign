package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class MotorBikeSpot extends ParkingSpot {
    public MotorBikeSpot(String number, boolean free) {
        super(number, free, ParkingSpotType.MOTORBIKE);
    }
}
