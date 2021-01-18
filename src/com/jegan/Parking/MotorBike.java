package com.jegan.Parking;

import com.jegan.models.VehicleType;

public class MotorBike extends Vehicle  {

    public MotorBike(String licenseNumber, VehicleType vehicleType, boolean isDisabledParkingEligible) {
        super(licenseNumber, vehicleType,  isDisabledParkingEligible);
    }

}
