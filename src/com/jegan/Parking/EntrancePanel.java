package com.jegan.Parking;

public class EntrancePanel {
    private int entrPanelId;
    private ParkingLot pLot;

    public EntrancePanel(int entrPanelId, ParkingLot pLot) {
        this.entrPanelId = entrPanelId;
        this.pLot = pLot;
    }

    public boolean printTicket(Vehicle vehicle) {
        ParkingTicket ticket = pLot.getNewParkingTicket(vehicle);
        System.out.println("Printing Ticket : " + ticket.getTicketNumber());
        return true;
    }
}
