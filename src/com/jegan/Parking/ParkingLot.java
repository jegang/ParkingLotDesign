package com.jegan.Parking;

import com.jegan.models.Location;
import com.jegan.models.ParkingSpotType;
import com.jegan.models.ParkingTicketStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String date;
    private int ticketNumber;
    private String id;
    private Location address;
    private ParkingRate rate;

    // Below should be stored in a DB
    Map<Integer, EntrancePanel> entrances = new HashMap<>();
    Map<Integer, ExitPanel> exits = new HashMap<>();
    Map<Integer, ParkingFloor> floors = new HashMap<>();
    Map<String, ParkingTicket> tickets = new HashMap<>();


    public ParkingLot(String id, Location address) {
        this.id = id;
        this.address = address;

        this.date = "";
        this.ticketNumber = 1;
    }

    public boolean setParkingRate(int hr, double amount ) {
        rate = new ParkingRate(hr, amount);
        return true;
    }

    public boolean addParkingFloor(Map<ParkingSpotType, Integer> numOfSpotsForCategories) {
        ParkingFloor floor = new ParkingFloor(floors.size()+1);

        createParkingSpots(floor, numOfSpotsForCategories);
        floors.put(floors.size()+1, floor);

        System.out.println("Added New Floor to Parking Lot : " + id + ", floor number : " + floors.size());
        return true;
    }

    private boolean createParkingSpots(ParkingFloor floor, Map<ParkingSpotType, Integer> numOfSpotsForCategories) {
        for(Map.Entry<ParkingSpotType, Integer> entry : numOfSpotsForCategories.entrySet()) {

            int spotNumber = 0;
            if(ParkingSpotType.HANDICAPPED.equals(entry.getKey())) {
                for(int i=0; i<entry.getValue(); i++) {
                    ParkingSpot spot = new HandicappedSpot(String.valueOf(spotNumber+=1), true);
                    floor.addParkingSpot(spot);
                }
            }
            else if(ParkingSpotType.ELECTRIC.equals(entry.getKey())){
                for(int i=0; i<entry.getValue(); i++) {
                    ParkingSpot spot = new ElectricSpot(String.valueOf(spotNumber+=1), true);
                    floor.addParkingSpot(spot);
                }

            }
            else if(ParkingSpotType.MOTORBIKE.equals(entry.getKey())){
                for(int i=0; i<entry.getValue(); i++) {
                    ParkingSpot spot = new MotorBikeSpot(String.valueOf(spotNumber+=1), true);
                    floor.addParkingSpot(spot);
                }
            }
            else if(ParkingSpotType.COMPACT.equals(entry.getKey())){
                for(int i=0; i<entry.getValue(); i++) {
                    ParkingSpot spot = new Compactspot(String.valueOf(spotNumber+=1), true);
                    floor.addParkingSpot(spot);
                }
            }
            else if(ParkingSpotType.LARGE.equals(entry.getKey())){
                for(int i=0; i<entry.getValue(); i++) {
                    ParkingSpot spot = new LargeSpot(String.valueOf(spotNumber+=1), true);
                    floor.addParkingSpot(spot);
                }
            }
        }
        return true;
    }

    public boolean addEntrancePanel() {

        EntrancePanel entrance = new EntrancePanel(entrances.size()+1, this);
        entrances.put(entrances.size()+1, entrance);

        System.out.println("Added New Entrance panel to Parking Lot : " + id);
        return true;
    }

    public boolean addExitPanel() {

        ExitPanel exit = new ExitPanel(exits.size()+1, this);
        exits.put(exits.size()+1, exit);

        System.out.println("Added New Exit panel to Parking Lot : " + id);

        return true;
    }


    ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        ParkingTicket pt = new ParkingTicket();
        String ticketNumber = generateNextTicketNumber();
        pt.setTicketNumber(ticketNumber);
        pt.setIssuedAt(new Date());
        pt.setStatus(ParkingTicketStatus.ACTIVE);

        ParkingSpot spot;
        for(ParkingFloor floor : floors.values()) {
            if(floor.numOfFreeSpots > 0) {
                spot = floor.assignVehicleToSpot(vehicle);
                if(spot != null) {
                    pt.setSpot(spot);
                    vehicle.setParkingTicket(pt);
                    break;
                }
            }
        }

        tickets.put(ticketNumber, pt);
        return pt;
    }

    ParkingTicket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }

    private String generateNextTicketNumber() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(new Date());
        if(!date.equals(today)) {
            date = today;
            ticketNumber = 0;
        }

        ticketNumber += 1;

        return date + String.valueOf(ticketNumber);
    }

    boolean isFull() {
        return false;
    }

    public ParkingRate getRate() {
        return rate;
    }

    public Map<Integer, EntrancePanel> getEntrances() {
        return entrances;
    }

    public Map<Integer, ExitPanel> getExits() {
        return exits;
    }
}
