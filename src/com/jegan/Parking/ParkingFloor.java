package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;
import com.jegan.models.VehicleType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    int numOfFreeSpots = 0;

    List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpots = new LinkedList<>();
    }

    boolean addCustomerInfoPortal(){return true;}

    void updateDisplayBoard(ParkingDisplayBoard pdb){}

    void addParkingSpot(ParkingSpot parkingSpot){
        String id = parkingSpot.getNumber();
        parkingSpots.add(parkingSpot);

        numOfFreeSpots += 1;
    }

    ParkingSpot assignVehicleToSpot(Vehicle vehicle){
        if(numOfFreeSpots == 0) {
            System.out.println("Parking Lot FULL");
            return null;
        }

        ParkingSpot nextSpot = getFreeSpot(vehicle.isDisabledParkingEligible(), vehicle.getVehicleType());

        nextSpot.setFree(false);

        numOfFreeSpots -= 1;

        return nextSpot;
    }

    void freeSpot(ParkingSpot spot){
        spot.setFree(true);
        numOfFreeSpots += 1;
    }

    private ParkingSpot getFreeSpot(boolean isDisabledParkingEligible, VehicleType vehicleType) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isFree()) {
                if(spot.getPtype().equals(ParkingSpotType.HANDICAPPED) && isDisabledParkingEligible) {
                    return spot;
                }
                else if(spot.getPtype().equals(ParkingSpotType.ELECTRIC) && vehicleType.equals(VehicleType.ELECTRIC)) {
                    return spot;
                }
                else if(spot.getPtype().equals(ParkingSpotType.MOTORBIKE) && vehicleType.equals(VehicleType.MOTORBIKE)) {
                    return spot;
                }
                else if(spot.getPtype().equals(ParkingSpotType.COMPACT) &&
                        (vehicleType.equals(VehicleType.MOTORBIKE) || vehicleType.equals(VehicleType.CAR))) {
                    return spot;
                }
                else {
                    //spot.getPtype().equals(ParkingSpotType.LARGE))
                    return spot;
                }
            }
        }

        return null;
    }

}
