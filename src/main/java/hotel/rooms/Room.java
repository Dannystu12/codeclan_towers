package hotel.rooms;

import hotel.Guest;
import hotel.enums.RateType;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private List<Guest> guests;
    private double rate;
    private RateType rateType;

    public Room(double rate, RateType rateType){
        guests = new ArrayList<>();
        this.rate = rate;
        this.rateType = rateType;
    }


}
