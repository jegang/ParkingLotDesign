package com.jegan.Parking;

import com.jegan.models.VehicleType;

public class Car extends Vehicle {

    public Car(String licenseNumber, VehicleType vehicleType, boolean isDisabledParkingEligible) {
        super(licenseNumber, vehicleType,  isDisabledParkingEligible);
    }
}
