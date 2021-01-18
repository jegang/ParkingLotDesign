package com.jegan.Parking;

import com.jegan.models.ParkingSpotType;

public class ParkingSpot {
    private String number;
    private boolean free;
    private ParkingSpotType ptype;

    public ParkingSpot(String number, boolean free, ParkingSpotType ptype) {
        this.number = number;
        this.free = free;
        this.ptype = ptype;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public ParkingSpotType getPtype() {
        return ptype;
    }

    public void setPtype(ParkingSpotType ptype) {
        this.ptype = ptype;
    }
}
