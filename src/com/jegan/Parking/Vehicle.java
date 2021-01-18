package com.jegan.Parking;

import com.jegan.models.VehicleType;

public class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
    private boolean isDisabledParkingEligible;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenseNumber, VehicleType vehicleType, boolean isDisabledParkingEligible) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.isDisabledParkingEligible = isDisabledParkingEligible;
    }

    void assignTicket(ParkingTicket parkingTicket)
    {
        this.parkingTicket = parkingTicket;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isDisabledParkingEligible() {
        return isDisabledParkingEligible;
    }

    public void setDisabledParkingEligible(boolean disabledParkingEligible) {
        isDisabledParkingEligible = disabledParkingEligible;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
