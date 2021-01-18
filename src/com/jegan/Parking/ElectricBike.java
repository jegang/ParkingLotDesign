package com.jegan.Parking;

import com.jegan.models.VehicleType;

public class ElectricBike extends Vehicle  {

    public ElectricBike(String licenseNumber, VehicleType vehicleType, boolean isDisabledParkingEligible) {
        super(licenseNumber, vehicleType,  isDisabledParkingEligible);
    }
}
