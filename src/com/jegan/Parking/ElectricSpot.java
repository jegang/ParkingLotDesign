package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class ElectricSpot extends ParkingSpot {
    public ElectricSpot(String number, boolean free) {
            super(number, free, ParkingSpotType.ELECTRIC);
        }

    void addElectricPanel(){
        ElectricPanel ep = new ElectricPanel();
    }
}
