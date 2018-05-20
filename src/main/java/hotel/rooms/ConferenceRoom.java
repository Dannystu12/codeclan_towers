package hotel.rooms;

import hotel.enums.RateType;

public class ConferenceRoom extends Room{

    private String name;

    public ConferenceRoom(String name, double rate, int capacity){
        super(rate, RateType.DAILY, capacity);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
