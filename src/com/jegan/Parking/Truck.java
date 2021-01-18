package com.jegan.Parking;

import com.jegan.models.VehicleType;

public class Truck extends Vehicle {

    public Truck(String licenseNumber, VehicleType vehicleType, boolean isDisabledParkingEligible) {
        super(licenseNumber, vehicleType,  isDisabledParkingEligible);
    }
}
