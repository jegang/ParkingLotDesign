package com.jegan.Parking;

import com.jegan.Payments.Payment;
import com.jegan.models.ParkingTicketStatus;

import java.util.Date;

public class ExitPanel {
    private int panelId;
    private ParkingLot pLot;

    public ExitPanel(int exitPanelId, ParkingLot pLot) {
        this.panelId = exitPanelId;
        this.pLot = pLot;
    }

    public boolean scanTicket(String ticketNumber) {

        ParkingTicket ticket = pLot.getTicket(ticketNumber);

        if(ticket == null) {
            System.out.println("ticket is null");
        }
        System.out.println(ticket.getTicketNumber());

        return true;
    }

    public boolean processPayment(String ticketNumber, Payment payment) {
        ParkingTicket ticket = pLot.getTicket(ticketNumber);

        Date endTime = new Date();
        long secs = (endTime.getTime() - ticket.getIssuedAt().getTime());

        // Rounding up to next whole hour. 1hr 1 min is considered as 2 hour.
        int hr = (int) ((secs / 3600) + ((secs%60 == 0)? 0 : 1));
        double amount = ((double)hr/(double)pLot.getRate().getHourNumber()) * pLot.getRate().getRate();

        payment.setAmount(amount);
        payment.setCreationDate(endTime);
        System.out.println("Processing Payment:: Charging Amount : " + amount);

        payment.initiateTransaction();

        ticket.setPayedAmount(amount);
        ticket.setPayedAt(endTime);
        ticket.setStatus(ParkingTicketStatus.PAID);

        return true;
    }
}
