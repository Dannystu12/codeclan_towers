package hotel;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private List<Guest> guests;
    private int remainingStay;
    private double bill;

    public Booking(int stay, List<Guest> guests){
        if(stay < 1){
            throw new IllegalArgumentException("Stay must be >= 1");
        }

        if(guests.size() < 1){
            throw new IllegalArgumentException("Booking must have at least 1 guest");
        }

        this.guests = new ArrayList<>(guests);
        this.remainingStay = stay;
        this.bill = 0;
    }

    public int getRemainingStay(){
        return this.remainingStay;
    }

    public int guestCount(){
        return guests.size();
    }

    public double getBill(){
        return this.bill;
    }

    public boolean partyCanAfford(double amount){
        if(amount < 0){
            return false;
        }

        Double totalWallet = guests.stream().map(Guest::getWallet)
                .reduce(0.0, (Double res, Double wallet) -> res + wallet);
        return totalWallet >= bill + amount;
    }

    public void settleBill(){
        for(Guest guest : guests){
            double wallet = guest.getWallet();
            if(wallet <= bill){
                guest.reduceFunds(wallet);
                bill -= wallet;
            } else {
                guest.reduceFunds(bill);
                bill -= bill;
            }

            if(bill <= 0){
                return;
            }
        }
    }

    public void reduceStay(int amount){
        if(amount > remainingStay || amount <=0) return;
        remainingStay -= amount;
    }

    public void charge(double amount){
        if(partyCanAfford(amount)) bill += amount;
    }

    public boolean stayComplete(){
        return remainingStay <= 0;
    }

}
