package hotel.rooms;

import hotel.Booking;
import hotel.enums.RateType;

public abstract class Room {
    private double rate;
    private RateType rateType;
    private int capacity;
    private Booking booking;

    public Room(double rate, RateType rateType, int capacity){
        this.rate = rate;
        this.rateType = rateType;
        this.capacity = capacity;
    }

    public double getRate() {
        return rate;
    }

    public RateType getRateType() {
        return rateType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBooking(Booking booking){
        if(booking == null) return;
        int numGuests = booking.guestCount();
        if(numGuests > capacity) throw new IllegalArgumentException("Number of Guests Cannot Exceed Capacity");
        double totalCharge = booking.getRemainingStay() * rate;
        if(!booking.partyCanAfford(totalCharge)) throw new IllegalArgumentException("Guests cannot afford room");
        this.booking = booking;
    }

    public void removeBooking() throws Exception {
        if(!booking.deletable()) throw new Exception("Cannot double book rooms");
        booking = null;
    }

    public boolean hasBooking(){
        return booking != null;
    }

    public void billStay(){
        if(!hasBooking()) return;
        booking.charge(rate);
        booking.reduceStay(1);
    }





}
