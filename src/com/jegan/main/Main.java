package com.jegan.main;

import com.jegan.Payments.Payment;
import com.jegan.Parking.Car;
import com.jegan.Parking.EntrancePanel;
import com.jegan.Parking.ExitPanel;
import com.jegan.Parking.ParkingLot;
import com.jegan.Parking.Vehicle;
import com.jegan.models.Location;
import com.jegan.models.ParkingSpotType;
import com.jegan.models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Parking Lot : Jegan : $5/hr and 3 Floors and 100 spots each
        Location jeganAddr = new Location("1215 Dexter Ave N", "Seattle", "WA", "98109", "USA");
        ParkingLot jegan = new ParkingLot("3915", jeganAddr);

        jegan.setParkingRate(1, 5);
        Map<ParkingSpotType, Integer> numOfSpotsForCategories = new HashMap<>();
        numOfSpotsForCategories.put(ParkingSpotType.HANDICAPPED, 10);
        numOfSpotsForCategories.put(ParkingSpotType.ELECTRIC, 10);
        numOfSpotsForCategories.put(ParkingSpotType.COMPACT, 50);
        numOfSpotsForCategories.put(ParkingSpotType.MOTORBIKE, 10);
        numOfSpotsForCategories.put(ParkingSpotType.LARGE, 20);

        jegan.addParkingFloor(numOfSpotsForCategories);
        jegan.addParkingFloor(numOfSpotsForCategories);
        jegan.addParkingFloor(numOfSpotsForCategories);

        jegan.addEntrancePanel();
        jegan.addExitPanel();


        Vehicle vehicle = new Car("WSDJ876", VehicleType.ELECTRIC, false);

        Map<Integer, EntrancePanel> entryPanel =  jegan.getEntrances();
        entryPanel.get(1).printTicket(vehicle);

        Map<Integer, ExitPanel>exitPanel =  jegan.getExits();
        exitPanel.get(1).scanTicket(vehicle.getParkingTicket().getTicketNumber());

        Payment payment = new Payment();
        exitPanel.get(1).processPayment(vehicle.getParkingTicket().getTicketNumber(), payment);






        // Parking Lot : Adarsh : $10/hr and 2 Floors and 50 Spots each






    }
}
