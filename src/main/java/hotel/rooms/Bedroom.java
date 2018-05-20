package hotel.rooms;

import hotel.enums.BedroomType;
import hotel.enums.RateType;

public class Bedroom extends Room{

    private int number;
    private BedroomType bedroomType;

    public Bedroom(int number, BedroomType bedroomType){
        super(bedroomType.getRate(), RateType.NIGHTLY, bedroomType.getCapacity());
        this.number = number;
        this.bedroomType = bedroomType;
    }

    public BedroomType getBedroomType() {
        return bedroomType;
    }

    public int getNumber(){
        return number;
    }
}
